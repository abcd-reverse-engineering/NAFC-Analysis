package com.xiaomi.push.service;

import com.xiaomi.push.C0343r;
import com.xiaomi.push.he;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static a f13422a;

    /* renamed from: a, reason: collision with other field name */
    private static b f1043a;

    public interface a {
        boolean a(he heVar);
    }

    public interface b {
    }

    public static void a(b bVar) {
        f1043a = bVar;
    }

    public static boolean a(he heVar) {
        if (f13422a == null || heVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("rc params is null, not cpra");
            return false;
        }
        if (com.xiaomi.push.j.m627a(C0343r.m636a())) {
            return f13422a.a(heVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("rc app not permission to cpra");
        return false;
    }
}
