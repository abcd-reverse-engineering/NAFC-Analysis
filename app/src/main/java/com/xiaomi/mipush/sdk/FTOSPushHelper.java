package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class FTOSPushHelper {

    /* renamed from: a, reason: collision with root package name */
    private static long f12338a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static volatile boolean f89a = false;

    private static void a(Context context) {
        AbstractPushManager abstractPushManagerA = e.a(context).a(d.ASSEMBLE_PUSH_FTOS);
        if (abstractPushManagerA != null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            abstractPushManagerA.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j2 = f12338a;
            if (j2 <= 0 || j2 + 300000 <= jElapsedRealtime) {
                f12338a = jElapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f89a;
    }

    public static boolean hasNetwork(Context context) {
        return f.m98a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) throws JSONException {
        PushMessageReceiver pushMessageReceiverA;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (pushMessageReceiverA = f.a(context)) == null) {
            return;
        }
        MiPushMessage miPushMessageA = f.a(str);
        if (miPushMessageA.getExtra().containsKey("notify_effect")) {
            return;
        }
        pushMessageReceiverA.onNotificationMessageClicked(context, miPushMessageA);
    }

    public static void setNeedRegister(boolean z) {
        f89a = z;
    }

    public static void uploadToken(Context context, String str) {
        f.m97a(context, d.ASSEMBLE_PUSH_FTOS, str);
    }
}
