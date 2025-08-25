package com.bumptech.glide.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.k;
import com.bumptech.glide.load.p.q;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.r.l.o;
import com.bumptech.glide.r.l.p;
import com.bumptech.glide.util.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: SingleRequest.java */
/* loaded from: classes.dex */
public final class j<R> implements d, o, i {
    private static final String E = "Glide";

    @GuardedBy("requestLock")
    private int A;

    @GuardedBy("requestLock")
    private boolean B;

    @Nullable
    private RuntimeException C;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f5243a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.util.n.c f5244b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f5245c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final g<R> f5246d;

    /* renamed from: e, reason: collision with root package name */
    private final e f5247e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f5248f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.d f5249g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private final Object f5250h;

    /* renamed from: i, reason: collision with root package name */
    private final Class<R> f5251i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.r.a<?> f5252j;

    /* renamed from: k, reason: collision with root package name */
    private final int f5253k;

    /* renamed from: l, reason: collision with root package name */
    private final int f5254l;

    /* renamed from: m, reason: collision with root package name */
    private final com.bumptech.glide.h f5255m;
    private final p<R> n;

    @Nullable
    private final List<g<R>> o;
    private final com.bumptech.glide.r.m.g<? super R> p;
    private final Executor q;

    @GuardedBy("requestLock")
    private v<R> r;

    @GuardedBy("requestLock")
    private k.d s;

    @GuardedBy("requestLock")
    private long t;
    private volatile com.bumptech.glide.load.p.k u;

    @GuardedBy("requestLock")
    private a v;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable w;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable x;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable y;

    @GuardedBy("requestLock")
    private int z;
    private static final String D = "Request";
    private static final boolean F = Log.isLoggable(D, 2);

