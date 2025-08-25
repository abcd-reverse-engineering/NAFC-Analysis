package com.bumptech.glide.r.l;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.r.m.f;

/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class j<Z> extends r<ImageView, Z> implements f.a {

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private Animatable f5297j;

    public j(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        c((j<Z>) null);
        d(drawable);
    }

    protected abstract void a(@Nullable Z z);

    @Override // com.bumptech.glide.r.m.f.a
    @Nullable
    public Drawable b() {
        return ((ImageView) this.f5312b).getDrawable();
    }

    @Override // com.bumptech.glide.r.l.r, com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        Animatable animatable = this.f5297j;
        if (animatable != null) {
            animatable.stop();
        }
        c((j<Z>) null);
        d(drawable);
    }

    @Override // com.bumptech.glide.r.m.f.a
    public void d(Drawable drawable) {
        ((ImageView) this.f5312b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.manager.i
    public void onStart() {
        Animatable animatable = this.f5297j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.manager.i
    public void onStop() {
        Animatable animatable = this.f5297j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Deprecated
    public j(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Override // com.bumptech.glide.r.l.r, com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        c((j<Z>) null);
        d(drawable);
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@NonNull Z z, @Nullable com.bumptech.glide.r.m.f<? super Z> fVar) {
        if (fVar != null && fVar.a(z, this)) {
            b((j<Z>) z);
        } else {
            c((j<Z>) z);
        }
    }

    private void b(@Nullable Z z) {
        if (z instanceof Animatable) {
            this.f5297j = (Animatable) z;
            this.f5297j.start();
        } else {
            this.f5297j = null;
        }
    }

    private void c(@Nullable Z z) {
        a((j<Z>) z);
        b((j<Z>) z);
    }
}
