package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: ColorDrawable.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b¨\u0006\u0004"}, d2 = {"toDrawable", "Landroid/graphics/drawable/ColorDrawable;", "", "Landroid/graphics/Color;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ColorDrawableKt {
    @d
    public static final ColorDrawable toDrawable(@ColorInt int i2) {
        return new ColorDrawable(i2);
    }

    @RequiresApi(26)
    @d
    public static final ColorDrawable toDrawable(@d Color color) {
        i0.f(color, "$receiver");
        return new ColorDrawable(color.toArgb());
    }
}
