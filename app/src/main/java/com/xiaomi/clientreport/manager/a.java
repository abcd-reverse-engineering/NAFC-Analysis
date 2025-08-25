package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ae;
import com.xiaomi.push.bb;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bl;
import com.xiaomi.push.bm;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f12323a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile a f74a;

    /* renamed from: a, reason: collision with other field name */
    private Context f75a;

    /* renamed from: a, reason: collision with other field name */
    private Config f76a;

    /* renamed from: a, reason: collision with other field name */
    private IEventProcessor f77a;

    /* renamed from: a, reason: collision with other field name */
    private IPerfProcessor f78a;

    /* renamed from: a, reason: collision with other field name */
    private String f79a;

    /* renamed from: a, reason: collision with other field name */
    private ExecutorService f81a = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f80a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f12324b = new HashMap<>();

    static {
        f12323a = j.m626a() ? 30 : 10;
    }

    private a(Context context) {
        this.f75a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f77a.b();
        } catch (Exception e2) {
            b.d("we: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f78a.b();
        } catch (Exception e2) {
            b.d("wp: " + e2.getMessage());
        }
    }

    private void f() {
        if (a(this.f75a).m59a().isEventUploadSwitchOpen()) {
            final bi biVar = new bi(this.f75a);
            int eventUploadFrequency = (int) a(this.f75a).m59a().getEventUploadFrequency();
            int i2 = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f75a).a("sp_client_report_status", "event_last_upload_time", 0L) > i2 * 1000) {
                ae.a(this.f75a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        biVar.run();
                    }
                }, 10);
            }
            synchronized (a.class) {
                if (!ae.a(this.f75a).a((ae.a) biVar, i2)) {
                    ae.a(this.f75a).m131a("100886");
                    ae.a(this.f75a).a((ae.a) biVar, i2);
                }
            }
        }
    }

    private void g() {
        if (a(this.f75a).m59a().isPerfUploadSwitchOpen()) {
            final bj bjVar = new bj(this.f75a);
            int perfUploadFrequency = (int) a(this.f75a).m59a().getPerfUploadFrequency();
            int i2 = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f75a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i2 * 1000) {
                ae.a(this.f75a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        bjVar.run();
                    }
                }, 15);
            }
            synchronized (a.class) {
                if (!ae.a(this.f75a).a((ae.a) bjVar, i2)) {
                    ae.a(this.f75a).m131a("100887");
                    ae.a(this.f75a).a((ae.a) bjVar, i2);
                }
            }
        }
    }

    public void c() {
        if (m59a().isPerfUploadSwitchOpen()) {
            bk bkVar = new bk();
            bkVar.a(this.f78a);
            bkVar.a(this.f75a);
            this.f81a.execute(bkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f77a;
        if (iEventProcessor != null) {
            iEventProcessor.mo62a(eventClientReport);
            if (a() >= 10) {
                d();
                ae.a(this.f75a).m131a("100888");
            } else {
                a(new ae.a() { // from class: com.xiaomi.clientreport.manager.a.3
                    @Override // com.xiaomi.push.ae.a
                    /* renamed from: a */
                    public String mo183a() {
                        return "100888";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.a() > 0) {
                            a.this.f81a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.d();
                                }
                            });
                        }
                    }
                }, f12323a);
            }
        }
    }

    public static a a(Context context) {
        if (f74a == null) {
            synchronized (a.class) {
                if (f74a == null) {
                    f74a = new a(context);
                }
            }
        }
        return f74a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f78a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo62a(perfClientReport);
            if (b() >= 10) {
                e();
                ae.a(this.f75a).m131a("100889");
            } else {
                a(new ae.a() { // from class: com.xiaomi.clientreport.manager.a.4
                    @Override // com.xiaomi.push.ae.a
                    /* renamed from: a */
                    public String mo183a() {
                        return "100889";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.b() > 0) {
                            a.this.f81a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.e();
                                }
                            });
                        }
                    }
                }, f12323a);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Config m59a() {
        if (this.f76a == null) {
            this.f76a = Config.defaultConfig(this.f75a);
        }
        return this.f76a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> map = this.f80a;
        int i2 = 0;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, com.xiaomi.clientreport.data.a> map2 = this.f80a.get(it.next());
                if (map2 != null) {
                    Iterator<String> it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        com.xiaomi.clientreport.data.a aVar = map2.get(it2.next());
                        if (aVar instanceof PerfClientReport) {
                            i2 = (int) (i2 + ((PerfClientReport) aVar).perfCounts);
                        }
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m60a() {
        a(this.f75a).f();
        a(this.f75a).g();
    }

    public void a(String str) {
        this.f79a = str;
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f76a = config;
        this.f77a = iEventProcessor;
        this.f78a = iPerfProcessor;
        this.f77a.setEventMap(this.f12324b);
        this.f78a.setPerfMap(this.f80a);
    }

    public void a(boolean z, boolean z2, long j2, long j3) {
        Config config = this.f76a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f76a.isPerfUploadSwitchOpen() && j2 == this.f76a.getEventUploadFrequency() && j3 == this.f76a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f76a.getEventUploadFrequency();
            long perfUploadFrequency = this.f76a.getPerfUploadFrequency();
            Config configBuild = Config.getBuilder().setAESKey(bl.a(this.f75a)).setEventEncrypted(this.f76a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j2).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j3).build(this.f75a);
            this.f76a = configBuild;
            if (!this.f76a.isEventUploadSwitchOpen()) {
                ae.a(this.f75a).m131a("100886");
            } else if (eventUploadFrequency != configBuild.getEventUploadFrequency()) {
                b.c(this.f75a.getPackageName() + "reset event job " + configBuild.getEventUploadFrequency());
                f();
            }
            if (!this.f76a.isPerfUploadSwitchOpen()) {
                ae.a(this.f75a).m131a("100887");
                return;
            }
            if (perfUploadFrequency != configBuild.getPerfUploadFrequency()) {
                b.c(this.f75a.getPackageName() + " reset perf job " + configBuild.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m61b() {
        if (m59a().isEventUploadSwitchOpen()) {
            bk bkVar = new bk();
            bkVar.a(this.f75a);
            bkVar.a(this.f77a);
            this.f81a.execute(bkVar);
        }
    }

    private void a(ae.a aVar, int i2) {
        ae.a(this.f75a).b(aVar, i2);
    }

    public void a(final EventClientReport eventClientReport) {
        if (m59a().isEventUploadSwitchOpen()) {
            this.f81a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(eventClientReport);
                }
            });
        }
    }

    public void a(final PerfClientReport perfClientReport) {
        if (m59a().isPerfUploadSwitchOpen()) {
            this.f81a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(perfClientReport);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map = this.f12324b;
        if (map == null) {
            return 0;
        }
        Iterator<String> it = map.keySet().iterator();
        int size = 0;
        while (it.hasNext()) {
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f12324b.get(it.next());
            size += arrayList != null ? arrayList.size() : 0;
        }
        return size;
    }

    public EventClientReport a(int i2, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i2;
        eventClientReport.eventId = bb.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f75a.getPackageName());
        eventClientReport.setSdkVersion(this.f79a);
        return eventClientReport;
    }
}
