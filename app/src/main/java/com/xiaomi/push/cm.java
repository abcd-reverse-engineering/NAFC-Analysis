package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
public class cm implements ff, fk {

    /* renamed from: a, reason: collision with root package name */
    private Context f12562a;

    public cm(Context context) {
        this.f12562a = context;
    }

    @Override // com.xiaomi.push.ff
    public void a(fo foVar) {
        ct.a(this.f12562a);
    }

    @Override // com.xiaomi.push.fk
    /* renamed from: a */
    public boolean mo240a(fo foVar) {
        return true;
    }

    @Override // com.xiaomi.push.ff
    public void a(er erVar) {
        if (erVar != null && erVar.a() == 0 && "PING".equals(erVar.m390a())) {
            ct.c(this.f12562a);
        } else {
            ct.a(this.f12562a);
        }
    }
}
