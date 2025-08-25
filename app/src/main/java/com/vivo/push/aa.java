package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ag;

/* compiled from: SubscribeImpl.java */
/* loaded from: classes2.dex */
final class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11923a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f11924b;

    aa(z zVar, String str) {
        this.f11924b = zVar;
        this.f11923a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context contextB = com.vivo.push.restructure.a.a().b();
        if (contextB == null) {
            return;
        }
        long j2 = m.a().f() ? 488L : 341L;
        if (TextUtils.isEmpty(this.f11923a) || !ag.a(contextB, contextB.getPackageName(), this.f11923a, j2)) {
            return;
        }
        com.vivo.push.restructure.a.a().e().e();
        this.f11924b.f12316d = "";
    }
}
