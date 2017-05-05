package videodemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dialog.AddrDialog2;
import move.MoveImageviewActivity;
import move.MoveViewActivity;
import move.RulerActivity;
import move.WeigetMoveActivity;
import move.WelcomeActivity;


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

/**
 * 圆角Dialog,背景是圆角的shape,并从下到上弹出，从上到下消失
 */
        findViewById(R.id.rounded_rectangle_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里要是传getApplication,getApplicationContext都不能显示dialog
                AddrDialog2 addrDialog2 = new AddrDialog2(DaShenActivity.this);
                addrDialog2.show();
            }
        });
/**
 * 圆角Dialog,背景是圆角的shape,从中间弹出，比上面那个仅仅是重写她的style而已
 */
        findViewById(R.id.middle_rounded_rectangle_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里要是传getApplication,getApplicationContext都不能显示dialog
                AddrDialog2 addrDialog2 = new AddrDialog2(DaShenActivity.this,R.style.filletDialog);


                addrDialog2.show();
            }
        });


        findViewById(R.id.btn_count_down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, WelcomeActivity.class));
            }
        });

        findViewById(R.id.btn_anim_compress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        findViewById(R.id.btn_ruler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, RulerActivity.class));
            }
        });
















    }
}
