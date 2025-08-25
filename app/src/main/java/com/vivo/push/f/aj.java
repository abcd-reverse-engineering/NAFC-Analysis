package com.vivo.push.f;

import android.content.pm.PackageManager;

/* compiled from: UnbindAppSendCommandTask.java */
/* loaded from: classes2.dex */
final class aj extends com.vivo.push.s {
    aj(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) throws PackageManager.NameNotFoundException {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
        com.vivo.push.model.b bVarA = com.vivo.push.util.aa.a(this.f12207a, com.vivo.push.restructure.a.a().f());
        if (bVarA == null) {
            com.vivo.push.m.a().a(cVar.f(), 1005, new Object[0]);
            return;
        }
        String strA = bVarA.a();
        if (bVarA.c()) {
            com.vivo.push.m.a().a(cVar.f(), 1004, new Object[0]);
            vVar = new com.vivo.push.b.e();
        } else {
            int iA = com.vivo.push.util.y.a(cVar);
            if (iA != 0) {
                com.vivo.push.m.a().a(cVar.f(), iA, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f12207a, strA, vVar);
    }
}
