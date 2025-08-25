package anetwork.channel.aidl.j;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.NetworkService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    static volatile anetwork.channel.aidl.b f2178a = null;

    /* renamed from: b, reason: collision with root package name */
    static volatile boolean f2179b = false;

    /* renamed from: c, reason: collision with root package name */
    static volatile boolean f2180c = false;

    /* renamed from: d, reason: collision with root package name */
    static volatile CountDownLatch f2181d;

    /* renamed from: e, reason: collision with root package name */
    static Handler f2182e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    private static ServiceConnection f2183f = new j();

    public static void a(Context context, boolean z) {
        if (f2178a == null && !f2179b) {
            a(context);
            if (f2179b || !z) {
                return;
            }
            try {
                synchronized (i.class) {
                    if (f2178a != null) {
                        return;
                    }
                    if (f2181d == null) {
                        f2181d = new CountDownLatch(1);
                    }
                    ALog.i("anet.RemoteGetter", "[initRemoteGetterAndWait]begin to wait", null, new Object[0]);
                    if (f2181d.await(a.a.k.b.c(), TimeUnit.SECONDS)) {
                        ALog.i("anet.RemoteGetter", "mServiceBindLock count down to 0", null, new Object[0]);
                    } else {
                        ALog.i("anet.RemoteGetter", "mServiceBindLock wait timeout", null, new Object[0]);
                    }
                }
            } catch (InterruptedException unused) {
                ALog.e("anet.RemoteGetter", "mServiceBindLock wait interrupt", null, new Object[0]);
            }
        }
    }

    public static anetwork.channel.aidl.b a() {
        return f2178a;
    }

    private static void a(Context context) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "[asyncBindService] mContext:" + context + " bBindFailed:" + f2179b + " bBinding:" + f2180c, null, new Object[0]);
        }
        if (context == null || f2179b || f2180c) {
            return;
        }
        f2180c = true;
        Intent intent = new Intent(context, (Class<?>) NetworkService.class);
        intent.setAction(anetwork.channel.aidl.b.class.getName());
        intent.addCategory("android.intent.category.DEFAULT");
        f2179b = !context.bindService(intent, f2183f, 1);
        if (f2179b) {
            f2180c = false;
            ALog.e("anet.RemoteGetter", "[asyncBindService]ANet_Service start not success. ANet run with local mode!", null, new Object[0]);
        }
        f2182e.postDelayed(new k(), com.heytap.mcssdk.constant.a.q);
    }
}
