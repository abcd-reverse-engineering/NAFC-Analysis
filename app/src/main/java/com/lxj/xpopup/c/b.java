package com.lxj.xpopup.c;

import android.view.View;

/* compiled from: PopupAnimator.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public View f7950a;

    /* renamed from: b, reason: collision with root package name */
    public com.lxj.xpopup.d.c f7951b;

    public b() {
    }

    public abstract void a();

    public abstract void b();

    public int c() {
        return com.lxj.xpopup.b.a();
    }

    public abstract void d();

    public b(View view) {
        this(view, null);
    }

    public b(View view, com.lxj.xpopup.d.c cVar) {
        this.f7950a = view;
        this.f7951b = cVar;
    }
}
