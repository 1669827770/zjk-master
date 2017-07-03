package util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
	public static void show(String text, Context context) {
		Toast.makeText(context, text, 0).show();
	}

	public static void showLong(String text, Context context) {
		Toast.makeText(context, text, 1).show();
	}
}
