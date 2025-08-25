package i.a.a.a.k;

import java.io.OutputStream;

/* compiled from: Base32OutputStream.java */
/* loaded from: classes2.dex */
public class c extends i {
    public c(OutputStream outputStream) {
        this(outputStream, true);
    }

    public c(OutputStream outputStream, boolean z) {
        super(outputStream, new a(false), z);
    }

    public c(OutputStream outputStream, boolean z, int i2, byte[] bArr) {
        super(outputStream, new a(i2, bArr), z);
    }
}
