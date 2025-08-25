package com.bumptech.glide.load.q;

import android.net.Uri;
import androidx.annotation.NonNull;
import anet.channel.util.HttpConstant;
import com.bumptech.glide.load.q.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class x<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f4790b = Collections.unmodifiableSet(new HashSet(Arrays.asList(HttpConstant.HTTP, HttpConstant.HTTPS)));

    /* renamed from: a, reason: collision with root package name */
    private final n<g, Data> f4791a;

    /* compiled from: UrlUriLoader.java */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new x(rVar.a(g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public x(n<g, Data> nVar) {
        this.f4791a = nVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return this.f4791a.a(new g(uri.toString()), i2, i3, jVar);
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return f4790b.contains(uri.getScheme());
    }
}
