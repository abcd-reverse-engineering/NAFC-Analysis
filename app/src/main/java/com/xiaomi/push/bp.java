package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.bw;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class bp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private String f12516a;

    /* renamed from: a, reason: collision with other field name */
    private WeakReference<Context> f226a;

    public bp(String str, WeakReference<Context> weakReference) {
        this.f12516a = str;
        this.f226a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f226a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (ca.a(this.f12516a) <= bo.f224a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bs bsVarA = bs.a(this.f12516a);
        br brVarA = br.a(this.f12516a);
        bsVarA.a(brVarA);
        brVarA.a(bq.a(context, this.f12516a, 1000));
        bw.a(context).a((bw.a) bsVarA);
    }
}
