package com.bumptech.glide.load.q;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f4710b = "FileLoader";

    /* renamed from: a, reason: collision with root package name */
    private final d<Data> f4711a;

    /* compiled from: FileLoader.java */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final d<Data> f4712a;

        public a(d<Data> dVar) {
            this.f4712a = dVar;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public final n<File, Data> a(@NonNull r rVar) {
            return new f(this.f4712a);
        }

        @Override // com.bumptech.glide.load.q.o
        public final void a() {
        }
    }

    /* compiled from: FileLoader.java */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: FileLoader.java */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.q.f.d
            public ParcelFileDescriptor a(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, CommonNetImpl.FLAG_AUTH);
            }

            @Override // com.bumptech.glide.load.q.f.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.q.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }
        }

        public b() {
            super(new a());
        }
    }

    /* compiled from: FileLoader.java */
    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void close(Data data) throws IOException;
    }

    /* compiled from: FileLoader.java */
    public static class e extends a<InputStream> {

        /* compiled from: FileLoader.java */
        class a implements d<InputStream> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.q.f.d
            public InputStream a(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            @Override // com.bumptech.glide.load.q.f.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.q.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f4711a = dVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull File file, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(file), new c(file, this.f4711a));
    }

    /* compiled from: FileLoader.java */
    private static final class c<Data> implements com.bumptech.glide.load.o.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final File f4713a;

        /* renamed from: b, reason: collision with root package name */
        private final d<Data> f4714b;

        /* renamed from: c, reason: collision with root package name */
        private Data f4715c;

        c(File file, d<Data> dVar) {
            this.f4713a = file;
            this.f4714b = dVar;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Data> aVar) {
            try {
                this.f4715c = this.f4714b.a(this.f4713a);
                aVar.a((d.a<? super Data>) this.f4715c);
            } catch (FileNotFoundException e2) {
                Log.isLoggable(f.f4710b, 3);
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
            Data data = this.f4715c;
            if (data != null) {
                try {
                    this.f4714b.close(data);
                } catch (IOException unused) {
                }
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
            return this.f4714b.a();
        }
    }
}
