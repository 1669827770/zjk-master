package util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import activity.AnimationActivity;
import activity.GoogleMarketActivity;
import activity.StatusbariconActivity;
import activity.TestActivity;
import videodemo.CustomViewActivity;

import static videodemo.MyApplication.mContext;

public class UiUtils {


	private static Toast toast;

	public static void showToast2(Context context,
								  CharSequence content) {
		if (toast == null) {
			toast = Toast.makeText(context,
					content,
					Toast.LENGTH_SHORT);
		} else {
			toast.setText(content);
		}
		toast.show();
	}

	
	/** 在屏幕的中央显示Toast */
//	public static void showToast(Context context, CharSequence text) {
//
//		Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
//		toast.setGravity(Gravity.CENTER, 0, 0);	// 设置Toast显示在屏幕的中央
//		toast.show();
//	}
	
	/** 创建一个随机颜色 */
	public static int createRandomColor() {
		Random random = new Random();
		int red = 50 + random.nextInt(151);		// 50 ~ 200
		int green = 50 + random.nextInt(151);	// 50 ~ 200
		int blue = 50 + random.nextInt(151);	// 50 ~ 200
		int color = Color.rgb(red, green, blue);
		return color;
	}

	/**
	 * 创建一个带随机颜色图形的选择器的TextView
	 * @return
	 */
	public static TextView createRandomColorShapeSelectorTextView(Context context) {
		final TextView textView = new TextView(context);
		textView.setTextColor(Color.WHITE);
		textView.setPadding(6, 6, 6, 6);
		textView.setGravity(Gravity.CENTER);
		textView.setBackgroundDrawable(createRandomColorShapeSelector());
		textView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                String text = (String) textView.getText();

                if(text.equals("自定义控件")){
					Intent intent = new Intent(mContext, CustomViewActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);
                }else if (text.equals("安卓动画")){
					Intent intent = new Intent(mContext, AnimationActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);
                }else if (text.equals("状态栏图标")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("谷歌市场")){
					Intent intent = new Intent(mContext, GoogleMarketActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("无法取消的dialog")){
					Intent intent = new Intent(mContext, TestActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("windowManager")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("首页倒计时")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("载入动画进度条")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("手机视频")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("高度可变的textview")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("recycleview使用")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("高度可变的recycleview")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("图片问题，包括压缩，上传之类")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("Activity进出动画")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("Scroview与Recycleviwew显示不全问题")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("Scroview与Recycleviwew没有惯性问题")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("swiperefreshlayout的简单使用")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("2种观察者模式的使用")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("6.0权限")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("7.0权限")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("EventBus")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("EventBus2")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("MVP")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("RXjava")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("APP顶部的toolbar位置的滑动透明变化")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("沉浸式状态栏")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }else if (text.equals("手机卫士")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);


                }else if (text.equals("新闻客户端")){
					Intent intent = new Intent(mContext, StatusbariconActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);

                }

//				showToast2(v.getContext(), textView.getText());

			}
		});
		return textView;
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
	
	
}

























