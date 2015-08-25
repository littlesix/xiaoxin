package com.xiaoxin.system;

import android.app.Application;

import com.xiaoxin.BuildConfig;
import com.xiaoxin.utils.Logger;
import com.xiaoxin.utils.Utils;

/**
 * application
 * Created by zhuangqianliu on 2015/8/25.
 */
public class App extends Application{
    private static final String TAG= Logger.makeLogTag(App.class);
    private static App app=null;
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println(BuildConfig.DEBUG);
        String processName=Utils.getCurrentProcessName();
        processName=Utils.getCurProcessName(this);
        Logger.d(TAG, "App onCreate ...", processName);
        app=this;
        initWithProcessName(processName);
    }

    /**
     * 获取app对象
     * @return app
     */
    public static App getApp(){
        return app;
    }

    /** 根据进程名初始化*/
    private void initWithProcessName(String pName){
        if(getPackageName().equals(pName)){
            //主进程
            Logger.d(TAG,"主进程初始化");

        }else if(pName.endsWith(":ok")){
            //
            Logger.d(TAG,"ok程初始化");
        }
    }





}
