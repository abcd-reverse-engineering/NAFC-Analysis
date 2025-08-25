package com.huawei.hms.opendevice;

/* compiled from: TaskWrapper.java */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f7145a;

    public o(Runnable runnable) {
        this.f7145a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f7145a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
            }
        }
    }
}
