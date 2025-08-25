package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class BaseActivity extends Activity {
    private boolean h() throws NoSuchMethodException, SecurityException {
        Method method;
        boolean zBooleanValue;
        boolean z = false;
        try {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            zBooleanValue = ((Boolean) method.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            method.setAccessible(false);
            return zBooleanValue;
        } catch (Exception e3) {
            z = zBooleanValue;
            e = e3;
            e.printStackTrace();
            return z;
        }
    }

    private boolean i() throws NoSuchFieldException {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT == 26 && h()) {
            i();
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (Build.VERSION.SDK_INT == 26 && h()) {
            return;
        }
        super.setRequestedOrientation(i2);
    }
}
