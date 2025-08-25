package com.bumptech.glide.load.q.y;

import android.net.Uri;
import androidx.annotation.NonNull;
import anet.channel.util.HttpConstant;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.r;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader.java */
/* loaded from: classes.dex */
public class c implements n<Uri, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f4797b = Collections.unmodifiableSet(new HashSet(Arrays.asList(HttpConstant.HTTP, HttpConstant.HTTPS)));

    /* renamed from: a, reason: collision with root package name */
    private final n<com.bumptech.glide.load.q.g, InputStream> f4798a;

    /* compiled from: HttpUriLoader.java */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new c(rVar.a(com.bumptech.glide.load.q.g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public c(n<com.bumptech.glide.load.q.g, InputStream> nVar) {
        this.f4798a = nVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<InputStream> a(@NonNull Uri uri, int i2, int i3, @NonNull j jVar) {
        return this.f4798a.a(new com.bumptech.glide.load.q.g(uri.toString()), i2, i3, jVar);
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return f4797b.contains(uri.getScheme());
    }
}
