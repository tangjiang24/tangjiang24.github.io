package com.tj24.demo.countdown;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tj24.demo.R;

import androidx.annotation.NonNull;

/**
 * @Description:定时器组件
 * @Createdtime:2019/6/6 16:11
 * @Author:TangJiang
 * @Version: V.1.0.0
 */
public class CountDownView implements View.OnClickListener {

    private ImageView ivAlarm;
    private ImageView ivStart;
    private ImageView ivPause;
    private ImageView ivCancle;
    private TextView tvTimes;

    private CountDown mCountDown;
    private Context mContext;
    private int mState;
    private String mId;
    private int mTotalTime;
    private int mLastTime;
    private LinearLayout mContainer;

    public CountDown getmCountDown() {
        return mCountDown;
    }

    public void init(@NonNull String id,@NonNull int totalTime,@NonNull Context context,@NonNull LinearLayout container){
        mCountDown = CountDownManager.getInstance().creatCountDown(id,totalTime,context,container);
        mState = mCountDown.getState();
        mContext = context;
        mContainer = container;
        mId = id;
        mTotalTime = totalTime;
        mLastTime = mCountDown.getLastTime();

        if(mState == CountDown.TIMER_NOT_TIMING){
            initView(mState,totalTime);
        }else if(mState == CountDown.TIMER_TIMING){
            initView(mState,mCountDown.getLastTime());
        }else if(mState == CountDown.TIMER_PAUSE){
            initView(mState,mCountDown.getLastTime());
        }else if(mState == CountDown.TIMER_FINISH){
            initView(mState,mCountDown.getLastTime());
        }
    }

    private void initView(int state,int currentTime) {
        mContainer.removeAllViews();
        View view = LayoutInflater.from(mCountDown.getmContext()).inflate(R.layout.timer_layout,null);
        mContainer.addView(view);
        tvTimes = view.findViewById(R.id.tv_times);
        ivStart = view.findViewById(R.id.iv_start);
        ivPause = view.findViewById(R.id.iv_pause);
        ivCancle = view.findViewById(R.id.iv_cancle);
        ivAlarm = view.findViewById(R.id.iv_clock);

        ivStart.setOnClickListener(this);
        ivPause.setOnClickListener(this);
        ivCancle.setOnClickListener(this);
        setViews(state,currentTime);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.iv_start) {
            start(mLastTime);
        } else if (i == R.id.iv_pause) {
            if (mState == CountDown.TIMER_PAUSE) {
                restart(mLastTime);
            } else {
                pause(mLastTime);
            }
        } else if (i == R.id.iv_cancle) {
            reSet(mTotalTime);
        }
    }

    /**
     * 重置定时
     * @param times
     */
    public void reSet(int times) {
        CountDownSercice.startService(mContext,mId, 0);
        mState = CountDown.TIMER_NOT_TIMING;
        setViews(mState,times);
    }

    /**
     * 暂停定时
     * @param times
     */
    private void pause(int times) {
        CountDownSercice.startService(mContext,mId, 0);
        mState = CountDown.TIMER_PAUSE;
        setViews(mState,times);
    }

    /**
     * 开始倒计时
     * @param times
     */
    public void start(int times){
        CountDownSercice.startService(mContext,mId, mTotalTime);
        mState = CountDown.TIMER_TIMING;
        setViews(mState,times);
    }

    /**
     * 重新开启定时
     * @param times
     */
    private void restart(int times) {
        CountDownSercice.startService(mContext,mId, mLastTime);
        mState = CountDown.TIMER_TIMING;
        setViews(mState,times);
    }


    /**
     * 设置控件信息
     * @param state
     * @param times
     */
    @SuppressLint("ResourceType")
    public void setViews(int state, int times) {
        mLastTime = times;
        mState = state;
        upDateCountDown();
        tvTimes.setText(TimmerUtil.convertTime(times));
        switch (state){
            case CountDown.TIMER_NOT_TIMING:
                ivAlarm.setVisibility(View.VISIBLE);
                ivStart.setVisibility(View.VISIBLE);
                ivCancle.setVisibility(View.GONE);
                ivPause.setVisibility(View.GONE);
                break;
            case CountDown.TIMER_TIMING:
                ivAlarm.setVisibility(View.GONE);
                ivStart.setVisibility(View.GONE);
                ivCancle.setVisibility(View.VISIBLE);
                ivPause.setVisibility(View.VISIBLE);
                ivPause.setImageResource(R.drawable.pause);
                break;
            case CountDown.TIMER_PAUSE:
                ivAlarm.setVisibility(View.GONE);
                ivStart.setVisibility(View.GONE);
                ivCancle.setVisibility(View.VISIBLE);
                ivPause.setVisibility(View.VISIBLE);
                ivPause.setImageResource(R.drawable.start);
                break;
        }
    }

    private void upDateCountDown(){
        mCountDown.setState(mState);
        mCountDown.setLastTime(mLastTime);
        CountDownManager.getInstance().add(mCountDown);
    }

}
