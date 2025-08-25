package com.vivo.push.f;

import android.content.Context;
import java.net.URISyntaxException;

/* compiled from: OnNotificationClickTask.java */
/* loaded from: classes2.dex */
final class x extends aa {
    x(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) throws URISyntaxException {
        Context context = this.f12207a;
        if (com.vivo.push.util.aa.c(context, context.getPackageName())) {
            e eVar = new e(vVar);
            eVar.a(((aa) this).f12034b);
            eVar.a(vVar);
        } else {
            d dVar = new d(vVar);
            dVar.a(((aa) this).f12034b);
            dVar.a(vVar);
        }
    }
}
