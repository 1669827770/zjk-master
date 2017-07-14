package videodemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import ui.activity.ContactsActivity;
import ui.activity.CustomCombinationsActivity;
import ui.activity.CustomCombinationsPRogressbarActivity;
import ui.activity.CustomTitleActivity;
import ui.activity.FullHeightChangeSevenLinesActivity;
import ui.activity.FullHeightChangeZeroLinesActivity;
import ui.activity.LoopViewpagerActivity;
import ui.activity.MoveImageviewActivity;
import ui.activity.MoveViewActivity;
import ui.activity.OneViewActivity;
import ui.activity.PieChartActivity;
import ui.activity.PoupwindowActivity;
import ui.activity.PulltorefreshListViewActivity;
import ui.activity.RulerActivity;
import ui.activity.ViewpagerActivity;
import ui.activity.WaveByBezierActivity;
import ui.activity.WeigetMoveActivity;
import view.FlowLayout;

/**
 * Created by admin on 2017-05-22.
 */

public   class CustomViewActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
//       setContentView(R.layout.activity_customview);


//        /**
//         *移动的图片
//         */
//        findViewById(R.id.move_imageview).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                startActivity(new Intent(getApplicationContext(), MoveImageviewActivity.class));
//            }
//        });
//
///**
// * 移动的小球
// */
//        findViewById(R.id.move_view).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), MoveViewActivity.class));
//            }
//        });
//
//        /**
//         * 控件移动
//         */
//        findViewById(R.id.weiget_move).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), WeigetMoveActivity.class));
//            }
//        });
//
//        findViewById(R.id.Custom_title).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), CustomTitleActivity.class));
//            }
//        });
//
//
//
//        findViewById(R.id.btn__viewpager).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), ViewpagerActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn__loopviewpager).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), LoopViewpagerActivity.class));
//            }
//        });
//
//        findViewById(R.id.btn_pulltorefreshListView).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), PulltorefreshListViewActivity.class));
//            }
//        });
//
//
//        findViewById(R.id.btn_poupwindow).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), PoupwindowActivity.class));
//            }
//        });
//
//
//        findViewById(R.id.btn_ruler).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), RulerActivity.class));
//            }
//        });

    }


    /**
     * 创建一个带随机颜色图形的选择器的TextView
     * @return
     */
    public TextView createRandomColorShapeSelectorTextView(Context context) {
        final TextView textView = new TextView(context);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(6, 6, 6, 6);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundDrawable(createRandomColorShapeSelector());
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = (String) textView.getText();

                if(text.equals("可移动的图片")){
                    startActivity(new Intent(getApplicationContext(), MoveImageviewActivity.class));
                }else if (text.equals("可移动的View")){
                    startActivity(new Intent(getApplicationContext(), MoveViewActivity.class));
                }else if (text.equals("安卓控件移动")){
                    startActivity(new Intent(getApplicationContext(), WeigetMoveActivity.class));
                }else if (text.equals("另一个View,智慧，城市")){
                    startActivity(new Intent(getApplicationContext(), CustomTitleActivity.class));
                }else if (text.equals("特效的viewpager")){
                    startActivity(new Intent(getApplicationContext(), ViewpagerActivity.class));
                }else if (text.equals("无限循环viewpager")){
                    startActivity(new Intent(getApplicationContext(), LoopViewpagerActivity.class));
                }else if (text.equals("pulltorefreshListView")){
                    startActivity(new Intent(getApplicationContext(), PulltorefreshListViewActivity.class));
                }else if (text.equals("poupwindow")){
                    startActivity(new Intent(getApplicationContext(), PoupwindowActivity.class));
                }else if (text.equals("尺子")){
                    startActivity(new Intent(getApplicationContext(), RulerActivity.class));
                }else if (text.equals("一个View,智慧，城市")){
                    startActivity(new Intent(getApplicationContext(), OneViewActivity.class));
                }else if (text.equals("联系人快速索引条")){
                    startActivity(new Intent(getApplicationContext(), ContactsActivity.class));
                }else if (text.equals("饼状图")){
                    startActivity(new Intent(getApplicationContext(), PieChartActivity.class));
                }else if (text.equals("自定义开关togglebutton")){
                    startActivity(new Intent(getApplicationContext(), ToggleButtonViewActivity.class));
                }else if (text.equals("自定义组合控件")){
                    startActivity(new Intent(getApplicationContext(), CustomCombinationsActivity.class));
                }else if (text.equals("自定义组合进度条")){
                    startActivity(new Intent(getApplicationContext(), CustomCombinationsPRogressbarActivity.class));
                }else if (text.equals("某控件中心画个圆")){
                    startActivity(new Intent(getApplicationContext(), CencleCircleActivity.class));
                }else if (text.equals("DrawTextTestView")){
                    startActivity(new Intent(getApplicationContext(), DrawTextActivity.class));
                }else if (text.equals("画布类操作，圆，矩形，弧等等")){
                    startActivity(new Intent(getApplicationContext(), CanvasActivity.class));
                }else if (text.equals("贝塞尔曲线")){
                    startActivity(new Intent(getApplicationContext(), BesselPlotActivity.class));
                }else if (text.equals("PieChartDemo")){
                    startActivity(new Intent(getApplicationContext(), PieChartDemoActivity.class));
                }else if (text.equals("Textview完整高变0")){
                    startActivity(new Intent(getApplicationContext(), FullHeightChangeZeroLinesActivity.class));
                }else if (text.equals("Textview完整高变7")){
                    startActivity(new Intent(getApplicationContext(), FullHeightChangeSevenLinesActivity.class));
                }else if (text.equals("贝塞尔曲线实现水波纹效果")){
                    startActivity(new Intent(getApplicationContext(), WaveByBezierActivity.class));
                }


            }
        });
        return textView;
    }


    public static ArrayList<String> list = new ArrayList<String>();
    static {
        list.add("可移动的图片");
        list.add("可移动的View");
        list.add("安卓控件移动");
        list.add("另一个View,智慧，城市");
        list.add("特效的viewpager");
        list.add("无限循环viewpager");
        list.add("pulltorefreshListView");
        list.add("poupwindow");
        list.add("尺子");
        list.add("一个View,智慧，城市");
        list.add("联系人快速索引条");
        list.add("饼状图");
        list.add("自定义开关togglebutton");
        list.add("自定义组合控件");
        list.add("自定义组合进度条");
        list.add("某控件中心画个圆");
        list.add("DrawTextTestView");
        list.add("画布类操作，圆，矩形，弧等等");
        list.add("贝塞尔曲线");
        list.add("PieChartDemo");
        list.add("Textview完整高变0");
        list.add("Textview完整高变7");
        list.add("贝塞尔曲线实现水波纹效果");

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

