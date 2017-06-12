package videodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import activity.CustomTitleActivity;
import activity.LoopViewpagerActivity;
import activity.MoveImageviewActivity;
import activity.MoveViewActivity;
import activity.PoupwindowActivity;
import activity.PulltorefreshListViewActivity;
import activity.RulerActivity;
import activity.ViewpagerActivity;
import activity.WeigetMoveActivity;

/**
 * Created by admin on 2017-05-22.
 */

public   class CustomViewActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);

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

        findViewById(R.id.Custom_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CustomTitleActivity.class));
            }
        });



        findViewById(R.id.btn__viewpager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ViewpagerActivity.class));
            }
        });

        findViewById(R.id.btn__loopviewpager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoopViewpagerActivity.class));
            }
        });

        findViewById(R.id.btn_pulltorefreshListView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PulltorefreshListViewActivity.class));
            }
        });


        findViewById(R.id.btn_poupwindow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PoupwindowActivity.class));
            }
        });


        findViewById(R.id.btn_ruler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RulerActivity.class));
            }
        });




    }

    }

