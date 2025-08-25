package g.a.y0.j;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingIgnoringReceiver.java */
/* loaded from: classes2.dex */
public final class f extends CountDownLatch implements g.a.x0.g<Throwable>, g.a.x0.a {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f16042a;

    public f() {
        super(1);
    }

    @Override // g.a.x0.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        this.f16042a = th;
        countDown();
    }

    @Override // g.a.x0.a
    public void run() {
        countDown();
    }
}