    /* compiled from: SingleRequest.java */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private j(Context context, com.bumptech.glide.d dVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, com.bumptech.glide.r.a<?> aVar, int i2, int i3, com.bumptech.glide.h hVar, p<R> pVar, @Nullable g<R> gVar, @Nullable List<g<R>> list, e eVar, com.bumptech.glide.load.p.k kVar, com.bumptech.glide.r.m.g<? super R> gVar2, Executor executor) {
        this.f5243a = F ? String.valueOf(super.hashCode()) : null;
        this.f5244b = com.bumptech.glide.util.n.c.b();
        this.f5245c = obj;
        this.f5248f = context;
        this.f5249g = dVar;
        this.f5250h = obj2;
        this.f5251i = cls;
        this.f5252j = aVar;
        this.f5253k = i2;
        this.f5254l = i3;
        this.f5255m = hVar;
        this.n = pVar;
        this.f5246d = gVar;
        this.o = list;
        this.f5247e = eVar;
        this.u = kVar;
        this.p = gVar2;
        this.q = executor;
        this.v = a.PENDING;
        if (this.C == null && dVar.g()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> j<R> a(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class<R> cls, com.bumptech.glide.r.a<?> aVar, int i2, int i3, com.bumptech.glide.h hVar, p<R> pVar, g<R> gVar, @Nullable List<g<R>> list, e eVar, com.bumptech.glide.load.p.k kVar, com.bumptech.glide.r.m.g<? super R> gVar2, Executor executor) {
        return new j<>(context, dVar, obj, obj2, cls, aVar, i2, i3, hVar, pVar, gVar, list, eVar, kVar, gVar2, executor);
    }

    @GuardedBy("requestLock")
    private void f() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean g() {
        e eVar = this.f5247e;
        return eVar == null || eVar.f(this);
    }

    @GuardedBy("requestLock")
    private boolean h() {
        e eVar = this.f5247e;
        return eVar == null || eVar.c(this);
    }

    @GuardedBy("requestLock")
    private boolean i() {
        e eVar = this.f5247e;
        return eVar == null || eVar.d(this);
    }

    @GuardedBy("requestLock")
    private void j() {
        f();
        this.f5244b.a();
        this.n.a((o) this);
        k.d dVar = this.s;
        if (dVar != null) {
            dVar.a();
            this.s = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable k() {
        if (this.w == null) {
            this.w = this.f5252j.k();
            if (this.w == null && this.f5252j.j() > 0) {
                this.w = a(this.f5252j.j());
            }
        }
        return this.w;
    }

    @GuardedBy("requestLock")
    private Drawable l() {
        if (this.y == null) {
            this.y = this.f5252j.l();
            if (this.y == null && this.f5252j.m() > 0) {
                this.y = a(this.f5252j.m());
            }
        }
        return this.y;
    }

    @GuardedBy("requestLock")
    private Drawable m() {
        if (this.x == null) {
            this.x = this.f5252j.r();
            if (this.x == null && this.f5252j.s() > 0) {
                this.x = a(this.f5252j.s());
            }
        }
        return this.x;
    }

    @GuardedBy("requestLock")
    private boolean n() {
        e eVar = this.f5247e;
        return eVar == null || !eVar.getRoot().a();
    }

    @GuardedBy("requestLock")
    private void o() {
        e eVar = this.f5247e;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    @GuardedBy("requestLock")
    private void p() {
        e eVar = this.f5247e;
        if (eVar != null) {
            eVar.e(this);
        }
    }

    @GuardedBy("requestLock")
    private void q() {
        if (h()) {
            Drawable drawableL = this.f5250h == null ? l() : null;
            if (drawableL == null) {
                drawableL = k();
            }
            if (drawableL == null) {
                drawableL = m();
            }
            this.n.a(drawableL);
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean b() {
        boolean z;
        synchronized (this.f5245c) {
            z = this.v == a.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void c() {
        synchronized (this.f5245c) {
            f();
            this.f5244b.a();
            this.t = com.bumptech.glide.util.f.a();
            if (this.f5250h == null) {
                if (l.b(this.f5253k, this.f5254l)) {
                    this.z = this.f5253k;
                    this.A = this.f5254l;
                }
                a(new q("Received null model"), l() == null ? 5 : 3);
                return;
            }
            if (this.v == a.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (this.v == a.COMPLETE) {
                a((v<?>) this.r, com.bumptech.glide.load.a.MEMORY_CACHE);
                return;
            }
            this.v = a.WAITING_FOR_SIZE;
            if (l.b(this.f5253k, this.f5254l)) {
                a(this.f5253k, this.f5254l);
            } else {
                this.n.b(this);
            }
            if ((this.v == a.RUNNING || this.v == a.WAITING_FOR_SIZE) && h()) {
                this.n.b(m());
            }
            if (F) {
                a("finished run method in " + com.bumptech.glide.util.f.a(this.t));
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public void clear() {
        v<R> vVar;
        synchronized (this.f5245c) {
            f();
            this.f5244b.a();
            if (this.v == a.CLEARED) {
                return;
            }
            j();
            if (this.r != null) {
                vVar = this.r;
                this.r = null;
            } else {
                vVar = null;
            }
            if (g()) {
                this.n.c(m());
            }
            this.v = a.CLEARED;
            if (vVar != null) {
                this.u.b((v<?>) vVar);
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean d() {
        boolean z;
        synchronized (this.f5245c) {
            z = this.v == a.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.i
    public Object e() {
        this.f5244b.a();
        return this.f5245c;
    }

    @Override // com.bumptech.glide.r.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f5245c) {
            z = this.v == a.RUNNING || this.v == a.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void pause() {
        synchronized (this.f5245c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean a() {
        boolean z;
        synchronized (this.f5245c) {
            z = this.v == a.COMPLETE;
        }
        return z;
    }

    @GuardedBy("requestLock")
    private Drawable a(@DrawableRes int i2) {
        return com.bumptech.glide.load.r.f.a.a(this.f5249g, i2, this.f5252j.x() != null ? this.f5252j.x() : this.f5248f.getTheme());
    }

    @Override // com.bumptech.glide.r.l.o
    public void a(int i2, int i3) throws Throwable {
        Object obj;
        this.f5244b.a();
        Object obj2 = this.f5245c;
        synchronized (obj2) {
            try {
                try {
                    if (F) {
                        a("Got onSizeReady in " + com.bumptech.glide.util.f.a(this.t));
                    }
                    if (this.v == a.WAITING_FOR_SIZE) {
                        this.v = a.RUNNING;
                        float fW = this.f5252j.w();
                        this.z = a(i2, fW);
                        this.A = a(i3, fW);
                        if (F) {
                            a("finished setup for calling load in " + com.bumptech.glide.util.f.a(this.t));
                        }
                        obj = obj2;
                        try {
                            this.s = this.u.a(this.f5249g, this.f5250h, this.f5252j.v(), this.z, this.A, this.f5252j.u(), this.f5251i, this.f5255m, this.f5252j.i(), this.f5252j.y(), this.f5252j.J(), this.f5252j.G(), this.f5252j.o(), this.f5252j.E(), this.f5252j.A(), this.f5252j.z(), this.f5252j.n(), this, this.q);
                            if (this.v != a.RUNNING) {
                                this.s = null;
                            }
                            if (F) {
                                a("finished onSizeReady in " + com.bumptech.glide.util.f.a(this.t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r6 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        r5.u.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ad, code lost:
    
        if (r6 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
    
        r5.u.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.r.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.bumptech.glide.load.p.v<?> r6, com.bumptech.glide.load.a r7) throws java.lang.Throwable {
        /*
            r5 = this;
            com.bumptech.glide.util.n.c r0 = r5.f5244b
            r0.a()
            r0 = 0
            java.lang.Object r1 = r5.f5245c     // Catch: java.lang.Throwable -> Lbf
            monitor-enter(r1)     // Catch: java.lang.Throwable -> Lbf
            r5.s = r0     // Catch: java.lang.Throwable -> Lb5
            if (r6 != 0) goto L2f
            com.bumptech.glide.load.p.q r6 = new com.bumptech.glide.load.p.q     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            r7.<init>()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r2 = "Expected to receive a Resource<R> with an object of "
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.Class<R> r2 = r5.f5251i     // Catch: java.lang.Throwable -> Lb5
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r2 = " inside, but instead got null."
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb5
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lb5
            r5.a(r6)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb5
            return
        L2f:
            java.lang.Object r2 = r6.get()     // Catch: java.lang.Throwable -> Lb5
            if (r2 == 0) goto L5c
            java.lang.Class<R> r3 = r5.f5251i     // Catch: java.lang.Throwable -> Lb5
            java.lang.Class r4 = r2.getClass()     // Catch: java.lang.Throwable -> Lb5
            boolean r3 = r3.isAssignableFrom(r4)     // Catch: java.lang.Throwable -> Lb5
            if (r3 != 0) goto L42
            goto L5c
        L42:
            boolean r3 = r5.i()     // Catch: java.lang.Throwable -> Lb5
            if (r3 != 0) goto L57
            r5.r = r0     // Catch: java.lang.Throwable -> Lbd
            com.bumptech.glide.r.j$a r7 = com.bumptech.glide.r.j.a.COMPLETE     // Catch: java.lang.Throwable -> Lbd
            r5.v = r7     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbd
            if (r6 == 0) goto L56
            com.bumptech.glide.load.p.k r7 = r5.u
            r7.b(r6)
        L56:
            return
        L57:
            r5.a(r6, r2, r7)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb5
            return
        L5c:
            r5.r = r0     // Catch: java.lang.Throwable -> Lbd
            com.bumptech.glide.load.p.q r7 = new com.bumptech.glide.load.p.q     // Catch: java.lang.Throwable -> Lbd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbd
            r0.<init>()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = "Expected to receive an object of "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            java.lang.Class<R> r3 = r5.f5251i     // Catch: java.lang.Throwable -> Lbd
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = " but instead got "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            if (r2 == 0) goto L7b
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Throwable -> Lbd
            goto L7d
        L7b:
            java.lang.String r3 = ""
        L7d:
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = "{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            r0.append(r2)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = "} inside Resource{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            r0.append(r6)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = "}."
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            if (r2 == 0) goto L9d
            java.lang.String r2 = ""
            goto L9f
        L9d:
            java.lang.String r2 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L9f:
            r0.append(r2)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lbd
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lbd
            r5.a(r7)     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbd
            if (r6 == 0) goto Lb4
            com.bumptech.glide.load.p.k r7 = r5.u
            r7.b(r6)
        Lb4:
            return
        Lb5:
            r6 = move-exception
            r7 = r6
            r6 = r0
        Lb8:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbd
            throw r7     // Catch: java.lang.Throwable -> Lba
        Lba:
            r7 = move-exception
            r0 = r6
            goto Lc0
        Lbd:
            r7 = move-exception
            goto Lb8
        Lbf:
            r7 = move-exception
        Lc0:
            if (r0 == 0) goto Lc7
            com.bumptech.glide.load.p.k r6 = r5.u
            r6.b(r0)
        Lc7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.r.j.a(com.bumptech.glide.load.p.v, com.bumptech.glide.load.a):void");
    }

    @GuardedBy("requestLock")
    private void a(v<R> vVar, R r, com.bumptech.glide.load.a aVar) {
        boolean zA;
        boolean zN = n();
        this.v = a.COMPLETE;
        this.r = vVar;
        if (this.f5249g.e() <= 3) {
            String str = "Finished loading " + r.getClass().getSimpleName() + " from " + aVar + " for " + this.f5250h + " with size [" + this.z + "x" + this.A + "] in " + com.bumptech.glide.util.f.a(this.t) + " ms";
        }
        boolean z = true;
        this.B = true;
        try {
            if (this.o != null) {
                Iterator<g<R>> it = this.o.iterator();
                zA = false;
                while (it.hasNext()) {
                    zA |= it.next().a(r, this.f5250h, this.n, aVar, zN);
                }
            } else {
                zA = false;
            }
            if (this.f5246d == null || !this.f5246d.a(r, this.f5250h, this.n, aVar, zN)) {
                z = false;
            }
            if (!(z | zA)) {
                this.n.a(r, this.p.a(aVar, zN));
            }
            this.B = false;
            p();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.r.i
    public void a(q qVar) {
        a(qVar, 5);
    }

    private void a(q qVar, int i2) {
        boolean zA;
        this.f5244b.a();
        synchronized (this.f5245c) {
            qVar.setOrigin(this.C);
            int iE = this.f5249g.e();
            if (iE <= i2) {
                String str = "Load failed for " + this.f5250h + " with size [" + this.z + "x" + this.A + "]";
                if (iE <= 4) {
                    qVar.logRootCauses(E);
                }
            }
            this.s = null;
            this.v = a.FAILED;
            boolean z = true;
            this.B = true;
            try {
                if (this.o != null) {
                    Iterator<g<R>> it = this.o.iterator();
                    zA = false;
                    while (it.hasNext()) {
                        zA |= it.next().a(qVar, this.f5250h, this.n, n());
                    }
                } else {
                    zA = false;
                }
                if (this.f5246d == null || !this.f5246d.a(qVar, this.f5250h, this.n, n())) {
                    z = false;
                }
                if (!(zA | z)) {
                    q();
                }
                this.B = false;
                o();
            } catch (Throwable th) {
                this.B = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean a(d dVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        com.bumptech.glide.r.a<?> aVar;
        com.bumptech.glide.h hVar;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        com.bumptech.glide.r.a<?> aVar2;
        com.bumptech.glide.h hVar2;
        int size2;
        if (!(dVar instanceof j)) {
            return false;
        }
        synchronized (this.f5245c) {
            i2 = this.f5253k;
            i3 = this.f5254l;
            obj = this.f5250h;
            cls = this.f5251i;
            aVar = this.f5252j;
            hVar = this.f5255m;
            size = this.o != null ? this.o.size() : 0;
        }
        j jVar = (j) dVar;
        synchronized (jVar.f5245c) {
            i4 = jVar.f5253k;
            i5 = jVar.f5254l;
            obj2 = jVar.f5250h;
            cls2 = jVar.f5251i;
            aVar2 = jVar.f5252j;
            hVar2 = jVar.f5255m;
            size2 = jVar.o != null ? jVar.o.size() : 0;
        }
        return i2 == i4 && i3 == i5 && l.a(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && hVar == hVar2 && size == size2;
    }

    private void a(String str) {
        String str2 = str + " this: " + this.f5243a;
    }
}
