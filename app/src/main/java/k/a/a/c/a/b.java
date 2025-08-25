package k.a.a.c.a;

import android.content.Context;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k.a.a.a.j.e;

/* compiled from: AIDLTask.java */
/* loaded from: classes2.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected final CountDownLatch f17078a = new CountDownLatch(1);

    /* renamed from: b, reason: collision with root package name */
    protected final AtomicBoolean f17079b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    protected Context f17080c;

    protected b(Context context) {
        this.f17080c = context;
    }

    private void c() {
        if (this.f17079b.get()) {
            return;
        }
        this.f17079b.set(true);
        a(null);
        b();
    }

    protected abstract void a();

    public abstract void a(ErrorStatus errorStatus);

    protected void b() {
        e.b("AIDLTask", "finishTask", true);
        a aVarA = a.a(this.f17080c);
        if (aVarA != null) {
            aVarA.b();
        }
        this.f17078a.countDown();
        this.f17079b.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        try {
            if (this.f17078a.await(12000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            c();
        } catch (InterruptedException unused) {
            e.b("AIDLTask", "execute await InterruptedException", true);
            c();
        }
    }
}
