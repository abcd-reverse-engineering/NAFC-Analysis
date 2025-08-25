package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Worker.java */
/* loaded from: classes2.dex */
public abstract class ab {

    /* renamed from: a, reason: collision with root package name */
    protected Context f11925a;

    /* renamed from: b, reason: collision with root package name */
    protected Handler f11926b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f11927c = new Object();

    /* compiled from: Worker.java */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ab.this.b(message);
        }
    }

    public ab() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f11926b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f11925a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f11927c) {
            if (this.f11926b == null) {
                String str = "Dead worker dropping a message: " + message.what;
                com.vivo.push.util.u.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                this.f11926b.sendMessage(message);
            }
        }
    }
}
