package util;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.tools.DoubleUtils;
import ui.Hicore;

/* compiled from: ToastUtil.java */
/* loaded from: classes2.dex */
public class w1 {

    /* renamed from: a, reason: collision with root package name */
    private static Toast f21018a;

    public static void a(String str) {
        if (TextUtils.isEmpty(str) || Hicore.getApp() == null || DoubleUtils.isFastDoubleClick()) {
            return;
        }
        f21018a = Toast.makeText(Hicore.getApp(), str, 0);
        f21018a.setGravity(17, 0, 0);
        f21018a.show();
    }

    public static void b(int i2) {
        if (Hicore.getApp() == null) {
            return;
        }
        f21018a = Toast.makeText(Hicore.getApp(), a(i2), 0);
        f21018a.setGravity(17, 0, 0);
        f21018a.show();
    }

    public static void c(String str) {
        if (Hicore.getApp() == null) {
            return;
        }
        f21018a = Toast.makeText(Hicore.getApp(), str, 0);
        f21018a.setGravity(17, 0, 0);
        f21018a.show();
    }

    public static void d(int i2) {
        Toast toast = f21018a;
        if (toast == null) {
            f21018a = Toast.makeText(Hicore.getApp(), a(i2), 0);
            f21018a.setGravity(17, 0, 0);
            f21018a.show();
        } else {
            toast.setGravity(17, 0, 0);
            f21018a.setDuration(0);
            f21018a.setText(a(i2));
            f21018a.show();
        }
    }

    public static void e(String str) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(str)) {
            str = Hicore.getApp().getResources().getString(R.string.err_timeout);
        }
        a(str);
    }

    public static void f(String str) {
        Toast toast = f21018a;
        if (toast == null) {
            f21018a = Toast.makeText(Hicore.getApp(), str, 0);
            f21018a.setGravity(17, 0, 0);
            f21018a.show();
        } else {
            toast.setGravity(17, 0, 0);
            f21018a.setDuration(0);
            f21018a.setText(str);
            f21018a.show();
        }
    }

    public static void c(int i2) {
        Toast toast = f21018a;
        if (toast == null) {
            f21018a = Toast.makeText(Hicore.getApp(), a(i2), 1);
            f21018a.setGravity(17, 0, 0);
            f21018a.show();
        } else {
            toast.setGravity(17, 0, 0);
            f21018a.setDuration(1);
            f21018a.setText(a(i2));
            f21018a.show();
        }
    }

    private static CharSequence a(int i2) {
        return Hicore.getApp().getResources().getString(i2);
    }

    public static void b(String str) {
        Toast toast = f21018a;
        if (toast == null) {
            f21018a = Toast.makeText(Hicore.getApp(), str, 0);
            f21018a.setGravity(80, 0, 0);
            f21018a.show();
        } else {
            toast.setGravity(80, 0, 0);
            f21018a.setDuration(0);
            f21018a.setText(str);
            f21018a.show();
        }
    }

    public static void a(String str, int i2, int i3) {
        if (Hicore.getApp() == null) {
            return;
        }
        Toast toast = f21018a;
        if (toast == null) {
            f21018a = Toast.makeText(Hicore.getApp(), str, 0);
            f21018a.setGravity(51, i2, i3);
            f21018a.show();
        } else {
            toast.setGravity(51, i2, i3);
            f21018a.setText(str);
            f21018a.show();
        }
    }

    public static void d(String str) {
        Toast toast = f21018a;
        if (toast == null) {
            f21018a = Toast.makeText(Hicore.getApp(), str, 1);
            f21018a.setGravity(17, 0, 0);
            f21018a.show();
        } else {
            toast.setGravity(17, 0, 0);
            f21018a.setDuration(1);
            f21018a.setText(str);
            f21018a.show();
        }
    }

    public static void a(float f2, float f3, String str) {
        if (Hicore.getApp() == null) {
            return;
        }
        Toast toast = f21018a;
        if (toast == null) {
            f21018a = Toast.makeText(Hicore.getApp(), str, 0);
            f21018a.setMargin(f2, f3);
            f21018a.show();
        } else {
            toast.setMargin(f2, f3);
            f21018a.setText(str);
            f21018a.show();
        }
    }
}
