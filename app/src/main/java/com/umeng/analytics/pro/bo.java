package com.umeng.analytics.pro;

/* compiled from: ShortStack.java */
/* loaded from: classes2.dex */
public class bo {

    /* renamed from: a, reason: collision with root package name */
    private short[] f10180a;

    /* renamed from: b, reason: collision with root package name */
    private int f10181b = -1;

    public bo(int i2) {
        this.f10180a = new short[i2];
    }

    private void d() {
        short[] sArr = this.f10180a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f10180a = sArr2;
    }

    public short a() {
        short[] sArr = this.f10180a;
        int i2 = this.f10181b;
        this.f10181b = i2 - 1;
        return sArr[i2];
    }

    public short b() {
        return this.f10180a[this.f10181b];
    }

    public void c() {
        this.f10181b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i2 = 0; i2 < this.f10180a.length; i2++) {
            if (i2 != 0) {
                sb.append(c.c.a.b.a.a.f3100g);
            }
            if (i2 == this.f10181b) {
                sb.append(">>");
            }
            sb.append((int) this.f10180a[i2]);
            if (i2 == this.f10181b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s) {
        if (this.f10180a.length == this.f10181b + 1) {
            d();
        }
        short[] sArr = this.f10180a;
        int i2 = this.f10181b + 1;
        this.f10181b = i2;
        sArr[i2] = s;
    }
}
