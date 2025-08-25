package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f7079a = {1, 6, 7, 9};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f7080b = {0, 2, 3, 4, 5};

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Integer, String> f7081c = new a();

    static class a extends HashMap<Integer, String> {
        a() {
            put(1, "2G");
            put(2, "2G");
            put(4, "2G");
            put(7, "2G");
            put(11, "2G");
            put(3, "3G");
            put(8, "3G");
            put(9, "3G");
            put(10, "3G");
            put(15, "3G");
            put(5, "3G");
            put(6, "3G");
            put(12, "3G");
            put(14, "3G");
            put(13, "4G");
            if (Build.VERSION.SDK_INT >= 29) {
                put(20, "5G");
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private static NetworkInfo a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            v.b("hmsSdk", "cannot get network state, ensure permission android.permission.ACCESS_NETWORK_STATE in the manifest: " + th.getMessage());
            return null;
        }
    }

    private static String a(int i2) {
        Map<Integer, String> map = f7081c;
        String str = map.containsKey(Integer.valueOf(i2)) ? map.get(Integer.valueOf(i2)) : "unknown";
        return (!"unknown".equals(str) || Build.VERSION.SDK_INT < 25) ? str : i2 != 16 ? i2 != 17 ? "unknown" : "3G" : "2G";
    }

    private static boolean a(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f7080b, networkInfo.getType()) == -1) ? false : true;
    }

    public static String b(Context context) {
        NetworkInfo networkInfoA;
        if (context == null) {
            return "unknown";
        }
        try {
            networkInfoA = a(context);
        } catch (Throwable unused) {
        }
        if (!b(networkInfoA)) {
            return "none";
        }
        if (c(networkInfoA)) {
            return "WIFI";
        }
        if (a(networkInfoA)) {
            return a(networkInfoA.getSubtype());
        }
        return "unknown";
    }

    private static boolean b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean c(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f7079a, networkInfo.getType()) == -1) ? false : true;
    }
}
