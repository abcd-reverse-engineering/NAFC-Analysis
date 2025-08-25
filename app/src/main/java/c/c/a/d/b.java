package c.c.a.d;

import java.util.Iterator;

/* compiled from: CancellationTokenSource.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.hihonor.cloudservice.tasks.q.a f3134a = new com.hihonor.cloudservice.tasks.q.a();

    public void a() {
        com.hihonor.cloudservice.tasks.q.a aVar = this.f3134a;
        if (aVar.f6045c) {
            return;
        }
        synchronized (aVar.f6044b) {
            aVar.f6045c = true;
            Iterator<Runnable> it = aVar.f6043a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public a b() {
        return this.f3134a;
    }
}
