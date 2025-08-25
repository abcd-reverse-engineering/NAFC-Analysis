package com.vivo.push.b;

/* compiled from: AppCommand.java */
/* loaded from: classes2.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private String f11932a;

    /* renamed from: b, reason: collision with root package name */
    private String f11933b;

    /* renamed from: c, reason: collision with root package name */
    private int f11934c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11935d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, str);
        this.f11934c = 1;
        this.f11935d = false;
    }

    public final void a(int i2) {
        this.f11934c = i2;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("sdk_clients", this.f11932a);
        dVar.a("sdk_version", 341L);
        dVar.a("PUSH_REGID", this.f11933b);
        if (b() == 2007) {
            dVar.a("PUSH_UNBIND_SOURCE_CODE", this.f11934c);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11932a = dVar.a("sdk_clients");
        this.f11933b = dVar.a("PUSH_REGID");
        if (b() == 2007) {
            this.f11934c = dVar.b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AppCommand:" + b();
    }
}
