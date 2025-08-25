package com.huawei.hms.hatool;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class x0 extends o {
    public static String c() {
        String str;
        String str2;
        try {
            str = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
        } catch (AndroidRuntimeException unused) {
            str = "";
        } catch (ClassNotFoundException unused2) {
            str = "";
        } catch (IllegalAccessException unused3) {
            str = "";
        } catch (IllegalArgumentException unused4) {
            str = "";
        } catch (NoSuchMethodException unused5) {
            str = "";
        } catch (InvocationTargetException unused6) {
            str = "";
        }
        try {
            v.c("hmsSdk", "getUDID success");
        } catch (AndroidRuntimeException unused7) {
            str2 = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
            v.f("hmsSdk", str2);
            return str;
        } catch (ClassNotFoundException unused8) {
            str2 = "getUDID method invoke failed";
            v.f("hmsSdk", str2);
            return str;
        } catch (IllegalAccessException unused9) {
            str2 = "getUDID method invoke failed : Illegal AccessException";
            v.f("hmsSdk", str2);
            return str;
        } catch (IllegalArgumentException unused10) {
            str2 = "getUDID method invoke failed : Illegal ArgumentException";
            v.f("hmsSdk", str2);
            return str;
        } catch (NoSuchMethodException unused11) {
            str2 = "getUDID method invoke failed : NoSuchMethodException";
            v.f("hmsSdk", str2);
            return str;
        } catch (InvocationTargetException unused12) {
            str2 = "getUDID method invoke failed : InvocationTargetException";
            v.f("hmsSdk", str2);
            return str;
        }
        return str;
    }

    public static Pair<String, String> e(Context context) {
        if (c0.a(context, util.permissionutil.a.f20916j)) {
            v.f("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
            String networkOperator = telephonyManager.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, c.c.a.b.a.a.f3101h)) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
        }
        return new Pair<>("", "");
    }
}
