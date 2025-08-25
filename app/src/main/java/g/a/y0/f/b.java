package g.a.y0.f;

import g.a.t0.g;
import g.a.y0.c.n;
import g.a.y0.j.t;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscArrayQueue.java */
/* loaded from: classes2.dex */
public final class b<E> extends AtomicReferenceArray<E> implements n<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final Integer f15885a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public b(int i2) {
        super(t.b(i2));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i2 / 4, f15885a.intValue());
    }

    int calcElementOffset(long j2) {
        return this.mask & ((int) j2);
    }

    int calcElementOffset(long j2, int i2) {
        return ((int) j2) & i2;
    }

    @Override // g.a.y0.c.o
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // g.a.y0.c.o
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    E lvElement(int i2) {
        return get(i2);
    }

    @Override // g.a.y0.c.o
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i2 = this.mask;
        long j2 = this.producerIndex.get();
        int iCalcElementOffset = calcElementOffset(j2, i2);
        if (j2 >= this.producerLookAhead) {
            long j3 = this.lookAheadStep + j2;
            if (lvElement(calcElementOffset(j3, i2)) == null) {
                this.producerLookAhead = j3;
            } else if (lvElement(iCalcElementOffset) != null) {
                return false;
            }
        }
        soElement(iCalcElementOffset, e2);
        soProducerIndex(j2 + 1);
        return true;
    }

    @Override // g.a.y0.c.n, g.a.y0.c.o
    @g
    public E poll() {
        long j2 = this.consumerIndex.get();
        int iCalcElementOffset = calcElementOffset(j2);
        E eLvElement = lvElement(iCalcElementOffset);
        if (eLvElement == null) {
            return null;
        }
        soConsumerIndex(j2 + 1);
        soElement(iCalcElementOffset, null);
        return eLvElement;
    }

    void soConsumerIndex(long j2) {
        this.consumerIndex.lazySet(j2);
    }

    void soElement(int i2, E e2) {
        lazySet(i2, e2);
    }

    void soProducerIndex(long j2) {
        this.producerIndex.lazySet(j2);
    }

    @Override // g.a.y0.c.o
    public boolean offer(E e2, E e3) {
        return offer(e2) && offer(e3);
    }
}
