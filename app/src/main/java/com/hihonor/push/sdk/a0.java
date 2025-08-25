package com.hihonor.push.sdk;

import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.UpMsgType;

/* loaded from: classes.dex */
public class a0 {
    public Void a(boolean z) throws ApiException {
        try {
            g1 g1Var = new g1(z ? UpMsgType.TURN_ON_PUSH : UpMsgType.TURN_OFF_PUSH, null);
            g1Var.f6280e = b.a();
            b.a(z.f6357c.a(g1Var));
            return null;
        } catch (Exception e2) {
            throw b.a(e2);
        }
    }
}
