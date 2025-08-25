package com.vivo.push.b;

/* compiled from: OnLogReceiveCommand.java */
/* loaded from: classes2.dex */
public final class n extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f11957a;

    /* renamed from: b, reason: collision with root package name */
    private int f11958b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11959c;

    public n() {
        super(7);
        this.f11958b = 0;
        this.f11959c = false;
    }

    public final void a(int i2) {
        this.f11958b = i2;
    }

    public final void b(String str) {
        this.f11957a = str;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f11957a);
        dVar.a("log_level", this.f11958b);
        dVar.a("is_server_log", this.f11959c);
    }

    public final String d() {
        return this.f11957a;
    }

    public final int e() {
        return this.f11958b;
    }

    public final boolean f() {
        return this.f11959c;
    }

    public final void g() {
        this.f11959c = false;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnLogCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11957a = dVar.a("content");
        this.f11958b = dVar.b("log_level", 0);
        this.f11959c = dVar.e("is_server_log");
    }
}
