package com.vivo.push;

import android.content.Context;

/* compiled from: PushClientTask.java */
/* loaded from: classes2.dex */
public abstract class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected Context f12207a;

    /* renamed from: b, reason: collision with root package name */
    private int f12208b;

    /* renamed from: c, reason: collision with root package name */
    private v f12209c;

    public s(v vVar) {
        this.f12208b = -1;
        this.f12209c = vVar;
        this.f12208b = vVar.b();
        if (this.f12208b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f12207a = m.a().h();
    }

    public final int a() {
        return this.f12208b;
    }

    protected abstract void a(v vVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f12207a;
        if (context != null && !(this.f12209c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.u.a(context, "[执行指令]" + this.f12209c);
        }
        a(this.f12209c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        v vVar = this.f12209c;
        sb.append(vVar == null ? "[null]" : vVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
