package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.n;
import com.bumptech.glide.r.l.p;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.o.a f5023a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f5024b;

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f5025c;

    /* renamed from: d, reason: collision with root package name */
    final k f5026d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f5027e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5028f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5029g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5030h;

    /* renamed from: i, reason: collision with root package name */
    private j<Bitmap> f5031i;

    /* renamed from: j, reason: collision with root package name */
    private a f5032j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5033k;

    /* renamed from: l, reason: collision with root package name */
    private a f5034l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f5035m;
    private n<Bitmap> n;
    private a o;

    @Nullable
    private d p;
    private int q;
    private int r;
    private int s;

    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    static class a extends com.bumptech.glide.r.l.e<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f5036d;

        /* renamed from: e, reason: collision with root package name */
        final int f5037e;

        /* renamed from: f, reason: collision with root package name */
        private final long f5038f;

        /* renamed from: g, reason: collision with root package name */
        private Bitmap f5039g;

        a(Handler handler, int i2, long j2) {
            this.f5036d = handler;
            this.f5037e = i2;
            this.f5038f = j2;
        }

        @Override // com.bumptech.glide.r.l.p
        public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f fVar) {
            a((Bitmap) obj, (com.bumptech.glide.r.m.f<? super Bitmap>) fVar);
        }

        Bitmap b() {
            return this.f5039g;
        }

        @Override // com.bumptech.glide.r.l.p
        public void c(@Nullable Drawable drawable) {
            this.f5039g = null;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.r.m.f<? super Bitmap> fVar) {
            this.f5039g = bitmap;
            this.f5036d.sendMessageAtTime(this.f5036d.obtainMessage(1, this), this.f5038f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader.java */
    private class c implements Handler.Callback {

        /* renamed from: b, reason: collision with root package name */
        static final int f5040b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f5041c = 2;

        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                f.this.a((a) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            f.this.f5026d.a((p<?>) message.obj);
            return false;
        }
    }

    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    interface d {
        void a();
    }

    f(com.bumptech.glide.b bVar, com.bumptech.glide.o.a aVar, int i2, int i3, n<Bitmap> nVar, Bitmap bitmap) {
        this(bVar.d(), com.bumptech.glide.b.e(bVar.f()), aVar, null, a(com.bumptech.glide.b.e(bVar.f()), i2, i3), nVar, bitmap);
    }

    private static com.bumptech.glide.load.g m() {
        return new com.bumptech.glide.s.e(Double.valueOf(Math.random()));
    }

    private void n() {
        if (!this.f5028f || this.f5029g) {
            return;
        }
        if (this.f5030h) {
            com.bumptech.glide.util.j.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.f5023a.f();
            this.f5030h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.f5029g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.f5023a.d();
        this.f5023a.b();
        this.f5034l = new a(this.f5024b, this.f5023a.g(), jUptimeMillis);
        this.f5031i.a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(m())).a((Object) this.f5023a).b((j<Bitmap>) this.f5034l);
    }

    private void o() {
        Bitmap bitmap = this.f5035m;
        if (bitmap != null) {
            this.f5027e.a(bitmap);
            this.f5035m = null;
        }
    }

    private void p() {
        if (this.f5028f) {
            return;
        }
        this.f5028f = true;
        this.f5033k = false;
        n();
    }

    private void q() {
        this.f5028f = false;
    }

    void a(n<Bitmap> nVar, Bitmap bitmap) {
        this.n = (n) com.bumptech.glide.util.j.a(nVar);
        this.f5035m = (Bitmap) com.bumptech.glide.util.j.a(bitmap);
        this.f5031i = this.f5031i.a((com.bumptech.glide.r.a<?>) new com.bumptech.glide.r.h().b(nVar));
        this.q = l.a(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    void b(b bVar) {
        this.f5025c.remove(bVar);
        if (this.f5025c.isEmpty()) {
            q();
        }
    }

    Bitmap c() {
        a aVar = this.f5032j;
        return aVar != null ? aVar.b() : this.f5035m;
    }

    int d() {
        a aVar = this.f5032j;
        if (aVar != null) {
            return aVar.f5037e;
        }
        return -1;
    }

    Bitmap e() {
        return this.f5035m;
    }

    int f() {
        return this.f5023a.c();
    }

    n<Bitmap> g() {
        return this.n;
    }

    int h() {
        return this.s;
    }

    int i() {
        return this.f5023a.k();
    }

    int j() {
        return this.f5023a.j() + this.q;
    }

    int k() {
        return this.r;
    }

    void l() {
        com.bumptech.glide.util.j.a(!this.f5028f, "Can't restart a running animation");
        this.f5030h = true;
        a aVar = this.o;
        if (aVar != null) {
            this.f5026d.a((p<?>) aVar);
            this.o = null;
        }
    }

    @VisibleForTesting
    void setOnEveryFrameReadyListener(@Nullable d dVar) {
        this.p = dVar;
    }

    ByteBuffer b() {
        return this.f5023a.e().asReadOnlyBuffer();
    }

    f(com.bumptech.glide.load.p.a0.e eVar, k kVar, com.bumptech.glide.o.a aVar, Handler handler, j<Bitmap> jVar, n<Bitmap> nVar, Bitmap bitmap) {
        this.f5025c = new ArrayList();
        this.f5026d = kVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f5027e = eVar;
        this.f5024b = handler;
        this.f5031i = jVar;
        this.f5023a = aVar;
        a(nVar, bitmap);
    }

    void a(b bVar) {
        if (!this.f5033k) {
            if (!this.f5025c.contains(bVar)) {
                boolean zIsEmpty = this.f5025c.isEmpty();
                this.f5025c.add(bVar);
                if (zIsEmpty) {
                    p();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    void a() {
        this.f5025c.clear();
        o();
        q();
        a aVar = this.f5032j;
        if (aVar != null) {
            this.f5026d.a((p<?>) aVar);
            this.f5032j = null;
        }
        a aVar2 = this.f5034l;
        if (aVar2 != null) {
            this.f5026d.a((p<?>) aVar2);
            this.f5034l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f5026d.a((p<?>) aVar3);
            this.o = null;
        }
        this.f5023a.clear();
        this.f5033k = true;
    }

    @VisibleForTesting
    void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f5029g = false;
        if (this.f5033k) {
            this.f5024b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f5028f) {
            this.o = aVar;
            return;
        }
        if (aVar.b() != null) {
            o();
            a aVar2 = this.f5032j;
            this.f5032j = aVar;
            for (int size = this.f5025c.size() - 1; size >= 0; size--) {
                this.f5025c.get(size).a();
            }
            if (aVar2 != null) {
                this.f5024b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        n();
    }

    private static j<Bitmap> a(k kVar, int i2, int i3) {
        return kVar.b().a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f4571b).c(true).b(true).a(i2, i3));
    }
}
