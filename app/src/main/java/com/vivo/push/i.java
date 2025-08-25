package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.ag;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IPCManager.java */
/* loaded from: classes2.dex */
public final class i implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f12082a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, i> f12083b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private boolean f12084c;

    /* renamed from: d, reason: collision with root package name */
    private String f12085d;

    /* renamed from: e, reason: collision with root package name */
    private Context f12086e;

    /* renamed from: g, reason: collision with root package name */
    private volatile IPCInvoke f12088g;

    /* renamed from: i, reason: collision with root package name */
    private String f12090i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f12091j;

    /* renamed from: h, reason: collision with root package name */
    private Object f12089h = new Object();

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f12087f = new AtomicInteger(1);

    private i(Context context, String str) {
        this.f12085d = null;
        this.f12091j = null;
        this.f12086e = context;
        this.f12090i = str;
        this.f12091j = new Handler(Looper.getMainLooper(), new j(this));
        this.f12085d = com.vivo.push.util.aa.a(context);
        if (!TextUtils.isEmpty(this.f12085d) && !TextUtils.isEmpty(this.f12090i)) {
            this.f12084c = ag.a(context, this.f12085d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.u.c(this.f12086e, "init error : push pkgname is " + this.f12085d + " ; action is " + this.f12090i);
        this.f12084c = false;
    }

    private void d() {
        this.f12091j.removeMessages(1);
        this.f12091j.sendEmptyMessageDelayed(1, 3000L);
    }

    private void e() {
        this.f12091j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.f12086e.unbindService(this);
        } catch (Exception e2) {
            com.vivo.push.util.u.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.u.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.f12088g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f12088g == null) {
            com.vivo.push.util.u.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f12087f.set(1);
            return;
        }
        if (this.f12087f.get() == 2) {
            a(4);
        } else if (this.f12087f.get() != 4) {
            f();
        }
        synchronized (this.f12089h) {
            this.f12089h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f12088g = null;
        a(1);
    }

    public static i a(Context context, String str) {
        i iVar = f12083b.get(str);
        if (iVar == null) {
            synchronized (f12082a) {
                iVar = f12083b.get(str);
                if (iVar == null) {
                    iVar = new i(context, str);
                    f12083b.put(str, iVar);
                }
            }
        }
        return iVar;
    }

    private void b() {
        int i2 = this.f12087f.get();
        com.vivo.push.util.u.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i2)));
        if (i2 == 4 || i2 == 2 || i2 == 3 || i2 == 5 || !this.f12084c) {
            return;
        }
        a(2);
        if (c()) {
            d();
        } else {
            a(1);
            com.vivo.push.util.u.a("AidlManager", "bind core service fail");
        }
    }

    private boolean c() {
        Intent intent = new Intent(this.f12090i);
        intent.setPackage(this.f12085d);
        try {
            return this.f12086e.bindService(intent, this, 1);
        } catch (Exception e2) {
            com.vivo.push.util.u.a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    public final boolean a() {
        this.f12085d = com.vivo.push.util.aa.a(this.f12086e);
        if (TextUtils.isEmpty(this.f12085d)) {
            com.vivo.push.util.u.c(this.f12086e, "push pkgname is null");
            return false;
        }
        this.f12084c = ag.a(this.f12086e, this.f12085d) >= 1260;
        return this.f12084c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        this.f12087f.set(i2);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f12087f.get() == 2) {
            synchronized (this.f12089h) {
                try {
                    this.f12089h.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i2 = this.f12087f.get();
            if (i2 == 4) {
                this.f12091j.removeMessages(2);
                this.f12091j.sendEmptyMessageDelayed(2, 30000L);
                this.f12088g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.u.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i2)));
            return false;
        } catch (Exception e3) {
            com.vivo.push.util.u.a("AidlManager", "invoke error ", e3);
            int i3 = this.f12087f.get();
            com.vivo.push.util.u.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i3)));
            if (i3 == 1) {
                return false;
            }
            if (i3 == 2) {
                e();
                a(1);
                return false;
            }
            if (i3 == 3) {
                a(1);
                return false;
            }
            if (i3 != 4) {
                return false;
            }
            a(1);
            f();
            return false;
        }
    }
}
