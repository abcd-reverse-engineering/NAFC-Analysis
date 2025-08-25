package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f6460a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final int f6461b;

    /* renamed from: c, reason: collision with root package name */
    private final i<Void> f6462c;

    /* renamed from: d, reason: collision with root package name */
    private int f6463d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f6464e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6465f;

    e(int i2, i<Void> iVar) {
        this.f6461b = i2;
        this.f6462c = iVar;
    }

    private void a() {
        if (this.f6463d >= this.f6461b) {
            Exception exc = this.f6464e;
            if (exc != null) {
                this.f6462c.a(new ExecutionException("a task failed", exc));
            } else if (this.f6465f) {
                this.f6462c.a();
            } else {
                this.f6462c.a((i<Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f6460a) {
            this.f6463d++;
            this.f6465f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f6460a) {
            this.f6463d++;
            this.f6464e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.f6460a) {
            this.f6463d++;
            a();
        }
    }
}
