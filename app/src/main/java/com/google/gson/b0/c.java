package com.google.gson.b0;

import com.google.gson.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.gson.g<?>> f5482a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5483b;

    /* renamed from: c, reason: collision with root package name */
    private final List<v> f5484c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class a<T> implements com.google.gson.b0.k<T> {
        a() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class b<T> implements com.google.gson.b0.k<T> {
        b() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$c, reason: collision with other inner class name */
    class C0084c<T> implements com.google.gson.b0.k<T> {
        C0084c() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class d<T> implements com.google.gson.b0.k<T> {
        d() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class e<T> implements com.google.gson.b0.k<T> {
        e() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class f<T> implements com.google.gson.b0.k<T> {
        f() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class g<T> implements com.google.gson.b0.k<T> {
        g() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class h<T> implements com.google.gson.b0.k<T> {
        h() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class i<T> implements com.google.gson.b0.k<T> {
        i() {
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) new com.google.gson.b0.i();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class j<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f5485a;

        j(Class cls) {
            this.f5485a = cls;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            try {
                return (T) com.google.gson.b0.p.f5546a.a(this.f5485a);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to create instance of " + this.f5485a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e2);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class k<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.g f5487a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f5488b;

        k(com.google.gson.g gVar, Type type) {
            this.f5487a = gVar;
            this.f5488b = type;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) this.f5487a.a(this.f5488b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class l<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5490a;

        l(String str) {
            this.f5490a = str;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            throw new com.google.gson.l(this.f5490a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class m<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.g f5492a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f5493b;

        m(com.google.gson.g gVar, Type type) {
            this.f5492a = gVar;
            this.f5493b = type;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            return (T) this.f5492a.a(this.f5493b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class n<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5495a;

        n(String str) {
            this.f5495a = str;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            throw new com.google.gson.l(this.f5495a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class o<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5497a;

        o(String str) {
            this.f5497a = str;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            throw new com.google.gson.l(this.f5497a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class p<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f5499a;

        p(Type type) {
            this.f5499a = type;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            Type type = this.f5499a;
            if (!(type instanceof ParameterizedType)) {
                throw new com.google.gson.l("Invalid EnumSet type: " + this.f5499a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new com.google.gson.l("Invalid EnumSet type: " + this.f5499a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class q<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f5500a;

        q(Type type) {
            this.f5500a = type;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            Type type = this.f5500a;
            if (!(type instanceof ParameterizedType)) {
                throw new com.google.gson.l("Invalid EnumMap type: " + this.f5500a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new com.google.gson.l("Invalid EnumMap type: " + this.f5500a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class r<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5501a;

        r(String str) {
            this.f5501a = str;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            throw new com.google.gson.l(this.f5501a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class s<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5502a;

        s(String str) {
            this.f5502a = str;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            throw new com.google.gson.l(this.f5502a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    class t<T> implements com.google.gson.b0.k<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f5503a;

        t(Constructor constructor) {
            this.f5503a = constructor;
        }

        @Override // com.google.gson.b0.k
        public T a() {
            try {
                return (T) this.f5503a.newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                throw com.google.gson.b0.s.a.a(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f5503a) + "' with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f5503a) + "' with no args", e4.getCause());
            }
        }
    }

    public c(Map<Type, com.google.gson.g<?>> map, boolean z, List<v> list) {
        this.f5482a = map;
        this.f5483b = z;
        this.f5484c = list;
    }

    static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
    }

    private static <T> com.google.gson.b0.k<T> b(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    public String toString() {
        return this.f5482a.toString();
    }

    private <T> com.google.gson.b0.k<T> b(Class<? super T> cls) {
        if (this.f5483b) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> com.google.gson.b0.k<T> a(com.google.gson.d0.a<T> aVar) throws NoSuchMethodException, SecurityException {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        com.google.gson.g<?> gVar = this.f5482a.get(type);
        if (gVar != null) {
            return new k(gVar, type);
        }
        com.google.gson.g<?> gVar2 = this.f5482a.get(rawType);
        if (gVar2 != null) {
            return new m(gVar2, type);
        }
        com.google.gson.b0.k<T> kVarB = b(type, rawType);
        if (kVarB != null) {
            return kVarB;
        }
        v.e eVarA = com.google.gson.b0.n.a(this.f5484c, rawType);
        com.google.gson.b0.k<T> kVarA = a(rawType, eVarA);
        if (kVarA != null) {
            return kVarA;
        }
        com.google.gson.b0.k<T> kVarA2 = a(type, rawType);
        if (kVarA2 != null) {
            return kVarA2;
        }
        String strA = a(rawType);
        if (strA != null) {
            return new n(strA);
        }
        if (eVarA == v.e.ALLOW) {
            return b(rawType);
        }
        return new o("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    private static <T> com.google.gson.b0.k<T> a(Class<? super T> cls, v.e eVar) throws NoSuchMethodException, SecurityException {
        String strB;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        boolean z = false;
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (eVar == v.e.ALLOW || (com.google.gson.b0.n.a(declaredConstructor, (Object) null) && (eVar != v.e.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                z = true;
            }
            if (!z) {
                return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            }
            if (eVar == v.e.ALLOW && (strB = com.google.gson.b0.s.a.b(declaredConstructor)) != null) {
                return new s(strB);
            }
            return new t(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> com.google.gson.b0.k<T> a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new C0084c();
            }
            return new d();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new e();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new f();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new g();
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(com.google.gson.d0.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new h();
        }
        return new i();
    }
}
