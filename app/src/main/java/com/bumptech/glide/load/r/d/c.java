package com.bumptech.glide.load.r.d;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* compiled from: BitmapDrawableResource.java */
/* loaded from: classes.dex */
public class c extends com.bumptech.glide.load.r.f.b<BitmapDrawable> implements com.bumptech.glide.load.p.r {

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f4844b;

    public c(BitmapDrawable bitmapDrawable, com.bumptech.glide.load.p.a0.e eVar) {
        super(bitmapDrawable);
        this.f4844b = eVar;
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return com.bumptech.glide.util.l.a(((BitmapDrawable) this.f4976a).getBitmap());
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.r.f.b, com.bumptech.glide.load.p.r
    public void c() {
        ((BitmapDrawable) this.f4976a).getBitmap().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
        this.f4844b.a(((BitmapDrawable) this.f4976a).getBitmap());
    }
}
