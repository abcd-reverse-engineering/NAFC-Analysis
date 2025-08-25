package h;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LazyJVM.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkotlin/SafePublicationLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", SurveyH5Bean.VALUE, "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class s0<T> implements s<T>, Serializable {
    public static final a Companion = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<s0<?>, Object> f16477a = AtomicReferenceFieldUpdater.newUpdater(s0.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final, reason: not valid java name */
    private final Object f1109final;
    private volatile h.q2.s.a<? extends T> initializer;

    /* compiled from: LazyJVM.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    public s0(@i.c.a.d h.q2.s.a<? extends T> aVar) {
        h.q2.t.i0.f(aVar, "initializer");
        this.initializer = aVar;
        r1 r1Var = r1.f16467a;
        this._value = r1Var;
        this.f1109final = r1Var;
    }

    private final Object writeReplace() {
        return new o(getValue());
    }

    @Override // h.s
    public T getValue() {
        T t = (T) this._value;
        if (t != r1.f16467a) {
            return t;
        }
        h.q2.s.a<? extends T> aVar = this.initializer;
        if (aVar != null) {
            T tInvoke = aVar.invoke();
            if (f16477a.compareAndSet(this, r1.f16467a, tInvoke)) {
                this.initializer = null;
                return tInvoke;
            }
        }
        return (T) this._value;
    }

    @Override // h.s
    public boolean isInitialized() {
        return this._value != r1.f16467a;
    }

    @i.c.a.d
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
