package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SessionIdManager.java */
/* loaded from: classes2.dex */
public class y {

    /* renamed from: c, reason: collision with root package name */
    private static volatile y f10535c;

    /* renamed from: a, reason: collision with root package name */
    private w f10536a = new x();

    /* renamed from: b, reason: collision with root package name */
    private String f10537b;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f10538d;

    /* renamed from: e, reason: collision with root package name */
    private String f10539e;

    /* compiled from: SessionIdManager.java */
    public interface a {
        void a(String str, long j2, long j3, long j4);

        void a(String str, String str2, long j2, long j3, long j4);
    }

    private y() {
    }

    public static y a() {
        if (f10535c == null) {
            synchronized (y.class) {
                if (f10535c == null) {
                    f10535c = new y();
                }
            }
        }
        return f10535c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString(u.f10517d, d(context));
            editorEdit.commit();
        } catch (Exception unused) {
        }
        long jH = h(context);
        long jI = i(context);
        String str = this.f10537b;
        long jA = u.a(context);
        long j2 = jA * com.heytap.mcssdk.constant.a.r;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + jA);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(jI, jH, j2, str, false);
        this.f10537b = this.f10536a.a(context);
        a(jI, jH, j2, str, true);
        this.f10536a.a(context, this.f10537b);
        return this.f10537b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f10537b) && i.a(context).a(this.f10537b) > 0;
    }

    private long h(Context context) {
        return a(context, u.f10519f);
    }

    private long i(Context context) {
        return a(context, u.f10514a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j2 = sharedPreferences.getLong(u.f10518e, 0L);
            long j3 = sharedPreferences.getLong(u.f10519f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j2 > 0 && j3 == 0) {
                long jA = u.a(appContext);
                if (jA > 0) {
                    long j4 = jA * com.heytap.mcssdk.constant.a.r;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j3 = j2 + j4;
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j3 - j2));
            return this.f10536a.a(j2, j3);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f10536a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f10537b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f10537b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f10537b)) {
            try {
                this.f10537b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f10537b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f10537b)) {
            this.f10537b = d(context);
        }
        return TextUtils.isEmpty(this.f10537b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f10537b = d(appContext);
        if (e(appContext)) {
            try {
                this.f10537b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f10537b;
    }

    public void a(long j2) {
        this.f10536a.a(j2);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String string = "";
        try {
            synchronized (y.class) {
                string = PreferenceWrapper.getDefault(appContext).getString(u.f10517d, "");
            }
        } catch (Exception unused) {
        }
        return string;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f10538d) == null || list.size() == 0) {
            return;
        }
        this.f10538d.remove(aVar);
    }

    public String a(Context context, long j2) {
        if (TextUtils.isEmpty(this.f10539e)) {
            String str = "SUB" + j2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f10539e = sb.toString();
        }
        return this.f10539e;
    }

    private long a(Context context, String str) {
        long j2;
        try {
            j2 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j2 = 0;
        }
        return j2 <= 0 ? System.currentTimeMillis() : j2;
    }

    private void a(long j2, long j3, long j4, String str, boolean z) {
        List<a> list = this.f10538d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.f10537b, j2, j3, j4);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f10537b, j2, j3, j4);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f10538d == null) {
            this.f10538d = new ArrayList();
        }
        if (this.f10538d.contains(aVar)) {
            return;
        }
        this.f10538d.add(aVar);
    }
}
