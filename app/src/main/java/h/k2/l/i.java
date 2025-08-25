package h.k2.l;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.umeng.analytics.pro.bh;
import h.n0;
import h.q2.t.i0;
import h.q2.t.v;
import h.y;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: SafeContinuationJvm.kt */
@n0
@y(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0001\u0018\u0000 \u0015*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u0015\u0016B\u0015\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004B\u001f\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0001J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlin/coroutines/experimental/SafeContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/experimental/Continuation;", "delegate", "(Lkotlin/coroutines/experimental/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/experimental/Continuation;Ljava/lang/Object;)V", com.umeng.analytics.pro.d.R, "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "result", "getResult", "resume", "", SurveyH5Bean.VALUE, "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "Companion", "Fail", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class i<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    private volatile Object f16262a;

    /* renamed from: b, reason: collision with root package name */
    private final c<T> f16263b;

    /* renamed from: f, reason: collision with root package name */
    public static final a f16261f = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f16258c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f16259d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<i<?>, Object> f16260e = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, bh.ay);

    /* compiled from: SafeContinuationJvm.kt */
    public static final class a {
        private a() {
        }

        @h.q2.h
        private static /* synthetic */ void a() {
        }

        public /* synthetic */ a(v vVar) {
            this();
        }
    }

    /* compiled from: SafeContinuationJvm.kt */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Throwable f16264a;

        public b(@i.c.a.d Throwable th) {
            i0.f(th, "exception");
            this.f16264a = th;
        }

        @i.c.a.d
        public final Throwable a() {
            return this.f16264a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@i.c.a.d c<? super T> cVar, @i.c.a.e Object obj) {
        i0.f(cVar, "delegate");
        this.f16263b = cVar;
        this.f16262a = obj;
    }

    @n0
    @i.c.a.e
    public final Object a() throws Throwable {
        Object obj = this.f16262a;
        Object obj2 = f16258c;
        if (obj == obj2) {
            if (f16260e.compareAndSet(this, obj2, h.k2.l.n.b.b())) {
                return h.k2.l.n.b.b();
            }
            obj = this.f16262a;
        }
        if (obj == f16259d) {
            return h.k2.l.n.b.b();
        }
        if (obj instanceof b) {
            throw ((b) obj).a();
        }
        return obj;
    }

    @Override // h.k2.l.c
    @i.c.a.d
    public e getContext() {
        return this.f16263b.getContext();
    }

    @Override // h.k2.l.c
    public void resume(T t) {
        while (true) {
            Object obj = this.f16262a;
            Object obj2 = f16258c;
            if (obj == obj2) {
                if (f16260e.compareAndSet(this, obj2, t)) {
                    return;
                }
            } else {
                if (obj != h.k2.l.n.b.b()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (f16260e.compareAndSet(this, h.k2.l.n.b.b(), f16259d)) {
                    this.f16263b.resume(t);
                    return;
                }
            }
        }
    }

    @Override // h.k2.l.c
    public void resumeWithException(@i.c.a.d Throwable th) {
        i0.f(th, "exception");
        while (true) {
            Object obj = this.f16262a;
            Object obj2 = f16258c;
            if (obj == obj2) {
                if (f16260e.compareAndSet(this, obj2, new b(th))) {
                    return;
                }
            } else {
                if (obj != h.k2.l.n.b.b()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (f16260e.compareAndSet(this, h.k2.l.n.b.b(), f16259d)) {
                    this.f16263b.resumeWithException(th);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @n0
    public i(@i.c.a.d c<? super T> cVar) {
        this(cVar, f16258c);
        i0.f(cVar, "delegate");
    }
}
