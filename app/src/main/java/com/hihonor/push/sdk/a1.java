package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Incorrect class signature: super class is equals to this class */
/* loaded from: classes.dex */
public final class a1<TResult> {

    /* renamed from: b, reason: collision with root package name */
    public boolean f6250b;

    /* renamed from: c, reason: collision with root package name */
    public TResult f6251c;

    /* renamed from: d, reason: collision with root package name */
    public Exception f6252d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f6249a = new Object();

    /* renamed from: e, reason: collision with root package name */
    public List<j0<TResult>> f6253e = new ArrayList();

    public final void a() {
        synchronized (this.f6249a) {
            Iterator<j0<TResult>> it = this.f6253e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f6253e = null;
        }
    }

    public final Exception b() {
        Exception exc;
        synchronized (this.f6249a) {
            exc = this.f6252d;
        }
        return exc;
    }

    public final TResult c() {
        TResult tresult;
        synchronized (this.f6249a) {
            if (this.f6252d != null) {
                throw new RuntimeException(this.f6252d);
            }
            tresult = this.f6251c;
        }
        return tresult;
    }

    public final boolean d() {
        synchronized (this.f6249a) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6249a
            monitor-enter(r0)
            boolean r1 = r2.f6250b     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L10
            r2.d()     // Catch: java.lang.Throwable -> L13
            java.lang.Exception r1 = r2.f6252d     // Catch: java.lang.Throwable -> L13
            if (r1 != 0) goto L10
            r1 = 1
            goto L11
        L10:
            r1 = 0
        L11:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            return r1
        L13:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hihonor.push.sdk.a1.e():boolean");
    }

    public final a1<TResult> a(j0<TResult> j0Var) {
        synchronized (this.f6249a) {
            if (!this.f6250b) {
                this.f6253e.add(j0Var);
            } else {
                j0Var.a(this);
            }
        }
        return this;
    }
}
