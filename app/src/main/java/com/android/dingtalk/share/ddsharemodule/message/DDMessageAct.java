package com.android.dingtalk.share.ddsharemodule.message;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import com.android.dingtalk.share.ddsharemodule.plugin.SignatureCheck;

/* loaded from: classes.dex */
public class DDMessageAct {
    private static final String TAG = "DDMessageAct";

    private static Intent initIntent(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse(str));
    }

    private static Intent initSendByAuthIntent() {
        return initIntent(ShareConstant.DD_SEND_AUTH_ACTIVITY_SCHEME);
    }

    private static Intent initSendDingIntent() {
        return initIntent(ShareConstant.DD_DING_ACTIVITY_SCHEME);
    }

    private static Intent initSendFriendIntent() {
        return initIntent(ShareConstant.DD_ENTER_ACTIVITY_SCHEME);
    }

    private static boolean send(Context context, String str, Bundle bundle, Intent intent) throws PackageManager.NameNotFoundException {
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        String packageName = context.getPackageName();
        String mD5Signature = SignatureCheck.getMD5Signature(context, packageName);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_SDK_VERSION, 20160101);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_APP_PACKAGE_NAME, packageName);
        intent.putExtra(ShareConstant.EXTRA_ACTION_TYPE, ShareConstant.OUT_SHARE_ACTION_TYPE);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_APP_SIGNATURE, mD5Signature);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_APP_ID, str);
        try {
            context.startActivity(intent);
            String str2 = "send dd message, intent=" + intent;
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        } catch (Exception e2) {
            String str3 = "send v2 fail " + e2.getMessage();
            return false;
        }
    }

    public static boolean sendDDAuth(Context context, String str, Bundle bundle) {
        if (context != null) {
            return send(context, str, bundle, initSendByAuthIntent());
        }
        return false;
    }

    public static boolean sendDDFriend(Context context, String str, Bundle bundle) {
        if (context != null) {
            return send(context, str, bundle, initSendFriendIntent());
        }
        return false;
    }

    public static boolean sendDing(Context context, String str, Bundle bundle) {
        if (context != null) {
            return send(context, str, bundle, initSendDingIntent());
        }
        return false;
    }
}
