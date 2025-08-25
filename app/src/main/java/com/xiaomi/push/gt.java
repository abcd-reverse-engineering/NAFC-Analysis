package com.xiaomi.push;

/* loaded from: classes2.dex */
public enum gt {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f643a;

    gt(int i2) {
        this.f643a = i2;
    }

    public int a() {
        return this.f643a;
    }

    public static gt a(int i2) {
        if (i2 == 0) {
            return RegIdExpired;
        }
        if (i2 == 1) {
            return PackageUnregistered;
        }
        if (i2 != 2) {
            return null;
        }
        return Init;
    }
}
