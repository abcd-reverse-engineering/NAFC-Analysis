package k.a.a.c.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.hihonor.cloudservice.framework.aidl.b;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k.a.a.a.j.e;

/* compiled from: AIDLClientInvokeManager.java */
/* loaded from: classes2.dex */
public class a implements ServiceConnection {

    /* renamed from: j, reason: collision with root package name */
    private static a f17064j;

    /* renamed from: k, reason: collision with root package name */
    private static final AtomicInteger f17065k = new AtomicInteger();

    /* renamed from: l, reason: collision with root package name */
    private static final ExecutorService f17066l = Executors.newFixedThreadPool(3);

    /* renamed from: a, reason: collision with root package name */
    private com.hihonor.cloudservice.framework.aidl.b f17067a;

    /* renamed from: f, reason: collision with root package name */
    private Context f17072f;

    /* renamed from: i, reason: collision with root package name */
    private Handler f17075i;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f17068b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final Queue<k.a.a.c.a.b> f17069c = new LinkedBlockingQueue();

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f17070d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private CountDownLatch f17071e = null;

    /* renamed from: g, reason: collision with root package name */
    private int f17073g = 0;

    /* renamed from: h, reason: collision with root package name */
    final HandlerThread f17074h = new HandlerThread("AIDLClientInvokeManager");

    /* compiled from: AIDLClientInvokeManager.java */
    /* renamed from: k.a.a.c.a.a$a, reason: collision with other inner class name */
    class HandlerC0265a extends Handler {
        HandlerC0265a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            e.b("AIDLClientInvokeManager", "msg.what: " + message.what, true);
            int i2 = message.what;
            if (i2 == 3001) {
                if (a.this.f17070d.get() == 2) {
                    a.this.f();
                    return;
                } else {
                    if (a.this.f17070d.get() == 0) {
                        a.this.i();
                        return;
                    }
                    return;
                }
            }
            if (i2 == 3002) {
                a.this.f17070d.set(2);
                a.this.f();
                return;
            }
            if (i2 == 3003) {
                a.this.f17070d.set(0);
                a.this.e();
            } else if (i2 == 3004) {
                e.b("AIDLClientInvokeManager", "MSG_FINISH_TASK, unbind", true);
                a.this.j();
                a.this.f17070d.set(0);
            } else if (i2 == 3005) {
                e.b("AIDLClientInvokeManager", "MSG_START_SERVICE_FAILED all login return failed", true);
                a.this.f17070d.set(0);
                a.this.g();
            }
        }
    }

    /* compiled from: AIDLClientInvokeManager.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            try {
                boolean zAwait = a.this.f17071e.await(4000L, TimeUnit.MILLISECONDS);
                e.b("AIDLClientInvokeManager", "startService await", true);
                if (zAwait) {
                    return;
                }
                a.this.h();
            } catch (InterruptedException unused) {
                e.b("AIDLClientInvokeManager", "serviceStartDownLatch InterruptedException", true);
                a.this.h();
            }
        }
    }

    private a(Context context) {
        this.f17072f = context.getApplicationContext();
        this.f17074h.start();
        this.f17075i = new HandlerC0265a(this.f17074h.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        e.b("AIDLClientInvokeManager", "startService", true);
        this.f17070d.set(1);
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        e.b("AIDLClientInvokeManager", "unbind Service", true);
        try {
            this.f17072f.unbindService(this);
        } catch (Exception unused) {
            e.b("AIDLClientInvokeManager", "unbind service error", true);
        }
        e();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e.b("AIDLClientInvokeManager", "onServiceConnected", true);
        try {
            this.f17073g = 0;
            this.f17067a = b.a.a(iBinder);
            this.f17071e.countDown();
            this.f17068b.set(true);
            this.f17075i.sendEmptyMessage(ErrorStatus.r0);
        } catch (RuntimeException unused) {
            e.a("AIDLClientInvokeManager", "onServiceConnected RuntimeException!", true);
        } catch (Exception unused2) {
            e.a("AIDLClientInvokeManager", "onServiceConnected Exception!", true);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        e.b("AIDLClientInvokeManager", "onServiceDisconnected", true);
        this.f17073g = 0;
        this.f17075i.sendEmptyMessage(ErrorStatus.q0);
    }

    public static a a(Context context) {
        a aVar;
        if (context == null) {
            return null;
        }
        synchronized (a.class) {
            if (f17064j == null) {
                e.b("AIDLClientInvokeManager", "AIDLClientInvokeManager init", true);
                f17064j = new a(context);
            }
            aVar = f17064j;
        }
        return aVar;
    }

    private void c() {
        e.b("AIDLClientInvokeManager", "begin to bindService", true);
        Intent intent = new Intent();
        String strA = k.a.a.a.e.a(this.f17072f).a();
        intent.setAction("com.hihonor.id.HonorInvokeService");
        intent.setPackage(strA);
        try {
            if (this.f17072f.bindService(intent, this, 1)) {
                return;
            }
            e.a("AIDLClientInvokeManager", "bind service failed", true);
        } catch (Exception unused) {
            e.a("AIDLClientInvokeManager", "bind service exception", true);
        }
    }

    private void d() {
        this.f17068b.set(false);
        this.f17071e = new CountDownLatch(1);
        new Thread(new b()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.f17069c) {
            this.f17067a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        e.b("AIDLClientInvokeManager", "doTask", true);
        synchronized (this.f17069c) {
            while (true) {
                k.a.a.c.a.b bVarPoll = this.f17069c.poll();
                if (bVarPoll != null) {
                    try {
                        try {
                            f17066l.submit(bVarPoll);
                        } catch (RejectedExecutionException unused) {
                            e.a("AIDLClientInvokeManager", "Execute submit RejectedExecutionException!", true);
                        } catch (Exception unused2) {
                            e.a("AIDLClientInvokeManager", "Execute submit Exception!", true);
                        }
                    } catch (NullPointerException unused3) {
                        e.a("AIDLClientInvokeManager", "Execute submit NullPointerException!", true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        e.b("AIDLClientInvokeManager", "onBindServiceFailed", true);
        synchronized (this.f17069c) {
            while (true) {
                k.a.a.c.a.b bVarPoll = this.f17069c.poll();
                if (bVarPoll != null) {
                    f17065k.decrementAndGet();
                    bVarPoll.a(new ErrorStatus(40, "start APK service ERROR"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        e.b("AIDLClientInvokeManager", "onServiceConnectedTimeout", true);
        if (this.f17068b.get()) {
            return;
        }
        j();
        int i2 = this.f17073g;
        if (i2 < 3) {
            this.f17073g = i2 + 1;
            i();
        } else {
            this.f17068b.set(true);
            this.f17075i.sendEmptyMessage(3005);
        }
    }

    public void b() {
        e.b("AIDLClientInvokeManager", "sendTaskFinishMsg", true);
        synchronized (this.f17069c) {
            if (f17065k.decrementAndGet() == 0) {
                this.f17075i.sendEmptyMessage(ErrorStatus.p0);
            }
        }
    }

    public com.hihonor.cloudservice.framework.aidl.b a() {
        return this.f17067a;
    }

    public void a(k.a.a.c.a.b bVar) {
        e.b("AIDLClientInvokeManager", "addTask:", true);
        synchronized (this.f17069c) {
            f17065k.incrementAndGet();
            this.f17069c.add(bVar);
        }
        this.f17075i.sendEmptyMessage(3001);
    }
}
