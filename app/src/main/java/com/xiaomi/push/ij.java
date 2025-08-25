package com.xiaomi.push;

/* loaded from: classes2.dex */
public final class ij extends ik {

    /* renamed from: a, reason: collision with root package name */
    private int f13246a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f907a;

    /* renamed from: b, reason: collision with root package name */
    private int f13247b;

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.ik
    public int a_() {
        return this.f13246a;
    }

    public void b(byte[] bArr, int i2, int i3) {
        this.f907a = bArr;
        this.f13246a = i2;
        this.f13247b = i2 + i3;
    }

    @Override // com.xiaomi.push.ik
    public int a(byte[] bArr, int i2, int i3) {
        int iB = b();
        if (i3 > iB) {
            i3 = iB;
        }
        if (i3 > 0) {
            System.arraycopy(this.f907a, this.f13246a, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    @Override // com.xiaomi.push.ik
    public int b() {
        return this.f13247b - this.f13246a;
    }

    @Override // com.xiaomi.push.ik
    /* renamed from: a */
    public void mo622a(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.ik
    public byte[] a() {
        return this.f907a;
    }

    @Override // com.xiaomi.push.ik
    public void a(int i2) {
        this.f13246a += i2;
    }
}
