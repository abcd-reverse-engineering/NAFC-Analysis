package com.vivo.push;

import com.vivo.push.m;

/* compiled from: PushClientManager.java */
/* loaded from: classes2.dex */
final class n implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m.a f12120a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12121b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f12122c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ m f12123d;

    n(m mVar, m.a aVar, String str, String str2) {
        this.f12123d = mVar;
        this.f12120a = aVar;
        this.f12121b = str;
        this.f12122c = str2;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        if (i2 != 0) {
            com.vivo.push.restructure.a.a().h().a("");
            return;
        }
        Object[] objArrB = this.f12120a.b();
        if (objArrB == null || objArrB.length == 0) {
            com.vivo.push.util.u.a("PushClientManager", "bind app result is null");
        } else {
            com.vivo.push.restructure.a.a().h().a((String) this.f12120a.b()[0], this.f12121b, this.f12122c);
        }
    }
}
