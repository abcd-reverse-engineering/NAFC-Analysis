package g.a.u0;

import g.a.y0.j.k;
import g.a.y0.j.s;
import java.util.ArrayList;

/* compiled from: CompositeDisposable.java */
/* loaded from: classes2.dex */
public final class b implements c, g.a.y0.a.c {

    /* renamed from: a, reason: collision with root package name */
    s<c> f13874a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f13875b;

    public b() {
    }

    public boolean a(@g.a.t0.f c... cVarArr) {
        g.a.y0.b.b.a(cVarArr, "ds is null");
        if (!this.f13875b) {
            synchronized (this) {
                if (!this.f13875b) {
                    s<c> sVar = this.f13874a;
                    if (sVar == null) {
                        sVar = new s<>(cVarArr.length + 1);
                        this.f13874a = sVar;
                    }
                    for (c cVar : cVarArr) {
                        g.a.y0.b.b.a(cVar, "d is null");
                        sVar.a((s<c>) cVar);
                    }
                    return true;
                }
            }
        }
        for (c cVar2 : cVarArr) {
            cVar2.dispose();
        }
        return false;
    }

    @Override // g.a.y0.a.c
    public boolean b(@g.a.t0.f c cVar) {
        g.a.y0.b.b.a(cVar, "d is null");
        if (!this.f13875b) {
            synchronized (this) {
                if (!this.f13875b) {
                    s<c> sVar = this.f13874a;
                    if (sVar == null) {
                        sVar = new s<>();
                        this.f13874a = sVar;
                    }
                    sVar.a((s<c>) cVar);
                    return true;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // g.a.y0.a.c
    public boolean c(@g.a.t0.f c cVar) {
        g.a.y0.b.b.a(cVar, "Disposable item is null");
        if (this.f13875b) {
            return false;
        }
        synchronized (this) {
            if (this.f13875b) {
                return false;
            }
            s<c> sVar = this.f13874a;
            if (sVar != null && sVar.b(cVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // g.a.u0.c
    public void dispose() {
        if (this.f13875b) {
            return;
        }
        synchronized (this) {
            if (this.f13875b) {
                return;
            }
            this.f13875b = true;
            s<c> sVar = this.f13874a;
            this.f13874a = null;
            a(sVar);
        }
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f13875b;
    }

    public b(@g.a.t0.f c... cVarArr) {
        g.a.y0.b.b.a(cVarArr, "resources is null");
        this.f13874a = new s<>(cVarArr.length + 1);
        for (c cVar : cVarArr) {
            g.a.y0.b.b.a(cVar, "Disposable item is null");
            this.f13874a.a((s<c>) cVar);
        }
    }

    public b(@g.a.t0.f Iterable<? extends c> iterable) {
        g.a.y0.b.b.a(iterable, "resources is null");
        this.f13874a = new s<>();
        for (c cVar : iterable) {
            g.a.y0.b.b.a(cVar, "Disposable item is null");
            this.f13874a.a((s<c>) cVar);
        }
    }

    public int b() {
        if (this.f13875b) {
            return 0;
        }
        synchronized (this) {
            if (this.f13875b) {
                return 0;
            }
            s<c> sVar = this.f13874a;
            return sVar != null ? sVar.c() : 0;
        }
    }

    @Override // g.a.y0.a.c
    public boolean a(@g.a.t0.f c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    public void a() {
        if (this.f13875b) {
            return;
        }
        synchronized (this) {
            if (this.f13875b) {
                return;
            }
            s<c> sVar = this.f13874a;
            this.f13874a = null;
            a(sVar);
        }
    }

    void a(s<c> sVar) {
        if (sVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : sVar.a()) {
            if (obj instanceof c) {
                try {
                    ((c) obj).dispose();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw k.c((Throwable) arrayList.get(0));
            }
            throw new g.a.v0.a(arrayList);
        }
    }
}
