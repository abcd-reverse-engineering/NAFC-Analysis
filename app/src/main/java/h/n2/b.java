package h.n2;

import h.e1;
import h.o0;
import h.q2.t.i0;
import h.t0;
import h.y;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;

/* compiled from: IOStreams.kt */
@h.q2.e(name = "ByteStreamsKt")
@y(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class b {

    /* compiled from: IOStreams.kt */
    public static final class a extends h.g2.u {

        /* renamed from: a, reason: collision with root package name */
        private int f16319a = -1;

        /* renamed from: b, reason: collision with root package name */
        private boolean f16320b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f16321c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BufferedInputStream f16322d;

        a(BufferedInputStream bufferedInputStream) {
            this.f16322d = bufferedInputStream;
        }

        private final void f() {
            if (this.f16320b || this.f16321c) {
                return;
            }
            this.f16319a = this.f16322d.read();
            this.f16320b = true;
            this.f16321c = this.f16319a == -1;
        }

        public final void a(int i2) {
            this.f16319a = i2;
        }

        public final void b(boolean z) {
            this.f16320b = z;
        }

        public final boolean c() {
            return this.f16321c;
        }

        public final int d() {
            return this.f16319a;
        }

        public final boolean e() {
            return this.f16320b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            f();
            return !this.f16321c;
        }

        public final void a(boolean z) {
            this.f16321c = z;
        }

        @Override // h.g2.u
        public byte b() {
            f();
            if (this.f16321c) {
                throw new NoSuchElementException("Input stream is over.");
            }
            byte b2 = (byte) this.f16319a;
            this.f16320b = false;
            return b2;
        }
    }

    @i.c.a.d
    public static final h.g2.u a(@i.c.a.d BufferedInputStream bufferedInputStream) {
        i0.f(bufferedInputStream, "$this$iterator");
        return new a(bufferedInputStream);
    }

    @h.m2.f
    private static final InputStreamReader b(@i.c.a.d InputStream inputStream, Charset charset) {
        return new InputStreamReader(inputStream, charset);
    }

    @h.m2.f
    private static final ByteArrayInputStream a(@i.c.a.d String str, Charset charset) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ InputStreamReader b(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ ByteArrayInputStream a(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    @h.m2.f
    private static final OutputStreamWriter b(@i.c.a.d OutputStream outputStream, Charset charset) {
        return new OutputStreamWriter(outputStream, charset);
    }

    @h.m2.f
    private static final ByteArrayInputStream a(@i.c.a.d byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    static /* synthetic */ OutputStreamWriter b(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        return new OutputStreamWriter(outputStream, charset);
    }

    @h.m2.f
    private static final ByteArrayInputStream a(@i.c.a.d byte[] bArr, int i2, int i3) {
        return new ByteArrayInputStream(bArr, i2, i3);
    }

    @h.m2.f
    private static final BufferedInputStream a(@i.c.a.d InputStream inputStream, int i2) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    public static /* synthetic */ byte[] b(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return b(inputStream, i2);
    }

    @h.m2.f
    private static final BufferedReader a(@i.c.a.d InputStream inputStream, Charset charset) {
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @h.c(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @o0(expression = "readBytes()", imports = {}))
    @i.c.a.d
    public static final byte[] b(@i.c.a.d InputStream inputStream, int i2) {
        i0.f(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i2, inputStream.available()));
        a(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        i0.a((Object) byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    static /* synthetic */ BufferedReader a(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @h.m2.f
    private static final BufferedOutputStream a(@i.c.a.d OutputStream outputStream, int i2) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    @h.m2.f
    private static final BufferedWriter a(@i.c.a.d OutputStream outputStream, Charset charset) {
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    static /* synthetic */ BufferedWriter a(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    public static /* synthetic */ long a(InputStream inputStream, OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return a(inputStream, outputStream, i2);
    }

    public static final long a(@i.c.a.d InputStream inputStream, @i.c.a.d OutputStream outputStream, int i2) throws IOException {
        i0.f(inputStream, "$this$copyTo");
        i0.f(outputStream, "out");
        byte[] bArr = new byte[i2];
        int i3 = inputStream.read(bArr);
        long j2 = 0;
        while (i3 >= 0) {
            outputStream.write(bArr, 0, i3);
            j2 += i3;
            i3 = inputStream.read(bArr);
        }
        return j2;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final byte[] a(@i.c.a.d InputStream inputStream) {
        i0.f(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        a(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        i0.a((Object) byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    static /* synthetic */ BufferedInputStream a(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    static /* synthetic */ BufferedOutputStream a(OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }
}
