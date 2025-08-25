package network;

import l.d;
import l.m;

/* loaded from: classes2.dex */
public abstract class RetrofitCallback<T> implements d<T> {
    public abstract void onLoading(long j2, long j3);

    @Override // l.d
    public void onResponse(l.b<T> bVar, m<T> mVar) {
        if (mVar.e()) {
            onSuccess(bVar, mVar);
        } else {
            onFailure(bVar, new Throwable(mVar.f()));
        }
    }

    public abstract void onSuccess(l.b<T> bVar, m<T> mVar);
}
