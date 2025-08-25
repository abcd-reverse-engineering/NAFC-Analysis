package l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import okio.Buffer;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
final class p {

    /* renamed from: a, reason: collision with root package name */
    static final Type[] f17204a = new Type[0];

    /* compiled from: Utils.java */
    private static final class a implements GenericArrayType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f17205a;

        a(Type type) {
            this.f17205a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && p.a(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f17205a;
        }

        public int hashCode() {
            return this.f17205a.hashCode();
        }

        public String toString() {
            return p.e(this.f17205a) + "[]";
        }
    }

    /* compiled from: Utils.java */
    private static final class b implements ParameterizedType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f17206a;

        /* renamed from: b, reason: collision with root package name */
        private final Type f17207b;

        /* renamed from: c, reason: collision with root package name */
        private final Type[] f17208c;

        b(@Nullable Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                p.a(type3, "typeArgument == null");
                p.a(type3);
            }
            this.f17206a = type;
            this.f17207b = type2;
            this.f17208c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && p.a(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f17208c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f17206a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f17207b;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.f17208c) ^ this.f17207b.hashCode();
            Type type = this.f17206a;
            return iHashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f17208c;
            if (typeArr.length == 0) {
                return p.e(this.f17207b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(p.e(this.f17207b));
            sb.append("<");
            sb.append(p.e(this.f17208c[0]));
            for (int i2 = 1; i2 < this.f17208c.length; i2++) {
                sb.append(", ");
                sb.append(p.e(this.f17208c[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: Utils.java */
    private static final class c implements WildcardType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f17209a;

        /* renamed from: b, reason: collision with root package name */
        private final Type f17210b;

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                if (typeArr[0] == null) {
                    throw new NullPointerException();
                }
                p.a(typeArr[0]);
                this.f17210b = null;
                this.f17209a = typeArr[0];
                return;
            }
            if (typeArr2[0] == null) {
                throw new NullPointerException();
            }
            p.a(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f17210b = typeArr2[0];
            this.f17209a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && p.a(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f17210b;
            return type != null ? new Type[]{type} : p.f17204a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f17209a};
        }

        public int hashCode() {
            Type type = this.f17210b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f17209a.hashCode() + 31);
        }

        public String toString() {
            if (this.f17210b != null) {
                return "? super " + p.e(this.f17210b);
            }
            if (this.f17209a == Object.class) {
                return "?";
            }
            return "? extends " + p.e(this.f17209a);
        }
    }

    private p() {
    }

    static boolean a(Type type, Type type2) {
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
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
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

    static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return a(type, cls, a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    static Class<?> c(Type type) {
        a(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(c(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return c(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    static boolean d(@Nullable Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (d(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return d(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? c.c.a.b.a.a.f3101h : type.getClass().getName()));
    }

    static String e(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type b(Type type) {
        if (type instanceof ParameterizedType) {
            return a(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
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

    private static int a(Object[] objArr, Object obj) {
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    static Type a(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type typeA = a(type, cls, (TypeVariable<?>) typeVariable);
            if (typeA == typeVariable) {
                return typeA;
            }
            type3 = typeA;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type typeA2 = a(type, cls, (Type) componentType);
                return componentType == typeA2 ? cls2 : new a(typeA2);
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeA3 = a(type, cls, genericComponentType);
            return genericComponentType == typeA3 ? genericArrayType : new a(typeA3);
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeA4 = a(type, cls, ownerType);
            boolean z = typeA4 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i2 = 0; i2 < length; i2++) {
                Type typeA5 = a(type, cls, actualTypeArguments[i2]);
                if (typeA5 != actualTypeArguments[i2]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i2] = typeA5;
                }
            }
            return z ? new b(typeA4, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z2 = type3 instanceof WildcardType;
        Type type4 = type3;
        if (z2) {
            WildcardType wildcardType = (WildcardType) type3;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeA6 = a(type, cls, lowerBounds[0]);
                type4 = wildcardType;
                if (typeA6 != lowerBounds[0]) {
                    return new c(new Type[]{Object.class}, new Type[]{typeA6});
                }
            } else {
                type4 = wildcardType;
                if (upperBounds.length == 1) {
                    Type typeA7 = a(type, cls, upperBounds[0]);
                    type4 = wildcardType;
                    if (typeA7 != upperBounds[0]) {
                        return new c(new Type[]{typeA7}, f17204a);
                    }
                }
            }
        }
        return type4;
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
        return ((ParameterizedType) typeA).getActualTypeArguments()[a(clsA.getTypeParameters(), typeVariable)];
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static void a(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    static <T> T a(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static boolean a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    static ResponseBody a(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().readAll(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), buffer);
    }

    static <T> void a(Class<T> cls) {
        if (cls.isInterface()) {
            if (cls.getInterfaces().length > 0) {
                throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    static Type a(int i2, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i2 >= 0 && i2 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i2];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i2 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    static void a(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
