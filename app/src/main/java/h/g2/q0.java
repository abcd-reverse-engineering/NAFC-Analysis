package h.g2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Grouping.kt */
/* loaded from: classes2.dex */
class q0 extends p0 {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R> Map<K, R> a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d h.q2.s.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> rVar) {
        h.q2.t.i0.f(n0Var, "$this$aggregate");
        h.q2.t.i0.f(rVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itA = n0Var.a();
        while (itA.hasNext()) {
            ?? next = itA.next();
            Object objA = n0Var.a(next);
            a.a.a aVar = (Object) linkedHashMap.get(objA);
            linkedHashMap.put(objA, rVar.invoke(objA, aVar, next, Boolean.valueOf(aVar == null && !linkedHashMap.containsKey(objA))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R, M extends Map<? super K, R>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2, @i.c.a.d h.q2.s.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> rVar) {
        h.q2.t.i0.f(n0Var, "$this$aggregateTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(rVar, "operation");
        Iterator<T> itA = n0Var.a();
        while (itA.hasNext()) {
            ?? next = itA.next();
            Object objA = n0Var.a(next);
            a.a.a aVar = (Object) m2.get(objA);
            m2.put(objA, rVar.invoke(objA, aVar, next, Boolean.valueOf(aVar == null && !m2.containsKey(objA))));
        }
        return m2;
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, M extends Map<? super K, Integer>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2) {
        h.q2.t.i0.f(n0Var, "$this$eachCountTo");
        h.q2.t.i0.f(m2, "destination");
        Iterator<T> itA = n0Var.a();
        while (itA.hasNext()) {
            K kA = n0Var.a(itA.next());
            Object obj = m2.get(kA);
            if (obj == null && !m2.containsKey(kA)) {
                obj = 0;
            }
            m2.put(kA, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return m2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R> Map<K, R> a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d h.q2.s.p<? super K, ? super T, ? extends R> pVar, @i.c.a.d h.q2.s.q<? super K, ? super R, ? super T, ? extends R> qVar) {
        h.q2.t.i0.f(n0Var, "$this$fold");
        h.q2.t.i0.f(pVar, "initialValueSelector");
        h.q2.t.i0.f(qVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itA = n0Var.a();
        while (itA.hasNext()) {
            ?? next = itA.next();
            Object objA = n0Var.a(next);
            R rInvoke = (Object) linkedHashMap.get(objA);
            if (rInvoke == null && !linkedHashMap.containsKey(objA)) {
                rInvoke = pVar.invoke(objA, next);
            }
            linkedHashMap.put(objA, qVar.invoke(objA, rInvoke, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R, M extends Map<? super K, R>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2, @i.c.a.d h.q2.s.p<? super K, ? super T, ? extends R> pVar, @i.c.a.d h.q2.s.q<? super K, ? super R, ? super T, ? extends R> qVar) {
        h.q2.t.i0.f(n0Var, "$this$foldTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(pVar, "initialValueSelector");
        h.q2.t.i0.f(qVar, "operation");
        Iterator<T> itA = n0Var.a();
        while (itA.hasNext()) {
            ?? next = itA.next();
            Object objA = n0Var.a(next);
            R rInvoke = (Object) m2.get(objA);
            if (rInvoke == null && !m2.containsKey(objA)) {
                rInvoke = pVar.invoke(objA, next);
            }
            m2.put(objA, qVar.invoke(objA, rInvoke, next));
        }
        return m2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R> Map<K, R> a(@i.c.a.d n0<T, ? extends K> n0Var, R r, @i.c.a.d h.q2.s.p<? super R, ? super T, ? extends R> pVar) {
        h.q2.t.i0.f(n0Var, "$this$fold");
        h.q2.t.i0.f(pVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itA = n0Var.a();
        while (itA.hasNext()) {
            ?? next = itA.next();
            K kA = n0Var.a(next);
            a.a.a aVar = (Object) linkedHashMap.get(kA);
            if (aVar == null && !linkedHashMap.containsKey(kA)) {
                aVar = (Object) r;
            }
            linkedHashMap.put(kA, pVar.invoke(aVar, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R, M extends Map<? super K, R>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2, R r, @i.c.a.d h.q2.s.p<? super R, ? super T, ? extends R> pVar) {
        h.q2.t.i0.f(n0Var, "$this$foldTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(pVar, "operation");
        Iterator<T> itA = n0Var.a();
        while (itA.hasNext()) {
            ?? next = itA.next();
            K kA = n0Var.a(next);
            a.a.a aVar = (Object) m2.get(kA);
            if (aVar == null && !m2.containsKey(kA)) {
                aVar = (Object) r;
            }
            m2.put(kA, pVar.invoke(aVar, next));
        }
        return m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <S, T extends S, K> Map<K, S> a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d h.q2.s.q<? super K, ? super S, ? super T, ? extends S> qVar) {
        h.q2.t.i0.f(n0Var, "$this$reduce");
        h.q2.t.i0.f(qVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itA = n0Var.a();
        while (itA.hasNext()) {
            S sInvoke = (Object) itA.next();
            Object objA = n0Var.a(sInvoke);
            a.a.a aVar = (Object) linkedHashMap.get(objA);
            if (!(aVar == null && !linkedHashMap.containsKey(objA))) {
                sInvoke = qVar.invoke(objA, aVar, sInvoke);
            }
            linkedHashMap.put(objA, sInvoke);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <S, T extends S, K, M extends Map<? super K, S>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2, @i.c.a.d h.q2.s.q<? super K, ? super S, ? super T, ? extends S> qVar) {
        h.q2.t.i0.f(n0Var, "$this$reduceTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(qVar, "operation");
        Iterator itA = n0Var.a();
        while (itA.hasNext()) {
            S sInvoke = (Object) itA.next();
            Object objA = n0Var.a(sInvoke);
            a.a.a aVar = (Object) m2.get(objA);
            if (!(aVar == null && !m2.containsKey(objA))) {
                sInvoke = qVar.invoke(objA, aVar, sInvoke);
            }
            m2.put(objA, sInvoke);
        }
        return m2;
    }
}
