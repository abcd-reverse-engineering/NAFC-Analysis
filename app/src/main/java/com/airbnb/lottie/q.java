package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public class q<T> {

    /* renamed from: e, reason: collision with root package name */
    public static Executor f3613e = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    private final Set<l<T>> f3614a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<l<Throwable>> f3615b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f3616c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private volatile p<T> f3617d;

    /* compiled from: LottieTask.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f3617d == null) {
                return;
            }
            p pVar = q.this.f3617d;
            if (pVar.b() != null) {
                q.this.a((q) pVar.b());
            } else {
                q.this.a(pVar.a());
            }
        }
    }

    /* compiled from: LottieTask.java */
    private class b extends FutureTask<p<T>> {
        b(Callable<p<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                q.this.a((p) get());
            } catch (InterruptedException | ExecutionException e2) {
                q.this.a(new p(e2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public q(Callable<p<T>> callable) {
        this(callable, false);
    }

    public synchronized q<T> b(l<T> lVar) {
        if (this.f3617d != null && this.f3617d.b() != null) {
            lVar.onResult(this.f3617d.b());
        }
        this.f3614a.add(lVar);
        return this;
    }

    public synchronized q<T> c(l<Throwable> lVar) {
        this.f3615b.remove(lVar);
        return this;
    }

    public synchronized q<T> d(l<T> lVar) {
        this.f3614a.remove(lVar);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    q(Callable<p<T>> callable, boolean z) {
        this.f3614a = new LinkedHashSet(1);
        this.f3615b = new LinkedHashSet(1);
        this.f3616c = new Handler(Looper.getMainLooper());
        this.f3617d = null;
        if (!z) {
            f3613e.execute(new b(callable));
            return;
        }
        try {
            a((p) callable.call());
        } catch (Throwable th) {
            a((p) new p<>(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable p<T> pVar) {
        if (this.f3617d == null) {
            this.f3617d = pVar;
            a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized q<T> a(l<Throwable> lVar) {
        if (this.f3617d != null && this.f3617d.a() != null) {
            lVar.onResult(this.f3617d.a());
        }
        this.f3615b.add(lVar);
        return this;
    }

    private void a() {
        this.f3616c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(T t) {
        Iterator it = new ArrayList(this.f3614a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f3615b);
        if (arrayList.isEmpty()) {
            com.airbnb.lottie.b0.d.c("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).onResult(th);
        }
    }
}
