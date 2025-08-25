package com.google.gson.b0.q;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.gson.y<Class> f5624a = new k().nullSafe();

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.gson.z f5625b = a(Class.class, f5624a);

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.gson.y<BitSet> f5626c = new v().nullSafe();

    /* renamed from: d, reason: collision with root package name */
    public static final com.google.gson.z f5627d = a(BitSet.class, f5626c);

    /* renamed from: e, reason: collision with root package name */
    public static final com.google.gson.y<Boolean> f5628e = new c0();

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.gson.y<Boolean> f5629f = new d0();

    /* renamed from: g, reason: collision with root package name */
    public static final com.google.gson.z f5630g = a(Boolean.TYPE, Boolean.class, f5628e);

    /* renamed from: h, reason: collision with root package name */
    public static final com.google.gson.y<Number> f5631h = new e0();

    /* renamed from: i, reason: collision with root package name */
    public static final com.google.gson.z f5632i = a(Byte.TYPE, Byte.class, f5631h);

    /* renamed from: j, reason: collision with root package name */
    public static final com.google.gson.y<Number> f5633j = new f0();

    /* renamed from: k, reason: collision with root package name */
    public static final com.google.gson.z f5634k = a(Short.TYPE, Short.class, f5633j);

    /* renamed from: l, reason: collision with root package name */
    public static final com.google.gson.y<Number> f5635l = new g0();

    /* renamed from: m, reason: collision with root package name */
    public static final com.google.gson.z f5636m = a(Integer.TYPE, Integer.class, f5635l);
    public static final com.google.gson.y<AtomicInteger> n = new h0().nullSafe();
    public static final com.google.gson.z o = a(AtomicInteger.class, n);
    public static final com.google.gson.y<AtomicBoolean> p = new i0().nullSafe();
    public static final com.google.gson.z q = a(AtomicBoolean.class, p);
    public static final com.google.gson.y<AtomicIntegerArray> r = new a().nullSafe();
    public static final com.google.gson.z s = a(AtomicIntegerArray.class, r);
    public static final com.google.gson.y<Number> t = new b();
    public static final com.google.gson.y<Number> u = new c();
    public static final com.google.gson.y<Number> v = new d();
    public static final com.google.gson.y<Character> w = new e();
    public static final com.google.gson.z x = a(Character.TYPE, Character.class, w);
    public static final com.google.gson.y<String> y = new f();
    public static final com.google.gson.y<BigDecimal> z = new g();
    public static final com.google.gson.y<BigInteger> A = new h();
    public static final com.google.gson.y<com.google.gson.b0.h> B = new i();
    public static final com.google.gson.z C = a(String.class, y);
    public static final com.google.gson.y<StringBuilder> D = new j();
    public static final com.google.gson.z E = a(StringBuilder.class, D);
    public static final com.google.gson.y<StringBuffer> F = new l();
    public static final com.google.gson.z G = a(StringBuffer.class, F);
    public static final com.google.gson.y<URL> H = new m();
    public static final com.google.gson.z I = a(URL.class, H);
    public static final com.google.gson.y<URI> J = new n();
    public static final com.google.gson.z K = a(URI.class, J);
    public static final com.google.gson.y<InetAddress> L = new C0087o();
    public static final com.google.gson.z M = b(InetAddress.class, L);
    public static final com.google.gson.y<UUID> N = new p();
    public static final com.google.gson.z O = a(UUID.class, N);
    public static final com.google.gson.y<Currency> P = new q().nullSafe();
    public static final com.google.gson.z Q = a(Currency.class, P);
    public static final com.google.gson.y<Calendar> R = new r();
    public static final com.google.gson.z S = b(Calendar.class, GregorianCalendar.class, R);
    public static final com.google.gson.y<Locale> T = new s();
    public static final com.google.gson.z U = a(Locale.class, T);
    public static final com.google.gson.y<com.google.gson.k> V = new t();
    public static final com.google.gson.z W = b(com.google.gson.k.class, V);
    public static final com.google.gson.z X = new u();

    /* compiled from: TypeAdapters.java */
    class a extends com.google.gson.y<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            dVar.c();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                dVar.a(atomicIntegerArray.get(i2));
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public AtomicIntegerArray read2(com.google.gson.e0.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.c();
            while (aVar.j()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.o()));
                } catch (NumberFormatException e2) {
                    throw new com.google.gson.t(e2);
                }
            }
            aVar.f();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }
    }

    /* compiled from: TypeAdapters.java */
    class a0 implements com.google.gson.z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f5637a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.gson.y f5638b;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* compiled from: TypeAdapters.java */
        class a<T1> extends com.google.gson.y<T1> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f5639a;

            a(Class cls) {
                this.f5639a = cls;
            }

            @Override // com.google.gson.y
            /* renamed from: read */
            public T1 read2(com.google.gson.e0.a aVar) throws IOException {
                T1 t1 = (T1) a0.this.f5638b.read2(aVar);
                if (t1 == null || this.f5639a.isInstance(t1)) {
                    return t1;
                }
                throw new com.google.gson.t("Expected a " + this.f5639a.getName() + " but was " + t1.getClass().getName() + "; at path " + aVar.i());
            }

            @Override // com.google.gson.y
            public void write(com.google.gson.e0.d dVar, T1 t1) throws IOException {
                a0.this.f5638b.write(dVar, t1);
            }
        }

        a0(Class cls, com.google.gson.y yVar) {
            this.f5637a = cls;
            this.f5638b = yVar;
        }

        @Override // com.google.gson.z
        public <T2> com.google.gson.y<T2> create(com.google.gson.e eVar, com.google.gson.d0.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (this.f5637a.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f5637a.getName() + ",adapter=" + this.f5638b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    class b extends com.google.gson.y<Number> {
        b() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.longValue());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Number read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                return Long.valueOf(aVar.p());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    static /* synthetic */ class b0 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5641a = new int[com.google.gson.e0.c.values().length];

        static {
            try {
                f5641a[com.google.gson.e0.c.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5641a[com.google.gson.e0.c.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5641a[com.google.gson.e0.c.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5641a[com.google.gson.e0.c.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5641a[com.google.gson.e0.c.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5641a[com.google.gson.e0.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class c extends com.google.gson.y<Number> {
        c() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            dVar.a(number);
        }

        /* JADX WARN: Can't rename method to resolve collision */
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

    /* compiled from: TypeAdapters.java */
    class c0 extends com.google.gson.y<Boolean> {
        c0() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Boolean bool) throws IOException {
            dVar.a(bool);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Boolean read2(com.google.gson.e0.a aVar) throws IOException {
            com.google.gson.e0.c cVarPeek = aVar.peek();
            if (cVarPeek != com.google.gson.e0.c.NULL) {
                return cVarPeek == com.google.gson.e0.c.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.s())) : Boolean.valueOf(aVar.m());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    class d extends com.google.gson.y<Number> {
        d() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.doubleValue());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Number read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Double.valueOf(aVar.n());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    class d0 extends com.google.gson.y<Boolean> {
        d0() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Boolean bool) throws IOException {
            dVar.d(bool == null ? c.c.a.b.a.a.f3101h : bool.toString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Boolean read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Boolean.valueOf(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    class e extends com.google.gson.y<Character> {
        e() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Character ch) throws IOException {
            dVar.d(ch == null ? null : String.valueOf(ch));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Character read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            if (strS.length() == 1) {
                return Character.valueOf(strS.charAt(0));
            }
            throw new com.google.gson.t("Expecting character, got: " + strS + "; at " + aVar.i());
        }
    }

    /* compiled from: TypeAdapters.java */
    class e0 extends com.google.gson.y<Number> {
        e0() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.byteValue());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Number read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                int iO = aVar.o();
                if (iO <= 255 && iO >= -128) {
                    return Byte.valueOf((byte) iO);
                }
                throw new com.google.gson.t("Lossy conversion from " + iO + " to byte; at path " + aVar.i());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class f extends com.google.gson.y<String> {
        f() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, String str) throws IOException {
            dVar.d(str);
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public String read2(com.google.gson.e0.a aVar) throws IOException {
            com.google.gson.e0.c cVarPeek = aVar.peek();
            if (cVarPeek != com.google.gson.e0.c.NULL) {
                return cVarPeek == com.google.gson.e0.c.BOOLEAN ? Boolean.toString(aVar.m()) : aVar.s();
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    class f0 extends com.google.gson.y<Number> {
        f0() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.shortValue());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Number read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                int iO = aVar.o();
                if (iO <= 65535 && iO >= -32768) {
                    return Short.valueOf((short) iO);
                }
                throw new com.google.gson.t("Lossy conversion from " + iO + " to short; at path " + aVar.i());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class g extends com.google.gson.y<BigDecimal> {
        g() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, BigDecimal bigDecimal) throws IOException {
            dVar.a(bigDecimal);
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public BigDecimal read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            try {
                return new BigDecimal(strS);
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t("Failed parsing '" + strS + "' as BigDecimal; at path " + aVar.i(), e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class g0 extends com.google.gson.y<Number> {
        g0() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.intValue());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Number read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                return Integer.valueOf(aVar.o());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class h extends com.google.gson.y<BigInteger> {
        h() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, BigInteger bigInteger) throws IOException {
            dVar.a(bigInteger);
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public BigInteger read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            try {
                return new BigInteger(strS);
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t("Failed parsing '" + strS + "' as BigInteger; at path " + aVar.i(), e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class h0 extends com.google.gson.y<AtomicInteger> {
        h0() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, AtomicInteger atomicInteger) throws IOException {
            dVar.a(atomicInteger.get());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public AtomicInteger read2(com.google.gson.e0.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.o());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class i extends com.google.gson.y<com.google.gson.b0.h> {
        i() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, com.google.gson.b0.h hVar) throws IOException {
            dVar.a(hVar);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public com.google.gson.b0.h read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return new com.google.gson.b0.h(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    class i0 extends com.google.gson.y<AtomicBoolean> {
        i0() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, AtomicBoolean atomicBoolean) throws IOException {
            dVar.d(atomicBoolean.get());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public AtomicBoolean read2(com.google.gson.e0.a aVar) throws IOException {
            return new AtomicBoolean(aVar.m());
        }
    }

    /* compiled from: TypeAdapters.java */
    class j extends com.google.gson.y<StringBuilder> {
        j() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, StringBuilder sb) throws IOException {
            dVar.d(sb == null ? null : sb.toString());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public StringBuilder read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return new StringBuilder(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    private static final class j0<T extends Enum<T>> extends com.google.gson.y<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, T> f5642a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, T> f5643b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private final Map<T, String> f5644c = new HashMap();

        /* compiled from: TypeAdapters.java */
        class a implements PrivilegedAction<Field[]> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f5645a;

            a(Class cls) {
                this.f5645a = cls;
            }

            @Override // java.security.PrivilegedAction
            public Field[] run() throws SecurityException {
                Field[] declaredFields = this.f5645a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public j0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    String string = r4.toString();
                    com.google.gson.a0.c cVar = (com.google.gson.a0.c) field.getAnnotation(com.google.gson.a0.c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f5642a.put(str, r4);
                        }
                    }
                    this.f5642a.put(strName, r4);
                    this.f5643b.put(string, r4);
                    this.f5644c.put(r4, strName);
                }
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            dVar.d(t == null ? null : this.f5644c.get(t));
        }

        @Override // com.google.gson.y
        /* renamed from: read */
        public T read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            T t = this.f5642a.get(strS);
            return t == null ? this.f5643b.get(strS) : t;
        }
    }

    /* compiled from: TypeAdapters.java */
    class k extends com.google.gson.y<Class> {
        k() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public Class read2(com.google.gson.e0.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    class l extends com.google.gson.y<StringBuffer> {
        l() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, StringBuffer stringBuffer) throws IOException {
            dVar.d(stringBuffer == null ? null : stringBuffer.toString());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public StringBuffer read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return new StringBuffer(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    class m extends com.google.gson.y<URL> {
        m() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, URL url) throws IOException {
            dVar.d(url == null ? null : url.toExternalForm());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public URL read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            if (c.c.a.b.a.a.f3101h.equals(strS)) {
                return null;
            }
            return new URL(strS);
        }
    }

    /* compiled from: TypeAdapters.java */
    class n extends com.google.gson.y<URI> {
        n() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, URI uri) throws IOException {
            dVar.d(uri == null ? null : uri.toASCIIString());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public URI read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                String strS = aVar.s();
                if (c.c.a.b.a.a.f3101h.equals(strS)) {
                    return null;
                }
                return new URI(strS);
            } catch (URISyntaxException e2) {
                throw new com.google.gson.l(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$o, reason: collision with other inner class name */
    class C0087o extends com.google.gson.y<InetAddress> {
        C0087o() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, InetAddress inetAddress) throws IOException {
            dVar.d(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public InetAddress read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return InetAddress.getByName(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    class p extends com.google.gson.y<UUID> {
        p() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, UUID uuid) throws IOException {
            dVar.d(uuid == null ? null : uuid.toString());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public UUID read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            try {
                return UUID.fromString(strS);
            } catch (IllegalArgumentException e2) {
                throw new com.google.gson.t("Failed parsing '" + strS + "' as UUID; at path " + aVar.i(), e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class q extends com.google.gson.y<Currency> {
        q() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Currency currency) throws IOException {
            dVar.d(currency.getCurrencyCode());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public Currency read2(com.google.gson.e0.a aVar) throws IOException {
            String strS = aVar.s();
            try {
                return Currency.getInstance(strS);
            } catch (IllegalArgumentException e2) {
                throw new com.google.gson.t("Failed parsing '" + strS + "' as Currency; at path " + aVar.i(), e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    class r extends com.google.gson.y<Calendar> {

        /* renamed from: a, reason: collision with root package name */
        private static final String f5647a = "year";

        /* renamed from: b, reason: collision with root package name */
        private static final String f5648b = "month";

        /* renamed from: c, reason: collision with root package name */
        private static final String f5649c = "dayOfMonth";

        /* renamed from: d, reason: collision with root package name */
        private static final String f5650d = "hourOfDay";

        /* renamed from: e, reason: collision with root package name */
        private static final String f5651e = "minute";

        /* renamed from: f, reason: collision with root package name */
        private static final String f5652f = "second";

        r() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                dVar.j();
                return;
            }
            dVar.d();
            dVar.b(f5647a);
            dVar.a(calendar.get(1));
            dVar.b(f5648b);
            dVar.a(calendar.get(2));
            dVar.b(f5649c);
            dVar.a(calendar.get(5));
            dVar.b(f5650d);
            dVar.a(calendar.get(11));
            dVar.b(f5651e);
            dVar.a(calendar.get(12));
            dVar.b(f5652f);
            dVar.a(calendar.get(13));
            dVar.f();
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public Calendar read2(com.google.gson.e0.a aVar) throws IOException, NumberFormatException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            aVar.d();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.peek() != com.google.gson.e0.c.END_OBJECT) {
                String strQ = aVar.q();
                int iO = aVar.o();
                if (f5647a.equals(strQ)) {
                    i2 = iO;
                } else if (f5648b.equals(strQ)) {
                    i3 = iO;
                } else if (f5649c.equals(strQ)) {
                    i4 = iO;
                } else if (f5650d.equals(strQ)) {
                    i5 = iO;
                } else if (f5651e.equals(strQ)) {
                    i6 = iO;
                } else if (f5652f.equals(strQ)) {
                    i7 = iO;
                }
            }
            aVar.g();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }
    }

    /* compiled from: TypeAdapters.java */
    class s extends com.google.gson.y<Locale> {
        s() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Locale locale) throws IOException {
            dVar.d(locale == null ? null : locale.toString());
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public Locale read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.s(), c.c.a.b.a.a.s1);
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }
    }

    /* compiled from: TypeAdapters.java */
    class t extends com.google.gson.y<com.google.gson.k> {
        t() {
        }

        private com.google.gson.k a(com.google.gson.e0.a aVar, com.google.gson.e0.c cVar) throws IOException {
            int i2 = b0.f5641a[cVar.ordinal()];
            if (i2 == 1) {
                return new com.google.gson.p(new com.google.gson.b0.h(aVar.s()));
            }
            if (i2 == 2) {
                return new com.google.gson.p(aVar.s());
            }
            if (i2 == 3) {
                return new com.google.gson.p(Boolean.valueOf(aVar.m()));
            }
            if (i2 == 6) {
                aVar.r();
                return com.google.gson.m.f5749a;
            }
            throw new IllegalStateException("Unexpected token: " + cVar);
        }

        private com.google.gson.k b(com.google.gson.e0.a aVar, com.google.gson.e0.c cVar) throws IOException {
            int i2 = b0.f5641a[cVar.ordinal()];
            if (i2 == 4) {
                aVar.c();
                return new com.google.gson.h();
            }
            if (i2 != 5) {
                return null;
            }
            aVar.d();
            return new JsonObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        /* renamed from: read */
        public com.google.gson.k read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar instanceof com.google.gson.b0.q.f) {
                return ((com.google.gson.b0.q.f) aVar).u();
            }
            com.google.gson.e0.c cVarPeek = aVar.peek();
            com.google.gson.k kVarB = b(aVar, cVarPeek);
            if (kVarB == null) {
                return a(aVar, cVarPeek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.j()) {
                    String strQ = kVarB instanceof JsonObject ? aVar.q() : null;
                    com.google.gson.e0.c cVarPeek2 = aVar.peek();
                    com.google.gson.k kVarB2 = b(aVar, cVarPeek2);
                    boolean z = kVarB2 != null;
                    if (kVarB2 == null) {
                        kVarB2 = a(aVar, cVarPeek2);
                    }
                    if (kVarB instanceof com.google.gson.h) {
                        ((com.google.gson.h) kVarB).a(kVarB2);
                    } else {
                        ((JsonObject) kVarB).add(strQ, kVarB2);
                    }
                    if (z) {
                        arrayDeque.addLast(kVarB);
                        kVarB = kVarB2;
                    }
                } else {
                    if (kVarB instanceof com.google.gson.h) {
                        aVar.f();
                    } else {
                        aVar.g();
                    }
                    if (arrayDeque.isEmpty()) {
                        return kVarB;
                    }
                    kVarB = (com.google.gson.k) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, com.google.gson.k kVar) throws IOException {
            if (kVar != null && !kVar.isJsonNull()) {
                if (kVar.isJsonPrimitive()) {
                    com.google.gson.p asJsonPrimitive = kVar.getAsJsonPrimitive();
                    if (asJsonPrimitive.b()) {
                        dVar.a(asJsonPrimitive.getAsNumber());
                        return;
                    } else if (asJsonPrimitive.a()) {
                        dVar.d(asJsonPrimitive.getAsBoolean());
                        return;
                    } else {
                        dVar.d(asJsonPrimitive.getAsString());
                        return;
                    }
                }
                if (kVar.isJsonArray()) {
                    dVar.c();
                    Iterator<com.google.gson.k> it = kVar.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        write(dVar, it.next());
                    }
                    dVar.e();
                    return;
                }
                if (kVar.isJsonObject()) {
                    dVar.d();
                    for (Map.Entry<String, com.google.gson.k> entry : kVar.getAsJsonObject().entrySet()) {
                        dVar.b(entry.getKey());
                        write(dVar, entry.getValue());
                    }
                    dVar.f();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
            dVar.j();
        }
    }

    /* compiled from: TypeAdapters.java */
    class u implements com.google.gson.z {
        u() {
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new j0(rawType);
        }
    }

    /* compiled from: TypeAdapters.java */
    class v extends com.google.gson.y<BitSet> {
        v() {
        }

        @Override // com.google.gson.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, BitSet bitSet) throws IOException {
            dVar.c();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                dVar.a(bitSet.get(i2) ? 1L : 0L);
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public BitSet read2(com.google.gson.e0.a aVar) throws IOException, NumberFormatException {
            boolean zM;
            BitSet bitSet = new BitSet();
            aVar.c();
            com.google.gson.e0.c cVarPeek = aVar.peek();
            int i2 = 0;
            while (cVarPeek != com.google.gson.e0.c.END_ARRAY) {
                int i3 = b0.f5641a[cVarPeek.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    int iO = aVar.o();
                    if (iO == 0) {
                        zM = false;
                    } else {
                        if (iO != 1) {
                            throw new com.google.gson.t("Invalid bitset value " + iO + ", expected 0 or 1; at path " + aVar.i());
                        }
                        zM = true;
                    }
                } else {
                    if (i3 != 3) {
                        throw new com.google.gson.t("Invalid bitset value type: " + cVarPeek + "; at path " + aVar.h());
                    }
                    zM = aVar.m();
                }
                if (zM) {
                    bitSet.set(i2);
                }
                i2++;
                cVarPeek = aVar.peek();
            }
            aVar.f();
            return bitSet;
        }
    }

    /* compiled from: TypeAdapters.java */
    class w implements com.google.gson.z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.d0.a f5653a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.gson.y f5654b;

        w(com.google.gson.d0.a aVar, com.google.gson.y yVar) {
            this.f5653a = aVar;
            this.f5654b = yVar;
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.equals(this.f5653a)) {
                return this.f5654b;
            }
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    class x implements com.google.gson.z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f5655a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.gson.y f5656b;

        x(Class cls, com.google.gson.y yVar) {
            this.f5655a = cls;
            this.f5656b = yVar;
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.getRawType() == this.f5655a) {
                return this.f5656b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5655a.getName() + ",adapter=" + this.f5656b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    class y implements com.google.gson.z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f5657a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f5658b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.gson.y f5659c;

        y(Class cls, Class cls2, com.google.gson.y yVar) {
            this.f5657a = cls;
            this.f5658b = cls2;
            this.f5659c = yVar;
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f5657a || rawType == this.f5658b) {
                return this.f5659c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5658b.getName() + "+" + this.f5657a.getName() + ",adapter=" + this.f5659c + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    class z implements com.google.gson.z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f5660a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f5661b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.gson.y f5662c;

        z(Class cls, Class cls2, com.google.gson.y yVar) {
            this.f5660a = cls;
            this.f5661b = cls2;
            this.f5662c = yVar;
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f5660a || rawType == this.f5661b) {
                return this.f5662c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5660a.getName() + "+" + this.f5661b.getName() + ",adapter=" + this.f5662c + "]";
        }
    }

    private o() {
        throw new UnsupportedOperationException();
    }

    public static <TT> com.google.gson.z a(com.google.gson.d0.a<TT> aVar, com.google.gson.y<TT> yVar) {
        return new w(aVar, yVar);
    }

    public static <TT> com.google.gson.z b(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.y<? super TT> yVar) {
        return new z(cls, cls2, yVar);
    }

    public static <TT> com.google.gson.z a(Class<TT> cls, com.google.gson.y<TT> yVar) {
        return new x(cls, yVar);
    }

    public static <T1> com.google.gson.z b(Class<T1> cls, com.google.gson.y<T1> yVar) {
        return new a0(cls, yVar);
    }

    public static <TT> com.google.gson.z a(Class<TT> cls, Class<TT> cls2, com.google.gson.y<? super TT> yVar) {
        return new y(cls, cls2, yVar);
    }
}
