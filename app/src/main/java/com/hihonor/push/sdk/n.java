package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class n implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f6309a;

    public n(s sVar) {
        this.f6309a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        s sVar = this.f6309a;
        a0 a0Var = sVar.f6325b;
        Context context = sVar.f6324a;
        a0Var.getClass();
        try {
            d1 d1Var = new d1(UpMsgType.UNREGISTER_PUSH_TOKEN, null);
            d1Var.f6280e = b.a();
            b.a(z.f6357c.a(d1Var));
            d.f6260b.a(context, null);
            return null;
        } catch (Exception e2) {
            throw b.a(e2);
        }
    }
}
