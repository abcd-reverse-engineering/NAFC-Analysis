package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: JsonStreamParser.java */
/* loaded from: classes.dex */
public final class s implements Iterator<k> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e0.a f5751a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f5752b;

    public s(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.f5752b) {
            try {
                try {
                    z = this.f5751a.peek() != com.google.gson.e0.c.END_DOCUMENT;
                } catch (com.google.gson.e0.e e2) {
                    throw new t(e2);
                } catch (IOException e3) {
                    throw new l(e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public s(Reader reader) {
        this.f5751a = new com.google.gson.e0.a(reader);
        this.f5751a.a(true);
        this.f5752b = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public k next() throws n {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return com.google.gson.b0.o.a(this.f5751a);
        } catch (OutOfMemoryError e2) {
            throw new n("Failed parsing JSON source to Json", e2);
        } catch (StackOverflowError e3) {
            throw new n("Failed parsing JSON source to Json", e3);
        }
    }
}
