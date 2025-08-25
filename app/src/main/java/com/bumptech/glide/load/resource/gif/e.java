package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.n;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class e implements n<GifDrawable> {

    /* renamed from: c, reason: collision with root package name */
    private final n<Bitmap> f5022c;

    public e(n<Bitmap> nVar) {
        this.f5022c = (n) j.a(nVar);
    }

    @Override // com.bumptech.glide.load.n
    @NonNull
    public v<GifDrawable> a(@NonNull Context context, @NonNull v<GifDrawable> vVar, int i2, int i3) {
        GifDrawable gifDrawable = vVar.get();
        v<Bitmap> gVar = new com.bumptech.glide.load.r.d.g(gifDrawable.c(), com.bumptech.glide.b.a(context).d());
        v<Bitmap> vVarA = this.f5022c.a(context, gVar, i2, i3);
        if (!gVar.equals(vVarA)) {
            gVar.recycle();
        }
        gifDrawable.a(this.f5022c, vVarA.get());
        return vVar;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f5022c.equals(((e) obj).f5022c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f5022c.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        this.f5022c.a(messageDigest);
    }
}
