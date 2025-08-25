package com.bumptech.glide.load.q;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader.java */
/* loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4700a = "ByteBufferFileLoader";

    /* compiled from: ByteBufferFileLoader.java */
    public static class b implements o<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<File, ByteBuffer> a(@NonNull r rVar) {
            return new d();
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<ByteBuffer> a(@NonNull File file, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(file), new a(file));
    }

    /* compiled from: ByteBufferFileLoader.java */
    private static final class a implements com.bumptech.glide.load.o.d<ByteBuffer> {

        /* renamed from: a, reason: collision with root package name */
        private final File f4701a;

        a(File file) {
            this.f4701a = file;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a((d.a<? super ByteBuffer>) com.bumptech.glide.util.a.a(this.f4701a));
            } catch (IOException e2) {
                Log.isLoggable(d.f4700a, 3);
                aVar.a((Exception) e2);
            }
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
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}
