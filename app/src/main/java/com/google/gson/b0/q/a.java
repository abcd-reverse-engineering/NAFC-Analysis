package com.google.gson.b0.q;

import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<E> extends y<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final z f5552c = new C0086a();

    /* renamed from: a, reason: collision with root package name */
    private final Class<E> f5553a;

    /* renamed from: b, reason: collision with root package name */
    private final y<E> f5554b;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.a$a, reason: collision with other inner class name */
    class C0086a implements z {
        C0086a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeD = com.google.gson.b0.b.d(type);
            return new a(eVar, eVar.a((com.google.gson.d0.a) com.google.gson.d0.a.get(typeD)), com.google.gson.b0.b.e(typeD));
        }
    }

    public a(com.google.gson.e eVar, y<E> yVar, Class<E> cls) {
        this.f5554b = new n(eVar, yVar, cls);
        this.f5553a = cls;
    }

    @Override // com.google.gson.y
    /* renamed from: read */
    public Object read2(com.google.gson.e0.a aVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (aVar.peek() == com.google.gson.e0.c.NULL) {
            aVar.r();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.c();
        while (aVar.j()) {
            arrayList.add(this.f5554b.read2(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        if (!this.f5553a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f5553a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.f5553a, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.y
    public void write(com.google.gson.e0.d dVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            dVar.j();
            return;
        }
        dVar.c();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f5554b.write(dVar, Array.get(obj, i2));
        }
        dVar.e();
    }
}
