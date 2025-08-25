package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* loaded from: classes2.dex */
public class cz {

    /* renamed from: a, reason: collision with root package name */
    private static cy f12621a;

    public static File a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR: Context cannot be null.");
            return null;
        }
        cy cyVar = f12621a;
        if (cyVar != null) {
            return cyVar.a(context);
        }
        com.xiaomi.channel.commonutils.logger.b.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
