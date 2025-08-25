package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewPageTracker.java */
/* loaded from: classes2.dex */
public class v {

    /* renamed from: c, reason: collision with root package name */
    private static final int f10528c = 5;

    /* renamed from: d, reason: collision with root package name */
    private static JSONArray f10529d = new JSONArray();

    /* renamed from: e, reason: collision with root package name */
    private static Object f10530e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Long> f10533f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    Stack<String> f10531a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f10532b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f10530e) {
                    string = f10529d.toString();
                    f10529d = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put("__a", new JSONArray(string));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected int a() {
        return 2;
    }

    public void b(String str) {
        Long l2;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f10533f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.f10531a.size() == 0) {
                UMLog.aq(j.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f10533f) {
            l2 = this.f10533f.get(str);
            this.f10533f.remove(str);
        }
        if (l2 == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f10531a.size() > 0 && str.equals(this.f10531a.peek())) {
            this.f10531a.pop();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - l2.longValue();
        synchronized (f10530e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(d.v, str);
                jSONObject.put("duration", jCurrentTimeMillis);
                jSONObject.put(d.x, l2);
                jSONObject.put("type", a());
                f10529d.put(jSONObject);
                if (f10529d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.f10531a.size() == 0) {
            return;
        }
        UMLog.aq(j.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f10531a.size() != 0) {
            UMLog.aq(j.F, 0, "\\|", new String[]{"@"}, new String[]{this.f10531a.peek()}, null, null);
        }
        this.f10532b.customPageBegin(str);
        synchronized (this.f10533f) {
            this.f10533f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f10531a.push(str);
            }
        }
    }

    public void b() {
        String key;
        synchronized (this.f10533f) {
            key = null;
            long j2 = 0;
            for (Map.Entry<String, Long> entry : this.f10533f.entrySet()) {
                if (entry.getValue().longValue() > j2) {
                    long jLongValue = entry.getValue().longValue();
                    key = entry.getKey();
                    j2 = jLongValue;
                }
            }
        }
        if (key != null) {
            b(key);
        }
    }
}
