package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;
import com.xiaomi.push.service.aj;

/* loaded from: classes2.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        he heVar = new he();
        heVar.c(gp.VRUpload.f597a);
        heVar.b(b.m75a(context).m76a());
        heVar.d(context.getPackageName());
        heVar.a("data", str);
        heVar.a(aj.a());
        u.a(context).a((u) heVar, gf.Notification, (gs) null);
    }
}
