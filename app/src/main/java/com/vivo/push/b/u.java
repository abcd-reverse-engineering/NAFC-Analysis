package com.vivo.push.b;

/* compiled from: OnUndoMsgReceiveCommand.java */
/* loaded from: classes2.dex */
public final class u extends v {

    /* renamed from: a, reason: collision with root package name */
    private long f11977a;

    /* renamed from: b, reason: collision with root package name */
    private int f11978b;

    public u() {
        super(20);
        this.f11977a = -1L;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("undo_msg_v1", this.f11977a);
        dVar.a("undo_msg_type_v1", this.f11978b);
    }

    public final long d() {
        return this.f11977a;
    }

    public final String e() {
        long j2 = this.f11977a;
        if (j2 != -1) {
            return String.valueOf(j2);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11977a = dVar.b("undo_msg_v1", this.f11977a);
        this.f11978b = dVar.b("undo_msg_type_v1", 0);
    }
}
