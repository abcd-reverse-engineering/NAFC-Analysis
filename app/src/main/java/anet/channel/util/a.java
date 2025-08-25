package anet.channel.util;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f2043a;

    /* renamed from: b, reason: collision with root package name */
    private long f2044b = 0;

    public a(InputStream inputStream) {
        this.f2043a = null;
        if (inputStream == null) {
            throw new NullPointerException("input stream cannot be null");
        }
        this.f2043a = inputStream;
    }

    public long a() {
        return this.f2044b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.f2044b++;
        return this.f2043a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f2043a.read(bArr, i2, i3);
        if (i4 != -1) {
            this.f2044b += i4;
        }
        return i4;
    }
}
