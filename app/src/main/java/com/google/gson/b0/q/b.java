package com.google.gson.b0.q;

import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class b implements z {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.b0.c f5555a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    private static final class a<E> extends y<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        private final y<E> f5556a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.gson.b0.k<? extends Collection<E>> f5557b;

        public a(com.google.gson.e eVar, Type type, y<E> yVar, com.google.gson.b0.k<? extends Collection<E>> kVar) {
            this.f5556a = new n(eVar, yVar, type);
            this.f5557b = kVar;
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                dVar.j();
                return;
            }
            dVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f5556a.write(dVar, it.next());
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        /* renamed from: read */
        public Collection<E> read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            Collection<E> collectionA = this.f5557b.a();
            aVar.c();
            while (aVar.j()) {
                collectionA.add(this.f5556a.read2(aVar));
            }
            aVar.f();
            return collectionA;
        }
    }

    public b(com.google.gson.b0.c cVar) {
        this.f5555a = cVar;
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeA = com.google.gson.b0.b.a(type, (Class<?>) rawType);
        return new a(eVar, typeA, eVar.a((com.google.gson.d0.a) com.google.gson.d0.a.get(typeA)), this.f5555a.a(aVar));
    }
}
