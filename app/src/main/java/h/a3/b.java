package h.a3;

import h.q2.t.i0;
import h.q2.t.v;
import h.t0;
import h.y;
import java.util.concurrent.TimeUnit;

/* compiled from: TimeSources.kt */
@j
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH$R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public abstract class b implements p {

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final TimeUnit f16072b;

    /* compiled from: TimeSources.kt */
    private static final class a extends o {

        /* renamed from: a, reason: collision with root package name */
        private final long f16073a;

        /* renamed from: b, reason: collision with root package name */
        private final b f16074b;

        /* renamed from: c, reason: collision with root package name */
        private final double f16075c;

        private a(long j2, b bVar, double d2) {
            this.f16073a = j2;
            this.f16074b = bVar;
            this.f16075c = d2;
        }

        @Override // h.a3.o
        public double a() {
            return d.e(e.a(this.f16074b.c() - this.f16073a, this.f16074b.b()), this.f16075c);
        }

        @Override // h.a3.o
        @i.c.a.d
        public o b(double d2) {
            return new a(this.f16073a, this.f16074b, d.f(this.f16075c, d2), null);
        }

        public /* synthetic */ a(long j2, b bVar, double d2, v vVar) {
            this(j2, bVar, d2);
        }
    }

    public b(@i.c.a.d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        this.f16072b = timeUnit;
    }

    @Override // h.a3.p
    @i.c.a.d
    public o a() {
        return new a(c(), this, d.f16080d.b(), null);
    }

    @i.c.a.d
    protected final TimeUnit b() {
        return this.f16072b;
    }

    protected abstract long c();
}
