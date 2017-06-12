package videodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import activity.WelcomeAnimActivity;

/**
 * Created by admin on 2017-06-11.
 */

public class NewsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news);



        findViewById(R.id.btn_welcomanim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewsActivity.this, WelcomeAnimActivity.class));
            }
        });


        findViewById(R.id.btn_maininterface).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewsActivity.this, MainInterfaceActivity.class));
            }
        });



    }
}
