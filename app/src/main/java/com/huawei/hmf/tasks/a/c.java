package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends CancellationToken {

    /* renamed from: a, reason: collision with root package name */
    public final List<Runnable> f6452a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Object f6453b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f6454c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f6454c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.f6453b) {
            if (this.f6454c) {
                runnable.run();
            } else {
                this.f6452a.add(runnable);
            }
        }
        return this;
    }
}
