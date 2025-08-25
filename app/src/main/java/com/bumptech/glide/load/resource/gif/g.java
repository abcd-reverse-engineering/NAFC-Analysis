package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.p.v;

/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: classes.dex */
public final class g implements l<com.bumptech.glide.o.a, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f5043a;

    public g(com.bumptech.glide.load.p.a0.e eVar) {
        this.f5043a = eVar;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull com.bumptech.glide.o.a aVar, @NonNull j jVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    public v<Bitmap> a(@NonNull com.bumptech.glide.o.a aVar, int i2, int i3, @NonNull j jVar) {
        return com.bumptech.glide.load.r.d.g.a(aVar.a(), this.f5043a);
    }
}
