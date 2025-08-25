package org.greenrobot.eventbus.util;

import android.content.res.Resources;

/* compiled from: ErrorDialogConfig.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    final Resources f17485a;

    /* renamed from: b, reason: collision with root package name */
    final int f17486b;

    /* renamed from: c, reason: collision with root package name */
    final int f17487c;

    /* renamed from: e, reason: collision with root package name */
    org.greenrobot.eventbus.c f17489e;

    /* renamed from: g, reason: collision with root package name */
    String f17491g;

    /* renamed from: h, reason: collision with root package name */
    int f17492h;

    /* renamed from: i, reason: collision with root package name */
    Class<?> f17493i;

    /* renamed from: f, reason: collision with root package name */
    boolean f17490f = true;

    /* renamed from: d, reason: collision with root package name */
    final d f17488d = new d();

    public b(Resources resources, int i2, int i3) {
        this.f17485a = resources;
        this.f17486b = i2;
        this.f17487c = i3;
    }

    public b a(Class<? extends Throwable> cls, int i2) {
        this.f17488d.a(cls, i2);
        return this;
    }

    org.greenrobot.eventbus.c b() {
        org.greenrobot.eventbus.c cVar = this.f17489e;
        return cVar != null ? cVar : org.greenrobot.eventbus.c.f();
    }

    public int a(Throwable th) {
        Integer numA = this.f17488d.a(th);
        if (numA != null) {
            return numA.intValue();
        }
        String str = org.greenrobot.eventbus.c.s;
        String str2 = "No specific message ressource ID found for " + th;
        return this.f17487c;
    }

    public void a(int i2) {
        this.f17492h = i2;
    }

    public void a(Class<?> cls) {
        this.f17493i = cls;
    }

    public void a() {
        this.f17490f = false;
    }

    public void a(String str) {
        this.f17491g = str;
    }

    public void a(org.greenrobot.eventbus.c cVar) {
        this.f17489e = cVar;
    }
}
