package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.f;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.an;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;

    /* renamed from: c, reason: collision with root package name */
    private static int f8752c;

    /* renamed from: e, reason: collision with root package name */
    private static CrashModule f8753e = new CrashModule();

    /* renamed from: a, reason: collision with root package name */
    private long f8754a;

    /* renamed from: b, reason: collision with root package name */
    private BuglyStrategy.a f8755b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8756d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            com.tencent.bugly.crashreport.common.info.a.a(context).t = libBuglySOFilePath;
            an.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f8755b = buglyStrategy.getCrashHandleCallback();
            an.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            this.f8754a = buglyStrategy.getAppReportDelay();
            an.a("setted delay: %d", Long.valueOf(this.f8754a));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f8753e;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f8756d;
    }

    @Override // com.tencent.bugly.a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        if (context != null) {
            if (!this.f8756d) {
                an.a("Initializing crash module.", new Object[0]);
                ac acVarA = ac.a();
                int i2 = f8752c + 1;
                f8752c = i2;
                acVarA.a(1004, i2);
                this.f8756d = true;
                CrashReport.setContext(context);
                a(context, buglyStrategy);
                c cVarA = c.a(1004, context, z, this.f8755b, (f) null, (String) null);
                cVarA.f();
                if (buglyStrategy != null) {
                    cVarA.a(buglyStrategy.getCallBackType());
                    cVarA.a(buglyStrategy.getCloseErrorCallback());
                }
                cVarA.n();
                if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                    cVarA.h();
                } else {
                    an.a("[crash] Closed native crash monitor!", new Object[0]);
                    cVarA.g();
                }
                if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                    cVarA.i();
                } else {
                    an.a("[crash] Closed ANR monitor!", new Object[0]);
                    cVarA.j();
                }
                cVarA.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                cVarA.m();
                d.a(context);
                BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
                buglyBroadcastReceiver.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                buglyBroadcastReceiver.register(context);
                ac acVarA2 = ac.a();
                int i3 = f8752c - 1;
                f8752c = i3;
                acVarA2.a(1004, i3);
            }
        }
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        c cVarA;
        if (strategyBean == null || (cVarA = c.a()) == null) {
            return;
        }
        cVarA.a(strategyBean);
    }
}
