package g.a.a1;

import g.a.a0;
import g.a.a1.a;
import g.a.x0.r;
import g.a.y0.j.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: BaseTestConsumer.java */
/* loaded from: classes2.dex */
public abstract class a<T, U extends a<T, U>> implements g.a.u0.c {

    /* renamed from: d, reason: collision with root package name */
    protected long f13618d;

    /* renamed from: e, reason: collision with root package name */
    protected Thread f13619e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f13620f;

    /* renamed from: g, reason: collision with root package name */
    protected int f13621g;

    /* renamed from: h, reason: collision with root package name */
    protected int f13622h;

    /* renamed from: i, reason: collision with root package name */
    protected CharSequence f13623i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f13624j;

    /* renamed from: b, reason: collision with root package name */
    protected final List<T> f13616b = new y();

    /* renamed from: c, reason: collision with root package name */
    protected final List<Throwable> f13617c = new y();

    /* renamed from: a, reason: collision with root package name */
    protected final CountDownLatch f13615a = new CountDownLatch(1);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BaseTestConsumer.java */
    public static abstract class b implements Runnable {
        public static final b SPIN = new C0168a("SPIN", 0);
        public static final b YIELD = new C0169b("YIELD", 1);
        public static final b SLEEP_1MS = new c("SLEEP_1MS", 2);
        public static final b SLEEP_10MS = new d("SLEEP_10MS", 3);
        public static final b SLEEP_100MS = new e("SLEEP_100MS", 4);
        public static final b SLEEP_1000MS = new f("SLEEP_1000MS", 5);

        /* renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ b[] f13625a = {SPIN, YIELD, SLEEP_1MS, SLEEP_10MS, SLEEP_100MS, SLEEP_1000MS};

        /* compiled from: BaseTestConsumer.java */
        /* renamed from: g.a.a1.a$b$a, reason: collision with other inner class name */
        enum C0168a extends b {
            C0168a(String str, int i2) {
                super(str, i2);
            }

            @Override // g.a.a1.a.b, java.lang.Runnable
            public void run() {
            }
        }

        /* compiled from: BaseTestConsumer.java */
        /* renamed from: g.a.a1.a$b$b, reason: collision with other inner class name */
        enum C0169b extends b {
            C0169b(String str, int i2) {
                super(str, i2);
            }

            @Override // g.a.a1.a.b, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        }

        /* compiled from: BaseTestConsumer.java */
        enum c extends b {
            c(String str, int i2) {
                super(str, i2);
            }

            @Override // g.a.a1.a.b, java.lang.Runnable
            public void run() throws InterruptedException {
                b.sleep(1);
            }
        }

        /* compiled from: BaseTestConsumer.java */
        enum d extends b {
            d(String str, int i2) {
                super(str, i2);
            }

            @Override // g.a.a1.a.b, java.lang.Runnable
            public void run() throws InterruptedException {
                b.sleep(10);
            }
        }

        /* compiled from: BaseTestConsumer.java */
        enum e extends b {
            e(String str, int i2) {
                super(str, i2);
            }

            @Override // g.a.a1.a.b, java.lang.Runnable
            public void run() throws InterruptedException {
                b.sleep(100);
            }
        }

        /* compiled from: BaseTestConsumer.java */
        enum f extends b {
            f(String str, int i2) {
                super(str, i2);
            }

            @Override // g.a.a1.a.b, java.lang.Runnable
            public void run() throws InterruptedException {
                b.sleep(1000);
            }
        }

        private b(String str, int i2) {
        }

        static void sleep(int i2) throws InterruptedException {
            try {
                Thread.sleep(i2);
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f13625a.clone();
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public final boolean a(long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean z = this.f13615a.getCount() == 0 || this.f13615a.await(j2, timeUnit);
        this.f13624j = !z;
        return z;
    }

    protected final AssertionError b(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.f13615a.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.f13616b.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.f13617c.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.f13618d);
        if (this.f13624j) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.f13623i;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.f13617c.isEmpty()) {
            if (this.f13617c.size() == 1) {
                assertionError.initCause(this.f13617c.get(0));
            } else {
                assertionError.initCause(new g.a.v0.a(this.f13617c));
            }
        }
        return assertionError;
    }

    public final U c() {
        if (this.f13617c.size() == 0) {
            return this;
        }
        throw b("Error(s) present: " + this.f13617c);
    }

    public final U d() {
        if (this.f13624j) {
            throw b("Timeout?!");
        }
        return this;
    }

    public final U e() {
        return (U) a(0);
    }

    public final U f() {
        long j2 = this.f13618d;
        if (j2 == 1) {
            throw b("Completed!");
        }
        if (j2 <= 1) {
            return this;
        }
        throw b("Multiple completions: " + j2);
    }

    public abstract U g();

    public final U h() {
        if (this.f13615a.getCount() != 0) {
            return this;
        }
        throw b("Subscriber terminated!");
    }

