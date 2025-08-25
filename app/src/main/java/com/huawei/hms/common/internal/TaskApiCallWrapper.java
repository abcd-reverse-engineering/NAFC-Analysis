package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f6783a;

    /* renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource<TResult> f6784b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f6783a = taskApiCall;
        this.f6784b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f6783a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.f6784b;
    }
}
