package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ui.activity.BaseProgressUploadActivity;

/* loaded from: classes2.dex */
public class ds {

    /* renamed from: a, reason: collision with root package name */
    private static a f12714a;

    /* renamed from: a, reason: collision with other field name */
    private static Map<String, gp> f402a;

    public interface a {
        void uploader(Context context, gj gjVar);
    }

    public static int a(int i2) {
        if (i2 > 0) {
            return i2 + 1000;
        }
        return -1;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m357a(int i2) {
        return i2 == 1000 ? "E100000" : i2 == 3000 ? "E100002" : i2 == 2000 ? "E100001" : i2 == 6000 ? "E100003" : "";
    }

    public static void a(a aVar) {
        f12714a = aVar;
    }

    private static void a(Context context, gj gjVar) {
        if (m359a(context.getApplicationContext())) {
            com.xiaomi.push.service.ba.a(context.getApplicationContext(), gjVar);
            return;
        }
        a aVar = f12714a;
        if (aVar != null) {
            aVar.uploader(context, gjVar);
        }
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static EventClientReport a(Context context, String str, String str2, int i2, long j2, String str3) {
        EventClientReport eventClientReportA = a(str);
        eventClientReportA.eventId = str2;
        eventClientReportA.eventType = i2;
        eventClientReportA.eventTime = j2;
        eventClientReportA.eventContent = str3;
        return eventClientReportA;
    }

    public static PerfClientReport a(Context context, int i2, long j2, long j3) {
        PerfClientReport perfClientReportA = a();
        perfClientReportA.code = i2;
        perfClientReportA.perfCounts = j2;
        perfClientReportA.perfLatencies = j3;
        return perfClientReportA;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m359a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                gj gjVarA = a(context, it.next());
                if (!com.xiaomi.push.service.az.a(gjVarA, false)) {
                    a(context, gjVarA);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static gj a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gj gjVar = new gj();
        gjVar.d("category_client_report_data");
        gjVar.a("push_sdk_channel");
        gjVar.a(1L);
        gjVar.b(str);
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(context.getPackageName());
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f(com.xiaomi.push.service.az.a());
        gjVar.c("quality_support");
        return gjVar;
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new dq(context), new dr(context));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m358a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static Config a(Context context) {
        boolean zA = com.xiaomi.push.service.ah.a(context).a(gk.PerfUploadSwitch.a(), false);
        boolean zA2 = com.xiaomi.push.service.ah.a(context).a(gk.EventUploadNewSwitch.a(), false);
        return Config.getBuilder().setEventUploadSwitchOpen(zA2).setEventUploadFrequency(com.xiaomi.push.service.ah.a(context).a(gk.EventUploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)).setPerfUploadSwitchOpen(zA).setPerfUploadFrequency(com.xiaomi.push.service.ah.a(context).a(gk.PerfUploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)).build(context);
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof gf) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof gp) {
                return r1.ordinal() + BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1;
            }
            if (r1 instanceof ed) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static gp m356a(String str) {
        if (f402a == null) {
            synchronized (gp.class) {
                if (f402a == null) {
                    f402a = new HashMap();
                    for (gp gpVar : gp.values()) {
                        f402a.put(gpVar.f597a.toLowerCase(), gpVar);
                    }
                }
            }
        }
        gp gpVar2 = f402a.get(str.toLowerCase());
        return gpVar2 != null ? gpVar2 : gp.Invalid;
    }
}
