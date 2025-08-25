package org.greenrobot.eventbus;

import java.util.logging.Level;

/* compiled from: BackgroundPoster.java */
/* loaded from: classes2.dex */
final class b implements Runnable, l {

    /* renamed from: a, reason: collision with root package name */
    private final k f17365a = new k();

    /* renamed from: b, reason: collision with root package name */
    private final c f17366b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f17367c;

    b(c cVar) {
        this.f17366b = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            this.f17365a.a(jVarA);
            if (!this.f17367c) {
                this.f17367c = true;
                this.f17366b.a().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                j jVarA = this.f17365a.a(1000);
                if (jVarA == null) {
                    synchronized (this) {
                        jVarA = this.f17365a.a();
                        if (jVarA == null) {
                            return;
                        }
                    }
                }
                this.f17366b.a(jVarA);
            } catch (InterruptedException e2) {
                this.f17366b.b().a(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f17367c = false;
            }
        }
    }
}
