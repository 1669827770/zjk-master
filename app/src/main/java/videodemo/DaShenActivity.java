package videodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import move.MoveImageviewActivity;
import move.MoveViewActivity;
import move.WeigetMoveActivity;


/**
 * Created by admin on 2017-04-21.
 */

public class DaShenActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashen);
/**
 *移动的图片
 */
        findViewById(R.id.move_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 startActivity(new Intent(getApplicationContext(), MoveImageviewActivity.class));
            }
        });

/**
 * 移动的小球
 */
        findViewById(R.id.move_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MoveViewActivity.class));
            }
        });

        /**
         * 控件移动
         */
        findViewById(R.id.weiget_move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WeigetMoveActivity.class));
            }
        });


    }
}
