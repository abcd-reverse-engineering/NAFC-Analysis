package com.bumptech.glide.r.m;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.r.m.f;

/* compiled from: DrawableCrossFadeTransition.java */
/* loaded from: classes.dex */
public class d implements f<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f5334a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5335b;

    public d(int i2, boolean z) {
        this.f5334a = i2;
        this.f5335b = z;
    }

    @Override // com.bumptech.glide.r.m.f
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable drawableB = aVar.b();
        if (drawableB == null) {
            drawableB = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableB, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f5335b);
        transitionDrawable.startTransition(this.f5334a);
        aVar.d(transitionDrawable);
        return true;
    }
}
