package com.luck.picture.lib.immersive;

import android.os.Build;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import c.c.a.b.a.a;

/* loaded from: classes.dex */
public class ImmersiveManage {
    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, int i2, int i3, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            immersiveAboveAPI23(appCompatActivity, false, false, i2, i3, z);
        }
    }

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, boolean z, boolean z2, int i2, int i3, boolean z3) {
        try {
            Window window = appCompatActivity.getWindow();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                window.setFlags(a.B1, a.B1);
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (z && z2) {
                    window.clearFlags(201326592);
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, z, z2, i2 == 0, z3);
                    window.addFlags(Integer.MIN_VALUE);
                } else if (!z && !z2) {
                    window.requestFeature(1);
                    window.clearFlags(201326592);
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, z, z2, i2 == 0, z3);
                    window.addFlags(Integer.MIN_VALUE);
                } else {
                    if (z || !z2) {
                        return;
                    }
                    window.requestFeature(1);
                    window.clearFlags(201326592);
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, z, z2, i2 == 0, z3);
                    window.addFlags(Integer.MIN_VALUE);
                }
                window.setStatusBarColor(i2);
                window.setNavigationBarColor(i3);
            }
        } catch (Exception unused) {
        }
    }
}
