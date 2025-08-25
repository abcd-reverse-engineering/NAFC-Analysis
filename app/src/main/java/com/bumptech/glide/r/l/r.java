package com.bumptech.glide.r.l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class r<T extends View, Z> extends com.bumptech.glide.r.l.b<Z> {

    /* renamed from: g, reason: collision with root package name */
    private static final String f5309g = "ViewTarget";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f5310h;

    /* renamed from: i, reason: collision with root package name */
    private static int f5311i = R.id.glide_custom_view_target_tag;

    /* renamed from: b, reason: collision with root package name */
    protected final T f5312b;

    /* renamed from: c, reason: collision with root package name */
    private final b f5313c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f5314d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5315e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5316f;

    /* compiled from: ViewTarget.java */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.d();
        }
    }

    public r(@NonNull T t) {
        this.f5312b = (T) com.bumptech.glide.util.j.a(t);
        this.f5313c = new b(t);
    }

    @Nullable
    private Object g() {
        return this.f5312b.getTag(f5311i);
    }

    private void h() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5314d;
        if (onAttachStateChangeListener == null || this.f5316f) {
            return;
        }
        this.f5312b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f5316f = true;
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5314d;
        if (onAttachStateChangeListener == null || !this.f5316f) {
            return;
        }
        this.f5312b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f5316f = false;
    }

    @Override // com.bumptech.glide.r.l.p
    @CallSuper
    public void a(@NonNull o oVar) {
        this.f5313c.b(oVar);
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    @CallSuper
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        h();
    }

    @NonNull
    public final r<T, Z> c() {
        if (this.f5314d != null) {
            return this;
        }
        this.f5314d = new a();
        h();
        return this;
    }

    void d() {
        com.bumptech.glide.r.d dVarA = a();
        if (dVarA != null) {
            this.f5315e = true;
            dVarA.clear();
            this.f5315e = false;
        }
    }

    void e() {
        com.bumptech.glide.r.d dVarA = a();
        if (dVarA == null || !dVarA.b()) {
            return;
        }
        dVarA.c();
    }

    @NonNull
    public final r<T, Z> f() {
        this.f5313c.f5322c = true;
        return this;
    }

    @NonNull
    public T getView() {
        return this.f5312b;
    }

    public String toString() {
        return "Target for: " + this.f5312b;
    }

    /* compiled from: ViewTarget.java */
    @VisibleForTesting
    static final class b {

        /* renamed from: e, reason: collision with root package name */
        private static final int f5318e = 0;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f5319f;

        /* renamed from: a, reason: collision with root package name */
        private final View f5320a;

        /* renamed from: b, reason: collision with root package name */
        private final List<o> f5321b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        boolean f5322c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private a f5323d;

        /* compiled from: ViewTarget.java */
        private static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<b> f5324a;

            a(@NonNull b bVar) {
                this.f5324a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(r.f5309g, 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                b bVar = this.f5324a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }
        }

        b(@NonNull View view) {
            this.f5320a = view;
        }

        private static int a(@NonNull Context context) {
            if (f5319f == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.util.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f5319f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f5319f.intValue();
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private void b(int i2, int i3) {
            Iterator it = new ArrayList(this.f5321b).iterator();
            while (it.hasNext()) {
                ((o) it.next()).a(i2, i3);
            }
        }

        private int c() {
            int paddingTop = this.f5320a.getPaddingTop() + this.f5320a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f5320a.getLayoutParams();
            return a(this.f5320a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f5320a.getPaddingLeft() + this.f5320a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f5320a.getLayoutParams();
            return a(this.f5320a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        void b(@NonNull o oVar) {
            this.f5321b.remove(oVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f5320a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f5323d);
            }
            this.f5323d = null;
            this.f5321b.clear();
        }

        void a() {
            if (this.f5321b.isEmpty()) {
                return;
            }
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                b(iD, iC);
                b();
            }
        }

        void a(@NonNull o oVar) {
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                oVar.a(iD, iC);
                return;
            }
            if (!this.f5321b.contains(oVar)) {
                this.f5321b.add(oVar);
            }
            if (this.f5323d == null) {
                ViewTreeObserver viewTreeObserver = this.f5320a.getViewTreeObserver();
                this.f5323d = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.f5323d);
            }
        }

        private boolean a(int i2, int i3) {
            return a(i2) && a(i3);
        }

        private int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f5322c && this.f5320a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f5320a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable(r.f5309g, 4);
            return a(this.f5320a.getContext());
        }
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    public void a(@Nullable com.bumptech.glide.r.d dVar) {
        a((Object) dVar);
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    @Nullable
    public com.bumptech.glide.r.d a() {
        Object objG = g();
        if (objG == null) {
            return null;
        }
        if (objG instanceof com.bumptech.glide.r.d) {
            return (com.bumptech.glide.r.d) objG;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.r.l.p
    @CallSuper
    public void b(@NonNull o oVar) {
        this.f5313c.a(oVar);
    }

    @Deprecated
    public r(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            f();
        }
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    @CallSuper
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        this.f5313c.b();
        if (this.f5315e) {
            return;
        }
        i();
    }

    private void a(@Nullable Object obj) {
        f5310h = true;
        this.f5312b.setTag(f5311i, obj);
    }

    @Deprecated
    public static void a(int i2) {
        if (!f5310h) {
            f5311i = i2;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }
}
