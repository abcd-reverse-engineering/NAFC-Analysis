package m.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import anet.channel.entity.ConnType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: AutoFocusManager.java */
/* loaded from: classes2.dex */
final class a implements Camera.AutoFocusCallback {

    /* renamed from: g, reason: collision with root package name */
    private static final long f17245g = 2000;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17247a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f17248b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f17249c;

    /* renamed from: d, reason: collision with root package name */
    private final Camera f17250d;

    /* renamed from: e, reason: collision with root package name */
    private AsyncTask<?, ?, ?> f17251e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f17244f = a.class.getSimpleName();

    /* renamed from: h, reason: collision with root package name */
    private static final Collection<String> f17246h = new ArrayList(2);

    /* compiled from: AutoFocusManager.java */
    private final class b extends AsyncTask<Object, Object, Object> {
        private b() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) throws InterruptedException {
            try {
                Thread.sleep(a.f17245g);
            } catch (InterruptedException unused) {
            }
            a.this.a();
            return null;
        }
    }

    static {
        f17246h.add(ConnType.PK_AUTO);
        f17246h.add("macro");
    }

    a(Context context, Camera camera) {
        this.f17250d = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        this.f17249c = defaultSharedPreferences.getBoolean(zxing.android.f.f21138g, true) && f17246h.contains(focusMode);
        String str = "Current focus mode '" + focusMode + "'; use auto focus? " + this.f17249c;
        a();
    }

    @SuppressLint({"NewApi"})
    private synchronized void c() {
        if (!this.f17247a && this.f17251e == null) {
            b bVar = new b();
            try {
                bVar.execute(new Object[0]);
                this.f17251e = bVar;
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    private synchronized void d() {
        if (this.f17251e != null) {
            if (this.f17251e.getStatus() != AsyncTask.Status.FINISHED) {
                this.f17251e.cancel(true);
            }
            this.f17251e = null;
        }
    }

    synchronized void a() {
        if (this.f17249c) {
            this.f17251e = null;
            if (!this.f17247a && !this.f17248b) {
                try {
                    this.f17250d.autoFocus(this);
                    this.f17248b = true;
                } catch (RuntimeException unused) {
                    c();
                }
            }
        }
    }

    synchronized void b() {
        this.f17247a = true;
        if (this.f17249c) {
            d();
            try {
                this.f17250d.cancelAutoFocus();
            } catch (RuntimeException unused) {
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f17248b = false;
        c();
    }
}
