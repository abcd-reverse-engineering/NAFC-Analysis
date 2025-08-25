package com.google.gson.b0.q;

import com.google.gson.p;
import com.google.gson.t;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class h implements z {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.b0.c f5568a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f5569b;

    /* compiled from: MapTypeAdapterFactory.java */
    private final class a<K, V> extends y<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final y<K> f5570a;

        /* renamed from: b, reason: collision with root package name */
        private final y<V> f5571b;

        /* renamed from: c, reason: collision with root package name */
        private final com.google.gson.b0.k<? extends Map<K, V>> f5572c;

        public a(com.google.gson.e eVar, Type type, y<K> yVar, Type type2, y<V> yVar2, com.google.gson.b0.k<? extends Map<K, V>> kVar) {
            this.f5570a = new n(eVar, yVar, type);
            this.f5571b = new n(eVar, yVar2, type2);
            this.f5572c = kVar;
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Map<K, V> map) throws IOException {
            if (map == null) {
                dVar.j();
                return;
            }
            if (!h.this.f5569b) {
                dVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    dVar.b(String.valueOf(entry.getKey()));
                    this.f5571b.write(dVar, entry.getValue());
                }
                dVar.f();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.k jsonTree = this.f5570a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (!z) {
                dVar.d();
                int size = arrayList.size();
                while (i2 < size) {
                    dVar.b(a((com.google.gson.k) arrayList.get(i2)));
                    this.f5571b.write(dVar, arrayList2.get(i2));
                    i2++;
                }
                dVar.f();
                return;
            }
            dVar.c();
            int size2 = arrayList.size();
            while (i2 < size2) {
                dVar.c();
                com.google.gson.b0.o.a((com.google.gson.k) arrayList.get(i2), dVar);
                this.f5571b.write(dVar, arrayList2.get(i2));
                dVar.e();
                i2++;
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        /* renamed from: read */
        public Map<K, V> read2(com.google.gson.e0.a aVar) throws IOException {
            com.google.gson.e0.c cVarPeek = aVar.peek();
            if (cVarPeek == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            Map<K, V> mapA = this.f5572c.a();
            if (cVarPeek == com.google.gson.e0.c.BEGIN_ARRAY) {
                aVar.c();
                while (aVar.j()) {
                    aVar.c();
                    K k2 = this.f5570a.read2(aVar);
                    if (mapA.put(k2, this.f5571b.read2(aVar)) != null) {
                        throw new t("duplicate key: " + k2);
                    }
                    aVar.f();
                }
                aVar.f();
            } else {
                aVar.d();
                while (aVar.j()) {
                    com.google.gson.b0.g.f5520a.a(aVar);
                    K k3 = this.f5570a.read2(aVar);
                    if (mapA.put(k3, this.f5571b.read2(aVar)) != null) {
                        throw new t("duplicate key: " + k3);
                    }
                }
                aVar.g();
            }
            return mapA;
        }

        private String a(com.google.gson.k kVar) {
            if (kVar.isJsonPrimitive()) {
                p asJsonPrimitive = kVar.getAsJsonPrimitive();
                if (asJsonPrimitive.b()) {
                    return String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.a()) {
                    return Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.c()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new AssertionError();
            }
            if (kVar.isJsonNull()) {
                return c.c.a.b.a.a.f3101h;
            }
            throw new AssertionError();
        }
    }

    public h(com.google.gson.b0.c cVar, boolean z) {
        this.f5568a = cVar;
        this.f5569b = z;
    }

    private y<?> a(com.google.gson.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? o.f5629f : eVar.a((com.google.gson.d0.a) com.google.gson.d0.a.get(type));
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) throws NoSuchMethodException, SecurityException {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] typeArrB = com.google.gson.b0.b.b(type, rawType);
        return new a(eVar, typeArrB[0], a(eVar, typeArrB[0]), typeArrB[1], eVar.a((com.google.gson.d0.a) com.google.gson.d0.a.get(typeArrB[1])), this.f5568a.a(aVar));
    }
}
