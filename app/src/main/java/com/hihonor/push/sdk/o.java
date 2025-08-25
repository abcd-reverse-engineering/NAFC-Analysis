package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class o implements Callable<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f6311a;

    public o(s sVar) {
        this.f6311a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        this.f6311a.f6325b.getClass();
        try {
            c1 c1Var = new c1(UpMsgType.QUERY_PUSH_STATUS, null);
            c1Var.f6280e = b.a();
            return Boolean.valueOf(((BooleanResult) b.a(z.f6357c.a(c1Var))).getStatus());
        } catch (Exception e2) {
            throw b.a(e2);
        }
    }
}
