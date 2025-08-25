package com.bumptech.glide.load.o.p;

import android.net.Uri;
import com.umeng.socialize.common.SocializeConstants;

/* compiled from: MediaStoreUtil.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4300a = 512;

    /* renamed from: b, reason: collision with root package name */
    private static final int f4301b = 384;

    private b() {
    }

    public static boolean a(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= f4301b;
    }

    public static boolean a(Uri uri) {
        return b(uri) && !d(uri);
    }

    public static boolean b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && SocializeConstants.KEY_PLATFORM.equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return b(uri) && d(uri);
    }

    private static boolean d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
