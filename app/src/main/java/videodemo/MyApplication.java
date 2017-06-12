package videodemo;

import android.app.Application;
import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by admin on 2017-05-17.
 */

public class MyApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        CrashReport.initCrashReport(getApplicationContext(), "5ade1968fe", false);

        //初始化全局上下文
        mContext = getApplicationContext();


    }
}
