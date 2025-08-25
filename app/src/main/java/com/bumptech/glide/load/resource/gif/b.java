package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.o.a;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class b implements a.InterfaceC0076a {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f5019a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final com.bumptech.glide.load.p.a0.b f5020b;

    public b(com.bumptech.glide.load.p.a0.e eVar) {
        this(eVar, null);
    }

    @Override // com.bumptech.glide.o.a.InterfaceC0076a
    @NonNull
    public Bitmap a(int i2, int i3, @NonNull Bitmap.Config config) {
        return this.f5019a.b(i2, i3, config);
    }

    @Override // com.bumptech.glide.o.a.InterfaceC0076a
    @NonNull
    public byte[] b(int i2) {
        com.bumptech.glide.load.p.a0.b bVar = this.f5020b;
        return bVar == null ? new byte[i2] : (byte[]) bVar.b(i2, byte[].class);
    }

    public b(com.bumptech.glide.load.p.a0.e eVar, @Nullable com.bumptech.glide.load.p.a0.b bVar) {
        this.f5019a = eVar;
        this.f5020b = bVar;
    }

    @Override // com.bumptech.glide.o.a.InterfaceC0076a
    public void a(@NonNull Bitmap bitmap) {
        this.f5019a.a(bitmap);
    }

    @Override // com.bumptech.glide.o.a.InterfaceC0076a
    public void a(@NonNull byte[] bArr) {
        com.bumptech.glide.load.p.a0.b bVar = this.f5020b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.bumptech.glide.o.a.InterfaceC0076a
    @NonNull
    public int[] a(int i2) {
        com.bumptech.glide.load.p.a0.b bVar = this.f5020b;
        if (bVar == null) {
            return new int[i2];
        }
        return (int[]) bVar.b(i2, int[].class);
    }

    @Override // com.bumptech.glide.o.a.InterfaceC0076a
    public void a(@NonNull int[] iArr) {
        com.bumptech.glide.load.p.a0.b bVar = this.f5020b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
