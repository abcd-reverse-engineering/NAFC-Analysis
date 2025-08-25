package b.a.a.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DoublePicker.java */
/* loaded from: classes.dex */
public class e extends k {
    private List<String> g0;
    private List<String> h0;
    private int i0;
    private int j0;
    private d k0;
    private c l0;
    private CharSequence m0;
    private CharSequence n0;
    private CharSequence o0;
    private CharSequence p0;

    /* compiled from: DoublePicker.java */
    class a implements WheelView.g {
        a() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            e.this.i0 = i2;
            if (e.this.k0 != null) {
                e.this.k0.g(e.this.i0, (String) e.this.g0.get(e.this.i0));
            }
        }
    }

    /* compiled from: DoublePicker.java */
    class b implements WheelView.g {
        b() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            e.this.j0 = i2;
            if (e.this.k0 != null) {
                e.this.k0.f(e.this.j0, (String) e.this.h0.get(e.this.j0));
            }
        }
    }

    /* compiled from: DoublePicker.java */
    public interface c {
        void a(int i2, int i3);
    }

    /* compiled from: DoublePicker.java */
    public interface d {
        void f(int i2, String str);

        void g(int i2, String str);
    }

    public e(Activity activity, List<String> list, List<String> list2) {
        super(activity);
        this.g0 = new ArrayList();
        this.h0 = new ArrayList();
        this.i0 = 0;
        this.j0 = 0;
        this.g0 = list;
        this.h0 = list2;
    }

    @Override // b.a.a.f.b
    @NonNull
    protected View r() {
        LinearLayout linearLayout = new LinearLayout(this.f2289a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        if (!TextUtils.isEmpty(this.m0)) {
            TextView textViewW = w();
            textViewW.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW.setText(this.m0);
            linearLayout.addView(textViewW);
        }
        WheelView wheelViewX = x();
        wheelViewX.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(wheelViewX);
        if (!TextUtils.isEmpty(this.n0)) {
            TextView textViewW2 = w();
            textViewW2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW2.setText(this.n0);
            linearLayout.addView(textViewW2);
        }
        if (!TextUtils.isEmpty(this.o0)) {
            TextView textViewW3 = w();
            textViewW3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW3.setText(this.o0);
            linearLayout.addView(textViewW3);
        }
        WheelView wheelViewX2 = x();
        wheelViewX2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(wheelViewX2);
        if (!TextUtils.isEmpty(this.p0)) {
            TextView textViewW4 = w();
            textViewW4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewW4.setText(this.p0);
            linearLayout.addView(textViewW4);
        }
        wheelViewX.a(this.g0, this.i0);
        wheelViewX.setOnItemSelectListener(new a());
        wheelViewX2.a(this.h0, this.j0);
        wheelViewX2.setOnItemSelectListener(new b());
        return linearLayout;
    }

    public void setOnPickListener(c cVar) {
        this.l0 = cVar;
    }

    public void setOnWheelListener(d dVar) {
        this.k0 = dVar;
    }

    @Override // b.a.a.f.b
    public void v() {
        c cVar = this.l0;
        if (cVar != null) {
            cVar.a(this.i0, this.j0);
        }
    }

    public String y() {
        int size = this.g0.size();
        int i2 = this.i0;
        return size > i2 ? this.g0.get(i2) : "";
    }

    public String z() {
        int size = this.h0.size();
        int i2 = this.j0;
        return size > i2 ? this.h0.get(i2) : "";
    }

    public void e(int i2, int i3) {
        if (i2 >= 0 && i2 < this.g0.size()) {
            this.i0 = i2;
        }
        if (i3 < 0 || i3 >= this.h0.size()) {
            return;
        }
        this.j0 = i3;
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.m0 = charSequence;
        this.n0 = charSequence2;
    }

    public void b(CharSequence charSequence, CharSequence charSequence2) {
        this.o0 = charSequence;
        this.p0 = charSequence2;
    }
}
