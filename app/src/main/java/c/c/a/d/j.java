package c.c.a.d;

import android.app.Activity;
import java.util.concurrent.Executor;

/* compiled from: Task.java */
/* loaded from: classes.dex */
public abstract class j<TResult> {
    public abstract j<TResult> a(Activity activity, g gVar);

    public abstract j<TResult> a(Activity activity, h<TResult> hVar);

    public j<TResult> a(e eVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public abstract j<TResult> a(g gVar);

    public abstract j<TResult> a(h<TResult> hVar);

    public abstract j<TResult> a(Executor executor, g gVar);

    public abstract j<TResult> a(Executor executor, h<TResult> hVar);

    public abstract Exception a();

    public abstract <E extends Throwable> TResult a(Class<E> cls);

    public <TContinuationResult> j<TContinuationResult> b(c<TResult, j<TContinuationResult>> cVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract TResult b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean e();

    public j<TResult> a(f<TResult> fVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public <TContinuationResult> j<TContinuationResult> b(Executor executor, c<TResult, j<TContinuationResult>> cVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> j<TContinuationResult> a(c<TResult, TContinuationResult> cVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> j<TContinuationResult> a(i<TResult, TContinuationResult> iVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public j<TResult> a(Executor executor, e eVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public j<TResult> a(Executor executor, f<TResult> fVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public <TContinuationResult> j<TContinuationResult> a(Executor executor, c<TResult, TContinuationResult> cVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> j<TContinuationResult> a(Executor executor, i<TResult, TContinuationResult> iVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public j<TResult> a(Activity activity, e eVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public j<TResult> a(Activity activity, f<TResult> fVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }
}
