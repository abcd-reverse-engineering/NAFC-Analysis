package com.vivo.push.f;

/* compiled from: OnBindAppReceiveTask.java */
/* loaded from: classes2.dex */
final class h extends aa {
    h(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        String strE = iVar.e();
        com.vivo.push.util.u.d("OnBindTask", "doTask,订阅APP结果 = " + iVar.i() + " clientToken= " + strE);
        com.vivo.push.m.a().a(iVar.h(), iVar.i(), strE);
        com.vivo.push.t.b(new i(this, strE, iVar));
    }
}
