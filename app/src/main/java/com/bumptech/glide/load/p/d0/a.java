package com.bumptech.glide.load.p.d0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.p.a0.e;
import com.bumptech.glide.load.p.b0.j;
import com.bumptech.glide.util.l;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: BitmapPreFillRunner.java */
/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final String f4491i = "PreFillRunner";

    /* renamed from: k, reason: collision with root package name */
    static final long f4493k = 32;

    /* renamed from: l, reason: collision with root package name */
    static final long f4494l = 40;

    /* renamed from: m, reason: collision with root package name */
    static final int f4495m = 4;

    /* renamed from: a, reason: collision with root package name */
    private final e f4496a;

    /* renamed from: b, reason: collision with root package name */
    private final j f4497b;

    /* renamed from: c, reason: collision with root package name */
    private final c f4498c;

    /* renamed from: d, reason: collision with root package name */
    private final C0064a f4499d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<d> f4500e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f4501f;

    /* renamed from: g, reason: collision with root package name */
    private long f4502g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4503h;

    /* renamed from: j, reason: collision with root package name */
    private static final C0064a f4492j = new C0064a();
    static final long n = TimeUnit.SECONDS.toMillis(1);

    /* compiled from: BitmapPreFillRunner.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.d0.a$a, reason: collision with other inner class name */
    static class C0064a {
        C0064a() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* compiled from: BitmapPreFillRunner.java */
    private static final class b implements g {
        b() {
        }

        @Override // com.bumptech.glide.load.g
        public void a(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(e eVar, j jVar, c cVar) {
        this(eVar, jVar, cVar, f4492j, new Handler(Looper.getMainLooper()));
    }

    private long c() {
        return this.f4497b.b() - this.f4497b.getCurrentSize();
    }

    private long d() {
        long j2 = this.f4502g;
        this.f4502g = Math.min(4 * j2, n);
        return j2;
    }

    @VisibleForTesting
    boolean a() {
        Bitmap bitmapCreateBitmap;
        long jA = this.f4499d.a();
        while (!this.f4498c.b() && !a(jA)) {
            d dVarC = this.f4498c.c();
            if (this.f4500e.contains(dVarC)) {
                bitmapCreateBitmap = Bitmap.createBitmap(dVarC.d(), dVarC.b(), dVarC.a());
            } else {
                this.f4500e.add(dVarC);
                bitmapCreateBitmap = this.f4496a.b(dVarC.d(), dVarC.b(), dVarC.a());
            }
            int iA = l.a(bitmapCreateBitmap);
            if (c() >= iA) {
                this.f4497b.a(new b(), com.bumptech.glide.load.r.d.g.a(bitmapCreateBitmap, this.f4496a));
            } else {
                this.f4496a.a(bitmapCreateBitmap);
            }
            if (Log.isLoggable(f4491i, 3)) {
                String str = "allocated [" + dVarC.d() + "x" + dVarC.b() + "] " + dVarC.a() + " size: " + iA;
            }
        }
        return (this.f4503h || this.f4498c.b()) ? false : true;
    }

    public void b() {
        this.f4503h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f4501f.postDelayed(this, d());
        }
    }

    @VisibleForTesting
    a(e eVar, j jVar, c cVar, C0064a c0064a, Handler handler) {
        this.f4500e = new HashSet();
        this.f4502g = f4494l;
        this.f4496a = eVar;
        this.f4497b = jVar;
        this.f4498c = cVar;
        this.f4499d = c0064a;
        this.f4501f = handler;
    }

    private boolean a(long j2) {
        return this.f4499d.a() - j2 >= 32;
    }
}
