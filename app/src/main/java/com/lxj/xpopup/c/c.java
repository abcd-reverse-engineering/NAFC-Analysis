package com.lxj.xpopup.c;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* compiled from: ScaleAlphaAnimator.java */
/* loaded from: classes.dex */
public class c extends com.lxj.xpopup.c.b {

    /* compiled from: ScaleAlphaAnimator.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.e();
        }
    }

    /* compiled from: ScaleAlphaAnimator.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7953a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                f7953a[com.lxj.xpopup.d.c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7953a[com.lxj.xpopup.d.c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7953a[com.lxj.xpopup.d.c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7953a[com.lxj.xpopup.d.c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7953a[com.lxj.xpopup.d.c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c(View view, com.lxj.xpopup.d.c cVar) {
        super(view, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i2 = b.f7953a[this.f7951b.ordinal()];
        if (i2 == 1) {
            this.f7950a.setPivotX(r0.getMeasuredWidth() / 2);
            this.f7950a.setPivotY(r0.getMeasuredHeight() / 2);
            return;
        }
        if (i2 == 2) {
            this.f7950a.setPivotX(0.0f);
            this.f7950a.setPivotY(0.0f);
            return;
        }
        if (i2 == 3) {
            this.f7950a.setPivotX(r0.getMeasuredWidth());
            this.f7950a.setPivotY(0.0f);
        } else if (i2 == 4) {
            this.f7950a.setPivotX(0.0f);
            this.f7950a.setPivotY(r0.getMeasuredHeight());
        } else {
            if (i2 != 5) {
                return;
            }
            this.f7950a.setPivotX(r0.getMeasuredWidth());
            this.f7950a.setPivotY(r0.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        this.f7950a.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(com.lxj.xpopup.b.a()).setInterpolator(new OvershootInterpolator(1.0f)).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        this.f7950a.setScaleX(0.0f);
        this.f7950a.setScaleY(0.0f);
        this.f7950a.setAlpha(0.0f);
        this.f7950a.post(new a());
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        this.f7950a.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(com.lxj.xpopup.b.a()).setInterpolator(new FastOutSlowInInterpolator()).start();
    }
}
