package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: BitmapDrawable.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Bitmap;", "resources", "Landroid/content/res/Resources;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class BitmapDrawableKt {
    @d
    public static final BitmapDrawable toDrawable(@d Bitmap bitmap, @d Resources resources) {
        i0.f(bitmap, "$receiver");
        i0.f(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
