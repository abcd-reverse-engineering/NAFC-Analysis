package com.bumptech.glide.load.p;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.p.p;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: ActiveResources.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4319a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f4320b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<com.bumptech.glide.load.g, d> f4321c;

    /* renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<p<?>> f4322d;

    /* renamed from: e, reason: collision with root package name */
    private p.a f4323e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f4324f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile c f4325g;

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.p.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0057a implements ThreadFactory {

        /* compiled from: ActiveResources.java */
        /* renamed from: com.bumptech.glide.load.p.a$a$a, reason: collision with other inner class name */
        class RunnableC0058a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f4326a;

            RunnableC0058a(Runnable runnable) {
                this.f4326a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(10);
                this.f4326a.run();
            }
        }

        ThreadFactoryC0057a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0058a(runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    interface c {
        void a();
    }

    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    static final class d extends WeakReference<p<?>> {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.g f4329a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f4330b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        v<?> f4331c;

        d(@NonNull com.bumptech.glide.load.g gVar, @NonNull p<?> pVar, @NonNull ReferenceQueue<? super p<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            this.f4329a = (com.bumptech.glide.load.g) com.bumptech.glide.util.j.a(gVar);
            this.f4331c = (pVar.e() && z) ? (v) com.bumptech.glide.util.j.a(pVar.d()) : null;
            this.f4330b = pVar.e();
        }

        void a() {
            this.f4331c = null;
            clear();
        }
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0057a()));
    }

    void a(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f4323e = aVar;
            }
        }
    }

    @Nullable
    synchronized p<?> b(com.bumptech.glide.load.g gVar) {
        d dVar = this.f4321c.get(gVar);
        if (dVar == null) {
            return null;
        }
        p<?> pVar = dVar.get();
        if (pVar == null) {
            a(dVar);
        }
        return pVar;
    }

    @VisibleForTesting
    a(boolean z, Executor executor) {
        this.f4321c = new HashMap();
        this.f4322d = new ReferenceQueue<>();
        this.f4319a = z;
        this.f4320b = executor;
        executor.execute(new b());
    }

    @VisibleForTesting
    void b() {
        this.f4324f = true;
        Executor executor = this.f4320b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.d.a((ExecutorService) executor);
        }
    }

    synchronized void a(com.bumptech.glide.load.g gVar, p<?> pVar) {
        d dVarPut = this.f4321c.put(gVar, new d(gVar, pVar, this.f4322d, this.f4319a));
        if (dVarPut != null) {
            dVarPut.a();
        }
    }

    synchronized void a(com.bumptech.glide.load.g gVar) {
        d dVarRemove = this.f4321c.remove(gVar);
        if (dVarRemove != null) {
            dVarRemove.a();
        }
    }

    void a(@NonNull d dVar) {
        synchronized (this) {
            this.f4321c.remove(dVar.f4329a);
            if (dVar.f4330b && dVar.f4331c != null) {
                this.f4323e.a(dVar.f4329a, new p<>(dVar.f4331c, true, false, dVar.f4329a, this.f4323e));
            }
        }
    }

    void a() {
        while (!this.f4324f) {
            try {
                a((d) this.f4322d.remove());
                c cVar = this.f4325g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @VisibleForTesting
    void a(c cVar) {
        this.f4325g = cVar;
    }
}
