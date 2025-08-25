package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
public class cl implements ff, fk {

    /* renamed from: a, reason: collision with root package name */
    private Context f12561a;

    public cl(Context context) {
        this.f12561a = context;
    }

    @Override // com.xiaomi.push.ff
    public void a(fo foVar) {
        ct.b(this.f12561a);
    }

    @Override // com.xiaomi.push.fk
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo240a(fo foVar) {
        return true;
    }

    @Override // com.xiaomi.push.ff
    public void a(er erVar) {
        if (erVar != null && erVar.a() == 0 && "PING".equals(erVar.m390a())) {
            ct.d(this.f12561a);
        } else {
            ct.b(this.f12561a);
        }
    }
}
