package com.vivo.push.d;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: ProfileInfoDS.java */
/* loaded from: classes2.dex */
public final class b implements com.vivo.push.restructure.request.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    public static c.a<b> f12004a = new c();

    /* renamed from: b, reason: collision with root package name */
    private String f12005b;

    public b(String str) {
        this.f12005b = str;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f12005b);
        return aVar.d();
    }

    public final String b() {
        return this.f12005b;
    }

    protected b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f12005b = aVar.c();
    }
}
