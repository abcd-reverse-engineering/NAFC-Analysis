package com.hihonor.honorid;

import android.os.Parcelable;
import com.hihonor.honorid.UseCase.RequestValues;

/* loaded from: classes.dex */
public abstract class UseCase<Q extends RequestValues> {

    /* renamed from: a, reason: collision with root package name */
    private Q f6097a;

    public static abstract class RequestValues implements Parcelable {
    }

    public interface a {
    }

    void a() {
        a((UseCase<Q>) this.f6097a);
    }

    protected abstract void a(Q q);

    public void a(a aVar) {
    }

    public void b(Q q) {
        this.f6097a = q;
    }
}
