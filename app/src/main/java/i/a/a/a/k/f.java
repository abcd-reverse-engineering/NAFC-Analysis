package i.a.a.a.k;

import java.io.OutputStream;

/* compiled from: Base64OutputStream.java */
/* loaded from: classes2.dex */
public class f extends i {
    public f(OutputStream outputStream) {
        this(outputStream, true);
    }

    public f(OutputStream outputStream, boolean z) {
        super(outputStream, new d(false), z);
    }

    public f(OutputStream outputStream, boolean z, int i2, byte[] bArr) {
        super(outputStream, new d(i2, bArr), z);
    }
}
