package com.chad.library.adapter.base.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: AlphaInAnimation.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: b, reason: collision with root package name */
    private static final float f5446b = 0.0f;

    /* renamed from: a, reason: collision with root package name */
    private final float f5447a;

    public a() {
        this(0.0f);
    }

    @Override // com.chad.library.adapter.base.a.b
    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", this.f5447a, 1.0f)};
    }

    public a(float f2) {
        this.f5447a = f2;
    }
}
