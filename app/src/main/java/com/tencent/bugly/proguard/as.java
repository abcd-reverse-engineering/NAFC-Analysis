package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import h.q2.t.m0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class as extends Thread {

    /* renamed from: b, reason: collision with root package name */
    private boolean f9289b = false;

    /* renamed from: a, reason: collision with root package name */
    final List<ar> f9288a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<at> f9290c = new ArrayList();

    private int e() {
        int iMax = 0;
        for (int i2 = 0; i2 < this.f9288a.size(); i2++) {
            try {
                iMax = Math.max(iMax, this.f9288a.get(i2).c());
            } catch (Exception e2) {
                an.b(e2);
            }
        }
        return iMax;
    }

    public void a() {
        a(new Handler(Looper.getMainLooper()));
    }

    public void b() {
        b(new Handler(Looper.getMainLooper()));
    }

    public boolean c() {
        this.f9289b = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            an.b(e2);
        }
        return true;
    }

    public boolean d() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            an.b(e2);
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f9289b) {
            for (int i2 = 0; i2 < this.f9288a.size(); i2++) {
                try {
                    this.f9288a.get(i2).a();
                } catch (Exception e2) {
                    an.b(e2);
                }
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            for (long jUptimeMillis2 = 2000; jUptimeMillis2 > 0 && !isInterrupted(); jUptimeMillis2 = 2000 - (SystemClock.uptimeMillis() - jUptimeMillis)) {
                Thread.sleep(jUptimeMillis2);
            }
            int iE = e();
            if (iE != 0 && iE != 1) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < this.f9288a.size(); i3++) {
                    ar arVar = this.f9288a.get(i3);
                    if (arVar.b()) {
                        arrayList.add(arVar);
                        arVar.a(m0.f16408b);
                    }
                }
                int i4 = 0;
                boolean z = false;
                while (i4 < arrayList.size()) {
                    ar arVar2 = (ar) arrayList.get(i4);
                    Thread threadD = arVar2.d();
                    boolean z2 = z;
                    for (int i5 = 0; i5 < this.f9290c.size(); i5++) {
                        if (this.f9290c.get(i5).a(threadD)) {
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        a(arVar2);
                    }
                    i4++;
                    z = z2;
                }
            }
        }
    }

    public void a(Handler handler) {
        a(handler, com.heytap.mcssdk.constant.a.r);
    }

    public void b(Handler handler) {
        if (handler == null) {
            an.e("removeThread handler should not be null", new Object[0]);
            return;
        }
        for (int i2 = 0; i2 < this.f9288a.size(); i2++) {
            try {
                if (this.f9288a.get(i2).e().equals(handler.getLooper().getThread().getName())) {
                    an.c("remove handler::%s", this.f9288a.get(i2));
                    this.f9288a.remove(i2);
                }
            } catch (Exception e2) {
                an.b(e2);
                return;
            }
        }
    }

    public void a(Handler handler, long j2) {
        if (handler == null) {
            an.e("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i2 = 0; i2 < this.f9288a.size(); i2++) {
            try {
                if (this.f9288a.get(i2).e().equals(handler.getLooper().getThread().getName())) {
                    an.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                an.b(e2);
            }
        }
        this.f9288a.add(new ar(handler, name, j2));
    }

    public void b(at atVar) {
        this.f9290c.remove(atVar);
    }

    public void a(at atVar) {
        if (this.f9290c.contains(atVar)) {
            an.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f9290c.add(atVar);
        }
    }

    private void a(ar arVar) {
        if (arVar.e().contains("main")) {
            arVar.f();
            an.d("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new Object[0]);
        }
    }
}
