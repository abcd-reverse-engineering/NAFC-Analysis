package com.chad.library.adapter.base.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: SlideInLeftAnimation.java */
/* loaded from: classes.dex */
public class e implements b {
    @Override // com.chad.library.adapter.base.a.b
    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationX", -view.getRootView().getWidth(), 0.0f)};
    }
}
