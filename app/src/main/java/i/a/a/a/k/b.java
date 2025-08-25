package i.a.a.a.k;

import java.io.InputStream;

/* compiled from: Base32InputStream.java */
/* loaded from: classes2.dex */
public class b extends h {
    public b(InputStream inputStream) {
        this(inputStream, false);
    }

    public b(InputStream inputStream, boolean z) {
        super(inputStream, new a(false), z);
    }

    public b(InputStream inputStream, boolean z, int i2, byte[] bArr) {
        super(inputStream, new a(i2, bArr), z);
    }
}
