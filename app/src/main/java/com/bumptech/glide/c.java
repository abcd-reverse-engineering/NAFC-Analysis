package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.os.BuildCompat;
import com.bumptech.glide.b;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.l;
import com.bumptech.glide.manager.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private com.bumptech.glide.load.p.k f4161b;

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.p.a0.e f4162c;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.p.a0.b f4163d;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.p.b0.j f4164e;

    /* renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.load.p.c0.a f4165f;

    /* renamed from: g, reason: collision with root package name */
    private com.bumptech.glide.load.p.c0.a f4166g;

    /* renamed from: h, reason: collision with root package name */
    private a.InterfaceC0059a f4167h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.p.b0.l f4168i;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.manager.d f4169j;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private k.b f4172m;
    private com.bumptech.glide.load.p.c0.a n;
    private boolean o;

    @Nullable
    private List<com.bumptech.glide.r.g<Object>> p;
    private boolean q;
    private boolean r;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, l<?, ?>> f4160a = new ArrayMap();

    /* renamed from: k, reason: collision with root package name */
    private int f4170k = 4;

    /* renamed from: l, reason: collision with root package name */
    private b.a f4171l = new a();

    /* compiled from: GlideBuilder.java */
    class a implements b.a {
        a() {
        }

        @Override // com.bumptech.glide.b.a
        @NonNull
        public com.bumptech.glide.r.h build() {
            return new com.bumptech.glide.r.h();
        }
    }

    /* compiled from: GlideBuilder.java */
    class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.r.h f4174a;

        b(com.bumptech.glide.r.h hVar) {
            this.f4174a = hVar;
        }

        @Override // com.bumptech.glide.b.a
        @NonNull
        public com.bumptech.glide.r.h build() {
            com.bumptech.glide.r.h hVar = this.f4174a;
            return hVar != null ? hVar : new com.bumptech.glide.r.h();
        }
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.a0.e eVar) {
        this.f4162c = eVar;
        return this;
    }

    @NonNull
    public c b(@Nullable com.bumptech.glide.load.p.c0.a aVar) {
        this.f4166g = aVar;
        return this;
    }

    @Deprecated
    public c c(@Nullable com.bumptech.glide.load.p.c0.a aVar) {
        return d(aVar);
    }

    @NonNull
    public c d(@Nullable com.bumptech.glide.load.p.c0.a aVar) {
        this.f4165f = aVar;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.a0.b bVar) {
        this.f4163d = bVar;
        return this;
    }

    @NonNull
    public c b(boolean z) {
        this.o = z;
        return this;
    }

    public c c(boolean z) {
        this.q = z;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.b0.j jVar) {
        this.f4164e = jVar;
        return this;
    }

    @NonNull
    public c a(@Nullable a.InterfaceC0059a interfaceC0059a) {
        this.f4167h = interfaceC0059a;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.c0.a aVar) {
        this.n = aVar;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.r.h hVar) {
        return a(new b(hVar));
    }

    @NonNull
    public c a(@NonNull b.a aVar) {
        this.f4171l = (b.a) com.bumptech.glide.util.j.a(aVar);
        return this;
    }

    @NonNull
    public <T> c a(@NonNull Class<T> cls, @Nullable l<?, T> lVar) {
        this.f4160a.put(cls, lVar);
        return this;
    }

    @NonNull
    public c a(@NonNull l.a aVar) {
        return a(aVar.a());
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.b0.l lVar) {
        this.f4168i = lVar;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.manager.d dVar) {
        this.f4169j = dVar;
        return this;
    }

    @NonNull
    public c a(int i2) {
        if (i2 >= 2 && i2 <= 6) {
            this.f4170k = i2;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    @NonNull
    public c a(@NonNull com.bumptech.glide.r.g<Object> gVar) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(gVar);
        return this;
    }

    public c a(boolean z) {
        if (!BuildCompat.isAtLeastQ()) {
            return this;
        }
        this.r = z;
        return this;
    }

    void a(@Nullable k.b bVar) {
        this.f4172m = bVar;
    }

    c a(com.bumptech.glide.load.p.k kVar) {
        this.f4161b = kVar;
        return this;
    }

    @NonNull
    com.bumptech.glide.b a(@NonNull Context context) {
        if (this.f4165f == null) {
            this.f4165f = com.bumptech.glide.load.p.c0.a.g();
        }
        if (this.f4166g == null) {
            this.f4166g = com.bumptech.glide.load.p.c0.a.e();
        }
        if (this.n == null) {
            this.n = com.bumptech.glide.load.p.c0.a.c();
        }
        if (this.f4168i == null) {
            this.f4168i = new l.a(context).a();
        }
        if (this.f4169j == null) {
            this.f4169j = new com.bumptech.glide.manager.f();
        }
        if (this.f4162c == null) {
            int iB = this.f4168i.b();
            if (iB > 0) {
                this.f4162c = new com.bumptech.glide.load.p.a0.k(iB);
            } else {
                this.f4162c = new com.bumptech.glide.load.p.a0.f();
            }
        }
        if (this.f4163d == null) {
            this.f4163d = new com.bumptech.glide.load.p.a0.j(this.f4168i.a());
        }
        if (this.f4164e == null) {
            this.f4164e = new com.bumptech.glide.load.p.b0.i(this.f4168i.c());
        }
        if (this.f4167h == null) {
            this.f4167h = new com.bumptech.glide.load.p.b0.h(context);
        }
        if (this.f4161b == null) {
            this.f4161b = new com.bumptech.glide.load.p.k(this.f4164e, this.f4167h, this.f4166g, this.f4165f, com.bumptech.glide.load.p.c0.a.h(), this.n, this.o);
        }
        List<com.bumptech.glide.r.g<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        return new com.bumptech.glide.b(context, this.f4161b, this.f4164e, this.f4162c, this.f4163d, new com.bumptech.glide.manager.k(this.f4172m), this.f4169j, this.f4170k, this.f4171l, this.f4160a, this.p, this.q, this.r);
    }
}
