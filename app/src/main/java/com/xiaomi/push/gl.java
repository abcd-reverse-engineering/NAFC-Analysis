package com.xiaomi.push;

/* loaded from: classes2.dex */
public enum gl {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f583a;

    gl(int i2) {
        this.f583a = i2;
    }

    public int a() {
        return this.f583a;
    }

    public static gl a(int i2) {
        if (i2 == 1) {
            return MISC_CONFIG;
        }
        if (i2 != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
