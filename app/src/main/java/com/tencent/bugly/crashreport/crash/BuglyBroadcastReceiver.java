package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static BuglyBroadcastReceiver f9015d;

    /* renamed from: b, reason: collision with root package name */
    private Context f9017b;

    /* renamed from: c, reason: collision with root package name */
    private String f9018c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9019e = true;

    /* renamed from: a, reason: collision with root package name */
    private IntentFilter f9016a = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        if (f9015d == null) {
            f9015d = new BuglyBroadcastReceiver();
        }
        return f9015d;
    }

    public synchronized void addFilter(String str) {
        if (!this.f9016a.hasAction(str)) {
            this.f9016a.addAction(str);
        }
        an.c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f9017b = context;
        aq.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    an.a(BuglyBroadcastReceiver.f9015d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.f9017b.registerReceiver(BuglyBroadcastReceiver.f9015d, BuglyBroadcastReceiver.this.f9016a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            an.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f9017b = context;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
    }

    protected final synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f9019e) {
                    this.f9019e = false;
                    return true;
                }
                String strF = com.tencent.bugly.crashreport.common.info.b.f(this.f9017b);
                an.c("is Connect BC " + strF, new Object[0]);
                an.a("network %s changed to %s", "" + this.f9018c, "" + strF);
                if (strF == null) {
                    this.f9018c = null;
                    return true;
                }
                String str = this.f9018c;
                this.f9018c = strF;
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
                ak akVarA = ak.a();
                com.tencent.bugly.crashreport.common.info.a aVarA2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (aVarA != null && akVarA != null && aVarA2 != null) {
                    if (!strF.equals(str)) {
                        if (jCurrentTimeMillis - akVarA.a(c.f9080a) > 30000) {
                            an.a("try to upload crash on network changed.", new Object[0]);
                            c cVarA = c.a();
                            if (cVarA != null) {
                                cVarA.a(0L);
                            }
                        }
                        if (jCurrentTimeMillis - akVarA.a(1001) > 30000) {
                            an.a("try to upload userinfo on network changed.", new Object[0]);
                            com.tencent.bugly.crashreport.biz.b.f8954b.b();
                        }
                    }
                    return true;
                }
                an.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
