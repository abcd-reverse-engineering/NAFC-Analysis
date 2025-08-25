package com.vivo.push.f;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: classes2.dex */
final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f12070a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.q f12071b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ u f12072c;

    v(u uVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.f12072c = uVar;
        this.f12070a = insideNotificationItem;
        this.f12071b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c2;
        u uVar = this.f12072c;
        NotifyArriveCallbackByUser notifyArriveCallbackByUserOnNotificationMessageArrived = ((aa) uVar).f12034b.onNotificationMessageArrived(((com.vivo.push.s) uVar).f12207a, com.vivo.push.util.v.a(this.f12070a));
        int iA = this.f12072c.a(notifyArriveCallbackByUserOnNotificationMessageArrived);
        if (iA > 0) {
            HashMap map = new HashMap();
            map.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(this.f12071b.f()));
            String strA = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
            map.put("clientsdkver", String.valueOf(com.vivo.push.util.ag.c(((com.vivo.push.s) this.f12072c).f12207a, ((com.vivo.push.s) this.f12072c).f12207a.getPackageName())));
            com.vivo.push.util.f.a(iA, (HashMap<String, String>) map);
            return;
        }
        int iB = this.f12072c.b();
        if (iB > 0) {
            com.vivo.push.util.u.b("OnNotificationArrivedTask", "pkg name : " + ((com.vivo.push.s) this.f12072c).f12207a.getPackageName() + " notify channel switch is " + iB);
            com.vivo.push.util.u.b(((com.vivo.push.s) this.f12072c).f12207a, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(iB)));
            HashMap map2 = new HashMap();
            map2.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(this.f12071b.f()));
            String strA2 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA2)) {
                map2.put("remoteAppId", strA2);
            }
            com.vivo.push.util.f.a(iB, (HashMap<String, String>) map2);
            return;
        }
        Context context = ((com.vivo.push.s) this.f12072c).f12207a;
        InsideNotificationItem insideNotificationItem = this.f12070a;
        long jF = this.f12071b.f();
        u uVar2 = this.f12072c;
        com.vivo.push.util.p pVar = new com.vivo.push.util.p(context, insideNotificationItem, jF, ((aa) uVar2).f12034b.isAllowNet(((com.vivo.push.s) uVar2).f12207a), new w(this), notifyArriveCallbackByUserOnNotificationMessageArrived);
        boolean zIsShowBigPicOnMobileNet = this.f12070a.isShowBigPicOnMobileNet();
        String purePicUrl = this.f12070a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.f12070a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.u.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(zIsShowBigPicOnMobileNet)));
            if (zIsShowBigPicOnMobileNet) {
                com.vivo.push.util.u.a(((com.vivo.push.s) this.f12072c).f12207a, "mobile net show");
            } else {
                com.vivo.push.util.u.a(((com.vivo.push.s) this.f12072c).f12207a, "mobile net unshow");
                NetworkInfo networkInfoA = com.vivo.push.util.x.a(((com.vivo.push.s) this.f12072c).f12207a);
                if (networkInfoA != null && networkInfoA.getState() == NetworkInfo.State.CONNECTED) {
                    int type = networkInfoA.getType();
                    c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                } else {
                    c2 = 0;
                }
                if (c2 == 1) {
                    purePicUrl = null;
                    this.f12070a.clearCoverUrl();
                    this.f12070a.clearPurePicUrl();
                }
            }
        }
        pVar.execute(this.f12070a.getIconUrl(), purePicUrl);
    }
}
