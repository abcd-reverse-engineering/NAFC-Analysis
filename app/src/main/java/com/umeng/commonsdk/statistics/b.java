package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EnvelopeManager.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f10869a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f10870b = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10871c = "EnvelopeManager";

    /* renamed from: d, reason: collision with root package name */
    private static final String f10872d = "debug.umeng.umTaskId";

    /* renamed from: e, reason: collision with root package name */
    private static final String f10873e = "debug.umeng.umCaseId";

    /* renamed from: f, reason: collision with root package name */
    private static final String f10874f = "empty";

    /* renamed from: g, reason: collision with root package name */
    private static String f10875g = "";

    /* renamed from: h, reason: collision with root package name */
    private static String f10876h = "";

    /* renamed from: i, reason: collision with root package name */
    private static String f10877i;

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, String> f10878j = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private static boolean f10879l;

    /* renamed from: k, reason: collision with root package name */
    private int f10880k = 0;

    static {
        f10878j.put("header", "#h");
        f10878j.put("sdk_type", "#sdt");
        f10878j.put(bh.Q, "#ac");
        f10878j.put("device_model", "#dm");
        f10878j.put("umid", "#umid");
        f10878j.put("os", "os");
        f10878j.put(bh.N, "#lang");
        f10878j.put(bh.ai, "#dt");
        f10878j.put("resolution", "#rl");
        f10878j.put(bh.H, "#dmf");
        f10878j.put(bh.J, "#dn");
        f10878j.put("platform_version", "#pv");
        f10878j.put("font_size_setting", "#fss");
        f10878j.put("os_version", "#ov");
        f10878j.put(bh.I, "#did");
        f10878j.put("platform_sdk_version", "#psv");
        f10878j.put(bh.F, "#db");
        f10878j.put("appkey", "#ak");
        f10878j.put(bh.Y, "#itr");
        f10878j.put("id_type", "#it");
        f10878j.put("uuid", "#ud");
        f10878j.put("device_id", "#dd");
        f10878j.put(bh.X, "#imp");
        f10878j.put("sdk_version", "#sv");
        f10878j.put("st", "#st");
        f10878j.put("analytics", "#a");
        f10878j.put("package_name", "#pkg");
        f10878j.put(bh.p, "#sig");
        f10878j.put(bh.q, "#sis1");
        f10878j.put(bh.r, "#sis");
        f10878j.put("app_version", "#av");
        f10878j.put("version_code", "#vc");
        f10878j.put(bh.v, "#imd");
        f10878j.put(bh.B, "#mnc");
        f10878j.put(bh.E, "#boa");
        f10878j.put(bh.G, "#mant");
        f10878j.put(bh.M, "#tz");
        f10878j.put(bh.O, "#ct");
        f10878j.put("carrier", "#car");
        f10878j.put("display_name", "#disn");
        f10878j.put(bh.T, "#nt");
        f10878j.put(bh.f10117b, "#cv");
        f10878j.put(bh.f10119d, "#mv");
        f10878j.put(bh.f10118c, "#cot");
        f10878j.put(bh.f10120e, "#mod");
        f10878j.put(bh.aj, "#al");
        f10878j.put("session_id", "#sid");
        f10878j.put(bh.S, "#ip");
        f10878j.put(bh.U, "#sre");
        f10878j.put(bh.V, "#fre");
        f10878j.put(bh.W, "#ret");
        f10878j.put("channel", "#chn");
        f10878j.put("wrapper_type", "#wt");
        f10878j.put("wrapper_version", "#wv");
        f10878j.put(bh.aY, "#tsv");
        f10878j.put(bh.aZ, "#rps");
        f10878j.put(bh.bc, "#mov");
        f10878j.put(d.f10312i, "#vt");
        f10878j.put("secret", "#sec");
        f10878j.put(d.ah, "#prv");
        f10878j.put(d.f10315l, "#$prv");
        f10878j.put(d.f10316m, "#uda");
        f10878j.put(bh.f10116a, "#tok");
        f10878j.put(bh.aQ, "#iv");
        f10878j.put(bh.R, "#ast");
        f10878j.put("backstate", "#bst");
        f10878j.put("zdata_ver", "#zv");
        f10878j.put("zdata_req_ts", "#zrt");
        f10878j.put("app_b_v", "#bv");
        f10878j.put("zdata", "#zta");
        f10878j.put(bh.ap, "#mt");
        f10878j.put(bh.am, "#zsv");
        f10878j.put(bh.ao, "#oos");
    }

    public static String a(String str) {
        return f10878j.containsKey(str) ? f10878j.get(str) : str;
    }

    private static boolean b() {
        f10875g = UMUtils.getSystemProperty(f10872d, "");
        f10876h = UMUtils.getSystemProperty(f10873e, "");
        return (!TextUtils.isEmpty(f10875g) && !f10874f.equals(f10875g)) && (!TextUtils.isEmpty(f10876h) && !f10874f.equals(f10876h));
    }

    public static void a() {
        if (f10877i != null) {
            f10877i = null;
            e.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f10875g);
                    jSONObject.put("umCaseId", f10876h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            Envelope envelopeA = null;
            if (jSONObject3 != null && (envelopeA = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                String str3 = "constructHeader size is " + jSONObject3.toString().getBytes().length;
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            String str = "free size is " + j2;
        }
        return j2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) throws JSONException {
        String str4;
        String str5;
        boolean z;
        String strSubstring;
        Envelope envelope;
        String str6;
        JSONObject jSONObjectOptJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            String str7 = "headerJSONObject size is " + jSONObject.toString().getBytes().length;
            String str8 = "bodyJSONObject size is " + jSONObject2.toString().getBytes().length;
        }
        JSONObject jSONObject3 = null;
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.has(d.n)) {
                    str5 = str2;
                    z = true;
                } else {
                    str5 = str2;
                    z = false;
                }
                JSONObject jSONObjectA = a(context, str5, z);
                if (jSONObjectA != null && jSONObject != null) {
                    jSONObjectA = a(jSONObjectA, jSONObject);
                }
                JSONObject jSONObject4 = jSONObjectA;
                if (jSONObject4 != null && jSONObject2 != null) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next != null && (next instanceof String) && (str6 = next) != null && jSONObject2.opt(str6) != null) {
                            try {
                                jSONObject4.put(a(str6), jSONObject2.opt(str6));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str5 = bh.aK;
                }
                String str9 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject4 != null) {
                    String str10 = str5 + "==" + str9 + "&=";
                    if (TextUtils.isEmpty(str10)) {
                        return a(101, jSONObject4);
                    }
                    strSubstring = str10.endsWith("&=") ? str10.substring(0, str10.length() - 2) : str10;
                } else {
                    strSubstring = null;
                }
                if (jSONObject4 != null) {
                    try {
                        e eVarA = e.a(context);
                        if (eVarA != null) {
                            eVarA.b();
                            String strEncodeToString = Base64.encodeToString(new bz().a(eVarA.c()), 0);
                            if (!TextUtils.isEmpty(strEncodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                                jSONObject5.put(a(bh.Y), strEncodeToString);
                                jSONObject4.put(a("header"), jSONObject5);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject4);
                }
                if (jSONObject4 != null) {
                    Envelope envelopeA = a(context, jSONObject4.toString().getBytes());
                    if (envelopeA == null) {
                        return a(111, jSONObject4);
                    }
                    envelope = envelopeA;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject4);
                }
                int iA = a(context, envelope, strSubstring, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (iA != 0) {
                    return a(iA, jSONObject4);
                }
                if (ULog.DEBUG) {
                    String str11 = "constructHeader size is " + jSONObject4.toString().getBytes().length;
                }
                if (!strSubstring.startsWith(bh.aG) && !strSubstring.startsWith(bh.aF) && !strSubstring.startsWith("t") && !strSubstring.startsWith(bh.ay) && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject4;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            jSONObject6.put("header", jSONObject);
                        } catch (JSONException unused3) {
                        } catch (Exception e2) {
                            e = e2;
                            jSONObject3 = jSONObject6;
                            UMCrashManager.reportCrash(context, e);
                            return a(110, jSONObject3);
                        }
                        jSONObject3 = jSONObject6;
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                if (jSONObject2 != null) {
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    if (jSONObject2 != null) {
                        Iterator<String> itKeys2 = jSONObject2.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            if (next2 != null && (next2 instanceof String) && (str4 = next2) != null && jSONObject2.opt(str4) != null) {
                                try {
                                    jSONObject3.put(str4, jSONObject2.opt(str4));
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    }
                }
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.f10771a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f10772b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f10773c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            Envelope envelopeA = null;
            if (jSONObject3 != null && (envelopeA = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "h==1.2.0", "", str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                String str3 = "constructHeader size is " + jSONObject3.toString().getBytes().length;
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:178:0x03f2
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static org.json.JSONObject a(android.content.Context r16, java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 1531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.a(android.content.Context, java.lang.String, boolean):org.json.JSONObject");
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(a(d.f10312i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.f10880k = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int iIntValue = -1;
        try {
            if (!TextUtils.isEmpty(strImprintProperty)) {
                iIntValue = Integer.valueOf(strImprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (iIntValue == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (iIntValue == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f10879l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String strB = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append(c.c.a.b.a.a.s1);
        sb.append(System.currentTimeMillis());
        sb.append(c.c.a.b.a.a.s1);
        sb.append(strB);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith(bh.aJ)) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith(bh.aJ)) {
            return 122;
        }
        if (!str.startsWith(bh.aG) && !str.startsWith(bh.aF) && !str.startsWith(bh.ay) && !str.startsWith("t")) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f10841f, sb.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
    }

    public static void a(boolean z) {
        f10879l = z;
    }
}
