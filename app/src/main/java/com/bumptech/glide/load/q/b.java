package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0069b<Data> f4694a;

    /* compiled from: ByteArrayLoader.java */
    public static class a implements o<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: com.bumptech.glide.load.q.b$a$a, reason: collision with other inner class name */
        class C0068a implements InterfaceC0069b<ByteBuffer> {
            C0068a() {
            }

            @Override // com.bumptech.glide.load.q.b.InterfaceC0069b
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // com.bumptech.glide.load.q.b.InterfaceC0069b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<byte[], ByteBuffer> a(@NonNull r rVar) {
            return new b(new C0068a());
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.q.b$b, reason: collision with other inner class name */
    public interface InterfaceC0069b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* compiled from: ByteArrayLoader.java */
    public static class d implements o<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        class a implements InterfaceC0069b<InputStream> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.q.b.InterfaceC0069b
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // com.bumptech.glide.load.q.b.InterfaceC0069b
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<byte[], InputStream> a(@NonNull r rVar) {
            return new b(new a());
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public b(InterfaceC0069b<Data> interfaceC0069b) {
        this.f4694a = interfaceC0069b;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }

    /* compiled from: ByteArrayLoader.java */
    private static class c<Data> implements com.bumptech.glide.load.o.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f4696a;

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC0069b<Data> f4697b;

        c(byte[] bArr, InterfaceC0069b<Data> interfaceC0069b) {
            this.f4696a = bArr;
            this.f4697b = interfaceC0069b;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Data> aVar) {
            aVar.a((d.a<? super Data>) this.f4697b.a(this.f4696a));
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<Data> a() {
            return this.f4697b.a();
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull byte[] bArr, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(bArr), new c(bArr, this.f4694a));
    }
}
