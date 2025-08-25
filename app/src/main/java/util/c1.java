package util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.IOException;
import ui.Hicore;

/* compiled from: DisplayUtil.java */
/* loaded from: classes2.dex */
public class c1 {

    /* renamed from: a, reason: collision with root package name */
    private static int f20776a;

    public static RectF a(int i2, int i3, int i4, int i5) {
        Point pointB = b(i2, i3, i4, i5);
        return new RectF(pointB.x, pointB.y, i4 + r2, i5 + r1);
    }

    public static Point b(int i2, int i3, int i4, int i5) {
        return new Point((i2 / 2) - (i4 / 2), (i3 - i5) / 4);
    }

    public static float c(Context context) {
        return a(context).widthPixels;
    }

    public static int d(Context context) {
        int i2 = f20776a;
        if (i2 > 0) {
            return i2;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            f20776a = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            return f20776a;
        } catch (Throwable th) {
            th.printStackTrace();
            return f20776a;
        }
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static Point b(float f2, float f3, int i2, int i3) {
        if (f2 > f3) {
            i2 = (int) (i3 / f2);
        } else {
            i3 = (int) (i2 * f2);
        }
        return new Point(i2, i3);
    }

    public static Point a(float f2, float f3, int i2, int i3) {
        int i4;
        int i5;
        if (f2 > f3) {
            i4 = (int) (i3 / 1.5f);
            i5 = (int) (i4 / f2);
        } else {
            int i6 = (int) (i2 / 1.5f);
            i4 = (int) (i6 * f2);
            i5 = i6;
        }
        return new Point(i5, i4);
    }

    public static float b(Context context) {
        return a(context).heightPixels;
    }

    public static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static float b(Context context, float f2) {
        return (f2 / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(int i2) {
        return Hicore.getApp().getResources().getDimensionPixelSize(i2);
    }

    public static int a(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
