package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Interpreter.java */
/* loaded from: classes2.dex */
public final class c implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    NativeInterpreterWrapper f17519a;

    /* compiled from: Interpreter.java */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        Boolean f17521b;

        /* renamed from: c, reason: collision with root package name */
        Boolean f17522c;

        /* renamed from: d, reason: collision with root package name */
        Boolean f17523d;

        /* renamed from: a, reason: collision with root package name */
        int f17520a = -1;

        /* renamed from: e, reason: collision with root package name */
        final List<b> f17524e = new ArrayList();

        public a a(int i2) {
            this.f17520a = i2;
            return this;
        }

        public a b(boolean z) {
            this.f17522c = Boolean.valueOf(z);
            return this;
        }

        public a c(boolean z) {
            this.f17521b = Boolean.valueOf(z);
            return this;
        }

        public a a(b bVar) {
            this.f17524e.add(bVar);
            return this;
        }

        public a a(boolean z) {
            this.f17523d = Boolean.valueOf(z);
            return this;
        }
    }

    public c(File file) {
        this(file, (a) null);
    }

    private void f() {
        if (this.f17519a == null) {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }

    public void a(Object obj, Object obj2) {
        Object[] objArr = {obj};
        HashMap map = new HashMap();
        map.put(0, obj2);
        a(objArr, (Map<Integer, Object>) map);
    }

    public int b(String str) {
        f();
        return this.f17519a.b(str);
    }

    public int c() {
        f();
        return this.f17519a.c();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.f17519a;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.close();
            this.f17519a = null;
        }
    }

    public Long d() {
        f();
        return this.f17519a.d();
    }

    public int e() {
        f();
        return this.f17519a.e();
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Deprecated
    public c(File file, int i2) {
        this(file, new a().a(i2));
    }

    public c(File file, a aVar) {
        this.f17519a = new NativeInterpreterWrapper(file.getAbsolutePath(), aVar);
    }

    public Tensor b(int i2) {
        f();
        return this.f17519a.d(i2);
    }

    @Deprecated
    public void c(int i2) {
        f();
        this.f17519a.e(i2);
    }

    public void a(Object[] objArr, Map<Integer, Object> map) {
        f();
        this.f17519a.a(objArr, map);
    }

    public c(ByteBuffer byteBuffer) {
        this(byteBuffer, (a) null);
    }

    @Deprecated
    public c(ByteBuffer byteBuffer, int i2) {
        this(byteBuffer, new a().a(i2));
    }

    public void a(int i2, int[] iArr) {
        f();
        this.f17519a.a(i2, iArr);
    }

    @Deprecated
    public c(MappedByteBuffer mappedByteBuffer) {
        this(mappedByteBuffer, (a) null);
    }

    public c(ByteBuffer byteBuffer, a aVar) {
        this.f17519a = new NativeInterpreterWrapper(byteBuffer, aVar);
    }

    public int a(String str) {
        f();
        return this.f17519a.a(str);
    }

    public Tensor a(int i2) {
        f();
        return this.f17519a.a(i2);
    }

    @Deprecated
    public void a(boolean z) {
        f();
        this.f17519a.a(z);
    }

    public void a(b bVar) {
        f();
        this.f17519a.a(bVar);
    }
}
