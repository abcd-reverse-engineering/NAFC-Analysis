package com.hihonor.cloudservice.tasks.q;

import android.os.Looper;
import c.c.a.d.k;
import c.c.a.d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: TaskManager.java */
/* loaded from: classes.dex */
public class j {

    /* compiled from: TaskManager.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f6094a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f6095b;

        a(j jVar, k kVar, Callable callable) {
            this.f6094a = kVar;
            this.f6095b = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f6094a.a((k) this.f6095b.call());
            } catch (Exception e2) {
                this.f6094a.a(e2);
            }
        }
    }

    /* compiled from: TaskManager.java */
    class b implements c.c.a.d.c<Void, List<c.c.a.d.j<?>>> {
        b() {
        }

        @Override // c.c.a.d.c
        public List<c.c.a.d.j<?>> a(c.c.a.d.j<Void> jVar) {
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TResult] */
    /* compiled from: TaskManager.java */
    class c<TResult> implements c.c.a.d.c<Void, List<TResult>> {
        c() {
        }

        @Override // c.c.a.d.c
        public List<TResult> a(c.c.a.d.j<Void> jVar) {
            return null;
        }
    }

    /* compiled from: TaskManager.java */
    public static class d<TResult> implements c.c.a.d.e, c.c.a.d.g, c.c.a.d.h<TResult> {

        /* renamed from: a, reason: collision with root package name */
        public final CountDownLatch f6096a = new CountDownLatch(1);

        @Override // c.c.a.d.e
        public final void onCanceled() {
            this.f6096a.countDown();
        }

        @Override // c.c.a.d.g
        public final void onFailure(Exception exc) {
            this.f6096a.countDown();
        }

        @Override // c.c.a.d.h
        public final void onSuccess(TResult tresult) {
            this.f6096a.countDown();
        }
    }

    public static <TResult> c.c.a.d.j<List<TResult>> b(Collection<? extends c.c.a.d.j<?>> collection) {
        return (c.c.a.d.j<List<TResult>>) c(collection).a(new c());
    }

    public static c.c.a.d.j<Void> c(Collection<? extends c.c.a.d.j<?>> collection) {
        if (collection.isEmpty()) {
            return a((Object) null);
        }
        Iterator<? extends c.c.a.d.j<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        i iVar = new i();
        h hVar = new h(collection.size(), iVar);
        for (c.c.a.d.j<?> jVar : collection) {
            jVar.a(l.b(), (c.c.a.d.h<?>) hVar);
            jVar.a(l.b(), (c.c.a.d.g) hVar);
            jVar.a(l.b(), (c.c.a.d.e) hVar);
        }
        return iVar;
    }

    public final <TResult> c.c.a.d.j<TResult> a(Executor executor, Callable<TResult> callable) {
        k kVar = new k();
        try {
            executor.execute(new a(this, kVar, callable));
        } catch (Exception e2) {
            kVar.a(e2);
        }
        return kVar.a();
    }

    public static <TResult> c.c.a.d.j<TResult> a(TResult tresult) {
        k kVar = new k();
        kVar.a((k) tresult);
        return kVar.a();
    }

    public static c.c.a.d.j<List<c.c.a.d.j<?>>> a(Collection<? extends c.c.a.d.j<?>> collection) {
        return c(collection).a(new b());
    }

    public static <TResult> TResult a(c.c.a.d.j<TResult> jVar) throws ExecutionException {
        if (jVar.e()) {
            return jVar.b();
        }
        throw new ExecutionException(jVar.a());
    }

    public static void a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }
}
