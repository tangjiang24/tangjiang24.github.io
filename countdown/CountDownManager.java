package com.tj24.demo.countdown;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;

public class CountDownManager {

    public static volatile CountDownManager instance;

    public static CountDownManager getInstance(){
        if(instance==null){
            synchronized (CountDownManager.class){
                if(instance == null){
                    instance = new CountDownManager();
                }
            }
        }
        return instance;
    }

    /**
     * 全局管理 map
     */
    public static Map<String,CountDown> countDownMap = new HashMap<>();

    /**
     * 添加倒计时
     * @param countDown
     */
    public void add(CountDown countDown){
        if(TextUtils.isEmpty(countDown.getId())){
            throw new IllegalArgumentException("contDown id cannot be null");
        }
        countDownMap.put(countDown.getId(),countDown);
    }

    /**
     * 根据ID移除
     * @param id
     */
    public void remove(String id){
        if(countDownMap.containsKey(id)){
            countDownMap.remove(id);
        }
    }

    /**
     * 清空
     */
    public void clear(){
       countDownMap.clear();
    }


    /**
     * 创建倒计时 查询map中是否有 即保持单例
     * @param id
     * @return
     */
    public CountDown creatCountDown(String id){
        CountDown countDown;
        if(countDownMap.containsKey(id)){
            countDown = countDownMap.get(id);
        }else {
            countDown = new CountDown();
            countDown.setId(id);
            add(countDown);
        }
        return countDown;
    }

    /**
     * 创建倒计时 查询map中是否有 即保持单例
     * @param id
     * @return
     */
    public CountDown creatCountDown(String id, int totalTime,Context context, LinearLayout container){
        CountDown countDown;
        if(countDownMap.containsKey(id)){
            countDown = countDownMap.get(id);
        }else {
            countDown = new CountDown();
            countDown.setId(id);
            add(countDown);
        }
        countDown.setContainer(container);
        countDown.setTotalTime(totalTime);
        countDown.setmContext(context);
        return countDown;
    }

    /**
     * 创建倒计时 查询map中是否有 即保持单例
     * @return
     */
    public CountDown creatCountDown(CountDown countDown){
        CountDown mCountDown;
        if(countDownMap.containsKey(countDown.getId())){
            mCountDown = countDownMap.get(countDown.getId());
        }else {
            mCountDown = countDown;
            add(countDown);
        }
        return countDown;
    }
}
