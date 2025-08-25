package com.google.gson;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class e {
    static final boolean A = false;
    static final boolean B = false;
    static final boolean C = true;
    static final boolean D = false;
    static final boolean E = false;
    static final boolean F = false;
    static final boolean G = true;
    static final String H = null;
    static final com.google.gson.d I = com.google.gson.c.IDENTITY;
    static final x J = w.DOUBLE;
    static final x K = w.LAZILY_PARSED_NUMBER;
    private static final String L = ")]}'\n";
    static final boolean z = false;

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gson.d0.a<?>, y<?>>> f5683a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<com.google.gson.d0.a<?>, y<?>> f5684b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.gson.b0.c f5685c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.gson.b0.q.e f5686d;

    /* renamed from: e, reason: collision with root package name */
    final List<z> f5687e;

    /* renamed from: f, reason: collision with root package name */
    final com.google.gson.b0.d f5688f;

    /* renamed from: g, reason: collision with root package name */
    final com.google.gson.d f5689g;

    /* renamed from: h, reason: collision with root package name */
    final Map<Type, g<?>> f5690h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f5691i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f5692j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f5693k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f5694l;

    /* renamed from: m, reason: collision with root package name */
    final boolean f5695m;
    final boolean n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final u t;
    final List<z> u;
    final List<z> v;
    final x w;
    final x x;
    final List<v> y;

    /* compiled from: Gson.java */
    class a extends y<Number> {
        a() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
                return;
            }
            double dDoubleValue = number.doubleValue();
            e.a(dDoubleValue);
            dVar.a(dDoubleValue);
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: merged with bridge method [inline-methods] */
        public Number read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Double.valueOf(aVar.n());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: Gson.java */
    class b extends y<Number> {
        b() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
                return;
            }
            float fFloatValue = number.floatValue();
            e.a(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            dVar.a(number);
        }

        @Override // com.google.gson.y
        /* renamed from: read */
        public Number read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Float.valueOf((float) aVar.n());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: Gson.java */
    class c extends y<Number> {
        c() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.d(number.toString());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Number read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Long.valueOf(aVar.p());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: Gson.java */
    class d extends y<AtomicLong> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f5698a;

        d(y yVar) {
            this.f5698a = yVar;
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, AtomicLong atomicLong) throws IOException {
            this.f5698a.write(dVar, Long.valueOf(atomicLong.get()));
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public AtomicLong read2(com.google.gson.e0.a aVar) throws IOException {
            return new AtomicLong(((Number) this.f5698a.read2(aVar)).longValue());
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$e, reason: collision with other inner class name */
    class C0091e extends y<AtomicLongArray> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f5699a;

        C0091e(y yVar) {
            this.f5699a = yVar;
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, AtomicLongArray atomicLongArray) throws IOException {
            dVar.c();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.f5699a.write(dVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public AtomicLongArray read2(com.google.gson.e0.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.c();
            while (aVar.j()) {
                arrayList.add(Long.valueOf(((Number) this.f5699a.read2(aVar)).longValue()));
            }
            aVar.f();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }
    }

    public e() {
        this(com.google.gson.b0.d.f5505h, I, Collections.emptyMap(), false, false, false, true, false, false, false, true, u.DEFAULT, H, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), J, K, Collections.emptyList());
    }

    @Deprecated
    public com.google.gson.b0.d a() {
        return this.f5688f;
    }

    public com.google.gson.d b() {
        return this.f5689g;
    }

    public boolean c() {
        return this.f5694l;
    }

    public com.google.gson.f d() {
        return new com.google.gson.f(this);
    }

    public boolean e() {
        return this.f5691i;
    }

    public String toString() {
        return "{serializeNulls:" + this.f5691i + ",factories:" + this.f5687e + ",instanceCreators:" + this.f5685c + "}";
    }

    private y<Number> a(boolean z2) {
        return z2 ? com.google.gson.b0.q.o.v : new a();
    }

    private y<Number> b(boolean z2) {
        return z2 ? com.google.gson.b0.q.o.u : new b();
    }

    /* compiled from: Gson.java */
    static class f<T> extends com.google.gson.b0.q.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private y<T> f5700a = null;

        f() {
        }

        private y<T> b() {
            y<T> yVar = this.f5700a;
            if (yVar != null) {
                return yVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public void a(y<T> yVar) {
            if (this.f5700a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f5700a = yVar;
        }

        @Override // com.google.gson.y
        /* renamed from: read */
        public T read2(com.google.gson.e0.a aVar) throws IOException {
            return b().read2(aVar);
        }

        @Override // com.google.gson.y
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            b().write(dVar, t);
        }

        @Override // com.google.gson.b0.q.l
        public y<T> a() {
            return b();
        }
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static y<AtomicLongArray> b(y<Number> yVar) {
        return new C0091e(yVar).nullSafe();
    }

    private static y<Number> a(u uVar) {
        if (uVar == u.DEFAULT) {
            return com.google.gson.b0.q.o.t;
        }
        return new c();
    }

    public k b(Object obj) {
        if (obj == null) {
            return m.f5749a;
        }
        return b(obj, obj.getClass());
    }

    e(com.google.gson.b0.d dVar, com.google.gson.d dVar2, Map<Type, g<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, u uVar, String str, int i2, int i3, List<z> list, List<z> list2, List<z> list3, x xVar, x xVar2, List<v> list4) {
        this.f5683a = new ThreadLocal<>();
        this.f5684b = new ConcurrentHashMap();
        this.f5688f = dVar;
        this.f5689g = dVar2;
        this.f5690h = map;
        this.f5685c = new com.google.gson.b0.c(map, z9, list4);
        this.f5691i = z2;
        this.f5692j = z3;
        this.f5693k = z4;
        this.f5694l = z5;
        this.f5695m = z6;
        this.n = z7;
        this.o = z8;
        this.p = z9;
        this.t = uVar;
        this.q = str;
        this.r = i2;
        this.s = i3;
        this.u = list;
        this.v = list2;
        this.w = xVar;
        this.x = xVar2;
        this.y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.b0.q.o.W);
        arrayList.add(com.google.gson.b0.q.j.a(xVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(com.google.gson.b0.q.o.C);
        arrayList.add(com.google.gson.b0.q.o.f5636m);
        arrayList.add(com.google.gson.b0.q.o.f5630g);
        arrayList.add(com.google.gson.b0.q.o.f5632i);
        arrayList.add(com.google.gson.b0.q.o.f5634k);
        y<Number> yVarA = a(uVar);
        arrayList.add(com.google.gson.b0.q.o.a(Long.TYPE, Long.class, yVarA));
        arrayList.add(com.google.gson.b0.q.o.a(Double.TYPE, Double.class, a(z8)));
        arrayList.add(com.google.gson.b0.q.o.a(Float.TYPE, Float.class, b(z8)));
        arrayList.add(com.google.gson.b0.q.i.a(xVar2));
        arrayList.add(com.google.gson.b0.q.o.o);
        arrayList.add(com.google.gson.b0.q.o.q);
        arrayList.add(com.google.gson.b0.q.o.a(AtomicLong.class, a(yVarA)));
        arrayList.add(com.google.gson.b0.q.o.a(AtomicLongArray.class, b(yVarA)));
        arrayList.add(com.google.gson.b0.q.o.s);
        arrayList.add(com.google.gson.b0.q.o.x);
        arrayList.add(com.google.gson.b0.q.o.E);
        arrayList.add(com.google.gson.b0.q.o.G);
        arrayList.add(com.google.gson.b0.q.o.a(BigDecimal.class, com.google.gson.b0.q.o.z));
        arrayList.add(com.google.gson.b0.q.o.a(BigInteger.class, com.google.gson.b0.q.o.A));
        arrayList.add(com.google.gson.b0.q.o.a(com.google.gson.b0.h.class, com.google.gson.b0.q.o.B));
        arrayList.add(com.google.gson.b0.q.o.I);
        arrayList.add(com.google.gson.b0.q.o.K);
        arrayList.add(com.google.gson.b0.q.o.O);
        arrayList.add(com.google.gson.b0.q.o.Q);
        arrayList.add(com.google.gson.b0.q.o.U);
        arrayList.add(com.google.gson.b0.q.o.M);
        arrayList.add(com.google.gson.b0.q.o.f5627d);
        arrayList.add(com.google.gson.b0.q.c.f5558b);
        arrayList.add(com.google.gson.b0.q.o.S);
        if (com.google.gson.b0.t.d.f5676a) {
            arrayList.add(com.google.gson.b0.t.d.f5680e);
            arrayList.add(com.google.gson.b0.t.d.f5679d);
            arrayList.add(com.google.gson.b0.t.d.f5681f);
        }
        arrayList.add(com.google.gson.b0.q.a.f5552c);
        arrayList.add(com.google.gson.b0.q.o.f5625b);
        arrayList.add(new com.google.gson.b0.q.b(this.f5685c));
        arrayList.add(new com.google.gson.b0.q.h(this.f5685c, z3));
        this.f5686d = new com.google.gson.b0.q.e(this.f5685c);
        arrayList.add(this.f5686d);
        arrayList.add(com.google.gson.b0.q.o.X);
        arrayList.add(new com.google.gson.b0.q.k(this.f5685c, dVar2, dVar, this.f5686d, list4));
        this.f5687e = Collections.unmodifiableList(arrayList);
    }

    public k b(Object obj, Type type) throws l {
        com.google.gson.b0.q.g gVar = new com.google.gson.b0.q.g();
        a(obj, type, gVar);
        return gVar.k();
    }

    private static y<AtomicLong> a(y<Number> yVar) {
        return new d(yVar).nullSafe();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r3.a(r2);
        r0.put(r7, r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> com.google.gson.y<T> a(com.google.gson.d0.a<T> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap<com.google.gson.d0.a<?>, com.google.gson.y<?>> r0 = r6.f5684b
            java.lang.Object r0 = r0.get(r7)
            com.google.gson.y r0 = (com.google.gson.y) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal<java.util.Map<com.google.gson.d0.a<?>, com.google.gson.y<?>>> r0 = r6.f5683a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            r1 = 0
            if (r0 != 0) goto L27
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal<java.util.Map<com.google.gson.d0.a<?>, com.google.gson.y<?>>> r1 = r6.f5683a
            r1.set(r0)
            r1 = 1
            goto L30
        L27:
            java.lang.Object r2 = r0.get(r7)
            com.google.gson.y r2 = (com.google.gson.y) r2
            if (r2 == 0) goto L30
            return r2
        L30:
            r2 = 0
            com.google.gson.e$f r3 = new com.google.gson.e$f     // Catch: java.lang.Throwable -> L7f
            r3.<init>()     // Catch: java.lang.Throwable -> L7f
            r0.put(r7, r3)     // Catch: java.lang.Throwable -> L7f
            java.util.List<com.google.gson.z> r4 = r6.f5687e     // Catch: java.lang.Throwable -> L7f
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L7f
        L3f:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L7f
            if (r5 == 0) goto L57
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Throwable -> L7f
            com.google.gson.z r2 = (com.google.gson.z) r2     // Catch: java.lang.Throwable -> L7f
            com.google.gson.y r2 = r2.create(r6, r7)     // Catch: java.lang.Throwable -> L7f
            if (r2 == 0) goto L3f
            r3.a(r2)     // Catch: java.lang.Throwable -> L7f
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L7f
        L57:
            if (r1 == 0) goto L5e
            java.lang.ThreadLocal<java.util.Map<com.google.gson.d0.a<?>, com.google.gson.y<?>>> r3 = r6.f5683a
            r3.remove()
        L5e:
            if (r2 == 0) goto L68
            if (r1 == 0) goto L67
            java.util.concurrent.ConcurrentMap<com.google.gson.d0.a<?>, com.google.gson.y<?>> r7 = r6.f5684b
            r7.putAll(r0)
        L67:
            return r2
        L68:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "GSON (2.10.1) cannot handle "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L7f:
            r7 = move-exception
            if (r1 == 0) goto L87
            java.lang.ThreadLocal<java.util.Map<com.google.gson.d0.a<?>, com.google.gson.y<?>>> r0 = r6.f5683a
            r0.remove()
        L87:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.e.a(com.google.gson.d0.a):com.google.gson.y");
    }

    public <T> y<T> a(z zVar, com.google.gson.d0.a<T> aVar) {
        if (!this.f5687e.contains(zVar)) {
            zVar = this.f5686d;
        }
        boolean z2 = false;
        for (z zVar2 : this.f5687e) {
            if (z2) {
                y<T> yVarCreate = zVar2.create(this, aVar);
                if (yVarCreate != null) {
                    return yVarCreate;
                }
            } else if (zVar2 == zVar) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> y<T> a(Class<T> cls) {
        return a((com.google.gson.d0.a) com.google.gson.d0.a.get((Class) cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((k) m.f5749a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) throws l {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Appendable appendable) throws l {
        if (obj != null) {
            a(obj, obj.getClass(), appendable);
        } else {
            a((k) m.f5749a, appendable);
        }
    }

    public void a(Object obj, Type type, Appendable appendable) throws l {
        try {
            a(obj, type, a(com.google.gson.b0.o.a(appendable)));
        } catch (IOException e2) {
            throw new l(e2);
        }
    }

    public void a(Object obj, Type type, com.google.gson.e0.d dVar) throws l {
        y yVarA = a((com.google.gson.d0.a) com.google.gson.d0.a.get(type));
        boolean zI = dVar.i();
        dVar.b(true);
        boolean zH = dVar.h();
        dVar.a(this.f5694l);
        boolean zG = dVar.g();
        dVar.c(this.f5691i);
        try {
            try {
                yVarA.write(dVar, obj);
            } catch (IOException e2) {
                throw new l(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            dVar.b(zI);
            dVar.a(zH);
            dVar.c(zG);
        }
    }

    public String a(k kVar) throws l {
        StringWriter stringWriter = new StringWriter();
        a(kVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void a(k kVar, Appendable appendable) throws l {
        try {
            a(kVar, a(com.google.gson.b0.o.a(appendable)));
        } catch (IOException e2) {
            throw new l(e2);
        }
    }

    public com.google.gson.e0.d a(Writer writer) throws IOException {
        if (this.f5693k) {
            writer.write(L);
        }
        com.google.gson.e0.d dVar = new com.google.gson.e0.d(writer);
        if (this.f5695m) {
            dVar.c("  ");
        }
        dVar.a(this.f5694l);
        dVar.b(this.n);
        dVar.c(this.f5691i);
        return dVar;
    }

    public com.google.gson.e0.a a(Reader reader) {
        com.google.gson.e0.a aVar = new com.google.gson.e0.a(reader);
        aVar.a(this.n);
        return aVar;
    }

    public void a(k kVar, com.google.gson.e0.d dVar) throws l {
        boolean zI = dVar.i();
        dVar.b(true);
        boolean zH = dVar.h();
        dVar.a(this.f5694l);
        boolean zG = dVar.g();
        dVar.c(this.f5691i);
        try {
            try {
                com.google.gson.b0.o.a(kVar, dVar);
            } catch (IOException e2) {
                throw new l(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            dVar.b(zI);
            dVar.a(zH);
            dVar.c(zG);
        }
    }

    public <T> T a(String str, Class<T> cls) throws t {
        return (T) com.google.gson.b0.m.b((Class) cls).cast(a(str, com.google.gson.d0.a.get((Class) cls)));
    }

    public <T> T a(String str, Type type) throws t {
        return (T) a(str, com.google.gson.d0.a.get(type));
    }

    public <T> T a(String str, com.google.gson.d0.a<T> aVar) throws t {
        if (str == null) {
            return null;
        }
        return (T) a(new StringReader(str), aVar);
    }

    public <T> T a(Reader reader, Class<T> cls) throws t, l {
        return (T) com.google.gson.b0.m.b((Class) cls).cast(a(reader, com.google.gson.d0.a.get((Class) cls)));
    }

    public <T> T a(Reader reader, Type type) throws t, l {
        return (T) a(reader, com.google.gson.d0.a.get(type));
    }

    public <T> T a(Reader reader, com.google.gson.d0.a<T> aVar) throws t, l {
        com.google.gson.e0.a aVarA = a(reader);
        T t = (T) a(aVarA, aVar);
        a(t, aVarA);
        return t;
    }

    private static void a(Object obj, com.google.gson.e0.a aVar) {
        if (obj != null) {
            try {
                if (aVar.peek() == com.google.gson.e0.c.END_DOCUMENT) {
                } else {
                    throw new t("JSON document was not fully consumed.");
                }
            } catch (com.google.gson.e0.e e2) {
                throw new t(e2);
            } catch (IOException e3) {
                throw new l(e3);
            }
        }
    }

    public <T> T a(com.google.gson.e0.a aVar, Type type) throws t, l {
        return (T) a(aVar, com.google.gson.d0.a.get(type));
    }

    public <T> T a(com.google.gson.e0.a aVar, com.google.gson.d0.a<T> aVar2) throws t, l {
        boolean zK = aVar.k();
        boolean z2 = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.peek();
                    z2 = false;
                    T t = a((com.google.gson.d0.a) aVar2).read2(aVar);
                    aVar.a(zK);
                    return t;
                } catch (IOException e2) {
                    throw new t(e2);
                } catch (IllegalStateException e3) {
                    throw new t(e3);
                }
            } catch (EOFException e4) {
                if (z2) {
                    aVar.a(zK);
                    return null;
                }
                throw new t(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e5.getMessage(), e5);
            }
        } catch (Throwable th) {
            aVar.a(zK);
            throw th;
        }
    }

    public <T> T a(k kVar, Class<T> cls) throws t {
        return (T) com.google.gson.b0.m.b((Class) cls).cast(a(kVar, com.google.gson.d0.a.get((Class) cls)));
    }

    public <T> T a(k kVar, Type type) throws t {
        return (T) a(kVar, com.google.gson.d0.a.get(type));
    }

    public <T> T a(k kVar, com.google.gson.d0.a<T> aVar) throws t {
        if (kVar == null) {
            return null;
        }
        return (T) a(new com.google.gson.b0.q.f(kVar), aVar);
    }
}
