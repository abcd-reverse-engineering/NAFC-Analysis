package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;
import h.f1;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public final class o implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f9949a;

    public o(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i2 = this.f9949a;
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.f9949a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof o) && this.f9949a == ((o) obj).b();
    }

    public int hashCode() {
        return this.f9949a;
    }

    public o(byte[] bArr, int i2) {
        this.f9949a = (bArr[i2 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f9949a += bArr[i2] & f1.f16099c;
    }

    public o(int i2) {
        this.f9949a = i2;
    }
}
