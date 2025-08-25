package com.vivo.push.b;

/* compiled from: OnChangePushStatusReceiveCommand.java */
/* loaded from: classes2.dex */
public final class j extends s {

    /* renamed from: a, reason: collision with root package name */
    private int f11952a;

    /* renamed from: b, reason: collision with root package name */
    private int f11953b;

    public j() {
        super(12);
        this.f11952a = -1;
        this.f11953b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f11952a);
        dVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f11953b);
    }

    public final int d() {
        return this.f11952a;
    }

    public final int e() {
        return this.f11953b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11952a = dVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f11952a);
        this.f11953b = dVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f11953b);
    }
}
