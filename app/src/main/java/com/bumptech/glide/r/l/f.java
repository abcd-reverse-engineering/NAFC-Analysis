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
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CustomViewTarget.java */
/* loaded from: classes.dex */
public abstract class f<T extends View, Z> implements p<Z> {

    /* renamed from: f, reason: collision with root package name */
    private static final String f5273f = "CustomViewTarget";

    /* renamed from: g, reason: collision with root package name */
    @IdRes
    private static final int f5274g = R.id.glide_custom_view_target_tag;

    /* renamed from: a, reason: collision with root package name */
    private final b f5275a;

    /* renamed from: b, reason: collision with root package name */
    protected final T f5276b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f5277c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5278d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5279e;

    /* compiled from: CustomViewTarget.java */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f.this.e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f.this.d();
        }
    }

    public f(@NonNull T t) {
        this.f5276b = (T) com.bumptech.glide.util.j.a(t);
        this.f5275a = new b(t);
    }

    @Nullable
    private Object g() {
        return this.f5276b.getTag(f5274g);
    }

    private void h() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5277c;
        if (onAttachStateChangeListener == null || this.f5279e) {
            return;
        }
        this.f5276b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f5279e = true;
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5277c;
        if (onAttachStateChangeListener == null || !this.f5279e) {
            return;
        }
        this.f5276b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f5279e = false;
    }

    @Deprecated
    public final f<T, Z> a(@IdRes int i2) {
        return this;
    }

    @Override // com.bumptech.glide.r.l.p
    public final void a(@NonNull o oVar) {
        this.f5275a.b(oVar);
    }

    @NonNull
    public final f<T, Z> b() {
        if (this.f5277c != null) {
            return this;
        }
        this.f5277c = new a();
        h();
        return this;
    }

    @NonNull
    public final T c() {
        return this.f5276b;
    }

    final void d() {
        com.bumptech.glide.r.d dVarA = a();
        if (dVarA != null) {
            this.f5278d = true;
            dVarA.clear();
            this.f5278d = false;
        }
    }

    protected abstract void d(@Nullable Drawable drawable);

    final void e() {
        com.bumptech.glide.r.d dVarA = a();
        if (dVarA == null || !dVarA.b()) {
            return;
        }
        dVarA.c();
    }

    protected void e(@Nullable Drawable drawable) {
    }

    @NonNull
    public final f<T, Z> f() {
        this.f5275a.f5285c = true;
        return this;
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    public String toString() {
        return "Target for: " + this.f5276b;
    }

    /* compiled from: CustomViewTarget.java */
    @VisibleForTesting
    static final class b {

        /* renamed from: e, reason: collision with root package name */
        private static final int f5281e = 0;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f5282f;

        /* renamed from: a, reason: collision with root package name */
        private final View f5283a;

        /* renamed from: b, reason: collision with root package name */
        private final List<o> f5284b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        boolean f5285c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private a f5286d;

        /* compiled from: CustomViewTarget.java */
        private static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<b> f5287a;

            a(@NonNull b bVar) {
                this.f5287a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(f.f5273f, 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                b bVar = this.f5287a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }
        }

        b(@NonNull View view) {
            this.f5283a = view;
        }

        private static int a(@NonNull Context context) {
            if (f5282f == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.util.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f5282f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f5282f.intValue();
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private void b(int i2, int i3) {
            Iterator it = new ArrayList(this.f5284b).iterator();
            while (it.hasNext()) {
                ((o) it.next()).a(i2, i3);
            }
        }

        private int c() {
            int paddingTop = this.f5283a.getPaddingTop() + this.f5283a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f5283a.getLayoutParams();
            return a(this.f5283a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f5283a.getPaddingLeft() + this.f5283a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f5283a.getLayoutParams();
            return a(this.f5283a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        void b(@NonNull o oVar) {
            this.f5284b.remove(oVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f5283a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f5286d);
            }
            this.f5286d = null;
            this.f5284b.clear();
        }

        void a() {
            if (this.f5284b.isEmpty()) {
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
            if (!this.f5284b.contains(oVar)) {
                this.f5284b.add(oVar);
            }
            if (this.f5286d == null) {
                ViewTreeObserver viewTreeObserver = this.f5283a.getViewTreeObserver();
                this.f5286d = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.f5286d);
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
            if (this.f5285c && this.f5283a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f5283a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable(f.f5273f, 4);
            return a(this.f5283a.getContext());
        }
    }

    @Override // com.bumptech.glide.r.l.p
    public final void a(@Nullable com.bumptech.glide.r.d dVar) {
        a((Object) dVar);
    }

    @Override // com.bumptech.glide.r.l.p
    public final void c(@Nullable Drawable drawable) {
        this.f5275a.b();
        d(drawable);
        if (this.f5278d) {
            return;
        }
        i();
    }

    @Override // com.bumptech.glide.r.l.p
    @Nullable
    public final com.bumptech.glide.r.d a() {
        Object objG = g();
        if (objG == null) {
            return null;
        }
        if (objG instanceof com.bumptech.glide.r.d) {
            return (com.bumptech.glide.r.d) objG;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.r.l.p
    public final void b(@NonNull o oVar) {
        this.f5275a.a(oVar);
    }

    @Override // com.bumptech.glide.r.l.p
    public final void b(@Nullable Drawable drawable) {
        h();
        e(drawable);
    }

    private void a(@Nullable Object obj) {
        this.f5276b.setTag(f5274g, obj);
    }
}
