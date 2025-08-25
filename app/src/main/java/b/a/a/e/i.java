package b.a.a.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: SinglePicker.java */
/* loaded from: classes.dex */
public class i<T> extends k {
    private static final int o0 = -99;
    private List<T> g0;
    private List<String> h0;
    private WheelView i0;
    private c<T> j0;
    private b<T> k0;
    private int l0;
    private String m0;
    private int n0;

    /* compiled from: SinglePicker.java */
    class a implements WheelView.g {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            i.this.l0 = i2;
            if (i.this.j0 != null) {
                i.this.j0.a(i.this.l0, i.this.g0.get(i2));
            }
        }
    }

    /* compiled from: SinglePicker.java */
    public interface b<T> {
        void a(int i2, T t);
    }

    /* compiled from: SinglePicker.java */
    public interface c<T> {
        void a(int i2, T t);
    }

    public i(Activity activity, T[] tArr) {
        this(activity, Arrays.asList(tArr));
    }

    private String d(T t) {
        return ((t instanceof Float) || (t instanceof Double)) ? new DecimalFormat("0.00").format(t) : t.toString();
    }

    public WheelView A() {
        return this.i0;
    }

    public void D(int i2) {
        WheelView wheelView = this.i0;
        if (wheelView == null) {
            this.n0 = i2;
            return;
        }
        ViewGroup.LayoutParams layoutParams = wheelView.getLayoutParams();
        layoutParams.width = b.a.a.g.b.b(this.f2289a, i2);
        this.i0.setLayoutParams(layoutParams);
    }

    public void E(int i2) {
        if (i2 < 0 || i2 >= this.g0.size()) {
            return;
        }
        this.l0 = i2;
    }

    @Override // b.a.a.f.b
    @NonNull
    protected View r() {
        if (this.g0.size() == 0) {
            throw new IllegalArgumentException("Items can't be empty");
        }
        LinearLayout linearLayout = new LinearLayout(this.f2289a);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.i0 = x();
        linearLayout.addView(this.i0);
        if (TextUtils.isEmpty(this.m0)) {
            this.i0.setLayoutParams(new LinearLayout.LayoutParams(this.f2290b, -2));
        } else {
            this.i0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            TextView textViewW = w();
            textViewW.setText(this.m0);
            linearLayout.addView(textViewW);
        }
        this.i0.a(this.h0, this.l0);
        this.i0.setOnItemSelectListener(new a());
        if (this.n0 != o0) {
            ViewGroup.LayoutParams layoutParams = this.i0.getLayoutParams();
            layoutParams.width = b.a.a.g.b.b(this.f2289a, this.n0);
            this.i0.setLayoutParams(layoutParams);
        }
        return linearLayout;
    }

    public void setOnItemPickListener(b<T> bVar) {
        this.k0 = bVar;
    }

    public void setOnWheelListener(c<T> cVar) {
        this.j0 = cVar;
    }

    @Override // b.a.a.f.b
    public void v() {
        b<T> bVar = this.k0;
        if (bVar != null) {
            bVar.a(this.l0, z());
        }
    }

    public int y() {
        return this.l0;
    }

    public T z() {
        return this.g0.get(this.l0);
    }

    public i(Activity activity, List<T> list) {
        super(activity);
        this.g0 = new ArrayList();
        this.h0 = new ArrayList();
        this.l0 = 0;
        this.m0 = "";
        this.n0 = o0;
        a((List) list);
    }

    public void b(T t) {
        this.g0.remove(t);
        this.h0.remove(d((i<T>) t));
    }

    public void c(@NonNull T t) {
        E(this.h0.indexOf(d((i<T>) t)));
    }

    public void a(T t) {
        this.g0.add(t);
        this.h0.add(d((i<T>) t));
    }

    public void a(T[] tArr) {
        a((List) Arrays.asList(tArr));
    }

    public void a(List<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.g0 = list;
        this.h0.clear();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.h0.add(d((i<T>) it.next()));
        }
        WheelView wheelView = this.i0;
        if (wheelView != null) {
            wheelView.a(this.h0, this.l0);
        }
    }

    public void a(String str) {
        this.m0 = str;
    }
}
