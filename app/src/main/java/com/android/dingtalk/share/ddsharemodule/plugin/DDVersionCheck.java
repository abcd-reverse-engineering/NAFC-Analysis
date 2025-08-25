package com.android.dingtalk.share.ddsharemodule.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;

/* loaded from: classes.dex */
public class DDVersionCheck {
    public static int getSdkVersionFromMetaData(Context context, int i2) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(ShareConstant.DD_APP_PACKAGE, 128);
            return applicationInfo.metaData != null ? applicationInfo.metaData.getInt(ShareConstant.DD_SDK_VERSION_META_KEY) : i2;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return i2;
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            return i2;
        }
    }
}
