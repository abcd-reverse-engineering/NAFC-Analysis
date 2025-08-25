package cn.cloudwalk.libproject.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class ImageViewUtil {
    public static void matchAll(Context context, ImageView imageView) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        Drawable drawable = imageView.getDrawable();
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float f5 = intrinsicWidth / intrinsicHeight;
        if (f4 > f5) {
            i2 = (int) (intrinsicWidth * (intrinsicHeight / f3));
        } else if (f4 < f5) {
            i3 = (int) (intrinsicHeight / (intrinsicWidth / f2));
        }
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(i2, i3));
    }
}
