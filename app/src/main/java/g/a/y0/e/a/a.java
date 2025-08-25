package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CompletableAmb.java */
/* loaded from: classes2.dex */
public final class a extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    private final g.a.i[] f13982a;

    /* renamed from: b, reason: collision with root package name */
    private final Iterable<? extends g.a.i> f13983b;

    /* compiled from: CompletableAmb.java */
    /* renamed from: g.a.y0.e.a.a$a, reason: collision with other inner class name */
    static final class C0181a implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f13984a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.u0.b f13985b;

        /* renamed from: c, reason: collision with root package name */
        private final g.a.f f13986c;

        C0181a(AtomicBoolean atomicBoolean, g.a.u0.b bVar, g.a.f fVar) {
            this.f13984a = atomicBoolean;
            this.f13985b = bVar;
            this.f13986c = fVar;
        }

        @Override // g.a.f
        public void onComplete() {
            if (this.f13984a.compareAndSet(false, true)) {
                this.f13985b.dispose();
                this.f13986c.onComplete();
            }
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            if (!this.f13984a.compareAndSet(false, true)) {
                g.a.c1.a.b(th);
            } else {
                this.f13985b.dispose();
                this.f13986c.onError(th);
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f13985b.b(cVar);
        }
    }

    public a(g.a.i[] iVarArr, Iterable<? extends g.a.i> iterable) {
        this.f13982a = iVarArr;
        this.f13983b = iterable;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        int length;
        g.a.i[] iVarArr = this.f13982a;
        if (iVarArr == null) {
            iVarArr = new g.a.i[8];
            try {
                length = 0;
                for (g.a.i iVar : this.f13983b) {
                    if (iVar == null) {
                        g.a.y0.a.e.error(new NullPointerException("One of the sources is null"), fVar);
                        return;
                    }
                    if (length == iVarArr.length) {
                        g.a.i[] iVarArr2 = new g.a.i[(length >> 2) + length];
                        System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                        iVarArr = iVarArr2;
                    }
                    int i2 = length + 1;
                    iVarArr[length] = iVar;
                    length = i2;
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.y0.a.e.error(th, fVar);
                return;
            }
        } else {
            length = iVarArr.length;
        }
        g.a.u0.b bVar = new g.a.u0.b();
        fVar.onSubscribe(bVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        C0181a c0181a = new C0181a(atomicBoolean, bVar, fVar);
        for (int i3 = 0; i3 < length; i3++) {
            g.a.i iVar2 = iVarArr[i3];
            if (bVar.isDisposed()) {
                return;
            }
            if (iVar2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (!atomicBoolean.compareAndSet(false, true)) {
                    g.a.c1.a.b(nullPointerException);
                    return;
                } else {
                    bVar.dispose();
                    fVar.onError(nullPointerException);
                    return;
                }
            }
            iVar2.a(c0181a);
        }
        if (length == 0) {
            fVar.onComplete();
        }
    }
}
