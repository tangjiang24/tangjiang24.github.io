package com.tj24.demo.countdown;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.tj24.demo.timmer.TimmerInfo;

import java.util.HashMap;
import java.util.Map;

public class TimmerUtil {

    /**
     * 全局保存timmer的状态
     */
    public static Map<String,TimmerInfo> timmerInfoMap = new HashMap<>();

    public static String convertTime(int t){
        if(t<60000){
            return (t % 60000 )/1000+"";
        }else if((t>=60000)&&(t<3600000)){
            return getString((t % 3600000)/60000)+":"+getString((t % 60000 )/1000);
        }else {
            return getString(t / 3600000)+":"+getString((t % 3600000)/60000)+":"+getString((t % 60000 )/1000);
        }
    }


    private static String getString(int t){
        String m="";
        if(t>0){
            if(t<10){
                m="0"+t;
            }else{
                m=t+"";
            }
        }else{
            m="00";
        }
        return m;
    }

//    public static List<Timmer> getTimers(ArrayList<UMBaseContentData> mStepsList) {
//        List<Timmer> timers = new ArrayList<>();
//        if(mStepsList!=null && mStepsList.size()>0){
//            for(int i= 0; i<mStepsList.size();i++){
//                int time = filterContent(((CookStepInfo) mStepsList.get(i)).getContent());
//                Timmer timmer = new Timmer();
//                timmer.setId(((CookStepInfo) mStepsList.get(i)).getImageUrl()+"");
//                timmer.setTotalTime(time);
//                timers.add(timmer);
//            }
//        }
//        return timers;
//    }

    private static int filterContent(String content){
        int time = 0;
        if(content.contains("分钟")){
            time = 60*3*1000;
        }
        return time;
    }

    public static synchronized String getPackageName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.packageName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
