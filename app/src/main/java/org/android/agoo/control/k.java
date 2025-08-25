package org.android.agoo.control;

import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f17344a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseIntentService f17345b;

    k(BaseIntentService baseIntentService, Intent intent) {
        this.f17345b = baseIntentService;
        this.f17344a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17345b.onHandleIntent(this.f17344a);
    }
}
