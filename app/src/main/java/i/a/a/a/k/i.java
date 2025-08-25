package i.a.a.a.k;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BaseNCodecOutputStream.java */
/* loaded from: classes2.dex */
public class i extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f16752a;

    /* renamed from: b, reason: collision with root package name */
    private final g f16753b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f16754c;

    public i(OutputStream outputStream, g gVar, boolean z) {
        super(outputStream);
        this.f16754c = new byte[1];
        this.f16753b = gVar;
        this.f16752a = z;
    }

    private void a(boolean z) throws IOException {
        byte[] bArr;
        int iC;
        int iA = this.f16753b.a();
        if (iA > 0 && (iC = this.f16753b.c((bArr = new byte[iA]), 0, iA)) > 0) {
            ((FilterOutputStream) this).out.write(bArr, 0, iC);
        }
        if (z) {
            ((FilterOutputStream) this).out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f16752a) {
            this.f16753b.b(this.f16754c, 0, -1);
        } else {
            this.f16753b.a(this.f16754c, 0, -1);
        }
        flush();
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a(true);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f16754c;
        bArr[0] = (byte) i2;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i2 >= 0 && i3 >= 0) {
            if (i2 > bArr.length || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 > 0) {
                if (this.f16752a) {
                    this.f16753b.b(bArr, i2, i3);
                } else {
                    this.f16753b.a(bArr, i2, i3);
                }
                a(false);
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
