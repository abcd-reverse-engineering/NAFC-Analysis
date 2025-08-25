package g.a.y0.j;

import g.a.i0;
import java.io.Serializable;

/* compiled from: NotificationLite.java */
/* loaded from: classes2.dex */
public enum q {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: d, reason: collision with root package name */
        final g.a.u0.c f16056d;

        a(g.a.u0.c cVar) {
            this.f16056d = cVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f16056d + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e, reason: collision with root package name */
        final Throwable f16057e;

        b(Throwable th) {
            this.f16057e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return g.a.y0.b.b.a(this.f16057e, ((b) obj).f16057e);
            }
            return false;
        }

        public int hashCode() {
            return this.f16057e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f16057e + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final i.d.d s;

        c(i.d.d dVar) {
            this.s = dVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.s + "]";
        }
    }

    public static <T> boolean accept(Object obj, i.d.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            cVar.onError(((b) obj).f16057e);
            return true;
        }
        cVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, i.d.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            cVar.onError(((b) obj).f16057e);
            return true;
        }
        if (obj instanceof c) {
            cVar.onSubscribe(((c) obj).s);
            return false;
        }
        cVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(g.a.u0.c cVar) {
        return new a(cVar);
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static g.a.u0.c getDisposable(Object obj) {
        return ((a) obj).f16056d;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f16057e;
    }

    public static i.d.d getSubscription(Object obj) {
        return ((c) obj).s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(i.d.d dVar) {
        return new c(dVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, i0<? super T> i0Var) {
        if (obj == COMPLETE) {
            i0Var.onComplete();
            return true;
        }
        if (obj instanceof b) {
            i0Var.onError(((b) obj).f16057e);
            return true;
        }
        i0Var.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, i0<? super T> i0Var) {
        if (obj == COMPLETE) {
            i0Var.onComplete();
            return true;
        }
        if (obj instanceof b) {
            i0Var.onError(((b) obj).f16057e);
            return true;
        }
        if (obj instanceof a) {
            i0Var.onSubscribe(((a) obj).f16056d);
            return false;
        }
        i0Var.onNext(obj);
        return false;
    }
}
