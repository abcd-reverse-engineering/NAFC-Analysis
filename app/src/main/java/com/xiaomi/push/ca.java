package com.xiaomi.push;

import android.os.Build;
import android.system.Os;
import java.io.File;

/* loaded from: classes2.dex */
public class ca {
    public static long a(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0L;
        }
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0L;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return 0L;
        }
    }
}
