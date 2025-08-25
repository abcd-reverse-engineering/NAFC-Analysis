package i.a.a.a.k;

import java.io.InputStream;

/* compiled from: Base64InputStream.java */
/* loaded from: classes2.dex */
public class e extends h {
    public e(InputStream inputStream) {
        this(inputStream, false);
    }

    public e(InputStream inputStream, boolean z) {
        super(inputStream, new d(false), z);
    }

    public e(InputStream inputStream, boolean z, int i2, byte[] bArr) {
        super(inputStream, new d(i2, bArr), z);
    }
}
