package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f8468a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Intent f8469b;

    h(Context context, Intent intent) {
        this.f8468a = context;
        this.f8469b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        g.a().b(this.f8468a, this.f8469b);
    }
}
