package com.chad.library.adapter.base.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: ScaleInAnimation.java */
/* loaded from: classes.dex */
public class c implements b {

    /* renamed from: b, reason: collision with root package name */
    private static final float f5448b = 0.5f;

    /* renamed from: a, reason: collision with root package name */
    private final float f5449a;

    public c() {
        this(f5448b);
    }

    @Override // com.chad.library.adapter.base.a.b
    public Animator[] a(View view) {
        return new ObjectAnimator[]{ObjectAnimator.ofFloat(view, "scaleX", this.f5449a, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", this.f5449a, 1.0f)};
    }

    public c(float f2) {
        this.f5449a = f2;
    }
}
