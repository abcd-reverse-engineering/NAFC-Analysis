package h.n2;

import h.q2.t.i0;
import h.y;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ReadWrite.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class s implements h.x2.m<String> {

    /* renamed from: a, reason: collision with root package name */
    private final BufferedReader f16353a;

    /* compiled from: ReadWrite.kt */
    public static final class a implements Iterator<String>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        private String f16354a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f16355b;

        a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f16354a == null && !this.f16355b) {
                this.f16354a = s.this.f16353a.readLine();
                if (this.f16354a == null) {
                    this.f16355b = true;
                }
            }
            return this.f16354a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        @i.c.a.d
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f16354a;
            this.f16354a = null;
            if (str == null) {
                i0.f();
            }
            return str;
        }
    }

    public s(@i.c.a.d BufferedReader bufferedReader) {
        i0.f(bufferedReader, "reader");
        this.f16353a = bufferedReader;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<String> iterator() {
        return new a();
    }
}
