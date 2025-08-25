package com.luck.picture.lib.immersive;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class NavBarUtils {
    public static void setNavBarColor(@NonNull Activity activity, @ColorInt int i2) {
        setNavBarColor(activity.getWindow(), i2);
    }

    public static void setNavBarColor(@NonNull Window window, @ColorInt int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            window.setNavigationBarColor(i2);
        }
    }
}
