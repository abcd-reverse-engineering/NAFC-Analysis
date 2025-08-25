package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder.java */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.load.l<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final q f4880a;

    public j(q qVar) {
        this.f4880a = qVar;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.j jVar) {
        return this.f4880a.a(byteBuffer);
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return this.f4880a.a(com.bumptech.glide.util.a.c(byteBuffer), i2, i3, jVar);
    }
}
