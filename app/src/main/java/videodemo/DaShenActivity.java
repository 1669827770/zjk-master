package videodemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import activity.AnimationActivity;
import activity.GlideActivity;
import activity.GoogleMarketActivity;
import activity.MobleSalfActivity;
import activity.RecycleViewActivity;
import activity.SViewOrRviewBattleActivity;
import activity.StatusbariconActivity;
import activity.TransparencyToolbarActivity;
import activity.WelcomeActivity;
import activity.eventbus.EventBusActivity;
import activity.eventbus.eventBus2.tryeventbus2.FirstActivity;
import activity.video.ChoosePhotosActivity;
import activity.video.DownParallaxActivity;
import dialog.AddrDialog2;
import dialog.NoCancleDialog;
import view.AddrToast;
import view.FlowLayout;

import static videodemo.MyApplication.mContext;


/**
 * Created by admin on 2017-04-21.
 */

public class DaShenActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);	// 创建ScrollView
        FlowLayout flowLayout = new FlowLayout(this);	// 创建FlowLayout
        flowLayout.setPadding(6, 6, 6, 6);
        for (String str : list) {
            TextView textView =createRandomColorShapeSelectorTextView(this);
            textView.setText(str);
            flowLayout.addView(textView);
        }

        scrollView.addView(flowLayout);
        setContentView(scrollView);	// 把ScrollView作为根容器显示到界面上

//      setContentView(R.layout.activity_dashen);




/**
 *自定义控件
 */
