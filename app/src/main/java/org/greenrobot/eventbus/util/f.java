package org.greenrobot.eventbus.util;

/* compiled from: ThrowableFailureEvent.java */
/* loaded from: classes2.dex */
public class f implements e {

    /* renamed from: a, reason: collision with root package name */
    protected final Throwable f17496a;

    /* renamed from: b, reason: collision with root package name */
    protected final boolean f17497b;

    /* renamed from: c, reason: collision with root package name */
    private Object f17498c;

    public f(Throwable th) {
        this.f17496a = th;
        this.f17497b = false;
    }

    @Override // org.greenrobot.eventbus.util.e
    public Object a() {
        return this.f17498c;
    }

    public Throwable b() {
        return this.f17496a;
    }

    public boolean c() {
        return this.f17497b;
    }

    @Override // org.greenrobot.eventbus.util.e
    public void a(Object obj) {
        this.f17498c = obj;
    }

    public f(Throwable th, boolean z) {
        this.f17496a = th;
        this.f17497b = z;
    }
}
