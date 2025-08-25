package com.google.gson.b0.q;

import com.google.gson.JsonObject;
import com.google.gson.p;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class g extends com.google.gson.e0.d {
    private static final Writer p = new a();
    private static final p q = new p("closed");

    /* renamed from: m, reason: collision with root package name */
    private final List<com.google.gson.k> f5567m;
    private String n;
    private com.google.gson.k o;

    /* compiled from: JsonTreeWriter.java */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public g() {
        super(p);
        this.f5567m = new ArrayList();
        this.o = com.google.gson.m.f5749a;
    }

    private void a(com.google.gson.k kVar) {
        if (this.n != null) {
            if (!kVar.isJsonNull() || g()) {
                ((JsonObject) peek()).add(this.n, kVar);
            }
            this.n = null;
            return;
        }
        if (this.f5567m.isEmpty()) {
            this.o = kVar;
            return;
        }
        com.google.gson.k kVarPeek = peek();
        if (!(kVarPeek instanceof com.google.gson.h)) {
            throw new IllegalStateException();
        }
        ((com.google.gson.h) kVarPeek).a(kVar);
    }

    private com.google.gson.k peek() {
        return this.f5567m.get(r0.size() - 1);
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d b(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f5567m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.n = str;
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d c() throws IOException {
        com.google.gson.h hVar = new com.google.gson.h();
        a(hVar);
        this.f5567m.add(hVar);
        return this;
    }

    @Override // com.google.gson.e0.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f5567m.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f5567m.add(q);
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d d() throws IOException {
        JsonObject jsonObject = new JsonObject();
        a(jsonObject);
        this.f5567m.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d e() throws IOException {
        if (this.f5567m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof com.google.gson.h)) {
            throw new IllegalStateException();
        }
        this.f5567m.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d f() throws IOException {
        if (this.f5567m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.f5567m.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.e0.d, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d j() throws IOException {
        a(com.google.gson.m.f5749a);
        return this;
    }

    public com.google.gson.k k() {
        if (this.f5567m.isEmpty()) {
            return this.o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f5567m);
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d d(String str) throws IOException {
        if (str == null) {
            return j();
        }
        a(new p(str));
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d d(boolean z) throws IOException {
        a(new p(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d a(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d a(Boolean bool) throws IOException {
        if (bool == null) {
            return j();
        }
        a(new p(bool));
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d a(float f2) throws IOException {
        if (!i() && (Float.isNaN(f2) || Float.isInfinite(f2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f2);
        }
        a(new p(Float.valueOf(f2)));
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d a(double d2) throws IOException {
        if (!i() && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
        }
        a(new p(Double.valueOf(d2)));
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d a(long j2) throws IOException {
        a(new p(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.e0.d
    public com.google.gson.e0.d a(Number number) throws IOException {
        if (number == null) {
            return j();
        }
        if (!i()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new p(number));
        return this;
    }
}
