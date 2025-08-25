package org.greenrobot.eventbus;

/* compiled from: Subscription.java */
/* loaded from: classes2.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    final Object f17445a;

    /* renamed from: b, reason: collision with root package name */
    final o f17446b;

    /* renamed from: c, reason: collision with root package name */
    volatile boolean f17447c = true;

    q(Object obj, o oVar) {
        this.f17445a = obj;
        this.f17446b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f17445a == qVar.f17445a && this.f17446b.equals(qVar.f17446b);
    }

    public int hashCode() {
        return this.f17445a.hashCode() + this.f17446b.f17427f.hashCode();
    }
}
