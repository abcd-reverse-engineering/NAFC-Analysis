package com.bumptech.glide.load.p.a0;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class k implements e {

    /* renamed from: k, reason: collision with root package name */
    private static final String f4361k = "LruBitmapPool";

    /* renamed from: l, reason: collision with root package name */
    private static final Bitmap.Config f4362l = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private final l f4363a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f4364b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4365c;

    /* renamed from: d, reason: collision with root package name */
    private final a f4366d;

    /* renamed from: e, reason: collision with root package name */
    private long f4367e;

    /* renamed from: f, reason: collision with root package name */
    private long f4368f;

    /* renamed from: g, reason: collision with root package name */
    private int f4369g;

    /* renamed from: h, reason: collision with root package name */
    private int f4370h;

    /* renamed from: i, reason: collision with root package name */
    private int f4371i;

    /* renamed from: j, reason: collision with root package name */
    private int f4372j;

    /* compiled from: LruBitmapPool.java */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.p.a0.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.p.a0.k.a
        public void b(Bitmap bitmap) {
        }
    }

    /* compiled from: LruBitmapPool.java */
    private static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final Set<Bitmap> f4373a = Collections.synchronizedSet(new HashSet());

        private c() {
        }

        @Override // com.bumptech.glide.load.p.a0.k.a
        public void a(Bitmap bitmap) {
            if (!this.f4373a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f4373a.remove(bitmap);
        }

        @Override // com.bumptech.glide.load.p.a0.k.a
        public void b(Bitmap bitmap) {
            if (!this.f4373a.contains(bitmap)) {
                this.f4373a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f4365c = j2;
        this.f4367e = j2;
        this.f4363a = lVar;
        this.f4364b = set;
        this.f4366d = new b();
    }

    private void g() {
        if (Log.isLoggable(f4361k, 2)) {
            h();
        }
    }

    private void h() {
        String str = "Hits=" + this.f4369g + ", misses=" + this.f4370h + ", puts=" + this.f4371i + ", evictions=" + this.f4372j + ", currentSize=" + this.f4368f + ", maxSize=" + this.f4367e + "\nStrategy=" + this.f4363a;
    }

    private void i() {
        a(this.f4367e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> j() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l k() {
        return Build.VERSION.SDK_INT >= 19 ? new o() : new com.bumptech.glide.load.p.a0.c();
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public synchronized void a(float f2) {
        this.f4367e = Math.round(this.f4365c * f2);
        i();
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public long b() {
        return this.f4367e;
    }

    public long c() {
        return this.f4372j;
    }

    public long d() {
        return this.f4368f;
    }

    public long e() {
        return this.f4369g;
    }

    public long f() {
        return this.f4370h;
    }

    @NonNull
    private static Bitmap c(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f4362l;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Nullable
    private synchronized Bitmap d(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap bitmapA;
        a(config);
        bitmapA = this.f4363a.a(i2, i3, config != null ? config : f4362l);
        if (bitmapA == null) {
            if (Log.isLoggable(f4361k, 3)) {
                String str = "Missing bitmap=" + this.f4363a.b(i2, i3, config);
            }
            this.f4370h++;
        } else {
            this.f4369g++;
            this.f4368f -= this.f4363a.b(bitmapA);
            this.f4366d.a(bitmapA);
            c(bitmapA);
        }
        if (Log.isLoggable(f4361k, 2)) {
            String str2 = "Get bitmap=" + this.f4363a.b(i2, i3, config);
        }
        g();
        return bitmapA;
    }

    @Override // com.bumptech.glide.load.p.a0.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapD = d(i2, i3, config);
        return bitmapD == null ? c(i2, i3, config) : bitmapD;
    }

    private static void c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        b(bitmap);
    }

    @TargetApi(19)
    private static void b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f4363a.b(bitmap) <= this.f4367e && this.f4364b.contains(bitmap.getConfig())) {
                        int iB = this.f4363a.b(bitmap);
                        this.f4363a.a(bitmap);
                        this.f4366d.b(bitmap);
                        this.f4371i++;
                        this.f4368f += iB;
                        if (Log.isLoggable(f4361k, 2)) {
                            String str = "Put bitmap in pool=" + this.f4363a.c(bitmap);
                        }
                        g();
                        i();
                        return;
                    }
                    if (Log.isLoggable(f4361k, 2)) {
                        String str2 = "Reject bitmap from pool, bitmap: " + this.f4363a.c(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f4364b.contains(bitmap.getConfig());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    public k(long j2) {
        this(j2, k(), j());
    }

    public k(long j2, Set<Bitmap.Config> set) {
        this(j2, k(), set);
    }

    @Override // com.bumptech.glide.load.p.a0.e
    @NonNull
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapD = d(i2, i3, config);
        if (bitmapD != null) {
            bitmapD.eraseColor(0);
            return bitmapD;
        }
        return c(i2, i3, config);
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public void a() {
        Log.isLoggable(f4361k, 3);
        a(0L);
    }

    @Override // com.bumptech.glide.load.p.a0.e
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable(f4361k, 3)) {
            String str = "trimMemory, level=" + i2;
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }

    private synchronized void a(long j2) {
        while (this.f4368f > j2) {
            Bitmap bitmapRemoveLast = this.f4363a.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable(f4361k, 5)) {
                    h();
                }
                this.f4368f = 0L;
                return;
            }
            this.f4366d.a(bitmapRemoveLast);
            this.f4368f -= this.f4363a.b(bitmapRemoveLast);
            this.f4372j++;
            if (Log.isLoggable(f4361k, 3)) {
                String str = "Evicting bitmap=" + this.f4363a.c(bitmapRemoveLast);
            }
            g();
            bitmapRemoveLast.recycle();
        }
    }
}
