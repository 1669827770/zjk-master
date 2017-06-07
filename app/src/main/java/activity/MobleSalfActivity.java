package activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import videodemo.R;

/**
 * Created by admin on 2017-06-05.
 */

public class MobleSalfActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_moblesalf);

        findViewById(R.id.btn_horse_race_lamp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FocussActivity.class));
            }
        });
    }
}
