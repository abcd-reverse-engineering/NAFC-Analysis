package com.lxj.xpopup.c;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* compiled from: TranslateAnimator.java */
/* loaded from: classes.dex */
public class g extends b {

    /* renamed from: c, reason: collision with root package name */
    private float f7975c;

    /* renamed from: d, reason: collision with root package name */
    private float f7976d;

    /* renamed from: e, reason: collision with root package name */
    private int f7977e;

    /* renamed from: f, reason: collision with root package name */
    private int f7978f;

    /* renamed from: g, reason: collision with root package name */
    private float f7979g;

    /* renamed from: h, reason: collision with root package name */
    private float f7980h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7981i;

    /* compiled from: TranslateAnimator.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7982a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                f7982a[com.lxj.xpopup.d.c.TranslateFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7982a[com.lxj.xpopup.d.c.TranslateFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7982a[com.lxj.xpopup.d.c.TranslateFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7982a[com.lxj.xpopup.d.c.TranslateFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public g(View view, com.lxj.xpopup.d.c cVar) {
        super(view, cVar);
        this.f7981i = false;
    }

    private void e() {
        int i2 = a.f7982a[this.f7951b.ordinal()];
        if (i2 == 1) {
            this.f7950a.setTranslationX(-r0.getRight());
            return;
        }
        if (i2 == 2) {
            this.f7950a.setTranslationY(-r0.getBottom());
        } else if (i2 == 3) {
            this.f7950a.setTranslationX(((View) r0.getParent()).getMeasuredWidth() - this.f7950a.getLeft());
        } else {
            if (i2 != 4) {
                return;
            }
            this.f7950a.setTranslationY(((View) r0.getParent()).getMeasuredHeight() - this.f7950a.getTop());
        }
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        int i2 = a.f7982a[this.f7951b.ordinal()];
        if (i2 == 1) {
            this.f7975c -= this.f7950a.getMeasuredWidth() - this.f7977e;
        } else if (i2 == 2) {
            this.f7976d -= this.f7950a.getMeasuredHeight() - this.f7978f;
        } else if (i2 == 3) {
            this.f7975c += this.f7950a.getMeasuredWidth() - this.f7977e;
        } else if (i2 == 4) {
            this.f7976d += this.f7950a.getMeasuredHeight() - this.f7978f;
        }
        this.f7950a.animate().translationX(this.f7975c).translationY(this.f7976d).setInterpolator(new FastOutSlowInInterpolator()).setDuration(com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        this.f7950a.animate().translationX(this.f7979g).translationY(this.f7980h).setInterpolator(new FastOutSlowInInterpolator()).setDuration(com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        if (!this.f7981i) {
            this.f7979g = this.f7950a.getTranslationX();
            this.f7980h = this.f7950a.getTranslationY();
            this.f7981i = true;
        }
        e();
        this.f7975c = this.f7950a.getTranslationX();
        this.f7976d = this.f7950a.getTranslationY();
        this.f7977e = this.f7950a.getMeasuredWidth();
        this.f7978f = this.f7950a.getMeasuredHeight();
    }
}
