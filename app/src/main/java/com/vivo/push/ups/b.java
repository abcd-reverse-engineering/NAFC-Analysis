package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* loaded from: classes2.dex */
final class b implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f12225a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f12226b;

    b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f12226b = vUpsManager;
        this.f12225a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f12225a.onResult(new TokenResult(i2, ""));
    }
}
