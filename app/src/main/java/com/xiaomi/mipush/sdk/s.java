package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.g;
import com.xiaomi.push.aw;

/* loaded from: classes2.dex */
public class s {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        g.a aVarA = g.a(dVar);
        if (aVarA == null || TextUtils.isEmpty(aVarA.f12375a) || TextUtils.isEmpty(aVarA.f12376b)) {
            return null;
        }
        return (AbstractPushManager) aw.a(aVarA.f12375a, aVarA.f12376b, context);
    }
}
