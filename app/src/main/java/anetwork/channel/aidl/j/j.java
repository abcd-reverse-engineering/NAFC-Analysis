package anetwork.channel.aidl.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.b;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class j implements ServiceConnection {
    j() {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "[onServiceConnected]ANet_Service start success. ANet run with service mode", null, new Object[0]);
        }
        synchronized (i.class) {
            i.f2178a = b.a.a(iBinder);
            if (i.f2181d != null) {
                i.f2181d.countDown();
            }
        }
        i.f2179b = false;
        i.f2180c = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "ANet_Service Disconnected", null, new Object[0]);
        }
        i.f2178a = null;
        i.f2180c = false;
        if (i.f2181d != null) {
            i.f2181d.countDown();
        }
    }
}
