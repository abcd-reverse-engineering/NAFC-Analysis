package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* compiled from: FieldAttributes.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Field f5479a;

    public b(Field field) {
        this.f5479a = (Field) Objects.requireNonNull(field);
    }

    public <T extends Annotation> T a(Class<T> cls) {
        return (T) this.f5479a.getAnnotation(cls);
    }

    public Class<?> b() {
        return this.f5479a.getType();
    }

    public Type c() {
        return this.f5479a.getGenericType();
    }

    public Class<?> d() {
        return this.f5479a.getDeclaringClass();
    }

    public String e() {
        return this.f5479a.getName();
    }

    public String toString() {
        return this.f5479a.toString();
    }

    public Collection<Annotation> a() {
        return Arrays.asList(this.f5479a.getAnnotations());
    }

    public boolean a(int i2) {
        return (i2 & this.f5479a.getModifiers()) != 0;
    }
}