//        findViewById(R.id.custom_view).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                startActivity(new Intent(getApplicationContext(), CustomViewActivity.class));
//            }
//        });
//
//
//        findViewById(R.id.btn_animation).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                startActivity(new Intent(getApplicationContext(), AnimationActivity.class));
//            }
//        });
//
//
//        findViewById(R.id.btn_status_bar_icon).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), StatusbariconActivity.class));
//            }
//        });
//
//
//        findViewById(R.id.btn_googlemarket).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), GoogleMarketActivity.class));
//            }
//        });
//
//
//
//        findViewById(R.id.no_cancle_windowManager).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), TestActivity.class));
//            }
//        });
//
//
//
///**
// * 无法取消的dialog
// */
//        findViewById(R.id.no_cancle_dialog).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //这里要是传getApplication,getApplicationContext都不能显示dialog
//                NoCancleDialog nocancleDialog = new NoCancleDialog(DaShenActivity.this,R.style.filletDialog);
//                nocancleDialog.setCancelable(false);
//                nocancleDialog.show();
////                nocancleDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG);
//
//
//
//                 BroadcastReceiver mHomeKeyEventReceiver = new BroadcastReceiver() {
//                    String SYSTEM_REASON = "reason";
//                    String SYSTEM_HOME_KEY = "homekey";
//                    String SYSTEM_HOME_KEY_LONG = "recentapps";
//
//                    @Override
//                    public void onReceive(Context context, Intent intent) {
//                        String action = intent.getAction();
//                        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) { // 监听home键
//                            String reason = intent.getStringExtra(SYSTEM_REASON);
//
//                            // 表示按了home键,程序到了后台
//                            Log.e("777777777777", "66666666666666");
//
//                            WindowManager wManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
//                            wManager.getDefaultDisplay();
//
//                        }
//                    }
//                };
//                registerReceiver(mHomeKeyEventReceiver, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
//            }
//        });
//
///**
// * 圆角Dialog,背景是圆角的shape,并从下到上弹出，从上到下消失
// */
//        findViewById(R.id.rounded_rectangle_dialog).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //这里要是传getApplication,getApplicationContext都不能显示dialog
//                AddrDialog2 addrDialog2 = new AddrDialog2(DaShenActivity.this);
//                addrDialog2.show();
//            }
//        });
///**
// * 圆角Dialog,背景是圆角的shape,从中间弹出，比上面那个仅仅是重写她的style而已
// */
//        findViewById(R.id.middle_rounded_rectangle_dialog).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //这里要是传getApplication,getApplicationContext都不能显示dialog
//                AddrDialog2 addrDialog2 = new AddrDialog2(DaShenActivity.this,R.style.filletDialog);
//                addrDialog2.show();
//            }
//        });
//
///**
// * 视频主界面
// */
//        findViewById(R.id.btn_video).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, ChoosePhotosActivity.class));
//            }
//        });
///**
// *首页倒计时
// */
//        findViewById(R.id.btn_count_down).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, WelcomeActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_anim_compress).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        findViewById(R.id.btn_Recycleview).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, RecycleViewActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_glide).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, GlideActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_sr).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, SViewOrRviewBattleActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_sr2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, GlideActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_swipRe).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, GlideActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_pull_down_parallax).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this,DownParallaxActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_eventbus).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this,EventBusActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_eventbus2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this,FirstActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_rxjava).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this,EventBusActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_rxjava).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this,EventBusActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_transparency_toolbar).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, TransparencyToolbarActivity.class));
//            }
//        });
//        findViewById(R.id.btn_Immersive_statusbar).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, TransparencyToolbarActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_moblesalf).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, MobleSalfActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_news).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaShenActivity.this, NewsActivity.class));
//
//            }
//        });

    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // 获取当前进程的id
        int pid = android.os.Process.myPid();
        // 这个方法只能用于自杀操作
        android.os.Process.killProcess(pid);
    }

    /**
     * 创建一个带随机颜色图形的选择器的TextView
     * @return
     */
    public  TextView createRandomColorShapeSelectorTextView(Context context) {
        final TextView textView = new TextView(context);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(6, 6, 6, 6);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundDrawable(createRandomColorShapeSelector());
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = (String) textView.getText();

                if(text.equals("自定义控件")){
                    startActivity(new Intent(getApplicationContext(), CustomViewActivity.class));
                }else if (text.equals("安卓动画")){
                    startActivity(new Intent(getApplicationContext(), AnimationActivity.class));
                }else if (text.equals("状态栏图标")){
                    startActivity(new Intent(getApplicationContext(), StatusbariconActivity.class));

                }else if (text.equals("谷歌市场")){
                    startActivity(new Intent(getApplicationContext(), GoogleMarketActivity.class));

                }else if (text.equals("无法取消的dialog")){
                    //                //这里要是传getApplication,getApplicationContext都不能显示dialog
               NoCancleDialog nocancleDialog = new NoCancleDialog(DaShenActivity.this,R.style.filletDialog);
                nocancleDialog.setCancelable(false);
                nocancleDialog.show();
//              startActivity(new Intent(getApplicationContext(), TestActivity.class));

                }else if (text.equals("windowManager")){
                    //这里要是传getApplication,getApplicationContext都不能显示dialog
                    AddrToast  at = new AddrToast(getApplicationContext());
                    at.show();
                    finish();
//                    Toast.makeText(getApplication(), "4444444444444444444", Toast.LENGTH_SHORT).show();
                }else if (text.equals("圆角矩形的dialog")){

                    //这里要是传getApplication,getApplicationContext都不能显示dialog
                AddrDialog2 addrDialog2 = new AddrDialog2(DaShenActivity.this);
                addrDialog2.show();

                }else if (text.equals("中间的圆角矩形的dialog")){
                    //                //这里要是传getApplication,getApplicationContext都不能显示dialog
                AddrDialog2 addrDialog2 = new AddrDialog2(DaShenActivity.this,R.style.filletDialog);
                addrDialog2.show();

                }else if (text.equals("首页倒计时")){
                    startActivity(new Intent(DaShenActivity.this, WelcomeActivity.class));

                }else if (text.equals("载入动画进度条")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("手机视频")){
                    startActivity(new Intent(DaShenActivity.this, ChoosePhotosActivity.class));

                }else if (text.equals("高度可变的textview")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("recycleview使用")){
                    startActivity(new Intent(DaShenActivity.this, RecycleViewActivity.class));

                }else if (text.equals("高度可变的recycleview")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("图片问题，包括压缩，上传之类")){
                    startActivity(new Intent(DaShenActivity.this, GlideActivity.class));

                }else if (text.equals("Activity进出动画")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("Scroview与Recycleviwew显示不全问题")){
                    startActivity(new Intent(DaShenActivity.this,SViewOrRviewBattleActivity.class));
                }else if (text.equals("Scroview与Recycleviwew没有惯性问题")){
                    startActivity(new Intent(DaShenActivity.this, SViewOrRviewBattleActivity.class));

                }else if (text.equals("swiperefreshlayout的简单使用")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("2种观察者模式的使用")){
                    startActivity(new Intent(DaShenActivity.this,DownParallaxActivity.class));
                }else if (text.equals("下拉视差动画")){
                    startActivity(new Intent(DaShenActivity.this,DownParallaxActivity.class));

                }else if (text.equals("6.0权限")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("7.0权限")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("EventBus")){
                    startActivity(new Intent(DaShenActivity.this,EventBusActivity.class));

                }else if (text.equals("EventBus2")){
                    startActivity(new Intent(DaShenActivity.this,FirstActivity.class));

                }else if (text.equals("MVP")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("RXjava")){
                    Intent intent = new Intent(mContext, StatusbariconActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }else if (text.equals("APP顶部的toolbar位置的滑动透明变化")){
                    startActivity(new Intent(DaShenActivity.this, TransparencyToolbarActivity.class));

                }else if (text.equals("沉浸式状态栏")){
                    startActivity(new Intent(DaShenActivity.this, TransparencyToolbarActivity.class));

                }else if (text.equals("手机卫士")){
                    startActivity(new Intent(DaShenActivity.this, MobleSalfActivity.class));

                }else if (text.equals("新闻客户端")){
                    startActivity(new Intent(DaShenActivity.this, NewsActivity.class));

                }


            }
        });
        return textView;
    }





    public static ArrayList<String> list = new ArrayList<String>();
    static {
        list.add("自定义控件");
        list.add("安卓动画");
        list.add("状态栏图标");
        list.add("谷歌市场");
        list.add("无法取消的dialog");
        list.add("windowManager");
        list.add("圆角矩形的dialog");
        list.add("中间的圆角矩形的dialog");
        list.add("首页倒计时");
        list.add("载入动画进度条");
        list.add("手机视频");
        list.add("高度可变的textview");
        list.add("recycleview使用");
        list.add("高度可变的recycleview");
        list.add("图片问题，包括压缩，上传之类");
        list.add("Activity进出动画");
        list.add("Scroview与Recycleviwew显示不全问题");
        list.add("Scroview与Recycleviwew没有惯性问题");
        list.add("swiperefreshlayout的简单使用");
        list.add("2种观察者模式的使用");
        list.add("下拉视差动画");
        list.add("6.0权限");
        list.add("7.0权限");
        list.add("EventBus");
        list.add("EventBus2");
        list.add("MVP");
        list.add("RXjava");
        list.add("APP顶部的toolbar位置的滑动透明变化");
        list.add("沉浸式状态栏");
        list.add("手机卫士");
        list.add("新闻客户端");
    }

    /**
     * 创建一个带随机颜色图形的选择器的
     * @return
     */
    public static Drawable createRandomColorShapeSelector() {
        StateListDrawable stateListDrawable = new StateListDrawable();	// 创建一个选择器对象
        // 创建一个按下状态和按下状态对应的图片
        int[] pressState = {android.R.attr.state_pressed, android.R.attr.state_enabled};
        Drawable pressDrawable = createRandomColorShape();

        // 创建一个正常状态和正常状态对应的图片
        int[] normalState = {};
        Drawable normalDrawable = createRandomColorShape();

        stateListDrawable.addState(pressState, pressDrawable);	// 按下状态显示按下的Drawable
        stateListDrawable.addState(normalState, normalDrawable);// 正常状态显示正常的Drawable
        return stateListDrawable;
    }


    /**
     * 创建一个带随机颜色的图形
     * @return
     */
    public static Drawable createRandomColorShape() {
        GradientDrawable gradientDrawable = new GradientDrawable();	// 创建一个图形Drawable
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);		// 设置图形为矩形
        gradientDrawable.setCornerRadius(6);	// 设置矩形的圆角
        gradientDrawable.setColor(createRandomColor());	// 设置矩形的颜色
        return gradientDrawable;
    }


    /** 创建一个随机颜色 */
    public static int createRandomColor() {
        Random random = new Random();
        int red = 50 + random.nextInt(151);		// 50 ~ 200
        int green = 50 + random.nextInt(151);	// 50 ~ 200
        int blue = 50 + random.nextInt(151);	// 50 ~ 200
        int color = Color.rgb(red, green, blue);
        return color;
    }



}
