package com.bumptech.glide.load.p;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.i;
import com.bumptech.glide.load.p.f;
import com.bumptech.glide.load.p.i;
import com.bumptech.glide.util.n.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {
    private static final String F = "DecodeJob";
    private com.bumptech.glide.load.a A;
    private com.bumptech.glide.load.o.d<?> B;
    private volatile com.bumptech.glide.load.p.f C;
    private volatile boolean D;
    private volatile boolean E;

    /* renamed from: d, reason: collision with root package name */
    private final e f4541d;

    /* renamed from: e, reason: collision with root package name */
    private final Pools.Pool<h<?>> f4542e;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.d f4545h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.g f4546i;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.h f4547j;

    /* renamed from: k, reason: collision with root package name */
    private n f4548k;

    /* renamed from: l, reason: collision with root package name */
    private int f4549l;

    /* renamed from: m, reason: collision with root package name */
    private int f4550m;
    private j n;
    private com.bumptech.glide.load.j o;
    private b<R> p;
    private int q;
    private EnumC0065h r;
    private g s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.bumptech.glide.load.g x;
    private com.bumptech.glide.load.g y;
    private Object z;

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.p.g<R> f4538a = new com.bumptech.glide.load.p.g<>();

    /* renamed from: b, reason: collision with root package name */
    private final List<Throwable> f4539b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.util.n.c f4540c = com.bumptech.glide.util.n.c.b();

    /* renamed from: f, reason: collision with root package name */
    private final d<?> f4543f = new d<>();

    /* renamed from: g, reason: collision with root package name */
    private final f f4544g = new f();

    /* compiled from: DecodeJob.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4551a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4552b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f4553c = new int[com.bumptech.glide.load.c.values().length];

        static {
            try {
                f4553c[com.bumptech.glide.load.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4553c[com.bumptech.glide.load.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f4552b = new int[EnumC0065h.values().length];
            try {
                f4552b[EnumC0065h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4552b[EnumC0065h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4552b[EnumC0065h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4552b[EnumC0065h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4552b[EnumC0065h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            f4551a = new int[g.values().length];
            try {
                f4551a[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4551a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4551a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: DecodeJob.java */
    interface b<R> {
        void a(h<?> hVar);

        void a(q qVar);

        void a(v<R> vVar, com.bumptech.glide.load.a aVar);
    }

    /* compiled from: DecodeJob.java */
    private final class c<Z> implements i.a<Z> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.a f4554a;

        c(com.bumptech.glide.load.a aVar) {
            this.f4554a = aVar;
        }

        @Override // com.bumptech.glide.load.p.i.a
        @NonNull
        public v<Z> a(@NonNull v<Z> vVar) {
            return h.this.a(this.f4554a, vVar);
        }
    }

    /* compiled from: DecodeJob.java */
    interface e {
        com.bumptech.glide.load.p.b0.a a();
    }

    /* compiled from: DecodeJob.java */
    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$h, reason: collision with other inner class name */
    private enum EnumC0065h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    h(e eVar, Pools.Pool<h<?>> pool) {
        this.f4541d = eVar;
        this.f4542e = pool;
    }

    private void e() {
        if (Log.isLoggable(F, 2)) {
            a("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        v<R> vVarA = null;
        try {
            vVarA = a(this.B, (com.bumptech.glide.load.o.d<?>) this.z, this.A);
        } catch (q e2) {
            e2.setLoggingDetails(this.y, this.A);
            this.f4539b.add(e2);
        }
        if (vVarA != null) {
            b(vVarA, this.A);
        } else {
            l();
        }
    }

    private com.bumptech.glide.load.p.f f() {
        int i2 = a.f4552b[this.r.ordinal()];
        if (i2 == 1) {
            return new w(this.f4538a, this);
        }
        if (i2 == 2) {
            return new com.bumptech.glide.load.p.c(this.f4538a, this);
        }
        if (i2 == 3) {
            return new z(this.f4538a, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    private int g() {
        return this.f4547j.ordinal();
    }

    private void h() {
        n();
        this.p.a(new q("Failed to load resource", new ArrayList(this.f4539b)));
        j();
    }

    private void i() {
        if (this.f4544g.a()) {
            k();
        }
    }

    private void j() {
        if (this.f4544g.b()) {
            k();
        }
    }

    private void k() {
        this.f4544g.c();
        this.f4543f.a();
        this.f4538a.a();
        this.D = false;
        this.f4545h = null;
        this.f4546i = null;
        this.o = null;
        this.f4547j = null;
        this.f4548k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.f4539b.clear();
        this.f4542e.release(this);
    }

    private void l() {
        this.w = Thread.currentThread();
        this.t = com.bumptech.glide.util.f.a();
        boolean zA = false;
        while (!this.E && this.C != null && !(zA = this.C.a())) {
            this.r = a(this.r);
            this.C = f();
            if (this.r == EnumC0065h.SOURCE) {
                b();
                return;
            }
        }
        if ((this.r == EnumC0065h.FINISHED || this.E) && !zA) {
            h();
        }
    }

    private void m() {
        int i2 = a.f4551a[this.s.ordinal()];
        if (i2 == 1) {
            this.r = a(EnumC0065h.INITIALIZE);
            this.C = f();
            l();
        } else if (i2 == 2) {
            l();
        } else {
            if (i2 == 3) {
                e();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private void n() {
        Throwable th;
        this.f4540c.a();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.f4539b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f4539b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    h<R> a(com.bumptech.glide.d dVar, Object obj, n nVar, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.j jVar2, b<R> bVar, int i4) {
        this.f4538a.a(dVar, obj, gVar, i2, i3, jVar, cls, cls2, hVar, jVar2, map, z, z2, this.f4541d);
        this.f4545h = dVar;
        this.f4546i = gVar;
        this.f4547j = hVar;
        this.f4548k = nVar;
        this.f4549l = i2;
        this.f4550m = i3;
        this.n = jVar;
        this.u = z3;
        this.o = jVar2;
        this.p = bVar;
        this.q = i4;
        this.s = g.INITIALIZE;
        this.v = obj;
        return this;
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void b() {
        this.s = g.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((h<?>) this);
    }

    @Override // com.bumptech.glide.util.n.a.f
    @NonNull
    public com.bumptech.glide.util.n.c c() {
        return this.f4540c;
    }

    boolean d() {
        EnumC0065h enumC0065hA = a(EnumC0065h.INITIALIZE);
        return enumC0065hA == EnumC0065h.RESOURCE_CACHE || enumC0065hA == EnumC0065h.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.util.n.b.a("DecodeJob#run(model=%s)", this.v);
        com.bumptech.glide.load.o.d<?> dVar = this.B;
        try {
            try {
                try {
                    if (this.E) {
                        h();
                        if (dVar != null) {
                            dVar.b();
                        }
                        com.bumptech.glide.util.n.b.a();
                        return;
                    }
                    m();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.bumptech.glide.util.n.b.a();
                } catch (com.bumptech.glide.load.p.b e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                if (Log.isLoggable(F, 3)) {
                    String str = "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r;
                }
                if (this.r != EnumC0065h.ENCODE) {
                    this.f4539b.add(th);
                    h();
                }
                if (!this.E) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.util.n.b.a();
            throw th2;
        }
    }

    /* compiled from: DecodeJob.java */
    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4559a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f4560b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4561c;

        f() {
        }

        synchronized boolean a(boolean z) {
            this.f4559a = true;
            return b(z);
        }

        synchronized boolean b() {
            this.f4561c = true;
            return b(false);
        }

        synchronized void c() {
            this.f4560b = false;
            this.f4559a = false;
            this.f4561c = false;
        }

        private boolean b(boolean z) {
            return (this.f4561c || z || this.f4560b) && this.f4559a;
        }

        synchronized boolean a() {
            this.f4560b = true;
            return b(false);
        }
    }

    /* compiled from: DecodeJob.java */
    private static class d<Z> {

        /* renamed from: a, reason: collision with root package name */
        private com.bumptech.glide.load.g f4556a;

        /* renamed from: b, reason: collision with root package name */
        private com.bumptech.glide.load.m<Z> f4557b;

        /* renamed from: c, reason: collision with root package name */
        private u<Z> f4558c;

        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.bumptech.glide.load.g gVar, com.bumptech.glide.load.m<X> mVar, u<X> uVar) {
            this.f4556a = gVar;
            this.f4557b = mVar;
            this.f4558c = uVar;
        }

        boolean b() {
            return this.f4558c != null;
        }

        void a(e eVar, com.bumptech.glide.load.j jVar) {
            com.bumptech.glide.util.n.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f4556a, new com.bumptech.glide.load.p.e(this.f4557b, this.f4558c, jVar));
            } finally {
                this.f4558c.d();
                com.bumptech.glide.util.n.b.a();
            }
        }

        void a() {
            this.f4556a = null;
            this.f4557b = null;
            this.f4558c = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(v<R> vVar, com.bumptech.glide.load.a aVar) {
        if (vVar instanceof r) {
            ((r) vVar).c();
        }
        u uVar = 0;
        if (this.f4543f.b()) {
            vVar = u.b(vVar);
            uVar = vVar;
        }
        a((v) vVar, aVar);
        this.r = EnumC0065h.ENCODE;
        try {
            if (this.f4543f.b()) {
                this.f4543f.a(this.f4541d, this.o);
            }
            i();
        } finally {
            if (uVar != 0) {
                uVar.d();
            }
        }
    }

    void a(boolean z) {
        if (this.f4544g.a(z)) {
            k();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull h<?> hVar) {
        int iG = g() - hVar.g();
        return iG == 0 ? this.q - hVar.q : iG;
    }

    public void a() {
        this.E = true;
        com.bumptech.glide.load.p.f fVar = this.C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    private void a(v<R> vVar, com.bumptech.glide.load.a aVar) {
        n();
        this.p.a(vVar, aVar);
    }

    private EnumC0065h a(EnumC0065h enumC0065h) {
        int i2 = a.f4552b[enumC0065h.ordinal()];
        if (i2 == 1) {
            if (this.n.a()) {
                return EnumC0065h.DATA_CACHE;
            }
            return a(EnumC0065h.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.u ? EnumC0065h.FINISHED : EnumC0065h.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return EnumC0065h.FINISHED;
        }
        if (i2 == 5) {
            if (this.n.b()) {
                return EnumC0065h.RESOURCE_CACHE;
            }
            return a(EnumC0065h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0065h);
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void a(com.bumptech.glide.load.g gVar, Object obj, com.bumptech.glide.load.o.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.g gVar2) {
        this.x = gVar;
        this.z = obj;
        this.B = dVar;
        this.A = aVar;
        this.y = gVar2;
        if (Thread.currentThread() != this.w) {
            this.s = g.DECODE_DATA;
            this.p.a((h<?>) this);
        } else {
            com.bumptech.glide.util.n.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                e();
            } finally {
                com.bumptech.glide.util.n.b.a();
            }
        }
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void a(com.bumptech.glide.load.g gVar, Exception exc, com.bumptech.glide.load.o.d<?> dVar, com.bumptech.glide.load.a aVar) {
        dVar.b();
        q qVar = new q("Fetching data failed", exc);
        qVar.setLoggingDetails(gVar, aVar, dVar.a());
        this.f4539b.add(qVar);
        if (Thread.currentThread() != this.w) {
            this.s = g.SWITCH_TO_SOURCE_SERVICE;
            this.p.a((h<?>) this);
        } else {
            l();
        }
    }

    private <Data> v<R> a(com.bumptech.glide.load.o.d<?> dVar, Data data, com.bumptech.glide.load.a aVar) throws q {
        if (data == null) {
            return null;
        }
        try {
            long jA = com.bumptech.glide.util.f.a();
            v<R> vVarA = a((h<R>) data, aVar);
            if (Log.isLoggable(F, 2)) {
                a("Decoded result " + vVarA, jA);
            }
            return vVarA;
        } finally {
            dVar.b();
        }
    }

    private <Data> v<R> a(Data data, com.bumptech.glide.load.a aVar) throws q {
        return a((h<R>) data, aVar, (t<h<R>, ResourceType, R>) this.f4538a.a((Class) data.getClass()));
    }

    @NonNull
    private com.bumptech.glide.load.j a(com.bumptech.glide.load.a aVar) {
        com.bumptech.glide.load.j jVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return jVar;
        }
        boolean z = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.f4538a.o();
        Boolean bool = (Boolean) jVar.a(com.bumptech.glide.load.r.d.q.f4932k);
        if (bool != null && (!bool.booleanValue() || z)) {
            return jVar;
        }
        com.bumptech.glide.load.j jVar2 = new com.bumptech.glide.load.j();
        jVar2.a(this.o);
        jVar2.a(com.bumptech.glide.load.r.d.q.f4932k, Boolean.valueOf(z));
        return jVar2;
    }

    private <Data, ResourceType> v<R> a(Data data, com.bumptech.glide.load.a aVar, t<Data, ResourceType, R> tVar) throws q {
        com.bumptech.glide.load.j jVarA = a(aVar);
        com.bumptech.glide.load.o.e<Data> eVarB = this.f4545h.f().b((com.bumptech.glide.i) data);
        try {
            return tVar.a(eVarB, jVarA, this.f4549l, this.f4550m, new c(aVar));
        } finally {
            eVarB.b();
        }
    }

    private void a(String str, long j2) {
        a(str, j2, (String) null);
    }

    private void a(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.util.f.a(j2));
        sb.append(", load key: ");
        sb.append(this.f4548k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.toString();
    }

    @NonNull
    <Z> v<Z> a(com.bumptech.glide.load.a aVar, @NonNull v<Z> vVar) {
        v<Z> vVarA;
        com.bumptech.glide.load.n<Z> nVar;
        com.bumptech.glide.load.c cVarA;
        com.bumptech.glide.load.g dVar;
        Class<?> cls = vVar.get().getClass();
        com.bumptech.glide.load.m<Z> mVarA = null;
        if (aVar != com.bumptech.glide.load.a.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.n<Z> nVarB = this.f4538a.b(cls);
            nVar = nVarB;
            vVarA = nVarB.a(this.f4545h, vVar, this.f4549l, this.f4550m);
        } else {
            vVarA = vVar;
            nVar = null;
        }
        if (!vVar.equals(vVarA)) {
            vVar.recycle();
        }
        if (this.f4538a.b((v<?>) vVarA)) {
            mVarA = this.f4538a.a((v) vVarA);
            cVarA = mVarA.a(this.o);
        } else {
            cVarA = com.bumptech.glide.load.c.NONE;
        }
        com.bumptech.glide.load.m mVar = mVarA;
        if (!this.n.a(!this.f4538a.a(this.x), aVar, cVarA)) {
            return vVarA;
        }
        if (mVar != null) {
            int i2 = a.f4553c[cVarA.ordinal()];
            if (i2 == 1) {
                dVar = new com.bumptech.glide.load.p.d(this.x, this.f4546i);
            } else if (i2 == 2) {
                dVar = new x(this.f4538a.b(), this.x, this.f4546i, this.f4549l, this.f4550m, nVar, cls, this.o);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + cVarA);
            }
            u uVarB = u.b(vVarA);
            this.f4543f.a(dVar, mVar, uVarB);
            return uVarB;
        }
        throw new i.d(vVarA.get().getClass());
    }
}
