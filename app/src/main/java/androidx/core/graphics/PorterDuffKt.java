package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: PorterDuff.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0086\b¨\u0006\u0007"}, d2 = {"toColorFilter", "Landroid/graphics/PorterDuffColorFilter;", "Landroid/graphics/PorterDuff$Mode;", RemoteMessageConst.Notification.COLOR, "", "toXfermode", "Landroid/graphics/PorterDuffXfermode;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PorterDuffKt {
    @d
    public static final PorterDuffColorFilter toColorFilter(@d PorterDuff.Mode mode, int i2) {
        i0.f(mode, "$receiver");
        return new PorterDuffColorFilter(i2, mode);
    }

    @d
    public static final PorterDuffXfermode toXfermode(@d PorterDuff.Mode mode) {
        i0.f(mode, "$receiver");
        return new PorterDuffXfermode(mode);
    }
}
