package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f6888a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f6889b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONArray f6890c;

        a(long j2, ArrayList arrayList, JSONArray jSONArray) {
            this.f6888a = j2;
            this.f6889b = arrayList;
            this.f6890c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            com.huawei.hms.framework.network.grs.g.j.a aVar = new com.huawei.hms.framework.network.grs.g.j.a();
            aVar.put("total_time", this.f6888a);
            Iterator it = this.f6889b.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.o() || dVar.m()) {
                    aVar.put(e.b(dVar));
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z && this.f6889b.size() > 0) {
                ArrayList arrayList = this.f6889b;
                d dVar2 = (d) arrayList.get(arrayList.size() - 1);
                aVar.put(e.b(dVar2));
                this.f6889b.remove(dVar2);
            }
            if (this.f6889b.size() > 0) {
                Iterator it2 = this.f6889b.iterator();
                while (it2.hasNext()) {
                    this.f6890c.put(new JSONObject(e.b((d) it2.next())));
                }
            }
            if (this.f6890c.length() > 0) {
                aVar.put("failed_info", this.f6890c.toString());
            }
            Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
            HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
        }
    }

    public static void a(ArrayList<d> arrayList, long j2, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReport(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j2, arrayList, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception excD = dVar.d();
        if (excD != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(excD));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, excD.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(excD.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, dVar.c());
        }
        try {
            linkedHashMapPack.put(DispatchConstants.DOMAIN, new URL(dVar.l()).getHost());
        } catch (MalformedURLException e2) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e2);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }
}
