package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: TypeAdapter.java */
/* loaded from: classes.dex */
public abstract class y<T> {

    /* compiled from: TypeAdapter.java */
    class a extends y<T> {
        a() {
        }

        @Override // com.google.gson.y
        public T read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return (T) y.this.read(aVar);
            }
            aVar.r();
            return null;
        }

        @Override // com.google.gson.y
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            if (t == null) {
                dVar.j();
            } else {
                y.this.write(dVar, t);
            }
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new com.google.gson.e0.a(reader));
    }

    public final T fromJsonTree(k kVar) {
        try {
            return read(new com.google.gson.b0.q.f(kVar));
        } catch (IOException e2) {
            throw new l(e2);
        }
    }

    public final y<T> nullSafe() {
        return new a();
    }

    public abstract T read(com.google.gson.e0.a aVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new com.google.gson.e0.d(writer), t);
    }

    public final k toJsonTree(T t) {
        try {
            com.google.gson.b0.q.g gVar = new com.google.gson.b0.q.g();
            write(gVar, t);
            return gVar.k();
        } catch (IOException e2) {
            throw new l(e2);
        }
    }

    public abstract void write(com.google.gson.e0.d dVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new l(e2);
        }
    }
}
