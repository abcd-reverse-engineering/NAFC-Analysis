package com.luck.picture.lib.tools;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class AttrsUtils {
    public static boolean getTypeValueBoolean(Context context, int i2) throws Resources.NotFoundException {
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i2});
            boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            return z;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int getTypeValueColor(Context context, int i2) throws Resources.NotFoundException {
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i2});
            int color = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return color;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Drawable getTypeValueDrawable(Context context, int i2) throws Resources.NotFoundException {
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i2});
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
