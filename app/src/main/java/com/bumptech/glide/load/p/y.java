package com.bumptech.glide.load.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
class y {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4674a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f4675b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler.java */
    private static final class a implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        static final int f4676a = 1;

        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).recycle();
            return true;
        }
    }

    y() {
    }

    synchronized void a(v<?> vVar, boolean z) {
        if (this.f4674a || z) {
            this.f4675b.obtainMessage(1, vVar).sendToTarget();
        } else {
            this.f4674a = true;
            vVar.recycle();
            this.f4674a = false;
        }
    }
}
