package com.xiaomi.push;

/* loaded from: classes2.dex */
public abstract class ik {
    public abstract int a(byte[] bArr, int i2, int i3);

    public void a(int i2) {
    }

    /* renamed from: a */
    public abstract void mo622a(byte[] bArr, int i2, int i3);

    public byte[] a() {
        return null;
    }

    public int a_() {
        return 0;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i2, int i3) throws il {
        int i4 = 0;
        while (i4 < i3) {
            int iA = a(bArr, i2 + i4, i3 - i4);
            if (iA <= 0) {
                throw new il("Cannot read. Remote side has closed. Tried to read " + i3 + " bytes, but only got " + i4 + " bytes.");
            }
            i4 += iA;
        }
        return i4;
    }
}
