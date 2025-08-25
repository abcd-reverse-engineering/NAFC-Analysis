package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ImageReader.java */
/* loaded from: classes.dex */
interface x {

    /* compiled from: ImageReader.java */
    public static final class a implements x {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.o.k f4964a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.p.a0.b f4965b;

        /* renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f4966c;

        a(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.p.a0.b bVar) {
            this.f4965b = (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar);
            this.f4966c = (List) com.bumptech.glide.util.j.a(list);
            this.f4964a = new com.bumptech.glide.load.o.k(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.r.d.x
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f4964a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.r.d.x
        public void b() {
            this.f4964a.c();
        }

        @Override // com.bumptech.glide.load.r.d.x
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.f.b(this.f4966c, this.f4964a.a(), this.f4965b);
        }

        @Override // com.bumptech.glide.load.r.d.x
        public int a() throws IOException {
            return com.bumptech.glide.load.f.a(this.f4966c, this.f4964a.a(), this.f4965b);
        }
    }

    int a() throws IOException;

    @Nullable
    Bitmap a(BitmapFactory.Options options) throws IOException;

    void b();

    ImageHeaderParser.ImageType c() throws IOException;

    /* compiled from: ImageReader.java */
    @RequiresApi(21)
    public static final class b implements x {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.p.a0.b f4967a;

        /* renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f4968b;

        /* renamed from: c, reason: collision with root package name */
        private final com.bumptech.glide.load.o.m f4969c;

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.p.a0.b bVar) {
            this.f4967a = (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar);
            this.f4968b = (List) com.bumptech.glide.util.j.a(list);
            this.f4969c = new com.bumptech.glide.load.o.m(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.r.d.x
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f4969c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.r.d.x
        public void b() {
        }

        @Override // com.bumptech.glide.load.r.d.x
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.f.b(this.f4968b, this.f4969c, this.f4967a);
        }

        @Override // com.bumptech.glide.load.r.d.x
        public int a() throws IOException {
            return com.bumptech.glide.load.f.a(this.f4968b, this.f4969c, this.f4967a);
        }
    }
}
