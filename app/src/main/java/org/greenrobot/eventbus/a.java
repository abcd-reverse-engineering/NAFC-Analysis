package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;

/* compiled from: AsyncPoster.java */
/* loaded from: classes2.dex */
class a implements Runnable, l {

    /* renamed from: a, reason: collision with root package name */
    private final k f17363a = new k();

    /* renamed from: b, reason: collision with root package name */
    private final c f17364b;

    a(c cVar) {
        this.f17364b = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        this.f17363a.a(j.a(qVar, obj));
        this.f17364b.a().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        j jVarA = this.f17363a.a();
        if (jVarA == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f17364b.a(jVarA);
    }
}
