package h.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Iterator;

/* compiled from: Progressions.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class a implements Iterable<Character>, h.q2.t.q1.a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0249a f16507d = new C0249a(null);

    /* renamed from: a, reason: collision with root package name */
    private final char f16508a;

    /* renamed from: b, reason: collision with root package name */
    private final char f16509b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16510c;

    /* compiled from: Progressions.kt */
    /* renamed from: h.v2.a$a, reason: collision with other inner class name */
    public static final class C0249a {
        private C0249a() {
        }

        @i.c.a.d
        public final a a(char c2, char c3, int i2) {
            return new a(c2, c3, i2);
        }

        public /* synthetic */ C0249a(h.q2.t.v vVar) {
            this();
        }
    }

    public a(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f16508a = c2;
        this.f16509b = (char) h.m2.m.b((int) c2, (int) c3, i2);
        this.f16510c = i2;
    }

    public final int b() {
        return this.f16510c;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f16508a != aVar.f16508a || this.f16509b != aVar.f16509b || this.f16510c != aVar.f16510c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char getFirst() {
        return this.f16508a;
    }

    public final char getLast() {
        return this.f16509b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f16508a * 31) + this.f16509b) * 31) + this.f16510c;
    }

    public boolean isEmpty() {
        if (this.f16510c > 0) {
            if (this.f16508a > this.f16509b) {
                return true;
            }
        } else if (this.f16508a < this.f16509b) {
            return true;
        }
        return false;
    }

    @i.c.a.d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f16510c > 0) {
            sb = new StringBuilder();
            sb.append(this.f16508a);
            sb.append("..");
            sb.append(this.f16509b);
            sb.append(" step ");
            i2 = this.f16510c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f16508a);
            sb.append(" downTo ");
            sb.append(this.f16509b);
            sb.append(" step ");
            i2 = -this.f16510c;
        }
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @i.c.a.d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Character> iterator2() {
        return new b(this.f16508a, this.f16509b, this.f16510c);
    }
}
