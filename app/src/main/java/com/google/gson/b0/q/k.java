package com.google.gson.b0.q;

import com.google.gson.t;
import com.google.gson.v;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class k implements z {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.b0.c f5583a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.d f5584b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.gson.b0.d f5585c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.gson.b0.q.e f5586d;

    /* renamed from: e, reason: collision with root package name */
    private final List<v> f5587e;

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    public static abstract class b<T, A> extends y<T> {

        /* renamed from: a, reason: collision with root package name */
        final Map<String, c> f5596a;

        b(Map<String, c> map) {
            this.f5596a = map;
        }

        abstract A a();

        abstract T a(A a2);

        abstract void a(A a2, com.google.gson.e0.a aVar, c cVar) throws IllegalAccessException, IOException;

        @Override // com.google.gson.y
        /* renamed from: read */
        public T read2(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            A a2 = a();
            try {
                aVar.d();
                while (aVar.j()) {
                    c cVar = this.f5596a.get(aVar.q());
                    if (cVar == null || !cVar.f5601e) {
                        aVar.t();
                    } else {
                        a(a2, aVar, cVar);
                    }
                }
                aVar.g();
                return a(a2);
            } catch (IllegalAccessException e2) {
                throw com.google.gson.b0.s.a.a(e2);
            } catch (IllegalStateException e3) {
                throw new t(e3);
            }
        }

        @Override // com.google.gson.y
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            if (t == null) {
                dVar.j();
                return;
            }
            dVar.d();
            try {
                Iterator<c> it = this.f5596a.values().iterator();
                while (it.hasNext()) {
                    it.next().a(dVar, t);
                }
                dVar.f();
            } catch (IllegalAccessException e2) {
                throw com.google.gson.b0.s.a.a(e2);
            }
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final String f5597a;

        /* renamed from: b, reason: collision with root package name */
        final Field f5598b;

        /* renamed from: c, reason: collision with root package name */
        final String f5599c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f5600d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f5601e;

        protected c(String str, Field field, boolean z, boolean z2) {
            this.f5597a = str;
            this.f5598b = field;
            this.f5599c = field.getName();
            this.f5600d = z;
            this.f5601e = z2;
        }

        abstract void a(com.google.gson.e0.a aVar, int i2, Object[] objArr) throws com.google.gson.n, IOException;

        abstract void a(com.google.gson.e0.a aVar, Object obj) throws IllegalAccessException, IOException;

        abstract void a(com.google.gson.e0.d dVar, Object obj) throws IllegalAccessException, IOException;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    private static final class d<T> extends b<T, T> {

        /* renamed from: b, reason: collision with root package name */
        private final com.google.gson.b0.k<T> f5602b;

        d(com.google.gson.b0.k<T> kVar, Map<String, c> map) {
            super(map);
            this.f5602b = kVar;
        }

        @Override // com.google.gson.b0.q.k.b
        T a() {
            return this.f5602b.a();
        }

        @Override // com.google.gson.b0.q.k.b
        T a(T t) {
            return t;
        }

        @Override // com.google.gson.b0.q.k.b
        void a(T t, com.google.gson.e0.a aVar, c cVar) throws IllegalAccessException, IOException {
            cVar.a(aVar, t);
        }
    }

    public k(com.google.gson.b0.c cVar, com.google.gson.d dVar, com.google.gson.b0.d dVar2, com.google.gson.b0.q.e eVar, List<v> list) {
        this.f5583a = cVar;
        this.f5584b = dVar;
        this.f5585c = dVar2;
        this.f5586d = eVar;
        this.f5587e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void b(Object obj, M m2) {
        if (Modifier.isStatic(m2.getModifiers())) {
            obj = null;
        }
        if (com.google.gson.b0.n.a(m2, obj)) {
            return;
        }
        throw new com.google.gson.l(com.google.gson.b0.s.a.a((AccessibleObject) m2, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        v.e eVarA = com.google.gson.b0.n.a(this.f5587e, rawType);
        if (eVarA != v.e.BLOCK_ALL) {
            boolean z = eVarA == v.e.BLOCK_INACCESSIBLE;
            return com.google.gson.b0.s.a.c(rawType) ? new e(rawType, a(eVar, aVar, rawType, z, true), z) : new d(this.f5583a.a(aVar), a(eVar, aVar, rawType, z, false));
        }
        throw new com.google.gson.l("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    private boolean a(Field field, boolean z) {
        return (this.f5585c.a(field.getType(), z) || this.f5585c.a(field, z)) ? false : true;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    private static final class e<T> extends b<T, Object[]> {

        /* renamed from: e, reason: collision with root package name */
        static final Map<Class<?>, Object> f5603e = b();

        /* renamed from: b, reason: collision with root package name */
        private final Constructor<T> f5604b;

        /* renamed from: c, reason: collision with root package name */
        private final Object[] f5605c;

        /* renamed from: d, reason: collision with root package name */
        private final Map<String, Integer> f5606d;

        e(Class<T> cls, Map<String, c> map, boolean z) throws SecurityException, com.google.gson.l {
            super(map);
            this.f5606d = new HashMap();
            this.f5604b = com.google.gson.b0.s.a.a(cls);
            if (z) {
                k.b(null, this.f5604b);
            } else {
                com.google.gson.b0.s.a.a(this.f5604b);
            }
            String[] strArrB = com.google.gson.b0.s.a.b((Class<?>) cls);
            for (int i2 = 0; i2 < strArrB.length; i2++) {
                this.f5606d.put(strArrB[i2], Integer.valueOf(i2));
            }
            Class<?>[] parameterTypes = this.f5604b.getParameterTypes();
            this.f5605c = new Object[parameterTypes.length];
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                this.f5605c[i3] = f5603e.get(parameterTypes[i3]);
            }
        }

        private static Map<Class<?>, Object> b() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, false);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.b0.q.k.b
        public Object[] a() {
            return (Object[]) this.f5605c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.b0.q.k.b
        public void a(Object[] objArr, com.google.gson.e0.a aVar, c cVar) throws com.google.gson.n, IOException {
            Integer num = this.f5606d.get(cVar.f5599c);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f5604b) + "' for field with name '" + cVar.f5599c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.b0.q.k.b
        public T a(Object[] objArr) {
            try {
                return this.f5604b.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                throw com.google.gson.b0.s.a.a(e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f5604b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f5604b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f5604b) + "' with args " + Arrays.toString(objArr), e5.getCause());
            }
        }
    }

    private List<String> a(Field field) {
        com.google.gson.a0.c cVar = (com.google.gson.a0.c) field.getAnnotation(com.google.gson.a0.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f5584b.translateName(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private c a(com.google.gson.e eVar, Field field, Method method, String str, com.google.gson.d0.a<?> aVar, boolean z, boolean z2, boolean z3) {
        boolean zA = com.google.gson.b0.m.a((Type) aVar.getRawType());
        int modifiers = field.getModifiers();
        boolean z4 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        com.google.gson.a0.b bVar = (com.google.gson.a0.b) field.getAnnotation(com.google.gson.a0.b.class);
        y<?> yVarA = bVar != null ? this.f5586d.a(this.f5583a, eVar, aVar, bVar) : null;
        return new a(str, field, z, z2, z3, method, yVarA != null, yVarA == null ? eVar.a((com.google.gson.d0.a) aVar) : yVarA, eVar, aVar, zA, z4);
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    class a extends c {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f5588f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Method f5589g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f5590h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ y f5591i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f5592j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ com.google.gson.d0.a f5593k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f5594l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f5595m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, y yVar, com.google.gson.e eVar, com.google.gson.d0.a aVar, boolean z5, boolean z6) {
            super(str, field, z, z2);
            this.f5588f = z3;
            this.f5589g = method;
            this.f5590h = z4;
            this.f5591i = yVar;
            this.f5592j = eVar;
            this.f5593k = aVar;
            this.f5594l = z5;
            this.f5595m = z6;
        }

        @Override // com.google.gson.b0.q.k.c
        void a(com.google.gson.e0.d dVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            Object objInvoke;
            if (this.f5600d) {
                if (this.f5588f) {
                    Method method = this.f5589g;
                    if (method == null) {
                        k.b(obj, this.f5598b);
                    } else {
                        k.b(obj, method);
                    }
                }
                Method method2 = this.f5589g;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e2) {
                        throw new com.google.gson.l("Accessor " + com.google.gson.b0.s.a.a((AccessibleObject) this.f5589g, false) + " threw exception", e2.getCause());
                    }
                } else {
                    objInvoke = this.f5598b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                dVar.b(this.f5597a);
                (this.f5590h ? this.f5591i : new n(this.f5592j, this.f5591i, this.f5593k.getType())).write(dVar, objInvoke);
            }
        }

        @Override // com.google.gson.b0.q.k.c
        void a(com.google.gson.e0.a aVar, int i2, Object[] objArr) throws com.google.gson.n, IOException {
            Object obj = this.f5591i.read2(aVar);
            if (obj == null && this.f5594l) {
                throw new com.google.gson.n("null is not allowed as value for record component '" + this.f5599c + "' of primitive type; at path " + aVar.h());
            }
            objArr[i2] = obj;
        }

        @Override // com.google.gson.b0.q.k.c
        void a(com.google.gson.e0.a aVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
            Object obj2 = this.f5591i.read2(aVar);
            if (obj2 == null && this.f5594l) {
                return;
            }
            if (this.f5588f) {
                k.b(obj, this.f5598b);
            } else if (this.f5595m) {
                throw new com.google.gson.l("Cannot set value of 'static final' " + com.google.gson.b0.s.a.a((AccessibleObject) this.f5598b, false));
            }
            this.f5598b.set(obj, obj2);
        }
    }

    private Map<String, c> a(com.google.gson.e eVar, com.google.gson.d0.a<?> aVar, Class<?> cls, boolean z, boolean z2) throws SecurityException, com.google.gson.l {
        boolean z3;
        Method method;
        int i2;
        int i3;
        k kVar = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        com.google.gson.d0.a<?> aVar2 = aVar;
        boolean z4 = z;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            boolean z5 = true;
            boolean z6 = false;
            if (rawType != cls && declaredFields.length > 0) {
                v.e eVarA = com.google.gson.b0.n.a(kVar.f5587e, rawType);
                if (eVarA != v.e.BLOCK_ALL) {
                    z4 = eVarA == v.e.BLOCK_INACCESSIBLE;
                } else {
                    throw new com.google.gson.l("ReflectionAccessFilter does not permit using reflection for " + rawType + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
            }
            boolean z7 = z4;
            int length = declaredFields.length;
            int i4 = 0;
            while (i4 < length) {
                Field field = declaredFields[i4];
                boolean zA = kVar.a(field, z5);
                boolean zA2 = kVar.a(field, z6);
                if (zA || zA2) {
                    if (!z2) {
                        z3 = zA2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z3 = false;
                    } else {
                        Method methodA = com.google.gson.b0.s.a.a(rawType, field);
                        if (!z7) {
                            com.google.gson.b0.s.a.a(methodA);
                        }
                        if (methodA.getAnnotation(com.google.gson.a0.c.class) != null && field.getAnnotation(com.google.gson.a0.c.class) == null) {
                            throw new com.google.gson.l("@SerializedName on " + com.google.gson.b0.s.a.a(methodA, z6) + " is not supported");
                        }
                        z3 = zA2;
                        method = methodA;
                    }
                    if (!z7 && method == null) {
                        com.google.gson.b0.s.a.a((AccessibleObject) field);
                    }
                    Type typeA = com.google.gson.b0.b.a(aVar2.getType(), rawType, field.getGenericType());
                    List<String> listA = kVar.a(field);
                    int size = listA.size();
                    c cVar = null;
                    int i5 = 0;
                    while (i5 < size) {
                        String str = listA.get(i5);
                        boolean z8 = i5 != 0 ? false : zA;
                        c cVar2 = cVar;
                        int i6 = i5;
                        int i7 = size;
                        List<String> list = listA;
                        Field field2 = field;
                        int i8 = i4;
                        int i9 = length;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, a(eVar, field, method, str, com.google.gson.d0.a.get(typeA), z8, z3, z7)) : cVar2;
                        i5 = i6 + 1;
                        zA = z8;
                        i4 = i8;
                        size = i7;
                        listA = list;
                        field = field2;
                        length = i9;
                    }
                    c cVar3 = cVar;
                    Field field3 = field;
                    i2 = i4;
                    i3 = length;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar3.f5597a + "'; conflict is caused by fields " + com.google.gson.b0.s.a.a(cVar3.f5598b) + " and " + com.google.gson.b0.s.a.a(field3));
                    }
                } else {
                    i2 = i4;
                    i3 = length;
                }
                i4 = i2 + 1;
                z6 = false;
                z5 = true;
                kVar = this;
                length = i3;
            }
            aVar2 = com.google.gson.d0.a.get(com.google.gson.b0.b.a(aVar2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = aVar2.getRawType();
            kVar = this;
            z4 = z7;
        }
        return linkedHashMap;
    }
}
