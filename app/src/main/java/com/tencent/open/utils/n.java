package com.tencent.open.utils;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public final class n implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private long f9948a;

    public n(long j2) {
        this.f9948a = j2;
    }

    public byte[] a() {
        long j2 = this.f9948a;
        return new byte[]{(byte) (255 & j2), (byte) ((65280 & j2) >> 8), (byte) ((16711680 & j2) >> 16), (byte) ((j2 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f9948a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof n) && this.f9948a == ((n) obj).b();
    }

    public int hashCode() {
        return (int) this.f9948a;
    }
}
