package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.go;
import com.xiaomi.push.gq;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ai {

    /* renamed from: com.xiaomi.push.service.ai$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13338a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f13339b = new int[gm.values().length];

        static {
            try {
                f13339b[gm.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13339b[gm.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13339b[gm.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13339b[gm.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f13338a = new int[gl.values().length];
            try {
                f13338a[gl.MISC_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13338a[gl.PLUGIN_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static void a(ah ahVar, hd hdVar) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", "-->updateNormalConfigs(): onlineConfig=", ahVar, ", configMessage=", hdVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (go goVar : hdVar.a()) {
            arrayList.add(new Pair<>(goVar.m476a(), Integer.valueOf(goVar.a())));
            List<Pair<Integer, Object>> listA = a(goVar.f595a, false);
            if (!com.xiaomi.push.z.a(listA)) {
                arrayList2.addAll(listA);
            }
        }
        ahVar.a(arrayList, arrayList2);
        ahVar.b();
    }

    public static void a(ah ahVar, hc hcVar) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", "-->updateCustomConfigs(): onlineConfig=", ahVar, ", configMessage=", hcVar);
        ahVar.a(a(hcVar.a(), true));
        ahVar.b();
    }

    public static int a(ah ahVar, gl glVar) {
        int i2 = 0;
        if (AnonymousClass1.f13338a[glVar.ordinal()] == 1) {
            i2 = 1;
        }
        return ahVar.a(glVar, i2);
    }

    private static List<Pair<Integer, Object>> a(List<gq> list, boolean z) {
        Pair pair;
        if (com.xiaomi.push.z.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (gq gqVar : list) {
            int iA = gqVar.a();
            gm gmVarA = gm.a(gqVar.b());
            if (gmVarA != null) {
                if (z && gqVar.f603a) {
                    arrayList.add(new Pair(Integer.valueOf(iA), null));
                } else {
                    int i2 = AnonymousClass1.f13339b[gmVarA.ordinal()];
                    if (i2 == 1) {
                        pair = new Pair(Integer.valueOf(iA), Integer.valueOf(gqVar.c()));
                    } else if (i2 == 2) {
                        pair = new Pair(Integer.valueOf(iA), Long.valueOf(gqVar.m480a()));
                    } else if (i2 != 3) {
                        pair = i2 != 4 ? null : new Pair(Integer.valueOf(iA), Boolean.valueOf(gqVar.g()));
                    } else {
                        pair = new Pair(Integer.valueOf(iA), gqVar.m481a());
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }
}
