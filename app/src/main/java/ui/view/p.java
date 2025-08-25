package ui.view;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: DownTimer.java */
/* loaded from: classes2.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    private long f20610a;

    /* renamed from: b, reason: collision with root package name */
    private long f20611b;

    /* renamed from: c, reason: collision with root package name */
    private int f20612c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f20613d;

    /* renamed from: e, reason: collision with root package name */
    Handler f20614e;

    /* renamed from: f, reason: collision with root package name */
    Runnable f20615f;

    /* compiled from: DownTimer.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                long j2 = p.this.f20610a - (p.this.f20611b * p.this.f20612c);
                if (j2 <= 0) {
                    p.this.f20612c = 0;
                    p pVar = p.this;
                    pVar.f20614e.removeCallbacks(pVar.f20615f);
                    p.this.d();
                    return;
                }
                p.this.a(j2);
                p.d(p.this);
                p pVar2 = p.this;
                pVar2.f20614e.postDelayed(pVar2.f20615f, pVar2.f20611b);
            }
        }
    }

    public p(long j2, long j3) {
        this.f20613d = false;
        this.f20614e = new a(Looper.getMainLooper());
        this.f20615f = new Runnable() { // from class: ui.view.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f20484a.c();
            }
        };
        this.f20610a = j2;
        this.f20611b = j3;
        this.f20612c = 0;
        this.f20613d = false;
        this.f20614e.post(this.f20615f);
    }

    static /* synthetic */ int d(p pVar) {
        int i2 = pVar.f20612c;
        pVar.f20612c = i2 + 1;
        return i2;
    }

    public abstract void a(long j2);

    public abstract void d();

    public boolean b() {
        return Build.VERSION.SDK_INT >= 29 ? !this.f20614e.hasCallbacks(this.f20615f) : this.f20613d;
    }

    public /* synthetic */ void c() {
        this.f20614e.sendEmptyMessage(1);
    }

    public void a(long j2, long j3) {
        this.f20610a = j2;
        this.f20611b = j3;
        this.f20612c = 0;
        this.f20613d = false;
        this.f20614e.post(this.f20615f);
    }

    public void a() {
        this.f20614e.removeCallbacks(this.f20615f);
        this.f20613d = true;
    }

    public p() {
        this.f20613d = false;
        this.f20614e = new a(Looper.getMainLooper());
        this.f20615f = new Runnable() { // from class: ui.view.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f20484a.c();
            }
        };
    }
}
