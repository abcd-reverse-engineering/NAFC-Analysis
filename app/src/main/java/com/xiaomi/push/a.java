package com.xiaomi.push;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12411a = new a(new byte[0]);

    /* renamed from: a, reason: collision with other field name */
    private volatile int f148a = 0;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f149a;

    private a(byte[] bArr) {
        this.f149a = bArr;
    }

    public int a() {
        return this.f149a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f149a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f149a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.f148a;
        if (i2 == 0) {
            byte[] bArr = this.f149a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i2 = length == 0 ? 1 : length;
            this.f148a = i2;
        }
        return i2;
    }

    public static a a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new a(bArr2);
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m127a() {
        byte[] bArr = this.f149a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
