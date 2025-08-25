package com.xiaomi.push;

/* loaded from: classes2.dex */
public class ii extends ik {

    /* renamed from: a, reason: collision with root package name */
    private int f13245a;

    /* renamed from: a, reason: collision with other field name */
    private hs f906a;

    public ii(int i2) {
        this.f906a = new hs(i2);
    }

    @Override // com.xiaomi.push.ik
    public int a(byte[] bArr, int i2, int i3) {
        byte[] bArrM599a = this.f906a.m599a();
        if (i3 > this.f906a.a() - this.f13245a) {
            i3 = this.f906a.a() - this.f13245a;
        }
        if (i3 > 0) {
            System.arraycopy(bArrM599a, this.f13245a, bArr, i2, i3);
            this.f13245a += i3;
        }
        return i3;
    }

    @Override // com.xiaomi.push.ik
    /* renamed from: a */
    public void mo622a(byte[] bArr, int i2, int i3) {
        this.f906a.write(bArr, i2, i3);
    }

    public int a() {
        return this.f906a.size();
    }
}
