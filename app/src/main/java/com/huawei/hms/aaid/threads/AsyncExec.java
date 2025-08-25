package com.huawei.hms.aaid.threads;

import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.o;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class AsyncExec {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f6513a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("SeqIO"), new ThreadPoolExecutor.AbortPolicy());

    public static void submitSeqIO(Runnable runnable) {
        try {
            f6513a.execute(new o(runnable));
        } catch (Exception e2) {
            String str = "submit seq io task failed, Exception:" + e2;
        }
    }
}
