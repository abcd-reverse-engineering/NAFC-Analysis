package com.bumptech.glide.load.q.y;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.r;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class g implements n<URL, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final n<com.bumptech.glide.load.q.g, InputStream> f4820a;

    /* compiled from: UrlLoader.java */
    public static class a implements o<URL, InputStream> {
        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<URL, InputStream> a(r rVar) {
            return new g(rVar.a(com.bumptech.glide.load.q.g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public g(n<com.bumptech.glide.load.q.g, InputStream> nVar) {
        this.f4820a = nVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull URL url) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<InputStream> a(@NonNull URL url, int i2, int i3, @NonNull j jVar) {
        return this.f4820a.a(new com.bumptech.glide.load.q.g(url), i2, i3, jVar);
    }
}
