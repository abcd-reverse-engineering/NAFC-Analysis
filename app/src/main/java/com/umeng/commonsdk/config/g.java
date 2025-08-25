package com.umeng.commonsdk.config;

import com.umeng.commonsdk.debug.UMRTLog;
import org.android.agoo.common.Config;

/* compiled from: SensitiveFieldHandler.java */
/* loaded from: classes2.dex */
public class g implements e {
    @Override // com.umeng.commonsdk.config.e
    public void a(String str, Object obj, String[] strArr) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            long j2 = Long.parseLong(str);
            if (j2 == -1) {
                UMRTLog.e(Config.TAG, "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.");
                return;
            }
            UMRTLog.i(Config.TAG, "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
            if (obj == null || !(obj instanceof b)) {
                return;
            }
            try {
                Boolean.valueOf(true);
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String str2 = strArr[i2];
                    if (d.a(str2)) {
                        ((b) obj).a(str2, Boolean.valueOf(a.a(j2, i2)));
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            UMRTLog.e(Config.TAG, "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.");
        }
    }
}
