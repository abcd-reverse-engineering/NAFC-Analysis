package zxing.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;

/* compiled from: InactivityTimer.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    private static final String f21096e = "c";

    /* renamed from: f, reason: collision with root package name */
    private static final long f21097f = 300000;

    /* renamed from: a, reason: collision with root package name */
    private final Activity f21098a;

    /* renamed from: b, reason: collision with root package name */
    private final BroadcastReceiver f21099b = new C0326c();

    /* renamed from: c, reason: collision with root package name */
    private boolean f21100c = false;

    /* renamed from: d, reason: collision with root package name */
    private AsyncTask<Object, Object, Object> f21101d;

    /* compiled from: InactivityTimer.java */
    private final class b extends AsyncTask<Object, Object, Object> {
        private b() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) throws InterruptedException {
            try {
                Thread.sleep(300000L);
                String unused = c.f21096e;
                c.this.f21098a.finish();
                return null;
            } catch (InterruptedException unused2) {
                return null;
            }
        }
    }

    /* compiled from: InactivityTimer.java */
    /* renamed from: zxing.android.c$c, reason: collision with other inner class name */
    private final class C0326c extends BroadcastReceiver {
        private C0326c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    c.this.a();
                } else {
                    c.this.f();
                }
            }
        }
    }

    public c(Activity activity) {
        this.f21098a = activity;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        AsyncTask<Object, Object, Object> asyncTask = this.f21101d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f21101d = null;
        }
    }

    public synchronized void c() {
        if (!this.f21100c) {
            this.f21098a.registerReceiver(this.f21099b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f21100c = true;
        }
        a();
    }

    public void d() {
        f();
    }

    @SuppressLint({"NewApi"})
    public synchronized void a() {
        f();
        this.f21101d = new b();
        this.f21101d.execute(new Object[0]);
    }

    public synchronized void b() {
        f();
        if (this.f21100c) {
            this.f21098a.unregisterReceiver(this.f21099b);
            this.f21100c = false;
        }
    }
}
