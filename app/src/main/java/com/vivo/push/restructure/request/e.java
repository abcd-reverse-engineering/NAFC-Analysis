package com.vivo.push.restructure.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.g;

/* compiled from: RequestManager.java */
/* loaded from: classes2.dex */
final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f12204a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(d dVar, Looper looper) {
        super(looper);
        this.f12204a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (this.f12204a.f12199a.containsKey(Integer.valueOf(i2))) {
            g.a().execute(new f(this, (b) this.f12204a.f12199a.remove(Integer.valueOf(i2))));
        }
    }
}
