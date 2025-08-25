package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class y implements com.bumptech.glide.load.l<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final f f4970a = new f();

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return this.f4970a.a(ImageDecoder.createSource(com.bumptech.glide.util.a.a(inputStream)), i2, i3, jVar);
    }
}
