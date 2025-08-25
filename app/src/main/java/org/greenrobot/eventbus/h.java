package org.greenrobot.eventbus;

import android.os.Looper;

/* compiled from: MainThreadSupport.java */
/* loaded from: classes2.dex */
public interface h {

    /* compiled from: MainThreadSupport.java */
    public static class a implements h {

        /* renamed from: a, reason: collision with root package name */
        private final Looper f17409a;

        public a(Looper looper) {
            this.f17409a = looper;
        }

        @Override // org.greenrobot.eventbus.h
        public boolean a() {
            return this.f17409a == Looper.myLooper();
        }

        @Override // org.greenrobot.eventbus.h
        public l a(c cVar) {
            return new f(cVar, this.f17409a, 10);
        }
    }

    l a(c cVar);

    boolean a();
}
