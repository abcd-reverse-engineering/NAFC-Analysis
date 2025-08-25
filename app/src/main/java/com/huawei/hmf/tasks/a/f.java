package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class f<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private OnFailureListener f6466a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f6467b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6468c = new Object();

    f(Executor executor, OnFailureListener onFailureListener) {
        this.f6466a = onFailureListener;
        this.f6467b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f6468c) {
            this.f6466a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.f6467b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (f.this.f6468c) {
                    if (f.this.f6466a != null) {
                        f.this.f6466a.onFailure(task.getException());
                    }
                }
            }
        });
    }
}
