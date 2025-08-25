package com.scwang.smartrefresh.layout.e;

/* compiled from: DelayedRunnable.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public long f8272a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f8273b;

    public a(Runnable runnable, long j2) {
        this.f8273b = runnable;
        this.f8272a = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f8273b != null) {
                this.f8273b.run();
                this.f8273b = null;
            }
        } catch (Throwable th) {
            if (th instanceof NoClassDefFoundError) {
                return;
            }
            th.printStackTrace();
        }
    }
}
