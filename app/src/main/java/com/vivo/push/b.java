package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* compiled from: BasePushClient.java */
/* loaded from: classes2.dex */
final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushQueryActionListener f11929a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f11930b;

    b(a aVar, IPushQueryActionListener iPushQueryActionListener) {
        this.f11930b = aVar;
        this.f11929a = iPushQueryActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strB = com.vivo.push.restructure.a.a().h().b();
        IPushQueryActionListener iPushQueryActionListener = this.f11929a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(strB);
        }
    }
}
