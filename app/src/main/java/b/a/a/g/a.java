package b.a.a.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.DrawableRes;

/* compiled from: CompatUtils.java */
/* loaded from: classes.dex */
public class a {
    @TargetApi(16)
    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    @TargetApi(21)
    public static Drawable a(Context context, @DrawableRes int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            return context.getResources().getDrawable(i2);
        }
        return context.getDrawable(i2);
    }
}
