package com.vivo.push.b;

import com.tencent.connect.common.Constants;

/* compiled from: OnAppReceiveCommand.java */
/* loaded from: classes2.dex */
public final class i extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f11948a;

    /* renamed from: b, reason: collision with root package name */
    private String f11949b;

    /* renamed from: c, reason: collision with root package name */
    private String f11950c;

    /* renamed from: d, reason: collision with root package name */
    private String f11951d;

    public i(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("app_id", this.f11948a);
        dVar.a(Constants.PARAM_CLIENT_ID, this.f11949b);
        dVar.a("client_token", this.f11950c);
        dVar.a("client_token_validity_period", this.f11951d);
    }

    public final String d() {
        return this.f11948a;
    }

    public final String e() {
        return this.f11950c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11948a = dVar.a("app_id");
        this.f11949b = dVar.a(Constants.PARAM_CLIENT_ID);
        this.f11950c = dVar.a("client_token");
        this.f11951d = dVar.a("client_token_validity_period");
    }
}
