package com.vivo.push.restructure.request.a;

import com.vivo.push.restructure.request.a.a.b;
import org.json.JSONException;

/* compiled from: CFToCoreDS.java */
/* loaded from: classes2.dex */
public final class c implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<c> f12191a = new d();

    /* renamed from: b, reason: collision with root package name */
    private String f12192b;

    /* renamed from: c, reason: collision with root package name */
    private int f12193c;

    /* renamed from: d, reason: collision with root package name */
    private long f12194d;

    /* renamed from: e, reason: collision with root package name */
    private int f12195e;

    public c(int i2, int i3) {
        this.f12192b = com.vivo.push.restructure.a.a().b().getPackageName();
        this.f12193c = i2;
        this.f12194d = 341L;
        this.f12195e = i3;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f12192b);
        aVar.a(this.f12193c);
        aVar.a(this.f12194d);
        aVar.a(this.f12195e);
    }

    protected c(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f12192b = aVar.c();
            this.f12193c = aVar.a();
            this.f12194d = aVar.b();
            this.f12195e = aVar.a();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
