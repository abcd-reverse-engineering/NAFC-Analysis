package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.r.l.p;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class k implements ComponentCallbacks2, com.bumptech.glide.manager.i, g<j<Drawable>> {

    /* renamed from: m, reason: collision with root package name */
    private static final com.bumptech.glide.r.h f4218m = com.bumptech.glide.r.h.b((Class<?>) Bitmap.class).M();
    private static final com.bumptech.glide.r.h n = com.bumptech.glide.r.h.b((Class<?>) GifDrawable.class).M();
    private static final com.bumptech.glide.r.h o = com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f4572c).a(h.LOW).b(true);

    /* renamed from: a, reason: collision with root package name */
    protected final com.bumptech.glide.b f4219a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f4220b;

    /* renamed from: c, reason: collision with root package name */
    final com.bumptech.glide.manager.h f4221c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private final m f4222d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private final com.bumptech.glide.manager.l f4223e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private final n f4224f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f4225g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f4226h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.manager.c f4227i;

    /* renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.bumptech.glide.r.g<Object>> f4228j;

    /* renamed from: k, reason: collision with root package name */
    @GuardedBy("this")
    private com.bumptech.glide.r.h f4229k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4230l;

    /* compiled from: RequestManager.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = k.this;
            kVar.f4221c.a(kVar);
        }
    }

    /* compiled from: RequestManager.java */
    private static class b extends com.bumptech.glide.r.l.f<View, Object> {
        b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f<? super Object> fVar) {
        }

        @Override // com.bumptech.glide.r.l.f
        protected void d(@Nullable Drawable drawable) {
        }
    }

    /* compiled from: RequestManager.java */
    private class c implements c.a {

        /* renamed from: a, reason: collision with root package name */
        @GuardedBy("RequestManager.this")
        private final m f4232a;

        c(@NonNull m mVar) {
            this.f4232a = mVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (k.this) {
                    this.f4232a.e();
                }
            }
        }
    }

    public k(@NonNull com.bumptech.glide.b bVar, @NonNull com.bumptech.glide.manager.h hVar, @NonNull com.bumptech.glide.manager.l lVar, @NonNull Context context) {
        this(bVar, hVar, lVar, new m(), bVar.e(), context);
    }

    @NonNull
    public synchronized k b(@NonNull com.bumptech.glide.r.h hVar) {
        c(hVar);
        return this;
    }

    protected synchronized void c(@NonNull com.bumptech.glide.r.h hVar) {
        this.f4229k = hVar.mo36clone().a();
    }

    @NonNull
    @CheckResult
    public j<GifDrawable> e() {
        return a(GifDrawable.class).a((com.bumptech.glide.r.a<?>) n);
    }

    @NonNull
    @CheckResult
    public j<File> f() {
        return a(File.class).a((com.bumptech.glide.r.a<?>) o);
    }

    List<com.bumptech.glide.r.g<Object>> g() {
        return this.f4228j;
    }

    synchronized com.bumptech.glide.r.h h() {
        return this.f4229k;
    }

    public synchronized boolean i() {
        return this.f4222d.b();
    }

    public synchronized void j() {
        this.f4222d.c();
    }

    public synchronized void k() {
        j();
        Iterator<k> it = this.f4223e.a().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    public synchronized void l() {
        this.f4222d.d();
    }

    public synchronized void m() {
        l();
        Iterator<k> it = this.f4223e.a().iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    public synchronized void n() {
        this.f4222d.f();
    }

    public synchronized void o() {
        com.bumptech.glide.util.l.b();
        n();
        Iterator<k> it = this.f4223e.a().iterator();
        while (it.hasNext()) {
            it.next().n();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onDestroy() {
        this.f4224f.onDestroy();
        Iterator<p<?>> it = this.f4224f.c().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.f4224f.b();
        this.f4222d.a();
        this.f4221c.b(this);
        this.f4221c.b(this.f4227i);
        this.f4226h.removeCallbacks(this.f4225g);
        this.f4219a.b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onStart() {
        n();
        this.f4224f.onStart();
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onStop() {
        l();
        this.f4224f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.f4230l) {
            k();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f4222d + ", treeNode=" + this.f4223e + "}";
    }

    private synchronized void d(@NonNull com.bumptech.glide.r.h hVar) {
        this.f4229k = this.f4229k.a(hVar);
    }

    @NonNull
    @CheckResult
    public j<Bitmap> b() {
        return a(Bitmap.class).a((com.bumptech.glide.r.a<?>) f4218m);
    }

    @NonNull
    @CheckResult
    public j<Drawable> c() {
        return a(Drawable.class);
    }

    k(com.bumptech.glide.b bVar, com.bumptech.glide.manager.h hVar, com.bumptech.glide.manager.l lVar, m mVar, com.bumptech.glide.manager.d dVar, Context context) {
        this.f4224f = new n();
        this.f4225g = new a();
        this.f4226h = new Handler(Looper.getMainLooper());
        this.f4219a = bVar;
        this.f4221c = hVar;
        this.f4223e = lVar;
        this.f4222d = mVar;
        this.f4220b = context;
        this.f4227i = dVar.a(context.getApplicationContext(), new c(mVar));
        if (com.bumptech.glide.util.l.c()) {
            this.f4226h.post(this.f4225g);
        } else {
            hVar.a(this);
        }
        hVar.a(this.f4227i);
        this.f4228j = new CopyOnWriteArrayList<>(bVar.g().b());
        c(bVar.g().c());
        bVar.a(this);
    }

    private void c(@NonNull p<?> pVar) {
        boolean zB = b(pVar);
        com.bumptech.glide.r.d dVarA = pVar.a();
        if (zB || this.f4219a.a(pVar) || dVarA == null) {
            return;
        }
        pVar.a((com.bumptech.glide.r.d) null);
        dVarA.clear();
    }

    @NonNull
    @CheckResult
    public j<File> b(@Nullable Object obj) {
        return f().a(obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> d(@Nullable Drawable drawable) {
        return c().d(drawable);
    }

    synchronized boolean b(@NonNull p<?> pVar) {
        com.bumptech.glide.r.d dVarA = pVar.a();
        if (dVarA == null) {
            return true;
        }
        if (!this.f4222d.b(dVarA)) {
            return false;
        }
        this.f4224f.b(pVar);
        pVar.a((com.bumptech.glide.r.d) null);
        return true;
    }

    @NonNull
    @CheckResult
    public j<File> d() {
        return a(File.class).a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.e(true));
    }

    @NonNull
    public synchronized k a(@NonNull com.bumptech.glide.r.h hVar) {
        d(hVar);
        return this;
    }

    public k a(com.bumptech.glide.r.g<Object> gVar) {
        this.f4228j.add(gVar);
        return this;
    }

    public void a(boolean z) {
        this.f4230l = z;
    }

    @NonNull
    <T> l<?, T> b(Class<T> cls) {
        return this.f4219a.g().a(cls);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable Bitmap bitmap) {
        return c().a(bitmap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable String str) {
        return c().a(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable Uri uri) {
        return c().a(uri);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable File file) {
        return c().a(file);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable @DrawableRes @RawRes Integer num) {
        return c().a(num);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @CheckResult
    @Deprecated
    public j<Drawable> a(@Nullable URL url) {
        return c().a(url);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable byte[] bArr) {
        return c().a(bArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable Object obj) {
        return c().a(obj);
    }

    @NonNull
    @CheckResult
    public <ResourceType> j<ResourceType> a(@NonNull Class<ResourceType> cls) {
        return new j<>(this.f4219a, this, cls, this.f4220b);
    }

    public void a(@NonNull View view) {
        a((p<?>) new b(view));
    }

    public void a(@Nullable p<?> pVar) {
        if (pVar == null) {
            return;
        }
        c(pVar);
    }

    synchronized void a(@NonNull p<?> pVar, @NonNull com.bumptech.glide.r.d dVar) {
        this.f4224f.a(pVar);
        this.f4222d.c(dVar);
    }
}
