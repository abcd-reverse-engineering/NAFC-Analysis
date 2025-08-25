package com.bumptech.glide.r.l;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* compiled from: BaseTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class b<Z> implements p<Z> {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.r.d f5269a;

    @Override // com.bumptech.glide.r.l.p
    public void a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@Nullable com.bumptech.glide.r.d dVar) {
        this.f5269a = dVar;
    }

    @Override // com.bumptech.glide.r.l.p
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    @Override // com.bumptech.glide.r.l.p
    @Nullable
    public com.bumptech.glide.r.d a() {
        return this.f5269a;
    }
}
