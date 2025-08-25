package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;

/* loaded from: classes.dex */
public class f0 implements ServiceConnection {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f6271e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final RemoteServiceBean f6272a;

    /* renamed from: b, reason: collision with root package name */
    public a f6273b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f6274c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6275d = false;

    public interface a {
    }

    public f0(RemoteServiceBean remoteServiceBean) {
        this.f6272a = remoteServiceBean;
    }

    public final void a(int i2) {
        a aVar = this.f6273b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f6258a.f6261a.set(i2 == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            c0Var.f6258a.a(i2);
            c0Var.f6258a.f6262b = null;
        }
    }

    public void b() {
        try {
            String str = "trying to unbind service from " + this;
            l.f6299e.a().unbindService(this);
        } catch (Exception e2) {
            String str2 = "on unBind service exception:" + e2.getMessage();
        }
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        if (this.f6275d) {
            this.f6275d = false;
            return;
        }
        b();
        a();
        a aVar = this.f6273b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f6258a.f6261a.set(1);
            c0Var.f6258a.a(8002005);
            c0Var.f6258a.f6262b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a();
        a aVar = this.f6273b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f6258a.f6262b = IPushInvoke.Stub.asInterface(iBinder);
            if (c0Var.f6258a.f6262b == null) {
                c0Var.f6258a.f6264d.b();
                c0Var.f6258a.f6261a.set(1);
                c0Var.f6258a.a(8002001);
                return;
            }
            c0Var.f6258a.f6261a.set(3);
            b0.a aVar2 = c0Var.f6258a.f6263c;
            if (aVar2 != null) {
                z.a aVar3 = (z.a) aVar2;
                if (Looper.myLooper() == z.this.f6358a.getLooper()) {
                    aVar3.b();
                } else {
                    z.this.f6358a.post(new x(aVar3));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        a aVar = this.f6273b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f6258a.f6261a.set(1);
            c0Var.f6258a.a(8002002);
            c0Var.f6258a.f6262b = null;
        }
    }

    public final void a() {
        synchronized (f6271e) {
            Handler handler = this.f6274c;
            if (handler != null) {
                handler.removeMessages(1001);
                this.f6274c = null;
            }
        }
    }
}
