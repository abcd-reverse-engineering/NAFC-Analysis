package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.f.u;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: classes2.dex */
final class w implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f12073a;

    w(v vVar) {
        this.f12073a = vVar;
    }

    @Override // com.vivo.push.f.u.a
    public final void a() {
        long jK = com.vivo.push.m.a().k();
        if (jK < 1400 && jK != 1340) {
            com.vivo.push.util.u.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(jK)));
            return;
        }
        HashMap map = new HashMap();
        map.put("srt", "1");
        map.put("message_id", String.valueOf(this.f12073a.f12071b.f()));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("app_id", strA);
        }
        map.put("type", "1");
        map.put("dtp", "1");
        com.vivo.push.util.f.a(6L, (HashMap<String, String>) map);
    }

    @Override // com.vivo.push.f.u.a
    public final void b() {
        HashMap map = new HashMap();
        map.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(this.f12073a.f12071b.f()));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        com.vivo.push.util.f.a(2122L, (HashMap<String, String>) map);
    }
}
