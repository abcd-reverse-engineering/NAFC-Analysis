package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* loaded from: classes2.dex */
final class c implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f12227a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f12228b;

    c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f12228b = vUpsManager;
        this.f12227a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f12227a.onResult(new CodeResult(i2));
    }
}
