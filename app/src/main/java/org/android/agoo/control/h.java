package org.android.agoo.control;

import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f17340a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f17341b;

    h(g gVar, Intent intent) {
        this.f17341b = gVar;
        this.f17340a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17341b.f17339a.onHandleIntent(this.f17340a);
    }
}
