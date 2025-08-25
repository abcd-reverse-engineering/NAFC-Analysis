package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.r;

/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class d extends com.bumptech.glide.load.r.f.b<GifDrawable> implements r {
    public d(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return ((GifDrawable) this.f4976a).g();
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<GifDrawable> b() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.r.f.b, com.bumptech.glide.load.p.r
    public void c() {
        ((GifDrawable) this.f4976a).c().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
        ((GifDrawable) this.f4976a).stop();
        ((GifDrawable) this.f4976a).i();
    }
}
