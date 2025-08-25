package com.google.gson.b0;

import com.google.gson.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class o {
    private o() {
        throw new UnsupportedOperationException();
    }

    public static com.google.gson.k a(com.google.gson.e0.a aVar) throws com.google.gson.n {
        boolean z;
        try {
            try {
                aVar.peek();
                z = false;
                try {
                    return com.google.gson.b0.q.o.V.read2(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return com.google.gson.m.f5749a;
                    }
                    throw new t(e);
                }
            } catch (com.google.gson.e0.e e3) {
                throw new t(e3);
            } catch (IOException e4) {
                throw new com.google.gson.l(e4);
            } catch (NumberFormatException e5) {
                throw new t(e5);
            }
        } catch (EOFException e6) {
            e = e6;
            z = true;
        }
    }

    /* compiled from: Streams.java */
    private static final class b extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f5542a;

        /* renamed from: b, reason: collision with root package name */
        private final a f5543b = new a();

        /* compiled from: Streams.java */
        private static class a implements CharSequence {

            /* renamed from: a, reason: collision with root package name */
            private char[] f5544a;

            /* renamed from: b, reason: collision with root package name */
            private String f5545b;

            private a() {
            }

            void a(char[] cArr) {
                this.f5544a = cArr;
                this.f5545b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.f5544a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f5544a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f5544a, i2, i3 - i2);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f5545b == null) {
                    this.f5545b = new String(this.f5544a);
                }
                return this.f5545b;
            }
        }

        b(Appendable appendable) {
            this.f5542a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            this.f5543b.a(cArr);
            this.f5542a.append(this.f5543b, i2, i3 + i2);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f5542a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.f5542a.append((char) i2);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i2, int i3) throws IOException {
            this.f5542a.append(charSequence, i2, i3);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i2, int i3) throws IOException {
            Objects.requireNonNull(str);
            this.f5542a.append(str, i2, i3 + i2);
        }
    }

    public static void a(com.google.gson.k kVar, com.google.gson.e0.d dVar) throws IOException {
        com.google.gson.b0.q.o.V.write(dVar, kVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }
}
