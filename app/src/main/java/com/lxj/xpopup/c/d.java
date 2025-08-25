package com.lxj.xpopup.c;

import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* compiled from: ScrollScaleAnimator.java */
/* loaded from: classes.dex */
public class d extends com.lxj.xpopup.c.b {

    /* renamed from: c, reason: collision with root package name */
    private FloatEvaluator f7954c;

    /* renamed from: d, reason: collision with root package name */
    private IntEvaluator f7955d;

    /* renamed from: e, reason: collision with root package name */
    private int f7956e;

    /* renamed from: f, reason: collision with root package name */
    private int f7957f;

    /* renamed from: g, reason: collision with root package name */
    private float f7958g;

    /* renamed from: h, reason: collision with root package name */
    private float f7959h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7960i;

    /* compiled from: ScrollScaleAnimator.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.e();
            d dVar = d.this;
            dVar.f7950a.scrollTo(dVar.f7956e, d.this.f7957f);
            if (d.this.f7950a.getBackground() != null) {
                d.this.f7950a.getBackground().setAlpha(0);
            }
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            d dVar = d.this;
            View view = dVar.f7950a;
            FloatEvaluator floatEvaluator = dVar.f7954c;
            Float fValueOf = Float.valueOf(d.this.f7958g);
            Float fValueOf2 = Float.valueOf(1.0f);
            view.setAlpha(floatEvaluator.evaluate(animatedFraction, (Number) fValueOf, (Number) fValueOf2).floatValue());
            d dVar2 = d.this;
            dVar2.f7950a.scrollTo(dVar2.f7955d.evaluate(animatedFraction, Integer.valueOf(d.this.f7956e), (Integer) 0).intValue(), d.this.f7955d.evaluate(animatedFraction, Integer.valueOf(d.this.f7957f), (Integer) 0).intValue());
            float fFloatValue = d.this.f7954c.evaluate(animatedFraction, (Number) Float.valueOf(d.this.f7959h), (Number) fValueOf2).floatValue();
            d.this.f7950a.setScaleX(fFloatValue);
            d dVar3 = d.this;
            if (!dVar3.f7960i) {
                dVar3.f7950a.setScaleY(fFloatValue);
            }
            if (animatedFraction < 0.9f || d.this.f7950a.getBackground() == null) {
                return;
            }
            d.this.f7950a.getBackground().setAlpha((int) (((animatedFraction - 0.9f) / 0.1f) * 255.0f));
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            d dVar = d.this;
            View view = dVar.f7950a;
            FloatEvaluator floatEvaluator = dVar.f7954c;
            Float fValueOf = Float.valueOf(1.0f);
            view.setAlpha(floatEvaluator.evaluate(animatedFraction, (Number) fValueOf, (Number) Float.valueOf(d.this.f7958g)).floatValue());
            d dVar2 = d.this;
            dVar2.f7950a.scrollTo(dVar2.f7955d.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(d.this.f7956e)).intValue(), d.this.f7955d.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(d.this.f7957f)).intValue());
            float fFloatValue = d.this.f7954c.evaluate(animatedFraction, (Number) fValueOf, (Number) Float.valueOf(d.this.f7959h)).floatValue();
            d.this.f7950a.setScaleX(fFloatValue);
            d dVar3 = d.this;
            if (!dVar3.f7960i) {
                dVar3.f7950a.setScaleY(fFloatValue);
            }
            if (d.this.f7950a.getBackground() != null) {
                d.this.f7950a.getBackground().setAlpha((int) (animatedFraction * 255.0f));
            }
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    /* renamed from: com.lxj.xpopup.c.d$d, reason: collision with other inner class name */
    static /* synthetic */ class C0113d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7964a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                f7964a[com.lxj.xpopup.d.c.ScrollAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7964a[com.lxj.xpopup.d.c.ScrollAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7964a[com.lxj.xpopup.d.c.ScrollAlphaFromTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7964a[com.lxj.xpopup.d.c.ScrollAlphaFromRightTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7964a[com.lxj.xpopup.d.c.ScrollAlphaFromRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7964a[com.lxj.xpopup.d.c.ScrollAlphaFromRightBottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7964a[com.lxj.xpopup.d.c.ScrollAlphaFromBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7964a[com.lxj.xpopup.d.c.ScrollAlphaFromLeftBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public d(View view, com.lxj.xpopup.d.c cVar) {
        super(view, cVar);
        this.f7954c = new FloatEvaluator();
        this.f7955d = new IntEvaluator();
        this.f7958g = 0.2f;
        this.f7959h = 0.0f;
        this.f7960i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        switch (C0113d.f7964a[this.f7951b.ordinal()]) {
            case 1:
                this.f7950a.setPivotX(0.0f);
                this.f7950a.setPivotY(r0.getMeasuredHeight() / 2);
                this.f7956e = this.f7950a.getMeasuredWidth();
                this.f7957f = 0;
                break;
            case 2:
                this.f7950a.setPivotX(0.0f);
                this.f7950a.setPivotY(0.0f);
                this.f7956e = this.f7950a.getMeasuredWidth();
                this.f7957f = this.f7950a.getMeasuredHeight();
                break;
            case 3:
                this.f7950a.setPivotX(r0.getMeasuredWidth() / 2);
                this.f7950a.setPivotY(0.0f);
                this.f7957f = this.f7950a.getMeasuredHeight();
                break;
            case 4:
                this.f7950a.setPivotX(r0.getMeasuredWidth());
                this.f7950a.setPivotY(0.0f);
                this.f7956e = -this.f7950a.getMeasuredWidth();
                this.f7957f = this.f7950a.getMeasuredHeight();
                break;
            case 5:
                this.f7950a.setPivotX(r0.getMeasuredWidth());
                this.f7950a.setPivotY(r0.getMeasuredHeight() / 2);
                this.f7956e = -this.f7950a.getMeasuredWidth();
                break;
            case 6:
                this.f7950a.setPivotX(r0.getMeasuredWidth());
                this.f7950a.setPivotY(r0.getMeasuredHeight());
                this.f7956e = -this.f7950a.getMeasuredWidth();
                this.f7957f = -this.f7950a.getMeasuredHeight();
                break;
            case 7:
                this.f7950a.setPivotX(r0.getMeasuredWidth() / 2);
                this.f7950a.setPivotY(r0.getMeasuredHeight());
                this.f7957f = -this.f7950a.getMeasuredHeight();
                break;
            case 8:
                this.f7950a.setPivotX(0.0f);
                this.f7950a.setPivotY(r0.getMeasuredHeight());
                this.f7956e = this.f7950a.getMeasuredWidth();
                this.f7957f = -this.f7950a.getMeasuredHeight();
                break;
        }
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new c());
        valueAnimatorOfFloat.setDuration(com.lxj.xpopup.b.a()).setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfFloat.start();
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b());
        valueAnimatorOfFloat.setDuration(com.lxj.xpopup.b.a()).setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfFloat.start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        this.f7950a.setAlpha(this.f7958g);
        this.f7950a.setScaleX(this.f7959h);
        if (!this.f7960i) {
            this.f7950a.setScaleY(this.f7959h);
        }
        this.f7950a.post(new a());
    }
}
