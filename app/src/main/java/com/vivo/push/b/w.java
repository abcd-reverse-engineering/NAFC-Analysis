package com.vivo.push.b;

/* compiled from: PushModeCommand.java */
/* loaded from: classes2.dex */
public final class w extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private int f11981a;

    public w() {
        super(2011);
        this.f11981a = 0;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("com.bbk.push.ikey.MODE_TYPE", this.f11981a);
    }

    @Override // com.vivo.push.v
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.f11981a;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.f11981a = dVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
