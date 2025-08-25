package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* loaded from: classes2.dex */
final class a implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f12223a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f12224b;

    a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f12224b = vUpsManager;
        this.f12223a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f12223a.onResult(new TokenResult(i2, com.vivo.push.restructure.a.a().h().b()));
    }
}
