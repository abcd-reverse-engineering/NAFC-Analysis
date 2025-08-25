package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.r.d.q;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class f0 implements com.bumptech.glide.load.l<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final q f4860a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f4861b;

    /* compiled from: StreamBitmapDecoder.java */
    static class a implements q.b {

        /* renamed from: a, reason: collision with root package name */
        private final b0 f4862a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.util.c f4863b;

        a(b0 b0Var, com.bumptech.glide.util.c cVar) {
            this.f4862a = b0Var;
            this.f4863b = cVar;
        }

        @Override // com.bumptech.glide.load.r.d.q.b
        public void a() {
            this.f4862a.c();
        }

        @Override // com.bumptech.glide.load.r.d.q.b
        public void a(com.bumptech.glide.load.p.a0.e eVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionC = this.f4863b.c();
            if (iOExceptionC != null) {
                if (bitmap == null) {
                    throw iOExceptionC;
                }
                eVar.a(bitmap);
                throw iOExceptionC;
            }
        }
    }

    public f0(q qVar, com.bumptech.glide.load.p.a0.b bVar) {
        this.f4860a = qVar;
        this.f4861b = bVar;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.j jVar) {
        return this.f4860a.a(inputStream);
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        b0 b0Var;
        boolean z;
        if (inputStream instanceof b0) {
            b0Var = (b0) inputStream;
            z = false;
        } else {
            b0Var = new b0(inputStream, this.f4861b);
            z = true;
        }
        com.bumptech.glide.util.c cVarB = com.bumptech.glide.util.c.b(b0Var);
        try {
            return this.f4860a.a(new com.bumptech.glide.util.h(cVarB), i2, i3, jVar, new a(b0Var, cVarB));
        } finally {
            cVarB.d();
            if (z) {
                b0Var.d();
            }
        }
    }
}
