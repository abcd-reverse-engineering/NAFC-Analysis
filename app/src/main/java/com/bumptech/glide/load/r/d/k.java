package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class k implements com.bumptech.glide.load.l<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final f f4894a = new f();

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return this.f4894a.a(ImageDecoder.createSource(byteBuffer), i2, i3, jVar);
    }
}
