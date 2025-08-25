package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class h<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private OnSuccessListener<TResult> f6473a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f6474b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6475c = new Object();

    h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f6473a = onSuccessListener;
        this.f6474b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f6475c) {
            this.f6473a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.f6474b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (h.this.f6475c) {
                    if (h.this.f6473a != null) {
                        h.this.f6473a.onSuccess(task.getResult());
                    }
                }
            }
        });
    }
}
