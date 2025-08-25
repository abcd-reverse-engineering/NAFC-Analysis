package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorBitmapDecoder.java */
@RequiresApi(21)
/* loaded from: classes.dex */
public final class a0 implements com.bumptech.glide.load.l<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final q f4835a;

    public a0(q qVar) {
        this.f4835a = qVar;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull com.bumptech.glide.load.j jVar) {
        return this.f4835a.a(parcelFileDescriptor);
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return this.f4835a.a(parcelFileDescriptor, i2, i3, jVar);
    }
}
