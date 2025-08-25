package com.vivo.push;

/* compiled from: BasePushClient.java */
/* loaded from: classes2.dex */
final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f11986a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f11987b;

    c(a aVar, IPushActionListener iPushActionListener) {
        this.f11987b = aVar;
        this.f11986a = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iA = com.vivo.push.restructure.a.a().h().a();
        IPushActionListener iPushActionListener = this.f11986a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(iA);
        }
    }
}
