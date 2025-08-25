package h.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Iterator;

/* compiled from: Progressions.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class i implements Iterable<Integer>, h.q2.t.q1.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f16523d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f16524a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16525b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16526c;

    /* compiled from: Progressions.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.d
        public final i a(int i2, int i3, int i4) {
            return new i(i2, i3, i4);
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    public i(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f16524a = i2;
        this.f16525b = h.m2.m.b(i2, i3, i4);
        this.f16526c = i4;
    }

    public final int b() {
        return this.f16526c;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (this.f16524a != iVar.f16524a || this.f16525b != iVar.f16525b || this.f16526c != iVar.f16526c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f16524a;
    }

    public final int getLast() {
        return this.f16525b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f16524a * 31) + this.f16525b) * 31) + this.f16526c;
    }

    public boolean isEmpty() {
        if (this.f16526c > 0) {
            if (this.f16524a > this.f16525b) {
                return true;
            }
        } else if (this.f16524a < this.f16525b) {
            return true;
        }
        return false;
    }

    @i.c.a.d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f16526c > 0) {
            sb = new StringBuilder();
            sb.append(this.f16524a);
            sb.append("..");
            sb.append(this.f16525b);
            sb.append(" step ");
            i2 = this.f16526c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f16524a);
            sb.append(" downTo ");
            sb.append(this.f16525b);
            sb.append(" step ");
            i2 = -this.f16526c;
        }
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @i.c.a.d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Integer> iterator2() {
        return new j(this.f16524a, this.f16525b, this.f16526c);
    }
}
