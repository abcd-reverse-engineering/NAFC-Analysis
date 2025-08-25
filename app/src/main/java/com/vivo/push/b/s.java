package com.vivo.push.b;

/* compiled from: OnReceiveCommand.java */
/* loaded from: classes2.dex */
public class s extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f11973a;

    /* renamed from: b, reason: collision with root package name */
    private int f11974b;

    public s(int i2) {
        super(i2);
        this.f11973a = null;
        this.f11974b = 0;
    }

    @Override // com.vivo.push.v
    protected void c(com.vivo.push.d dVar) {
        dVar.a("req_id", this.f11973a);
        dVar.a("status_msg_code", this.f11974b);
    }

    @Override // com.vivo.push.v
    protected void d(com.vivo.push.d dVar) {
        this.f11973a = dVar.a("req_id");
        this.f11974b = dVar.b("status_msg_code", this.f11974b);
    }

    public final String h() {
        return this.f11973a;
    }

    public final int i() {
        return this.f11974b;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "OnReceiveCommand";
    }
}
