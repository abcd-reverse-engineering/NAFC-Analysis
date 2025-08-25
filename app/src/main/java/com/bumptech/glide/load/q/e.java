package com.bumptech.glide.load.q;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f4702b = "data:image";

    /* renamed from: c, reason: collision with root package name */
    private static final String f4703c = ";base64";

    /* renamed from: a, reason: collision with root package name */
    private final a<Data> f4704a;

    /* compiled from: DataUrlLoader.java */
    public interface a<Data> {
        Class<Data> a();

        void close(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* compiled from: DataUrlLoader.java */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final a<InputStream> f4708a = new a();

        /* compiled from: DataUrlLoader.java */
        class a implements a<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.q.e.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.q.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.q.e.a
            public InputStream decode(String str) {
                if (!str.startsWith(e.f4702b)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(e.f4703c)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Model, InputStream> a(@NonNull r rVar) {
            return new e(this.f4708a);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public e(a<Data> aVar) {
        this.f4704a = aVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(model), new b(model.toString(), this.f4704a));
    }

    /* compiled from: DataUrlLoader.java */
    private static final class b<Data> implements com.bumptech.glide.load.o.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final String f4705a;

        /* renamed from: b, reason: collision with root package name */
        private final a<Data> f4706b;

        /* renamed from: c, reason: collision with root package name */
        private Data f4707c;

        b(String str, a<Data> aVar) {
            this.f4705a = str;
            this.f4706b = aVar;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Data> aVar) {
            try {
                this.f4707c = this.f4706b.decode(this.f4705a);
                aVar.a((d.a<? super Data>) this.f4707c);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
            try {
                this.f4706b.close(this.f4707c);
            } catch (IOException unused) {
            }
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
            return this.f4706b.a();
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith(f4702b);
    }
}
