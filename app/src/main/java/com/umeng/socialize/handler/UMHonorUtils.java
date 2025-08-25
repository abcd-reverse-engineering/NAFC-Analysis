package com.umeng.socialize.handler;

import android.text.TextUtils;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.UMAuthUtils;

/* loaded from: classes2.dex */
public class UMHonorUtils {
    public static String decryptMobileNumber(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        PlatformConfig.APPIDPlatform aPPIDPlatform = (PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.HONOR);
        if (aPPIDPlatform == null) {
            throw new RuntimeException("please config honor platform!");
        }
        String appSecret = aPPIDPlatform.getAppSecret();
        if (TextUtils.isEmpty(appSecret)) {
            throw new RuntimeException("honor secret empty!");
        }
        return UMAuthUtils.decrypt(str, appSecret);
    }
}
