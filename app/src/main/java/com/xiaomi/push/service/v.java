package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import java.util.Map;

/* loaded from: classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static a f13470a;

    /* renamed from: a, reason: collision with other field name */
    private static b f1085a;

    public interface a {
        Map<String, String> a(Context context, hb hbVar);

        /* renamed from: a, reason: collision with other method in class */
        void m750a(Context context, hb hbVar);

        void a(Context context, hb hbVar, he heVar);

        boolean a(Context context, hb hbVar, boolean z);
    }

    public interface b {
        void a(hb hbVar);

        void a(String str);

        /* renamed from: a, reason: collision with other method in class */
        boolean m751a(hb hbVar);
    }

    public static void a(Context context, hb hbVar, he heVar) {
        a aVar = f13470a;
        if (aVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        } else {
            aVar.a(context, hbVar, heVar);
        }
    }

    public static boolean a(Context context, hb hbVar, boolean z) {
        a aVar = f13470a;
        if (aVar != null && hbVar != null) {
            return aVar.a(context, hbVar, z);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("pepa judement listener or container is null");
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m748a(Context context, hb hbVar) {
        a aVar = f13470a;
        if (aVar != null && hbVar != null) {
            aVar.m750a(context, hbVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a("handle msg wrong");
        }
    }

    public static Map<String, String> a(Context context, hb hbVar) {
        a aVar = f13470a;
        if (aVar != null && hbVar != null) {
            return aVar.a(context, hbVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("pepa listener or container is null");
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m749a(hb hbVar) {
        b bVar = f1085a;
        if (bVar != null && hbVar != null) {
            return bVar.m751a(hbVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("pepa handleReceiveMessage is null");
        return false;
    }

    public static void a(hb hbVar) {
        b bVar = f1085a;
        if (bVar != null && hbVar != null) {
            bVar.a(hbVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a("pepa clearMessage is null");
        }
    }

    public static void a(String str) {
        b bVar = f1085a;
        if (bVar != null && str != null) {
            bVar.a(str);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a("pepa clearMessage is null");
        }
    }
}
