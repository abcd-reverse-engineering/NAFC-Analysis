package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PathCenter.java */
/* loaded from: classes2.dex */
public class at {
    public static final String A = "rtd";
    public static final String B = "lepd";
    public static final String C = "ccfg";
    private static Map<String, String> D = new HashMap();
    private static String E = "";

    /* renamed from: a, reason: collision with root package name */
    public static final String f10067a = "env";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10068b = "exp";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10069c = "imp";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10070d = "ua";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10071e = "zc";

    /* renamed from: f, reason: collision with root package name */
    public static final String f10072f = "id";

    /* renamed from: g, reason: collision with root package name */
    public static final String f10073g = "zf";

    /* renamed from: h, reason: collision with root package name */
    public static final String f10074h = "exid";

    /* renamed from: i, reason: collision with root package name */
    public static final String f10075i = "ucc";

    /* renamed from: j, reason: collision with root package name */
    public static final String f10076j = "ugc";

    /* renamed from: k, reason: collision with root package name */
    public static final String f10077k = "usi";

    /* renamed from: l, reason: collision with root package name */
    public static final String f10078l = "uso";

    /* renamed from: m, reason: collision with root package name */
    public static final String f10079m = "user";
    public static final String n = "uspi";
    public static final String o = "dtfn";
    public static final String p = "pr";
    public static final String q = "upg";
    public static final String r = "pri";
    public static final String s = "probe";
    public static final String t = "bl";
    public static final String u = "wl";
    public static final String v = "subp";
    public static final String w = "subua";
    public static final String x = "sta";
    public static final String y = "emi";
    public static final String z = "sli";

    /* compiled from: PathCenter.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final at f10080a = new at();

        private a() {
        }
    }

    static {
        D.put(f10067a, "envelope");
        D.put(f10068b, ".umeng");
        D.put(f10069c, ".imprint");
        D.put(f10070d, "ua.db");
        D.put(f10071e, "umeng_zero_cache.db");
        D.put("id", "umeng_it.cache");
        D.put(f10073g, "umeng_zcfg_flag");
        D.put(f10074h, "exid.dat");
        D.put(f10075i, "umeng_common_config");
        D.put(f10076j, "umeng_general_config");
        D.put(f10077k, "um_session_id");
        D.put(f10078l, "umeng_sp_oaid");
        D.put(f10079m, "mobclick_agent_user_");
        D.put(n, "umeng_subprocess_info");
        D.put(o, "delayed_transmission_flag_new");
        D.put("pr", "umeng_policy_result_flag");
        D.put(q, "um_policy_grant");
        D.put(r, "um_pri");
        D.put(s, "UM_PROBE_DATA");
        D.put(t, "ekv_bl");
        D.put(u, "ekv_wl");
        D.put(v, e.f10329a);
        D.put(w, "ua_");
        D.put(x, "stateless");
        D.put(y, ".emitter");
        D.put(z, "um_slmode_sp");
        D.put(A, "um_rtd_conf");
        D.put(B, "");
        D.put(C, ".dmpvedpogjhejs.cfg");
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(E)) {
            if (str.length() > 3) {
                E = str.substring(0, 3) + c.c.a.b.a.a.s1;
                return;
            }
            E = str + c.c.a.b.a.a.s1;
        }
    }

    public String b(String str) {
        if (!D.containsKey(str)) {
            return "";
        }
        String str2 = D.get(str);
        if (!f10068b.equalsIgnoreCase(str) && !f10069c.equalsIgnoreCase(str) && !y.equalsIgnoreCase(str)) {
            return E + str2;
        }
        return "." + E + str2.substring(1);
    }

    private at() {
    }

    public void a() {
        E = "";
    }

    public static at b() {
        return a.f10080a;
    }
}
