package com.vivo.push;

/* compiled from: PushClientManager.java */
/* loaded from: classes2.dex */
final class p implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f12127a;

    p(m mVar) {
        this.f12127a = mVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        if (i2 == 0) {
            com.vivo.push.restructure.a.a().h().b("");
        } else {
            com.vivo.push.restructure.a.a().h().c("");
        }
    }
}
