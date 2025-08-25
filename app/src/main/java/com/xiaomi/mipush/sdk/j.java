package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static volatile j f12379a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f122a;

    private j(Context context) {
        this.f122a = context.getApplicationContext();
    }

    private static j a(Context context) {
        if (f12379a == null) {
            synchronized (j.class) {
                if (f12379a == null) {
                    f12379a = new j(context);
                }
            }
        }
        return f12379a;
    }

    public static void b(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 2, z);
    }

    public static void c(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 3, z);
    }

    public static void d(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 4, z);
    }

    public static void e(Context context, hb hbVar, boolean z) {
        b bVarM75a = b.m75a(context);
        if (TextUtils.isEmpty(bVarM75a.m83c()) || TextUtils.isEmpty(bVarM75a.d())) {
            a(context).a(hbVar, 6, z);
        } else if (bVarM75a.m87f()) {
            a(context).a(hbVar, 7, z);
        } else {
            a(context).a(hbVar, 5, z);
        }
    }

    public static void a(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 1, z);
    }

    public static void a(Context context, hb hbVar) {
        a(context).a(hbVar, 0, true);
    }

    private void a(hb hbVar, int i2, boolean z) {
        if (com.xiaomi.push.j.m627a(this.f122a) || !com.xiaomi.push.j.m626a() || hbVar == null || hbVar.f717a != gf.SendMessage || hbVar.m529a() == null || !z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("click to start activity result:" + String.valueOf(i2));
        he heVar = new he(hbVar.m529a().m495a(), false);
        heVar.c(gp.SDK_START_ACTIVITY.f597a);
        heVar.b(hbVar.m530a());
        heVar.d(hbVar.f724b);
        heVar.f736a = new HashMap();
        heVar.f736a.put("result", String.valueOf(i2));
        u.a(this.f122a).a(heVar, gf.Notification, false, false, null, true, hbVar.f724b, hbVar.f720a, true, false);
    }
}
