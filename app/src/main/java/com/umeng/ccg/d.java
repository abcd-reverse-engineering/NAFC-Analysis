package com.umeng.ccg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.aj;
import com.umeng.analytics.pro.al;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.z;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Monitor.java */
/* loaded from: classes2.dex */
public class d implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10623a = "iucc";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10624b = at.b().b(at.C);

    /* renamed from: c, reason: collision with root package name */
    private static JSONObject f10625c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f10626d = {com.umeng.ccg.a.f10596f, com.umeng.ccg.a.f10597g, com.umeng.ccg.a.f10598h};

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<aa> f10627e = null;

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<aa> f10628f = null;

    /* renamed from: g, reason: collision with root package name */
    private static ArrayList<aa> f10629g = null;

    /* renamed from: j, reason: collision with root package name */
    private static c f10630j = new c();

    /* renamed from: h, reason: collision with root package name */
    private volatile String f10631h = "";

    /* renamed from: i, reason: collision with root package name */
    private Map<String, a> f10632i = new HashMap();

    /* compiled from: Monitor.java */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        private JSONArray f10635b;

        /* renamed from: c, reason: collision with root package name */
        private String f10636c;

        public a(JSONArray jSONArray, String str) {
            this.f10635b = jSONArray;
            this.f10636c = str;
        }

        public JSONArray a() {
            return this.f10635b;
        }

        public String b() {
            return this.f10636c;
        }
    }

    /* compiled from: Monitor.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f10637a = new d();

        private b() {
        }
    }

    /* compiled from: Monitor.java */
    public static class c extends BroadcastReceiver {
        public long a(ArrayList<aa> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    aa aaVar = arrayList.get(i2);
                    if (aaVar instanceof ac) {
                        return ((ac) aaVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<aa> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (b(d.f10627e)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.f10627e) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.f10628f)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.f10628f) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(d.f10629g)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.f10629g) * 1000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(f10630j, intentFilter);
    }

    private String e(Context context) {
        try {
            SharedPreferences sharedPreferencesA = aq.a(context);
            return sharedPreferencesA != null ? sharedPreferencesA.getString(aq.f10059e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void f() {
        try {
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putString(aq.f10060f, new JSONObject(ap.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean g() {
        try {
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                return !TextUtils.isEmpty(sharedPreferencesA.getString(aq.f10061g, ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f10623a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        try {
            SharedPreferences sharedPreferencesA = aq.a(context);
            if (sharedPreferencesA != null) {
                return Long.valueOf(sharedPreferencesA.getLong(aq.f10058d, 0L));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null && (jSONObject instanceof JSONObject) && jSONObject.has(com.umeng.ccg.a.f10591a)) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f10591a);
                z zVarA = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f10592b) ? a(com.umeng.ccg.a.f10592b, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f10592b)) : null;
                z zVarA2 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f10593c) ? a(com.umeng.ccg.a.f10593c, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f10593c)) : null;
                z zVarA3 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f10594d) ? a(com.umeng.ccg.a.f10594d, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f10594d)) : null;
                z zVarA4 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f10595e) ? a(com.umeng.ccg.a.f10595e, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f10595e)) : null;
                z zVarA5 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f10596f) ? a(com.umeng.ccg.a.f10596f, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f10596f)) : null;
                z zVarA6 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f10597g) ? a(com.umeng.ccg.a.f10597g, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f10597g)) : null;
                z zVarA7 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f10598h) ? a(com.umeng.ccg.a.f10598h, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f10598h)) : null;
                ArrayList arrayList = new ArrayList();
                if (zVarA != null) {
                    arrayList.add(zVarA);
                }
                if (zVarA2 != null) {
                    arrayList.add(zVarA2);
                }
                if (zVarA3 != null) {
                    arrayList.add(zVarA3);
                }
                if (zVarA4 != null) {
                    arrayList.add(zVarA4);
                }
                if (zVarA5 != null) {
                    arrayList.add(zVarA5);
                }
                if (zVarA6 != null) {
                    arrayList.add(zVarA6);
                }
                if (zVarA7 != null) {
                    arrayList.add(zVarA7);
                }
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean e() {
        SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
        if (sharedPreferencesA != null) {
            String string = sharedPreferencesA.getString(aq.f10060f, "");
            if (TextUtils.isEmpty(string)) {
                f();
                return false;
            }
            try {
                if (!ap.a().keySet().equals(ap.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static d a() {
        return b.f10637a;
    }

    private JSONObject b(Context context) {
        FileInputStream fileInputStreamOpenFileInput;
        try {
            if (!new File(context.getFilesDir(), f10624b).exists()) {
                return null;
            }
            try {
                fileInputStreamOpenFileInput = context.openFileInput(f10624b);
                try {
                    JSONObject jSONObject = new JSONObject(new String(as.a(HelperUtils.readStreamToByteArray(fileInputStreamOpenFileInput), UMConfigure.sAppkey.getBytes())));
                    try {
                        ap.a(fileInputStreamOpenFileInput);
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                } catch (Throwable unused2) {
                    ap.a(fileInputStreamOpenFileInput);
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStreamOpenFileInput = null;
            }
        } catch (Throwable unused4) {
            return null;
        }
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has(com.umeng.ccg.a.f10591a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a(Context context, JSONObject jSONObject, String str) {
        try {
            long jB = b(jSONObject);
            byte[] bArrA = as.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
            if (bArrA != null && bArrA.length > 1) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f10624b));
                try {
                    fileOutputStream.write(bArrA);
                    fileOutputStream.flush();
                    ap.a(fileOutputStream);
                    a(context, str, jB);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
                } catch (Throwable th) {
                    ap.a(fileOutputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void b(String str) {
        String str2 = aq.f10056b + str;
        SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
        if (sharedPreferencesA != null) {
            sharedPreferencesA.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, aa aaVar) {
        if (com.umeng.ccg.a.f10596f.equalsIgnoreCase(str)) {
            if (f10627e == null) {
                f10627e = new ArrayList<>();
            }
            f10627e.add(aaVar);
        }
        if (com.umeng.ccg.a.f10597g.equalsIgnoreCase(str)) {
            if (f10628f == null) {
                f10628f = new ArrayList<>();
            }
            f10628f.add(aaVar);
        }
        if (com.umeng.ccg.a.f10598h.equalsIgnoreCase(str)) {
            if (f10629g == null) {
                f10629g = new ArrayList<>();
            }
            f10629g.add(aaVar);
        }
    }

    private z a(String str, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        String str2;
        String str3;
        z zVar;
        JSONArray jSONArrayOptJSONArray2;
        if (jSONObject != null && (jSONObject instanceof JSONObject)) {
            try {
                if (jSONObject.has(com.umeng.ccg.a.f10599i) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.f10599i)) != null && jSONArrayOptJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(0);
                    boolean zHas = jSONObject2.has(com.umeng.ccg.a.f10600j);
                    boolean zHas2 = jSONObject2.has(com.umeng.ccg.a.f10603m);
                    boolean zHas3 = jSONObject2.has(com.umeng.ccg.a.n);
                    if (!zHas || !zHas2 || !zHas3) {
                        return null;
                    }
                    try {
                        int iOptInt = jSONObject2.optInt(com.umeng.ccg.a.f10600j);
                        long jOptLong = jSONObject2.optLong(com.umeng.ccg.a.f10603m);
                        long jOptLong2 = jSONObject2.optLong(com.umeng.ccg.a.n);
                        String strOptString = jSONObject2.optString(com.umeng.ccg.a.o);
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject2.has(com.umeng.ccg.a.f10601k)) {
                            JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.f10601k);
                            str2 = "action";
                            HashSet hashSet = new HashSet();
                            if (jSONArrayOptJSONArray3 != null) {
                                str3 = com.umeng.ccg.a.r;
                                int i2 = 0;
                                for (int length = jSONArrayOptJSONArray3.length(); i2 < length; length = length) {
                                    hashSet.add(Integer.valueOf(jSONArrayOptJSONArray3.getInt(i2)));
                                    i2++;
                                }
                            } else {
                                str3 = com.umeng.ccg.a.r;
                            }
                            if (hashSet.size() > 0) {
                                aj ajVar = new aj(hashSet);
                                if (Arrays.asList(f10626d).contains(str)) {
                                    a(str, ajVar);
                                } else {
                                    arrayList.add(ajVar);
                                }
                            }
                        } else {
                            str2 = "action";
                            str3 = com.umeng.ccg.a.r;
                        }
                        if (jSONObject2.has(com.umeng.ccg.a.f10602l)) {
                            String strOptString2 = jSONObject2.optString(com.umeng.ccg.a.f10602l);
                            if (!TextUtils.isEmpty(strOptString2)) {
                                ah ahVar = new ah(strOptString2);
                                HashSet hashSet2 = new HashSet();
                                for (int i3 = 1; i3 <= 24; i3++) {
                                    if (ahVar.a(i3)) {
                                        hashSet2.add(Integer.valueOf(i3));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    ad adVar = new ad(hashSet2);
                                    if (Arrays.asList(f10626d).contains(str)) {
                                        a(str, adVar);
                                    } else {
                                        arrayList.add(adVar);
                                    }
                                }
                            }
                        }
                        arrayList.add(new af(iOptInt));
                        ae aeVar = new ae(str, jOptLong);
                        if (Arrays.asList(f10626d).contains(str)) {
                            a(str, aeVar);
                        } else {
                            arrayList.add(aeVar);
                        }
                        ac acVar = new ac(jOptLong2);
                        if (Arrays.asList(f10626d).contains(str)) {
                            a(str, acVar);
                            arrayList.add(acVar);
                        } else {
                            arrayList.add(acVar);
                        }
                        if (com.umeng.ccg.a.f10595e.equals(str)) {
                            zVar = new ab(str, arrayList);
                        } else {
                            zVar = new z(str, arrayList);
                        }
                        try {
                            zVar.a(strOptString);
                            String str4 = "";
                            String str5 = str3;
                            if (jSONObject.has(str5) && (jSONArrayOptJSONArray2 = jSONObject.optJSONArray(str5)) != null && (jSONArrayOptJSONArray2 instanceof JSONArray)) {
                                if (this.f10632i != null && !this.f10632i.containsKey(str)) {
                                    this.f10632i.put(str, new a(new JSONArray(jSONArrayOptJSONArray2.toString()), strOptString));
                                }
                                int length2 = jSONArrayOptJSONArray2.length();
                                String str6 = "";
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                    str6 = str6 + jSONArrayOptJSONArray2.getString(i4);
                                    if (i4 < length2 - 1) {
                                        str6 = str6 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                                    }
                                }
                                str4 = str6;
                            }
                            zVar.b(str4);
                            if (com.umeng.ccg.a.f10595e.equals(str) && (zVar instanceof ab)) {
                                String str7 = str2;
                                if (jSONObject2.has(str7)) {
                                    ((ab) zVar).d(jSONObject2.optString(str7));
                                }
                                if (jSONObject2.has(com.umeng.ccg.a.s)) {
                                    ((ab) zVar).c(jSONObject2.optString(com.umeng.ccg.a.s));
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        return zVar;
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    private void a(Context context, String str, long j2) {
        SharedPreferences sharedPreferencesA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length != 4 || (sharedPreferencesA = aq.a(context)) == null) {
                return;
            }
            long j3 = Long.parseLong(strArrSplit[0]);
            String str2 = strArrSplit[1];
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putLong(aq.f10057c, j2);
            editorEdit.putLong(aq.f10058d, j3);
            editorEdit.putString(aq.f10059e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j2 + "; s1 = " + j3 + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length != 4) {
                return;
            }
            long j2 = Long.parseLong(strArrSplit[0]);
            String str2 = strArrSplit[1];
            if (!TextUtils.isEmpty(this.f10631h)) {
                String[] strArrSplit2 = this.f10631h.split("@");
                if (strArrSplit2.length == 2) {
                    long j3 = Long.parseLong(strArrSplit2[0]);
                    String str3 = strArrSplit2[1];
                    if (j3 == j2 && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                if (sharedPreferencesA.getLong(aq.f10057c, 0L) != j2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f10631h = String.valueOf(j2) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f10631h = String.valueOf(j2) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z) {
        try {
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                if (z) {
                    editorEdit.putString(aq.f10061g, "1").commit();
                } else {
                    editorEdit.putString(aq.f10061g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9, types: [org.json.JSONObject] */
    @Override // com.umeng.ccg.c.a
    public void a(Object obj, int i2) {
        Integer numValueOf;
        ArrayList arrayList;
        int size;
        a aVar;
        a aVar2;
        a aVar3;
        JSONObject jSONObjectB = null;
        boolean z = true;
        int i3 = 0;
        try {
            switch (i2) {
                case 101:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: " + str);
                        JSONObject jSONObjectA = al.a(UMGlobalContext.getAppContext(), str);
                        if (jSONObjectA != null) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[imprint] send request. body: " + jSONObjectA.toString());
                            ar.a(new ao(ao.f10051a, jSONObjectA, str), 0L, TimeUnit.SECONDS);
                        }
                        if (g()) {
                            c(UMGlobalContext.getAppContext());
                            String strImprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f10623a, "");
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + strImprintProperty);
                            a(strImprintProperty);
                            break;
                        }
                    }
                    break;
                case 102:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_RESPONSE msg.");
                    this.f10631h = "";
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (a(jSONObject.optJSONObject("config"))) {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 103, a(), jSONObject);
                            break;
                        } else {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                            break;
                        }
                    } else {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                        break;
                    }
                    break;
                case 103:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_SUCCESS msg.");
                    Context appContext = UMGlobalContext.getAppContext();
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("config");
                        String strOptString = jSONObject2.optString("sourceIucc");
                        if (jSONObjectOptJSONObject != null) {
                            if (g()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 成功拉取云配参数后，检测到should fetch标志，清除此标志。更新SDK类型集缓存值");
                                f();
                                a(false);
                            }
                            a(appContext, jSONObjectOptJSONObject, strOptString);
                            break;
                        }
                    }
                    break;
                case 104:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_FAILED msg.");
                    break;
                case 105:
                    String[] collectItemList = CcgAgent.getCollectItemList();
                    int length = collectItemList.length;
                    ?? jSONObject3 = 0;
                    while (jSONObject3 < length) {
                        String str2 = collectItemList[jSONObject3];
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[forbid_sdk] 采集项: " + str2 + "; 值: " + CcgAgent.getForbidSdkArray(str2).toString());
                        jSONObject3++;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv LOAD_CONFIG msg.");
                    Integer num = 0;
                    try {
                        try {
                            jSONObjectB = b(UMGlobalContext.getAppContext());
                            if (jSONObjectB != null && (jSONObjectB instanceof JSONObject) && a(jSONObjectB)) {
                                numValueOf = Integer.valueOf(num.intValue() | 1);
                            } else {
                                numValueOf = Integer.valueOf(num.intValue() | 0);
                            }
                            jSONObject3 = new JSONObject();
                            jSONObject3.put("result", numValueOf);
                        } catch (Throwable unused) {
                            jSONObject3 = new JSONObject();
                            jSONObject3.put("result", num);
                            if (0 != 0) {
                                jSONObject3 = jSONObject3;
                                if (jSONObjectB instanceof JSONObject) {
                                }
                            }
                        }
                        if (jSONObjectB != null) {
                            jSONObject3 = jSONObject3;
                            if (jSONObjectB instanceof JSONObject) {
                                jSONObject3.put("config", jSONObjectB);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 106, a(), jSONObject3);
                    break;
                case 106:
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject4 = (JSONObject) obj;
                        if (jSONObject4 != null && jSONObject4.has("result")) {
                            if ((jSONObject4.optInt("result") & 1) != 0 && jSONObject4.has("config")) {
                                f10625c = jSONObject4.optJSONObject("config");
                                if (f10625c != null) {
                                    CcgAgent.notifyConfigReady(f10625c);
                                    i3 = 1;
                                }
                            }
                            if (i3 == 0) {
                                CcgAgent.notifyConfigReady(null);
                            }
                        }
                        if (e()) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 检测到集成的SDK类型集合发生变化，发起云配参数拉取请求(设置本地should fetch标志).");
                            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f10623a, "");
                            a(true);
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), strImprintProperty2);
                            break;
                        } else {
                            c(UMGlobalContext.getAppContext());
                            String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f10623a, "");
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + strImprintProperty3);
                            a(strImprintProperty3);
                            break;
                        }
                    }
                    break;
                case 107:
                    if (obj != null) {
                        try {
                            if (obj instanceof String) {
                                String str3 = (String) obj;
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[IMPRINT_IUCC_CHANGED] iucc : " + str3);
                                a(str3);
                                break;
                            }
                        } catch (Throwable th) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "[imprint] process error " + th.getMessage());
                            return;
                        }
                    }
                    break;
                default:
                    switch (i2) {
                        case 201:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv PARSE_CONFIG msg.");
                            if (obj != null && (obj instanceof JSONObject)) {
                                c((JSONObject) obj);
                                break;
                            }
                            break;
                        case 202:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv COLLECTION_JUDGMENT msg.");
                            if (obj != null && (obj instanceof ArrayList) && (size = (arrayList = (ArrayList) obj).size()) > 0) {
                                while (i3 < size) {
                                    z zVar = (z) arrayList.get(i3);
                                    JSONObject jSONObjectA2 = zVar.a(zVar.a(), null);
                                    if (jSONObjectA2 != null) {
                                        long jOptLong = !Arrays.asList(f10626d).contains(zVar.a()) ? jSONObjectA2.optLong("delay") * 1000 : 0L;
                                        jSONObjectA2.remove("delay");
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "send START_COLLECT msg, delayTs = " + jOptLong);
                                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 203, a(), jSONObjectA2, jOptLong);
                                    }
                                    i3++;
                                }
                                break;
                            }
                            break;
                        case 203:
                            if (obj != null && (obj instanceof JSONObject)) {
                                JSONObject jSONObject5 = (JSONObject) obj;
                                String strOptString2 = jSONObject5.optString("actionName");
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "recv START_COLLECT msg. name is : " + strOptString2);
                                if (!com.umeng.ccg.b.a(strOptString2)) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Local switch of [" + strOptString2 + "] is off, ignore this command.");
                                    break;
                                } else {
                                    String string = jSONObject5.toString();
                                    if (Arrays.asList(f10626d).contains(strOptString2)) {
                                        if (com.umeng.ccg.a.f10596f.equalsIgnoreCase(strOptString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_ON");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON");
                                        }
                                        if (com.umeng.ccg.a.f10597g.equalsIgnoreCase(strOptString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_OFF");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_OFF");
                                        }
                                        if (com.umeng.ccg.a.f10598h.equalsIgnoreCase(strOptString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_USER_PRESENT");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.USER_PRESENT");
                                            break;
                                        }
                                    } else {
                                        b(strOptString2);
                                        if (CcgAgent.hasRegistedActionInfo()) {
                                            if (CcgAgent.getActionInfo("anti") == null) {
                                                z = false;
                                            }
                                            String strOptString3 = jSONObject5.optString(com.umeng.ccg.a.p);
                                            if (!TextUtils.isEmpty(strOptString3)) {
                                                ActionInfo actionInfo = CcgAgent.getActionInfo(strOptString3);
                                                if (actionInfo != null) {
                                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "调用[" + strOptString3 + "] onCommand接口方法, 参数: " + jSONObject5.toString());
                                                    actionInfo.onCommand(UMGlobalContext.getAppContext(), strOptString2, jSONObject5);
                                                }
                                            } else {
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "忽略 本次采集项[" + strOptString2 + "]采集请求.");
                                            }
                                            if (!z) {
                                                ap.a(UMGlobalContext.getAppContext(), string);
                                                break;
                                            }
                                        } else {
                                            ap.a(UMGlobalContext.getAppContext(), string);
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                        default:
                            switch (i2) {
                                case 301:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_ON msg.");
                                    b(com.umeng.ccg.a.f10596f);
                                    if (this.f10632i.containsKey(com.umeng.ccg.a.f10596f) && (aVar = this.f10632i.get(com.umeng.ccg.a.f10596f)) != null) {
                                        JSONObject jSONObjectA3 = al.a(UMGlobalContext.getAppContext(), 1, aVar.a(), aVar.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_on event param: " + jSONObjectA3.toString());
                                        ar.a(new an(an.f10048a, jSONObjectA3), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 302:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_OFF msg.");
                                    b(com.umeng.ccg.a.f10597g);
                                    if (this.f10632i.containsKey(com.umeng.ccg.a.f10597g) && (aVar2 = this.f10632i.get(com.umeng.ccg.a.f10597g)) != null) {
                                        JSONObject jSONObjectA4 = al.a(UMGlobalContext.getAppContext(), 3, aVar2.a(), aVar2.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_off event param: " + jSONObjectA4.toString());
                                        ar.a(new an(an.f10048a, jSONObjectA4), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 303:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_UNLOCK msg.");
                                    b(com.umeng.ccg.a.f10598h);
                                    if (this.f10632i.containsKey(com.umeng.ccg.a.f10598h) && (aVar3 = this.f10632i.get(com.umeng.ccg.a.f10598h)) != null) {
                                        JSONObject jSONObjectA5 = al.a(UMGlobalContext.getAppContext(), 2, aVar3.a(), aVar3.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_unlock event param: " + jSONObjectA5.toString());
                                        ar.a(new an(an.f10048a, jSONObjectA5), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                            }
                    }
            }
        } catch (Throwable unused3) {
        }
    }
}
