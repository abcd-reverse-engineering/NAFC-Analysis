package com.hihonor.cloudservice.support.account.request;

import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import java.util.List;
import k.a.a.a.b;

/* compiled from: SignInOptionBuilder.java */
/* loaded from: classes.dex */
public class a extends com.hihonor.cloudservice.support.feature.request.a {
    public a() {
    }

    public SignInOptions a() {
        return new SignInOptions(this.f6021a, this.f6022b, this.f6023c, this.f6024d, this.f6025e, this.f6026f, this.f6027g, this.f6028h, this.f6029i, this.f6030j, this.f6031k, this.f6032l);
    }

    public a b(String str) {
        this.f6023c = str;
        return this;
    }

    public a c(String str) {
        this.f6024d = str;
        return this;
    }

    public a d() {
        return a(AbstractSignInOptions.n);
    }

    public a e(boolean z) {
        this.f6029i = z;
        return this;
    }

    public a(SignInOptions signInOptions) {
        this.f6021a.addAll(signInOptions.f());
        this.f6022b.addAll(signInOptions.d());
    }

    public a a(boolean z) {
        this.f6026f = z;
        return this;
    }

    public a b() {
        return a(AbstractSignInOptions.o);
    }

    public a c(boolean z) {
        this.f6028h = z;
        return this;
    }

    public a d(String str) {
        this.f6025e = str;
        return this;
    }

    public a e() {
        this.f6022b.add(AbstractSignInOptions.f6008m);
        return this;
    }

    public a a(String str) {
        this.f6032l = str;
        return this;
    }

    public a b(boolean z) {
        this.f6027g = z;
        return this;
    }

    public a c() {
        return a(AbstractSignInOptions.p);
    }

    public a d(boolean z) {
        this.f6030j = z;
        return this;
    }

    public a e(String str) {
        this.f6031k = str;
        return this;
    }

    public a a(Scope scope) {
        this.f6021a.add(scope);
        return this;
    }

    public a a(List<Scope> list) {
        if (b.b(list)) {
            for (Scope scope : list) {
                if (scope != null && scope.a() != null) {
                    this.f6021a.add(scope);
                }
            }
        }
        return this;
    }
}
