package c.c.a.d;

import com.hihonor.cloudservice.tasks.q.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Tasks.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static com.hihonor.cloudservice.tasks.q.j f3141a = new com.hihonor.cloudservice.tasks.q.j();

    public static j<List<j<?>>> a(j<?>... jVarArr) {
        return com.hihonor.cloudservice.tasks.q.j.a((Collection<? extends j<?>>) Arrays.asList(jVarArr));
    }

    public static <TResult> j<TResult> b(Callable<TResult> callable) {
        return f3141a.a(l.a(), callable);
    }

    public static <TResult> j<List<TResult>> c(Collection<? extends j<TResult>> collection) {
        return com.hihonor.cloudservice.tasks.q.j.b(collection);
    }

    public static <TResult> TResult a(j<TResult> jVar) throws InterruptedException {
        com.hihonor.cloudservice.tasks.q.j.a("await must not be called on the UI thread");
        if (jVar.d()) {
            return (TResult) com.hihonor.cloudservice.tasks.q.j.a((j) jVar);
        }
        j.d dVar = new j.d();
        jVar.a((h) dVar).a((g) dVar);
        dVar.f6096a.await();
        return (TResult) com.hihonor.cloudservice.tasks.q.j.a((j) jVar);
    }

    public static j<Void> b(j<?>... jVarArr) {
        return com.hihonor.cloudservice.tasks.q.j.c(Arrays.asList(jVarArr));
    }

    public static <TResult> j<List<TResult>> c(j<?>... jVarArr) {
        return com.hihonor.cloudservice.tasks.q.j.b(Arrays.asList(jVarArr));
    }

    public static j<Void> b(Collection<? extends j<?>> collection) {
        return com.hihonor.cloudservice.tasks.q.j.c(collection);
    }

    public static <TResult> j<TResult> a(Callable<TResult> callable) {
        return f3141a.a(l.b(), callable);
    }

    public static <TResult> j<TResult> a() {
        com.hihonor.cloudservice.tasks.q.i iVar = new com.hihonor.cloudservice.tasks.q.i();
        iVar.f();
        return iVar;
    }

    public static <TResult> j<TResult> a(Exception exc) {
        k kVar = new k();
        kVar.a(exc);
        return kVar.a();
    }

    public static <TResult> j<TResult> a(TResult tresult) {
        return com.hihonor.cloudservice.tasks.q.j.a(tresult);
    }

    public static j<List<j<?>>> a(Collection<? extends j<?>> collection) {
        return com.hihonor.cloudservice.tasks.q.j.a(collection);
    }

    public static <TResult> j<TResult> a(Executor executor, Callable<TResult> callable) {
        return f3141a.a(executor, callable);
    }

    public static <TResult> TResult a(j<TResult> jVar, long j2, TimeUnit timeUnit) throws TimeoutException {
        com.hihonor.cloudservice.tasks.q.j.a("await must not be called on the UI thread");
        if (!jVar.d()) {
            j.d dVar = new j.d();
            jVar.a((h) dVar).a((g) dVar);
            if (!dVar.f6096a.await(j2, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return (TResult) com.hihonor.cloudservice.tasks.q.j.a((j) jVar);
    }
}
