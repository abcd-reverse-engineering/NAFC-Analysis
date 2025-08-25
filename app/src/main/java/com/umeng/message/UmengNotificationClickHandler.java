package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import c.c.a.b.a.a;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.aw;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* loaded from: classes2.dex */
public class UmengNotificationClickHandler implements UPushMessageHandler {
    private static void a(Intent intent, UMessage uMessage) {
        if (intent == null || uMessage == null || uMessage.getExtra() == null) {
            return;
        }
        for (Map.Entry<String, String> entry : uMessage.getExtra().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                intent.putExtra(key, value);
            }
        }
    }

    public void changeBadgeNum(Context context, UMessage uMessage) {
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        if (TextUtils.equals(uMessage.getMsgId(), messageSharedPrefs.f())) {
            return;
        }
        messageSharedPrefs.c(uMessage.getMsgId());
        aw.b(context, -1);
    }

    public void dealWithCustomAction(Context context, UMessage uMessage) {
    }

    public void dismissNotification(Context context, UMessage uMessage) {
    }

    protected Intent getMainIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.setFlags(a.B1);
        return launchIntentForPackage;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0080 A[Catch: all -> 0x0087, TryCatch #0 {all -> 0x0087, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x0008, B:8:0x0014, B:10:0x001c, B:33:0x0083, B:11:0x0020, B:13:0x0028, B:14:0x002c, B:16:0x0034, B:17:0x0038, B:19:0x003e, B:21:0x004c, B:22:0x0050, B:24:0x0056, B:26:0x0064, B:27:0x0068, B:29:0x006e, B:31:0x007c, B:32:0x0080), top: B:38:0x0000 }] */
    @Override // com.umeng.message.api.UPushMessageHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(android.content.Context r3, com.umeng.message.entity.UMessage r4) {
        /*
            r2 = this;
            boolean r0 = r4.dismiss     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L8
            r2.dismissNotification(r3, r4)     // Catch: java.lang.Throwable -> L87
            return
        L8:
            java.lang.String r0 = r4.getAction()     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = "go_app"
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch: java.lang.Throwable -> L87
            if (r1 != 0) goto L80
            java.lang.String r1 = "go_url"
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L20
            r2.openUrl(r3, r4)     // Catch: java.lang.Throwable -> L87
            goto L83
        L20:
            java.lang.String r1 = "go_activity"
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L2c
            r2.openActivity(r3, r4)     // Catch: java.lang.Throwable -> L87
            goto L83
        L2c:
            java.lang.String r1 = "go_custom"
            boolean r0 = android.text.TextUtils.equals(r1, r0)     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L38
            r2.dealWithCustomAction(r3, r4)     // Catch: java.lang.Throwable -> L87
            goto L83
        L38:
            java.lang.String r0 = r4.getDeeplink()     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L50
            java.lang.String r0 = r4.getDeeplink()     // Catch: java.lang.Throwable -> L87
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L87
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L87
            if (r0 != 0) goto L50
            r2.openUrl(r3, r4)     // Catch: java.lang.Throwable -> L87
            goto L83
        L50:
            java.lang.String r0 = r4.getActivity()     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L68
            java.lang.String r0 = r4.getActivity()     // Catch: java.lang.Throwable -> L87
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L87
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L87
            if (r0 != 0) goto L68
            r2.openActivity(r3, r4)     // Catch: java.lang.Throwable -> L87
            goto L83
        L68:
            java.lang.String r0 = r4.getCustom()     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L80
            java.lang.String r0 = r4.getContent()     // Catch: java.lang.Throwable -> L87
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L87
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L87
            if (r0 != 0) goto L80
            r2.dealWithCustomAction(r3, r4)     // Catch: java.lang.Throwable -> L87
            goto L83
        L80:
            r2.launchApp(r3, r4)     // Catch: java.lang.Throwable -> L87
        L83:
            r2.changeBadgeNum(r3, r4)     // Catch: java.lang.Throwable -> L87
            return
        L87:
            r3 = move-exception
            java.lang.String r4 = "UmengNotificationClickHandler"
            com.umeng.message.common.UPLog.e(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengNotificationClickHandler.handleMessage(android.content.Context, com.umeng.message.entity.UMessage):void");
    }

    public void launchApp(Context context, UMessage uMessage) {
        try {
            Intent mainIntent = getMainIntent(context);
            if (mainIntent == null) {
                UPLog.e("UmengNotificationClickHandler", "can't find launchIntent:", context.getPackageName());
                return;
            }
            mainIntent.addFlags(CommonNetImpl.FLAG_AUTH);
            a(mainIntent, uMessage);
            UPLog.d("UmengNotificationClickHandler", "open app:", context.getPackageName());
            context.startActivity(mainIntent);
        } catch (Throwable th) {
            UPLog.e("UmengNotificationClickHandler", th);
        }
    }

    public void openActivity(Context context, UMessage uMessage) {
        try {
            String activity = uMessage.getActivity();
            if (activity == null) {
                return;
            }
            String strTrim = activity.trim();
            if (TextUtils.isEmpty(strTrim)) {
                return;
            }
            UPLog.d("UmengNotificationClickHandler", "open activity:", strTrim);
            Intent intent = new Intent();
            a(intent, uMessage);
            intent.setClassName(context, strTrim);
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent);
        } catch (Throwable th) {
            UPLog.e("UmengNotificationClickHandler", th);
        }
    }

    public void openUrl(Context context, UMessage uMessage) {
        try {
            String deeplink = uMessage.getDeeplink();
            if (deeplink == null) {
                return;
            }
            String strTrim = deeplink.trim();
            if (TextUtils.isEmpty(strTrim)) {
                return;
            }
            UPLog.d("UmengNotificationClickHandler", "open deeplink:".concat(String.valueOf(strTrim)));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strTrim));
            a(intent, uMessage);
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent);
        } catch (Throwable th) {
            UPLog.e("UmengNotificationClickHandler", th);
        }
    }
}
