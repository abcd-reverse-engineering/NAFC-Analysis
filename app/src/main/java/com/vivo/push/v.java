package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: PushCommand.java */
/* loaded from: classes2.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private int f12304a;

    /* renamed from: b, reason: collision with root package name */
    private String f12305b;

    public v(int i2) {
        this.f12304a = -1;
        if (i2 < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f12304a = i2;
    }

    private void e(d dVar) {
        dVar.a("command", this.f12304a);
        dVar.a("client_pkgname", this.f12305b);
        c(dVar);
    }

    public final String a() {
        return this.f12305b;
    }

    public final int b() {
        return this.f12304a;
    }

    protected abstract void c(d dVar);

    public boolean c() {
        return false;
    }

    protected abstract void d(d dVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f12305b = str;
    }

    public final void b(Intent intent) {
        d dVarA = d.a(intent);
        if (dVarA == null) {
            com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            return;
        }
        dVarA.a("method", this.f12304a);
        e(dVarA);
        Bundle bundleB = dVarA.b();
        if (bundleB != null) {
            intent.putExtras(bundleB);
        }
    }

    public final void a(Intent intent) {
        d dVarA = d.a(intent);
        if (dVarA == null) {
            com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(dVarA);
        Bundle bundleB = dVarA.b();
        if (bundleB != null) {
            intent.putExtras(bundleB);
        }
    }

    public final void a(d dVar) {
        String strA = x.a(this.f12304a);
        if (strA == null) {
            strA = "";
        }
        dVar.a("method", strA);
        e(dVar);
    }

    public final void b(d dVar) {
        String strA = dVar.a();
        if (!TextUtils.isEmpty(strA)) {
            this.f12305b = strA;
        } else {
            this.f12305b = dVar.a("client_pkgname");
        }
        d(dVar);
    }
}
