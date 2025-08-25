package com.vivo.push.f;

import android.content.pm.PackageManager;

/* compiled from: ChangeNetPermissionTask.java */
/* loaded from: classes2.dex */
final class b extends com.vivo.push.s {
    b(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) throws PackageManager.NameNotFoundException {
        com.vivo.push.model.b bVarA = com.vivo.push.util.aa.a(this.f12207a, com.vivo.push.restructure.a.a().f());
        try {
            if (((com.vivo.push.b.d) vVar).d() ? j.a(this.f12207a) : j.b(this.f12207a)) {
                com.vivo.push.model.b bVarA2 = com.vivo.push.util.aa.a(this.f12207a, com.vivo.push.restructure.a.a().f());
                if (bVarA == null || bVarA2 == null || bVarA2.a() == null || !bVarA2.a().equals(bVarA.a())) {
                    if (bVarA != null && bVarA.a() != null) {
                        com.vivo.push.a.a.a(this.f12207a, bVarA.a(), new com.vivo.push.b.y(bVarA.a()));
                    }
                    if (bVarA2 == null || bVarA2.a() == null) {
                        return;
                    }
                    com.vivo.push.b.f fVar = new com.vivo.push.b.f();
                    com.vivo.push.restructure.a.a();
                    fVar.d();
                    com.vivo.push.a.a.a(this.f12207a, bVarA2.a(), fVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
