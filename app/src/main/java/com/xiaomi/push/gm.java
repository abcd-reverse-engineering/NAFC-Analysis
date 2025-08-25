package com.xiaomi.push;

/* loaded from: classes2.dex */
public enum gm {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* renamed from: a, reason: collision with other field name */
    private final int f585a;

    gm(int i2) {
        this.f585a = i2;
    }

    public static gm a(int i2) {
        if (i2 == 1) {
            return INT;
        }
        if (i2 == 2) {
            return LONG;
        }
        if (i2 == 3) {
            return STRING;
        }
        if (i2 != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
