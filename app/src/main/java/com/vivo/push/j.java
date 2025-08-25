package com.vivo.push;

import android.os.Handler;
import android.os.Message;

/* compiled from: IPCManager.java */
/* loaded from: classes2.dex */
final class j implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f12092a;

    j(i iVar) {
        this.f12092a = iVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message == null) {
            com.vivo.push.util.u.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i2 = message.what;
        if (i2 == 1) {
            com.vivo.push.util.u.a("AidlManager", "In connect, bind core service time out");
            if (this.f12092a.f12087f.get() == 2) {
                this.f12092a.a(1);
            }
        } else if (i2 != 2) {
            com.vivo.push.util.u.b("AidlManager", "unknow msg what [" + message.what + "]");
        } else {
            if (this.f12092a.f12087f.get() == 4) {
                this.f12092a.f();
            }
            this.f12092a.a(1);
        }
        return true;
    }
}
