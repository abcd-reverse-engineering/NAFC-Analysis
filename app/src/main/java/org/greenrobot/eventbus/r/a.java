package org.greenrobot.eventbus.r;

import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.o;

/* compiled from: AbstractSubscriberInfo.java */
/* loaded from: classes2.dex */
public abstract class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Class f17448a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<? extends c> f17449b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f17450c;

    protected a(Class cls, Class<? extends c> cls2, boolean z) {
        this.f17448a = cls;
        this.f17449b = cls2;
        this.f17450c = z;
    }

    protected o a(String str, Class<?> cls) {
        return a(str, cls, ThreadMode.POSTING, 0, false);
    }

    @Override // org.greenrobot.eventbus.r.c
    public c b() {
        Class<? extends c> cls = this.f17449b;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // org.greenrobot.eventbus.r.c
    public boolean c() {
        return this.f17450c;
    }

    @Override // org.greenrobot.eventbus.r.c
    public Class d() {
        return this.f17448a;
    }

    protected o a(String str, Class<?> cls, ThreadMode threadMode) {
        return a(str, cls, threadMode, 0, false);
    }

    protected o a(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        try {
            return new o(this.f17448a.getDeclaredMethod(str, cls), cls, threadMode, i2, z);
        } catch (NoSuchMethodException e2) {
            throw new org.greenrobot.eventbus.e("Could not find subscriber method in " + this.f17448a + ". Maybe a missing ProGuard rule?", e2);
        }
    }
}
