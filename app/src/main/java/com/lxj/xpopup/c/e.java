package com.lxj.xpopup.c;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* compiled from: ShadowBgAnimator.java */
/* loaded from: classes.dex */
public class e extends com.lxj.xpopup.c.b {

    /* renamed from: c, reason: collision with root package name */
    public ArgbEvaluator f7965c;

    /* renamed from: d, reason: collision with root package name */
    public int f7966d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7967e;

    /* compiled from: ShadowBgAnimator.java */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.f7950a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: ShadowBgAnimator.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.f7950a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public e(View view) {
        super(view);
        this.f7965c = new ArgbEvaluator();
        this.f7966d = 0;
        this.f7967e = false;
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f7965c, Integer.valueOf(com.lxj.xpopup.b.c()), Integer.valueOf(this.f7966d));
        valueAnimatorOfObject.addUpdateListener(new b());
        valueAnimatorOfObject.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfObject.setDuration(this.f7967e ? 0L : com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f7965c, Integer.valueOf(this.f7966d), Integer.valueOf(com.lxj.xpopup.b.c()));
        valueAnimatorOfObject.addUpdateListener(new a());
        valueAnimatorOfObject.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfObject.setDuration(this.f7967e ? 0L : com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        this.f7950a.setBackgroundColor(this.f7966d);
    }

    public e() {
        this.f7965c = new ArgbEvaluator();
        this.f7966d = 0;
        this.f7967e = false;
    }

    public int a(float f2) {
        return ((Integer) this.f7965c.evaluate(f2, Integer.valueOf(this.f7966d), Integer.valueOf(com.lxj.xpopup.b.c()))).intValue();
    }
}
