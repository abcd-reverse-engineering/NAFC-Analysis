package l.q.a;

import javax.annotation.Nullable;
import l.m;

/* compiled from: Result.java */
/* loaded from: classes2.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final m<T> f17222a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Throwable f17223b;

    private e(@Nullable m<T> mVar, @Nullable Throwable th) {
        this.f17222a = mVar;
        this.f17223b = th;
    }

    public static <T> e<T> a(Throwable th) {
        if (th != null) {
            return new e<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public boolean b() {
        return this.f17223b != null;
    }

    @Nullable
    public m<T> c() {
        return this.f17222a;
    }

    public static <T> e<T> a(m<T> mVar) {
        if (mVar != null) {
            return new e<>(mVar, null);
        }
        throw new NullPointerException("response == null");
    }

    @Nullable
    public Throwable a() {
        return this.f17223b;
    }
}
