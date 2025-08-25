package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class be extends m implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f9303d;

    /* renamed from: a, reason: collision with root package name */
    public byte f9304a;

    /* renamed from: b, reason: collision with root package name */
    public String f9305b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f9306c;

    public be() {
        this.f9304a = (byte) 0;
        this.f9305b = "";
        this.f9306c = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.b(this.f9304a, 0);
        lVar.a(this.f9305b, 1);
        byte[] bArr = this.f9306c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    public be(byte b2, String str, byte[] bArr) {
        this.f9304a = (byte) 0;
        this.f9305b = "";
        this.f9306c = null;
        this.f9304a = b2;
        this.f9305b = str;
        this.f9306c = bArr;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9304a = kVar.a(this.f9304a, 0, true);
        this.f9305b = kVar.a(1, true);
        if (f9303d == null) {
            f9303d = new byte[1];
            f9303d[0] = 0;
        }
        this.f9306c = kVar.a(f9303d, 2, false);
    }
}
