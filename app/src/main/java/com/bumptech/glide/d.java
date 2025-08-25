package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.b;
import com.bumptech.glide.r.l.r;
import java.util.List;
import java.util.Map;

/* compiled from: GlideContext.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    static final l<?, ?> f4176k = new a();

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f4177a;

    /* renamed from: b, reason: collision with root package name */
    private final i f4178b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.r.l.k f4179c;

    /* renamed from: d, reason: collision with root package name */
    private final b.a f4180d;

    /* renamed from: e, reason: collision with root package name */
    private final List<com.bumptech.glide.r.g<Object>> f4181e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, l<?, ?>> f4182f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.p.k f4183g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f4184h;

    /* renamed from: i, reason: collision with root package name */
    private final int f4185i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private com.bumptech.glide.r.h f4186j;

    public d(@NonNull Context context, @NonNull com.bumptech.glide.load.p.a0.b bVar, @NonNull i iVar, @NonNull com.bumptech.glide.r.l.k kVar, @NonNull b.a aVar, @NonNull Map<Class<?>, l<?, ?>> map, @NonNull List<com.bumptech.glide.r.g<Object>> list, @NonNull com.bumptech.glide.load.p.k kVar2, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f4177a = bVar;
        this.f4178b = iVar;
        this.f4179c = kVar;
        this.f4180d = aVar;
        this.f4181e = list;
        this.f4182f = map;
        this.f4183g = kVar2;
        this.f4184h = z;
        this.f4185i = i2;
    }

    @NonNull
    public <T> l<?, T> a(@NonNull Class<T> cls) {
        l<?, T> lVar = (l) this.f4182f.get(cls);
        if (lVar == null) {
            for (Map.Entry<Class<?>, l<?, ?>> entry : this.f4182f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    lVar = (l) entry.getValue();
                }
            }
        }
        return lVar == null ? (l<?, T>) f4176k : lVar;
    }

    public List<com.bumptech.glide.r.g<Object>> b() {
        return this.f4181e;
    }

    public synchronized com.bumptech.glide.r.h c() {
        if (this.f4186j == null) {
            this.f4186j = this.f4180d.build().M();
        }
        return this.f4186j;
    }

    @NonNull
    public com.bumptech.glide.load.p.k d() {
        return this.f4183g;
    }

    public int e() {
        return this.f4185i;
    }

    @NonNull
    public i f() {
        return this.f4178b;
    }

    public boolean g() {
        return this.f4184h;
    }

    @NonNull
    public <X> r<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f4179c.a(imageView, cls);
    }

    @NonNull
    public com.bumptech.glide.load.p.a0.b a() {
        return this.f4177a;
    }
}
