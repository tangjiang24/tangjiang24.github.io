package com.tj24.demo.countdown;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

public class CountDownSercice extends Service {
    private Handler handler = new Handler();

    private static final String TIMER_ID = "id";
    private static final String TIMER_TIME = "time";
    public static final String TIMER_ACTION = "countDown_action";
    /**
     * 管理runnable的 map
     */
    Map<String, Runnable> map = new HashMap<>();

    public CountDownSercice() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initData(intent);
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 获取传递过来的timmer的ID 和需要定时的时间；
     * 若map中包含有此ID 的 任务，需要先将其移除掉，重新加入后启动
     * @param intent
     */
    private void initData(Intent intent) {
        int totalTimes = intent.getIntExtra(TIMER_TIME,0);
        String id = intent.getStringExtra(TIMER_ID);

        if(map.containsKey(id)){
            handler.removeCallbacks(map.get(id));
        }
        map.put(id,new AlarmRunnable(id,totalTimes));
        handler.postDelayed(map.get(id),1000);

    }

    /**
     * 启动service
     * @param mContext
     * @param id
     * @param times
     */
    public static void startService(Context mContext, String id, int times){
        Intent intent = new Intent();
        intent.putExtra(TIMER_ID,id);
        intent.putExtra(TIMER_TIME,times);
        intent.setAction(TIMER_ACTION);
        intent.setPackage(TimmerUtil.getPackageName(mContext));
        mContext.startService(intent);
    }

    /**
     * 更新全局map中的倒计时
     * @param id
     * @param lastTimes
     * @param state
     */
    private CountDown updateCountDown(String id,int lastTimes,int state){
        CountDown countDown = CountDownManager.getInstance().creatCountDown(id);
        countDown.setLastTime(lastTimes);
        countDown.setState(state);
        CountDownManager.getInstance().add(countDown);
        return countDown;
    }

    class AlarmRunnable implements Runnable{
        private String id;
        private int totalTimes;
        private CountDown countDown;
        public AlarmRunnable(String id,int totalTimes) {
            this.id = id;
            this.totalTimes = totalTimes;
        }

        @Override
        public void run() {
            if(totalTimes>=0){
                totalTimes -= 1000;
                if(totalTimes>0){ //正在倒计时
                    countDown = updateCountDown(id,totalTimes,CountDown.TIMER_TIMING);
                }else if(totalTimes ==0){ //刚好倒计时完成
                    countDown = updateCountDown(id,totalTimes,CountDown.TIMER_FINISH);
                    CountDownManager.getInstance().remove(id);

                    Log.e("alarm","service已经完成了定时");
                }else {
                    return;
                }
                handler.postDelayed(this,1000);
                EventBus.getDefault().post(countDown);
            }
        }
    }
}