    public abstract U i();

    public final U j() {
        if (this.f13615a.getCount() != 0) {
            throw b("Subscriber still running!");
        }
        long j2 = this.f13618d;
        if (j2 > 1) {
            throw b("Terminated with multiple completions: " + j2);
        }
        int size = this.f13617c.size();
        if (size > 1) {
            throw b("Terminated with multiple errors: " + size);
        }
        if (j2 == 0 || size == 0) {
            return this;
        }
        throw b("Terminated with multiple completions and errors: " + j2);
    }

    public final U k() {
        if (this.f13624j) {
            return this;
        }
        throw b("No timeout?!");
    }

    public final U l() throws InterruptedException {
        if (this.f13615a.getCount() == 0) {
            return this;
        }
        this.f13615a.await();
        return this;
    }

    public final boolean m() {
        try {
            l();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U n() {
        this.f13624j = false;
        return this;
    }

    public final long o() {
        return this.f13618d;
    }

    public final int p() {
        return this.f13617c.size();
    }

    public final List<Throwable> q() {
        return this.f13617c;
    }

    public final List<List<Object>> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(w());
        arrayList.add(q());
        ArrayList arrayList2 = new ArrayList();
        for (long j2 = 0; j2 < this.f13618d; j2++) {
            arrayList2.add(a0.f());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean s() {
        return this.f13615a.getCount() == 0;
    }

    public final boolean t() {
        return this.f13624j;
    }

    public final Thread u() {
        return this.f13619e;
    }

    public final int v() {
        return this.f13616b.size();
    }

    public final List<T> w() {
        return this.f13616b;
    }

    public final U a() {
        long j2 = this.f13618d;
        if (j2 == 0) {
            throw b("Not completed");
        }
        if (j2 <= 1) {
            return this;
        }
        throw b("Multiple completions: " + j2);
    }

    public final U c(r<T> rVar) {
        a(0, (r) rVar);
        if (this.f13616b.size() <= 1) {
            return this;
        }
        throw b("Value present but other values as well");
    }

    public static String c(Object obj) {
        if (obj == null) {
            return c.c.a.b.a.a.f3101h;
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    public final U a(Throwable th) {
        return (U) a(g.a.y0.b.a.a(th));
    }

    public final U a(Class<? extends Throwable> cls) {
        return (U) a(g.a.y0.b.a.b((Class) cls));
    }

    @g.a.t0.e
    public final U c(T... tArr) {
        return (U) i().b((Object[]) tArr).c().f();
    }

    public final U a(r<Throwable> rVar) {
        int size = this.f13617c.size();
        if (size != 0) {
            boolean z = false;
            Iterator<Throwable> it = this.f13617c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    if (rVar.test(it.next())) {
                        z = true;
                        break;
                    }
                } catch (Exception e2) {
                    throw g.a.y0.j.k.c(e2);
                }
            }
            if (!z) {
                throw b("Error not present");
            }
            if (size == 1) {
                return this;
            }
            throw b("Error present but other errors as well");
        }
        throw b("No errors");
    }

    public final boolean c(long j2, TimeUnit timeUnit) {
        try {
            return a(j2, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U a(T t) {
        int size = this.f13616b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (g.a.y0.b.b.a(this.f13616b.get(i2), t)) {
                throw b("Value at position " + i2 + " is equal to " + c(t) + "; Expected them to be different");
            }
        }
        return this;
    }

    @g.a.t0.e
    public final U a(int i2, T t) {
        int size = this.f13616b.size();
        if (size == 0) {
            throw b("No values");
        }
        if (i2 < size) {
            T t2 = this.f13616b.get(i2);
            if (g.a.y0.b.b.a(t, t2)) {
                return this;
            }
            throw b("Expected: " + c(t) + ", Actual: " + c(t2));
        }
        throw b("Invalid index: " + i2);
    }

    public final U b(T t) {
        if (this.f13616b.size() == 1) {
            T t2 = this.f13616b.get(0);
            if (g.a.y0.b.b.a(t, t2)) {
                return this;
            }
            throw b("Expected: " + c(t) + ", Actual: " + c(t2));
        }
        throw b("Expected: " + c(t) + ", Actual: " + this.f13616b);
    }

    public final U a(int i2, r<T> rVar) {
        if (this.f13616b.size() != 0) {
            if (i2 < this.f13616b.size()) {
                try {
                    if (rVar.test(this.f13616b.get(i2))) {
                        return this;
                    }
                    throw b("Value not present");
                } catch (Exception e2) {
                    throw g.a.y0.j.k.c(e2);
                }
            }
            throw b("Invalid index: " + i2);
        }
        throw b("No values");
    }

    public final U b(r<? super T> rVar) {
        int size = this.f13616b.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                if (rVar.test(this.f13616b.get(i2))) {
                    throw b("Value at position " + i2 + " matches predicate " + rVar.toString() + ", which was not expected.");
                }
            } catch (Exception e2) {
                throw g.a.y0.j.k.c(e2);
            }
        }
        return this;
    }

    public final U a(int i2) {
        int size = this.f13616b.size();
        if (size == i2) {
            return this;
        }
        throw b("Value counts differ; Expected: " + i2 + ", Actual: " + size);
    }

    public final U b(T... tArr) {
        int size = this.f13616b.size();
        if (size != tArr.length) {
            throw b("Value count differs; Expected: " + tArr.length + c.c.a.b.a.a.f3100g + Arrays.toString(tArr) + ", Actual: " + size + c.c.a.b.a.a.f3100g + this.f13616b);
        }
        for (int i2 = 0; i2 < size; i2++) {
            T t = this.f13616b.get(i2);
            T t2 = tArr[i2];
            if (!g.a.y0.b.b.a(t2, t)) {
                throw b("Values at position " + i2 + " differ; Expected: " + c(t2) + ", Actual: " + c(t));
            }
        }
        return this;
    }

    public final U a(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            e();
            return this;
        }
        for (T t : this.f13616b) {
            if (!collection.contains(t)) {
                throw b("Value not in the expected collection: " + c(t));
            }
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
    
        if (r3 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        if (r2 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
    
        throw b("Fewer values received than expected (" + r1 + ")");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008f, code lost:
    
        throw b("More values received than expected (" + r1 + ")");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final U a(java.lang.Iterable<? extends T> r6) {
        /*
            r5 = this;
            java.util.List<T> r0 = r5.f13616b
            java.util.Iterator r0 = r0.iterator()
            java.util.Iterator r6 = r6.iterator()
            r1 = 0
        Lb:
            boolean r2 = r6.hasNext()
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L57
            if (r2 != 0) goto L18
            goto L57
        L18:
            java.lang.Object r2 = r6.next()
            java.lang.Object r3 = r0.next()
            boolean r4 = g.a.y0.b.b.a(r2, r3)
            if (r4 == 0) goto L29
            int r1 = r1 + 1
            goto Lb
        L29:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Values at position "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = " differ; Expected: "
            r6.append(r0)
            java.lang.String r0 = c(r2)
            r6.append(r0)
            java.lang.String r0 = ", Actual: "
            r6.append(r0)
            java.lang.String r0 = c(r3)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.AssertionError r6 = r5.b(r6)
            throw r6
        L57:
            java.lang.String r6 = ")"
            if (r3 != 0) goto L77
            if (r2 != 0) goto L5e
            return r5
        L5e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Fewer values received than expected ("
            r0.append(r2)
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.AssertionError r6 = r5.b(r6)
            throw r6
        L77:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "More values received than expected ("
            r0.append(r2)
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.AssertionError r6 = r5.b(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a1.a.a(java.lang.Iterable):g.a.a1.a");
    }

    public final U b(long j2, TimeUnit timeUnit) {
        try {
            if (!this.f13615a.await(j2, timeUnit)) {
                this.f13624j = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e2) {
            dispose();
            throw g.a.y0.j.k.c(e2);
        }
    }

    public final U b() {
        return (U) i().e().c().f();
    }

    public final U b(int i2) {
        return (U) a(i2, b.SLEEP_10MS, com.heytap.mcssdk.constant.a.r);
    }

    public final U a(String str) {
        int size = this.f13617c.size();
        if (size == 0) {
            throw b("No errors");
        }
        if (size == 1) {
            String message = this.f13617c.get(0).getMessage();
            if (g.a.y0.b.b.a((Object) str, (Object) message)) {
                return this;
            }
            throw b("Error message differs; Expected: " + str + ", Actual: " + message);
        }
        throw b("Multiple errors");
    }

    public final U a(T... tArr) {
        return (U) i().b((Object[]) tArr).c().a();
    }

    public final U a(Class<? extends Throwable> cls, T... tArr) {
        return (U) i().b((Object[]) tArr).a(cls).f();
    }

    public final U a(r<Throwable> rVar, T... tArr) {
        return (U) i().b((Object[]) tArr).a(rVar).f();
    }

    public final U a(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) i().b((Object[]) tArr).a(cls).a(str).f();
    }

    public final U a(CharSequence charSequence) {
        this.f13623i = charSequence;
        return this;
    }

    public final U a(int i2, Runnable runnable) {
        return (U) a(i2, runnable, com.heytap.mcssdk.constant.a.r);
    }

    public final U a(int i2, Runnable runnable, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j2 > 0 && System.currentTimeMillis() - jCurrentTimeMillis >= j2) {
                this.f13624j = true;
                break;
            }
            if (this.f13615a.getCount() == 0 || this.f13616b.size() >= i2) {
                break;
            }
            runnable.run();
        }
        return this;
    }
}
