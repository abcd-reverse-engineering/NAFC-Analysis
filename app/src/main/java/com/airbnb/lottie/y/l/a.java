package com.airbnb.lottie.y.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.j;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.w.c.o;
import com.airbnb.lottie.y.k.g;
import com.airbnb.lottie.y.k.l;
import com.airbnb.lottie.y.l.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class a implements com.airbnb.lottie.w.b.e, a.b, com.airbnb.lottie.y.f {
    private static final int A = 16;
    private static final int B = 1;
    private static final int C = 19;
    private static final int z = 2;

    /* renamed from: l, reason: collision with root package name */
    private final String f3964l;
    final j n;
    final d o;

    @Nullable
    private com.airbnb.lottie.w.c.g p;

    @Nullable
    private com.airbnb.lottie.w.c.c q;

    @Nullable
    private a r;

    @Nullable
    private a s;
    private List<a> t;
    final o v;
    private boolean x;

    @Nullable
    private Paint y;

    /* renamed from: a, reason: collision with root package name */
    private final Path f3953a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f3954b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    private final Paint f3955c = new com.airbnb.lottie.w.a(1);

    /* renamed from: d, reason: collision with root package name */
    private final Paint f3956d = new com.airbnb.lottie.w.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e, reason: collision with root package name */
    private final Paint f3957e = new com.airbnb.lottie.w.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: f, reason: collision with root package name */
    private final Paint f3958f = new com.airbnb.lottie.w.a(1);

    /* renamed from: g, reason: collision with root package name */
    private final Paint f3959g = new com.airbnb.lottie.w.a(PorterDuff.Mode.CLEAR);

    /* renamed from: h, reason: collision with root package name */
    private final RectF f3960h = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private final RectF f3961i = new RectF();

    /* renamed from: j, reason: collision with root package name */
    private final RectF f3962j = new RectF();

    /* renamed from: k, reason: collision with root package name */
    private final RectF f3963k = new RectF();

    /* renamed from: m, reason: collision with root package name */
    final Matrix f3965m = new Matrix();
    private final List<com.airbnb.lottie.w.c.a<?, ?>> u = new ArrayList();
    private boolean w = true;

    /* compiled from: BaseLayer.java */
    /* renamed from: com.airbnb.lottie.y.l.a$a, reason: collision with other inner class name */
    class C0052a implements a.b {
        C0052a() {
        }

        @Override // com.airbnb.lottie.w.c.a.b
        public void a() {
            a aVar = a.this;
            aVar.b(aVar.q.i() == 1.0f);
        }
    }

    /* compiled from: BaseLayer.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3967a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3968b = new int[g.a.values().length];

        static {
            try {
                f3968b[g.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3968b[g.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3968b[g.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3968b[g.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3967a = new int[d.a.values().length];
            try {
                f3967a[d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3967a[d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3967a[d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3967a[d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3967a[d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3967a[d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3967a[d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    a(j jVar, d dVar) {
        this.n = jVar;
        this.o = dVar;
        this.f3964l = dVar.g() + "#draw";
        if (dVar.f() == d.b.INVERT) {
            this.f3958f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f3958f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.v = dVar.u().a();
        this.v.a((a.b) this);
        if (dVar.e() != null && !dVar.e().isEmpty()) {
            this.p = new com.airbnb.lottie.w.c.g(dVar.e());
            Iterator<com.airbnb.lottie.w.c.a<l, Path>> it = this.p.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (com.airbnb.lottie.w.c.a<Integer, Integer> aVar : this.p.c()) {
                a(aVar);
                aVar.a(this);
            }
        }
        h();
    }

    private boolean e() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            if (this.p.b().get(i2).a() != g.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void f(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        this.f3953a.set(aVar.f());
        this.f3953a.transform(matrix);
        canvas.drawPath(this.f3953a, this.f3957e);
    }

    private void g() {
        this.n.invalidateSelf();
    }

    private void h() {
        if (this.o.c().isEmpty()) {
            b(true);
            return;
        }
        this.q = new com.airbnb.lottie.w.c.c(this.o.c());
        this.q.h();
        this.q.a(new C0052a());
        b(this.q.f().floatValue() == 1.0f);
        a(this.q);
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<com.airbnb.lottie.w.b.c> list, List<com.airbnb.lottie.w.b.c> list2) {
    }

    d b() {
        return this.o;
    }

    abstract void b(Canvas canvas, Matrix matrix, int i2);

    void b(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
    }

    boolean d() {
        return this.r != null;
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.o.g();
    }

    @Nullable
    static a a(d dVar, j jVar, com.airbnb.lottie.g gVar) {
        switch (b.f3967a[dVar.d().ordinal()]) {
            case 1:
                return new f(jVar, dVar);
            case 2:
                return new com.airbnb.lottie.y.l.b(jVar, dVar, gVar.c(dVar.k()), gVar);
            case 3:
                return new g(jVar, dVar);
            case 4:
                return new c(jVar, dVar);
            case 5:
                return new e(jVar, dVar);
            case 6:
                return new h(jVar, dVar);
            default:
                com.airbnb.lottie.b0.d.b("Unknown layer type " + dVar.d());
                return null;
        }
    }

    private void c(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.b0.h.a(canvas, this.f3960h, this.f3955c);
        canvas.drawRect(this.f3960h, this.f3955c);
        this.f3953a.set(aVar.f());
        this.f3953a.transform(matrix);
        this.f3955c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.f3953a, this.f3957e);
        canvas.restore();
    }

    private void d(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.b0.h.a(canvas, this.f3960h, this.f3956d);
        canvas.drawRect(this.f3960h, this.f3955c);
        this.f3957e.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        this.f3953a.set(aVar.f());
        this.f3953a.transform(matrix);
        canvas.drawPath(this.f3953a, this.f3957e);
        canvas.restore();
    }

    void b(@Nullable a aVar) {
        this.s = aVar;
    }

    public void b(com.airbnb.lottie.w.c.a<?, ?> aVar) {
        this.u.remove(aVar);
    }

    private void b(float f2) {
        this.n.f().l().a(this.o.g(), f2);
    }

    private void e(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.b0.h.a(canvas, this.f3960h, this.f3957e);
        canvas.drawRect(this.f3960h, this.f3955c);
        this.f3957e.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        this.f3953a.set(aVar.f());
        this.f3953a.transform(matrix);
        canvas.drawPath(this.f3953a, this.f3957e);
        canvas.restore();
    }

    private void f() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (a aVar = this.s; aVar != null; aVar = aVar.s) {
            this.t.add(aVar);
        }
    }

    private void b(RectF rectF, Matrix matrix) {
        if (d() && this.o.f() != d.b.INVERT) {
            this.f3962j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.a(this.f3962j, matrix, true);
            if (rectF.intersect(this.f3962j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    boolean c() {
        com.airbnb.lottie.w.c.g gVar = this.p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    void a(boolean z2) {
        if (z2 && this.y == null) {
            this.y = new com.airbnb.lottie.w.a();
        }
        this.x = z2;
    }

    private void b(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.b0.h.a(canvas, this.f3960h, this.f3956d);
        this.f3953a.set(aVar.f());
        this.f3953a.transform(matrix);
        this.f3955c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.f3953a, this.f3955c);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        g();
    }

    void a(@Nullable a aVar) {
        this.r = aVar;
    }

    public void a(@Nullable com.airbnb.lottie.w.c.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.u.add(aVar);
    }

    @Override // com.airbnb.lottie.w.b.e
    @CallSuper
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        this.f3960h.set(0.0f, 0.0f, 0.0f, 0.0f);
        f();
        this.f3965m.set(matrix);
        if (z2) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3965m.preConcat(this.t.get(size).v.b());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.f3965m.preConcat(aVar.v.b());
                }
            }
        }
        this.f3965m.preConcat(this.v.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        if (z2 != this.w) {
            this.w = z2;
            g();
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        com.airbnb.lottie.e.a(this.f3964l);
        if (this.w && !this.o.v()) {
            f();
            com.airbnb.lottie.e.a("Layer#parentMatrix");
            this.f3954b.reset();
            this.f3954b.set(matrix);
            for (int size = this.t.size() - 1; size >= 0; size--) {
                this.f3954b.preConcat(this.t.get(size).v.b());
            }
            com.airbnb.lottie.e.b("Layer#parentMatrix");
            int iIntValue = (int) ((((i2 / 255.0f) * (this.v.c() == null ? 100 : this.v.c().f().intValue())) / 100.0f) * 255.0f);
            if (!d() && !c()) {
                this.f3954b.preConcat(this.v.b());
                com.airbnb.lottie.e.a("Layer#drawLayer");
                b(canvas, this.f3954b, iIntValue);
                com.airbnb.lottie.e.b("Layer#drawLayer");
                b(com.airbnb.lottie.e.b(this.f3964l));
                return;
            }
            com.airbnb.lottie.e.a("Layer#computeBounds");
            a(this.f3960h, this.f3954b, false);
            b(this.f3960h, matrix);
            this.f3954b.preConcat(this.v.b());
            a(this.f3960h, this.f3954b);
            if (!this.f3960h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f3960h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.e.b("Layer#computeBounds");
            if (this.f3960h.width() >= 1.0f && this.f3960h.height() >= 1.0f) {
                com.airbnb.lottie.e.a("Layer#saveLayer");
                this.f3955c.setAlpha(255);
                com.airbnb.lottie.b0.h.a(canvas, this.f3960h, this.f3955c);
                com.airbnb.lottie.e.b("Layer#saveLayer");
                a(canvas);
                com.airbnb.lottie.e.a("Layer#drawLayer");
                b(canvas, this.f3954b, iIntValue);
                com.airbnb.lottie.e.b("Layer#drawLayer");
                if (c()) {
                    a(canvas, this.f3954b);
                }
                if (d()) {
                    com.airbnb.lottie.e.a("Layer#drawMatte");
                    com.airbnb.lottie.e.a("Layer#saveLayer");
                    com.airbnb.lottie.b0.h.a(canvas, this.f3960h, this.f3958f, 19);
                    com.airbnb.lottie.e.b("Layer#saveLayer");
                    a(canvas);
                    this.r.a(canvas, matrix, iIntValue);
                    com.airbnb.lottie.e.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.e.b("Layer#restoreLayer");
                    com.airbnb.lottie.e.b("Layer#drawMatte");
                }
                com.airbnb.lottie.e.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.e.b("Layer#restoreLayer");
            }
            if (this.x && (paint = this.y) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.y.setColor(-251901);
                this.y.setStrokeWidth(4.0f);
                canvas.drawRect(this.f3960h, this.y);
                this.y.setStyle(Paint.Style.FILL);
                this.y.setColor(1357638635);
                canvas.drawRect(this.f3960h, this.y);
            }
            b(com.airbnb.lottie.e.b(this.f3964l));
            return;
        }
        com.airbnb.lottie.e.b(this.f3964l);
    }

    private void a(Canvas canvas) {
        com.airbnb.lottie.e.a("Layer#clearLayer");
        RectF rectF = this.f3960h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f3959g);
        com.airbnb.lottie.e.b("Layer#clearLayer");
    }

    private void a(RectF rectF, Matrix matrix) {
        this.f3961i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (c()) {
            int size = this.p.b().size();
            for (int i2 = 0; i2 < size; i2++) {
                com.airbnb.lottie.y.k.g gVar = this.p.b().get(i2);
                this.f3953a.set(this.p.a().get(i2).f());
                this.f3953a.transform(matrix);
                int i3 = b.f3968b[gVar.a().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return;
                }
                if ((i3 == 3 || i3 == 4) && gVar.d()) {
                    return;
                }
                this.f3953a.computeBounds(this.f3963k, false);
                if (i2 == 0) {
                    this.f3961i.set(this.f3963k);
                } else {
                    RectF rectF2 = this.f3961i;
                    rectF2.set(Math.min(rectF2.left, this.f3963k.left), Math.min(this.f3961i.top, this.f3963k.top), Math.max(this.f3961i.right, this.f3963k.right), Math.max(this.f3961i.bottom, this.f3963k.bottom));
                }
            }
            if (rectF.intersect(this.f3961i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.e.a("Layer#saveLayer");
        com.airbnb.lottie.b0.h.a(canvas, this.f3960h, this.f3956d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            a(canvas);
        }
        com.airbnb.lottie.e.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            com.airbnb.lottie.y.k.g gVar = this.p.b().get(i2);
            com.airbnb.lottie.w.c.a<l, Path> aVar = this.p.a().get(i2);
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar2 = this.p.c().get(i2);
            int i3 = b.f3968b[gVar.a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.f3955c.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f3955c.setAlpha(255);
                        canvas.drawRect(this.f3960h, this.f3955c);
                    }
                    if (gVar.d()) {
                        e(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        f(canvas, matrix, gVar, aVar, aVar2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (gVar.d()) {
                            c(canvas, matrix, gVar, aVar, aVar2);
                        } else {
                            a(canvas, matrix, gVar, aVar, aVar2);
                        }
                    }
                } else if (gVar.d()) {
                    d(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    b(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (e()) {
                this.f3955c.setAlpha(255);
                canvas.drawRect(this.f3960h, this.f3955c);
            }
        }
        com.airbnb.lottie.e.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.e.b("Layer#restoreLayer");
    }

    private void a(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        this.f3953a.set(aVar.f());
        this.f3953a.transform(matrix);
        this.f3955c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.f3953a, this.f3955c);
    }

    void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.v.b(f2);
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.a().size(); i2++) {
                this.p.a().get(i2).a(f2);
            }
        }
        com.airbnb.lottie.w.c.c cVar = this.q;
        if (cVar != null) {
            cVar.a(f2);
        }
        a aVar = this.r;
        if (aVar != null) {
            aVar.a(f2);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).a(f2);
        }
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        a aVar = this.r;
        if (aVar != null) {
            com.airbnb.lottie.y.e eVarA = eVar2.a(aVar.getName());
            if (eVar.a(this.r.getName(), i2)) {
                list.add(eVarA.a(this.r));
            }
            if (eVar.d(getName(), i2)) {
                this.r.b(eVar, eVar.b(this.r.getName(), i2) + i2, list, eVarA);
            }
        }
        if (eVar.c(getName(), i2)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.a(getName(), i2)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.d(getName(), i2)) {
                b(eVar, i2 + eVar.b(getName(), i2), list, eVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        this.v.a(t, jVar);
    }
}
