package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: HandlerPoster.java */
/* loaded from: classes2.dex */
public class f extends Handler implements l {

    /* renamed from: a, reason: collision with root package name */
    private final k f17402a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17403b;

    /* renamed from: c, reason: collision with root package name */
    private final c f17404c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f17405d;

    protected f(c cVar, Looper looper, int i2) {
        super(looper);
        this.f17404c = cVar;
        this.f17403b = i2;
        this.f17402a = new k();
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            this.f17402a.a(jVarA);
            if (!this.f17405d) {
                this.f17405d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                j jVarA = this.f17402a.a();
                if (jVarA == null) {
                    synchronized (this) {
                        jVarA = this.f17402a.a();
                        if (jVarA == null) {
                            this.f17405d = false;
                            return;
                        }
                    }
                }
                this.f17404c.a(jVarA);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f17403b);
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f17405d = true;
        } finally {
            this.f17405d = false;
        }
    }
}
