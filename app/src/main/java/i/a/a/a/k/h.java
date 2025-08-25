package i.a.a.a.k;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: BaseNCodecInputStream.java */
/* loaded from: classes2.dex */
public class h extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f16749a;

    /* renamed from: b, reason: collision with root package name */
    private final g f16750b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f16751c;

    protected h(InputStream inputStream, g gVar, boolean z) {
        super(inputStream);
        this.f16751c = new byte[1];
        this.f16749a = z;
        this.f16750b = gVar;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = read(this.f16751c, 0, 1);
        while (i2 == 0) {
            i2 = read(this.f16751c, 0, 1);
        }
        if (i2 <= 0) {
            return -1;
        }
        byte[] bArr = this.f16751c;
        return bArr[0] < 0 ? bArr[0] + 256 : bArr[0];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i2 >= 0 && i3 >= 0) {
            if (i2 > bArr.length || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            int iC = 0;
            while (iC == 0) {
                if (!this.f16750b.c()) {
                    byte[] bArr2 = new byte[this.f16749a ? 4096 : 8192];
                    int i4 = ((FilterInputStream) this).in.read(bArr2);
                    if (this.f16749a) {
                        this.f16750b.b(bArr2, 0, i4);
                    } else {
                        this.f16750b.a(bArr2, 0, i4);
                    }
                }
                iC = this.f16750b.c(bArr, i2, i3);
            }
            return iC;
        }
        throw new IndexOutOfBoundsException();
    }
}
