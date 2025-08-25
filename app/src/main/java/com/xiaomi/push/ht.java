package com.xiaomi.push;

import com.xiaomi.push.hw;

/* loaded from: classes2.dex */
public class ht {

    /* renamed from: a, reason: collision with root package name */
    private final ia f13212a;

    /* renamed from: a, reason: collision with other field name */
    private final ij f888a;

    public ht() {
        this(new hw.a());
    }

    public void a(hq hqVar, byte[] bArr) {
        try {
            this.f888a.a(bArr);
            hqVar.a(this.f13212a);
        } finally {
            this.f13212a.k();
        }
    }

    public ht(ic icVar) {
        this.f888a = new ij();
        this.f13212a = icVar.a(this.f888a);
    }
}
