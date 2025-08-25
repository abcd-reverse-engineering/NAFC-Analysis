package util;

import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MMKVUtils.java */
/* loaded from: classes2.dex */
public class p1 {
    public static final String A = "key_cdn_version";

    /* renamed from: a, reason: collision with root package name */
    public static final int f20891a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final String f20892b = "key_longitude";

    /* renamed from: c, reason: collision with root package name */
    public static final String f20893c = "key_latitude";

    /* renamed from: d, reason: collision with root package name */
    public static final String f20894d = "key_address";

    /* renamed from: e, reason: collision with root package name */
    public static final String f20895e = "key_region_id";

    /* renamed from: f, reason: collision with root package name */
    public static final String f20896f = "key_province_name";

    /* renamed from: g, reason: collision with root package name */
    public static final String f20897g = "key_region_name";

    /* renamed from: h, reason: collision with root package name */
    public static final String f20898h = "key_node_address";

    /* renamed from: i, reason: collision with root package name */
    public static final String f20899i = "key_address_vertion";

    /* renamed from: j, reason: collision with root package name */
    public static final String f20900j = "key_address_last_day";

    /* renamed from: k, reason: collision with root package name */
    public static final String f20901k = "key_login_police";

    /* renamed from: l, reason: collision with root package name */
    public static final String f20902l = "key_user_info";

    /* renamed from: m, reason: collision with root package name */
    public static final String f20903m = "update_home";
    public static final String n = "key_xy_agree";
    public static final String o = "key_new_case";
    public static final String p = "key_white";
    public static final String q = "key_failLogin";
    public static final String r = "key_failAuthLogin";
    public static final String s = "key_failRegist";
    public static final String t = "key_failFortPwd";
    public static final String u = "key_failRestPhone";
    public static final String v = "key_failRestPwd";
    public static final String w = "key_logoutAcc";
    public static final String x = "key_policLogin";
    public static final String y = "isFirstEnter";
    public static final String z = "key_uuid";

    private static MMKV a() {
        return MMKV.defaultMMKV();
    }

    public static void b(String str, boolean z2) {
        a().encode(str, z2);
    }

    public static void a(String str, String str2) {
        a().encode(str, str2);
    }

    public static void b(String str, int i2) {
        a().encode(str, i2);
    }

    public static String a(String str) {
        return a().decodeString(str);
    }

    public static void b(String str, long j2) {
        a().encode(str, j2);
    }

    public static boolean a(String str, boolean z2) {
        return a().decodeBool(str, z2);
    }

    public static void b(String str, float f2) {
        a().encode(str, f2);
    }

    public static int a(String str, int i2) {
        return a().decodeInt(str, i2);
    }

    public static void b(String str, double d2) {
        a().encode(str, d2);
    }

    public static long a(String str, long j2) {
        return a().decodeLong(str, j2);
    }

    public static void b(String str, byte[] bArr) {
        a().encode(str, bArr);
    }

    public static float a(String str, float f2) {
        return a().decodeFloat(str, f2);
    }

    public static <T> List<T> b(String str, Class<T> cls) {
        MMKV mmkvA = a();
        com.google.gson.e eVar = new com.google.gson.e();
        String strDecodeString = mmkvA.decodeString(str, null);
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(strDecodeString)) {
                Iterator<com.google.gson.k> it = new com.google.gson.o().a(strDecodeString).getAsJsonArray().iterator();
                while (it.hasNext()) {
                    arrayList.add(eVar.a(it.next(), (Class) cls));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static double a(String str, double d2) {
        return a().decodeDouble(str, d2);
    }

    public static byte[] a(String str, byte[] bArr) {
        return a().decodeBytes(str, bArr);
    }

    public static <T> void a(String str, T t2) {
        MMKV mmkvA = a();
        com.google.gson.e eVar = new com.google.gson.e();
        if (t2 == null) {
            mmkvA.encode(str, "");
        } else {
            mmkvA.encode(str, eVar.a(t2));
        }
    }

    public static <T> T a(String str, Class<T> cls) {
        MMKV mmkvA = a();
        com.google.gson.e eVar = new com.google.gson.e();
        String strDecodeString = mmkvA.decodeString(str, "");
        try {
            if (TextUtils.isEmpty(strDecodeString)) {
                return null;
            }
            return (T) eVar.a((com.google.gson.k) new com.google.gson.o().a(strDecodeString).getAsJsonObject(), (Class) cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> void a(String str, List<T> list) {
        MMKV mmkvA = a();
        com.google.gson.e eVar = new com.google.gson.e();
        if (list == null) {
            mmkvA.encode(str, "");
        } else {
            mmkvA.encode(str, eVar.a(list));
        }
    }
}
