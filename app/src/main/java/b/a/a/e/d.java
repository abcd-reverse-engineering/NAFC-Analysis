package b.a.a.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/* compiled from: DateTimePicker.java */
/* loaded from: classes.dex */
public class d extends b.a.a.e.k {
    public static final int L0 = -1;
    public static final int M0 = 0;
    public static final int N0 = 1;
    public static final int O0 = 2;
    public static final int P0 = 3;

    @Deprecated
    public static final int Q0 = 3;
    public static final int R0 = 4;

    @Deprecated
    public static final int S0 = 4;
    private int A0;
    private int B0;
    private int C0;
    private int D0;
    private int E0;
    private int F0;
    private int G0;
    private int H0;
    private int I0;
    private int J0;
    private boolean K0;
    private ArrayList<String> g0;
    private ArrayList<String> h0;
    private ArrayList<String> i0;
    private ArrayList<String> j0;
    private ArrayList<String> k0;
    private String l0;
    private String m0;
    private String n0;
    private String o0;
    private String p0;
    private int q0;
    private int r0;
    private int s0;
    private String t0;
    private String u0;
    private l v0;
    private h w0;
    private int x0;
    private int y0;
    private int z0;

    /* compiled from: DateTimePicker.java */
    class a implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f2258a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WheelView f2259b;

