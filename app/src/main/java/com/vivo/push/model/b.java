package com.vivo.push.model;

import android.text.TextUtils;

/* compiled from: PushPackageInfo.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private String f12114a;

    /* renamed from: d, reason: collision with root package name */
    private String f12117d;

    /* renamed from: b, reason: collision with root package name */
    private long f12115b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f12116c = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12118e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12119f = false;

    public b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f12114a = str;
    }

    public final String a() {
        return this.f12114a;
    }

    public final long b() {
        return this.f12115b;
    }

    public final boolean c() {
        return this.f12118e;
    }

    public final boolean d() {
        return this.f12119f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f12114a + ", mPushVersion=" + this.f12115b + ", mPackageVersion=" + this.f12116c + ", mInBlackList=" + this.f12118e + ", mPushEnable=" + this.f12119f + "}";
    }

    public final void a(long j2) {
        this.f12115b = j2;
    }

    public final void b(boolean z) {
        this.f12119f = z;
    }

    public final void a(boolean z) {
        this.f12118e = z;
    }

    public final void a(int i2) {
        this.f12116c = i2;
    }

    public final void a(String str) {
        this.f12117d = str;
    }
}
