package com.bumptech.glide.r.l;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: CustomTarget.java */
/* loaded from: classes.dex */
public abstract class e<T> implements p<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f5270a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5271b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.r.d f5272c;

    public e() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public final void a(@Nullable com.bumptech.glide.r.d dVar) {
        this.f5272c = dVar;
    }

    @Override // com.bumptech.glide.r.l.p
    public final void a(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.r.l.p
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public final void b(@NonNull o oVar) {
        oVar.a(this.f5270a, this.f5271b);
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

    public e(int i2, int i3) {
        if (com.bumptech.glide.util.l.b(i2, i3)) {
            this.f5270a = i2;
            this.f5271b = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }

    @Override // com.bumptech.glide.r.l.p
    @Nullable
    public final com.bumptech.glide.r.d a() {
        return this.f5272c;
    }
}
