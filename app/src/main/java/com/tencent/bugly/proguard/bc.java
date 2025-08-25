package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bc extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f9295a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f9296b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f9297c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f9298d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f9299e = "";

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9295a, 0);
        String str = this.f9296b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f9297c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        String str3 = this.f9298d;
        if (str3 != null) {
            lVar.a(str3, 3);
        }
        String str4 = this.f9299e;
        if (str4 != null) {
            lVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9295a = kVar.a(0, true);
        this.f9296b = kVar.a(1, false);
        this.f9297c = kVar.a(2, false);
        this.f9298d = kVar.a(3, false);
        this.f9299e = kVar.a(4, false);
    }
}
