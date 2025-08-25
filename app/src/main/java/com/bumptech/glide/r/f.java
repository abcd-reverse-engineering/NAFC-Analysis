package com.bumptech.glide.r;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.p.q;
import com.bumptech.glide.r.l.o;
import com.bumptech.glide.r.l.p;
import com.bumptech.glide.util.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFutureTarget.java */
/* loaded from: classes.dex */
public class f<R> implements c<R>, g<R> {

    /* renamed from: k, reason: collision with root package name */
    private static final a f5232k = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f5233a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5234b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f5235c;

    /* renamed from: d, reason: collision with root package name */
    private final a f5236d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private R f5237e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private d f5238f;

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f5239g;

    /* renamed from: h, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f5240h;

    /* renamed from: i, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f5241i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private q f5242j;

    /* compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    static class a {
        a() {
        }

        void a(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }

        void a(Object obj) {
            obj.notifyAll();
        }
    }

    public f(int i2, int i3) {
        this(i2, i3, true, f5232k);
    }

    @Override // com.bumptech.glide.r.l.p
    public synchronized void a(@Nullable d dVar) {
        this.f5238f = dVar;
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.r.l.p
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public void b(@NonNull o oVar) {
        oVar.a(this.f5233a, this.f5234b);
    }

    @Override // com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        d dVar;
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.f5239g = true;
            this.f5236d.a(this);
            if (z) {
                dVar = this.f5238f;
                this.f5238f = null;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f5239g;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f5239g     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.f5240h     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.f5241i     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto Le
            goto L10
        Le:
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            monitor-exit(r1)
            return r0
        L13:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.r.f.isDone():boolean");
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    f(int i2, int i3, boolean z, a aVar) {
        this.f5233a = i2;
        this.f5234b = i3;
        this.f5235c = z;
        this.f5236d = aVar;
    }

    @Override // com.bumptech.glide.r.l.p
    @Nullable
    public synchronized d a() {
        return this.f5238f;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    @Override // com.bumptech.glide.r.l.p
    public synchronized void a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public synchronized void a(@NonNull R r, @Nullable com.bumptech.glide.r.m.f<? super R> fVar) {
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f5235c && !isDone()) {
            l.a();
        }
        if (!this.f5239g) {
            if (!this.f5241i) {
                if (this.f5240h) {
                    return this.f5237e;
                }
                if (l2 == null) {
                    this.f5236d.a(this, 0L);
                } else if (l2.longValue() > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jLongValue = l2.longValue() + jCurrentTimeMillis;
                    while (!isDone() && jCurrentTimeMillis < jLongValue) {
                        this.f5236d.a(this, jLongValue - jCurrentTimeMillis);
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.f5241i) {
                        if (!this.f5239g) {
                            if (this.f5240h) {
                                return this.f5237e;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.f5242j);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.f5242j);
        }
        throw new CancellationException();
    }

    @Override // com.bumptech.glide.r.g
    public synchronized boolean a(@Nullable q qVar, Object obj, p<R> pVar, boolean z) {
        this.f5241i = true;
        this.f5242j = qVar;
        this.f5236d.a(this);
        return false;
    }

    @Override // com.bumptech.glide.r.g
    public synchronized boolean a(R r, Object obj, p<R> pVar, com.bumptech.glide.load.a aVar, boolean z) {
        this.f5240h = true;
        this.f5237e = r;
        this.f5236d.a(this);
        return false;
    }
}
