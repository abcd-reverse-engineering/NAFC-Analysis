package com.airbnb.lottie.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.b0.h;
import com.airbnb.lottie.d;
import com.airbnb.lottie.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static final Object f3796e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f3797a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3798b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private d f3799c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, k> f3800d;

    public b(Drawable.Callback callback, String str, d dVar, Map<String, k> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f3798b = str;
        } else {
            this.f3798b = str + '/';
        }
        if (callback instanceof View) {
            this.f3797a = ((View) callback).getContext();
            this.f3800d = map;
            a(dVar);
        } else {
            com.airbnb.lottie.b0.d.b("LottieDrawable must be inside of a view for images to work.");
            this.f3800d = new HashMap();
            this.f3797a = null;
        }
    }

    private Bitmap b(String str, @Nullable Bitmap bitmap) {
        synchronized (f3796e) {
            this.f3800d.get(str).a(bitmap);
        }
        return bitmap;
    }

    public void a(@Nullable d dVar) {
        this.f3799c = dVar;
    }

    @Nullable
    public Bitmap a(String str, @Nullable Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmapA = this.f3800d.get(str).a();
            b(str, bitmap);
            return bitmapA;
        }
        k kVar = this.f3800d.get(str);
        Bitmap bitmapA2 = kVar.a();
        kVar.a(null);
        return bitmapA2;
    }

    @Nullable
    public Bitmap a(String str) {
        k kVar = this.f3800d.get(str);
        if (kVar == null) {
            return null;
        }
        Bitmap bitmapA = kVar.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        d dVar = this.f3799c;
        if (dVar != null) {
            Bitmap bitmapA2 = dVar.a(kVar);
            if (bitmapA2 != null) {
                b(str, bitmapA2);
            }
            return bitmapA2;
        }
        String strC = kVar.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                return b(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e2) {
                com.airbnb.lottie.b0.d.c("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f3798b)) {
                try {
                    return b(str, h.a(BitmapFactory.decodeStream(this.f3797a.getAssets().open(this.f3798b + strC), null, options), kVar.f(), kVar.d()));
                } catch (IllegalArgumentException e3) {
                    com.airbnb.lottie.b0.d.c("Unable to decode image.", e3);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e4) {
            com.airbnb.lottie.b0.d.c("Unable to open asset.", e4);
            return null;
        }
    }

    public boolean a(Context context) {
        return (context == null && this.f3797a == null) || this.f3797a.equals(context);
    }
}
