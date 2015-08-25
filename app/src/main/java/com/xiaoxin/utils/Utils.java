package com.xiaoxin.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;

/**
 * utils
 * Created by zhuangqianliu on 2015/8/25.
 */
public class Utils {
    static private final String  TAG=Logger.makeLogTag(Utils.class);
    /** 返回当前的进程名 */
    public static String getCurrentProcessName() {
        long startT=System.currentTimeMillis();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/proc/self/cmdline");
            byte[] buffer = new byte[32];
            int len = 0;
            int b;
            while ((b = fis.read()) > 0 && len < buffer.length) {
                buffer[len++] = (byte) b;
            }
            if (len > 0) {
                String s = new String(buffer, 0, len, "UTF-8");
                Logger.d(TAG,"getCurProcessNameFile",System.currentTimeMillis()-startT);
                return s;
            }
        } catch (Exception e) {
           Logger.e(TAG,e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                }
            }
            Logger.d(TAG,"getCurProcessNameFileFinally",System.currentTimeMillis()-startT);
        }

        return null;
    }
    /** 返回当前的进程名 */
    public static String getCurProcessName(Context context) {
        long startT=System.currentTimeMillis();
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                Logger.d(TAG,"getCurProcessNameAPI",System.currentTimeMillis()-startT);
                return appProcess.processName;
            }
        }

        return null;
    }
}
