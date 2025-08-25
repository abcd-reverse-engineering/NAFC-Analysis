package com.hihonor.cloudservice.tasks.q;

import java.util.ArrayList;
import java.util.List;

/* compiled from: CancellationTokenImpl.java */
/* loaded from: classes.dex */
public class a extends c.c.a.d.a {

    /* renamed from: a, reason: collision with root package name */
    public final List<Runnable> f6043a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Object f6044b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f6045c = false;

    @Override // c.c.a.d.a
    public boolean a() {
        return this.f6045c;
    }

    @Override // c.c.a.d.a
    public c.c.a.d.a a(Runnable runnable) {
        synchronized (this.f6044b) {
            if (this.f6045c) {
                runnable.run();
            } else {
                this.f6043a.add(runnable);
            }
        }
        return this;
    }
}
