package videodemo;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by admin on 2017-05-17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CrashReport.initCrashReport(getApplicationContext(), "5ade1968fe", false);

    }
}
