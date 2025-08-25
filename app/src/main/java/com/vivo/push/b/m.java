package com.vivo.push.b;

import java.util.ArrayList;

/* compiled from: OnListTagReceiveCommand.java */
/* loaded from: classes2.dex */
public final class m extends s {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f11956a;

    public m() {
        super(8);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags_list", this.f11956a);
    }

    public final ArrayList<String> d() {
        return this.f11956a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnListTagCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11956a = dVar.c("tags_list");
    }
}
