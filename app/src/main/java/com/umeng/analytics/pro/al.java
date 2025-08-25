package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ModelHelper.java */
/* loaded from: classes2.dex */
public class al {
    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject = null;
        try {
            ak akVar = new ak();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            akVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            akVar.b(appkey);
            akVar.c(UMUtils.getAppVersionName(context));
            akVar.d("9.6.4");
            akVar.e(UMUtils.getChannel(context));
            akVar.f(Build.VERSION.SDK_INT + "");
            akVar.g(Build.BRAND);
            akVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            akVar.i(localeInfo[1]);
            akVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            akVar.b(Integer.valueOf(resolutionArray[1]));
            akVar.a(Integer.valueOf(resolutionArray[0]));
            akVar.k(ap.a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(ak.f10034a, akVar.a());
                    jSONObject2.put(ak.f10036c, akVar.c());
                    jSONObject2.put(ak.f10035b, akVar.b());
                    jSONObject2.put(ak.f10037d, akVar.d());
                    jSONObject2.put(ak.f10038e, akVar.e());
                    jSONObject2.put(ak.f10039f, akVar.f());
                    jSONObject2.put(ak.f10040g, akVar.g());
                    jSONObject2.put(ak.f10041h, akVar.h());
                    jSONObject2.put(ak.f10044k, akVar.k());
                    jSONObject2.put(ak.f10043j, akVar.j());
                    jSONObject2.put(ak.f10045l, akVar.l());
                    jSONObject2.put(ak.f10042i, akVar.i());
                    jSONObject2.put(ak.f10046m, akVar.m());
                    jSONObject2.put(bh.al, UMUtils.getZid(context));
                    jSONObject2.put("platform", DispatchConstants.ANDROID);
                    jSONObject2.put("optional", new JSONObject(ap.a()));
                    String[] strArrSplit = str.split("@");
                    if (strArrSplit.length == 4) {
                        try {
                            long j2 = Long.parseLong(strArrSplit[0]);
                            String str2 = strArrSplit[1];
                            jSONObject2.put("s1", j2);
                            jSONObject2.put("s2", str2);
                        } catch (Throwable unused) {
                        }
                    }
                    return jSONObject2;
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject = jSONObject2;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    jSONObject = jSONObject2;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                    return jSONObject;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject a(Context context, int i2, JSONArray jSONArray, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                String zid = UMUtils.getZid(context);
                if (TextUtils.isEmpty(zid)) {
                    return jSONObject;
                }
                jSONObject.put("atoken", zid);
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, deviceToken);
                }
                jSONObject.put(Constants.KEY_MODEL, Build.MODEL);
                jSONObject.put("os", DispatchConstants.ANDROID);
                jSONObject.put("os_version", Build.VERSION.RELEASE);
                jSONObject.put(com.umeng.ccg.a.o, str);
                jSONObject.put(com.umeng.ccg.a.r, jSONArray);
                jSONObject.put("e", i2);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
