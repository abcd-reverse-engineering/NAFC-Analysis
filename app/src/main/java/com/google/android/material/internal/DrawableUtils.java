package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class DrawableUtils {
    private static final String LOG_TAG = "DrawableUtils";
    private static Method setConstantStateMethod;
    private static boolean setConstantStateMethodFetched;

    private DrawableUtils() {
    }

    public static boolean setContainerConstantState(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return setContainerConstantStateV9(drawableContainer, constantState);
    }

    private static boolean setContainerConstantStateV9(DrawableContainer drawableContainer, Drawable.ConstantState constantState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!setConstantStateMethodFetched) {
            try {
                setConstantStateMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                setConstantStateMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            setConstantStateMethodFetched = true;
        }
        Method method = setConstantStateMethod;
        if (method != null) {
            try {
                method.invoke(drawableContainer, constantState);
                return true;
            } catch (Exception unused2) {
            }
        }
        return false;
    }
}
