package com.chad.library.adapter.base.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: SlideInBottomAnimation.java */
/* loaded from: classes.dex */
public class d implements b {
    @Override // com.chad.library.adapter.base.a.b
    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0.0f)};
    }
}
