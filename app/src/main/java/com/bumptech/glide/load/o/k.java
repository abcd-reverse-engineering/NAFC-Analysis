package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.e;
import com.bumptech.glide.load.r.d.b0;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder.java */
/* loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* renamed from: b, reason: collision with root package name */
    private static final int f4285b = 5242880;

    /* renamed from: a, reason: collision with root package name */
    private final b0 f4286a;

    /* compiled from: InputStreamRewinder.java */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.p.a0.b f4287a;

        public a(com.bumptech.glide.load.p.a0.b bVar) {
            this.f4287a = bVar;
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.f4287a);
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, com.bumptech.glide.load.p.a0.b bVar) {
        this.f4286a = new b0(inputStream, bVar);
        this.f4286a.mark(5242880);
    }

    @Override // com.bumptech.glide.load.o.e
    public void b() {
        this.f4286a.d();
    }

    public void c() {
        this.f4286a.c();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.o.e
    @NonNull
    public InputStream a() throws IOException {
        this.f4286a.reset();
        return this.f4286a;
    }
}
