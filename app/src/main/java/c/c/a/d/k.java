package c.c.a.d;

/* compiled from: TaskCompletionSource.java */
/* loaded from: classes.dex */
public class k<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final com.hihonor.cloudservice.tasks.q.i<TResult> f3135a = new com.hihonor.cloudservice.tasks.q.i<>();

    /* compiled from: TaskCompletionSource.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.f3135a.f();
        }
    }

    public k() {
    }

    public j<TResult> a() {
        return this.f3135a;
    }

    public k(c.c.a.d.a aVar) {
        aVar.a(new a());
    }

    public void a(Exception exc) {
        this.f3135a.a(exc);
    }

    public void a(TResult tresult) {
        this.f3135a.a((com.hihonor.cloudservice.tasks.q.i<TResult>) tresult);
    }
}
