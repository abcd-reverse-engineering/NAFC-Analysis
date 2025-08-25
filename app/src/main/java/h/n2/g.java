package h.n2;

import h.q2.t.i0;
import java.io.ByteArrayOutputStream;

/* compiled from: FileReadWrite.kt */
/* loaded from: classes2.dex */
final class g extends ByteArrayOutputStream {
    public g(int i2) {
        super(i2);
    }

    @i.c.a.d
    public final byte[] getBuffer() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        i0.a((Object) bArr, "buf");
        return bArr;
    }
}
