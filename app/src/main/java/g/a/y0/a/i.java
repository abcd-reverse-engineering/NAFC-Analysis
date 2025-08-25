package g.a.y0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes2.dex */
public final class i implements g.a.u0.c, c {

    /* renamed from: a, reason: collision with root package name */
    List<g.a.u0.c> f13895a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f13896b;

    public i() {
    }

    public boolean a(g.a.u0.c... cVarArr) {
        g.a.y0.b.b.a(cVarArr, "ds is null");
        if (!this.f13896b) {
            synchronized (this) {
                if (!this.f13896b) {
                    List linkedList = this.f13895a;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f13895a = linkedList;
                    }
                    for (g.a.u0.c cVar : cVarArr) {
                        g.a.y0.b.b.a(cVar, "d is null");
                        linkedList.add(cVar);
                    }
                    return true;
                }
            }
        }
        for (g.a.u0.c cVar2 : cVarArr) {
            cVar2.dispose();
        }
        return false;
    }

    @Override // g.a.y0.a.c
    public boolean b(g.a.u0.c cVar) {
        g.a.y0.b.b.a(cVar, "d is null");
        if (!this.f13896b) {
            synchronized (this) {
                if (!this.f13896b) {
                    List linkedList = this.f13895a;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f13895a = linkedList;
                    }
                    linkedList.add(cVar);
                    return true;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // g.a.y0.a.c
    public boolean c(g.a.u0.c cVar) {
        g.a.y0.b.b.a(cVar, "Disposable item is null");
        if (this.f13896b) {
            return false;
        }
        synchronized (this) {
            if (this.f13896b) {
                return false;
            }
            List<g.a.u0.c> list = this.f13895a;
            if (list != null && list.remove(cVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // g.a.u0.c
    public void dispose() {
        if (this.f13896b) {
            return;
        }
        synchronized (this) {
            if (this.f13896b) {
                return;
            }
            this.f13896b = true;
            List<g.a.u0.c> list = this.f13895a;
            this.f13895a = null;
            a(list);
        }
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f13896b;
    }

    public i(g.a.u0.c... cVarArr) {
        g.a.y0.b.b.a(cVarArr, "resources is null");
        this.f13895a = new LinkedList();
        for (g.a.u0.c cVar : cVarArr) {
            g.a.y0.b.b.a(cVar, "Disposable item is null");
            this.f13895a.add(cVar);
        }
    }

    public i(Iterable<? extends g.a.u0.c> iterable) {
        g.a.y0.b.b.a(iterable, "resources is null");
        this.f13895a = new LinkedList();
        for (g.a.u0.c cVar : iterable) {
            g.a.y0.b.b.a(cVar, "Disposable item is null");
            this.f13895a.add(cVar);
        }
    }

    @Override // g.a.y0.a.c
    public boolean a(g.a.u0.c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    public void a() {
        if (this.f13896b) {
            return;
        }
        synchronized (this) {
            if (this.f13896b) {
                return;
            }
            List<g.a.u0.c> list = this.f13895a;
            this.f13895a = null;
            a(list);
        }
    }

    void a(List<g.a.u0.c> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<g.a.u0.c> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw g.a.y0.j.k.c((Throwable) arrayList.get(0));
            }
            throw new g.a.v0.a(arrayList);
        }
    }
}
