package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: ClientSdkQueryParemeterDS.java */
/* loaded from: classes2.dex */
public final class e implements com.vivo.push.restructure.request.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    public static c.a<e> f12020a = new f();

    /* renamed from: b, reason: collision with root package name */
    private int f12021b;

    /* renamed from: c, reason: collision with root package name */
    private String f12022c;

    /* renamed from: d, reason: collision with root package name */
    private String f12023d;

    /* renamed from: e, reason: collision with root package name */
    private String f12024e;

    /* renamed from: f, reason: collision with root package name */
    private String f12025f;

    public e(int i2, String str, String str2, String str3, String str4) {
        this.f12021b = i2;
        this.f12022c = str;
        this.f12023d = str2;
        this.f12024e = str3;
        this.f12025f = str4;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f12021b);
        aVar.a(this.f12022c);
        aVar.a(this.f12023d);
        aVar.a(this.f12024e);
        aVar.a(this.f12025f);
        return aVar.d();
    }

    protected e(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f12021b = aVar.a();
        this.f12022c = aVar.c();
        this.f12023d = aVar.c();
        this.f12024e = aVar.c();
        this.f12025f = aVar.c();
    }
}
