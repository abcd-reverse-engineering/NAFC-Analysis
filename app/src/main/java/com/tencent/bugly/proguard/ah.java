package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ah {
    public static bl a(UserInfoBean userInfoBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (userInfoBean == null) {
            return null;
        }
        bl blVar = new bl();
        blVar.f9361a = userInfoBean.f8931e;
        blVar.f9365e = userInfoBean.f8936j;
        blVar.f9364d = userInfoBean.f8929c;
        blVar.f9363c = userInfoBean.f8930d;
        blVar.f9367g = com.tencent.bugly.crashreport.common.info.a.b().i();
        blVar.f9368h = userInfoBean.o == 1;
        int i2 = userInfoBean.f8928b;
        if (i2 == 1) {
            blVar.f9362b = (byte) 1;
        } else if (i2 == 2) {
            blVar.f9362b = (byte) 4;
        } else if (i2 == 3) {
            blVar.f9362b = (byte) 2;
        } else if (i2 == 4) {
            blVar.f9362b = (byte) 3;
        } else {
            if (i2 < 10 || i2 >= 20) {
                an.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f8928b));
                return null;
            }
            blVar.f9362b = (byte) i2;
        }
        blVar.f9366f = new HashMap();
        if (userInfoBean.p >= 0) {
            blVar.f9366f.put("C01", "" + userInfoBean.p);
        }
        if (userInfoBean.q >= 0) {
            blVar.f9366f.put("C02", "" + userInfoBean.q);
        }
        Map<String, String> map = userInfoBean.r;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                blVar.f9366f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = userInfoBean.s;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                blVar.f9366f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map3 = blVar.f9366f;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(!userInfoBean.f8938l);
        map3.put("A36", sb.toString());
        blVar.f9366f.put("F02", "" + userInfoBean.f8933g);
        blVar.f9366f.put("F03", "" + userInfoBean.f8934h);
        blVar.f9366f.put("F04", "" + userInfoBean.f8936j);
        blVar.f9366f.put("F05", "" + userInfoBean.f8935i);
        blVar.f9366f.put("F06", "" + userInfoBean.f8939m);
        blVar.f9366f.put("F10", "" + userInfoBean.f8937k);
        an.c("summary type %d vm:%d", Byte.valueOf(blVar.f9362b), Integer.valueOf(blVar.f9366f.size()));
        return blVar;
    }

    public static bm a(List<UserInfoBean> list, int i2) {
        com.tencent.bugly.crashreport.common.info.a aVarB;
        if (list == null || list.size() == 0 || (aVarB = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        aVarB.t();
        bm bmVar = new bm();
        bmVar.f9372b = aVarB.f8978e;
        bmVar.f9373c = aVarB.h();
        ArrayList<bl> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            bl blVarA = a(it.next(), aVarB);
            if (blVarA != null) {
                arrayList.add(blVarA);
            }
        }
        bmVar.f9374d = arrayList;
        bmVar.f9375e = new HashMap();
        bmVar.f9375e.put("A7", "" + aVarB.f8985l);
        bmVar.f9375e.put("A6", "" + aVarB.s());
        bmVar.f9375e.put("A5", "" + aVarB.r());
        bmVar.f9375e.put("A2", "" + aVarB.p());
        bmVar.f9375e.put("A1", "" + aVarB.p());
        bmVar.f9375e.put("A24", "" + aVarB.n);
        bmVar.f9375e.put("A17", "" + aVarB.q());
        bmVar.f9375e.put("A15", "" + aVarB.w());
        bmVar.f9375e.put("A13", "" + aVarB.x());
        bmVar.f9375e.put("F08", "" + aVarB.C);
        bmVar.f9375e.put("F09", "" + aVarB.D);
        Map<String, String> mapG = aVarB.G();
        if (mapG != null && mapG.size() > 0) {
            for (Map.Entry<String, String> entry : mapG.entrySet()) {
                bmVar.f9375e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                an.e("unknown up type %d ", Integer.valueOf(i2));
                return null;
            }
            bmVar.f9371a = (byte) 2;
        } else {
            bmVar.f9371a = (byte) 1;
        }
        return bmVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                tNewInstance.a(kVar);
                return tNewInstance;
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bh a(Context context, int i2, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (aVarB != null && strategyBeanC != null) {
            try {
                bh bhVar = new bh();
                synchronized (aVarB) {
                    bhVar.f9322a = aVarB.f8976c;
                    bhVar.f9323b = aVarB.f();
                    bhVar.f9324c = aVarB.f8977d;
                    bhVar.f9325d = aVarB.p;
                    bhVar.f9326e = aVarB.s;
                    bhVar.f9327f = aVarB.f8983j;
                    bhVar.f9328g = i2;
                    bhVar.f9329h = bArr == null ? "".getBytes() : bArr;
                    bhVar.f9330i = aVarB.f8986m;
                    bhVar.f9331j = aVarB.n;
                    bhVar.f9332k = new HashMap();
                    bhVar.f9333l = aVarB.e();
                    bhVar.f9334m = strategyBeanC.p;
                    bhVar.o = aVarB.h();
                    bhVar.p = com.tencent.bugly.crashreport.common.info.b.f(context);
                    bhVar.q = System.currentTimeMillis();
                    bhVar.r = "" + aVarB.k();
                    bhVar.s = aVarB.j();
                    bhVar.t = "" + aVarB.m();
                    bhVar.u = aVarB.l();
                    bhVar.v = "" + aVarB.n();
                    bhVar.w = bhVar.p;
                    aVarB.getClass();
                    bhVar.n = "com.tencent.bugly";
                    bhVar.f9332k.put("A26", "" + aVarB.y());
                    bhVar.f9332k.put("A60", "" + aVarB.z());
                    bhVar.f9332k.put("A61", "" + aVarB.A());
                    bhVar.f9332k.put("A62", "" + aVarB.R());
                    bhVar.f9332k.put("A63", "" + aVarB.S());
                    bhVar.f9332k.put("F11", "" + aVarB.H);
                    bhVar.f9332k.put("F12", "" + aVarB.G);
                    bhVar.f9332k.put("G1", "" + aVarB.u());
                    bhVar.f9332k.put("A64", "" + aVarB.T());
                    if (aVarB.L) {
                        bhVar.f9332k.put("G2", "" + aVarB.L());
                        bhVar.f9332k.put("G3", "" + aVarB.M());
                        bhVar.f9332k.put("G4", "" + aVarB.N());
                        bhVar.f9332k.put("G5", "" + aVarB.O());
                        bhVar.f9332k.put("G6", "" + aVarB.P());
                        bhVar.f9332k.put("G7", "" + Long.toString(aVarB.Q()));
                    }
                    bhVar.f9332k.put("D3", "" + aVarB.r);
                    if (com.tencent.bugly.b.f8758b != null) {
                        for (com.tencent.bugly.a aVar : com.tencent.bugly.b.f8758b) {
                            if (aVar.versionKey != null && aVar.version != null) {
                                bhVar.f9332k.put(aVar.versionKey, aVar.version);
                            }
                        }
                    }
                    bhVar.f9332k.put("G15", aq.c("G15", ""));
                    bhVar.f9332k.put("D4", aq.c("D4", "0"));
                }
                ak akVarA = ak.a();
                if (akVarA != null && !akVarA.f9215b && bArr != null) {
                    bhVar.f9329h = aq.a(bhVar.f9329h, 2, 1, strategyBeanC.u);
                    if (bhVar.f9329h == null) {
                        an.e("reqPkg sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                Map<String, String> mapF = aVarB.F();
                if (mapF != null) {
                    for (Map.Entry<String, String> entry : mapF.entrySet()) {
                        bhVar.f9332k.put(entry.getKey(), entry.getValue());
                    }
                }
                return bhVar;
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        an.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.a(1);
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", (String) obj);
            return eVar.a();
        } catch (Throwable th) {
            if (an.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static bi a(byte[] bArr, StrategyBean strategyBean, boolean z) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                Object objB = eVar.b("detail", new bi());
                bi biVar = bi.class.isInstance(objB) ? (bi) bi.class.cast(objB) : null;
                if (!z && biVar != null && biVar.f9339c != null && biVar.f9339c.length > 0) {
                    an.c("resp buf %d", Integer.valueOf(biVar.f9339c.length));
                    biVar.f9339c = aq.b(biVar.f9339c, 2, 1, StrategyBean.f8995d);
                    if (biVar.f9339c == null) {
                        an.e("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return biVar;
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            return lVar.b();
        } catch (Throwable th) {
            if (an.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
