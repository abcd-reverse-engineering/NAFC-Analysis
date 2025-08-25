package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: OnTagsReceiveCommand.java */
/* loaded from: classes2.dex */
public final class t extends s {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f11975a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f11976b;

    public t(int i2) {
        super(i2);
        this.f11975a = null;
        this.f11976b = null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f11975a);
        dVar.a("error_msg", this.f11976b);
    }

    public final ArrayList<String> d() {
        return this.f11975a;
    }

    public final List<String> e() {
        return this.f11976b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11975a = dVar.c("content");
        this.f11976b = dVar.c("error_msg");
    }
}
