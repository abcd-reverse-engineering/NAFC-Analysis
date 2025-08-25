package com.bumptech.glide.load.r.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;

/* compiled from: HardwareConfigState.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f4952f = 128;

    /* renamed from: g, reason: collision with root package name */
    private static final int f4953g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static final File f4954h = new File("/proc/self/fd");

    /* renamed from: i, reason: collision with root package name */
    private static final int f4955i = 50;

    /* renamed from: j, reason: collision with root package name */
    private static final int f4956j = 700;

    /* renamed from: k, reason: collision with root package name */
    private static final int f4957k = 20000;

    /* renamed from: l, reason: collision with root package name */
    private static volatile w f4958l;

    /* renamed from: b, reason: collision with root package name */
    private final int f4960b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4961c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private int f4962d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f4963e = true;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4959a = c();

    @VisibleForTesting
    w() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4960b = 20000;
            this.f4961c = 0;
        } else {
            this.f4960b = 700;
            this.f4961c = 128;
        }
    }

    public static w a() {
        if (f4958l == null) {
            synchronized (w.class) {
                if (f4958l == null) {
                    f4958l = new w();
                }
            }
        }
        return f4958l;
    }

    private synchronized boolean b() {
        int i2 = this.f4962d + 1;
        this.f4962d = i2;
        if (i2 >= 50) {
            this.f4962d = 0;
            int length = f4954h.list().length;
            this.f4963e = length < this.f4960b;
            if (!this.f4963e && Log.isLoggable("Downsampler", 5)) {
                String str = "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f4960b;
            }
        }
        return this.f4963e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c() {
        /*
            java.lang.String r0 = android.os.Build.MODEL
            r1 = 1
            if (r0 == 0) goto L71
            int r0 = r0.length()
            r2 = 7
            if (r0 >= r2) goto Le
            goto L71
        Le:
            java.lang.String r0 = android.os.Build.MODEL
            r3 = 0
            java.lang.String r0 = r0.substring(r3, r2)
            r2 = -1
            int r4 = r0.hashCode()
            switch(r4) {
                case -1398613787: goto L5a;
                case -1398431166: goto L50;
                case -1398431161: goto L46;
                case -1398431073: goto L3c;
                case -1398431068: goto L32;
                case -1398343746: goto L28;
                case -1398222624: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L64
        L1e:
            java.lang.String r4 = "SM-N935"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 0
            goto L65
        L28:
            java.lang.String r4 = "SM-J720"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 1
            goto L65
        L32:
            java.lang.String r4 = "SM-G965"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 3
            goto L65
        L3c:
            java.lang.String r4 = "SM-G960"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 2
            goto L65
        L46:
            java.lang.String r4 = "SM-G935"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 4
            goto L65
        L50:
            java.lang.String r4 = "SM-G930"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 5
            goto L65
        L5a:
            java.lang.String r4 = "SM-A520"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 6
            goto L65
        L64:
            r0 = -1
        L65:
            switch(r0) {
                case 0: goto L69;
                case 1: goto L69;
                case 2: goto L69;
                case 3: goto L69;
                case 4: goto L69;
                case 5: goto L69;
                case 6: goto L69;
                default: goto L68;
            }
        L68:
            return r1
        L69:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r0 == r2) goto L70
            goto L71
        L70:
            r1 = 0
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.r.d.w.c():boolean");
    }

    public boolean a(int i2, int i3, boolean z, boolean z2) {
        int i4;
        return z && this.f4959a && Build.VERSION.SDK_INT >= 26 && !z2 && i2 >= (i4 = this.f4961c) && i3 >= i4 && b();
    }

    @TargetApi(26)
    boolean a(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zA = a(i2, i3, z, z2);
        if (zA) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zA;
    }
}
