package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class j extends Drawable implements Drawable.Callback, Animatable {
    public static final int x = 1;
    public static final int y = 2;
    public static final int z = -1;

    /* renamed from: b, reason: collision with root package name */
    private com.airbnb.lottie.g f3543b;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.x.b f3551j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private String f3552k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.d f3553l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.x.a f3554m;

    @Nullable
    com.airbnb.lottie.c n;

    @Nullable
    v o;
    private boolean p;

    @Nullable
    private com.airbnb.lottie.y.l.b q;
    private boolean s;
    private boolean t;
    private boolean u;

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f3542a = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.b0.e f3544c = new com.airbnb.lottie.b0.e();

    /* renamed from: d, reason: collision with root package name */
    private float f3545d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3546e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3547f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3548g = false;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<r> f3549h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f3550i = new i();
    private int r = 255;
    private boolean v = true;
    private boolean w = false;

    /* compiled from: LottieDrawable.java */
    class a implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3555a;

        a(String str) {
            this.f3555a = str;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.d(this.f3555a);
        }
    }

    /* compiled from: LottieDrawable.java */
    class b implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3557a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3558b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3559c;

        b(String str, String str2, boolean z) {
            this.f3557a = str;
            this.f3558b = str2;
            this.f3559c = z;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.f3557a, this.f3558b, this.f3559c);
        }
    }

    /* compiled from: LottieDrawable.java */
    class c implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3561a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3562b;

        c(int i2, int i3) {
            this.f3561a = i2;
            this.f3562b = i3;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.f3561a, this.f3562b);
        }
    }

    /* compiled from: LottieDrawable.java */
    class d implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f3564a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f3565b;

        d(float f2, float f3) {
            this.f3564a = f2;
            this.f3565b = f3;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.f3564a, this.f3565b);
        }
    }

    /* compiled from: LottieDrawable.java */
    class e implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3567a;

        e(int i2) {
            this.f3567a = i2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.f3567a);
        }
    }

    /* compiled from: LottieDrawable.java */
    class f implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f3569a;

        f(float f2) {
            this.f3569a = f2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.c(this.f3569a);
        }
    }

    /* compiled from: LottieDrawable.java */
    class g implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.y.e f3571a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f3572b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.c0.j f3573c;

        g(com.airbnb.lottie.y.e eVar, Object obj, com.airbnb.lottie.c0.j jVar) {
            this.f3571a = eVar;
            this.f3572b = obj;
            this.f3573c = jVar;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.f3571a, (com.airbnb.lottie.y.e) this.f3572b, (com.airbnb.lottie.c0.j<com.airbnb.lottie.y.e>) this.f3573c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LottieDrawable.java */
    class h<T> extends com.airbnb.lottie.c0.j<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.c0.l f3575d;

        h(com.airbnb.lottie.c0.l lVar) {
            this.f3575d = lVar;
        }

        @Override // com.airbnb.lottie.c0.j
        public T a(com.airbnb.lottie.c0.b<T> bVar) {
            return (T) this.f3575d.a(bVar);
        }
    }

    /* compiled from: LottieDrawable.java */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (j.this.q != null) {
                j.this.q.a(j.this.f3544c.f());
            }
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$j, reason: collision with other inner class name */
    class C0049j implements r {
        C0049j() {
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.y();
        }
    }

    /* compiled from: LottieDrawable.java */
    class k implements r {
        k() {
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.B();
        }
    }

    /* compiled from: LottieDrawable.java */
    class l implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3580a;

        l(int i2) {
            this.f3580a = i2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.c(this.f3580a);
        }
    }

    /* compiled from: LottieDrawable.java */
    class m implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f3582a;

        m(float f2) {
            this.f3582a = f2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.b(this.f3582a);
        }
    }

    /* compiled from: LottieDrawable.java */
    class n implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3584a;

        n(int i2) {
            this.f3584a = i2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.b(this.f3584a);
        }
    }

    /* compiled from: LottieDrawable.java */
    class o implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f3586a;

        o(float f2) {
            this.f3586a = f2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.f3586a);
        }
    }

    /* compiled from: LottieDrawable.java */
    class p implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3588a;

        p(String str) {
            this.f3588a = str;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.e(this.f3588a);
        }
    }

    /* compiled from: LottieDrawable.java */
    class q implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3590a;

        q(String str) {
            this.f3590a = str;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.c(this.f3590a);
        }
    }

    /* compiled from: LottieDrawable.java */
    private interface r {
        void a(com.airbnb.lottie.g gVar);
    }

    /* compiled from: LottieDrawable.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface s {
    }

    public j() {
        this.f3544c.addUpdateListener(this.f3550i);
    }

    private boolean E() {
        return this.f3546e || this.f3547f;
    }

    private boolean F() {
        com.airbnb.lottie.g gVar = this.f3543b;
        return gVar == null || getBounds().isEmpty() || a(getBounds()) == a(gVar.a());
    }

    private void G() {
        this.q = new com.airbnb.lottie.y.l.b(this, com.airbnb.lottie.a0.s.a(this.f3543b), this.f3543b.i(), this.f3543b);
        if (this.t) {
            this.q.a(true);
        }
    }

    @Nullable
    private Context H() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private com.airbnb.lottie.x.a I() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f3554m == null) {
            this.f3554m = new com.airbnb.lottie.x.a(getCallback(), this.n);
        }
        return this.f3554m;
    }

    private com.airbnb.lottie.x.b J() {
        if (getCallback() == null) {
            return null;
        }
        com.airbnb.lottie.x.b bVar = this.f3551j;
        if (bVar != null && !bVar.a(H())) {
            this.f3551j = null;
        }
        if (this.f3551j == null) {
            this.f3551j = new com.airbnb.lottie.x.b(getCallback(), this.f3552k, this.f3553l, this.f3543b.h());
        }
        return this.f3551j;
    }

    public void A() {
        this.f3544c.removeAllUpdateListeners();
        this.f3544c.addUpdateListener(this.f3550i);
    }

    @MainThread
    public void B() {
        if (this.q == null) {
            this.f3549h.add(new k());
            return;
        }
        if (E() || m() == 0) {
            this.f3544c.o();
        }
        if (E()) {
            return;
        }
        a((int) (p() < 0.0f ? j() : i()));
        this.f3544c.e();
    }

    public void C() {
        this.f3544c.p();
    }

    public boolean D() {
        return this.o == null && this.f3543b.b().size() > 0;
    }

    public void c(boolean z2) {
        this.u = z2;
    }

    public boolean d() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.w = false;
        com.airbnb.lottie.e.a("Drawable#draw");
        if (this.f3548g) {
            try {
                a(canvas);
            } catch (Throwable th) {
                com.airbnb.lottie.b0.d.b("Lottie crashed in draw!", th);
            }
        } else {
            a(canvas);
        }
        com.airbnb.lottie.e.b("Drawable#draw");
    }

    public void e(boolean z2) {
        if (this.t == z2) {
            return;
        }
        this.t = z2;
        com.airbnb.lottie.y.l.b bVar = this.q;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    public void f(boolean z2) {
        this.s = z2;
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar != null) {
            gVar.b(z2);
        }
    }

    public void g(boolean z2) {
        this.f3548g = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f3543b == null) {
            return -1;
        }
        return (int) (r0.a().height() * o());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f3543b == null) {
            return -1;
        }
        return (int) (r0.a().width() * o());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Nullable
    public String h() {
        return this.f3552k;
    }

    public float i() {
        return this.f3544c.h();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.w) {
            return;
        }
        this.w = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return t();
    }

    public float j() {
        return this.f3544c.i();
    }

    @Nullable
    public com.airbnb.lottie.s k() {
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar != null) {
            return gVar.l();
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float l() {
        return this.f3544c.f();
    }

    public int m() {
        return this.f3544c.getRepeatCount();
    }

    @SuppressLint({"WrongConstant"})
    public int n() {
        return this.f3544c.getRepeatMode();
    }

    public float o() {
        return this.f3545d;
    }

    public float p() {
        return this.f3544c.j();
    }

    @Nullable
    public v q() {
        return this.o;
    }

    public boolean r() {
        com.airbnb.lottie.y.l.b bVar = this.q;
        return bVar != null && bVar.e();
    }

    public boolean s() {
        com.airbnb.lottie.y.l.b bVar = this.q;
        return bVar != null && bVar.f();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.r = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        com.airbnb.lottie.b0.d.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        y();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        e();
    }

    public boolean t() {
        com.airbnb.lottie.b0.e eVar = this.f3544c;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean u() {
        return this.u;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public boolean v() {
        return this.f3544c.getRepeatCount() == -1;
    }

    public boolean w() {
        return this.p;
    }

    public void x() {
        this.f3549h.clear();
        this.f3544c.k();
    }

    @MainThread
    public void y() {
        if (this.q == null) {
            this.f3549h.add(new C0049j());
            return;
        }
        if (E() || m() == 0) {
            this.f3544c.l();
        }
        if (E()) {
            return;
        }
        a((int) (p() < 0.0f ? j() : i()));
        this.f3544c.e();
    }

    public void z() {
        this.f3544c.removeAllListeners();
    }

    public void a(boolean z2) {
        if (this.p == z2) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.airbnb.lottie.b0.d.b("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.p = z2;
        if (this.f3543b != null) {
            G();
        }
    }

    public void b(@Nullable String str) {
        this.f3552k = str;
    }

    public void c() {
        this.v = false;
    }

    public void d(String str) {
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar == null) {
            this.f3549h.add(new a(str));
            return;
        }
        com.airbnb.lottie.y.h hVarB = gVar.b(str);
        if (hVarB != null) {
            int i2 = (int) hVarB.f3834b;
            a(i2, ((int) hVarB.f3835c) + i2);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public int g() {
        return (int) this.f3544c.g();
    }

    public void b() {
        if (this.f3544c.isRunning()) {
            this.f3544c.cancel();
        }
        this.f3543b = null;
        this.q = null;
        this.f3551j = null;
        this.f3544c.d();
        invalidateSelf();
    }

    public void c(int i2) {
        if (this.f3543b == null) {
            this.f3549h.add(new l(i2));
        } else {
            this.f3544c.a(i2);
        }
    }

    public com.airbnb.lottie.g f() {
        return this.f3543b;
    }

    @MainThread
    public void e() {
        this.f3549h.clear();
        this.f3544c.e();
    }

    public void c(String str) {
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar == null) {
            this.f3549h.add(new q(str));
            return;
        }
        com.airbnb.lottie.y.h hVarB = gVar.b(str);
        if (hVarB != null) {
            b((int) (hVarB.f3834b + hVarB.f3835c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void e(String str) {
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar == null) {
            this.f3549h.add(new p(str));
            return;
        }
        com.airbnb.lottie.y.h hVarB = gVar.b(str);
        if (hVarB != null) {
            c((int) hVarB.f3834b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public boolean a(com.airbnb.lottie.g gVar) {
        if (this.f3543b == gVar) {
            return false;
        }
        this.w = false;
        b();
        this.f3543b = gVar;
        G();
        this.f3544c.a(gVar);
        c(this.f3544c.getAnimatedFraction());
        d(this.f3545d);
        Iterator it = new ArrayList(this.f3549h).iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.a(gVar);
            }
            it.remove();
        }
        this.f3549h.clear();
        gVar.b(this.s);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void d(int i2) {
        this.f3544c.setRepeatCount(i2);
    }

    public void d(boolean z2) {
        this.f3547f = z2;
    }

    public void b(float f2) {
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar == null) {
            this.f3549h.add(new m(f2));
        } else {
            c((int) com.airbnb.lottie.b0.g.c(gVar.m(), this.f3543b.e(), f2));
        }
    }

    public void d(float f2) {
        this.f3545d = f2;
    }

    private float d(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f3543b.a().width(), canvas.getHeight() / this.f3543b.a().height());
    }

    public void c(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f3543b == null) {
            this.f3549h.add(new f(f2));
            return;
        }
        com.airbnb.lottie.e.a("Drawable#setProgress");
        this.f3544c.a(this.f3543b.a(f2));
        com.airbnb.lottie.e.b("Drawable#setProgress");
    }

    public void e(float f2) {
        this.f3544c.c(f2);
    }

    public void b(int i2) {
        if (this.f3543b == null) {
            this.f3549h.add(new n(i2));
        } else {
            this.f3544c.b(i2 + 0.99f);
        }
    }

    public void e(int i2) {
        this.f3544c.setRepeatMode(i2);
    }

    private void c(Canvas canvas) {
        float f2;
        if (this.q == null) {
            return;
        }
        float f3 = this.f3545d;
        float fD = d(canvas);
        if (f3 > fD) {
            f2 = this.f3545d / fD;
        } else {
            fD = f3;
            f2 = 1.0f;
        }
        int iSave = -1;
        if (f2 > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.f3543b.a().width() / 2.0f;
            float fHeight = this.f3543b.a().height() / 2.0f;
            float f4 = fWidth * fD;
            float f5 = fHeight * fD;
            canvas.translate((o() * fWidth) - f4, (o() * fHeight) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.f3542a.reset();
        this.f3542a.preScale(fD, fD);
        this.q.a(canvas, this.f3542a, this.r);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3544c.removeUpdateListener(animatorUpdateListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f3544c.removeListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void b(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3544c.removePauseListener(animatorPauseListener);
    }

    @Deprecated
    public void b(boolean z2) {
        this.f3544c.setRepeatCount(z2 ? -1 : 0);
    }

    private void b(Canvas canvas) {
        float f2;
        if (this.q == null) {
            return;
        }
        int iSave = -1;
        Rect bounds = getBounds();
        float fWidth = bounds.width() / this.f3543b.a().width();
        float fHeight = bounds.height() / this.f3543b.a().height();
        if (this.v) {
            float fMin = Math.min(fWidth, fHeight);
            if (fMin < 1.0f) {
                f2 = 1.0f / fMin;
                fWidth /= f2;
                fHeight /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                iSave = canvas.save();
                float fWidth2 = bounds.width() / 2.0f;
                float fHeight2 = bounds.height() / 2.0f;
                float f3 = fWidth2 * fMin;
                float f4 = fMin * fHeight2;
                canvas.translate(fWidth2 - f3, fHeight2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.f3542a.reset();
        this.f3542a.preScale(fWidth, fHeight);
        this.q.a(canvas, this.f3542a, this.r);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    private void a(@NonNull Canvas canvas) {
        if (!F()) {
            b(canvas);
        } else {
            c(canvas);
        }
    }

    private float a(Rect rect) {
        return rect.width() / rect.height();
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar == null) {
            this.f3549h.add(new o(f2));
        } else {
            b((int) com.airbnb.lottie.b0.g.c(gVar.m(), this.f3543b.e(), f2));
        }
    }

    public void a(String str, String str2, boolean z2) {
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar == null) {
            this.f3549h.add(new b(str, str2, z2));
            return;
        }
        com.airbnb.lottie.y.h hVarB = gVar.b(str);
        if (hVarB != null) {
            int i2 = (int) hVarB.f3834b;
            com.airbnb.lottie.y.h hVarB2 = this.f3543b.b(str2);
            if (hVarB2 != null) {
                a(i2, (int) (hVarB2.f3834b + (z2 ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void a(int i2, int i3) {
        if (this.f3543b == null) {
            this.f3549h.add(new c(i2, i3));
        } else {
            this.f3544c.a(i2, i3 + 0.99f);
        }
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        com.airbnb.lottie.g gVar = this.f3543b;
        if (gVar == null) {
            this.f3549h.add(new d(f2, f3));
        } else {
            a((int) com.airbnb.lottie.b0.g.c(gVar.m(), this.f3543b.e(), f2), (int) com.airbnb.lottie.b0.g.c(this.f3543b.m(), this.f3543b.e(), f3));
        }
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3544c.addUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f3544c.addListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void a(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3544c.addPauseListener(animatorPauseListener);
    }

    public void a(int i2) {
        if (this.f3543b == null) {
            this.f3549h.add(new e(i2));
        } else {
            this.f3544c.a(i2);
        }
    }

    void a(Boolean bool) {
        this.f3546e = bool.booleanValue();
    }

    public void a(com.airbnb.lottie.d dVar) {
        this.f3553l = dVar;
        com.airbnb.lottie.x.b bVar = this.f3551j;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void a(com.airbnb.lottie.c cVar) {
        this.n = cVar;
        com.airbnb.lottie.x.a aVar = this.f3554m;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    public void a(v vVar) {
        this.o = vVar;
    }

    public void a() {
        this.f3549h.clear();
        this.f3544c.cancel();
    }

    public List<com.airbnb.lottie.y.e> a(com.airbnb.lottie.y.e eVar) {
        if (this.q == null) {
            com.airbnb.lottie.b0.d.b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.q.a(eVar, 0, arrayList, new com.airbnb.lottie.y.e(new String[0]));
        return arrayList;
    }

    public <T> void a(com.airbnb.lottie.y.e eVar, T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        com.airbnb.lottie.y.l.b bVar = this.q;
        if (bVar == null) {
            this.f3549h.add(new g(eVar, t, jVar));
            return;
        }
        boolean zIsEmpty = true;
        if (eVar == com.airbnb.lottie.y.e.f3827c) {
            bVar.a((com.airbnb.lottie.y.l.b) t, (com.airbnb.lottie.c0.j<com.airbnb.lottie.y.l.b>) jVar);
        } else if (eVar.a() != null) {
            eVar.a().a(t, jVar);
        } else {
            List<com.airbnb.lottie.y.e> listA = a(eVar);
            for (int i2 = 0; i2 < listA.size(); i2++) {
                listA.get(i2).a().a(t, jVar);
            }
            zIsEmpty = true ^ listA.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == com.airbnb.lottie.o.C) {
                c(l());
            }
        }
    }

    public <T> void a(com.airbnb.lottie.y.e eVar, T t, com.airbnb.lottie.c0.l<T> lVar) {
        a(eVar, (com.airbnb.lottie.y.e) t, (com.airbnb.lottie.c0.j<com.airbnb.lottie.y.e>) new h(lVar));
    }

    @Nullable
    public Bitmap a(String str, @Nullable Bitmap bitmap) {
        com.airbnb.lottie.x.b bVarJ = J();
        if (bVarJ == null) {
            com.airbnb.lottie.b0.d.b("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapA = bVarJ.a(str, bitmap);
        invalidateSelf();
        return bitmapA;
    }

    @Nullable
    public Bitmap a(String str) {
        com.airbnb.lottie.x.b bVarJ = J();
        if (bVarJ != null) {
            return bVarJ.a(str);
        }
        com.airbnb.lottie.g gVar = this.f3543b;
        com.airbnb.lottie.k kVar = gVar == null ? null : gVar.h().get(str);
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    @Nullable
    public Typeface a(String str, String str2) {
        com.airbnb.lottie.x.a aVarI = I();
        if (aVarI != null) {
            return aVarI.a(str, str2);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.y.l.b bVar = this.q;
        if (bVar == null) {
            return;
        }
        bVar.a(canvas, matrix, this.r);
    }
}
