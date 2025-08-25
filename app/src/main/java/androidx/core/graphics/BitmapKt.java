package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import h.q2.s.l;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: Bitmap.kt */
@y(bv = {1, 0, 2}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\bH\u0086\b\u001a'\u0010\u0016\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u0003H\u0086\n¨\u0006\u0018"}, d2 = {"createBitmap", "Landroid/graphics/Bitmap;", SocializeProtocolConstants.WIDTH, "", SocializeProtocolConstants.HEIGHT, "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "get", "x", "y", "scale", "filter", "set", RemoteMessageConst.Notification.COLOR, "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class BitmapKt {
    @d
    public static final Bitmap applyCanvas(@d Bitmap bitmap, @d l<? super Canvas, y1> lVar) {
        i0.f(bitmap, "$receiver");
        i0.f(lVar, "block");
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    @d
    public static final Bitmap createBitmap(int i2, int i3, @d Bitmap.Config config) {
        i0.f(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        i0.a((Object) bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    @d
    public static /* bridge */ /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        i0.f(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        i0.a((Object) bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static final int get(@d Bitmap bitmap, int i2, int i3) {
        i0.f(bitmap, "$receiver");
        return bitmap.getPixel(i2, i3);
    }

    @d
    public static final Bitmap scale(@d Bitmap bitmap, int i2, int i3, boolean z) {
        i0.f(bitmap, "$receiver");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        i0.a((Object) bitmapCreateScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    @d
    public static /* bridge */ /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = true;
        }
        i0.f(bitmap, "$receiver");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        i0.a((Object) bitmapCreateScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void set(@d Bitmap bitmap, int i2, int i3, @ColorInt int i4) {
        i0.f(bitmap, "$receiver");
        bitmap.setPixel(i2, i3, i4);
    }

    @RequiresApi(26)
    @d
    public static final Bitmap createBitmap(int i2, int i3, @d Bitmap.Config config, boolean z, @d ColorSpace colorSpace) {
        i0.f(config, "config");
        i0.f(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        i0.a((Object) bitmapCreateBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    @RequiresApi(26)
    @d
    public static /* bridge */ /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            i0.a((Object) colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        i0.f(config, "config");
        i0.f(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        i0.a((Object) bitmapCreateBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }
}
