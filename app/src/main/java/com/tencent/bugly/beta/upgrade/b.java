package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.bh;
import com.tencent.bugly.proguard.m;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f8859a = new b();

    public synchronized void a(int i2, int i3, byte[] bArr, a aVar, boolean z, String str) {
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            bh bhVarA = ah.a(e.G.u, i2, bArr);
            if (bhVarA != null) {
                e eVar = e.G;
                bhVarA.f9323b = eVar.w;
                if (!TextUtils.isEmpty(eVar.R)) {
                    bhVarA.f9326e = eVar.R;
                }
                if (bhVarA.f9332k != null) {
                    bhVarA.f9332k.put("G6", eVar.x);
                    bhVarA.f9332k.put("G10", "1.4.5");
                    bhVarA.f9332k.put("G3", "" + eVar.z);
                    bhVarA.f9332k.put("G11", String.valueOf(eVar.y));
                    bhVarA.f9332k.put("G7", "" + aVarB.m());
                    bhVarA.f9332k.put("G8", "" + aVarB.k());
                    bhVarA.f9332k.put("G9", "" + aVarB.l());
                    bhVarA.f9332k.put("G2", String.valueOf(com.tencent.bugly.beta.global.a.a(e.G.u)));
                    bhVarA.f9332k.put("G12", String.valueOf(eVar.q < 0 ? 0 : eVar.q));
                    bhVarA.f9332k.put("A21", "" + aVarB.g());
                    bhVarA.f9332k.put("A22", "" + aVarB.h());
                    bhVarA.f9332k.put("G13", "" + eVar.L);
                    bhVarA.f9332k.put("G14", "" + eVar.M);
                    bhVarA.f9332k.put("G15", "" + eVar.O);
                    bhVarA.f9332k.put("G17", "" + aVarB.x());
                    bhVarA.f9332k.put("C01", "" + aVarB.H());
                    bhVarA.f9332k.put("G18", "" + aVarB.g());
                    bhVarA.f9332k.put("strategyType", "" + i3);
                    bhVarA.f9332k.put("strategyRequestManner", "" + z);
                    Map<String, String> mapB = aVarB.B();
                    if (mapB != null && mapB.size() > 0) {
                        for (Map.Entry<String, String> entry : mapB.entrySet()) {
                            bhVarA.f9332k.put("C03_" + entry.getKey(), entry.getValue());
                        }
                    }
                    an.c("app version is: [%s.%s], [deviceId:%s], channel: [%s], buildNo: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s], strategyType:[%s]", eVar.z, Integer.valueOf(eVar.y), aVarB.h(), bhVarA.f9326e, Integer.valueOf(eVar.q), eVar.L, eVar.M, eVar.O, Integer.valueOf(i3));
                    HashMap map = new HashMap();
                    map.put("grayStrategyUpdateTime", e.G.H.f8854b + "");
                    if (z) {
                        ak.a().a(1002, bhVarA.f9328g, ah.a((Object) bhVarA), str, str, aVar, 0, 1, true, map);
                    } else {
                        ak.a().a(1002, bhVarA.f9328g, ah.a((Object) bhVarA), str, str, (aj) aVar, false, (Map<String, String>) map);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (!an.a(th)) {
                th.printStackTrace();
            }
            aVar.a(i2, null, 0L, 0L, false, "sendRequest failed");
        }
    }

    public synchronized void a(w wVar, boolean z) {
        if (wVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(wVar);
        x xVar = new x(arrayList);
        try {
            a(803, -1, ah.a((m) xVar), new a(2, 803, xVar, Boolean.valueOf(z)), false, e.G.H.f8853a.f9351d);
        } catch (Throwable th) {
            if (!an.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a(x xVar, boolean z) {
        if (xVar == null) {
            return;
        }
        try {
            a(803, -1, ah.a((m) xVar), new a(2, 803, xVar, Boolean.valueOf(z)), false, e.G.H.f8853a.f9351d);
        } catch (Throwable th) {
            if (!an.b(th)) {
                th.printStackTrace();
            }
        }
    }
}
