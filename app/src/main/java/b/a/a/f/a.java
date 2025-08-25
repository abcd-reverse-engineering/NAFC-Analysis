package b.a.a.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.StyleRes;
import b.a.a.g.d;
import b.a.a.g.e;

/* compiled from: BasicPopup.java */
/* loaded from: classes.dex */
public abstract class a<V extends View> implements DialogInterface.OnKeyListener, DialogInterface.OnDismissListener {

    /* renamed from: g, reason: collision with root package name */
    public static final int f2287g = -1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f2288h = -2;

    /* renamed from: a, reason: collision with root package name */
    protected Activity f2289a;

    /* renamed from: b, reason: collision with root package name */
    protected int f2290b;

    /* renamed from: c, reason: collision with root package name */
    protected int f2291c;

    /* renamed from: d, reason: collision with root package name */
    private Dialog f2292d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f2293e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2294f = false;

    /* compiled from: BasicPopup.java */
    /* renamed from: b.a.a.f.a$a, reason: collision with other inner class name */
    class DialogInterfaceOnDismissListenerC0029a implements DialogInterface.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f2295a;

        DialogInterfaceOnDismissListenerC0029a(DialogInterface.OnDismissListener onDismissListener) {
            this.f2295a = onDismissListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.onDismiss(dialogInterface);
            this.f2295a.onDismiss(dialogInterface);
        }
    }

    /* compiled from: BasicPopup.java */
    class b implements DialogInterface.OnKeyListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnKeyListener f2297a;

        b(DialogInterface.OnKeyListener onKeyListener) {
            this.f2297a = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            a.this.onKey(dialogInterface, i2, keyEvent);
            return this.f2297a.onKey(dialogInterface, i2, keyEvent);
        }
    }

    public a(Activity activity) {
        this.f2289a = activity;
        DisplayMetrics displayMetricsC = e.c(activity);
        this.f2290b = displayMetricsC.widthPixels;
        this.f2291c = displayMetricsC.heightPixels;
        o();
    }

    private void o() {
        this.f2293e = new FrameLayout(this.f2289a);
        this.f2293e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f2293e.setFocusable(true);
        this.f2293e.setFocusableInTouchMode(true);
        this.f2292d = new Dialog(this.f2289a);
        this.f2292d.setCanceledOnTouchOutside(true);
        this.f2292d.setCancelable(true);
        this.f2292d.setOnKeyListener(this);
        this.f2292d.setOnDismissListener(this);
        Window window = this.f2292d.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
            window.setContentView(this.f2293e);
        }
        a(this.f2290b, -2);
    }

    public void a(View view) {
        this.f2293e.removeAllViews();
        this.f2293e.addView(view);
    }

    public void b(int i2) {
        Window window = this.f2292d.getWindow();
        if (window != null) {
            window.setGravity(i2);
        }
        if (i2 == 17) {
            d((int) (this.f2290b * 0.7f));
        }
    }

    protected void b(V v) {
    }

    public void c(boolean z) {
        if (z) {
            a(this.f2290b, (int) (this.f2291c * 0.85f));
        }
    }

    public void d(boolean z) {
        this.f2293e.setFitsSystemWindows(z);
    }

    public void e(boolean z) {
        if (z) {
            a(this.f2290b, this.f2291c / 2);
        }
    }

    public int f() {
        return this.f2291c;
    }

    public int g() {
        return this.f2290b;
    }

    public Window h() {
        return this.f2292d.getWindow();
    }

    public boolean i() {
        return this.f2292d.isShowing();
    }

    protected abstract V j();

    public boolean k() {
        a();
        return false;
    }

    protected void l() {
    }

    public final void m() {
        if (this.f2294f) {
            this.f2292d.show();
            n();
            return;
        }
        d.c(this, "do something before popup show");
        l();
        View viewJ = j();
        a(viewJ);
        b((a<V>) viewJ);
        this.f2294f = true;
        this.f2292d.show();
        n();
    }

    protected void n() {
        d.c(this, "popup show");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i2 != 4) {
            return false;
        }
        k();
        return false;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f2292d.setOnDismissListener(new DialogInterfaceOnDismissListenerC0029a(onDismissListener));
        d.c(this, "popup setOnDismissListener");
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.f2292d.setOnKeyListener(new b(onKeyListener));
        d.c(this, "popup setOnKeyListener");
    }

    public void c(int i2) {
        a(0, i2);
    }

    public void d(int i2) {
        a(i2, 0);
    }

    public ViewGroup e() {
        return this.f2293e;
    }

    public void f(boolean z) {
        this.f2294f = z;
    }

    public void a(@StyleRes int i2) {
        Window window = this.f2292d.getWindow();
        if (window != null) {
            window.setWindowAnimations(i2);
        }
    }

    public View c() {
        return this.f2293e.getChildAt(0);
    }

    public Context d() {
        return this.f2292d.getContext();
    }

    public void b(boolean z) {
        this.f2292d.setCanceledOnTouchOutside(z);
    }

    public void a(boolean z) {
        this.f2292d.setCancelable(z);
    }

    protected final void b() {
        this.f2292d.dismiss();
        d.c(this, "popup dismiss");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r4, int r5) {
        /*
            r3 = this;
            r0 = -1
            if (r4 != r0) goto L5
            int r4 = r3.f2290b
        L5:
            r0 = -2
            if (r4 != 0) goto Le
            if (r5 != 0) goto Le
            int r4 = r3.f2290b
        Lc:
            r5 = -2
            goto L16
        Le:
            if (r4 != 0) goto L13
            int r4 = r3.f2290b
            goto L16
        L13:
            if (r5 != 0) goto L16
            goto Lc
        L16:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0[r1] = r2
            r1 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r0[r1] = r2
            java.lang.String r1 = "will set popup width/height to: %s/%s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            b.a.a.g.d.c(r3, r0)
            android.widget.FrameLayout r0 = r3.f2293e
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 != 0) goto L3f
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r0.<init>(r4, r5)
            goto L43
        L3f:
            r0.width = r4
            r0.height = r5
        L43:
            android.widget.FrameLayout r4 = r3.f2293e
            r4.setLayoutParams(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.f.a.a(int, int):void");
    }

    public void a() {
        b();
    }
}
