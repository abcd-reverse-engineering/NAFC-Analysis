package h.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Iterator;

/* compiled from: Progressions.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class l implements Iterable<Long>, h.q2.t.q1.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f16533d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f16534a;

    /* renamed from: b, reason: collision with root package name */
    private final long f16535b;

    /* renamed from: c, reason: collision with root package name */
    private final long f16536c;

    /* compiled from: Progressions.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.d
        public final l a(long j2, long j3, long j4) {
            return new l(j2, j3, j4);
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    public l(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f16534a = j2;
        this.f16535b = h.m2.m.b(j2, j3, j4);
        this.f16536c = j4;
    }

    public final long b() {
        return this.f16536c;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof l) {
            if (!isEmpty() || !((l) obj).isEmpty()) {
                l lVar = (l) obj;
                if (this.f16534a != lVar.f16534a || this.f16535b != lVar.f16535b || this.f16536c != lVar.f16536c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.f16534a;
    }

    public final long getLast() {
        return this.f16535b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = 31;
        long j3 = this.f16534a;
        long j4 = this.f16535b;
        long j5 = j2 * (((j3 ^ (j3 >>> 32)) * j2) + (j4 ^ (j4 >>> 32)));
        long j6 = this.f16536c;
        return (int) (j5 + (j6 ^ (j6 >>> 32)));
    }

    public boolean isEmpty() {
        long j2 = this.f16536c;
        long j3 = this.f16534a;
        long j4 = this.f16535b;
        if (j2 > 0) {
            if (j3 > j4) {
                return true;
            }
        } else if (j3 < j4) {
            return true;
        }
        return false;
    }

    @i.c.a.d
    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.f16536c > 0) {
            sb = new StringBuilder();
            sb.append(this.f16534a);
            sb.append("..");
            sb.append(this.f16535b);
            sb.append(" step ");
            j2 = this.f16536c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f16534a);
            sb.append(" downTo ");
            sb.append(this.f16535b);
            sb.append(" step ");
            j2 = -this.f16536c;
        }
        sb.append(j2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @i.c.a.d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Long> iterator2() {
        return new m(this.f16534a, this.f16535b, this.f16536c);
    }
}
