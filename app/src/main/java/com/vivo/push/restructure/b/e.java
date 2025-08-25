package com.vivo.push.restructure.b;

import android.content.Context;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ag;

/* compiled from: PushRelyImpl.java */
/* loaded from: classes2.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f12175a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PushConfig f12176b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f12177c;

    e(d dVar, Context context, PushConfig pushConfig) {
        this.f12177c = dVar;
        this.f12175a = context;
        this.f12176b = pushConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f12175a;
        ag.a(context, context.getPackageName(), this.f12176b.isAgreePrivacyStatement());
    }
}
