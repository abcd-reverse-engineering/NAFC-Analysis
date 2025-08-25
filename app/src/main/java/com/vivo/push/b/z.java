package com.vivo.push.b;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: TagCommand.java */
/* loaded from: classes2.dex */
public final class z extends c {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f11985a;

    public z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.f11985a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(SocializeProtocolConstants.TAGS, (Serializable) this.f11985a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11985a = dVar.c(SocializeProtocolConstants.TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "TagCommand";
    }
}
