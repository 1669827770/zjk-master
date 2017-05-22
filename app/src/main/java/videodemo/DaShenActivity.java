package videodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import activity.TransparencyToolbarActivity;

import activity.LoopViewpagerActivity;
import activity.PoupwindowActivity;
import activity.PulltorefreshListViewActivity;
import activity.SViewOrRviewBattleActivity;
import activity.eventbus.EventBusActivity;
import activity.eventbus.eventBus2.tryeventbus2.FirstActivity;
import activity.video.ChoosePhotosActivity;
import activity.video.DownParallaxActivity;
import dialog.AddrDialog2;
import activity.GlideActivity;
import activity.MoveImageviewActivity;
import activity.MoveViewActivity;
import activity.RecycleViewActivity;
import activity.RulerActivity;

import activity.ViewpagerActivity;
import activity.WeigetMoveActivity;
import activity.WelcomeActivity;


/**
 * Created by admin on 2017-04-21.
 */

public class DaShenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashen);



/**
 *自定义控件
 */
        findViewById(R.id.custom_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(), CustomViewActivity.class));
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

/**
 * 视频主界面
 */
        findViewById(R.id.btn_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, ChoosePhotosActivity.class));
            }
        });

/**
 *首页倒计时
 */
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



        findViewById(R.id.btn_Recycleview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, RecycleViewActivity.class));
            }
        });

        findViewById(R.id.btn_pulltorefreshListView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, PulltorefreshListViewActivity.class));
            }
        });


        findViewById(R.id.btn_poupwindow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, PoupwindowActivity.class));
            }
        });




        findViewById(R.id.btn__viewpager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, ViewpagerActivity.class));
            }
        });

        findViewById(R.id.btn__loopviewpager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, LoopViewpagerActivity.class));
            }
        });





        findViewById(R.id.btn_glide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, GlideActivity.class));
            }
        });


        findViewById(R.id.btn_sr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, SViewOrRviewBattleActivity.class));
            }
        });

        findViewById(R.id.btn_sr2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, GlideActivity.class));
            }
        });

        findViewById(R.id.btn_swipRe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, GlideActivity.class));
            }
        });


        findViewById(R.id.btn_pull_down_parallax).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this,DownParallaxActivity.class));
            }
        });


        findViewById(R.id.btn_eventbus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this,EventBusActivity.class));
            }
        });

        findViewById(R.id.btn_eventbus2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this,FirstActivity.class));
            }
        });


        findViewById(R.id.btn_rxjava).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this,EventBusActivity.class));
            }
        });


        findViewById(R.id.btn_rxjava).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this,EventBusActivity.class));
            }
        });


        findViewById(R.id.btn_transparency_toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, TransparencyToolbarActivity.class));
            }
        });
        findViewById(R.id.btn_Immersive_statusbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this, TransparencyToolbarActivity.class));
            }
        });

        findViewById(R.id.btn_moblesalf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaShenActivity.this,EventBusActivity.class));
            }
        });


















    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // 获取当前进程的id
        int pid = android.os.Process.myPid();
        // 这个方法只能用于自杀操作
        android.os.Process.killProcess(pid);
    }
}
