package h.n2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.o;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.t.f0;
import h.q2.t.i0;
import h.q2.t.j0;
import h.y;
import h.y1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: FileReadWrite.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001a!\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001aB\u0010\u0010\u001a\u00020\u0001*\u00020\u000226\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001aJ\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001a7\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0017\u0010\u001f\u001a\u00020 *\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001a\n\u0010!\u001a\u00020\u0004*\u00020\u0002\u001a\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010$\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010%\u001a\u00020&*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001a?\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u0002H(0\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010,\u001a\u0012\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010/\u001a\u000200*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u0082\u0002\b\n\u0006\b\u0011(+0\u0001¨\u00061"}, d2 = {"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/io/FilesKt")
/* loaded from: classes2.dex */
class p extends o {

    /* compiled from: FileReadWrite.kt */
    static final class a extends j0 implements h.q2.s.l<String, y1> {
        final /* synthetic */ ArrayList $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList) {
            super(1);
            this.$result = arrayList;
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ y1 invoke(String str) {
            invoke2(str);
            return y1.f16671a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@i.c.a.d String str) {
            i0.f(str, "it");
            this.$result.add(str);
        }
    }

    static /* synthetic */ BufferedReader a(File file, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i2);
    }

    static /* synthetic */ BufferedWriter b(File file, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i2);
    }

    @i.c.a.d
    public static final String c(@i.c.a.d File file, @i.c.a.d Charset charset) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$readText");
        i0.f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strB = x.b(inputStreamReader);
            c.a(inputStreamReader, (Throwable) null);
            return strB;
        } finally {
        }
    }

    static /* synthetic */ InputStreamReader d(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    static /* synthetic */ OutputStreamWriter e(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    @h.m2.f
    private static final FileOutputStream f(@i.c.a.d File file) {
        return new FileOutputStream(file);
    }

    @i.c.a.d
    public static final byte[] g(@i.c.a.d File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$readBytes");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i2 = (int) length;
            byte[] bArrA = new byte[i2];
            int i3 = 0;
            while (i2 > 0) {
                int i4 = fileInputStream.read(bArrA, i3, i2);
                if (i4 < 0) {
                    break;
                }
                i2 -= i4;
                i3 += i4;
            }
            if (i2 > 0) {
                bArrA = Arrays.copyOf(bArrA, i3);
                i0.a((Object) bArrA, "java.util.Arrays.copyOf(this, newSize)");
            } else {
                int i5 = fileInputStream.read();
                if (i5 != -1) {
                    g gVar = new g(o.a.q);
                    gVar.write(i5);
                    b.a(fileInputStream, gVar, 0, 2, null);
                    int length2 = bArrA.length + gVar.size();
                    if (length2 < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] buffer = gVar.getBuffer();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrA, length2);
                    i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                    bArrA = h.g2.q.a(buffer, bArrCopyOf, bArrA.length, 0, gVar.size());
                }
            }
            c.a(fileInputStream, (Throwable) null);
            return bArrA;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ String c(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        return c(file, charset);
    }

    @h.m2.f
    private static final BufferedReader a(@i.c.a.d File file, Charset charset, int i2) {
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i2);
    }

    @h.m2.f
    private static final BufferedWriter b(@i.c.a.d File file, Charset charset, int i2) {
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i2);
    }

    @h.m2.f
    private static final InputStreamReader d(@i.c.a.d File file, Charset charset) {
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    @h.m2.f
    private static final OutputStreamWriter e(@i.c.a.d File file, Charset charset) {
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    static /* synthetic */ PrintWriter a(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    public static final void b(@i.c.a.d File file, @i.c.a.d byte[] bArr) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$writeBytes");
        i0.f(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            y1 y1Var = y1.f16671a;
            c.a(fileOutputStream, (Throwable) null);
        } finally {
        }
    }

    @h.m2.f
    private static final FileInputStream e(@i.c.a.d File file) {
        return new FileInputStream(file);
    }

    public static final void b(@i.c.a.d File file, @i.c.a.d String str, @i.c.a.d Charset charset) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$writeText");
        i0.f(str, "text");
        i0.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        b(file, bytes);
    }

    @h.m2.f
    private static final PrintWriter a(@i.c.a.d File file, Charset charset) {
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    public static /* synthetic */ void b(File file, String str, Charset charset, int i2, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if ((i2 & 2) != 0) {
            charset = h.z2.f.f16682a;
        }
        b(file, str, charset);
    }

    public static final void a(@i.c.a.d File file, @i.c.a.d byte[] bArr) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$appendBytes");
        i0.f(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(bArr);
            y1 y1Var = y1.f16671a;
            c.a(fileOutputStream, (Throwable) null);
        } finally {
        }
    }

    public static /* synthetic */ List b(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        return b(file, charset);
    }

    public static final void a(@i.c.a.d File file, @i.c.a.d String str, @i.c.a.d Charset charset) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$appendText");
        i0.f(str, "text");
        i0.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        a(file, bytes);
    }

    @i.c.a.d
    public static final List<String> b(@i.c.a.d File file, @i.c.a.d Charset charset) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$readLines");
        i0.f(charset, "charset");
        ArrayList arrayList = new ArrayList();
        a(file, charset, new a(arrayList));
        return arrayList;
    }

    public static /* synthetic */ void a(File file, String str, Charset charset, int i2, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if ((i2 & 2) != 0) {
            charset = h.z2.f.f16682a;
        }
        a(file, str, charset);
    }

    public static final void a(@i.c.a.d File file, @i.c.a.d h.q2.s.p<? super byte[], ? super Integer, y1> pVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$forEachBlock");
        i0.f(pVar, "action");
        a(file, 4096, pVar);
    }

    public static /* synthetic */ Object b(File file, Charset charset, h.q2.s.l lVar, int i2, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        i0.f(file, "$this$useLines");
        i0.f(charset, "charset");
        i0.f(lVar, "block");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            Object objInvoke = lVar.invoke(x.a(bufferedReader));
            f0.b(1);
            if (h.m2.l.a(1, 1, 0)) {
                c.a(bufferedReader, (Throwable) null);
            } else {
                bufferedReader.close();
            }
            f0.a(1);
            return objInvoke;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void a(@i.c.a.d File file, int i2, @i.c.a.d h.q2.s.p<? super byte[], ? super Integer, y1> pVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$forEachBlock");
        i0.f(pVar, "action");
        ?? r2 = new byte[h.v2.q.a(i2, 512)];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i3 = fileInputStream.read(r2);
                if (i3 <= 0) {
                    y1 y1Var = y1.f16671a;
                    c.a(fileInputStream, (Throwable) null);
                    return;
                }
                pVar.invoke(r2, Integer.valueOf(i3));
            } finally {
            }
        }
    }

    public static final <T> T b(@i.c.a.d File file, @i.c.a.d Charset charset, @i.c.a.d h.q2.s.l<? super h.x2.m<String>, ? extends T> lVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$useLines");
        i0.f(charset, "charset");
        i0.f(lVar, "block");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            T tInvoke = lVar.invoke(x.a(bufferedReader));
            f0.b(1);
            if (h.m2.l.a(1, 1, 0)) {
                c.a(bufferedReader, (Throwable) null);
            } else {
                bufferedReader.close();
            }
            f0.a(1);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f0.b(1);
                if (h.m2.l.a(1, 1, 0)) {
                    c.a(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                f0.a(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void a(File file, Charset charset, h.q2.s.l lVar, int i2, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if ((i2 & 1) != 0) {
            charset = h.z2.f.f16682a;
        }
        a(file, charset, (h.q2.s.l<? super String, y1>) lVar);
    }

    public static final void a(@i.c.a.d File file, @i.c.a.d Charset charset, @i.c.a.d h.q2.s.l<? super String, y1> lVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i0.f(file, "$this$forEachLine");
        i0.f(charset, "charset");
        i0.f(lVar, "action");
        x.a(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), lVar);
    }
}
