package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class n0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final a1<TResult> f6310a = new a1<>();

    public void a(TResult tresult) {
        a1<TResult> a1Var = this.f6310a;
        synchronized (a1Var.f6249a) {
            if (!a1Var.f6250b) {
                a1Var.f6250b = true;
                a1Var.f6251c = tresult;
                a1Var.f6249a.notifyAll();
                a1Var.a();
            }
        }
    }

    public void a(Exception exc) {
        a1<TResult> a1Var = this.f6310a;
        synchronized (a1Var.f6249a) {
            if (!a1Var.f6250b) {
                a1Var.f6250b = true;
                a1Var.f6252d = exc;
                a1Var.f6249a.notifyAll();
                a1Var.a();
            }
        }
    }
}
