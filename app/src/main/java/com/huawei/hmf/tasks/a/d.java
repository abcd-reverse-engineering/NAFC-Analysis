package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    Executor f6455a;

    /* renamed from: b, reason: collision with root package name */
    private OnCompleteListener<TResult> f6456b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6457c = new Object();

    d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f6456b = onCompleteListener;
        this.f6455a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f6457c) {
            this.f6456b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.f6455a.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this.f6457c) {
                    if (d.this.f6456b != null) {
                        d.this.f6456b.onComplete(task);
                    }
                }
            }
        });
    }
}
