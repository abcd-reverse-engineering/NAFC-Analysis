package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f8405a;

    /* renamed from: b, reason: collision with root package name */
    public static String f8406b;

    /* renamed from: c, reason: collision with root package name */
    public static String f8407c;

    /* renamed from: d, reason: collision with root package name */
    public static String f8408d;

    /* renamed from: e, reason: collision with root package name */
    public static IProcessName f8409e;

    /* renamed from: f, reason: collision with root package name */
    public static AtomicInteger f8410f = new AtomicInteger(-1);

    /* renamed from: g, reason: collision with root package name */
    private static volatile a f8411g;

    /* renamed from: h, reason: collision with root package name */
    private static Context f8412h;

    /* renamed from: i, reason: collision with root package name */
    private ActivityManager f8413i;

    private a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        if (f8412h == null) {
            f8412h = context.getApplicationContext();
        }
    }

    public static a a(Context context) {
        if (f8411g == null) {
            synchronized (a.class) {
                if (f8411g == null) {
                    f8411g = new a(context);
                }
            }
        }
        return f8411g;
    }

    public static String b() {
        String str = TextUtils.isEmpty(f8405a) ? "com.umeng.message.component.UmengIntentService" : f8405a;
        ALog.d("AdapterGlobalClientInfo", "getAgooCustomServiceName", "serviceName", str);
        return str;
    }

    public static boolean c() {
        return f8410f.intValue() == 0;
    }

    public ActivityManager a() {
        if (this.f8413i == null) {
            this.f8413i = (ActivityManager) f8412h.getSystemService("activity");
        }
        return this.f8413i;
    }
}
