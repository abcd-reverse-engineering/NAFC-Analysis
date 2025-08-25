package com.bumptech.glide.load.p.a0;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.a0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class h<K extends m, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f4342a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f4343b = new HashMap();

    /* compiled from: GroupedLinkedMap.java */
    private static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f4344a;

        /* renamed from: b, reason: collision with root package name */
        private List<V> f4345b;

        /* renamed from: c, reason: collision with root package name */
        a<K, V> f4346c;

        /* renamed from: d, reason: collision with root package name */
        a<K, V> f4347d;

        a() {
            this(null);
        }

        @Nullable
        public V a() {
            int iB = b();
            if (iB > 0) {
                return this.f4345b.remove(iB - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.f4345b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k2) {
            this.f4347d = this;
            this.f4346c = this;
            this.f4344a = k2;
        }

        public void a(V v) {
            if (this.f4345b == null) {
                this.f4345b = new ArrayList();
            }
            this.f4345b.add(v);
        }
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f4342a;
        aVar.f4347d = aVar2.f4347d;
        aVar.f4346c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f4347d;
        aVar2.f4346c = aVar.f4346c;
        aVar.f4346c.f4347d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f4346c.f4347d = aVar;
        aVar.f4347d.f4346c = aVar;
    }

    public void a(K k2, V v) {
        a<K, V> aVar = this.f4343b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            b(aVar);
            this.f4343b.put(k2, aVar);
        } else {
            k2.offer();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f4342a.f4346c; !aVar.equals(this.f4342a); aVar = aVar.f4346c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f4344a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    @Nullable
    public V a(K k2) {
        a<K, V> aVar = this.f4343b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            this.f4343b.put(k2, aVar);
        } else {
            k2.offer();
        }
        a(aVar);
        return aVar.a();
    }

    @Nullable
    public V a() {
        for (a aVar = this.f4342a.f4347d; !aVar.equals(this.f4342a); aVar = aVar.f4347d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            c(aVar);
            this.f4343b.remove(aVar.f4344a);
            ((m) aVar.f4344a).offer();
        }
        return null;
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f4342a;
        aVar.f4347d = aVar2;
        aVar.f4346c = aVar2.f4346c;
        d(aVar);
    }
}
