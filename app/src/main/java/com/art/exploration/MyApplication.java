package com.art.exploration;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;

import java.util.List;

/**
 * Created by machangbao on 2018/4/11.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String processName = getProccessNameByPID(getApplicationContext(), Process.myPid());
        System.out.println("MyApplication processName = " + processName);
    }

    /**
     * 获取进程ID
     *
     * @return
     */
    public static int getProcessPID() {
        return android.os.Process.myPid();
    }

    /**
     * 通过进程id 获取进程名字
     *
     * @param context
     * @param pid
     * @return
     */
    @TargetApi(Build.VERSION_CODES.N)
    public static String getProccessNameByPID(Context context, int pid) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }
}
