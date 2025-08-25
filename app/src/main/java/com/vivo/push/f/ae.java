package com.vivo.push.f;

/* compiled from: OnUnBindAppReceiveTask.java */
/* loaded from: classes2.dex */
final class ae extends aa {
    ae(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        com.vivo.push.util.u.c("OnUnBindTask", "doTask,解订阅APP结果 = " + iVar.i() + " clientToken= " + iVar.e());
        com.vivo.push.m.a().a(iVar.h(), iVar.i(), new Object[0]);
        com.vivo.push.t.b(new af(this, iVar));
    }
}
