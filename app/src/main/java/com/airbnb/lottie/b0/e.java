package com.airbnb.lottie.b0;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.g f3437j;

    /* renamed from: c, reason: collision with root package name */
    private float f3430c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3431d = false;

    /* renamed from: e, reason: collision with root package name */
    private long f3432e = 0;

    /* renamed from: f, reason: collision with root package name */
    private float f3433f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    private int f3434g = 0;

    /* renamed from: h, reason: collision with root package name */
    private float f3435h = -2.1474836E9f;

    /* renamed from: i, reason: collision with root package name */
    private float f3436i = 2.1474836E9f;

    /* renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    protected boolean f3438k = false;

    private float q() {
        com.airbnb.lottie.g gVar = this.f3437j;
        if (gVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / gVar.g()) / Math.abs(this.f3430c);
    }

    private boolean r() {
        return j() < 0.0f;
    }

    private void s() {
        if (this.f3437j == null) {
            return;
        }
        float f2 = this.f3433f;
        if (f2 < this.f3435h || f2 > this.f3436i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f3435h), Float.valueOf(this.f3436i), Float.valueOf(this.f3433f)));
        }
    }

    public void a(com.airbnb.lottie.g gVar) {
        boolean z = this.f3437j == null;
        this.f3437j = gVar;
        if (z) {
            a((int) Math.max(this.f3435h, gVar.m()), (int) Math.min(this.f3436i, gVar.e()));
        } else {
            a((int) gVar.m(), (int) gVar.e());
        }
        float f2 = this.f3433f;
        this.f3433f = 0.0f;
        a((int) f2);
        c();
    }

    public void b(float f2) {
        a(this.f3435h, f2);
    }

    public void c(float f2) {
        this.f3430c = f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        n();
    }

    public void d() {
        this.f3437j = null;
        this.f3435h = -2.1474836E9f;
        this.f3436i = 2.1474836E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        m();
        if (this.f3437j == null || !isRunning()) {
            return;
        }
        com.airbnb.lottie.e.a("LottieValueAnimator#doFrame");
        float fQ = (this.f3432e != 0 ? j2 - r1 : 0L) / q();
        float f2 = this.f3433f;
        if (r()) {
            fQ = -fQ;
        }
        this.f3433f = f2 + fQ;
        boolean z = !g.b(this.f3433f, i(), h());
        this.f3433f = g.a(this.f3433f, i(), h());
        this.f3432e = j2;
        c();
        if (z) {
            if (getRepeatCount() == -1 || this.f3434g < getRepeatCount()) {
                b();
                this.f3434g++;
                if (getRepeatMode() == 2) {
                    this.f3431d = !this.f3431d;
                    p();
                } else {
                    this.f3433f = r() ? h() : i();
                }
                this.f3432e = j2;
            } else {
                this.f3433f = this.f3430c < 0.0f ? i() : h();
                n();
                a(r());
            }
        }
        s();
        com.airbnb.lottie.e.b("LottieValueAnimator#doFrame");
    }

    @MainThread
    public void e() {
        n();
        a(r());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float f() {
        com.airbnb.lottie.g gVar = this.f3437j;
        if (gVar == null) {
            return 0.0f;
        }
        return (this.f3433f - gVar.m()) / (this.f3437j.e() - this.f3437j.m());
    }

    public float g() {
        return this.f3433f;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float fI;
        float fH;
        float fI2;
        if (this.f3437j == null) {
            return 0.0f;
        }
        if (r()) {
            fI = h() - this.f3433f;
            fH = h();
            fI2 = i();
        } else {
            fI = this.f3433f - i();
            fH = h();
            fI2 = i();
        }
        return fI / (fH - fI2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(f());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.airbnb.lottie.g gVar = this.f3437j;
        if (gVar == null) {
            return 0L;
        }
        return (long) gVar.c();
    }

    public float h() {
        com.airbnb.lottie.g gVar = this.f3437j;
        if (gVar == null) {
            return 0.0f;
        }
        float f2 = this.f3436i;
        return f2 == 2.1474836E9f ? gVar.e() : f2;
    }

    public float i() {
        com.airbnb.lottie.g gVar = this.f3437j;
        if (gVar == null) {
            return 0.0f;
        }
        float f2 = this.f3435h;
        return f2 == -2.1474836E9f ? gVar.m() : f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f3438k;
    }

    public float j() {
        return this.f3430c;
    }

    @MainThread
    public void k() {
        n();
    }

    @MainThread
    public void l() {
        this.f3438k = true;
        b(r());
        a((int) (r() ? h() : i()));
        this.f3432e = 0L;
        this.f3434g = 0;
        m();
    }

    protected void m() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void n() {
        c(true);
    }

    @MainThread
    public void o() {
        this.f3438k = true;
        m();
        this.f3432e = 0L;
        if (r() && g() == i()) {
            this.f3433f = h();
        } else {
            if (r() || g() != h()) {
                return;
            }
            this.f3433f = i();
        }
    }

    public void p() {
        c(-j());
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f3431d) {
            return;
        }
        this.f3431d = false;
        p();
    }

    @MainThread
    protected void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f3438k = false;
        }
    }

    public void a(float f2) {
        if (this.f3433f == f2) {
            return;
        }
        this.f3433f = g.a(f2, i(), h());
        this.f3432e = 0L;
        c();
    }

    public void a(int i2) {
        a(i2, (int) this.f3436i);
    }

    public void a(float f2, float f3) {
        if (f2 <= f3) {
            com.airbnb.lottie.g gVar = this.f3437j;
            float fM = gVar == null ? -3.4028235E38f : gVar.m();
            com.airbnb.lottie.g gVar2 = this.f3437j;
            float fE = gVar2 == null ? Float.MAX_VALUE : gVar2.e();
            float fA = g.a(f2, fM, fE);
            float fA2 = g.a(f3, fM, fE);
            if (fA == this.f3435h && fA2 == this.f3436i) {
                return;
            }
            this.f3435h = fA;
            this.f3436i = fA2;
            a((int) g.a(this.f3433f, fA, fA2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
    }
}
