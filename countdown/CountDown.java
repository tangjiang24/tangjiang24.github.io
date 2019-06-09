package com.tj24.demo.countdown;

import android.content.Context;
import android.widget.LinearLayout;

public class CountDown {
    /**
     * 未开始倒计时
     */
    public static final int TIMER_NOT_TIMING = 0 ;
    /**
     * 倒计时中
     */
    public static final int TIMER_TIMING = 1 ;
    /**
     * 暂停倒计时
     */
    public static final int TIMER_PAUSE = 2 ;
    /**
     * 倒计时 时间到
     */
    public static final int TIMER_FINISH = 3 ;

    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 倒计时包裹容器
     */
    private LinearLayout container;
    /**
     * ID
     */
    private String id;
    /**
     * 剩余的时间
     */
    private int lastTime;
    /**
     * 总时间
     */
    private int totalTime;

    /**
     * timmer的状态
     */

    private int state;

    public CountDown() {
    }

    public CountDown(Context mContext, LinearLayout container, String id, int lastTime, int totalTime, int state) {
        this.mContext = mContext;
        this.container = container;
        this.id = id;
        this.lastTime = lastTime;
        this.totalTime = totalTime;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public LinearLayout getContainer() {
        return container;
    }

    public void setContainer(LinearLayout container) {
        this.container = container;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
