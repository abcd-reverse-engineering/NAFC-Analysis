package com.bumptech.glide.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?>> f5209a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry.java */
    private static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f5210a;

        /* renamed from: b, reason: collision with root package name */
        final m<T> f5211b;

        a(@NonNull Class<T> cls, @NonNull m<T> mVar) {
            this.f5210a = cls;
            this.f5211b = mVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f5210a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull m<Z> mVar) {
        this.f5209a.add(new a<>(cls, mVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull m<Z> mVar) {
        this.f5209a.add(0, new a<>(cls, mVar));
    }

    @Nullable
    public synchronized <Z> m<Z> a(@NonNull Class<Z> cls) {
        int size = this.f5209a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.f5209a.get(i2);
            if (aVar.a(cls)) {
                return (m<Z>) aVar.f5211b;
            }
        }
        return null;
    }
}
