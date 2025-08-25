package com.bumptech.glide.load.q.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.q.m;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.r;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader.java */
/* loaded from: classes.dex */
public class b implements n<com.bumptech.glide.load.q.g, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    public static final i<Integer> f4794b = i.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final m<com.bumptech.glide.load.q.g, com.bumptech.glide.load.q.g> f4795a;

    /* compiled from: HttpGlideUrlLoader.java */
    public static class a implements o<com.bumptech.glide.load.q.g, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final m<com.bumptech.glide.load.q.g, com.bumptech.glide.load.q.g> f4796a = new m<>(500);

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<com.bumptech.glide.load.q.g, InputStream> a(r rVar) {
            return new b(this.f4796a);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public b() {
        this(null);
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull com.bumptech.glide.load.q.g gVar) {
        return true;
    }

    public b(@Nullable m<com.bumptech.glide.load.q.g, com.bumptech.glide.load.q.g> mVar) {
        this.f4795a = mVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<InputStream> a(@NonNull com.bumptech.glide.load.q.g gVar, int i2, int i3, @NonNull j jVar) {
        m<com.bumptech.glide.load.q.g, com.bumptech.glide.load.q.g> mVar = this.f4795a;
        if (mVar != null) {
            com.bumptech.glide.load.q.g gVarA = mVar.a(gVar, 0, 0);
            if (gVarA == null) {
                this.f4795a.a(gVar, 0, 0, gVar);
            } else {
                gVar = gVarA;
            }
        }
        return new n.a<>(gVar, new com.bumptech.glide.load.o.j(gVar, ((Integer) jVar.a(f4794b)).intValue()));
    }
}
