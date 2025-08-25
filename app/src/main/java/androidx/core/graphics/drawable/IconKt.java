package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: Icon.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class IconKt {
    @RequiresApi(26)
    @d
    public static final Icon toAdaptiveIcon(@d Bitmap bitmap) {
        i0.f(bitmap, "$receiver");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        i0.a((Object) iconCreateWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    @d
    public static final Icon toIcon(@d Bitmap bitmap) {
        i0.f(bitmap, "$receiver");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        i0.a((Object) iconCreateWithBitmap, "Icon.createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @RequiresApi(26)
    @d
    public static final Icon toIcon(@d Uri uri) {
        i0.f(uri, "$receiver");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        i0.a((Object) iconCreateWithContentUri, "Icon.createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @RequiresApi(26)
    @d
    public static final Icon toIcon(@d byte[] bArr) {
        i0.f(bArr, "$receiver");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        i0.a((Object) iconCreateWithData, "Icon.createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
