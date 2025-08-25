package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.cloudwalk.util.LogUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f9783a;

    /* renamed from: b, reason: collision with root package name */
    private String f9784b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f9785c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f9786d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f9787e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f9788f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f9789g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f9790h = "";

    /* renamed from: i, reason: collision with root package name */
    private List<Serializable> f9791i = Collections.synchronizedList(new ArrayList());

    /* renamed from: j, reason: collision with root package name */
    private List<Serializable> f9792j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k, reason: collision with root package name */
    private Executor f9793k = l.b();

    /* renamed from: l, reason: collision with root package name */
    private boolean f9794l;

    private b() {
    }

    private void c() {
        while (!this.f9792j.isEmpty()) {
            c cVar = (c) this.f9792j.remove(0);
            cVar.f9797a.put("appid", this.f9784b);
            cVar.f9797a.put("app_name", this.f9785c);
            cVar.f9797a.put(Constants.PARAM_APP_VER, this.f9787e);
            cVar.f9797a.put(Constants.PARAM_PKG_NAME, this.f9788f);
            cVar.f9797a.put("qq_install", this.f9789g);
            cVar.f9797a.put(Constants.PARAM_QQ_VER, this.f9790h);
            cVar.f9797a.put("openid", this.f9786d);
            cVar.f9797a.put("time_appid_openid", cVar.f9797a.get("time") + c.c.a.b.a.a.s1 + this.f9784b + c.c.a.b.a.a.s1 + this.f9786d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(cVar);
            SLog.i("AttaReporter", sb.toString());
            this.f9791i.add(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.f9794l) {
            List<Serializable> listB = g.b("report_atta");
            this.f9794l = listB.isEmpty();
            this.f9791i.addAll(listB);
            Iterator<Serializable> it = listB.iterator();
            while (it.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f9791i.isEmpty()) {
            c cVar = (c) this.f9791i.remove(0);
            if (!b(cVar)) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (this.f9794l) {
                return;
            }
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            g.a("report_atta");
            this.f9794l = true;
            return;
        }
        SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) it2.next()));
        }
        g.a("report_atta", arrayList);
        this.f9794l = false;
    }

    public static synchronized b a() {
        if (f9783a == null) {
            f9783a = new b();
        }
        return f9783a;
    }

    private c b(String str, String str2, Object obj, Map<String, Object> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map2 = new HashMap();
        map2.put("attaid", "09400051119");
        map2.put("token", "9389887874");
        map2.put("time_appid_openid", jCurrentTimeMillis + c.c.a.b.a.a.s1 + this.f9784b + c.c.a.b.a.a.s1 + this.f9786d);
        map2.put("time", String.valueOf(jCurrentTimeMillis));
        map2.put("openid", this.f9786d);
        map2.put("appid", this.f9784b);
        map2.put("app_name", this.f9785c);
        map2.put(Constants.PARAM_APP_VER, this.f9787e);
        map2.put(Constants.PARAM_PKG_NAME, this.f9788f);
        map2.put("os", "AND");
        map2.put("os_ver", Build.VERSION.RELEASE);
        map2.put("sdk_ver", Constants.SDK_VERSION);
        map2.put(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
        map2.put("interface_name", str);
        map2.put("interface_data", str2);
        map2.put("interface_result", obj == null ? "" : obj.toString());
        map2.put("qq_install", this.f9789g);
        map2.put(Constants.PARAM_QQ_VER, this.f9790h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            map2.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            map2.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            map2.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            map2.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new c((HashMap<String, String>) map2);
    }

    public void a(String str, Context context) {
        SLog.i("AttaReporter", "init");
        this.f9784b = str;
        this.f9785c = k.a(context);
        this.f9787e = m.d(context, com.tencent.open.utils.g.b());
        this.f9788f = com.tencent.open.utils.g.b();
        this.f9789g = k.b(context) ? "1" : "0";
        this.f9790h = m.c(context, "com.tencent.mobileqq");
        c();
        g.a();
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.f9786d = str;
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        c cVarB = b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.f9784b) && !TextUtils.isEmpty(this.f9785c) && com.tencent.open.utils.g.a() != null) {
            a(cVarB);
            return;
        }
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.f9784b + ", mAppName=" + this.f9785c + ", context=" + com.tencent.open.utils.g.a() + ", " + cVarB);
        this.f9792j.add(cVarB);
    }

    private void a(final c cVar) {
        this.f9793k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f9791i.add(cVar);
                if (m.b(com.tencent.open.utils.g.a())) {
                    try {
                        b.this.d();
                        return;
                    } catch (Exception e2) {
                        SLog.e("AttaReporter", LogUtils.LOG_EXCEPTION, e2);
                        return;
                    }
                }
                SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
            }
        });
    }

    private boolean b(c cVar) {
        int i2 = 0;
        do {
            i2++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + cVar);
                return com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", cVar.f9797a).d() == 200;
            } catch (Exception e2) {
                SLog.i("AttaReporter", LogUtils.LOG_EXCEPTION, e2);
            }
        } while (i2 < 2);
        return false;
    }

    public static String b() {
        return a().f9784b;
    }
}
