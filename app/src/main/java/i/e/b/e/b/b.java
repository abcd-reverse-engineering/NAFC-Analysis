package i.e.b.e.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import i.e.b.e.a.a;

/* compiled from: OpenDeviceId.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static String f16983e = "OpenDeviceId library";

    /* renamed from: f, reason: collision with root package name */
    private static boolean f16984f = false;

    /* renamed from: b, reason: collision with root package name */
    private i.e.b.e.a.a f16986b;

    /* renamed from: c, reason: collision with root package name */
    private ServiceConnection f16987c;

    /* renamed from: a, reason: collision with root package name */
    private Context f16985a = null;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0262b f16988d = null;

    /* compiled from: OpenDeviceId.java */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f16986b = a.AbstractBinderC0260a.a(iBinder);
            if (b.this.f16988d != null) {
                b.this.f16988d.a("Deviceid Service Connected", b.this);
            }
            b.this.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f16986b = null;
            b.this.a("Service onServiceDisconnected");
        }
    }

    /* compiled from: OpenDeviceId.java */
    /* renamed from: i.e.b.e.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0262b<T> {
        void a(T t, b bVar);
    }

    public String b() {
        if (this.f16985a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.f16986b != null) {
                return this.f16986b.b();
            }
            return null;
        } catch (RemoteException e2) {
            b("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            b("getUDID error, Exception!");
            e3.printStackTrace();
            return null;
        }
    }

    public boolean c() {
        try {
            if (this.f16986b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.f16986b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.f16985a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            if (this.f16986b != null) {
                return this.f16986b.a(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            b("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String e() {
        Context context = this.f16985a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        String strB = null;
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            if (this.f16986b == null) {
                return null;
            }
            strB = this.f16986b.b(packageName);
            return ((strB == null || "".equals(strB)) && this.f16986b.c(packageName)) ? this.f16986b.b(packageName) : strB;
        } catch (RemoteException unused) {
            b("getAAID error, RemoteException!");
            return strB;
        }
    }

    public void f() {
        try {
            this.f16985a.unbindService(this.f16987c);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f16986b = null;
    }

    public int a(Context context, InterfaceC0262b<String> interfaceC0262b) {
        if (context != null) {
            this.f16985a = context;
            this.f16988d = interfaceC0262b;
            this.f16987c = new a();
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f16985a.bindService(intent, this.f16987c, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    private void b(String str) {
        boolean z = f16984f;
    }

    public String a() {
        if (this.f16985a != null) {
            try {
                if (this.f16986b != null) {
                    return this.f16986b.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z) {
        f16984f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        boolean z = f16984f;
    }
}
