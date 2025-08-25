package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CancellationTokenSource {
    private c impl = new c();

    public void cancel() {
        c cVar = this.impl;
        if (cVar.f6454c) {
            return;
        }
        synchronized (cVar.f6453b) {
            cVar.f6454c = true;
            Iterator<Runnable> it = cVar.f6452a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
