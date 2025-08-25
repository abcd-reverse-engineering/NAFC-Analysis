package com.huawei.hms.hatool;

import android.content.Context;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    s0 f6943a;

    /* renamed from: b, reason: collision with root package name */
    s0 f6944b;

    /* renamed from: c, reason: collision with root package name */
    Context f6945c;

    /* renamed from: d, reason: collision with root package name */
    String f6946d;

    public b(Context context) {
        if (context != null) {
            this.f6945c = context.getApplicationContext();
        }
        this.f6943a = new s0();
        this.f6944b = new s0();
    }

    public b a(int i2, String str) {
        s0 s0Var;
        v.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i2);
        if (!p1.b(str)) {
            str = "";
        }
        if (i2 == 0) {
            s0Var = this.f6943a;
        } else {
            if (i2 != 1) {
                v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            }
            s0Var = this.f6944b;
        }
        s0Var.b(str);
        return this;
    }

    public b a(String str) {
        v.c("hmsSdk", "Builder.setAppID is execute");
        this.f6946d = str;
        return this;
    }

    @Deprecated
    public b a(boolean z) {
        v.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f6943a.j().a(z);
        this.f6944b.j().a(z);
        return this;
    }

    public void a() {
        if (this.f6945c == null) {
            v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        v.c("hmsSdk", "Builder.create() is execute.");
        z0 z0Var = new z0("_hms_config_tag");
        z0Var.b(new s0(this.f6943a));
        z0Var.a(new s0(this.f6944b));
        m.a().a(this.f6945c);
        g0.a().a(this.f6945c);
        q.c().a(z0Var);
        m.a().a(this.f6946d);
    }

    @Deprecated
    public b b(boolean z) {
        v.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f6943a.j().b(z);
        this.f6944b.j().b(z);
        return this;
    }

    @Deprecated
    public b c(boolean z) {
        v.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f6943a.j().c(z);
        this.f6944b.j().c(z);
        return this;
    }
}
