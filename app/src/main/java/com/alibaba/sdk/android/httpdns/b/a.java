package com.alibaba.sdk.android.httpdns.b;

import android.content.Context;
import java.util.List;

/* loaded from: classes.dex */
class a implements f {

    /* renamed from: a, reason: collision with root package name */
    private final d f4003a;

    a(Context context) {
        this.f4003a = new d(context);
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public List<e> a() {
        return this.f4003a.b();
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public void a(e eVar) {
        this.f4003a.m12a(eVar);
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public void b(e eVar) {
        this.f4003a.b(eVar.f4009m, eVar.host);
    }
}
