package h.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import h.b2;
import h.j1;
import h.t0;
import java.util.Iterator;

/* compiled from: UIntRange.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()I", "I", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/UIntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@h.k
/* loaded from: classes2.dex */
public class r implements Iterable<j1>, h.q2.t.q1.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f16543d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f16544a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16545b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16546c;

    /* compiled from: UIntRange.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.d
        public final r a(int i2, int i3, int i4) {
            return new r(i2, i3, i4, null);
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    public /* synthetic */ r(int i2, int i3, int i4, h.q2.t.v vVar) {
        this(i2, i3, i4);
    }

    public final int b() {
        return this.f16546c;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof r) {
            if (!isEmpty() || !((r) obj).isEmpty()) {
                r rVar = (r) obj;
                if (this.f16544a != rVar.f16544a || this.f16545b != rVar.f16545b || this.f16546c != rVar.f16546c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f16544a;
    }

    public final int getLast() {
        return this.f16545b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f16544a * 31) + this.f16545b) * 31) + this.f16546c;
    }

    public boolean isEmpty() {
        if (this.f16546c > 0) {
            if (b2.a(this.f16544a, this.f16545b) > 0) {
                return true;
            }
        } else if (b2.a(this.f16544a, this.f16545b) < 0) {
            return true;
        }
        return false;
    }

    @i.c.a.d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f16546c > 0) {
            sb = new StringBuilder();
            sb.append(j1.n(this.f16544a));
            sb.append("..");
            sb.append(j1.n(this.f16545b));
            sb.append(" step ");
            i2 = this.f16546c;
        } else {
            sb = new StringBuilder();
            sb.append(j1.n(this.f16544a));
            sb.append(" downTo ");
            sb.append(j1.n(this.f16545b));
            sb.append(" step ");
            i2 = -this.f16546c;
        }
        sb.append(i2);
        return sb.toString();
    }

    private r(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f16544a = i2;
        this.f16545b = h.m2.q.b(i2, i3, i4);
        this.f16546c = i4;
    }

    @Override // java.lang.Iterable
    @i.c.a.d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<j1> iterator2() {
        return new s(this.f16544a, this.f16545b, this.f16546c, null);
    }
}
