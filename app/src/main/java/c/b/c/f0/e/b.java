package c.b.c.f0.e;

import java.lang.reflect.Array;

/* compiled from: ByteMatrix.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f2800a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2801b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2802c;

    public b(int i2, int i3) {
        this.f2800a = (byte[][]) Array.newInstance((Class<?>) byte.class, i3, i2);
        this.f2801b = i2;
        this.f2802c = i3;
    }

    public byte a(int i2, int i3) {
        return this.f2800a[i3][i2];
    }

    public int b() {
        return this.f2802c;
    }

    public int c() {
        return this.f2801b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f2801b * 2 * this.f2802c) + 2);
        for (int i2 = 0; i2 < this.f2802c; i2++) {
            for (int i3 = 0; i3 < this.f2801b; i3++) {
                byte b2 = this.f2800a[i2][i3];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public byte[][] a() {
        return this.f2800a;
    }

    public void a(int i2, int i3, byte b2) {
        this.f2800a[i3][i2] = b2;
    }

    public void a(int i2, int i3, int i4) {
        this.f2800a[i3][i2] = (byte) i4;
    }

    public void a(int i2, int i3, boolean z) {
        this.f2800a[i3][i2] = z ? (byte) 1 : (byte) 0;
    }

    public void a(byte b2) {
        for (int i2 = 0; i2 < this.f2802c; i2++) {
            for (int i3 = 0; i3 < this.f2801b; i3++) {
                this.f2800a[i2][i3] = b2;
            }
        }
    }
}
