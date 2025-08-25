package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class d implements e, n, a.b, com.airbnb.lottie.y.f {

    /* renamed from: a, reason: collision with root package name */
    private Paint f3646a;

    /* renamed from: b, reason: collision with root package name */
    private RectF f3647b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f3648c;

    /* renamed from: d, reason: collision with root package name */
    private final Path f3649d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f3650e;

    /* renamed from: f, reason: collision with root package name */
    private final String f3651f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f3652g;

    /* renamed from: h, reason: collision with root package name */
    private final List<c> f3653h;

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.j f3654i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private List<n> f3655j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.w.c.o f3656k;

    public d(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.n nVar) {
        this(jVar, aVar, nVar.b(), nVar.c(), a(jVar, aVar, nVar.a()), a(nVar.a()));
    }

    private static List<c> a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, List<com.airbnb.lottie.y.k.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVarA = list.get(i2).a(jVar, aVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    private boolean d() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3653h.size(); i3++) {
            if ((this.f3653h.get(i3) instanceof e) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    List<n> b() {
        if (this.f3655j == null) {
            this.f3655j = new ArrayList();
            for (int i2 = 0; i2 < this.f3653h.size(); i2++) {
                c cVar = this.f3653h.get(i2);
                if (cVar instanceof n) {
                    this.f3655j.add((n) cVar);
                }
            }
        }
        return this.f3655j;
    }

    Matrix c() {
        com.airbnb.lottie.w.c.o oVar = this.f3656k;
        if (oVar != null) {
            return oVar.b();
        }
        this.f3648c.reset();
        return this.f3648c;
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3651f;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        this.f3648c.reset();
        com.airbnb.lottie.w.c.o oVar = this.f3656k;
        if (oVar != null) {
            this.f3648c.set(oVar.b());
        }
        this.f3649d.reset();
        if (this.f3652g) {
            return this.f3649d;
        }
        for (int size = this.f3653h.size() - 1; size >= 0; size--) {
            c cVar = this.f3653h.get(size);
            if (cVar instanceof n) {
                this.f3649d.addPath(((n) cVar).getPath(), this.f3648c);
            }
        }
        return this.f3649d;
    }

    d(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, String str, boolean z, List<c> list, @Nullable com.airbnb.lottie.y.j.l lVar) {
        this.f3646a = new com.airbnb.lottie.w.a();
        this.f3647b = new RectF();
        this.f3648c = new Matrix();
        this.f3649d = new Path();
        this.f3650e = new RectF();
        this.f3651f = str;
        this.f3654i = jVar;
        this.f3652g = z;
        this.f3653h = list;
        if (lVar != null) {
            this.f3656k = lVar.a();
            this.f3656k.a(aVar);
            this.f3656k.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    @Nullable
    static com.airbnb.lottie.y.j.l a(List<com.airbnb.lottie.y.k.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.airbnb.lottie.y.k.b bVar = list.get(i2);
            if (bVar instanceof com.airbnb.lottie.y.j.l) {
                return (com.airbnb.lottie.y.j.l) bVar;
            }
        }
        return null;
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f3654i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f3653h.size());
        arrayList.addAll(list);
        for (int size = this.f3653h.size() - 1; size >= 0; size--) {
            c cVar = this.f3653h.get(size);
            cVar.a(arrayList, this.f3653h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f3652g) {
            return;
        }
        this.f3648c.set(matrix);
        com.airbnb.lottie.w.c.o oVar = this.f3656k;
        if (oVar != null) {
            this.f3648c.preConcat(oVar.b());
            i2 = (int) (((((this.f3656k.c() == null ? 100 : this.f3656k.c().f().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z = this.f3654i.u() && d() && i2 != 255;
        if (z) {
            this.f3647b.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.f3647b, this.f3648c, true);
            this.f3646a.setAlpha(i2);
            com.airbnb.lottie.b0.h.a(canvas, this.f3647b, this.f3646a);
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.f3653h.size() - 1; size >= 0; size--) {
            c cVar = this.f3653h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(canvas, this.f3648c, i2);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f3648c.set(matrix);
        com.airbnb.lottie.w.c.o oVar = this.f3656k;
        if (oVar != null) {
            this.f3648c.preConcat(oVar.b());
        }
        this.f3650e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f3653h.size() - 1; size >= 0; size--) {
            c cVar = this.f3653h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.f3650e, this.f3648c, z);
                rectF.union(this.f3650e);
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        if (eVar.c(getName(), i2) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.a(getName(), i2)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.d(getName(), i2)) {
                int iB = i2 + eVar.b(getName(), i2);
                for (int i3 = 0; i3 < this.f3653h.size(); i3++) {
                    c cVar = this.f3653h.get(i3);
                    if (cVar instanceof com.airbnb.lottie.y.f) {
                        ((com.airbnb.lottie.y.f) cVar).a(eVar, iB, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        com.airbnb.lottie.w.c.o oVar = this.f3656k;
        if (oVar != null) {
            oVar.a(t, jVar);
        }
    }
}
