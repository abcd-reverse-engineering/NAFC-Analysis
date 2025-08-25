package com.bumptech.glide.r.m;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.r.m.f;

/* compiled from: ViewTransition.java */
/* loaded from: classes.dex */
public class k<R> implements f<R> {

    /* renamed from: a, reason: collision with root package name */
    private final a f5345a;

    /* compiled from: ViewTransition.java */
    interface a {
        Animation a(Context context);
    }

    k(a aVar) {
        this.f5345a = aVar;
    }

    @Override // com.bumptech.glide.r.m.f
    public boolean a(R r, f.a aVar) {
        View view = aVar.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.f5345a.a(view.getContext()));
        return false;
    }
}
