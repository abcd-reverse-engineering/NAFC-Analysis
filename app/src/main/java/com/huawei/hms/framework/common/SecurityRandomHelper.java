package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: classes.dex */
public class SecurityRandomHelper {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile SecurityRandomHelper instance;

    private SecurityRandomHelper() {
    }

    public static SecurityRandomHelper getInstance() {
        if (instance == null) {
            synchronized (SecurityRandomHelper.class) {
                if (instance == null) {
                    EncryptUtil.setBouncycastleFlag(true);
                    instance = new SecurityRandomHelper();
                }
            }
        }
        return instance;
    }

    public byte[] generateSecureRandom(int i2) {
        return EncryptUtil.generateSecureRandom(i2);
    }

    public String generateSecureRandomStr(int i2) {
        return EncryptUtil.generateSecureRandomStr(i2);
    }
}
