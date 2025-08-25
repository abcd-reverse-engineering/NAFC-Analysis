package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Misc.java */
/* loaded from: classes2.dex */
public class ap {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(Context context, String str, String str2) {
        return context == null ? str2 : UMEnvelopeBuild.imprintProperty(context, str, str2);
    }

    public static void a(Context context, String str) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("processEvent", Context.class, String.class)) == null) {
                return;
            }
            declaredMethod.invoke(cls, context, str);
        } catch (Throwable unused) {
        }
    }

    public static Map<String, String> a() {
        HashMap map = new HashMap();
        map.put(bh.bd, com.umeng.commonsdk.internal.a.f10759e);
        if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
            map.put(bh.be, UMUtils.VALUE_ANALYTICS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
            map.put(bh.bf, UMUtils.VALUE_GAME_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
            map.put(bh.bg, UMUtils.VALUE_PUSH_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
            map.put(bh.bh, UMUtils.VALUE_SHARE_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
            map.put(bh.bi, UMUtils.VALUE_APM_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
            map.put(bh.bj, UMUtils.VALUE_VERIFY_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
            map.put(bh.bk, UMUtils.VALUE_SMS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
            map.put(bh.bl, UMUtils.VALUE_REC_VERSION_NAME);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
            map.put(bh.bm, UMUtils.VALUE_VISUAL_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
            map.put(bh.bn, UMUtils.VALUE_ASMS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
            map.put(bh.bo, UMUtils.VALUE_LINK_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
            map.put(bh.bp, UMUtils.VALUE_ABTEST_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ANTI_VERSION)) {
            map.put(bh.bq, UMUtils.VALUE_ANTI_VERSION);
        }
        return map;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        String str;
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                String strValueOf = String.valueOf(itKeys.next());
                if (!TextUtils.isEmpty(strValueOf) && (str = (String) jSONObject.get(strValueOf)) != null) {
                    map.put(strValueOf, str);
                }
            } catch (Throwable unused) {
            }
        }
        return map;
    }
}
