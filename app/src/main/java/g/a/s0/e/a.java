package g.a.s0.e;

import android.os.Handler;
import android.os.Looper;
import g.a.j0;
import java.util.concurrent.Callable;

/* compiled from: AndroidSchedulers.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final j0 f13859a = g.a.s0.d.a.b(new CallableC0177a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: g.a.s0.e.a$a, reason: collision with other inner class name */
    static class CallableC0177a implements Callable<j0> {
        CallableC0177a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return b.f13860a;
        }
    }

    /* compiled from: AndroidSchedulers.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final j0 f13860a = new g.a.s0.e.b(new Handler(Looper.getMainLooper()));

        private b() {
        }
    }

    private a() {
        throw new AssertionError("No instances.");
    }

    public static j0 a() {
        return g.a.s0.d.a.a(f13859a);
    }

    public static j0 a(Looper looper) {
        if (looper != null) {
            return new g.a.s0.e.b(new Handler(looper));
        }
        throw new NullPointerException("looper == null");
    }
}
