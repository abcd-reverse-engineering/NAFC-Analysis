package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class SmartRefreshLayout extends ViewGroup implements com.scwang.smartrefresh.layout.b.j, NestedScrollingParent {
    protected static com.scwang.smartrefresh.layout.b.a T0;
    protected static com.scwang.smartrefresh.layout.b.b U0;
    protected static com.scwang.smartrefresh.layout.b.c V0;
    protected boolean A;
    protected com.scwang.smartrefresh.layout.b.h A0;
    protected boolean B;
    protected com.scwang.smartrefresh.layout.b.h B0;
    protected boolean C;
    protected com.scwang.smartrefresh.layout.b.e C0;
    protected boolean D;
    protected Paint D0;
    protected boolean E;
    protected Handler E0;
    protected boolean F;
    protected com.scwang.smartrefresh.layout.b.i F0;
    protected boolean G;
    protected List<com.scwang.smartrefresh.layout.e.a> G0;
    protected boolean H;
    protected com.scwang.smartrefresh.layout.c.b H0;
    protected boolean I;
    protected com.scwang.smartrefresh.layout.c.b I0;
    protected boolean J;
    protected long J0;
    protected boolean K;
    protected int K0;
    protected boolean L;
    protected int L0;
    protected boolean M;
    protected boolean M0;
    protected boolean N;
    protected boolean N0;
    protected boolean O;
    protected boolean O0;
    protected boolean P0;
    protected MotionEvent Q0;
    protected Runnable R0;
    protected ValueAnimator S0;

    /* renamed from: a, reason: collision with root package name */
    protected int f8205a;

    /* renamed from: b, reason: collision with root package name */
    protected int f8206b;
    protected boolean b0;

    /* renamed from: c, reason: collision with root package name */
    protected int f8207c;
    protected boolean c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f8208d;
    protected boolean d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f8209e;
    protected boolean e0;

    /* renamed from: f, reason: collision with root package name */
    protected int f8210f;
    protected boolean f0;

    /* renamed from: g, reason: collision with root package name */
    protected int f8211g;
    protected boolean g0;

    /* renamed from: h, reason: collision with root package name */
    protected float f8212h;
    protected com.scwang.smartrefresh.layout.d.d h0;

    /* renamed from: i, reason: collision with root package name */
    protected float f8213i;
    protected com.scwang.smartrefresh.layout.d.b i0;

    /* renamed from: j, reason: collision with root package name */
    protected float f8214j;
    protected com.scwang.smartrefresh.layout.d.c j0;

    /* renamed from: k, reason: collision with root package name */
    protected float f8215k;
    protected com.scwang.smartrefresh.layout.b.k k0;

    /* renamed from: l, reason: collision with root package name */
    protected float f8216l;
    protected int l0;

    /* renamed from: m, reason: collision with root package name */
    protected char f8217m;
    protected boolean m0;
    protected boolean n;
    protected int[] n0;
    protected boolean o;
    protected NestedScrollingChildHelper o0;
    protected int p;
    protected NestedScrollingParentHelper p0;
    protected int q;
    protected int q0;
    protected int r;
    protected com.scwang.smartrefresh.layout.c.a r0;
    protected int s;
    protected int s0;
    protected int t;
    protected com.scwang.smartrefresh.layout.c.a t0;
    protected int u;
    protected int u0;
    protected int v;
    protected int v0;
    protected Scroller w;
    protected float w0;
    protected VelocityTracker x;
    protected float x0;
    protected Interpolator y;
    protected float y0;
    protected int[] z;
    protected float z0;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8218a = new int[com.scwang.smartrefresh.layout.c.b.values().length];

        static {
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.TwoLevelReleased.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.TwoLevelFinish.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8218a[com.scwang.smartrefresh.layout.c.b.TwoLevel.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.setStateDirectLoading(true);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.J0 = System.currentTimeMillis();
            SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.d.d dVar = smartRefreshLayout.h0;
            if (dVar != null) {
                dVar.a(smartRefreshLayout);
            } else if (smartRefreshLayout.j0 == null) {
                smartRefreshLayout.d(PathInterpolatorCompat.MAX_NUM_POINTS);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.b.h hVar = smartRefreshLayout2.A0;
            if (hVar != null) {
                int i2 = smartRefreshLayout2.q0;
                hVar.a(smartRefreshLayout2, i2, (int) (smartRefreshLayout2.w0 * i2));
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.d.c cVar = smartRefreshLayout3.j0;
            if (cVar == null || !(smartRefreshLayout3.A0 instanceof com.scwang.smartrefresh.layout.b.g)) {
                return;
            }
            cVar.a(smartRefreshLayout3);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.d.c cVar2 = smartRefreshLayout4.j0;
            com.scwang.smartrefresh.layout.b.g gVar = (com.scwang.smartrefresh.layout.b.g) smartRefreshLayout4.A0;
            int i3 = smartRefreshLayout4.q0;
            cVar2.b(gVar, i3, (int) (smartRefreshLayout4.w0 * i3));
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.S0 = null;
            if (smartRefreshLayout.f8206b != 0) {
                com.scwang.smartrefresh.layout.c.b bVar = smartRefreshLayout.H0;
                if (bVar != smartRefreshLayout.I0) {
                    smartRefreshLayout.setViceState(bVar);
                    return;
                }
                return;
            }
            com.scwang.smartrefresh.layout.c.b bVar2 = smartRefreshLayout.H0;
            com.scwang.smartrefresh.layout.c.b bVar3 = com.scwang.smartrefresh.layout.c.b.None;
            if (bVar2 == bVar3 || bVar2.isOpening) {
                return;
            }
            smartRefreshLayout.a(bVar3);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.F0.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.d.b bVar = smartRefreshLayout.i0;
            if (bVar != null) {
                bVar.b(smartRefreshLayout);
            } else if (smartRefreshLayout.j0 == null) {
                smartRefreshLayout.e(2000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.d.c cVar = smartRefreshLayout2.j0;
            if (cVar != null) {
                cVar.b(smartRefreshLayout2);
            }
        }
    }

    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8224a;

        g(boolean z) {
            this.f8224a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.H0 != com.scwang.smartrefresh.layout.c.b.Refreshing || smartRefreshLayout.A0 == null || smartRefreshLayout.C0 == null) {
                return;
            }
            smartRefreshLayout.a(com.scwang.smartrefresh.layout.c.b.RefreshFinish);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int iA = smartRefreshLayout2.A0.a(smartRefreshLayout2, this.f8224a);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.d.c cVar = smartRefreshLayout3.j0;
            if (cVar != null) {
                com.scwang.smartrefresh.layout.b.h hVar = smartRefreshLayout3.A0;
                if (hVar instanceof com.scwang.smartrefresh.layout.b.g) {
                    cVar.a((com.scwang.smartrefresh.layout.b.g) hVar, this.f8224a);
                }
            }
            if (iA < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                if (smartRefreshLayout4.n || smartRefreshLayout4.m0) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.n) {
                        smartRefreshLayout5.f8213i = smartRefreshLayout5.f8215k;
                        smartRefreshLayout5.f8208d = 0;
                        smartRefreshLayout5.n = false;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout6.f8214j, (smartRefreshLayout6.f8215k + smartRefreshLayout6.f8206b) - (smartRefreshLayout6.f8205a * 2), 0));
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout7.f8214j, smartRefreshLayout7.f8215k + smartRefreshLayout7.f8206b, 0));
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.m0) {
                        smartRefreshLayout8.l0 = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout9.f8206b;
                if (i2 <= 0) {
                    if (i2 < 0) {
                        smartRefreshLayout9.a(0, iA, smartRefreshLayout9.y, smartRefreshLayout9.f8210f);
                        return;
                    } else {
                        smartRefreshLayout9.F0.a(0, false);
                        SmartRefreshLayout.this.k();
                        return;
                    }
                }
                ValueAnimator valueAnimatorA = smartRefreshLayout9.a(0, iA, smartRefreshLayout9.y, smartRefreshLayout9.f8210f);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerA = smartRefreshLayout10.N ? smartRefreshLayout10.C0.a(smartRefreshLayout10.f8206b) : null;
                if (valueAnimatorA == null || animatorUpdateListenerA == null) {
                    return;
                }
                valueAnimatorA.addUpdateListener(animatorUpdateListenerA);
            }
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8226a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f8227b;

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8229a;

            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$h$a$a, reason: collision with other inner class name */
            class C0119a extends AnimatorListenerAdapter {
                C0119a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    h hVar = h.this;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.O0 = false;
                    if (hVar.f8227b) {
                        smartRefreshLayout.a(true);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.H0 == com.scwang.smartrefresh.layout.c.b.LoadFinish) {
                        smartRefreshLayout2.a(com.scwang.smartrefresh.layout.c.b.None);
                    }
                }
            }

            a(int i2) {
                this.f8229a = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator valueAnimatorA;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerA = (!smartRefreshLayout.M || this.f8229a >= 0) ? null : smartRefreshLayout.C0.a(smartRefreshLayout.f8206b);
                if (animatorUpdateListenerA != null) {
                    animatorUpdateListenerA.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                }
                C0119a c0119a = new C0119a();
                h hVar = h.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout2.f8206b;
                if (i2 > 0) {
                    valueAnimatorA = smartRefreshLayout2.F0.a(0);
                } else {
                    if (animatorUpdateListenerA != null || i2 == 0) {
                        ValueAnimator valueAnimator = SmartRefreshLayout.this.S0;
                        if (valueAnimator != null) {
                            valueAnimator.cancel();
                            SmartRefreshLayout.this.S0 = null;
                        }
                        SmartRefreshLayout.this.F0.a(0, false);
                        SmartRefreshLayout.this.k();
                    } else if (hVar.f8227b && smartRefreshLayout2.G) {
                        int i3 = smartRefreshLayout2.s0;
                        if (i2 >= (-i3)) {
                            smartRefreshLayout2.a(com.scwang.smartrefresh.layout.c.b.None);
                        } else {
                            valueAnimatorA = smartRefreshLayout2.F0.a(-i3);
                        }
                    } else {
                        valueAnimatorA = SmartRefreshLayout.this.F0.a(0);
                    }
                    valueAnimatorA = null;
                }
                if (valueAnimatorA != null) {
                    valueAnimatorA.addListener(c0119a);
                } else {
                    c0119a.onAnimationEnd(null);
                }
            }
        }

        h(boolean z, boolean z2) {
            this.f8226a = z;
            this.f8227b = z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 215
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.h.run():void");
        }
    }

    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f8232a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8233b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8234c;

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.F0.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                i iVar = i.this;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.S0 = null;
                if (!iVar.f8234c) {
                    com.scwang.smartrefresh.layout.c.b bVar = smartRefreshLayout.H0;
                    com.scwang.smartrefresh.layout.c.b bVar2 = com.scwang.smartrefresh.layout.c.b.ReleaseToRefresh;
                    if (bVar != bVar2) {
                        smartRefreshLayout.F0.a(bVar2);
                    }
                } else if (smartRefreshLayout.H0 == com.scwang.smartrefresh.layout.c.b.ReleaseToRefresh) {
                    smartRefreshLayout.F0.a(com.scwang.smartrefresh.layout.c.b.PullDownToRefresh);
                }
                SmartRefreshLayout.this.j();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout.this.f8214j = r2.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.F0.a(com.scwang.smartrefresh.layout.c.b.PullDownToRefresh);
            }
        }

        i(float f2, int i2, boolean z) {
            this.f8232a = f2;
            this.f8233b = i2;
            this.f8234c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.S0 = ValueAnimator.ofInt(smartRefreshLayout.f8206b, (int) (smartRefreshLayout.q0 * this.f8232a));
            SmartRefreshLayout.this.S0.setDuration(this.f8233b);
            SmartRefreshLayout.this.S0.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.S0.addUpdateListener(new a());
            SmartRefreshLayout.this.S0.addListener(new b());
            SmartRefreshLayout.this.S0.start();
        }
    }

    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f8238a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8239b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8240c;

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.F0.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                j jVar = j.this;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.S0 = null;
                if (!jVar.f8240c) {
                    com.scwang.smartrefresh.layout.c.b bVar = smartRefreshLayout.H0;
                    com.scwang.smartrefresh.layout.c.b bVar2 = com.scwang.smartrefresh.layout.c.b.ReleaseToLoad;
                    if (bVar != bVar2) {
                        smartRefreshLayout.F0.a(bVar2);
                    }
                } else if (smartRefreshLayout.H0 == com.scwang.smartrefresh.layout.c.b.ReleaseToLoad) {
                    smartRefreshLayout.F0.a(com.scwang.smartrefresh.layout.c.b.PullUpToLoad);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.K) {
                    smartRefreshLayout2.j();
                    return;
                }
                smartRefreshLayout2.K = false;
                smartRefreshLayout2.j();
                SmartRefreshLayout.this.K = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout.this.f8214j = r2.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.F0.a(com.scwang.smartrefresh.layout.c.b.PullUpToLoad);
            }
        }

        j(float f2, int i2, boolean z) {
            this.f8238a = f2;
            this.f8239b = i2;
            this.f8240c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.S0 = ValueAnimator.ofInt(smartRefreshLayout.f8206b, -((int) (smartRefreshLayout.s0 * this.f8238a)));
            SmartRefreshLayout.this.S0.setDuration(this.f8239b);
            SmartRefreshLayout.this.S0.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.S0.addUpdateListener(new a());
            SmartRefreshLayout.this.S0.addListener(new b());
            SmartRefreshLayout.this.S0.start();
        }
    }

    protected class k implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        int f8246c;

        /* renamed from: f, reason: collision with root package name */
        float f8249f;

        /* renamed from: a, reason: collision with root package name */
        int f8244a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f8245b = 10;

        /* renamed from: e, reason: collision with root package name */
        float f8248e = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        long f8247d = AnimationUtils.currentAnimationTimeMillis();

        k(float f2, int i2) {
            this.f8249f = f2;
            this.f8246c = i2;
            SmartRefreshLayout.this.postDelayed(this, this.f8245b);
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.R0 != this || smartRefreshLayout.H0.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.f8206b) < Math.abs(this.f8246c)) {
                double d2 = this.f8249f;
                this.f8244a = this.f8244a + 1;
                this.f8249f = (float) (d2 * Math.pow(0.949999988079071d, r4 * 2));
            } else if (this.f8246c != 0) {
                double d3 = this.f8249f;
                this.f8244a = this.f8244a + 1;
                this.f8249f = (float) (d3 * Math.pow(0.44999998807907104d, r4 * 2));
            } else {
                double d4 = this.f8249f;
                this.f8244a = this.f8244a + 1;
                this.f8249f = (float) (d4 * Math.pow(0.8500000238418579d, r4 * 2));
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f2 = this.f8249f * (((jCurrentAnimationTimeMillis - this.f8247d) * 1.0f) / 1000.0f);
            if (Math.abs(f2) >= 1.0f) {
                this.f8247d = jCurrentAnimationTimeMillis;
                this.f8248e += f2;
                SmartRefreshLayout.this.k(this.f8248e);
                SmartRefreshLayout.this.postDelayed(this, this.f8245b);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.R0 = null;
            if (Math.abs(smartRefreshLayout2.f8206b) >= Math.abs(this.f8246c)) {
                int iMin = Math.min(Math.max((int) com.scwang.smartrefresh.layout.e.b.b(Math.abs(SmartRefreshLayout.this.f8206b - this.f8246c)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                smartRefreshLayout3.a(this.f8246c, 0, smartRefreshLayout3.y, iMin);
            }
        }
    }

    protected class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        int f8251a;

        /* renamed from: d, reason: collision with root package name */
        float f8254d;

        /* renamed from: b, reason: collision with root package name */
        int f8252b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f8253c = 10;

        /* renamed from: e, reason: collision with root package name */
        float f8255e = 0.98f;

        /* renamed from: f, reason: collision with root package name */
        long f8256f = 0;

        /* renamed from: g, reason: collision with root package name */
        long f8257g = AnimationUtils.currentAnimationTimeMillis();

        l(float f2) {
            this.f8254d = f2;
            this.f8251a = SmartRefreshLayout.this.f8206b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a1, code lost:
        
            if (r0 < (-r1.s0)) goto L44;
         */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable a() {
            /*
                r11 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r1 = r0.H0
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto La
                return r3
            La:
                int r2 = r0.f8206b
                if (r2 == 0) goto La8
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L22
                boolean r1 = r0.d0
                if (r1 == 0) goto L51
                boolean r1 = r0.G
                if (r1 == 0) goto L51
                boolean r1 = r0.B
                boolean r0 = r0.v(r1)
                if (r0 == 0) goto L51
            L22:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r1 = r0.H0
                com.scwang.smartrefresh.layout.c.b r2 = com.scwang.smartrefresh.layout.c.b.Loading
                if (r1 == r2) goto L3a
                boolean r1 = r0.d0
                if (r1 == 0) goto L43
                boolean r1 = r0.G
                if (r1 == 0) goto L43
                boolean r1 = r0.B
                boolean r0 = r0.v(r1)
                if (r0 == 0) goto L43
            L3a:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r0.f8206b
                int r0 = r0.s0
                int r0 = -r0
                if (r1 < r0) goto L51
            L43:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r1 = r0.H0
                com.scwang.smartrefresh.layout.c.b r2 = com.scwang.smartrefresh.layout.c.b.Refreshing
                if (r1 != r2) goto La8
                int r1 = r0.f8206b
                int r0 = r0.q0
                if (r1 <= r0) goto La8
            L51:
                r0 = 0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.f8206b
                float r2 = r11.f8254d
                r0 = r1
                r4 = 0
            L5a:
                int r5 = r1 * r0
                if (r5 <= 0) goto La8
                double r5 = (double) r2
                float r2 = r11.f8255e
                double r7 = (double) r2
                int r4 = r4 + 1
                int r2 = r11.f8253c
                int r2 = r2 * r4
                int r2 = r2 / 10
                double r9 = (double) r2
                double r7 = java.lang.Math.pow(r7, r9)
                double r5 = r5 * r7
                float r2 = (float) r5
                int r5 = r11.f8253c
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r2
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto La4
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r2 = r1.H0
                boolean r4 = r2.isOpening
                if (r4 == 0) goto La3
                com.scwang.smartrefresh.layout.c.b r4 = com.scwang.smartrefresh.layout.c.b.Refreshing
                if (r2 != r4) goto L96
                int r1 = r1.q0
                if (r0 > r1) goto La3
            L96:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r2 = r1.H0
                com.scwang.smartrefresh.layout.c.b r4 = com.scwang.smartrefresh.layout.c.b.Refreshing
                if (r2 == r4) goto La8
                int r1 = r1.s0
                int r1 = -r1
                if (r0 >= r1) goto La8
            La3:
                return r3
            La4:
                float r0 = (float) r0
                float r0 = r0 + r5
                int r0 = (int) r0
                goto L5a
            La8:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r11.f8256f = r0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r11.f8253c
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.l.a():java.lang.Runnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.R0 != this || smartRefreshLayout.H0.isFinishing) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j2 = jCurrentAnimationTimeMillis - this.f8257g;
            this.f8254d = (float) (this.f8254d * Math.pow(this.f8255e, (jCurrentAnimationTimeMillis - this.f8256f) / (1000 / this.f8253c)));
            float f2 = this.f8254d * ((j2 * 1.0f) / 1000.0f);
            if (Math.abs(f2) <= 1.0f) {
                SmartRefreshLayout.this.R0 = null;
                return;
            }
            this.f8257g = jCurrentAnimationTimeMillis;
            this.f8251a = (int) (this.f8251a + f2);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i2 = smartRefreshLayout2.f8206b;
            int i3 = this.f8251a;
            if (i2 * i3 > 0) {
                smartRefreshLayout2.F0.a(i3, true);
                SmartRefreshLayout.this.postDelayed(this, this.f8253c);
                return;
            }
            smartRefreshLayout2.R0 = null;
            smartRefreshLayout2.F0.a(0, true);
            com.scwang.smartrefresh.layout.e.e.a(SmartRefreshLayout.this.C0.c(), (int) (-this.f8254d));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.O0 || f2 <= 0.0f) {
                return;
            }
            smartRefreshLayout3.O0 = false;
        }
    }

    public class n implements com.scwang.smartrefresh.layout.b.i {

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.F0.a(com.scwang.smartrefresh.layout.c.b.TwoLevel);
            }
        }

        public n() {
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        @NonNull
        public com.scwang.smartrefresh.layout.b.e a() {
            return SmartRefreshLayout.this.C0;
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public com.scwang.smartrefresh.layout.b.i b() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.H0 == com.scwang.smartrefresh.layout.c.b.TwoLevel) {
                smartRefreshLayout.F0.a(com.scwang.smartrefresh.layout.c.b.TwoLevelFinish);
                if (SmartRefreshLayout.this.f8206b == 0) {
                    a(0, false);
                    SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.None);
                } else {
                    a(0).setDuration(SmartRefreshLayout.this.f8209e);
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        @NonNull
        public com.scwang.smartrefresh.layout.b.j c() {
            return SmartRefreshLayout.this;
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public com.scwang.smartrefresh.layout.b.i a(@NonNull com.scwang.smartrefresh.layout.c.b bVar) {
            switch (a.f8218a[bVar.ordinal()]) {
                case 1:
                    SmartRefreshLayout.this.k();
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (!smartRefreshLayout.H0.isOpening && smartRefreshLayout.v(smartRefreshLayout.A)) {
                        SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.PullDownToRefresh);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.PullDownToRefresh);
                        break;
                    }
                    break;
                case 3:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.v(smartRefreshLayout2.B)) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        com.scwang.smartrefresh.layout.c.b bVar2 = smartRefreshLayout3.H0;
                        if (!bVar2.isOpening && !bVar2.isFinishing && (!smartRefreshLayout3.d0 || !smartRefreshLayout3.G)) {
                            SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.PullUpToLoad);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout4.H0.isOpening && smartRefreshLayout4.v(smartRefreshLayout4.A)) {
                        SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.PullDownCanceled);
                        SmartRefreshLayout.this.k();
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.PullDownCanceled);
                        break;
                    }
                case 5:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.v(smartRefreshLayout5.B)) {
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout6.H0.isOpening && (!smartRefreshLayout6.d0 || !smartRefreshLayout6.G)) {
                            SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.PullUpCanceled);
                            SmartRefreshLayout.this.k();
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout7.H0.isOpening && smartRefreshLayout7.v(smartRefreshLayout7.A)) {
                        SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.ReleaseToRefresh);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.ReleaseToRefresh);
                        break;
                    }
                case 7:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.v(smartRefreshLayout8.B)) {
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        com.scwang.smartrefresh.layout.c.b bVar3 = smartRefreshLayout9.H0;
                        if (!bVar3.isOpening && !bVar3.isFinishing && (!smartRefreshLayout9.d0 || !smartRefreshLayout9.G)) {
                            SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.ReleaseToLoad);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout10.H0.isOpening && smartRefreshLayout10.v(smartRefreshLayout10.A)) {
                        SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.ReleaseToTwoLevel);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.ReleaseToTwoLevel);
                        break;
                    }
                case 9:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.H0.isOpening && smartRefreshLayout11.v(smartRefreshLayout11.A)) {
                        SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.RefreshReleased);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.RefreshReleased);
                        break;
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.H0.isOpening && smartRefreshLayout12.v(smartRefreshLayout12.B)) {
                        SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.LoadReleased);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(com.scwang.smartrefresh.layout.c.b.LoadReleased);
                        break;
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.m();
                    break;
                case 12:
                    SmartRefreshLayout.this.l();
                    break;
                case 13:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (smartRefreshLayout13.H0 == com.scwang.smartrefresh.layout.c.b.Refreshing) {
                        smartRefreshLayout13.a(com.scwang.smartrefresh.layout.c.b.RefreshFinish);
                        break;
                    }
                    break;
                case 14:
                    SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                    if (smartRefreshLayout14.H0 == com.scwang.smartrefresh.layout.c.b.Loading) {
                        smartRefreshLayout14.a(com.scwang.smartrefresh.layout.c.b.LoadFinish);
                        break;
                    }
                    break;
                case 15:
                    SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.TwoLevelReleased);
                    break;
                case 16:
                    SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.TwoLevelFinish);
                    break;
                case 17:
                    SmartRefreshLayout.this.a(com.scwang.smartrefresh.layout.c.b.TwoLevel);
                    break;
            }
            return null;
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public com.scwang.smartrefresh.layout.b.i b(@NonNull com.scwang.smartrefresh.layout.b.h hVar, boolean z) {
            if (hVar.equals(SmartRefreshLayout.this.A0)) {
                SmartRefreshLayout.this.M0 = z;
            } else if (hVar.equals(SmartRefreshLayout.this.B0)) {
                SmartRefreshLayout.this.N0 = z;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public com.scwang.smartrefresh.layout.b.i b(int i2) {
            SmartRefreshLayout.this.f8209e = i2;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // com.scwang.smartrefresh.layout.b.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.scwang.smartrefresh.layout.b.i a(boolean r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L28
                com.scwang.smartrefresh.layout.SmartRefreshLayout$n$a r4 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$n$a
                r4.<init>()
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.getMeasuredHeight()
                android.animation.ValueAnimator r0 = r3.a(r0)
                if (r0 == 0) goto L23
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.animation.ValueAnimator r2 = r1.S0
                if (r0 != r2) goto L23
                int r1 = r1.f8209e
                long r1 = (long) r1
                r0.setDuration(r1)
                r0.addListener(r4)
                goto L36
            L23:
                r0 = 0
                r4.onAnimationEnd(r0)
                goto L36
            L28:
                r4 = 0
                android.animation.ValueAnimator r4 = r3.a(r4)
                if (r4 != 0) goto L36
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r0 = com.scwang.smartrefresh.layout.c.b.None
                r4.a(r0)
            L36:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.n.a(boolean):com.scwang.smartrefresh.layout.b.i");
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public com.scwang.smartrefresh.layout.b.i a(int i2, boolean z) {
            com.scwang.smartrefresh.layout.d.c cVar;
            com.scwang.smartrefresh.layout.d.c cVar2;
            com.scwang.smartrefresh.layout.b.h hVar;
            com.scwang.smartrefresh.layout.b.h hVar2;
            SmartRefreshLayout smartRefreshLayout;
            com.scwang.smartrefresh.layout.b.h hVar3;
            com.scwang.smartrefresh.layout.b.h hVar4;
            com.scwang.smartrefresh.layout.b.h hVar5;
            com.scwang.smartrefresh.layout.b.h hVar6;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.f8206b == i2 && (((hVar5 = smartRefreshLayout2.A0) == null || !hVar5.a()) && ((hVar6 = SmartRefreshLayout.this.B0) == null || !hVar6.a()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int i3 = smartRefreshLayout3.f8206b;
            smartRefreshLayout3.f8206b = i2;
            if (z && smartRefreshLayout3.I0.isDragging) {
                if (smartRefreshLayout3.f8206b > smartRefreshLayout3.q0 * smartRefreshLayout3.y0) {
                    if (smartRefreshLayout3.H0 != com.scwang.smartrefresh.layout.c.b.ReleaseToTwoLevel) {
                        smartRefreshLayout3.F0.a(com.scwang.smartrefresh.layout.c.b.ReleaseToRefresh);
                    }
                } else if ((-r2) > smartRefreshLayout3.s0 * smartRefreshLayout3.z0 && !smartRefreshLayout3.d0) {
                    smartRefreshLayout3.F0.a(com.scwang.smartrefresh.layout.c.b.ReleaseToLoad);
                } else {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.f8206b < 0 && !smartRefreshLayout4.d0) {
                        smartRefreshLayout4.F0.a(com.scwang.smartrefresh.layout.c.b.PullUpToLoad);
                    } else {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.f8206b > 0) {
                            smartRefreshLayout5.F0.a(com.scwang.smartrefresh.layout.c.b.PullDownToRefresh);
                        }
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
            if (smartRefreshLayout6.C0 != null) {
                Integer numValueOf = null;
                if (i2 >= 0 && (hVar4 = smartRefreshLayout6.A0) != null) {
                    if (smartRefreshLayout6.a(smartRefreshLayout6.E, hVar4)) {
                        numValueOf = Integer.valueOf(i2);
                    } else if (i3 < 0) {
                        numValueOf = 0;
                    }
                }
                if (i2 <= 0 && (hVar3 = (smartRefreshLayout = SmartRefreshLayout.this).B0) != null) {
                    if (smartRefreshLayout.a(smartRefreshLayout.F, hVar3)) {
                        numValueOf = Integer.valueOf(i2);
                    } else if (i3 > 0) {
                        numValueOf = 0;
                    }
                }
                if (numValueOf != null) {
                    com.scwang.smartrefresh.layout.b.e eVar = SmartRefreshLayout.this.C0;
                    int iIntValue = numValueOf.intValue();
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    eVar.a(iIntValue, smartRefreshLayout7.r, smartRefreshLayout7.s);
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    boolean z2 = (smartRefreshLayout8.C && (hVar2 = smartRefreshLayout8.A0) != null && hVar2.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) || SmartRefreshLayout.this.K0 != 0;
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    boolean z3 = (smartRefreshLayout9.D && (hVar = smartRefreshLayout9.B0) != null && hVar.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) || SmartRefreshLayout.this.L0 != 0;
                    if ((z2 && (numValueOf.intValue() >= 0 || i3 > 0)) || (z3 && (numValueOf.intValue() <= 0 || i3 < 0))) {
                        smartRefreshLayout3.invalidate();
                    }
                }
            }
            if ((i2 >= 0 || i3 > 0) && SmartRefreshLayout.this.A0 != null) {
                int iMax = Math.max(i2, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i4 = smartRefreshLayout10.q0;
                int i5 = (int) (i4 * smartRefreshLayout10.w0);
                float f2 = (iMax * 1.0f) / (i4 == 0 ? 1 : i4);
                SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                if (smartRefreshLayout11.v(smartRefreshLayout11.A) || (SmartRefreshLayout.this.H0 == com.scwang.smartrefresh.layout.c.b.RefreshFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout12.f8206b) {
                        if (smartRefreshLayout12.A0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Translate) {
                            SmartRefreshLayout.this.A0.getView().setTranslationY(SmartRefreshLayout.this.f8206b);
                            SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                            if (smartRefreshLayout13.K0 != 0 && smartRefreshLayout13.D0 != null && !smartRefreshLayout13.a(smartRefreshLayout13.E, smartRefreshLayout13.A0)) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.A0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Scale) {
                            SmartRefreshLayout.this.A0.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.A0.a(z, f2, iMax, i4, i5);
                    }
                    if (z && SmartRefreshLayout.this.A0.a()) {
                        int i6 = (int) SmartRefreshLayout.this.f8214j;
                        int width = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout.this.A0.a(SmartRefreshLayout.this.f8214j / (width == 0 ? 1 : width), i6, width);
                    }
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout14.f8206b && (cVar = smartRefreshLayout14.j0) != null) {
                    com.scwang.smartrefresh.layout.b.h hVar7 = smartRefreshLayout14.A0;
                    if (hVar7 instanceof com.scwang.smartrefresh.layout.b.g) {
                        cVar.a((com.scwang.smartrefresh.layout.b.g) hVar7, z, f2, iMax, i4, i5);
                    }
                }
            }
            if ((i2 <= 0 || i3 < 0) && SmartRefreshLayout.this.B0 != null) {
                int i7 = -Math.min(i2, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i8 = smartRefreshLayout15.s0;
                int i9 = (int) (i8 * smartRefreshLayout15.x0);
                float f3 = (i7 * 1.0f) / (i8 == 0 ? 1 : i8);
                SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                if (smartRefreshLayout16.v(smartRefreshLayout16.B) || (SmartRefreshLayout.this.H0 == com.scwang.smartrefresh.layout.c.b.LoadFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout17.f8206b) {
                        if (smartRefreshLayout17.B0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Translate) {
                            SmartRefreshLayout.this.B0.getView().setTranslationY(SmartRefreshLayout.this.f8206b);
                            SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                            if (smartRefreshLayout18.L0 != 0 && smartRefreshLayout18.D0 != null && !smartRefreshLayout18.a(smartRefreshLayout18.F, smartRefreshLayout18.B0)) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.B0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Scale) {
                            SmartRefreshLayout.this.B0.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.B0.a(z, f3, i7, i8, i9);
                    }
                    if (z && SmartRefreshLayout.this.B0.a()) {
                        int i10 = (int) SmartRefreshLayout.this.f8214j;
                        int width2 = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout.this.B0.a(SmartRefreshLayout.this.f8214j / (width2 != 0 ? width2 : 1), i10, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout19.f8206b && (cVar2 = smartRefreshLayout19.j0) != null) {
                    com.scwang.smartrefresh.layout.b.h hVar8 = smartRefreshLayout19.B0;
                    if (hVar8 instanceof com.scwang.smartrefresh.layout.b.f) {
                        cVar2.a((com.scwang.smartrefresh.layout.b.f) hVar8, z, f3, i7, i8, i9);
                    }
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public ValueAnimator a(int i2) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.a(i2, 0, smartRefreshLayout.y, smartRefreshLayout.f8210f);
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public com.scwang.smartrefresh.layout.b.i a(@NonNull com.scwang.smartrefresh.layout.b.h hVar, int i2) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.D0 == null && i2 != 0) {
                smartRefreshLayout.D0 = new Paint();
            }
            if (hVar.equals(SmartRefreshLayout.this.A0)) {
                SmartRefreshLayout.this.K0 = i2;
            } else if (hVar.equals(SmartRefreshLayout.this.B0)) {
                SmartRefreshLayout.this.L0 = i2;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public com.scwang.smartrefresh.layout.b.i a(@NonNull com.scwang.smartrefresh.layout.b.h hVar, boolean z) {
            if (hVar.equals(SmartRefreshLayout.this.A0)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.f0) {
                    smartRefreshLayout.f0 = true;
                    smartRefreshLayout.E = z;
                }
            } else if (hVar.equals(SmartRefreshLayout.this.B0)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.g0) {
                    smartRefreshLayout2.g0 = true;
                    smartRefreshLayout2.F = z;
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.b.i
        public com.scwang.smartrefresh.layout.b.i a(@NonNull com.scwang.smartrefresh.layout.b.h hVar) {
            if (hVar.equals(SmartRefreshLayout.this.A0)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                com.scwang.smartrefresh.layout.c.a aVar = smartRefreshLayout.r0;
                if (aVar.notified) {
                    smartRefreshLayout.r0 = aVar.unNotify();
                }
            } else if (hVar.equals(SmartRefreshLayout.this.B0)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                com.scwang.smartrefresh.layout.c.a aVar2 = smartRefreshLayout2.t0;
                if (aVar2.notified) {
                    smartRefreshLayout2.t0 = aVar2.unNotify();
                }
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull com.scwang.smartrefresh.layout.b.a aVar) {
        T0 = aVar;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull com.scwang.smartrefresh.layout.b.b bVar) {
        U0 = bVar;
    }

    public static void setDefaultRefreshInitializer(@NonNull com.scwang.smartrefresh.layout.b.c cVar) {
        V0 = cVar;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof m;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.w.getCurrY();
        if (this.w.computeScrollOffset()) {
            int finalY = this.w.getFinalY();
            if ((finalY >= 0 || !((this.J || v(this.A)) && this.C0.a())) && (finalY <= 0 || !((this.J || v(this.B)) && this.C0.b()))) {
                this.P0 = true;
                invalidate();
            } else {
                if (this.P0) {
                    j(Build.VERSION.SDK_INT >= 14 ? finalY > 0 ? -this.w.getCurrVelocity() : this.w.getCurrVelocity() : ((this.w.getCurrY() - finalY) * 1.0f) / Math.max(this.w.getDuration() - this.w.timePassed(), 1));
                }
                this.w.forceFinished(true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e8, code lost:
    
        if (r22.H0.isFooter == false) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        Paint paint;
        Paint paint2;
        com.scwang.smartrefresh.layout.b.e eVar = this.C0;
        View view2 = eVar != null ? eVar.getView() : null;
        com.scwang.smartrefresh.layout.b.h hVar = this.A0;
        if (hVar != null && hVar.getView() == view) {
            if (!v(this.A) || (!this.H && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getTop() + view2.getPaddingTop() + this.f8206b, view.getTop());
                int i2 = this.K0;
                if (i2 != 0 && (paint2 = this.D0) != null) {
                    paint2.setColor(i2);
                    if (this.A0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Scale) {
                        iMax = view.getBottom();
                    } else if (this.A0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Translate) {
                        iMax = view.getBottom() + this.f8206b;
                    }
                    canvas.drawRect(view.getLeft(), view.getTop(), view.getRight(), iMax, this.D0);
                }
                if (this.C && this.A0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        com.scwang.smartrefresh.layout.b.h hVar2 = this.B0;
        if (hVar2 != null && hVar2.getView() == view) {
            if (!v(this.B) || (!this.H && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f8206b, view.getBottom());
                int i3 = this.L0;
                if (i3 != 0 && (paint = this.D0) != null) {
                    paint.setColor(i3);
                    if (this.B0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Scale) {
                        iMin = view.getTop();
                    } else if (this.B0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Translate) {
                        iMin = view.getTop() + this.f8206b;
                    }
                    canvas.drawRect(view.getLeft(), iMin, view.getRight(), view.getBottom(), this.D0);
                }
                if (this.D && this.B0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.p0.getNestedScrollAxes();
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    @Nullable
    public com.scwang.smartrefresh.layout.b.f getRefreshFooter() {
        com.scwang.smartrefresh.layout.b.h hVar = this.B0;
        if (hVar instanceof com.scwang.smartrefresh.layout.b.f) {
            return (com.scwang.smartrefresh.layout.b.f) hVar;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    @Nullable
    public com.scwang.smartrefresh.layout.b.g getRefreshHeader() {
        com.scwang.smartrefresh.layout.b.h hVar = this.A0;
        if (hVar instanceof com.scwang.smartrefresh.layout.b.g) {
            return (com.scwang.smartrefresh.layout.b.g) hVar;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public com.scwang.smartrefresh.layout.c.b getState() {
        return this.H0;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.o0.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        com.scwang.smartrefresh.layout.b.h hVar;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.E0 == null) {
                this.E0 = new Handler();
            }
            List<com.scwang.smartrefresh.layout.e.a> list = this.G0;
            if (list != null) {
                for (com.scwang.smartrefresh.layout.e.a aVar : list) {
                    this.E0.postDelayed(aVar, aVar.f8272a);
                }
                this.G0.clear();
                this.G0 = null;
            }
            if (this.A0 == null) {
                com.scwang.smartrefresh.layout.b.b bVar = U0;
                if (bVar != null) {
                    a(bVar.a(getContext(), this));
                } else {
                    a(new BezierRadarHeader(getContext()));
                }
            }
            if (this.B0 == null) {
                com.scwang.smartrefresh.layout.b.a aVar2 = T0;
                if (aVar2 != null) {
                    a(aVar2.a(getContext(), this));
                } else {
                    boolean z = this.B;
                    a(new BallPulseFooter(getContext()));
                    this.B = z;
                }
            } else {
                this.B = this.B || !this.e0;
            }
            if (this.C0 == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    com.scwang.smartrefresh.layout.b.h hVar2 = this.A0;
                    if ((hVar2 == null || childAt != hVar2.getView()) && ((hVar = this.B0) == null || childAt != hVar.getView())) {
                        this.C0 = new com.scwang.smartrefresh.layout.impl.a(childAt);
                    }
                }
            }
            if (this.C0 == null) {
                int iB = com.scwang.smartrefresh.layout.e.b.b(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, -1, -1);
                this.C0 = new com.scwang.smartrefresh.layout.impl.a(textView);
                this.C0.getView().setPadding(iB, iB, iB, iB);
            }
            int i3 = this.p;
            View viewFindViewById = i3 > 0 ? findViewById(i3) : null;
            int i4 = this.q;
            View viewFindViewById2 = i4 > 0 ? findViewById(i4) : null;
            this.C0.a(this.k0);
            this.C0.b(this.O);
            this.C0.a(this.F0, viewFindViewById, viewFindViewById2);
            if (this.f8206b != 0) {
                a(com.scwang.smartrefresh.layout.c.b.None);
                com.scwang.smartrefresh.layout.b.e eVar = this.C0;
                this.f8206b = 0;
                eVar.a(0, this.r, this.s);
            }
        }
        int[] iArr = this.z;
        if (iArr != null) {
            com.scwang.smartrefresh.layout.b.h hVar3 = this.A0;
            if (hVar3 != null) {
                hVar3.setPrimaryColors(iArr);
            }
            com.scwang.smartrefresh.layout.b.h hVar4 = this.B0;
            if (hVar4 != null) {
                hVar4.setPrimaryColors(this.z);
            }
        }
        com.scwang.smartrefresh.layout.b.e eVar2 = this.C0;
        if (eVar2 != null) {
            super.bringChildToFront(eVar2.getView());
        }
        com.scwang.smartrefresh.layout.b.h hVar5 = this.A0;
        if (hVar5 != null && hVar5.getSpinnerStyle() != com.scwang.smartrefresh.layout.c.c.FixedBehind) {
            super.bringChildToFront(this.A0.getView());
        }
        com.scwang.smartrefresh.layout.b.h hVar6 = this.B0;
        if (hVar6 == null || hVar6.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
            return;
        }
        super.bringChildToFront(this.B0.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.F0.a(0, true);
        a(com.scwang.smartrefresh.layout.c.b.None);
        Handler handler = this.E0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E0 = null;
        }
        List<com.scwang.smartrefresh.layout.e.a> list = this.G0;
        if (list != null) {
            list.clear();
            this.G0 = null;
        }
        this.e0 = true;
        this.R0 = null;
        ValueAnimator valueAnimator = this.S0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.S0.removeAllUpdateListeners();
            this.S0.cancel();
            this.S0 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        int i2;
        int i3;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i4 = 0;
        int i5 = -1;
        char c2 = 0;
        while (true) {
            i2 = 2;
            if (i4 >= childCount) {
                break;
            }
            View childAt = super.getChildAt(i4);
            if (com.scwang.smartrefresh.layout.e.e.a(childAt) && (c2 < 2 || i4 == 1)) {
                i5 = i4;
                c2 = 2;
            } else if (!(childAt instanceof com.scwang.smartrefresh.layout.b.h) && c2 < 1) {
                i5 = i4;
                c2 = i4 <= 0 ? (char) 0 : (char) 1;
            }
            i4++;
        }
        if (i5 >= 0) {
            this.C0 = new com.scwang.smartrefresh.layout.impl.a(super.getChildAt(i5));
            if (i5 != 1) {
                if (childCount == 2) {
                    i3 = -1;
                    i2 = 1;
                }
                i3 = -1;
                i2 = -1;
            } else if (childCount == 3) {
                i3 = 0;
            } else {
                i3 = 0;
                i2 = -1;
            }
        } else {
            i3 = -1;
            i2 = -1;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = super.getChildAt(i6);
            if (i6 == i3 || (i6 != i2 && i3 == -1 && this.A0 == null && (childAt2 instanceof com.scwang.smartrefresh.layout.b.g))) {
                this.A0 = childAt2 instanceof com.scwang.smartrefresh.layout.b.g ? (com.scwang.smartrefresh.layout.b.g) childAt2 : new RefreshHeaderWrapper(childAt2);
            } else if (i6 == i2 || (i2 == -1 && (childAt2 instanceof com.scwang.smartrefresh.layout.b.f))) {
                this.B = this.B || !this.e0;
                this.B0 = childAt2 instanceof com.scwang.smartrefresh.layout.b.f ? (com.scwang.smartrefresh.layout.b.f) childAt2 : new RefreshFooterWrapper(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iMax;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            com.scwang.smartrefresh.layout.b.e eVar = this.C0;
            if (eVar != null && eVar.getView() == childAt) {
                boolean z2 = isInEditMode() && this.H && v(this.A) && this.A0 != null;
                View view = this.C0.getView();
                m mVar = (m) view.getLayoutParams();
                int i7 = ((ViewGroup.MarginLayoutParams) mVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) mVar).topMargin + paddingTop;
                int measuredWidth = view.getMeasuredWidth() + i7;
                int measuredHeight = view.getMeasuredHeight() + i8;
                if (z2 && a(this.E, this.A0)) {
                    int i9 = this.q0;
                    i8 += i9;
                    measuredHeight += i9;
                }
                view.layout(i7, i8, measuredWidth, measuredHeight);
            }
            com.scwang.smartrefresh.layout.b.h hVar = this.A0;
            if (hVar != null && hVar.getView() == childAt) {
                boolean z3 = isInEditMode() && this.H && v(this.A);
                View view2 = this.A0.getView();
                m mVar2 = (m) view2.getLayoutParams();
                int i10 = ((ViewGroup.MarginLayoutParams) mVar2).leftMargin;
                int i11 = ((ViewGroup.MarginLayoutParams) mVar2).topMargin + this.u0;
                int measuredWidth2 = view2.getMeasuredWidth() + i10;
                int measuredHeight2 = view2.getMeasuredHeight() + i11;
                if (!z3 && this.A0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.Translate) {
                    int i12 = this.q0;
                    i11 -= i12;
                    measuredHeight2 -= i12;
                }
                view2.layout(i10, i11, measuredWidth2, measuredHeight2);
            }
            com.scwang.smartrefresh.layout.b.h hVar2 = this.B0;
            if (hVar2 != null && hVar2.getView() == childAt) {
                boolean z4 = isInEditMode() && this.H && v(this.B);
                View view3 = this.B0.getView();
                m mVar3 = (m) view3.getLayoutParams();
                com.scwang.smartrefresh.layout.c.c spinnerStyle = this.B0.getSpinnerStyle();
                int i13 = ((ViewGroup.MarginLayoutParams) mVar3).leftMargin;
                int measuredHeight3 = ((ViewGroup.MarginLayoutParams) mVar3).topMargin + getMeasuredHeight();
                int i14 = this.v0;
                int i15 = measuredHeight3 - i14;
                if (spinnerStyle == com.scwang.smartrefresh.layout.c.c.MatchLayout) {
                    i15 = ((ViewGroup.MarginLayoutParams) mVar3).topMargin - i14;
                } else {
                    if (z4 || spinnerStyle == com.scwang.smartrefresh.layout.c.c.FixedFront || spinnerStyle == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
                        iMax = this.s0;
                    } else if (spinnerStyle == com.scwang.smartrefresh.layout.c.c.Scale && this.f8206b < 0) {
                        iMax = Math.max(v(this.B) ? -this.f8206b : 0, 0);
                    }
                    i15 -= iMax;
                }
                view3.layout(i13, i15, view3.getMeasuredWidth() + i13, view3.getMeasuredHeight() + i15);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        return this.o0.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return (this.O0 && f3 > 0.0f) || a(Float.valueOf(-f3)) || this.o0.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        int i4;
        int i5 = this.l0;
        if (i3 * i5 > 0) {
            if (Math.abs(i3) > Math.abs(this.l0)) {
                i4 = this.l0;
                this.l0 = 0;
            } else {
                this.l0 -= i3;
                i4 = i3;
            }
            k(this.l0);
            com.scwang.smartrefresh.layout.c.b bVar = this.I0;
            if (bVar.isOpening || bVar == com.scwang.smartrefresh.layout.c.b.None) {
                if (this.f8206b > 0) {
                    this.F0.a(com.scwang.smartrefresh.layout.c.b.PullDownToRefresh);
                } else {
                    this.F0.a(com.scwang.smartrefresh.layout.c.b.PullUpToLoad);
                }
            }
        } else if (i3 <= 0 || !this.O0) {
            i4 = 0;
        } else {
            this.l0 = i5 - i3;
            k(this.l0);
            i4 = i3;
        }
        this.o0.dispatchNestedPreScroll(i2, i3 - i4, iArr, null);
        iArr[1] = iArr[1] + i4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        this.o0.dispatchNestedScroll(i2, i3, i4, i5, this.n0);
        int i6 = i5 + this.n0[1];
        if (i6 != 0 && (this.J || ((i6 < 0 && v(this.A)) || (i6 > 0 && v(this.B))))) {
            if (this.I0 == com.scwang.smartrefresh.layout.c.b.None) {
                this.F0.a(i6 > 0 ? com.scwang.smartrefresh.layout.c.b.PullUpToLoad : com.scwang.smartrefresh.layout.c.b.PullDownToRefresh);
            }
            int i7 = this.l0 - i6;
            this.l0 = i7;
            k(i7);
        }
        if (!this.O0 || i3 >= 0) {
            return;
        }
        this.O0 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        this.p0.onNestedScrollAccepted(view, view2, i2);
        this.o0.startNestedScroll(i2 & 2);
        this.l0 = this.f8206b;
        this.m0 = true;
        f(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        return (isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0) && (this.J || v(this.A) || v(this.B));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.p0.onStopNestedScroll(view);
        this.m0 = false;
        this.l0 = 0;
        j();
        this.o0.stopNestedScroll();
    }

    @Override // android.view.View
    public boolean post(@NonNull Runnable runnable) {
        Handler handler = this.E0;
        if (handler != null) {
            return handler.post(new com.scwang.smartrefresh.layout.e.a(runnable, 0L));
        }
        List<com.scwang.smartrefresh.layout.e.a> arrayList = this.G0;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.G0 = arrayList;
        this.G0.add(new com.scwang.smartrefresh.layout.e.a(runnable, 0L));
        return false;
    }

    @Override // android.view.View
    public boolean postDelayed(@NonNull Runnable runnable, long j2) {
        if (j2 == 0) {
            new com.scwang.smartrefresh.layout.e.a(runnable, 0L).run();
            return true;
        }
        Handler handler = this.E0;
        if (handler != null) {
            return handler.postDelayed(new com.scwang.smartrefresh.layout.e.a(runnable, 0L), j2);
        }
        List<com.scwang.smartrefresh.layout.e.a> arrayList = this.G0;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.G0 = arrayList;
        this.G0.add(new com.scwang.smartrefresh.layout.e.a(runnable, j2));
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public com.scwang.smartrefresh.layout.b.j q(boolean z) {
        this.G = z;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.o0.setNestedScrollingEnabled(z);
    }

    protected void setStateDirectLoading(boolean z) {
        if (this.H0 != com.scwang.smartrefresh.layout.c.b.Loading) {
            this.J0 = System.currentTimeMillis();
            this.O0 = true;
            a(com.scwang.smartrefresh.layout.c.b.Loading);
            com.scwang.smartrefresh.layout.d.b bVar = this.i0;
            if (bVar != null) {
                if (z) {
                    bVar.b(this);
                }
            } else if (this.j0 == null) {
                e(2000);
            }
            com.scwang.smartrefresh.layout.b.h hVar = this.B0;
            if (hVar != null) {
                int i2 = this.s0;
                hVar.a(this, i2, (int) (this.x0 * i2));
            }
            com.scwang.smartrefresh.layout.d.c cVar = this.j0;
            if (cVar == null || !(this.B0 instanceof com.scwang.smartrefresh.layout.b.f)) {
                return;
            }
            if (cVar != null && z) {
                cVar.b(this);
            }
            com.scwang.smartrefresh.layout.d.c cVar2 = this.j0;
            com.scwang.smartrefresh.layout.b.f fVar = (com.scwang.smartrefresh.layout.b.f) this.B0;
            int i3 = this.s0;
            cVar2.a(fVar, i3, (int) (this.x0 * i3));
        }
    }

    protected void setViceState(com.scwang.smartrefresh.layout.c.b bVar) {
        com.scwang.smartrefresh.layout.c.b bVar2 = this.H0;
        if (bVar2.isDragging && bVar2.isHeader != bVar.isHeader) {
            a(com.scwang.smartrefresh.layout.c.b.None);
        }
        if (this.I0 != bVar) {
            this.I0 = bVar;
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public com.scwang.smartrefresh.layout.b.j u(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    protected boolean v(boolean z) {
        return z && !this.L;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public m generateDefaultLayoutParams() {
        return new m(-1, -1);
    }

    protected void j(float f2) {
        com.scwang.smartrefresh.layout.c.b bVar;
        if (this.S0 == null) {
            if (f2 > 0.0f && ((bVar = this.H0) == com.scwang.smartrefresh.layout.c.b.Refreshing || bVar == com.scwang.smartrefresh.layout.c.b.TwoLevel)) {
                this.R0 = new k(f2, this.q0);
                return;
            }
            if (f2 < 0.0f && (this.H0 == com.scwang.smartrefresh.layout.c.b.Loading || ((this.G && this.d0 && v(this.B)) || (this.K && !this.d0 && v(this.B) && this.H0 != com.scwang.smartrefresh.layout.c.b.Refreshing)))) {
                this.R0 = new k(f2, -this.s0);
            } else if (this.f8206b == 0 && this.I) {
                this.R0 = new k(f2, 0);
            }
        }
    }

    protected void k() {
        com.scwang.smartrefresh.layout.c.b bVar = this.H0;
        com.scwang.smartrefresh.layout.c.b bVar2 = com.scwang.smartrefresh.layout.c.b.None;
        if (bVar != bVar2 && this.f8206b == 0) {
            a(bVar2);
        }
        if (this.f8206b != 0) {
            this.F0.a(0);
        }
    }

    protected void l() {
        b bVar = new b();
        a(com.scwang.smartrefresh.layout.c.b.LoadReleased);
        ValueAnimator valueAnimatorA = this.F0.a(-this.s0);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(bVar);
        }
        com.scwang.smartrefresh.layout.b.h hVar = this.B0;
        if (hVar != null) {
            int i2 = this.s0;
            hVar.b(this, i2, (int) (this.x0 * i2));
        }
        com.scwang.smartrefresh.layout.d.c cVar = this.j0;
        if (cVar != null) {
            com.scwang.smartrefresh.layout.b.h hVar2 = this.B0;
            if (hVar2 instanceof com.scwang.smartrefresh.layout.b.f) {
                int i3 = this.s0;
                cVar.b((com.scwang.smartrefresh.layout.b.f) hVar2, i3, (int) (this.x0 * i3));
            }
        }
        if (valueAnimatorA == null) {
            bVar.onAnimationEnd(null);
        }
    }

    protected void m() {
        c cVar = new c();
        a(com.scwang.smartrefresh.layout.c.b.RefreshReleased);
        ValueAnimator valueAnimatorA = this.F0.a(this.q0);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(cVar);
        }
        com.scwang.smartrefresh.layout.b.h hVar = this.A0;
        if (hVar != null) {
            int i2 = this.q0;
            hVar.b(this, i2, (int) (this.w0 * i2));
        }
        com.scwang.smartrefresh.layout.d.c cVar2 = this.j0;
        if (cVar2 != null) {
            com.scwang.smartrefresh.layout.b.h hVar2 = this.A0;
            if (hVar2 instanceof com.scwang.smartrefresh.layout.b.g) {
                int i3 = this.q0;
                cVar2.a((com.scwang.smartrefresh.layout.b.g) hVar2, i3, (int) (this.w0 * i3));
            }
        }
        if (valueAnimatorA == null) {
            cVar.onAnimationEnd(null);
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout n(boolean z) {
        this.C = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout o(boolean z) {
        this.M = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout p(boolean z) {
        this.D = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout r(boolean z) {
        this.N = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout s(boolean z) {
        this.e0 = true;
        this.B = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout setPrimaryColors(@ColorInt int... iArr) {
        com.scwang.smartrefresh.layout.b.h hVar = this.A0;
        if (hVar != null) {
            hVar.setPrimaryColors(iArr);
        }
        com.scwang.smartrefresh.layout.b.h hVar2 = this.B0;
        if (hVar2 != null) {
            hVar2.setPrimaryColors(iArr);
        }
        this.z = iArr;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    @Deprecated
    public SmartRefreshLayout t(boolean z) {
        this.G = z;
        return this;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8209e = 250;
        this.f8210f = 250;
        this.f8216l = 0.5f;
        this.f8217m = 'n';
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = true;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.f0 = false;
        this.g0 = false;
        this.n0 = new int[2];
        this.o0 = new NestedScrollingChildHelper(this);
        this.p0 = new NestedScrollingParentHelper(this);
        com.scwang.smartrefresh.layout.c.a aVar = com.scwang.smartrefresh.layout.c.a.DefaultUnNotify;
        this.r0 = aVar;
        this.t0 = aVar;
        this.w0 = 2.5f;
        this.x0 = 2.5f;
        this.y0 = 1.0f;
        this.z0 = 1.0f;
        this.F0 = new n();
        com.scwang.smartrefresh.layout.c.b bVar = com.scwang.smartrefresh.layout.c.b.None;
        this.H0 = bVar;
        this.I0 = bVar;
        this.J0 = 0L;
        this.K0 = 0;
        this.L0 = 0;
        this.O0 = false;
        this.P0 = false;
        this.Q0 = null;
        super.setClipToPadding(false);
        com.scwang.smartrefresh.layout.e.b bVar2 = new com.scwang.smartrefresh.layout.e.b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.w = new Scroller(context);
        this.x = VelocityTracker.obtain();
        this.f8211g = context.getResources().getDisplayMetrics().heightPixels;
        this.y = new com.scwang.smartrefresh.layout.e.f();
        this.f8205a = viewConfiguration.getScaledTouchSlop();
        this.t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.s0 = bVar2.a(60.0f);
        this.q0 = bVar2.a(100.0f);
        this.o0.setNestedScrollingEnabled(true);
        com.scwang.smartrefresh.layout.b.c cVar = V0;
        if (cVar != null) {
            cVar.a(context, this);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        NestedScrollingChildHelper nestedScrollingChildHelper = this.o0;
        nestedScrollingChildHelper.setNestedScrollingEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, nestedScrollingChildHelper.isNestedScrollingEnabled()));
        this.f8216l = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.f8216l);
        this.w0 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.w0);
        this.x0 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.x0);
        this.y0 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.y0);
        this.z0 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.z0);
        this.A = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.A);
        this.f8210f = typedArrayObtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f8210f);
        this.B = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.B);
        this.q0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.q0);
        this.s0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.s0);
        this.u0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.u0);
        this.v0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.v0);
        this.b0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.b0);
        this.c0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.c0);
        this.E = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.E);
        this.F = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.F);
        this.H = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.H);
        this.K = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.K);
        this.I = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.I);
        this.L = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.L);
        this.M = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.M);
        this.N = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.N);
        this.O = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.O);
        this.G = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.G);
        this.G = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, this.G);
        this.C = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.C);
        this.D = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.D);
        this.J = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.J);
        this.p = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.p);
        this.q = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.q);
        this.r = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.r);
        this.s = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.s);
        if (this.L && !typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag)) {
            this.J = true;
        }
        this.e0 = this.e0 || typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.f0 = this.f0 || typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.g0 = this.g0 || typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.r0 = typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight) ? com.scwang.smartrefresh.layout.c.a.XmlLayoutUnNotify : this.r0;
        this.t0 = typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight) ? com.scwang.smartrefresh.layout.c.a.XmlLayoutUnNotify : this.t0;
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.z = new int[]{color2, color};
            } else {
                this.z = new int[]{color2};
            }
        } else if (color != 0) {
            this.z = new int[]{0, color};
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    protected boolean f(int i2) {
        if (i2 == 0) {
            if (this.S0 != null) {
                com.scwang.smartrefresh.layout.c.b bVar = this.H0;
                if (bVar.isFinishing || bVar == com.scwang.smartrefresh.layout.c.b.TwoLevelReleased) {
                    return true;
                }
                if (bVar == com.scwang.smartrefresh.layout.c.b.PullDownCanceled) {
                    this.F0.a(com.scwang.smartrefresh.layout.c.b.PullDownToRefresh);
                } else if (bVar == com.scwang.smartrefresh.layout.c.b.PullUpCanceled) {
                    this.F0.a(com.scwang.smartrefresh.layout.c.b.PullUpToLoad);
                }
                this.S0.cancel();
                this.S0 = null;
            }
            this.R0 = null;
        }
        return this.S0 != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public m generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new m(layoutParams);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout h(float f2) {
        this.f8216l = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout i(float f2) {
        if (this.r0.canReplaceWith(com.scwang.smartrefresh.layout.c.a.CodeExact)) {
            this.q0 = com.scwang.smartrefresh.layout.e.b.b(f2);
            this.r0 = com.scwang.smartrefresh.layout.c.a.CodeExactUnNotify;
            com.scwang.smartrefresh.layout.b.h hVar = this.A0;
            if (hVar != null) {
                hVar.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout c(float f2) {
        if (this.t0.canReplaceWith(com.scwang.smartrefresh.layout.c.a.CodeExact)) {
            this.s0 = com.scwang.smartrefresh.layout.e.b.b(f2);
            this.t0 = com.scwang.smartrefresh.layout.c.a.CodeExactUnNotify;
            com.scwang.smartrefresh.layout.b.h hVar = this.B0;
            if (hVar != null) {
                hVar.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout e(float f2) {
        this.v0 = com.scwang.smartrefresh.layout.e.b.b(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout g(float f2) {
        this.y0 = f2;
        return this;
    }

    @Override // android.view.ViewGroup
    public m generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout h(boolean z) {
        this.A = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout e(boolean z) {
        return a(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.J0))), 300) : 0, z);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout g(boolean z) {
        this.J = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public boolean h() {
        int i2 = this.E0 == null ? 400 : 0;
        int i3 = this.f8210f;
        float f2 = (this.w0 / 2.0f) + 0.5f;
        int i4 = this.q0;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return b(i2, i3, f3 / i4, true);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout b(float f2) {
        this.z0 = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout d(float f2) {
        this.w0 = f2;
        com.scwang.smartrefresh.layout.b.h hVar = this.A0;
        if (hVar != null && this.E0 != null) {
            com.scwang.smartrefresh.layout.b.i iVar = this.F0;
            int i2 = this.q0;
            hVar.a(iVar, i2, (int) (this.w0 * i2));
        } else {
            this.r0 = this.r0.unNotify();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout g() {
        return d(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.J0))), 300));
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout b(int i2) {
        this.f8210f = i2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout e(int i2) {
        return a(i2, true, false);
    }

    protected void k(float f2) {
        com.scwang.smartrefresh.layout.c.b bVar;
        if (this.H0 == com.scwang.smartrefresh.layout.c.b.TwoLevel && f2 > 0.0f) {
            this.F0.a(Math.min((int) f2, getMeasuredHeight()), true);
        } else if (this.H0 == com.scwang.smartrefresh.layout.c.b.Refreshing && f2 >= 0.0f) {
            int i2 = this.q0;
            if (f2 < i2) {
                this.F0.a((int) f2, true);
            } else {
                double d2 = (this.w0 - 1.0f) * i2;
                int iMax = Math.max((this.f8211g * 4) / 3, getHeight());
                int i3 = this.q0;
                double d3 = iMax - i3;
                double dMax = Math.max(0.0f, (f2 - i3) * this.f8216l);
                double d4 = -dMax;
                if (d3 == 0.0d) {
                    d3 = 1.0d;
                }
                this.F0.a(((int) Math.min(d2 * (1.0d - Math.pow(100.0d, d4 / d3)), dMax)) + this.q0, true);
            }
        } else if (f2 < 0.0f && (this.H0 == com.scwang.smartrefresh.layout.c.b.Loading || ((this.G && this.d0 && v(this.B)) || (this.K && !this.d0 && v(this.B))))) {
            int i4 = this.s0;
            if (f2 > (-i4)) {
                this.F0.a((int) f2, true);
            } else {
                double d5 = (this.x0 - 1.0f) * i4;
                int iMax2 = Math.max((this.f8211g * 4) / 3, getHeight());
                int i5 = this.s0;
                double d6 = iMax2 - i5;
                double d7 = -Math.min(0.0f, (i5 + f2) * this.f8216l);
                double d8 = -d7;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                this.F0.a(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d6)), d7))) - this.s0, true);
            }
        } else if (f2 >= 0.0f) {
            double d9 = this.w0 * this.q0;
            double dMax2 = Math.max(this.f8211g / 2, getHeight());
            double dMax3 = Math.max(0.0f, this.f8216l * f2);
            double d10 = -dMax3;
            if (dMax2 == 0.0d) {
                dMax2 = 1.0d;
            }
            this.F0.a((int) Math.min(d9 * (1.0d - Math.pow(100.0d, d10 / dMax2)), dMax3), true);
        } else {
            double d11 = this.x0 * this.s0;
            double dMax4 = Math.max(this.f8211g / 2, getHeight());
            double d12 = -Math.min(0.0f, this.f8216l * f2);
            double d13 = -d12;
            if (dMax4 == 0.0d) {
                dMax4 = 1.0d;
            }
            this.F0.a((int) (-Math.min(d11 * (1.0d - Math.pow(100.0d, d13 / dMax4)), d12)), true);
        }
        if (!this.K || this.d0 || !v(this.B) || f2 >= 0.0f || (bVar = this.H0) == com.scwang.smartrefresh.layout.c.b.Refreshing || bVar == com.scwang.smartrefresh.layout.c.b.Loading || bVar == com.scwang.smartrefresh.layout.c.b.LoadFinish) {
            return;
        }
        if (this.c0) {
            this.R0 = null;
            this.F0.a(-this.s0);
        }
        setStateDirectLoading(false);
        postDelayed(new f(), this.f8210f);
    }

    public static class m extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f8259a;

        /* renamed from: b, reason: collision with root package name */
        public com.scwang.smartrefresh.layout.c.c f8260b;

        public m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8259a = 0;
            this.f8260b = null;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f8259a = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f8259a);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.f8260b = com.scwang.smartrefresh.layout.c.c.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, com.scwang.smartrefresh.layout.c.c.Translate.ordinal())];
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public m(int i2, int i3) {
            super(i2, i3);
            this.f8259a = 0;
            this.f8260b = null;
        }

        public m(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8259a = 0;
            this.f8260b = null;
        }

        public m(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8259a = 0;
            this.f8260b = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout b(boolean z) {
        this.O = z;
        com.scwang.smartrefresh.layout.b.e eVar = this.C0;
        if (eVar != null) {
            eVar.b(z);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public boolean e() {
        int i2 = this.E0 == null ? 400 : 0;
        int i3 = this.f8210f;
        float f2 = (this.w0 / 2.0f) + 0.5f;
        int i4 = this.q0;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return b(i2, i3, f3 / i4, false);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout i(boolean z) {
        return a(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.J0))), 300) : 0, z, false);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout c(boolean z) {
        this.I = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public com.scwang.smartrefresh.layout.b.j c() {
        com.scwang.smartrefresh.layout.c.b bVar = this.H0;
        if (bVar == com.scwang.smartrefresh.layout.c.b.Refreshing) {
            g();
        } else if (bVar == com.scwang.smartrefresh.layout.c.b.Loading) {
            b();
        } else if (this.f8206b != 0) {
            a(0, 0, this.y, this.f8210f);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout d(boolean z) {
        this.b0 = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public boolean i() {
        int i2 = this.f8210f;
        int i3 = this.s0;
        float f2 = i3 * ((this.x0 / 2.0f) + 0.5f) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return a(0, i2, f2 / i3, false);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout b() {
        return e(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.J0))), 300));
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout d(int i2) {
        return a(i2, true);
    }

    protected void j() {
        com.scwang.smartrefresh.layout.c.b bVar = this.H0;
        if (bVar == com.scwang.smartrefresh.layout.c.b.TwoLevel) {
            if (this.v > -1000 && this.f8206b > getMeasuredHeight() / 2) {
                ValueAnimator valueAnimatorA = this.F0.a(getMeasuredHeight());
                if (valueAnimatorA != null) {
                    valueAnimatorA.setDuration(this.f8209e);
                    return;
                }
                return;
            }
            if (this.n) {
                this.F0.b();
                return;
            }
            return;
        }
        if (bVar != com.scwang.smartrefresh.layout.c.b.Loading && (!this.G || !this.d0 || this.f8206b >= 0 || !v(this.B))) {
            com.scwang.smartrefresh.layout.c.b bVar2 = this.H0;
            if (bVar2 == com.scwang.smartrefresh.layout.c.b.Refreshing) {
                int i2 = this.f8206b;
                int i3 = this.q0;
                if (i2 > i3) {
                    this.F0.a(i3);
                    return;
                } else {
                    if (i2 < 0) {
                        this.F0.a(0);
                        return;
                    }
                    return;
                }
            }
            if (bVar2 == com.scwang.smartrefresh.layout.c.b.PullDownToRefresh) {
                this.F0.a(com.scwang.smartrefresh.layout.c.b.PullDownCanceled);
                return;
            }
            if (bVar2 == com.scwang.smartrefresh.layout.c.b.PullUpToLoad) {
                this.F0.a(com.scwang.smartrefresh.layout.c.b.PullUpCanceled);
                return;
            }
            if (bVar2 == com.scwang.smartrefresh.layout.c.b.ReleaseToRefresh) {
                this.F0.a(com.scwang.smartrefresh.layout.c.b.Refreshing);
                return;
            }
            if (bVar2 == com.scwang.smartrefresh.layout.c.b.ReleaseToLoad) {
                this.F0.a(com.scwang.smartrefresh.layout.c.b.Loading);
                return;
            }
            if (bVar2 == com.scwang.smartrefresh.layout.c.b.ReleaseToTwoLevel) {
                this.F0.a(com.scwang.smartrefresh.layout.c.b.TwoLevelReleased);
                return;
            }
            if (bVar2 == com.scwang.smartrefresh.layout.c.b.RefreshReleased) {
                if (this.S0 == null) {
                    this.F0.a(this.q0);
                    return;
                }
                return;
            } else if (bVar2 == com.scwang.smartrefresh.layout.c.b.LoadReleased) {
                if (this.S0 == null) {
                    this.F0.a(-this.s0);
                    return;
                }
                return;
            } else {
                if (this.f8206b != 0) {
                    this.F0.a(0);
                    return;
                }
                return;
            }
        }
        int i4 = this.f8206b;
        int i5 = this.s0;
        if (i4 < (-i5)) {
            this.F0.a(-i5);
        } else if (i4 > 0) {
            this.F0.a(0);
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout l(boolean z) {
        this.K = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout m(boolean z) {
        this.c0 = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout d() {
        return a(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.J0))), 300), true, true);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public boolean b(int i2, int i3, float f2, boolean z) {
        if (this.H0 != com.scwang.smartrefresh.layout.c.b.None || !v(this.A)) {
            return false;
        }
        ValueAnimator valueAnimator = this.S0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        i iVar = new i(f2, i3, z);
        if (i2 > 0) {
            this.S0 = new ValueAnimator();
            postDelayed(iVar, i2);
            return true;
        }
        iVar.run();
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout f(float f2) {
        this.u0 = com.scwang.smartrefresh.layout.e.b.b(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout f(boolean z) {
        this.F = z;
        this.g0 = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    @Deprecated
    public boolean c(int i2) {
        int i3 = this.f8210f;
        int i4 = this.s0;
        float f2 = i4 * ((this.x0 / 2.0f) + 0.5f) * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return a(i2, i3, f2 / i4, false);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public com.scwang.smartrefresh.layout.b.j f() {
        this.d0 = false;
        com.scwang.smartrefresh.layout.b.h hVar = this.B0;
        if ((hVar instanceof com.scwang.smartrefresh.layout.b.f) && !((com.scwang.smartrefresh.layout.b.f) hVar).a(false)) {
            System.out.println("Footer:" + this.B0 + " NoMoreData is not supported.(不支持NoMoreData，请使用ClassicsFooter或者自定义)");
        }
        return this;
    }

    protected boolean a(Float f2) {
        float fFloatValue = f2 == null ? this.v : f2.floatValue();
        if (Math.abs(fFloatValue) > this.t) {
            int i2 = this.f8206b;
            if (i2 * fFloatValue < 0.0f) {
                com.scwang.smartrefresh.layout.c.b bVar = this.H0;
                if (bVar.isOpening) {
                    if (bVar != com.scwang.smartrefresh.layout.c.b.TwoLevel && bVar != this.I0) {
                        this.R0 = new l(fFloatValue).a();
                        return true;
                    }
                } else if (i2 > this.q0 * this.y0 || (-i2) > this.s0 * this.z0) {
                    return true;
                }
            }
            if ((fFloatValue < 0.0f && ((this.I && (this.J || v(this.B))) || ((this.H0 == com.scwang.smartrefresh.layout.c.b.Loading && this.f8206b >= 0) || (this.K && v(this.B))))) || (fFloatValue > 0.0f && ((this.I && (this.J || v(this.A))) || (this.H0 == com.scwang.smartrefresh.layout.c.b.Refreshing && this.f8206b <= 0)))) {
                this.P0 = false;
                this.w.fling(0, 0, 0, (int) (-fFloatValue), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.w.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    protected void a(com.scwang.smartrefresh.layout.c.b bVar) {
        com.scwang.smartrefresh.layout.c.b bVar2 = this.H0;
        if (bVar2 != bVar) {
            this.H0 = bVar;
            this.I0 = bVar;
            com.scwang.smartrefresh.layout.b.h hVar = this.A0;
            com.scwang.smartrefresh.layout.b.h hVar2 = this.B0;
            com.scwang.smartrefresh.layout.d.c cVar = this.j0;
            if (hVar != null) {
                hVar.a(this, bVar2, bVar);
            }
            if (hVar2 != null) {
                hVar2.a(this, bVar2, bVar);
            }
            if (cVar != null) {
                cVar.a(this, bVar2, bVar);
            }
        }
    }

    protected boolean a(boolean z, com.scwang.smartrefresh.layout.b.h hVar) {
        return z || this.L || hVar == null || hVar.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind;
    }

    protected ValueAnimator a(int i2, int i3, Interpolator interpolator, int i4) {
        if (this.f8206b == i2) {
            return null;
        }
        ValueAnimator valueAnimator = this.S0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.R0 = null;
        this.S0 = ValueAnimator.ofInt(this.f8206b, i2);
        this.S0.setDuration(i4);
        this.S0.setInterpolator(interpolator);
        this.S0.addListener(new d());
        this.S0.addUpdateListener(new e());
        this.S0.setStartDelay(i3);
        this.S0.start();
        return this.S0;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout k(boolean z) {
        this.E = z;
        this.f0 = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout j(boolean z) {
        this.L = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(float f2) {
        this.x0 = f2;
        com.scwang.smartrefresh.layout.b.h hVar = this.B0;
        if (hVar != null && this.E0 != null) {
            com.scwang.smartrefresh.layout.b.i iVar = this.F0;
            int i2 = this.s0;
            hVar.a(iVar, i2, (int) (i2 * this.x0));
        } else {
            this.t0 = this.t0.unNotify();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(@NonNull Interpolator interpolator) {
        this.y = interpolator;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(@NonNull com.scwang.smartrefresh.layout.b.g gVar) {
        return a(gVar, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(@NonNull com.scwang.smartrefresh.layout.b.g gVar, int i2, int i3) {
        com.scwang.smartrefresh.layout.b.h hVar = this.A0;
        if (hVar != null) {
            super.removeView(hVar.getView());
        }
        this.A0 = gVar;
        this.K0 = 0;
        this.M0 = false;
        this.r0 = this.r0.unNotify();
        if (this.A0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
            super.addView(this.A0.getView(), 0, new m(i2, i3));
        } else {
            super.addView(this.A0.getView(), i2, i3);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(@NonNull com.scwang.smartrefresh.layout.b.f fVar) {
        return a(fVar, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(@NonNull com.scwang.smartrefresh.layout.b.f fVar, int i2, int i3) {
        com.scwang.smartrefresh.layout.b.h hVar = this.B0;
        if (hVar != null) {
            super.removeView(hVar.getView());
        }
        this.B0 = fVar;
        this.L0 = 0;
        this.N0 = false;
        this.t0 = this.t0.unNotify();
        this.B = !this.e0 || this.B;
        if (this.B0.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
            super.addView(this.B0.getView(), 0, new m(i2, i3));
        } else {
            super.addView(this.B0.getView(), i2, i3);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(@NonNull View view) {
        return a(view, -1, -1);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(@NonNull View view, int i2, int i3) {
        com.scwang.smartrefresh.layout.b.e eVar = this.C0;
        if (eVar != null) {
            super.removeView(eVar.getView());
        }
        super.addView(view, 0, new m(i2, i3));
        com.scwang.smartrefresh.layout.b.h hVar = this.A0;
        if (hVar != null && hVar.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
            super.bringChildToFront(view);
            com.scwang.smartrefresh.layout.b.h hVar2 = this.B0;
            if (hVar2 != null && hVar2.getSpinnerStyle() != com.scwang.smartrefresh.layout.c.c.FixedBehind) {
                super.bringChildToFront(this.B0.getView());
            }
        } else {
            com.scwang.smartrefresh.layout.b.h hVar3 = this.B0;
            if (hVar3 != null && hVar3.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
                super.bringChildToFront(view);
                com.scwang.smartrefresh.layout.b.h hVar4 = this.A0;
                if (hVar4 != null && hVar4.getSpinnerStyle() == com.scwang.smartrefresh.layout.c.c.FixedBehind) {
                    super.bringChildToFront(this.A0.getView());
                }
            }
        }
        this.C0 = new com.scwang.smartrefresh.layout.impl.a(view);
        if (this.E0 != null) {
            int i4 = this.p;
            View viewFindViewById = i4 > 0 ? findViewById(i4) : null;
            int i5 = this.q;
            View viewFindViewById2 = i5 > 0 ? findViewById(i5) : null;
            this.C0.a(this.k0);
            this.C0.b(this.O);
            this.C0.a(this.F0, viewFindViewById, viewFindViewById2);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.d.d dVar) {
        this.h0 = dVar;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.d.b bVar) {
        this.i0 = bVar;
        this.B = this.B || !(this.e0 || bVar == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.d.e eVar) {
        this.h0 = eVar;
        this.i0 = eVar;
        this.B = this.B || !(this.e0 || eVar == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.d.c cVar) {
        this.j0 = cVar;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = com.scwang.smartrefresh.layout.e.e.a(getContext(), iArr[i2]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.b.k kVar) {
        this.k0 = kVar;
        com.scwang.smartrefresh.layout.b.e eVar = this.C0;
        if (eVar != null) {
            eVar.a(kVar);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    @Deprecated
    public SmartRefreshLayout a(boolean z) {
        if (this.H0 == com.scwang.smartrefresh.layout.c.b.Loading && z) {
            b();
        }
        this.d0 = z;
        com.scwang.smartrefresh.layout.b.h hVar = this.B0;
        if ((hVar instanceof com.scwang.smartrefresh.layout.b.f) && !((com.scwang.smartrefresh.layout.b.f) hVar).a(z)) {
            System.out.println("Footer:" + this.B0 + " NoMoreData is not supported.(不支持NoMoreData，请使用ClassicsFooter或者自定义)");
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(int i2, boolean z) {
        if (this.H0 == com.scwang.smartrefresh.layout.c.b.Refreshing && z) {
            f();
        }
        postDelayed(new g(z), i2 <= 0 ? 1L : i2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public SmartRefreshLayout a(int i2, boolean z, boolean z2) {
        postDelayed(new h(z, z2), i2 <= 0 ? 1L : i2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    @Deprecated
    public boolean a(int i2) {
        int i3 = this.f8210f;
        float f2 = (this.w0 / 2.0f) + 0.5f;
        int i4 = this.q0;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return b(i2, i3, f3 / i4, false);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public boolean a() {
        int i2 = this.f8210f;
        int i3 = this.s0;
        float f2 = i3 * ((this.x0 / 2.0f) + 0.5f) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return a(0, i2, f2 / i3, true);
    }

    @Override // com.scwang.smartrefresh.layout.b.j
    public boolean a(int i2, int i3, float f2, boolean z) {
        if (this.H0 != com.scwang.smartrefresh.layout.c.b.None || !v(this.B) || this.d0) {
            return false;
        }
        ValueAnimator valueAnimator = this.S0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        j jVar = new j(f2, i3, z);
        if (i2 > 0) {
            this.S0 = new ValueAnimator();
            postDelayed(jVar, i2);
            return true;
        }
        jVar.run();
        return true;
    }
}
