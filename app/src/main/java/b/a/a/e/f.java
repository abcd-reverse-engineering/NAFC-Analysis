package b.a.a.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.a.d.g;
import b.a.a.d.i;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: LinkagePicker.java */
/* loaded from: classes.dex */
public class f<Fst extends b.a.a.d.g<Snd>, Snd extends b.a.a.d.i<Trd>, Trd> extends b.a.a.e.k {
    protected Fst g0;
    protected Snd h0;
    protected Trd i0;
    protected String j0;
    protected String k0;
    protected String l0;
    protected int m0;
    protected int n0;
    protected int o0;
    protected k p0;
    protected float q0;
    protected float r0;
    protected float s0;
    private g t0;
    private AbstractC0028f u0;
    private j v0;
    private i w0;

    /* compiled from: LinkagePicker.java */
    class a implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f2270a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WheelView f2271b;

        a(WheelView wheelView, WheelView wheelView2) {
            this.f2270a = wheelView;
            this.f2271b = wheelView2;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            f fVar = f.this;
            fVar.g0 = fVar.p0.a().get(i2);
            f.this.m0 = i2;
            b.a.a.g.d.c(this, "change second data after first wheeled");
            f fVar2 = f.this;
            fVar2.n0 = 0;
            fVar2.o0 = 0;
            List<Snd> listA = fVar2.p0.a(fVar2.m0);
            f fVar3 = f.this;
            fVar3.h0 = listA.get(fVar3.n0);
            this.f2270a.a((List<?>) listA, f.this.n0);
            if (!f.this.p0.b()) {
                f fVar4 = f.this;
                List<Trd> listA2 = fVar4.p0.a(fVar4.m0, fVar4.n0);
                f fVar5 = f.this;
                fVar5.i0 = listA2.get(fVar5.o0);
                this.f2271b.a((List<?>) listA2, f.this.o0);
            }
            if (f.this.w0 != null) {
                f.this.w0.a(f.this.m0, 0, 0);
            }
            if (f.this.v0 != null) {
                j jVar = f.this.v0;
                f fVar6 = f.this;
                jVar.a(fVar6.m0, fVar6.g0.getName());
            }
        }
    }

    /* compiled from: LinkagePicker.java */
    class b implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f2273a;

        b(WheelView wheelView) {
            this.f2273a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            f fVar = f.this;
            fVar.h0 = fVar.p0.a(fVar.m0).get(i2);
            f fVar2 = f.this;
            fVar2.n0 = i2;
            if (!fVar2.p0.b()) {
                b.a.a.g.d.c(this, "change third data after second wheeled");
                f fVar3 = f.this;
                fVar3.o0 = 0;
                List<Trd> listA = fVar3.p0.a(fVar3.m0, fVar3.n0);
                f fVar4 = f.this;
                fVar4.i0 = listA.get(fVar4.o0);
                this.f2273a.a((List<?>) listA, f.this.o0);
            }
            if (f.this.w0 != null) {
                i iVar = f.this.w0;
                f fVar5 = f.this;
                iVar.a(fVar5.m0, fVar5.n0, 0);
            }
            if (f.this.v0 != null) {
                j jVar = f.this.v0;
                f fVar6 = f.this;
                jVar.b(fVar6.n0, fVar6.h0.getName());
            }
        }
    }

    /* compiled from: LinkagePicker.java */
    class c implements WheelView.g {
        c() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            f fVar = f.this;
            fVar.i0 = fVar.p0.a(fVar.m0, fVar.n0).get(i2);
            f fVar2 = f.this;
            fVar2.o0 = i2;
            if (fVar2.w0 != null) {
                i iVar = f.this.w0;
                f fVar3 = f.this;
                iVar.a(fVar3.m0, fVar3.n0, fVar3.o0);
            }
            if (f.this.v0 != null) {
                Trd trd = f.this.i0;
                f.this.v0.c(f.this.o0, trd instanceof b.a.a.d.j ? ((b.a.a.d.j) trd).getName() : trd.toString());
            }
        }
    }

    /* compiled from: LinkagePicker.java */
    private static class e<Fst extends b.a.a.d.g<Snd>, Snd extends b.a.a.d.i<Trd>, Trd> implements k<Fst, Snd, Trd> {

        /* renamed from: a, reason: collision with root package name */
        private List<Fst> f2276a;

        /* renamed from: b, reason: collision with root package name */
        private List<List<Snd>> f2277b;

        /* renamed from: c, reason: collision with root package name */
        private List<List<List<Trd>>> f2278c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2279d;

        public e(List<Fst> list, List<List<Snd>> list2, List<List<List<Trd>>> list3) {
            this.f2276a = new ArrayList();
            this.f2277b = new ArrayList();
            this.f2278c = new ArrayList();
            this.f2279d = false;
            this.f2276a = list;
            this.f2277b = list2;
            if (list3 == null || list3.size() == 0) {
                this.f2279d = true;
            } else {
                this.f2278c = list3;
            }
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<Fst> a() {
            return this.f2276a;
        }

        @Override // b.a.a.e.f.k
        public boolean b() {
            return this.f2279d;
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<Snd> a(int i2) {
            return this.f2277b.get(i2);
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<Trd> a(int i2, int i3) {
            if (this.f2279d) {
                return new ArrayList();
            }
            return this.f2278c.get(i2).get(i3);
        }
    }

    /* compiled from: LinkagePicker.java */
    @Deprecated
    /* renamed from: b.a.a.e.f$f, reason: collision with other inner class name */
    public static abstract class AbstractC0028f extends h {
    }

    /* compiled from: LinkagePicker.java */
    public interface g<Fst, Snd, Trd> {
        void a(Fst fst, Snd snd, Trd trd);
    }

    /* compiled from: LinkagePicker.java */
    public static abstract class h implements g<l, m, String> {
        public abstract void a(String str, String str2, String str3);

        @Override // b.a.a.e.f.g
        public void a(l lVar, m mVar, String str) {
            a(lVar.getName(), mVar.getName(), str);
        }
    }

    /* compiled from: LinkagePicker.java */
    public interface i {
        void a(int i2, int i3, int i4);
    }

    /* compiled from: LinkagePicker.java */
    @Deprecated
    public static abstract class j {
        public abstract void a(int i2, String str);

        public abstract void b(int i2, String str);

        public void c(int i2, String str) {
        }
    }

    /* compiled from: LinkagePicker.java */
    public interface k<Fst extends b.a.a.d.g<Snd>, Snd extends b.a.a.d.i<Trd>, Trd> {
        @NonNull
        List<Fst> a();

        @NonNull
        List<Snd> a(int i2);

        @NonNull
        List<Trd> a(int i2, int i3);

        boolean b();
    }

    /* compiled from: LinkagePicker.java */
    private static class l implements b.a.a.d.g<m> {
        private String name;
        private List<m> seconds;

        /* synthetic */ l(String str, List list, a aVar) {
            this(str, list);
        }

        @Override // b.a.a.d.g, b.a.a.d.h
        public Object getId() {
            return this.name;
        }

        @Override // b.a.a.d.l
        public String getName() {
            return this.name;
        }

        @Override // b.a.a.d.g
        public List<m> getSeconds() {
            return this.seconds;
        }

        private l(String str, List<m> list) {
            this.seconds = new ArrayList();
            this.name = str;
            this.seconds = list;
        }
    }

    /* compiled from: LinkagePicker.java */
    private static class m implements b.a.a.d.i<String> {
        private String name;
        private List<String> thirds;

        /* synthetic */ m(String str, List list, a aVar) {
            this(str, list);
        }

        @Override // b.a.a.d.i, b.a.a.d.h
        public Object getId() {
            return this.name;
        }

        @Override // b.a.a.d.l
        public String getName() {
            return this.name;
        }

        @Override // b.a.a.d.i
        public List<String> getThirds() {
            return this.thirds;
        }

        private m(String str, List<String> list) {
            this.thirds = new ArrayList();
            this.name = str;
            this.thirds = list;
        }
    }

    public f(Activity activity) {
        super(activity);
        this.j0 = "";
        this.k0 = "";
        this.l0 = "";
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.q0 = 1.0f;
        this.r0 = 1.0f;
        this.s0 = 1.0f;
    }

    public int A() {
        return this.n0;
    }

    public Snd B() {
        if (this.h0 == null) {
            this.h0 = this.p0.a(this.m0).get(this.n0);
        }
        return this.h0;
    }

    public int C() {
        return this.o0;
    }

    public Trd D() {
        if (this.i0 == null) {
            List<Trd> listA = this.p0.a(this.m0, this.n0);
            if (listA.size() > 0) {
                this.i0 = listA.get(this.o0);
            }
        }
        return this.i0;
    }

    public void e(int i2, int i3) {
        a(i2, i3, 0);
    }

    @Override // b.a.a.f.b
    @NonNull
    protected View r() {
        if (this.p0 == null) {
            throw new IllegalArgumentException("please set data provider before make view");
        }
        LinearLayout linearLayout = new LinearLayout(this.f2289a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView wheelViewX = x();
        wheelViewX.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.q0));
        linearLayout.addView(wheelViewX);
        if (!TextUtils.isEmpty(this.j0)) {
            TextView textViewW = w();
            textViewW.setText(this.j0);
            linearLayout.addView(textViewW);
        }
        WheelView wheelViewX2 = x();
        wheelViewX2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.r0));
        linearLayout.addView(wheelViewX2);
        if (!TextUtils.isEmpty(this.k0)) {
            TextView textViewW2 = w();
            textViewW2.setText(this.k0);
            linearLayout.addView(textViewW2);
        }
        WheelView wheelViewX3 = x();
        if (!this.p0.b()) {
            wheelViewX3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.s0));
            linearLayout.addView(wheelViewX3);
            if (!TextUtils.isEmpty(this.l0)) {
                TextView textViewW3 = w();
                textViewW3.setText(this.l0);
                linearLayout.addView(textViewW3);
            }
        }
        wheelViewX.a(this.p0.a(), this.m0);
        wheelViewX.setOnItemSelectListener(new a(wheelViewX2, wheelViewX3));
        wheelViewX2.a(this.p0.a(this.m0), this.n0);
        wheelViewX2.setOnItemSelectListener(new b(wheelViewX3));
        if (this.p0.b()) {
            return linearLayout;
        }
        wheelViewX3.a(this.p0.a(this.m0, this.n0), this.o0);
        wheelViewX3.setOnItemSelectListener(new c());
        return linearLayout;
    }

    @Deprecated
    public void setOnLinkageListener(AbstractC0028f abstractC0028f) {
        this.u0 = abstractC0028f;
    }

    public void setOnPickListener(g<Fst, Snd, Trd> gVar) {
        this.t0 = gVar;
    }

    public void setOnStringPickListener(h hVar) {
        this.t0 = hVar;
    }

    public void setOnWheelLinkageListener(i iVar) {
        this.w0 = iVar;
    }

    @Deprecated
    public void setOnWheelListener(j jVar) {
        this.v0 = jVar;
    }

    @Override // b.a.a.f.b
    public void v() {
        b.a.a.d.g gVarZ = z();
        b.a.a.d.i iVarB = B();
        Trd trdD = D();
        if (!this.p0.b()) {
            g gVar = this.t0;
            if (gVar != null) {
                gVar.a(gVarZ, iVarB, trdD);
            }
            if (this.u0 != null) {
                this.u0.a(gVarZ.getName(), iVarB.getName(), trdD instanceof b.a.a.d.j ? ((b.a.a.d.j) trdD).getName() : trdD.toString());
                return;
            }
            return;
        }
        g gVar2 = this.t0;
        if (gVar2 != null) {
            gVar2.a(gVarZ, iVarB, null);
        }
        AbstractC0028f abstractC0028f = this.u0;
        if (abstractC0028f != null) {
            abstractC0028f.a(gVarZ.getName(), iVarB.getName(), (String) null);
        }
    }

    public int y() {
        return this.m0;
    }

    public Fst z() {
        if (this.g0 == null) {
            this.g0 = this.p0.a().get(this.m0);
        }
        return this.g0;
    }

    protected void a(d dVar) {
        this.p0 = dVar;
    }

    protected void a(k<Fst, Snd, Trd> kVar) {
        this.p0 = kVar;
    }

    /* compiled from: LinkagePicker.java */
    public static abstract class d implements k<l, m, String> {
        @Override // b.a.a.e.f.k
        @NonNull
        public List<l> a() {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = c().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                arrayList.add(new l(it.next(), a(i2), null));
                i2++;
            }
            return arrayList;
        }

        @NonNull
        public abstract List<String> b(int i2);

        @Nullable
        public abstract List<String> b(int i2, int i3);

        @NonNull
        public abstract List<String> c();

        @Override // b.a.a.e.f.k
        @NonNull
        public List<m> a(int i2) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = b(i2).iterator();
            int i3 = 0;
            while (it.hasNext()) {
                arrayList.add(new m(it.next(), a(i2, i3), null));
                i3++;
            }
            return arrayList;
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<String> a(int i2, int i3) {
            List<String> listB = b(i2, i3);
            return listB == null ? new ArrayList() : listB;
        }
    }

    public void a(int i2, int i3, int i4) {
        this.m0 = i2;
        this.n0 = i3;
        this.o0 = i4;
    }

    public f(Activity activity, d dVar) {
        super(activity);
        this.j0 = "";
        this.k0 = "";
        this.l0 = "";
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.q0 = 1.0f;
        this.r0 = 1.0f;
        this.s0 = 1.0f;
        this.p0 = dVar;
    }

    public void a(Fst fst, Snd snd) {
        a((f<Fst, Snd, Trd>) fst, (Fst) snd, (Snd) null);
    }

    public void a(Fst fst, Snd snd, Trd trd) {
        k kVar = this.p0;
        if (kVar != null) {
            Iterator<Fst> it = kVar.a().iterator();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Fst next = it.next();
                if (next.equals(fst)) {
                    this.m0 = i3;
                    break;
                } else if (next.getId().equals(fst.getId()) || next.getName().contains(fst.getName())) {
                    break;
                } else {
                    i3++;
                }
            }
            this.m0 = i3;
            b.a.a.g.d.e("init select first: " + fst.getName() + ", index:" + this.m0);
            Iterator<Snd> it2 = this.p0.a(this.m0).iterator();
            int i4 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Snd next2 = it2.next();
                if (next2.equals(snd)) {
                    this.n0 = i4;
                    break;
                } else if (next2.getId().equals(snd.getId()) || next2.getName().contains(snd.getName())) {
                    break;
                } else {
                    i4++;
                }
            }
            this.n0 = i4;
            b.a.a.g.d.e("init select second: " + snd.getName() + ", index:" + this.n0);
            if (this.p0.b()) {
                return;
            }
            Iterator<Trd> it3 = this.p0.a(this.m0, this.n0).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Trd next3 = it3.next();
                if (next3.equals(trd)) {
                    this.o0 = i2;
                    break;
                }
                if (next3 instanceof b.a.a.d.j) {
                    b.a.a.d.j jVar = (b.a.a.d.j) trd;
                    b.a.a.d.j jVar2 = (b.a.a.d.j) next3;
                    if (jVar2.getId().equals(jVar.getId()) || jVar2.getName().contains(jVar.getName())) {
                        break;
                    }
                }
                i2++;
            }
            this.o0 = i2;
            b.a.a.g.d.e("init select third: " + trd + ", index:" + this.o0);
            return;
        }
        throw new IllegalArgumentException("please set data provider at first");
    }

    public f(Activity activity, k<Fst, Snd, Trd> kVar) {
        super(activity);
        this.j0 = "";
        this.k0 = "";
        this.l0 = "";
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.q0 = 1.0f;
        this.r0 = 1.0f;
        this.s0 = 1.0f;
        this.p0 = kVar;
    }

    @Deprecated
    public f(Activity activity, List<Fst> list, List<List<Snd>> list2) {
        this(activity, list, list2, null);
    }

    @Deprecated
    public f(Activity activity, List<Fst> list, List<List<Snd>> list2, List<List<List<Trd>>> list3) {
        super(activity);
        this.j0 = "";
        this.k0 = "";
        this.l0 = "";
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.q0 = 1.0f;
        this.r0 = 1.0f;
        this.s0 = 1.0f;
        this.p0 = new e(list, list2, list3);
    }

    public void a(String str, String str2) {
        a(str, str2, "");
    }

    public void a(String str, String str2, String str3) {
        this.j0 = str;
        this.k0 = str2;
        this.l0 = str3;
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.q0 = f2;
        this.r0 = f3;
        this.s0 = f4;
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        this.q0 = f2;
        this.r0 = f3;
        this.s0 = 0.0f;
    }
}
