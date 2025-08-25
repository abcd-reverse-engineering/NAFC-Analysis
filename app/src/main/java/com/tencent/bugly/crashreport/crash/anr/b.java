package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b implements at {

    /* renamed from: c, reason: collision with root package name */
    private final Context f9059c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f9060d;

    /* renamed from: e, reason: collision with root package name */
    private final am f9061e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f9062f;

    /* renamed from: g, reason: collision with root package name */
    private final String f9063g;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f9064h;

    /* renamed from: i, reason: collision with root package name */
    private FileObserver f9065i;

    /* renamed from: k, reason: collision with root package name */
    private as f9067k;

    /* renamed from: l, reason: collision with root package name */
    private int f9068l;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f9057a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private long f9058b = -1;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9066j = true;

    public b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, am amVar, ae aeVar, com.tencent.bugly.crashreport.crash.b bVar, BuglyStrategy.a aVar3) {
        this.f9059c = aq.a(context);
        this.f9063g = context.getDir("bugly", 0).getAbsolutePath();
        this.f9060d = aVar2;
        this.f9061e = amVar;
        this.f9062f = aVar;
        this.f9064h = bVar;
    }

    protected ActivityManager.ProcessErrorStateInfo a(Context context, long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        try {
            an.c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            long j3 = j2 / 500;
            int i2 = 0;
            while (true) {
                an.c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            an.c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                aq.b(500L);
                int i3 = i2 + 1;
                if (i2 >= j3) {
                    an.c("end!", new Object[0]);
                    return null;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            an.b(e2);
            return null;
        }
    }

    protected synchronized void b() {
        if (d()) {
            an.d("start when started!", new Object[0]);
            return;
        }
        this.f9065i = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public void onEvent(int i2, String str) {
                if (str == null) {
                    return;
                }
                String str2 = "/data/anr/" + str;
                if (str2.contains(AgooConstants.MESSAGE_TRACE)) {
                    b.this.a(str2);
                } else {
                    an.d("not anr file %s", str2);
                }
            }
        };
        try {
            this.f9065i.startWatching();
            an.a("start anr monitor!", new Object[0]);
            this.f9061e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f();
                }
            });
        } catch (Throwable th) {
            this.f9065i = null;
            an.d("start anr monitor failed!", new Object[0]);
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
    }

    protected synchronized void c() {
        if (!d()) {
            an.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f9065i.stopWatching();
            this.f9065i = null;
            an.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            an.d("stop anr monitor failed!", new Object[0]);
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
    }

    protected synchronized boolean d() {
        return this.f9065i != null;
    }

    public synchronized boolean e() {
        return this.f9066j;
    }

    protected void f() {
        int iIndexOf;
        long jB = aq.b() - c.f9086g;
        File file = new File(this.f9063g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i2 = 0;
                    for (File file2 : fileArrListFiles) {
                        String name = file2.getName();
                        if (name.startsWith("bugly_trace_")) {
                            try {
                                iIndexOf = name.indexOf(".txt");
                            } catch (Throwable unused) {
                                an.c("Trace file that has invalid format: " + name, new Object[0]);
                            }
                            if (iIndexOf <= 0 || Long.parseLong(name.substring(12, iIndexOf)) < jB) {
                                if (file2.delete()) {
                                    i2++;
                                }
                            }
                        }
                    }
                    an.c("Number of overdue trace files that has deleted: " + i2, new Object[0]);
                }
            } catch (Throwable th) {
                an.a(th);
            }
        }
    }

    public void g() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 30) {
                return;
            }
            try {
                an.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                aq.b(com.heytap.mcssdk.constant.a.r);
                i2 = i3;
            } catch (Throwable th) {
                if (an.a(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
    }

    public boolean h() {
        as asVar = this.f9067k;
        if (asVar != null && asVar.isAlive()) {
            return false;
        }
        this.f9067k = new as();
        as asVar2 = this.f9067k;
        StringBuilder sb = new StringBuilder();
        sb.append("Bugly-ThreadMonitor");
        int i2 = this.f9068l;
        this.f9068l = i2 + 1;
        sb.append(i2);
        asVar2.setName(sb.toString());
        this.f9067k.a();
        this.f9067k.a(this);
        return this.f9067k.d();
    }

    public boolean i() {
        as asVar = this.f9067k;
        if (asVar == null) {
            return false;
        }
        boolean zC = asVar.c();
        this.f9067k.b();
        this.f9067k.b(this);
        this.f9067k = null;
        return zC;
    }

    private synchronized void c(boolean z) {
        if (this.f9066j != z) {
            an.a("user change anr %b", Boolean.valueOf(z));
            this.f9066j = z;
        }
    }

    protected a a(Context context, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        File file = new File(context.getFilesDir(), "bugly/bugly_trace_" + j2 + ".txt");
        a aVar = new a();
        aVar.f9052c = j2;
        aVar.f9053d = file.getAbsolutePath();
        aVar.f9050a = processErrorStateInfo != null ? processErrorStateInfo.processName : "";
        aVar.f9055f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f9054e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.f9051b = map;
        if (map != null) {
            for (String str : map.keySet()) {
                if (str.startsWith("main(")) {
                    aVar.f9056g = map.get(str);
                }
            }
        }
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(aVar.f9052c);
        objArr[1] = aVar.f9053d;
        objArr[2] = aVar.f9050a;
        objArr[3] = aVar.f9055f;
        objArr[4] = aVar.f9054e;
        Map<String, String> map2 = aVar.f9051b;
        objArr[5] = Integer.valueOf(map2 != null ? map2.size() : 0);
        an.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        return aVar;
    }

    public void b(boolean z) {
        c(z);
        boolean zE = e();
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null) {
            zE = zE && aVarA.c().f8998g;
        }
        if (zE != d()) {
            an.a("anr changed to %b", Boolean.valueOf(zE));
            a(zE);
        }
    }

    protected CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.k();
            crashDetailBean.F = this.f9060d.p();
            crashDetailBean.G = this.f9060d.o();
            crashDetailBean.H = this.f9060d.q();
            crashDetailBean.w = aq.a(this.f9059c, c.f9084e, c.f9087h);
            crashDetailBean.f9023b = 3;
            crashDetailBean.f9026e = this.f9060d.h();
            crashDetailBean.f9027f = this.f9060d.p;
            crashDetailBean.f9028g = this.f9060d.w();
            crashDetailBean.f9034m = this.f9060d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f9055f;
            crashDetailBean.q = aVar.f9056g;
            crashDetailBean.P = new HashMap();
            crashDetailBean.P.put("BUGLY_CR_01", aVar.f9054e);
            int iIndexOf = crashDetailBean.q != null ? crashDetailBean.q.indexOf("\n") : -1;
            crashDetailBean.p = iIndexOf > 0 ? crashDetailBean.q.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.f9052c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = aq.b(crashDetailBean.q.getBytes());
            }
            crashDetailBean.z = aVar.f9051b;
            crashDetailBean.A = aVar.f9050a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.f9060d.y();
            crashDetailBean.f9029h = this.f9060d.v();
            crashDetailBean.f9030i = this.f9060d.J();
            crashDetailBean.v = aVar.f9053d;
            crashDetailBean.M = this.f9060d.u;
            crashDetailBean.N = this.f9060d.f8974a;
            crashDetailBean.O = this.f9060d.a();
            crashDetailBean.Q = this.f9060d.H();
            crashDetailBean.R = this.f9060d.I();
            crashDetailBean.S = this.f9060d.B();
            crashDetailBean.T = this.f9060d.G();
            this.f9064h.c(crashDetailBean);
            crashDetailBean.y = ap.a();
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    protected boolean a(String str, String str2, String str3) throws Throwable {
        Map<String, String[]> map;
        BufferedWriter bufferedWriter;
        TraceFileHelper.a targetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (targetDumpInfo != null && (map = targetDumpInfo.f9049d) != null && map.size() > 0) {
            File file = new File(str2);
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                if (file.exists() && file.canWrite()) {
                    BufferedWriter bufferedWriter2 = null;
                    try {
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                            try {
                                String[] strArr = targetDumpInfo.f9049d.get("main");
                                int i2 = 3;
                                if (strArr != null && strArr.length >= 3) {
                                    String str4 = strArr[0];
                                    String str5 = strArr[1];
                                    bufferedWriter.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                                    bufferedWriter.flush();
                                }
                                for (Map.Entry<String, String[]> entry : targetDumpInfo.f9049d.entrySet()) {
                                    if (!entry.getKey().equals("main")) {
                                        if (entry.getValue() != null && entry.getValue().length >= i2) {
                                            String str6 = entry.getValue()[0];
                                            String str7 = entry.getValue()[1];
                                            bufferedWriter.write("\"" + entry.getKey() + "\" tid=" + entry.getValue()[2] + " :\n" + str6 + "\n" + str7 + "\n\n");
                                            bufferedWriter.flush();
                                        }
                                        i2 = 3;
                                    }
                                }
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e2) {
                                    if (!an.a(e2)) {
                                        e2.printStackTrace();
                                    }
                                }
                                return true;
                            } catch (IOException e3) {
                                e = e3;
                                bufferedWriter2 = bufferedWriter;
                                if (!an.a(e)) {
                                    e.printStackTrace();
                                }
                                an.e("dump trace fail %s", e.getClass().getName() + Constants.COLON_SEPARATOR + e.getMessage());
                                if (bufferedWriter2 != null) {
                                    try {
                                        bufferedWriter2.close();
                                    } catch (IOException e4) {
                                        if (!an.a(e4)) {
                                            e4.printStackTrace();
                                        }
                                    }
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                Throwable th2 = th;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                        throw th2;
                                    } catch (IOException e5) {
                                        if (!an.a(e5)) {
                                            e5.printStackTrace();
                                            throw th2;
                                        }
                                        throw th2;
                                    }
                                }
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter = bufferedWriter2;
                        }
                    } catch (IOException e6) {
                        e = e6;
                    }
                } else {
                    an.e("backup file create fail %s", str2);
                    return false;
                }
            } catch (Exception e7) {
                if (!an.a(e7)) {
                    e7.printStackTrace();
                }
                an.e("backup file create error! %s  %s", e7.getClass().getName() + Constants.COLON_SEPARATOR + e7.getMessage(), str2);
                return false;
            }
        } else {
            an.e("not found trace dump for %s", str3);
            return false;
        }
    }

    public boolean a() {
        return this.f9057a.get() != 0;
    }

    public boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        a aVarA = a(context, processErrorStateInfo, j2, map);
        if (!this.f9062f.b()) {
            an.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
            com.tencent.bugly.crashreport.crash.b.a("ANR", aq.a(), aVarA.f9050a, "main", aVarA.f9054e, null);
            return false;
        }
        if (!this.f9062f.c().f9001j) {
            an.d("ANR Report is closed!", new Object[0]);
            return false;
        }
        an.a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean crashDetailBeanA = a(aVarA);
        if (crashDetailBeanA == null) {
            an.e("pack anr fail!", new Object[0]);
            return false;
        }
        c.a().a(crashDetailBeanA);
        if (crashDetailBeanA.f9022a >= 0) {
            an.a("backup anr record success!", new Object[0]);
        } else {
            an.d("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            this.f9057a.set(3);
            if (a(str, aVarA.f9053d, aVarA.f9050a)) {
                an.a("backup trace success", new Object[0]);
            }
        }
        com.tencent.bugly.crashreport.crash.b.a("ANR", aq.a(), aVarA.f9050a, "main", aVarA.f9054e, crashDetailBeanA);
        if (!this.f9064h.a(crashDetailBeanA)) {
            this.f9064h.a(crashDetailBeanA, 3000L, true);
        }
        this.f9064h.b(crashDetailBeanA);
        return true;
    }

    public final void a(String str) {
        long j2;
        synchronized (this) {
            if (this.f9057a.get() != 0) {
                an.c("trace started return ", new Object[0]);
                return;
            }
            this.f9057a.set(1);
            try {
                an.c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a firstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long jCurrentTimeMillis = firstDumpInfo != null ? firstDumpInfo.f9048c : -1L;
                if (jCurrentTimeMillis == -1) {
                    an.d("trace dump fail could not get time!", new Object[0]);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                j2 = jCurrentTimeMillis;
            } finally {
                try {
                } finally {
                }
            }
            if (Math.abs(j2 - this.f9058b) < com.heytap.mcssdk.constant.a.q) {
                an.d("should not process ANR too Fre in %d", 10000);
            } else {
                this.f9058b = j2;
                this.f9057a.set(1);
                try {
                    Map<String, String> mapA = aq.a(c.f9085f, false);
                    if (mapA != null && mapA.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.f9059c, com.heytap.mcssdk.constant.a.q);
                        if (processErrorStateInfoA == null) {
                            an.c("proc state is unvisiable!", new Object[0]);
                        } else {
                            if (processErrorStateInfoA.pid == Process.myPid()) {
                                an.a("found visiable anr , start to process!", new Object[0]);
                                a(this.f9059c, str, processErrorStateInfoA, j2, mapA);
                                return;
                            }
                            an.c("not mind proc!", processErrorStateInfoA.processName);
                        }
                    } else {
                        an.d("can't get all thread skip this anr", new Object[0]);
                    }
                } catch (Throwable th) {
                    an.a(th);
                    an.e("get all thread stack fail!", new Object[0]);
                }
            }
        }
    }

    protected synchronized void a(boolean z) {
        if (z) {
            b();
        } else {
            c();
        }
    }

    public synchronized void a(StrategyBean strategyBean) {
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.f9001j != d()) {
            an.d("server anr changed to %b", Boolean.valueOf(strategyBean.f9001j));
        }
        if (Build.VERSION.SDK_INT <= 19) {
            boolean z = strategyBean.f9001j && e();
            if (z != d()) {
                an.a("anr changed to %b", Boolean.valueOf(z));
                a(z);
            }
        } else if (strategyBean.f9001j) {
            h();
        } else {
            i();
        }
    }

    @Override // com.tencent.bugly.proguard.at
    public boolean a(Thread thread) {
        new HashMap();
        if (thread.getName().contains("main")) {
            ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.f9059c, com.heytap.mcssdk.constant.a.q);
            if (processErrorStateInfoA == null) {
                an.c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
                return false;
            }
            if (processErrorStateInfoA.pid != Process.myPid()) {
                an.c("onThreadBlock not mind proc!", processErrorStateInfoA.processName);
                return false;
            }
            try {
                Map<String, String> mapA = aq.a(200000, false);
                an.a("onThreadBlock found visiable anr , start to process!", new Object[0]);
                a(this.f9059c, "", processErrorStateInfoA, System.currentTimeMillis(), mapA);
            } catch (Throwable unused) {
                return false;
            }
        } else {
            an.c("anr handler onThreadBlock only care main thread", new Object[0]);
        }
        return true;
    }
}
