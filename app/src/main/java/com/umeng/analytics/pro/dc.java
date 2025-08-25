package com.umeng.analytics.pro;

/* compiled from: TMemoryInputTransport.java */
/* loaded from: classes2.dex */
public final class dc extends dd {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f10319a;

    /* renamed from: b, reason: collision with root package name */
    private int f10320b;

    /* renamed from: c, reason: collision with root package name */
    private int f10321c;

    public dc() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.dd
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.dd
    public void b() throws de {
    }

    @Override // com.umeng.analytics.pro.dd
    public void b(byte[] bArr, int i2, int i3) throws de {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.dd
    public void c() {
    }

    public void c(byte[] bArr, int i2, int i3) {
        this.f10319a = bArr;
        this.f10320b = i2;
        this.f10321c = i2 + i3;
    }

    public void e() {
        this.f10319a = null;
    }

    @Override // com.umeng.analytics.pro.dd
    public byte[] f() {
        return this.f10319a;
    }

    @Override // com.umeng.analytics.pro.dd
    public int g() {
        return this.f10320b;
    }

    @Override // com.umeng.analytics.pro.dd
    public int h() {
        return this.f10321c - this.f10320b;
    }

    public dc(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.dd
    public int a(byte[] bArr, int i2, int i3) throws de {
        int iH = h();
        if (i3 > iH) {
            i3 = iH;
        }
        if (i3 > 0) {
            System.arraycopy(this.f10319a, this.f10320b, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    public dc(byte[] bArr, int i2, int i3) {
        c(bArr, i2, i3);
    }

    @Override // com.umeng.analytics.pro.dd
    public void a(int i2) {
        this.f10320b += i2;
    }
}
