package com.huawei.hms.hatool;

/* loaded from: classes.dex */
public class l1 {

    /* renamed from: a, reason: collision with root package name */
    private s0 f7044a;

    /* renamed from: b, reason: collision with root package name */
    private s0 f7045b;

    /* renamed from: c, reason: collision with root package name */
    private s0 f7046c;

    /* renamed from: d, reason: collision with root package name */
    private s0 f7047d;

    public l1(String str) {
    }

    public s0 a() {
        return this.f7046c;
    }

    public s0 a(String str) {
        if (str.equals("oper")) {
            return c();
        }
        if (str.equals("maint")) {
            return b();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return d();
        }
        v.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(s0 s0Var) {
        this.f7044a = s0Var;
    }

    public s0 b() {
        return this.f7044a;
    }

    public void b(s0 s0Var) {
        this.f7045b = s0Var;
    }

    public s0 c() {
        return this.f7045b;
    }

    public s0 d() {
        return this.f7047d;
    }
}