        a(WheelView wheelView, WheelView wheelView2) {
            this.f2258a = wheelView;
            this.f2259b = wheelView2;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            d.this.q0 = i2;
            String str = (String) d.this.g0.get(d.this.q0);
            if (d.this.v0 != null) {
                d.this.v0.e(d.this.q0, str);
            }
            b.a.a.g.d.c(this, "change months after year wheeled");
            if (d.this.K0) {
                d.this.r0 = 0;
                d.this.s0 = 0;
            }
            int iC = b.a.a.g.c.c(str);
            d.this.E(iC);
            this.f2258a.a(d.this.h0, d.this.r0);
            if (d.this.v0 != null) {
                d.this.v0.d(d.this.r0, (String) d.this.h0.get(d.this.r0));
            }
            d dVar = d.this;
            dVar.j(iC, b.a.a.g.c.c((String) dVar.h0.get(d.this.r0)));
            this.f2259b.a(d.this.i0, d.this.s0);
            if (d.this.v0 != null) {
                d.this.v0.b(d.this.s0, (String) d.this.i0.get(d.this.s0));
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    class b implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f2261a;

        b(WheelView wheelView) {
            this.f2261a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            d.this.r0 = i2;
            String str = (String) d.this.h0.get(d.this.r0);
            if (d.this.v0 != null) {
                d.this.v0.d(d.this.r0, str);
            }
            if (d.this.x0 == 0 || d.this.x0 == 2) {
                b.a.a.g.d.c(this, "change days after month wheeled");
                if (d.this.K0) {
                    d.this.s0 = 0;
                }
                d.this.j(d.this.x0 == 0 ? b.a.a.g.c.c(d.this.C()) : Calendar.getInstance(Locale.CHINA).get(1), b.a.a.g.c.c(str));
                this.f2261a.a(d.this.i0, d.this.s0);
                if (d.this.v0 != null) {
                    d.this.v0.b(d.this.s0, (String) d.this.i0.get(d.this.s0));
                }
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    class c implements WheelView.g {
        c() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            d.this.s0 = i2;
            if (d.this.v0 != null) {
                d.this.v0.b(d.this.s0, (String) d.this.i0.get(d.this.s0));
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$d, reason: collision with other inner class name */
    class C0027d implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f2264a;

        C0027d(WheelView wheelView) {
            this.f2264a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            d dVar = d.this;
            dVar.t0 = (String) dVar.j0.get(i2);
            if (d.this.v0 != null) {
                d.this.v0.a(i2, d.this.t0);
            }
            b.a.a.g.d.c(this, "change minutes after hour wheeled");
            d dVar2 = d.this;
            dVar2.D(b.a.a.g.c.c(dVar2.t0));
            this.f2264a.a(d.this.k0, d.this.u0);
        }
    }

    /* compiled from: DateTimePicker.java */
    class e implements WheelView.g {
        e() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            d dVar = d.this;
            dVar.u0 = (String) dVar.k0.get(i2);
            if (d.this.v0 != null) {
                d.this.v0.c(i2, d.this.u0);
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    class f implements Comparator<Object> {
        f() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            String string = obj.toString();
            String string2 = obj2.toString();
            if (string.startsWith("0")) {
                string = string.substring(1);
            }
            if (string2.startsWith("0")) {
                string2 = string2.substring(1);
            }
            try {
                return Integer.parseInt(string) - Integer.parseInt(string2);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface g {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: DateTimePicker.java */
    public interface h {
    }

    /* compiled from: DateTimePicker.java */
    @Deprecated
    public interface i extends j {
    }

    /* compiled from: DateTimePicker.java */
    public interface j extends h {
        void a(String str, String str2, String str3, String str4);
    }

    /* compiled from: DateTimePicker.java */
    public interface k extends h {
        void a(String str, String str2);
    }

    /* compiled from: DateTimePicker.java */
    public interface l {
        void a(int i2, String str);

        void b(int i2, String str);

        void c(int i2, String str);

        void d(int i2, String str);

        void e(int i2, String str);
    }

    /* compiled from: DateTimePicker.java */
    public interface m extends h {
        void a(String str, String str2, String str3, String str4, String str5);
    }

    /* compiled from: DateTimePicker.java */
    @Deprecated
    public interface n extends o {
    }

    /* compiled from: DateTimePicker.java */
    public interface o extends h {
        void a(String str, String str2, String str3, String str4);
    }

    /* compiled from: DateTimePicker.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface p {
    }

    public d(Activity activity, int i2) {
        this(activity, 0, i2);
    }

    private void D() {
        this.j0.clear();
        int i2 = !this.K0 ? this.y0 == 3 ? Calendar.getInstance().get(11) : Calendar.getInstance().get(10) : 0;
        for (int i3 = this.F0; i3 <= this.H0; i3++) {
            String strB = b.a.a.g.c.b(i3);
            if (!this.K0 && i3 == i2) {
                this.t0 = strB;
            }
            this.j0.add(strB);
        }
        if (this.j0.indexOf(this.t0) == -1) {
            this.t0 = this.j0.get(0);
        }
        if (this.K0) {
            return;
        }
        this.u0 = b.a.a.g.c.b(Calendar.getInstance().get(12));
    }

    private void E() {
        this.g0.clear();
        int i2 = this.z0;
        int i3 = this.C0;
        if (i2 == i3) {
            this.g0.add(String.valueOf(i2));
        } else if (i2 < i3) {
            while (i2 <= this.C0) {
                this.g0.add(String.valueOf(i2));
                i2++;
            }
        } else {
            while (i2 >= this.C0) {
                this.g0.add(String.valueOf(i2));
                i2--;
            }
        }
        if (this.K0) {
            return;
        }
        int i4 = this.x0;
        if (i4 == 0 || i4 == 1) {
            int iIndexOf = this.g0.indexOf(b.a.a.g.c.b(Calendar.getInstance().get(1)));
            if (iIndexOf == -1) {
                this.q0 = 0;
            } else {
                this.q0 = iIndexOf;
            }
        }
    }

    public String A() {
        return this.y0 != -1 ? this.u0 : "";
    }

    public String B() {
        if (this.x0 == -1) {
            return "";
        }
        if (this.h0.size() <= this.r0) {
            this.r0 = this.h0.size() - 1;
        }
        return this.h0.get(this.r0);
    }

    public String C() {
        int i2 = this.x0;
        if (i2 != 0 && i2 != 1) {
            return "";
        }
        if (this.g0.size() <= this.q0) {
            this.q0 = this.g0.size() - 1;
        }
        return this.g0.get(this.q0);
    }

    public void o(boolean z) {
        this.K0 = z;
    }

    @Override // b.a.a.f.b
    @NonNull
    protected View r() {
        int i2 = this.x0;
        if ((i2 == 0 || i2 == 1) && this.g0.size() == 0) {
            b.a.a.g.d.c(this, "init years before make view");
            E();
        }
        if (this.x0 != -1 && this.h0.size() == 0) {
            b.a.a.g.d.c(this, "init months before make view");
            E(b.a.a.g.c.c(C()));
        }
        int i3 = this.x0;
        if ((i3 == 0 || i3 == 2) && this.i0.size() == 0) {
            b.a.a.g.d.c(this, "init days before make view");
            j(this.x0 == 0 ? b.a.a.g.c.c(C()) : Calendar.getInstance(Locale.CHINA).get(1), b.a.a.g.c.c(B()));
        }
        if (this.y0 != -1 && this.j0.size() == 0) {
            b.a.a.g.d.c(this, "init hours before make view");
            D();
        }
        if (this.y0 != -1 && this.k0.size() == 0) {
            b.a.a.g.d.c(this, "init minutes before make view");
            D(b.a.a.g.c.c(this.t0));
        }
        LinearLayout linearLayout = new LinearLayout(this.f2289a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView wheelViewX = x();
        WheelView wheelViewX2 = x();
        WheelView wheelViewX3 = x();
        WheelView wheelViewX4 = x();
        WheelView wheelViewX5 = x();
        int i4 = this.x0;
        if (i4 == 0 || i4 == 1) {
            wheelViewX.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewX.a(this.g0, this.q0);
            wheelViewX.setOnItemSelectListener(new a(wheelViewX2, wheelViewX3));
            linearLayout.addView(wheelViewX);
            if (!TextUtils.isEmpty(this.l0)) {
                TextView textViewW = w();
                textViewW.setTextSize(this.J0);
                textViewW.setText(this.l0);
                linearLayout.addView(textViewW);
            }
        }
        if (this.x0 != -1) {
            wheelViewX2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewX2.a(this.h0, this.r0);
            wheelViewX2.setOnItemSelectListener(new b(wheelViewX3));
            linearLayout.addView(wheelViewX2);
            if (!TextUtils.isEmpty(this.m0)) {
                TextView textViewW2 = w();
                textViewW2.setTextSize(this.J0);
                textViewW2.setText(this.m0);
                linearLayout.addView(textViewW2);
            }
        }
        int i5 = this.x0;
        if (i5 == 0 || i5 == 2) {
            wheelViewX3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewX3.a(this.i0, this.s0);
            wheelViewX3.setOnItemSelectListener(new c());
            linearLayout.addView(wheelViewX3);
            if (!TextUtils.isEmpty(this.n0)) {
                TextView textViewW3 = w();
                textViewW3.setTextSize(this.J0);
                textViewW3.setText(this.n0);
                linearLayout.addView(textViewW3);
            }
        }
        if (this.y0 != -1) {
            wheelViewX4.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewX4.a(this.j0, this.t0);
            wheelViewX4.setOnItemSelectListener(new C0027d(wheelViewX5));
            linearLayout.addView(wheelViewX4);
            if (!TextUtils.isEmpty(this.o0)) {
                TextView textViewW4 = w();
                textViewW4.setTextSize(this.J0);
                textViewW4.setText(this.o0);
                linearLayout.addView(textViewW4);
            }
            wheelViewX5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewX5.a(this.k0, this.u0);
            wheelViewX5.setOnItemSelectListener(new e());
            linearLayout.addView(wheelViewX5);
            if (!TextUtils.isEmpty(this.p0)) {
                TextView textViewW5 = w();
                textViewW5.setTextSize(this.J0);
                textViewW5.setText(this.p0);
                linearLayout.addView(textViewW5);
            }
        }
        return linearLayout;
    }

    public void setOnDateTimePickListener(h hVar) {
        this.w0 = hVar;
    }

    public void setOnWheelListener(l lVar) {
        this.v0 = lVar;
    }

    @Override // b.a.a.f.b
    protected void v() {
        if (this.w0 == null) {
            return;
        }
        String strC = C();
        String strB = B();
        String strY = y();
        String strZ = z();
        String strA = A();
        int i2 = this.x0;
        if (i2 == -1) {
            ((k) this.w0).a(strZ, strA);
            return;
        }
        if (i2 == 0) {
            ((m) this.w0).a(strC, strB, strY, strZ, strA);
        } else if (i2 == 1) {
            ((o) this.w0).a(strC, strB, strZ, strA);
        } else {
            if (i2 != 2) {
                return;
            }
            ((j) this.w0).a(strB, strY, strZ, strA);
        }
    }

    public String y() {
        int i2 = this.x0;
        if (i2 != 0 && i2 != 2) {
            return "";
        }
        if (this.i0.size() <= this.s0) {
            this.s0 = this.i0.size() - 1;
        }
        return this.i0.get(this.s0);
    }

    public String z() {
        return this.y0 != -1 ? this.t0 : "";
    }

    public d(Activity activity, int i2, int i3) {
        super(activity);
        this.g0 = new ArrayList<>();
        this.h0 = new ArrayList<>();
        this.i0 = new ArrayList<>();
        this.j0 = new ArrayList<>();
        this.k0 = new ArrayList<>();
        this.l0 = "年";
        this.m0 = "月";
        this.n0 = "日";
        this.o0 = "时";
        this.p0 = "分";
        this.q0 = 0;
        this.r0 = 0;
        this.s0 = 0;
        this.t0 = "";
        this.u0 = "";
        this.x0 = 0;
        this.y0 = 3;
        this.z0 = 2010;
        this.A0 = 1;
        this.B0 = 1;
        this.C0 = 2020;
        this.D0 = 12;
        this.E0 = 31;
        this.G0 = 0;
        this.I0 = 59;
        this.J0 = 16;
        this.K0 = true;
        if (i2 == -1 && i3 == -1) {
            throw new IllegalArgumentException("The modes are NONE at the same time");
        }
        if (i2 == 0 && i3 != -1) {
            int i4 = this.f2290b;
            if (i4 < 720) {
                this.J0 = 14;
            } else if (i4 < 480) {
                this.J0 = 12;
            }
        }
        this.x0 = i2;
        if (i3 == 4) {
            this.F0 = 1;
            this.H0 = 12;
        } else {
            this.F0 = 0;
            this.H0 = 23;
        }
        this.y0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i2, int i3) {
        String strB;
        int iA = b.a.a.g.c.a(i2, i3);
        if (this.K0) {
            strB = "";
        } else {
            if (this.s0 >= iA) {
                this.s0 = iA - 1;
            }
            int size = this.i0.size();
            int i4 = this.s0;
            strB = size > i4 ? this.i0.get(i4) : b.a.a.g.c.b(Calendar.getInstance().get(5));
            b.a.a.g.d.c(this, "maxDays=" + iA + ", preSelectDay=" + strB);
        }
        this.i0.clear();
        if (i2 == this.z0 && i3 == this.A0 && i2 == this.C0 && i3 == this.D0) {
            for (int i5 = this.B0; i5 <= this.E0; i5++) {
                this.i0.add(b.a.a.g.c.b(i5));
            }
        } else if (i2 == this.z0 && i3 == this.A0) {
            for (int i6 = this.B0; i6 <= iA; i6++) {
                this.i0.add(b.a.a.g.c.b(i6));
            }
        } else {
            int i7 = 1;
            if (i2 == this.C0 && i3 == this.D0) {
                while (i7 <= this.E0) {
                    this.i0.add(b.a.a.g.c.b(i7));
                    i7++;
                }
            } else {
                while (i7 <= iA) {
                    this.i0.add(b.a.a.g.c.b(i7));
                    i7++;
                }
            }
        }
        if (this.K0) {
            return;
        }
        int iIndexOf = this.i0.indexOf(strB);
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        this.s0 = iIndexOf;
    }

    public void f(int i2, int i3) {
        int i4 = this.x0;
        if (i4 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i4 == 0) {
            throw new IllegalArgumentException("Not support year/month/day mode");
        }
        if (i4 == 1) {
            this.z0 = i2;
            this.A0 = i3;
        } else if (i4 == 2) {
            int i5 = Calendar.getInstance(Locale.CHINA).get(1);
            this.C0 = i5;
            this.z0 = i5;
            this.A0 = i2;
            this.B0 = i3;
        }
        E();
    }

    @Deprecated
    public void g(int i2, int i3) {
        if (this.x0 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        this.z0 = i2;
        this.C0 = i3;
        E();
    }

    public void h(int i2, int i3) {
        if (this.y0 == -1) {
            throw new IllegalArgumentException("Time mode invalid");
        }
        boolean z = i2 < 0 || i3 < 0 || i3 > 59;
        if (this.y0 == 4 && (i2 == 0 || i2 > 12)) {
            z = true;
        }
        if (this.y0 == 3 && i2 >= 24) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("Time out of range");
        }
        this.H0 = i2;
        this.I0 = i3;
        D();
    }

    public void i(int i2, int i3) {
        if (this.y0 == -1) {
            throw new IllegalArgumentException("Time mode invalid");
        }
        boolean z = i2 < 0 || i3 < 0 || i3 > 59;
        if (this.y0 == 4 && (i2 == 0 || i2 > 12)) {
            z = true;
        }
        if (this.y0 == 3 && i2 >= 24) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("Time out of range");
        }
        this.F0 = i2;
        this.G0 = i3;
        D();
    }

    public void e(int i2, int i3) {
        int i4 = this.x0;
        if (i4 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i4 != 0) {
            if (i4 == 1) {
                this.C0 = i2;
                this.D0 = i3;
            } else if (i4 == 2) {
                this.D0 = i2;
                this.E0 = i3;
            }
            E();
            return;
        }
        throw new IllegalArgumentException("Not support year/month/day mode");
    }

    public void b(int i2, int i3, int i4) {
        if (this.x0 != -1) {
            this.z0 = i2;
            this.A0 = i3;
            this.B0 = i4;
            E();
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    public void a(int i2, int i3, int i4) {
        if (this.x0 != -1) {
            this.C0 = i2;
            this.D0 = i3;
            this.E0 = i4;
            E();
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        this.l0 = str;
        this.m0 = str2;
        this.n0 = str3;
        this.o0 = str4;
        this.p0 = str5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i2) {
        String strB;
        int i3;
        int i4 = 1;
        if (this.K0) {
            strB = "";
        } else {
            int size = this.h0.size();
            int i5 = this.r0;
            if (size > i5) {
                strB = this.h0.get(i5);
            } else {
                strB = b.a.a.g.c.b(Calendar.getInstance().get(2) + 1);
            }
            b.a.a.g.d.c(this, "preSelectMonth=" + strB);
        }
        this.h0.clear();
        int i6 = this.A0;
        if (i6 >= 1 && (i3 = this.D0) >= 1 && i6 <= 12 && i3 <= 12) {
            int i7 = this.z0;
            int i8 = this.C0;
            if (i7 == i8) {
                if (i6 > i3) {
                    while (i3 >= this.A0) {
                        this.h0.add(b.a.a.g.c.b(i3));
                        i3--;
                    }
                } else {
                    while (i6 <= this.D0) {
                        this.h0.add(b.a.a.g.c.b(i6));
                        i6++;
                    }
                }
            } else if (i2 == i7) {
                while (i6 <= 12) {
                    this.h0.add(b.a.a.g.c.b(i6));
                    i6++;
                }
            } else if (i2 == i8) {
                while (i4 <= this.D0) {
                    this.h0.add(b.a.a.g.c.b(i4));
                    i4++;
                }
            } else {
                while (i4 <= 12) {
                    this.h0.add(b.a.a.g.c.b(i4));
                    i4++;
                }
            }
            if (this.K0) {
                return;
            }
            int iIndexOf = this.h0.indexOf(strB);
            if (iIndexOf == -1) {
                iIndexOf = 0;
            }
            this.r0 = iIndexOf;
            return;
        }
        throw new IllegalArgumentException("Month out of range [1-12]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i2) {
        this.k0.clear();
        int i3 = this.F0;
        int i4 = this.H0;
        if (i3 == i4) {
            int i5 = this.G0;
            int i6 = this.I0;
            if (i5 > i6) {
                this.G0 = i6;
                this.I0 = i5;
            }
            for (int i7 = this.G0; i7 <= this.I0; i7++) {
                this.k0.add(b.a.a.g.c.b(i7));
            }
        } else if (i2 == i3) {
            for (int i8 = this.G0; i8 <= 59; i8++) {
                this.k0.add(b.a.a.g.c.b(i8));
            }
        } else if (i2 == i4) {
            for (int i9 = 0; i9 <= this.I0; i9++) {
                this.k0.add(b.a.a.g.c.b(i9));
            }
        } else {
            for (int i10 = 0; i10 <= 59; i10++) {
                this.k0.add(b.a.a.g.c.b(i10));
            }
        }
        if (this.k0.indexOf(this.u0) == -1) {
            this.u0 = this.k0.get(0);
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        if (this.x0 == 0) {
            b.a.a.g.d.c(this, "change months and days while set selected");
            E(i2);
            j(i2, i3);
            this.q0 = a(this.g0, i2);
            this.r0 = a(this.h0, i3);
            this.s0 = a(this.i0, i4);
            if (this.y0 != -1) {
                this.t0 = b.a.a.g.c.b(i5);
                this.u0 = b.a.a.g.c.b(i6);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    public void a(int i2, int i3, int i4, int i5) {
        int i6 = this.x0;
        if (i6 != 0) {
            if (i6 == 2) {
                b.a.a.g.d.c(this, "change months and days while set selected");
                int i7 = Calendar.getInstance(Locale.CHINA).get(1);
                this.C0 = i7;
                this.z0 = i7;
                E(i7);
                j(i7, i2);
                this.r0 = a(this.h0, i2);
                this.s0 = a(this.i0, i3);
            } else if (i6 == 1) {
                b.a.a.g.d.c(this, "change months while set selected");
                E(i2);
                this.q0 = a(this.g0, i2);
                this.r0 = a(this.h0, i3);
            }
            if (this.y0 != -1) {
                this.t0 = b.a.a.g.c.b(i4);
                this.u0 = b.a.a.g.c.b(i5);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    private int a(ArrayList<String> arrayList, int i2) {
        int iBinarySearch = Collections.binarySearch(arrayList, Integer.valueOf(i2), new f());
        if (iBinarySearch >= 0) {
            return iBinarySearch;
        }
        throw new IllegalArgumentException("Item[" + i2 + "] out of range");
    }
}
