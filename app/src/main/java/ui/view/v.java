package ui.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ThreePicker.java */
/* loaded from: classes2.dex */
public class v extends b.a.a.e.k {
    private List<String> g0;
    private List<String> h0;
    private List<String> i0;
    private int j0;
    private int k0;
    private int l0;
    private e m0;
    private d n0;
    private CharSequence o0;
    private CharSequence p0;
    private CharSequence q0;
    private CharSequence r0;
    private CharSequence s0;
    private CharSequence t0;

    /* compiled from: ThreePicker.java */
    class a implements WheelView.g {
        a() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            v.this.j0 = i2;
            if (v.this.m0 != null) {
                v.this.m0.g(v.this.j0, (String) v.this.g0.get(v.this.j0));
            }
        }
    }

    /* compiled from: ThreePicker.java */
    class b implements WheelView.g {
        b() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            v.this.k0 = i2;
            if (v.this.m0 != null) {
                v.this.m0.f(v.this.k0, (String) v.this.h0.get(v.this.k0));
            }
        }
    }

    /* compiled from: ThreePicker.java */
    class c implements WheelView.g {
        c() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            v.this.l0 = i2;
            if (v.this.m0 != null) {
                v.this.m0.f(v.this.l0, (String) v.this.i0.get(v.this.l0));
            }
        }
    }

    /* compiled from: ThreePicker.java */
    public interface d {
        void a(int i2, int i3, int i4);
    }

    /* compiled from: ThreePicker.java */
    public interface e {
        void a(int i2, String str);

        void f(int i2, String str);

        void g(int i2, String str);
    }

    public v(Activity activity, List<String> list, List<String> list2, List<String> list3) {
        super(activity);
        this.g0 = new ArrayList();
        this.h0 = new ArrayList();
        this.i0 = new ArrayList();
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.g0 = list;
        this.h0 = list2;
        this.i0 = list3;
    }

    public String A() {
        int size = this.i0.size();
        int i2 = this.l0;
        return size > i2 ? this.i0.get(i2) : "";
    }

    @Override // b.a.a.f.b
    @NonNull
    protected View r() {
        LinearLayout linearLayout = new LinearLayout(this.f2289a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        if (!TextUtils.isEmpty(this.o0)) {
            TextView textViewW = w();
            textViewW.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW.setText(this.o0);
            linearLayout.addView(textViewW);
        }
        WheelView wheelViewX = x();
        wheelViewX.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(wheelViewX);
        if (!TextUtils.isEmpty(this.p0)) {
            TextView textViewW2 = w();
            textViewW2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW2.setText(this.p0);
            linearLayout.addView(textViewW2);
        }
        if (!TextUtils.isEmpty(this.q0)) {
            TextView textViewW3 = w();
            textViewW3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW3.setText(this.q0);
            linearLayout.addView(textViewW3);
        }
        WheelView wheelViewX2 = x();
        wheelViewX2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(wheelViewX2);
        if (!TextUtils.isEmpty(this.r0)) {
            TextView textViewW4 = w();
            textViewW4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW4.setText(this.r0);
            linearLayout.addView(textViewW4);
        }
        if (!TextUtils.isEmpty(this.s0)) {
            TextView textViewW5 = w();
            textViewW5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW5.setText(this.s0);
            linearLayout.addView(textViewW5);
        }
        WheelView wheelViewX3 = x();
        wheelViewX3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(wheelViewX3);
        if (!TextUtils.isEmpty(this.t0)) {
            TextView textViewW6 = w();
            textViewW6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW6.setText(this.t0);
            linearLayout.addView(textViewW6);
        }
        wheelViewX.a(this.g0, this.j0);
        wheelViewX.setOnItemSelectListener(new a());
        wheelViewX2.a(this.h0, this.k0);
        wheelViewX2.setOnItemSelectListener(new b());
        wheelViewX3.a(this.i0, this.l0);
        wheelViewX3.setOnItemSelectListener(new c());
        return linearLayout;
    }

    public void setOnPickListener(d dVar) {
        this.n0 = dVar;
    }

    public void setOnWheelListener(e eVar) {
        this.m0 = eVar;
    }

    @Override // b.a.a.f.b
    public void v() {
        d dVar = this.n0;
        if (dVar != null) {
            dVar.a(this.j0, this.k0, this.l0);
        }
    }

    public String y() {
        int size = this.g0.size();
        int i2 = this.j0;
        return size > i2 ? this.g0.get(i2) : "";
    }

    public String z() {
        int size = this.h0.size();
        int i2 = this.k0;
        return size > i2 ? this.h0.get(i2) : "";
    }

    public void a(int i2, int i3, int i4) {
        if (i2 >= 0 && i2 < this.g0.size()) {
            this.j0 = i2;
        }
        if (i3 >= 0 && i3 < this.h0.size()) {
            this.k0 = i3;
        }
        if (i4 < 0 || i4 >= this.i0.size()) {
            return;
        }
        this.l0 = i4;
    }

    public void b(CharSequence charSequence, CharSequence charSequence2) {
        this.q0 = charSequence;
        this.r0 = charSequence2;
    }

    public void c(CharSequence charSequence, CharSequence charSequence2) {
        this.s0 = charSequence;
        this.t0 = charSequence2;
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.o0 = charSequence;
        this.p0 = charSequence2;
    }
}
