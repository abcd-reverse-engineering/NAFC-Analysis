package com.umeng.message.proguard;

/* loaded from: classes2.dex */
abstract class at {

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f11306b;

    /* renamed from: c, reason: collision with root package name */
    protected int f11307c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f11308d;

    /* renamed from: e, reason: collision with root package name */
    protected int f11309e;

    /* renamed from: f, reason: collision with root package name */
    protected int f11310f;

    /* renamed from: i, reason: collision with root package name */
    private int f11313i;

    /* renamed from: a, reason: collision with root package name */
    protected final byte f11305a = 61;

    /* renamed from: g, reason: collision with root package name */
    private final int f11311g = 3;

    /* renamed from: h, reason: collision with root package name */
    private final int f11312h = 4;

    protected at() {
    }

    protected final void a(int i2) {
        byte[] bArr = this.f11306b;
        if (bArr == null || bArr.length < this.f11307c + i2) {
            byte[] bArr2 = this.f11306b;
            if (bArr2 == null) {
                this.f11306b = new byte[8192];
                this.f11307c = 0;
                this.f11313i = 0;
            } else {
                byte[] bArr3 = new byte[bArr2.length * 2];
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                this.f11306b = bArr3;
            }
        }
    }

    abstract void a(byte[] bArr, int i2, int i3);

    abstract void b(byte[] bArr, int i2, int i3);

    public byte[] b(String str) {
        return e(str.getBytes());
    }

    public long c(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f11311g;
        return (((length + i2) - 1) / i2) * this.f11312h;
    }

    public byte[] d(byte[] bArr) {
        a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f11307c - this.f11313i];
        a(bArr2, bArr2.length);
        return bArr2;
    }

    public byte[] e(byte[] bArr) {
        a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f11307c];
        a(bArr2, bArr2.length);
        return bArr2;
    }

    private int a(byte[] bArr, int i2) {
        byte[] bArr2 = this.f11306b;
        if (bArr2 == null) {
            return this.f11308d ? -1 : 0;
        }
        int iMin = Math.min(bArr2 != null ? this.f11307c - this.f11313i : 0, i2);
        System.arraycopy(this.f11306b, this.f11313i, bArr, 0, iMin);
        this.f11313i += iMin;
        if (this.f11313i >= this.f11307c) {
            this.f11306b = null;
        }
        return iMin;
    }

    private void a() {
        this.f11306b = null;
        this.f11307c = 0;
        this.f11313i = 0;
        this.f11309e = 0;
        this.f11310f = 0;
        this.f11308d = false;
    }
}
