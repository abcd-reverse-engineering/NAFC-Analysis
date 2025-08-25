package com.umeng.socialize.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.cw;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UMAppScanTask.java */
/* loaded from: classes2.dex */
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11562a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f11563b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static final String f11564c = "AZX";

    g() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (UMShareAPI.getSmartEnableFlag()) {
            e eVarA = e.a(ContextUtil.getContext());
            eVarA.e();
            int iC = eVarA.c();
            long jD = eVarA.d();
            if (jD < iC) {
                if (a.f11537c) {
                    m.a(f11564c, "launch times skipped. times:", Long.valueOf(jD), " config:", Integer.valueOf(iC));
                    return;
                }
                return;
            }
            if (!eVarA.b()) {
                if (a.f11537c) {
                    m.a(f11564c, "interval skipped.");
                    return;
                }
                return;
            }
            try {
                final Context context = ContextUtil.getContext();
                final String appkey = UMUtils.getAppkey(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(bh.al, UMUtils.getZid(context));
                try {
                    jSONObject.put("imei", DeviceConfig.getImeiNew(context));
                    jSONObject.put("oaid", DeviceConfig.getOaid(context));
                } catch (Throwable unused) {
                }
                try {
                    jSONObject.put("idfa", DeviceConfig.getIdfa(context));
                } catch (Throwable unused2) {
                }
                jSONObject.put("umid", UMUtils.getUMId(context));
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                jSONObject.put("sdk_v", "7.3.2");
                jSONObject.put("os_v", Build.VERSION.RELEASE);
                jSONObject.put("lvl", Build.VERSION.SDK_INT);
                String[] networkAccessMode = UMUtils.getNetworkAccessMode(context);
                if (TextUtils.isEmpty(networkAccessMode[0])) {
                    networkAccessMode[0] = "Unknown";
                }
                jSONObject.put("net", networkAccessMode[0]);
                jSONObject.put("brand", c.a());
                long jA = eVarA.a();
                if (jA > 0) {
                    jSONObject.put("last", jA);
                }
                JSONObject jSONObjectA = null;
                try {
                    jSONObjectA = d.a(jSONObject, a.f11535a, appkey, a.f11537c);
                } catch (Exception e2) {
                    if (a.f11537c) {
                        m.d(f11564c, "request failed. ", e2.getMessage());
                    }
                }
                if (jSONObjectA == null) {
                    if (a.f11537c) {
                        m.a(f11564c, "response == null");
                    }
                    eVarA.a(7200L);
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    if (a.f11537c) {
                        m.a(f11564c, "data empty skipped.");
                    }
                    eVarA.a(7200L);
                    return;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("aa");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                }
                int iOptInt = jSONObjectOptJSONObject2.optInt("launch", 5);
                eVarA.a(iOptInt);
                if (eVarA.d() < iOptInt) {
                    if (a.f11537c) {
                        m.a(f11564c, "launch times skipped. config:", Integer.valueOf(iOptInt));
                        return;
                    }
                    return;
                }
                eVarA.a(jSONObjectOptJSONObject.optLong(RemoteMessageConst.TTL, 86400L));
                final long jOptLong = jSONObjectOptJSONObject.optLong("id", -1L);
                if (jOptLong <= 0) {
                    if (a.f11537c) {
                        m.a(f11564c, "id skipped, id:", Long.valueOf(jOptLong));
                        return;
                    }
                    return;
                }
                final int iMax = Math.max(jSONObjectOptJSONObject2.optInt(com.umeng.ccg.a.s, 300), 100);
                final int iOptInt2 = jSONObjectOptJSONObject2.optInt("action", 1);
                int iOptInt3 = jSONObjectOptJSONObject2.optInt("delay");
                if (iOptInt2 == 1 || iOptInt2 == 2) {
                    j.a(new Runnable() { // from class: com.umeng.socialize.a.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ByteArrayOutputStream byteArrayOutputStream;
                            TreeSet treeSet;
                            Object objA;
                            try {
                                treeSet = new TreeSet();
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = null;
                            }
                            try {
                                byte[] bArr = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, cw.f10302l, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, cw.f10301k, 3, 21, 21, 12, 40, cw.f10302l, 29};
                                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, bArr.length - 8, bArr.length);
                                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length - 8);
                                i.a(bArrCopyOf, bArrCopyOfRange);
                                l.b(bArrCopyOf, byteArrayOutputStream);
                                JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream.toString());
                                if (a.f11537c) {
                                    m.a(g.f11564c, jSONObject2.toString());
                                }
                                objA = k.a(jSONObject2.optString(bh.aI), jSONObject2.optString(bh.aA), null, context, null);
                                if (1 == iOptInt2) {
                                    Object objA2 = k.a(jSONObject2.optString("m"), jSONObject2.optString("q"), new Class[]{k.a(jSONObject2.optString(bh.aF)), Integer.TYPE}, objA, new Object[]{k.a(jSONObject2.optString(bh.aF), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject2.optString(bh.ay)}), 0});
                                    if (objA2 instanceof List) {
                                        Field fieldA = k.a(jSONObject2.optString("r"), jSONObject2.optString(bh.aE));
                                        Field fieldA2 = k.a(jSONObject2.optString("t"), jSONObject2.optString("n"));
                                        Iterator it = ((List) objA2).iterator();
                                        while (it.hasNext()) {
                                            Object objA3 = k.a(fieldA2, k.a(fieldA, it.next()));
                                            if (objA3 != null) {
                                                treeSet.add((String) objA3);
                                            }
                                        }
                                        if (a.f11537c) {
                                            m.a(g.f11564c, "size:" + treeSet.size());
                                        }
                                    }
                                } else {
                                    Object objA4 = k.a(jSONObject2.optString("m"), jSONObject2.optString(bh.aK), new Class[]{Integer.TYPE}, objA, new Object[]{0});
                                    if (objA4 instanceof List) {
                                        Field fieldA3 = k.a(jSONObject2.optString("v"), jSONObject2.optString("n"));
                                        Iterator it2 = ((List) objA4).iterator();
                                        while (it2.hasNext()) {
                                            Object objA5 = k.a(fieldA3, it2.next());
                                            if (objA5 != null) {
                                                treeSet.add((String) objA5);
                                            }
                                        }
                                        if (a.f11537c) {
                                            m.a(g.f11564c, "size:" + treeSet.size());
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    m.d(g.f11564c, th.getMessage());
                                } finally {
                                    c.a(byteArrayOutputStream);
                                }
                            }
                            if (treeSet.isEmpty()) {
                                if (a.f11537c) {
                                    m.a(g.f11564c, "app list empty!");
                                }
                                return;
                            }
                            if (objA == null) {
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it3 = treeSet.iterator();
                            int i2 = 0;
                            while (it3.hasNext()) {
                                Object objA6 = c.a(objA, (String) it3.next(), 0);
                                if (objA6 != null) {
                                    f fVar = new f(objA, objA6);
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(bh.ay, fVar.f11557b);
                                    jSONObject3.put(bh.aA, fVar.f11556a);
                                    jSONObject3.put("v", fVar.f11558c);
                                    jSONObject3.put("t", fVar.f11561f);
                                    jSONObject3.put(bh.aF, fVar.f11559d);
                                    jSONObject3.put(bh.aK, fVar.f11560e);
                                    jSONArray.put(jSONObject3);
                                    i2++;
                                    if (jSONArray.length() == iMax) {
                                        arrayList.add(jSONArray);
                                        jSONArray = new JSONArray();
                                    }
                                }
                            }
                            if (jSONArray.length() > 0) {
                                arrayList.add(jSONArray);
                            }
                            if (a.f11537c) {
                                m.a(g.f11564c, "total:", Integer.valueOf(i2));
                                Iterator it4 = arrayList.iterator();
                                while (it4.hasNext()) {
                                    JSONArray jSONArray2 = (JSONArray) it4.next();
                                    m.c(g.f11564c, "--- start ---");
                                    m.b(g.f11564c, "--- size:", Integer.valueOf(jSONArray2.length()));
                                    m.b(g.f11564c, jSONArray2);
                                    m.c(g.f11564c, "--- end ---");
                                }
                            }
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(bh.al, UMUtils.getZid(context));
                            jSONObject4.put("appkey", appkey);
                            jSONObject4.put("umid", UMUtils.getUMId(context));
                            jSONObject4.put("v", "2.0");
                            jSONObject4.put("sdk_v", "7.3.2");
                            jSONObject4.put("os_v", Build.VERSION.RELEASE);
                            jSONObject4.put("brand", c.a());
                            jSONObject4.put(Constants.KEY_MODEL, c.b());
                            jSONObject4.put("smart_id", jOptLong);
                            jSONObject4.put("src", "share");
                            jSONObject4.put("imei", DeviceConfig.getImeiNew(context));
                            try {
                                jSONObject4.put("oaid", DeviceConfig.getOaid(context));
                            } catch (Throwable unused3) {
                            }
                            try {
                                jSONObject4.put("idfa", DeviceConfig.getIdfa(context));
                            } catch (Throwable unused4) {
                            }
                            jSONObject4.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                            jSONObject4.put("pkg", context.getPackageName());
                            jSONObject4.put("app_v", UMUtils.getAppVersionName(context));
                            jSONObject4.put("board", c.c());
                            try {
                                Locale locale = UMUtils.getLocale(context);
                                if (locale != null) {
                                    jSONObject4.put("os_lang", locale.getLanguage());
                                }
                            } catch (Throwable unused5) {
                            }
                            jSONObject4.put("c_ts", System.currentTimeMillis());
                            jSONObject4.put("total", i2);
                            try {
                                jSONObject4.put("os_i", Build.VERSION.SDK_INT);
                                jSONObject4.put("os_t", context.getApplicationInfo().targetSdkVersion);
                                jSONObject4.put("grant", c.b(context) ? 1 : 0);
                            } catch (Throwable unused6) {
                            }
                            Iterator it5 = arrayList.iterator();
                            int i3 = 0;
                            while (it5.hasNext()) {
                                JSONArray jSONArray3 = (JSONArray) it5.next();
                                i3++;
                                jSONObject4.put(com.umeng.ccg.a.s, i3);
                                jSONObject4.put("data", jSONArray3);
                                try {
                                    d.a(jSONObject4, a.f11536b, appkey);
                                } catch (Exception e3) {
                                    if (a.f11537c) {
                                        m.d(g.f11564c, "upload error:", e3.getMessage());
                                    }
                                    throw e3;
                                }
                            }
                        }
                    }, iOptInt3, TimeUnit.SECONDS);
                } else if (a.f11537c) {
                    m.a(f11564c, "action skipped. ", Integer.valueOf(iOptInt2));
                }
            } catch (Throwable th) {
                if (a.f11537c) {
                    m.d(f11564c, th.getMessage());
                }
            }
        }
    }
}
