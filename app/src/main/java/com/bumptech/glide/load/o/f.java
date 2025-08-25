package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final e.a<?> f4266b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f4267a = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    class a implements e.a<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public e<Object> a(@NonNull Object obj) {
            return new b(obj);
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* compiled from: DataRewinderRegistry.java */
    private static final class b implements e<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f4268a;

        b(@NonNull Object obj) {
            this.f4268a = obj;
        }

        @Override // com.bumptech.glide.load.o.e
        @NonNull
        public Object a() {
            return this.f4268a;
        }

        @Override // com.bumptech.glide.load.o.e
        public void b() {
        }
    }

    public synchronized void a(@NonNull e.a<?> aVar) {
        this.f4267a.put(aVar.a(), aVar);
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t) {
        e.a<?> aVar;
        com.bumptech.glide.util.j.a(t);
        aVar = this.f4267a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f4267a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f4266b;
        }
        return (e<T>) aVar.a(t);
    }
}
