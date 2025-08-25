package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
public class cr implements fd {

    /* renamed from: a, reason: collision with root package name */
    private Context f12589a;

    public cr(Context context) {
        this.f12589a = context;
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i2, Exception exc) {
        cn.a(this.f12589a, faVar.mo414a(), i2);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        cn.m241a(this.f12589a);
    }
}
