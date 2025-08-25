package b.a.a.f;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* compiled from: ConfirmPopup.java */
/* loaded from: classes.dex */
public abstract class b<V extends View> extends b.a.a.f.a<View> {
    protected int A;
    protected int B;
    protected TextView C;
    protected TextView D;
    protected View E;
    protected View F;
    protected View G;
    protected View H;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f2299i;

    /* renamed from: j, reason: collision with root package name */
    protected int f2300j;

    /* renamed from: k, reason: collision with root package name */
    protected int f2301k;

    /* renamed from: l, reason: collision with root package name */
    protected int f2302l;

    /* renamed from: m, reason: collision with root package name */
    protected int f2303m;
    protected int n;
    protected int o;
    protected int p;
    protected boolean q;
    protected CharSequence r;
    protected CharSequence s;
    protected CharSequence t;
    protected int u;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected int z;

    /* compiled from: ConfirmPopup.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a();
            b.this.u();
        }
    }

    /* compiled from: ConfirmPopup.java */
    /* renamed from: b.a.a.f.b$b, reason: collision with other inner class name */
    class ViewOnClickListenerC0030b implements View.OnClickListener {
        ViewOnClickListenerC0030b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a();
            b.this.v();
        }
    }

    public b(Activity activity) {
        super(activity);
        this.f2299i = true;
        this.f2300j = -13388315;
        this.f2301k = 1;
        this.f2302l = -1;
        this.f2303m = 40;
        this.n = 15;
        this.o = 0;
        this.p = 0;
        this.q = true;
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = -13388315;
        this.v = -13388315;
        this.w = ViewCompat.MEASURED_STATE_MASK;
        this.x = WheelView.h0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = -1;
        this.r = activity.getString(R.string.cancel);
        this.s = activity.getString(R.string.ok);
    }

    public void a(CharSequence charSequence) {
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.r = charSequence;
        }
    }

    public void b(int i2, int i3) {
        this.o = i2;
        this.p = i3;
    }

    public void c(CharSequence charSequence) {
        View view = this.E;
        if (view == null || !(view instanceof TextView)) {
            this.t = charSequence;
        } else {
            ((TextView) view).setText(charSequence);
        }
    }

    public void d(View view) {
        this.F = view;
    }

    public void e(@ColorInt int i2) {
        this.B = i2;
    }

    public void f(@StringRes int i2) {
        a(this.f2289a.getString(i2));
    }

    public void g(boolean z) {
        TextView textView = this.C;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        } else {
            this.q = z;
        }
    }

    public void h(boolean z) {
        this.f2299i = z;
    }

    public void i(int i2) {
        this.x = i2;
    }

    public void j(@StringRes int i2) {
        b(this.f2289a.getString(i2));
    }

    public void k(@ColorInt int i2) {
        TextView textView = this.D;
        if (textView != null) {
            textView.setTextColor(i2);
        } else {
            this.v = i2;
        }
    }

    public void l(@IntRange(from = 10, to = 40) int i2) {
        this.z = i2;
    }

    public void m(@StringRes int i2) {
        c(this.f2289a.getString(i2));
    }

    public void n(@ColorInt int i2) {
        View view = this.E;
        if (view == null || !(view instanceof TextView)) {
            this.w = i2;
        } else {
            ((TextView) view).setTextColor(i2);
        }
    }

    public void o(@IntRange(from = 10, to = 40) int i2) {
        this.A = i2;
    }

    public void p(@ColorInt int i2) {
        this.f2302l = i2;
    }

    public void q(@IntRange(from = 10, to = 80) int i2) {
        this.f2303m = i2;
    }

    @NonNull
    protected abstract V r();

    public void r(@ColorInt int i2) {
        this.f2300j = i2;
    }

    public void s(int i2) {
        this.f2301k = i2;
    }

    public void t(int i2) {
        this.n = i2;
    }

    protected void u() {
    }

    protected void v() {
    }

    public void e(View view) {
        this.E = view;
    }

    public void h(@IntRange(from = 10, to = 40) int i2) {
        this.y = i2;
    }

    @Override // b.a.a.f.a
    protected final View j() {
        LinearLayout linearLayout = new LinearLayout(this.f2289a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(this.B);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setClipToPadding(false);
        View viewT = t();
        if (viewT != null) {
            linearLayout.addView(viewT);
        }
        if (this.f2299i) {
            View view = new View(this.f2289a);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f2301k));
            view.setBackgroundColor(this.f2300j);
            linearLayout.addView(view);
        }
        if (this.G == null) {
            this.G = r();
        }
        int i2 = this.o;
        int iB = i2 > 0 ? b.a.a.g.b.b(this.f2289a, i2) : 0;
        int i3 = this.p;
        int iB2 = i3 > 0 ? b.a.a.g.b.b(this.f2289a, i3) : 0;
        this.G.setPadding(iB, iB2, iB, iB2);
        ViewGroup viewGroup = (ViewGroup) this.G.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.G);
        }
        linearLayout.addView(this.G, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        View viewS = s();
        if (viewS != null) {
            linearLayout.addView(viewS);
        }
        return linearLayout;
    }

    public TextView o() {
        TextView textView = this.C;
        if (textView != null) {
            return textView;
        }
        throw new NullPointerException("please call show at first");
    }

    public TextView p() {
        TextView textView = this.D;
        if (textView != null) {
            return textView;
        }
        throw new NullPointerException("please call show at first");
    }

    public View q() {
        View view = this.E;
        if (view != null) {
            return view;
        }
        throw new NullPointerException("please call show at first");
    }

    @Nullable
    protected View s() {
        View view = this.H;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Nullable
    protected View t() {
        View view = this.F;
        if (view != null) {
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f2289a);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, b.a.a.g.b.b(this.f2289a, this.f2303m)));
        relativeLayout.setBackgroundColor(this.f2302l);
        relativeLayout.setGravity(16);
        this.C = new TextView(this.f2289a);
        this.C.setVisibility(this.q ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        this.C.setLayoutParams(layoutParams);
        this.C.setBackgroundColor(0);
        this.C.setGravity(17);
        int iB = b.a.a.g.b.b(this.f2289a, this.n);
        this.C.setPadding(iB, 0, iB, 0);
        if (!TextUtils.isEmpty(this.r)) {
            this.C.setText(this.r);
        }
        this.C.setTextColor(b.a.a.g.b.a(this.u, this.x));
        int i2 = this.y;
        if (i2 != 0) {
            this.C.setTextSize(i2);
        }
        this.C.setOnClickListener(new a());
        relativeLayout.addView(this.C);
        if (this.E == null) {
            TextView textView = new TextView(this.f2289a);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            int iB2 = b.a.a.g.b.b(this.f2289a, this.n);
            layoutParams2.leftMargin = iB2;
            layoutParams2.rightMargin = iB2;
            layoutParams2.addRule(14, -1);
            layoutParams2.addRule(15, -1);
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(17);
            if (!TextUtils.isEmpty(this.t)) {
                textView.setText(this.t);
            }
            textView.setTextColor(this.w);
            int i3 = this.A;
            if (i3 != 0) {
                textView.setTextSize(i3);
            }
            this.E = textView;
        }
        relativeLayout.addView(this.E);
        this.D = new TextView(this.f2289a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        this.D.setLayoutParams(layoutParams3);
        this.D.setBackgroundColor(0);
        this.D.setGravity(17);
        this.D.setPadding(iB, 0, iB, 0);
        if (!TextUtils.isEmpty(this.s)) {
            this.D.setText(this.s);
        }
        this.D.setTextColor(b.a.a.g.b.a(this.v, this.x));
        int i4 = this.z;
        if (i4 != 0) {
            this.D.setTextSize(i4);
        }
        this.D.setOnClickListener(new ViewOnClickListenerC0030b());
        relativeLayout.addView(this.D);
        return relativeLayout;
    }

    public void b(CharSequence charSequence) {
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.s = charSequence;
        }
    }

    public void c(View view) {
        this.H = view;
    }

    public void g(@ColorInt int i2) {
        TextView textView = this.C;
        if (textView != null) {
            textView.setTextColor(i2);
        } else {
            this.u = i2;
        }
    }
}
