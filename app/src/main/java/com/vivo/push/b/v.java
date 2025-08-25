package com.vivo.push.b;

/* compiled from: OnVerifyReceiveCommand.java */
/* loaded from: classes2.dex */
public abstract class v extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f11979a;

    /* renamed from: b, reason: collision with root package name */
    private long f11980b;

    public v(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f11979a);
        dVar.a("notify_id", this.f11980b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11979a = dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f11980b = dVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f11980b;
    }

    public final String g() {
        return this.f11979a;
    }
}
