package com.bumptech.glide.load.q.y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.r;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader.java */
/* loaded from: classes.dex */
public class d implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4799a;

    /* compiled from: MediaStoreImageThumbLoader.java */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4800a;

        public a(Context context) {
            this.f4800a = context;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new d(this.f4800a);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public d(Context context) {
        this.f4799a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<InputStream> a(@NonNull Uri uri, int i2, int i3, @NonNull j jVar) {
        if (com.bumptech.glide.load.o.p.b.a(i2, i3)) {
            return new n.a<>(new com.bumptech.glide.s.e(uri), com.bumptech.glide.load.o.p.c.a(this.f4799a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return com.bumptech.glide.load.o.p.b.a(uri);
    }
}
