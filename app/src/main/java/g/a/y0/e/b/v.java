package g.a.y0.e.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableConcatArray.java */
/* loaded from: classes2.dex */
public final class v<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<? extends T>[] f14655b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f14656c;

    /* compiled from: FlowableConcatArray.java */
    static final class a<T> extends g.a.y0.i.i implements g.a.q<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final i.d.c<? super T> actual;
        final boolean delayError;
        List<Throwable> errors;
        int index;
        long produced;
        final i.d.b<? extends T>[] sources;
        final AtomicInteger wip = new AtomicInteger();

        a(i.d.b<? extends T>[] bVarArr, boolean z, i.d.c<? super T> cVar) {
            this.actual = cVar;
            this.sources = bVarArr;
            this.delayError = z;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                i.d.b<? extends T>[] bVarArr = this.sources;
                int length = bVarArr.length;
                int i2 = this.index;
                while (i2 != length) {
                    i.d.b<? extends T> bVar = bVarArr[i2];
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (!this.delayError) {
                            this.actual.onError(nullPointerException);
                            return;
                        }
                        List arrayList = this.errors;
                        if (arrayList == null) {
                            arrayList = new ArrayList((length - i2) + 1);
                            this.errors = arrayList;
                        }
                        arrayList.add(nullPointerException);
                        i2++;
                    } else {
                        long j2 = this.produced;
                        if (j2 != 0) {
                            this.produced = 0L;
                            produced(j2);
                        }
                        bVar.subscribe(this);
                        i2++;
                        this.index = i2;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list = this.errors;
                if (list == null) {
                    this.actual.onComplete();
                } else if (list.size() == 1) {
                    this.actual.onError(list.get(0));
                } else {
                    this.actual.onError(new g.a.v0.a(list));
                }
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (!this.delayError) {
                this.actual.onError(th);
                return;
            }
            List arrayList = this.errors;
            if (arrayList == null) {
                arrayList = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = arrayList;
            }
            arrayList.add(th);
            onComplete();
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            setSubscription(dVar);
        }
    }

    public v(i.d.b<? extends T>[] bVarArr, boolean z) {
        this.f14655b = bVarArr;
        this.f14656c = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        a aVar = new a(this.f14655b, this.f14656c, cVar);
        cVar.onSubscribe(aVar);
        aVar.onComplete();
    }
}
