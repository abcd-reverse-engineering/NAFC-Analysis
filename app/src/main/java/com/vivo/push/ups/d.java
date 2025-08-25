package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* loaded from: classes2.dex */
final class d implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f12229a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f12230b;

    d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f12230b = vUpsManager;
        this.f12229a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f12229a.onResult(new CodeResult(i2));
    }
}
