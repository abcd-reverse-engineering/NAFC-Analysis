package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgooFactory.a f17338a;

    f(AgooFactory.a aVar) {
        this.f17338a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ALog.d("AgooFactory", "onConnected running tid:" + Thread.currentThread().getId(), new Object[0]);
            this.f17338a.f17319c.doSend(this.f17338a.f17317a);
            ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
            this.f17338a.f17319c = null;
            try {
                AgooFactory.mContext.unbindService(this.f17338a.f17320d);
            } catch (Throwable th) {
                ALog.e("AgooFactory", "unbindService error", th, new Object[0]);
            }
        } catch (Throwable th2) {
            try {
                ALog.e("AgooFactory", "send error", th2, new Object[0]);
                ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
                this.f17338a.f17319c = null;
                try {
                    AgooFactory.mContext.unbindService(this.f17338a.f17320d);
                } catch (Throwable th3) {
                    ALog.e("AgooFactory", "unbindService error", th3, new Object[0]);
                }
            } catch (Throwable th4) {
                ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
                this.f17338a.f17319c = null;
                try {
                    AgooFactory.mContext.unbindService(this.f17338a.f17320d);
                } catch (Throwable th5) {
                    ALog.e("AgooFactory", "unbindService error", th5, new Object[0]);
                }
                throw th4;
            }
        }
    }
}
