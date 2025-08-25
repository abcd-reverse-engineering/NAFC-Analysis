package com.vivo.push.d;

import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: classes2.dex */
final class i implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f12016a;

    i(h hVar) {
        this.f12016a = hVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        com.vivo.push.d.a.b bVar2 = (com.vivo.push.d.a.b) bVar;
        if (this.f12016a.f12014a != null) {
            u.b("query success");
            this.f12016a.f12014a.onSuccess(bVar2.a());
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i2) {
        if (this.f12016a.f12014a != null) {
            u.b("query err : ".concat(String.valueOf(i2)));
            this.f12016a.f12014a.onError(i2);
        }
    }
}
