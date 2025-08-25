package com.airbnb.lottie.b0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseLottieAnimator.java */
/* loaded from: classes.dex */
public abstract class a extends ValueAnimator {

    /* renamed from: a, reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f3426a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private final Set<Animator.AnimatorListener> f3427b = new CopyOnWriteArraySet();

    void a(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f3427b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f3427b.add(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3426a.add(animatorUpdateListener);
    }

    void b(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f3427b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    void c() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f3426a.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f3427b.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f3426a.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f3427b.remove(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3426a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    void a() {
        Iterator<Animator.AnimatorListener> it = this.f3427b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void b() {
        Iterator<Animator.AnimatorListener> it = this.f3427b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }
}
