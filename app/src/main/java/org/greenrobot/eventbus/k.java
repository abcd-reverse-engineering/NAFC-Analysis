package org.greenrobot.eventbus;

/* compiled from: PendingPostQueue.java */
/* loaded from: classes2.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private j f17416a;

    /* renamed from: b, reason: collision with root package name */
    private j f17417b;

    k() {
    }

    synchronized void a(j jVar) {
        try {
            if (jVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.f17417b != null) {
                this.f17417b.f17415c = jVar;
                this.f17417b = jVar;
            } else {
                if (this.f17416a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f17417b = jVar;
                this.f17416a = jVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized j a() {
        j jVar;
        jVar = this.f17416a;
        if (this.f17416a != null) {
            this.f17416a = this.f17416a.f17415c;
            if (this.f17416a == null) {
                this.f17417b = null;
            }
        }
        return jVar;
    }

    synchronized j a(int i2) throws InterruptedException {
        if (this.f17416a == null) {
            wait(i2);
        }
        return a();
    }
}
