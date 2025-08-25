package androidx.core.util;

import androidx.annotation.RequiresApi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.s.l;
import h.q2.t.f0;
import h.q2.t.i0;
import h.y;
import h.y1;
import h.z2.f;
import i.c.a.d;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: AtomicFile.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\b\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    @d
    public static final byte[] readBytes(@d android.util.AtomicFile atomicFile) throws IOException {
        i0.f(atomicFile, "$receiver");
        byte[] fully = atomicFile.readFully();
        i0.a((Object) fully, "readFully()");
        return fully;
    }

    @RequiresApi(17)
    @d
    public static final String readText(@d android.util.AtomicFile atomicFile, @d Charset charset) throws IOException {
        i0.f(atomicFile, "$receiver");
        i0.f(charset, "charset");
        byte[] fully = atomicFile.readFully();
        i0.a((Object) fully, "readFully()");
        return new String(fully, charset);
    }

    @RequiresApi(17)
    @d
    public static /* bridge */ /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = f.f16682a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@d android.util.AtomicFile atomicFile, @d l<? super FileOutputStream, y1> lVar) throws IOException {
        i0.f(atomicFile, "$receiver");
        i0.f(lVar, "block");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            i0.a((Object) fileOutputStreamStartWrite, "stream");
            lVar.invoke(fileOutputStreamStartWrite);
            f0.b(1);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
            f0.a(1);
        } catch (Throwable th) {
            f0.b(1);
            atomicFile.failWrite(fileOutputStreamStartWrite);
            f0.a(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@d android.util.AtomicFile atomicFile, @d byte[] bArr) throws IOException {
        i0.f(atomicFile, "$receiver");
        i0.f(bArr, "array");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            i0.a((Object) fileOutputStreamStartWrite, "stream");
            fileOutputStreamStartWrite.write(bArr);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@d android.util.AtomicFile atomicFile, @d String str, @d Charset charset) throws IOException {
        i0.f(atomicFile, "$receiver");
        i0.f(str, "text");
        i0.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    @RequiresApi(17)
    public static /* bridge */ /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = f.f16682a;
        }
        writeText(atomicFile, str, charset);
    }
}
