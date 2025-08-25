package com.lxj.xpopup.c;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* compiled from: TranslateAlphaAnimator.java */
/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: c, reason: collision with root package name */
    private float f7970c;

    /* renamed from: d, reason: collision with root package name */
    private float f7971d;

    /* renamed from: e, reason: collision with root package name */
    private float f7972e;

    /* renamed from: f, reason: collision with root package name */
    private float f7973f;

    /* compiled from: TranslateAlphaAnimator.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7974a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                f7974a[com.lxj.xpopup.d.c.TranslateAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7974a[com.lxj.xpopup.d.c.TranslateAlphaFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7974a[com.lxj.xpopup.d.c.TranslateAlphaFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7974a[com.lxj.xpopup.d.c.TranslateAlphaFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(View view, com.lxj.xpopup.d.c cVar) {
        super(view, cVar);
    }

    private void e() {
        int iC = com.lxj.xpopup.f.c.c(this.f7950a.getContext()) / 2;
        int measuredWidth = this.f7950a.getMeasuredWidth() / 2;
        int iB = com.lxj.xpopup.f.c.b(this.f7950a.getContext()) / 2;
        int measuredHeight = this.f7950a.getMeasuredHeight() / 2;
        int i2 = a.f7974a[this.f7951b.ordinal()];
        if (i2 == 1) {
            this.f7950a.setTranslationX(-r0.getMeasuredWidth());
            return;
        }
        if (i2 == 2) {
            this.f7950a.setTranslationY(-r0.getMeasuredHeight());
        } else if (i2 == 3) {
            this.f7950a.setTranslationX(r0.getMeasuredWidth());
        } else {
            if (i2 != 4) {
                return;
            }
            this.f7950a.setTranslationY(r0.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        this.f7950a.animate().translationX(this.f7970c).translationY(this.f7971d).alpha(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        this.f7950a.animate().translationX(this.f7972e).translationY(this.f7973f).alpha(1.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        this.f7972e = this.f7950a.getTranslationX();
        this.f7973f = this.f7950a.getTranslationY();
        this.f7950a.setAlpha(0.0f);
        e();
        this.f7970c = this.f7950a.getTranslationX();
        this.f7971d = this.f7950a.getTranslationY();
    }
}
