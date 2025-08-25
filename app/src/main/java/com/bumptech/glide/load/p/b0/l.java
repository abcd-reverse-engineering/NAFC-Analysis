package com.bumptech.glide.load.p.b0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: e, reason: collision with root package name */
    private static final String f4423e = "MemorySizeCalculator";

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f4424f = 4;

    /* renamed from: g, reason: collision with root package name */
    private static final int f4425g = 2;

    /* renamed from: a, reason: collision with root package name */
    private final int f4426a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4427b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f4428c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4429d;

    /* compiled from: MemorySizeCalculator.java */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f4443a;

        b(DisplayMetrics displayMetrics) {
            this.f4443a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.p.b0.l.c
        public int a() {
            return this.f4443a.heightPixels;
        }

        @Override // com.bumptech.glide.load.p.b0.l.c
        public int b() {
            return this.f4443a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    interface c {
        int a();

        int b();
    }

    l(a aVar) {
        this.f4428c = aVar.f4435a;
        this.f4429d = a(aVar.f4436b) ? aVar.f4442h / 2 : aVar.f4442h;
        int iA = a(aVar.f4436b, aVar.f4440f, aVar.f4441g);
        float fB = aVar.f4437c.b() * aVar.f4437c.a() * 4;
        int iRound = Math.round(aVar.f4439e * fB);
        int iRound2 = Math.round(fB * aVar.f4438d);
        int i2 = iA - this.f4429d;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.f4427b = iRound2;
            this.f4426a = iRound;
        } else {
            float f2 = i2;
            float f3 = aVar.f4439e;
            float f4 = aVar.f4438d;
            float f5 = f2 / (f3 + f4);
            this.f4427b = Math.round(f4 * f5);
            this.f4426a = Math.round(f5 * aVar.f4439e);
        }
        if (Log.isLoggable(f4423e, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f4427b));
            sb.append(", pool size: ");
            sb.append(a(this.f4426a));
            sb.append(", byte array size: ");
            sb.append(a(this.f4429d));
            sb.append(", memory class limited? ");
            sb.append(i3 > iA);
            sb.append(", max size: ");
            sb.append(a(iA));
            sb.append(", memoryClass: ");
            sb.append(aVar.f4436b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f4436b));
            sb.toString();
        }
    }

    public int a() {
        return this.f4429d;
    }

    public int b() {
        return this.f4426a;
    }

    public int c() {
        return this.f4427b;
    }

    /* compiled from: MemorySizeCalculator.java */
    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        @VisibleForTesting
        static final int f4430i = 2;

        /* renamed from: j, reason: collision with root package name */
        static final int f4431j;

        /* renamed from: k, reason: collision with root package name */
        static final float f4432k = 0.4f;

        /* renamed from: l, reason: collision with root package name */
        static final float f4433l = 0.33f;

        /* renamed from: m, reason: collision with root package name */
        static final int f4434m = 4194304;

        /* renamed from: a, reason: collision with root package name */
        final Context f4435a;

        /* renamed from: b, reason: collision with root package name */
        ActivityManager f4436b;

        /* renamed from: c, reason: collision with root package name */
        c f4437c;

        /* renamed from: e, reason: collision with root package name */
        float f4439e;

        /* renamed from: d, reason: collision with root package name */
        float f4438d = 2.0f;

        /* renamed from: f, reason: collision with root package name */
        float f4440f = f4432k;

        /* renamed from: g, reason: collision with root package name */
        float f4441g = f4433l;

        /* renamed from: h, reason: collision with root package name */
        int f4442h = 4194304;

        static {
            f4431j = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f4439e = f4431j;
            this.f4435a = context;
            this.f4436b = (ActivityManager) context.getSystemService("activity");
            this.f4437c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !l.a(this.f4436b)) {
                return;
            }
            this.f4439e = 0.0f;
        }

        public a a(float f2) {
            com.bumptech.glide.util.j.a(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f4439e = f2;
            return this;
        }

        public a b(float f2) {
            com.bumptech.glide.util.j.a(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f4441g = f2;
            return this;
        }

        public a c(float f2) {
            com.bumptech.glide.util.j.a(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f4440f = f2;
            return this;
        }

        public a d(float f2) {
            com.bumptech.glide.util.j.a(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f4438d = f2;
            return this;
        }

        public a a(int i2) {
            this.f4442h = i2;
            return this;
        }

        @VisibleForTesting
        a a(ActivityManager activityManager) {
            this.f4436b = activityManager;
            return this;
        }

        @VisibleForTesting
        a a(c cVar) {
            this.f4437c = cVar;
            return this;
        }

        public l a() {
            return new l(this);
        }
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i2) {
        return Formatter.formatFileSize(this.f4428c, i2);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
