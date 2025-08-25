package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.ca;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: TUnion.java */
/* loaded from: classes2.dex */
public abstract class ca<T extends ca<?, ?>, F extends bx> implements bq<T, F> {

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends cx>, cy> f10206c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    protected Object f10207a;

    /* renamed from: b, reason: collision with root package name */
    protected F f10208b;

    /* compiled from: TUnion.java */
    private static class a extends cz<ca> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, ca caVar) throws bw {
            caVar.f10208b = null;
            caVar.f10207a = null;
            cpVar.j();
            ck ckVarL = cpVar.l();
            caVar.f10207a = caVar.a(cpVar, ckVarL);
            if (caVar.f10207a != null) {
                caVar.f10208b = (F) caVar.a(ckVarL.f10265c);
            }
            cpVar.m();
            cpVar.l();
            cpVar.k();
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, ca caVar) throws bw {
            if (caVar.a() == null || caVar.b() == null) {
                throw new cq("Cannot write a TUnion with no set value!");
            }
            cpVar.a(caVar.d());
            cpVar.a(caVar.c(caVar.f10208b));
            caVar.a(cpVar);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* compiled from: TUnion.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: TUnion.java */
    private static class c extends da<ca> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, ca caVar) throws bw {
            caVar.f10208b = null;
            caVar.f10207a = null;
            short sV = cpVar.v();
            caVar.f10207a = caVar.a(cpVar, sV);
            if (caVar.f10207a != null) {
                caVar.f10208b = (F) caVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, ca caVar) throws bw {
            if (caVar.a() == null || caVar.b() == null) {
                throw new cq("Cannot write a TUnion with no set value!");
            }
            cpVar.a(caVar.f10208b.a());
            caVar.b(cpVar);
        }
    }

    /* compiled from: TUnion.java */
    private static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f10206c.put(cz.class, new b());
        f10206c.put(da.class, new d());
    }

    protected ca() {
        this.f10208b = null;
        this.f10207a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof bq ? ((bq) obj).deepCopy() : obj instanceof ByteBuffer ? br.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s);

    protected abstract Object a(cp cpVar, ck ckVar) throws bw;

    protected abstract Object a(cp cpVar, short s) throws bw;

    protected abstract void a(cp cpVar) throws bw;

    public Object b() {
        return this.f10207a;
    }

    protected abstract void b(F f2, Object obj) throws ClassCastException;

    protected abstract void b(cp cpVar) throws bw;

    protected abstract ck c(F f2);

    public boolean c() {
        return this.f10208b != null;
    }

    @Override // com.umeng.analytics.pro.bq
    public final void clear() {
        this.f10208b = null;
        this.f10207a = null;
    }

    protected abstract cu d();

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f10206c.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(ca.class.getSimpleName());
        sb.append(c.c.a.b.a.a.f3100g);
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).f10263a);
            sb.append(Constants.COLON_SEPARATOR);
            if (objB instanceof ByteBuffer) {
                br.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f10206c.get(cpVar.D()).b().a(cpVar, this);
    }

    public boolean b(F f2) {
        return this.f10208b == f2;
    }

    public boolean b(int i2) {
        return b((ca<T, F>) a((short) i2));
    }

    protected ca(F f2, Object obj) throws ClassCastException {
        a((ca<T, F>) f2, obj);
    }

    protected ca(ca<T, F> caVar) {
        if (caVar.getClass().equals(ca.class)) {
            this.f10208b = caVar.f10208b;
            this.f10207a = a(caVar.f10207a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f10208b;
    }

    public Object a(F f2) {
        if (f2 == this.f10208b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.f10208b);
    }

    public Object a(int i2) {
        return a((ca<T, F>) a((short) i2));
    }

    public void a(F f2, Object obj) throws ClassCastException {
        b(f2, obj);
        this.f10208b = f2;
        this.f10207a = obj;
    }

    public void a(int i2, Object obj) throws ClassCastException {
        a((ca<T, F>) a((short) i2), obj);
    }
}
