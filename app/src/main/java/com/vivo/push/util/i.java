package com.vivo.push.util;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ConvertMsgToIntentImpl.java */
/* loaded from: classes2.dex */
public final class i extends b {

    /* renamed from: e, reason: collision with root package name */
    private int f12272e = 0;

    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.Intent b(android.content.Context r9, com.vivo.push.model.InsideNotificationItem r10, com.vivo.push.model.NotifyArriveCallbackByUser r11) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.i.b(android.content.Context, com.vivo.push.model.InsideNotificationItem, com.vivo.push.model.NotifyArriveCallbackByUser):android.content.Intent");
    }

    @Override // com.vivo.push.util.b
    protected final int a() {
        return this.f12272e;
    }

    @Override // com.vivo.push.util.b
    protected final Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        return b(context, insideNotificationItem, notifyArriveCallbackByUser);
    }

    @Override // com.vivo.push.util.b
    protected final PendingIntent a(Context context, Intent intent) {
        return PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
    }

    private Intent a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) throws URISyntaxException {
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.setSelector(null);
            uri.setPackage(str2);
            uri.setFlags(335544320);
            a(uri, insideNotificationItem.getParams());
            int iA = a(uri, str2);
            if (iA <= 0) {
                return uri;
            }
            this.f12272e = iA;
            u.c(context, " 落地页未找到，通知不展示：  " + this.f12272e);
            return null;
        } catch (Exception e2) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e2);
            this.f12272e = 2158;
            return null;
        }
    }

    private static Intent a(Map<String, String> map, String str, Context context) throws SecurityException {
        Intent intent = new Intent();
        intent.setPackage(str);
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(str)) {
                        u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient topClassName=" + componentName.getClassName());
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        a(intent, map);
                        return intent;
                    }
                }
            }
        } catch (Exception e2) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ActivityManager", e2);
        }
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
            if (intent != null) {
                intent.setFlags(335544320);
                a(intent, map);
            } else {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
            }
        } catch (Exception e3) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e3.getMessage());
        }
        return intent;
    }

    private static Intent a(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int a(Intent intent, String str) {
        int iA = a(intent);
        u.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(iA)));
        if (iA != 0) {
            return iA;
        }
        int iB = b(intent, str);
        u.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(iB)));
        if (iB != 0) {
            return iB;
        }
        return 0;
    }

    private int a(Intent intent) {
        if (intent.resolveActivityInfo(this.f12258c.getPackageManager(), 65536) != null) {
            return 0;
        }
        u.a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
        u.c(this.f12258c, " 跳转参数对应的Activity找不到 通知不展示   2162");
        return 2162;
    }

    private static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && !intent.hasExtra(entry.getKey())) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int b(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : intent.getPackage();
                if (TextUtils.isEmpty(packageName) || TextUtils.equals(str, packageName)) {
                    return 0;
                }
                u.d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + str + "; but remote pkgName is " + packageName);
                u.a(this.f12258c, " 跳转参数对应的包名不是当前应用包名    local pkgName is " + str + "; but remote pkgName is " + packageName + " code =2813");
                return 2813;
            } catch (Exception e2) {
                u.a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e2.getMessage());
                return 2158;
            }
        }
        StringBuilder sb = new StringBuilder("checkSkipContentPackageFit intent = : ");
        Object obj = intent;
        if (intent == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(" mPkgName = ");
        sb.append(str);
        u.a("AndroidTwelveNotifyClickIntentParam", sb.toString());
        return 2158;
    }
}
