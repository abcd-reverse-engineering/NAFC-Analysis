package com.tencent.bugly.beta.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.f;
import com.tencent.bugly.proguard.am;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaReceiver extends BroadcastReceiver {
    public static ConcurrentHashMap<String, c> netListeners = new ConcurrentHashMap<>(3);
    public static int netStatus = 0;
    public static String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";

    public static synchronized void addTask(DownloadTask downloadTask) {
        netStatus = com.tencent.bugly.beta.global.a.a(e.G.u);
        f fVar = new f();
        fVar.n = downloadTask;
        netListeners.put(downloadTask.getDownloadUrl(), new c(2, downloadTask, false, fVar));
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(final Context context, final Intent intent) {
        am.a().a(new Runnable() { // from class: com.tencent.bugly.beta.download.BetaReceiver.1
            /* JADX WARN: Removed duplicated region for block: B:31:0x0099 A[Catch: Exception -> 0x00fc, TryCatch #0 {Exception -> 0x00fc, blocks: (B:2:0x0000, B:4:0x000e, B:5:0x0022, B:7:0x0028, B:8:0x0034, B:10:0x0044, B:14:0x0055, B:15:0x0060, B:18:0x0067, B:44:0x00ec, B:46:0x00f2, B:48:0x00f6, B:29:0x007c, B:30:0x0089, B:31:0x0099, B:33:0x009f, B:35:0x00a5, B:37:0x00b1, B:39:0x00c1, B:41:0x00cf, B:42:0x00df, B:43:0x00e6), top: B:55:0x0000 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 263
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.download.BetaReceiver.AnonymousClass1.run():void");
            }
        });
    }
}
