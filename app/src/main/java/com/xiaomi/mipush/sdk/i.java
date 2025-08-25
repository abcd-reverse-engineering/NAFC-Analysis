package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.df;
import com.xiaomi.push.gf;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;

/* loaded from: classes2.dex */
public class i implements df {

    /* renamed from: a, reason: collision with root package name */
    private Context f12378a;

    public i(Context context) {
        this.f12378a = context;
    }

    @Override // com.xiaomi.push.df
    public String a() {
        return b.m75a(this.f12378a).d();
    }

    @Override // com.xiaomi.push.df
    public void a(he heVar, gf gfVar, gs gsVar) {
        u.a(this.f12378a).a((u) heVar, gfVar, gsVar);
    }
}
