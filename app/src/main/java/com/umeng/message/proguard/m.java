package com.umeng.message.proguard;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.cw;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
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

/* loaded from: classes2.dex */
final class m implements Runnable {
    m() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (f.f11348a) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(x.a());
            if (messageSharedPrefs.f11129c == null) {
                try {
                    if (f.b(messageSharedPrefs.f11127a)) {
                        messageSharedPrefs.f11128b.a(com.umeng.socialize.a.a.f11538d, messageSharedPrefs.m() + 1);
                    }
                } finally {
                    messageSharedPrefs.f11129c = Boolean.TRUE;
                }
            }
            if (messageSharedPrefs.m() >= messageSharedPrefs.f11128b.b(com.umeng.socialize.a.a.f11540f, 0) && messageSharedPrefs.a(com.umeng.socialize.a.a.f11539e)) {
                try {
                    final Application applicationA = x.a();
                    final String appkey = UMUtils.getAppkey(applicationA);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(bh.al, UMUtils.getZid(applicationA));
                    try {
                        jSONObject.put("imei", DeviceConfig.getImeiNew(applicationA));
                        jSONObject.put("oaid", DeviceConfig.getOaid(applicationA));
                    } catch (Throwable unused) {
                    }
                    try {
                        jSONObject.put("idfa", DeviceConfig.getIdfa(applicationA));
                    } catch (Throwable unused2) {
                    }
                    jSONObject.put("umid", d.k(applicationA));
                    jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, d.e(applicationA));
                    jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                    jSONObject.put("os_v", Build.VERSION.RELEASE);
                    jSONObject.put("lvl", Build.VERSION.SDK_INT);
                    String[] networkAccessMode = UMUtils.getNetworkAccessMode(applicationA);
                    if (TextUtils.isEmpty(networkAccessMode[0])) {
                        networkAccessMode[0] = "Unknown";
                    }
                    jSONObject.put("net", networkAccessMode[0]);
                    jSONObject.put("brand", d.f());
                    long jB = messageSharedPrefs.f11128b.b("smart_ts", 0L);
                    if (jB > 0) {
                        jSONObject.put("last", jB);
                    }
                    JSONObject jSONObjectA = null;
                    try {
                        jSONObjectA = g.a(jSONObject, "https://ccs.umeng.com/aa", appkey, false);
                    } catch (Exception unused3) {
                    }
                    if (jSONObjectA == null) {
                        messageSharedPrefs.a(com.umeng.socialize.a.a.f11539e, 7200L);
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject("data");
                    if (jSONObjectOptJSONObject == null) {
                        messageSharedPrefs.a(com.umeng.socialize.a.a.f11539e, 7200L);
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("aa");
                    if (jSONObjectOptJSONObject2 == null) {
                        jSONObjectOptJSONObject2 = new JSONObject();
                    }
                    int iOptInt = jSONObjectOptJSONObject2.optInt("launch", 5);
                    messageSharedPrefs.f11128b.a(com.umeng.socialize.a.a.f11540f, iOptInt);
                    if (messageSharedPrefs.m() < iOptInt) {
                        return;
                    }
                    messageSharedPrefs.a(com.umeng.socialize.a.a.f11539e, jSONObjectOptJSONObject.optLong(RemoteMessageConst.TTL, 86400L));
                    final long jOptLong = jSONObjectOptJSONObject.optLong("id", -1L);
                    if (jOptLong <= 0) {
                        return;
                    }
                    final int iMax = Math.max(jSONObjectOptJSONObject2.optInt(com.umeng.ccg.a.s, 300), 100);
                    final int iOptInt2 = jSONObjectOptJSONObject2.optInt("action", 1);
                    int iOptInt3 = jSONObjectOptJSONObject2.optInt("delay");
                    if (iOptInt2 == 1 || iOptInt2 == 2) {
                        b.a(new Runnable() { // from class: com.umeng.message.proguard.m.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ByteArrayOutputStream byteArrayOutputStream;
                                TreeSet treeSet;
                                try {
                                    treeSet = new TreeSet();
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = null;
                                }
                                try {
                                    byte[] bArr = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, cw.f10302l, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, cw.f10301k, 3, 21, 21, 12, 40, cw.f10302l, 29};
                                    byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 179, 187);
                                    byte[] bArrCopyOf = Arrays.copyOf(bArr, 179);
                                    ay.a(bArrCopyOf, bArrCopyOfRange);
                                    bc.b(bArrCopyOf, byteArrayOutputStream);
                                    JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream.toString());
                                    Object objA = ba.a(jSONObject2.optString(bh.aI), jSONObject2.optString(bh.aA), null, applicationA, null);
                                    if (1 == iOptInt2) {
                                        Object objA2 = ba.a(jSONObject2.optString("m"), jSONObject2.optString("q"), new Class[]{ba.a(jSONObject2.optString(bh.aF)), Integer.TYPE}, objA, new Object[]{ba.a(jSONObject2.optString(bh.aF), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject2.optString(bh.ay)}), 0});
                                        if (objA2 instanceof List) {
                                            Field fieldA = ba.a(jSONObject2.optString("r"), jSONObject2.optString(bh.aE));
                                            Field fieldA2 = ba.a(jSONObject2.optString("t"), jSONObject2.optString("n"));
                                            Iterator it = ((List) objA2).iterator();
                                            while (it.hasNext()) {
                                                Object objA3 = ba.a(fieldA2, ba.a(fieldA, it.next()));
                                                if (objA3 != null) {
                                                    treeSet.add((String) objA3);
                                                }
                                            }
                                        }
                                    } else {
                                        Object objA4 = ba.a(jSONObject2.optString("m"), jSONObject2.optString(bh.aK), new Class[]{Integer.TYPE}, objA, new Object[]{0});
                                        if (objA4 instanceof List) {
                                            Field fieldA3 = ba.a(jSONObject2.optString("v"), jSONObject2.optString("n"));
                                            Iterator it2 = ((List) objA4).iterator();
                                            while (it2.hasNext()) {
                                                Object objA5 = ba.a(fieldA3, it2.next());
                                                if (objA5 != null) {
                                                    treeSet.add((String) objA5);
                                                }
                                            }
                                        }
                                    }
                                    if (treeSet.isEmpty()) {
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
                                        Object objA6 = f.a(objA, (String) it3.next());
                                        if (objA6 != null) {
                                            l lVar = new l(objA, objA6);
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put(bh.ay, lVar.f11373b);
                                            jSONObject3.put(bh.aA, lVar.f11372a);
                                            jSONObject3.put("v", lVar.f11374c);
                                            jSONObject3.put("t", lVar.f11377f);
                                            jSONObject3.put(bh.aF, lVar.f11375d);
                                            jSONObject3.put(bh.aK, lVar.f11376e);
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
                                    if (arrayList.isEmpty()) {
                                        return;
                                    }
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put(bh.al, UMUtils.getZid(applicationA));
                                    jSONObject4.put("appkey", appkey);
                                    jSONObject4.put("umid", d.k(applicationA));
                                    jSONObject4.put("v", "2.0");
                                    jSONObject4.put("sdk_v", MsgConstant.SDK_VERSION);
                                    jSONObject4.put("os_v", Build.VERSION.RELEASE);
                                    jSONObject4.put("brand", d.f());
                                    jSONObject4.put(Constants.KEY_MODEL, d.d());
                                    jSONObject4.put("smart_id", jOptLong);
                                    jSONObject4.put("src", "push");
                                    jSONObject4.put("imei", DeviceConfig.getImeiNew(applicationA));
                                    try {
                                        jSONObject4.put("oaid", DeviceConfig.getOaid(applicationA));
                                    } catch (Throwable unused4) {
                                    }
                                    try {
                                        jSONObject4.put("idfa", DeviceConfig.getIdfa(applicationA));
                                    } catch (Throwable unused5) {
                                    }
                                    jSONObject4.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, d.e(applicationA));
                                    jSONObject4.put("pkg", applicationA.getPackageName());
                                    jSONObject4.put("app_v", UMUtils.getAppVersionName(applicationA));
                                    jSONObject4.put("board", d.e());
                                    try {
                                        Locale locale = UMUtils.getLocale(applicationA);
                                        if (locale != null) {
                                            jSONObject4.put("os_lang", locale.getLanguage());
                                        }
                                    } catch (Throwable unused6) {
                                    }
                                    jSONObject4.put("c_ts", System.currentTimeMillis());
                                    jSONObject4.put("total", i2);
                                    try {
                                        jSONObject4.put("os_i", Build.VERSION.SDK_INT);
                                        jSONObject4.put("os_t", applicationA.getApplicationInfo().targetSdkVersion);
                                        jSONObject4.put("grant", f.f(applicationA) ? 1 : 0);
                                    } catch (Throwable unused7) {
                                    }
                                    Iterator it4 = arrayList.iterator();
                                    int i3 = 0;
                                    while (it4.hasNext()) {
                                        JSONArray jSONArray2 = (JSONArray) it4.next();
                                        i3++;
                                        jSONObject4.put(com.umeng.ccg.a.s, i3);
                                        jSONObject4.put("data", jSONArray2);
                                        try {
                                            g.b(jSONObject4, com.umeng.socialize.a.a.f11536b, appkey);
                                        } catch (Exception e2) {
                                            throw e2;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        UPLog.e("App", th.getMessage());
                                    } finally {
                                        f.a(byteArrayOutputStream);
                                    }
                                }
                            }
                        }, iOptInt3, TimeUnit.SECONDS);
                    }
                } catch (Throwable unused4) {
                }
            }
        }
    }
}
