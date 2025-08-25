package com.xiaomi.push;

/* loaded from: classes2.dex */
public class ar implements at {

    /* renamed from: a, reason: collision with root package name */
    private final String f12458a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12459b;

    public ar(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f12458a = str;
        this.f12459b = str2;
    }

    @Override // com.xiaomi.push.at
    public String a() {
        return this.f12458a;
    }

    @Override // com.xiaomi.push.at
    public String b() {
        return this.f12459b;
    }
}
