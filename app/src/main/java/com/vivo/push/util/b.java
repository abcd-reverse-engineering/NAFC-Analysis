package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.security.PublicKey;
import java.util.HashMap;

/* compiled from: BaseConvertMsgToIntent.java */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected String f12256a;

    /* renamed from: b, reason: collision with root package name */
    protected long f12257b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f12258c;

    /* renamed from: d, reason: collision with root package name */
    protected NotifyArriveCallbackByUser f12259d;

    protected static void a(Intent intent, Context context) {
        try {
            intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
            if (Build.VERSION.SDK_INT >= 18) {
                String strA = com.vivo.push.e.b.a().a(context).a("com.vivo.pushservice");
                PublicKey publicKeyA = com.vivo.push.e.b.a().a(context).a();
                if (TextUtils.isEmpty(strA)) {
                    strA = "com.vivo.pushservice";
                }
                intent.putExtra("security_avoid_pull_rsa", strA);
                intent.putExtra("security_avoid_rsa_public_key", publicKeyA == null ? "com.vivo.pushservice" : ab.a(publicKeyA));
            }
        } catch (Exception e2) {
            u.a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt ：" + e2.getMessage());
            intent.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
            intent.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
        }
    }

    protected abstract int a();

    protected abstract PendingIntent a(Context context, Intent intent);

    protected abstract Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser);

    public final long b() {
        return this.f12257b;
    }

    public final Intent a(Context context, String str, long j2, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f12257b = j2;
        this.f12256a = str;
        this.f12258c = context;
        this.f12259d = notifyArriveCallbackByUser;
        Intent intentA = a(context, insideNotificationItem, notifyArriveCallbackByUser);
        int iA = a();
        if (iA <= 0) {
            return intentA;
        }
        HashMap map = new HashMap();
        map.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(this.f12257b));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        map.put("ap", this.f12256a);
        map.put("clientsdkver", String.valueOf(ag.c(this.f12258c, this.f12256a)));
        f.a(iA, (HashMap<String, String>) map);
        return null;
    }

    public static Intent a(Context context, String str, long j2, Intent intent, InsideNotificationItem insideNotificationItem) {
        Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent2.putExtra("command_type", "reflect_receiver");
        intent2.putExtras(intent.getExtras());
        a(intent2, context);
        com.vivo.push.b.p pVar = new com.vivo.push.b.p(str, j2, insideNotificationItem);
        pVar.b(intent.getAction());
        if (intent.getComponent() != null) {
            pVar.c(intent.getComponent().getPackageName());
            pVar.d(intent.getComponent().getClassName());
        }
        if (intent.getData() != null) {
            pVar.a(intent.getData());
        }
        pVar.b(intent2);
        return intent2;
    }
}
