package com.google.gson.b0;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

/* compiled from: $Gson$Types.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final Type[] f5480a = new Type[0];

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f5481b = false;

    /* compiled from: $Gson$Types.java */
    private static final class a implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public a(Type type) {
            Objects.requireNonNull(type);
            this.componentType = b.b(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && b.a((Type) this, (Type) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return b.h(this.componentType) + "[]";
        }
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: com.google.gson.b0.b$b, reason: collision with other inner class name */
    private static final class C0083b implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public C0083b(Type type, Type type2, Type... typeArr) {
            Objects.requireNonNull(type2);
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                com.google.gson.b0.a.a(z);
            }
            this.ownerType = type == null ? null : b.b(type);
            this.rawType = b.b(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int length = this.typeArguments.length;
            for (int i2 = 0; i2 < length; i2++) {
                Objects.requireNonNull(this.typeArguments[i2]);
                b.c(this.typeArguments[i2]);
                Type[] typeArr2 = this.typeArguments;
                typeArr2[i2] = b.b(typeArr2[i2]);
            }
        }

        private static int a(Object obj) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && b.a((Type) this, (Type) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ a(this.ownerType);
        }

        public String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return b.h(this.rawType);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(b.h(this.rawType));
            sb.append("<");
            sb.append(b.h(this.typeArguments[0]));
            for (int i2 = 1; i2 < length; i2++) {
                sb.append(", ");
                sb.append(b.h(this.typeArguments[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: $Gson$Types.java */
    private static final class c implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public c(Type[] typeArr, Type[] typeArr2) {
            com.google.gson.b0.a.a(typeArr2.length <= 1);
            com.google.gson.b0.a.a(typeArr.length == 1);
            if (typeArr2.length != 1) {
                Objects.requireNonNull(typeArr[0]);
                b.c(typeArr[0]);
                this.lowerBound = null;
                this.upperBound = b.b(typeArr[0]);
                return;
            }
            Objects.requireNonNull(typeArr2[0]);
            b.c(typeArr2[0]);
            com.google.gson.b0.a.a(typeArr[0] == Object.class);
            this.lowerBound = b.b(typeArr2[0]);
            this.upperBound = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && b.a((Type) this, (Type) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            return type != null ? new Type[]{type} : b.f5480a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.lowerBound != null) {
                return "? super " + b.h(this.lowerBound);
            }
            if (this.upperBound == Object.class) {
                return "?";
            }
            return "? extends " + b.h(this.upperBound);
        }
    }

    private b() {
        throw new UnsupportedOperationException();
    }

    public static ParameterizedType a(Type type, Type type2, Type... typeArr) {
        return new C0083b(type, type2, typeArr);
    }

    public static Type b(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(b(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0083b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    static void c(Type type) {
        com.google.gson.b0.a.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static Type d(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Class<?> e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            com.google.gson.b0.a.a(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return e(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? c.c.a.b.a.a.f3101h : type.getClass().getName()));
    }

    public static WildcardType f(Type type) {
        return new c(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f5480a);
    }

    public static WildcardType g(Type type) {
        return new c(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
    }

    public static String h(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    private static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    private static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        com.google.gson.b0.a.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type typeB = b(type, cls, Map.class);
        return typeB instanceof ParameterizedType ? ((ParameterizedType) typeB).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    private static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces2 = cls.getInterfaces();
            int length = interfaces2.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (interfaces2[i2] == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(interfaces2[i2])) {
                    return a(cls.getGenericInterfaces()[i2], interfaces2[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type a(Type type, Class<?> cls) {
        Type typeB = b(type, cls, Collection.class);
        if (typeB instanceof ParameterizedType) {
            return ((ParameterizedType) typeB).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashMap());
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:
    
        if (r0 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00de, code lost:
    
        r12.put(r0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e1, code lost:
    
        return r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Map, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.reflect.Type a(java.lang.reflect.Type r9, java.lang.Class<?> r10, java.lang.reflect.Type r11, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> r12) {
        /*
            r0 = 0
        L1:
            boolean r1 = r11 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L27
            r1 = r11
            java.lang.reflect.TypeVariable r1 = (java.lang.reflect.TypeVariable) r1
            java.lang.Object r2 = r12.get(r1)
            java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
            if (r2 == 0) goto L17
            java.lang.Class r9 = java.lang.Void.TYPE
            if (r2 != r9) goto L15
            goto L16
        L15:
            r11 = r2
        L16:
            return r11
        L17:
            java.lang.Class r11 = java.lang.Void.TYPE
            r12.put(r1, r11)
            if (r0 != 0) goto L1f
            r0 = r1
        L1f:
            java.lang.reflect.Type r11 = a(r9, r10, r1)
            if (r11 != r1) goto L1
            goto Ldc
        L27:
            boolean r1 = r11 instanceof java.lang.Class
            if (r1 == 0) goto L4c
            r1 = r11
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r2 = r1.isArray()
            if (r2 == 0) goto L4c
            java.lang.Class r11 = r1.getComponentType()
            java.lang.reflect.Type r9 = a(r9, r10, r11, r12)
            boolean r10 = a(r11, r9)
            if (r10 == 0) goto L45
            r11 = r1
            goto Ldc
        L45:
            java.lang.reflect.GenericArrayType r9 = a(r9)
        L49:
            r11 = r9
            goto Ldc
        L4c:
            boolean r1 = r11 instanceof java.lang.reflect.GenericArrayType
            if (r1 == 0) goto L67
            java.lang.reflect.GenericArrayType r11 = (java.lang.reflect.GenericArrayType) r11
            java.lang.reflect.Type r1 = r11.getGenericComponentType()
            java.lang.reflect.Type r9 = a(r9, r10, r1, r12)
            boolean r10 = a(r1, r9)
            if (r10 == 0) goto L62
            goto Ldc
        L62:
            java.lang.reflect.GenericArrayType r9 = a(r9)
            goto L49
        L67:
            boolean r1 = r11 instanceof java.lang.reflect.ParameterizedType
            r2 = 0
            r3 = 1
            if (r1 == 0) goto Lab
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r1 = r11.getOwnerType()
            java.lang.reflect.Type r4 = a(r9, r10, r1, r12)
            boolean r1 = a(r4, r1)
            r1 = r1 ^ r3
            java.lang.reflect.Type[] r5 = r11.getActualTypeArguments()
            int r6 = r5.length
        L81:
            if (r2 >= r6) goto La0
            r7 = r5[r2]
            java.lang.reflect.Type r7 = a(r9, r10, r7, r12)
            r8 = r5[r2]
            boolean r8 = a(r7, r8)
            if (r8 != 0) goto L9d
            if (r1 != 0) goto L9b
            java.lang.Object r1 = r5.clone()
            r5 = r1
            java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
            r1 = 1
        L9b:
            r5[r2] = r7
        L9d:
            int r2 = r2 + 1
            goto L81
        La0:
            if (r1 == 0) goto Ldc
            java.lang.reflect.Type r9 = r11.getRawType()
            java.lang.reflect.ParameterizedType r9 = a(r4, r9, r5)
            goto L49
        Lab:
            boolean r1 = r11 instanceof java.lang.reflect.WildcardType
            if (r1 == 0) goto Ldc
            java.lang.reflect.WildcardType r11 = (java.lang.reflect.WildcardType) r11
            java.lang.reflect.Type[] r1 = r11.getLowerBounds()
            java.lang.reflect.Type[] r4 = r11.getUpperBounds()
            int r5 = r1.length
            if (r5 != r3) goto Lcb
            r3 = r1[r2]
            java.lang.reflect.Type r9 = a(r9, r10, r3, r12)
            r10 = r1[r2]
            if (r9 == r10) goto Ldc
            java.lang.reflect.WildcardType r11 = g(r9)
            goto Ldc
        Lcb:
            int r1 = r4.length
            if (r1 != r3) goto Ldc
            r1 = r4[r2]
            java.lang.reflect.Type r9 = a(r9, r10, r1, r12)     // Catch: java.lang.Throwable -> Le2
            r10 = r4[r2]
            if (r9 == r10) goto Ldc
            java.lang.reflect.WildcardType r11 = f(r9)
        Ldc:
            if (r0 == 0) goto Le1
            r12.put(r0, r11)
        Le1:
            return r11
        Le2:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.b0.b.a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Map):java.lang.reflect.Type");
    }

    private static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsA = a(typeVariable);
        if (clsA == null) {
            return typeVariable;
        }
        Type typeA = a(type, cls, clsA);
        if (!(typeA instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeA).getActualTypeArguments()[a((Object[]) clsA.getTypeParameters(), (Object) typeVariable)];
    }

    private static int a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }
}
