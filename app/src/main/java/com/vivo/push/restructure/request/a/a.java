package com.vivo.push.restructure.request.a;

import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.u;
import org.json.JSONException;

/* compiled from: CFToClientDS.java */
/* loaded from: classes2.dex */
public final class a implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<a> f12181a = new b();

    /* renamed from: b, reason: collision with root package name */
    private String f12182b;

    /* renamed from: c, reason: collision with root package name */
    private int f12183c;

    /* renamed from: d, reason: collision with root package name */
    private int f12184d;

    /* renamed from: e, reason: collision with root package name */
    private long f12185e;

    /* renamed from: f, reason: collision with root package name */
    private int f12186f;

    /* renamed from: g, reason: collision with root package name */
    private int f12187g;

    protected a(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f12182b = aVar.c();
            this.f12183c = aVar.a();
            this.f12185e = aVar.b();
            this.f12186f = aVar.a();
            this.f12184d = aVar.a();
            this.f12187g = aVar.a();
        } catch (JSONException e2) {
            u.a("CFToClientDS", e2);
        }
    }

    public final int a() {
        return this.f12183c;
    }

    public final int b() {
        return this.f12186f;
    }

    public final int c() {
        return this.f12187g;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f12182b);
        aVar.a(this.f12183c);
        aVar.a(this.f12185e);
        aVar.a(this.f12186f);
        aVar.a(this.f12184d);
        aVar.a(this.f12187g);
    }
}
