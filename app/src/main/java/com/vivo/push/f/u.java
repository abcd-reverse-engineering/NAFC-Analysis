package com.vivo.push.f;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: classes2.dex */
public final class u extends aa {

    /* compiled from: OnNotificationArrivedReceiveTask.java */
    public interface a {
        void a();

        void b();
    }

    u(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        if (vVar == null) {
            com.vivo.push.util.u.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean zIsEnablePush = ClientConfigManagerImpl.getInstance(this.f12207a).isEnablePush();
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) vVar;
        Context context = this.f12207a;
        if (!com.vivo.push.util.aa.d(context, context.getPackageName())) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
            HashMap<String, String> map = new HashMap<>();
            map.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(qVar.f()));
            String strA = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
            xVar.a(map);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(qVar.f())));
        com.vivo.push.util.u.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f12207a.getPackageName() + " isEnablePush :" + zIsEnablePush);
        if (!zIsEnablePush) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1020L);
            HashMap<String, String> map2 = new HashMap<>();
            map2.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(qVar.f()));
            String strA2 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA2)) {
                map2.put("remoteAppId", strA2);
            }
            xVar2.a(map2);
            com.vivo.push.m.a().a(xVar2);
            return;
        }
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f12207a), qVar.e(), qVar.g())) {
            com.vivo.push.b.x xVar3 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> map3 = new HashMap<>();
            map3.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(qVar.f()));
            String strA3 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA3)) {
                map3.put("remoteAppId", strA3);
            }
            xVar3.a(map3);
            com.vivo.push.m.a().a(xVar3);
            return;
        }
        InsideNotificationItem insideNotificationItemD = qVar.d();
        if (insideNotificationItemD == null) {
            com.vivo.push.util.u.a("OnNotificationArrivedTask", "notify is null");
            com.vivo.push.util.u.c(this.f12207a, "通知内容为空，" + qVar.f());
            com.vivo.push.util.f.a(qVar.f(), 1027L);
            return;
        }
        com.vivo.push.util.u.d("OnNotificationArrivedTask", "tragetType is " + insideNotificationItemD.getTargetType() + " ; target is " + insideNotificationItemD.getTragetContent());
        com.vivo.push.t.c(new v(this, insideNotificationItemD, qVar));
    }
}
