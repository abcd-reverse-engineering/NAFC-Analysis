package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* loaded from: classes2.dex */
public class UmengInAppClickHandler implements UInAppHandler {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11191a = "com.umeng.message.inapp.UmengInAppClickHandler";

    /* renamed from: b, reason: collision with root package name */
    private String f11192b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f11193c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f11194d = null;

    @Override // com.umeng.message.inapp.UInAppHandler
    public final void handleInAppMessage(Activity activity, UInAppMessage uInAppMessage, int i2) {
        switch (i2) {
            case 16:
                this.f11192b = uInAppMessage.action_type;
                this.f11193c = uInAppMessage.action_activity;
                this.f11194d = uInAppMessage.action_url;
                break;
            case 17:
                this.f11192b = uInAppMessage.bottom_action_type;
                this.f11193c = uInAppMessage.bottom_action_activity;
                this.f11194d = uInAppMessage.bottom_action_url;
                break;
            case 18:
                this.f11192b = uInAppMessage.plainTextActionType;
                this.f11193c = uInAppMessage.plainTextActivity;
                this.f11194d = uInAppMessage.plainTextUrl;
                break;
            case 19:
                this.f11192b = uInAppMessage.customButtonActionType;
                this.f11193c = uInAppMessage.customButtonActivity;
                this.f11194d = uInAppMessage.customButtonUrl;
                break;
        }
        if (TextUtils.isEmpty(this.f11192b)) {
            return;
        }
        if (TextUtils.equals("go_activity", this.f11192b)) {
            openActivity(activity, this.f11193c);
        } else if (TextUtils.equals("go_url", this.f11192b)) {
            openUrl(activity, this.f11194d);
        } else {
            TextUtils.equals("go_app", this.f11192b);
        }
    }

    public void openActivity(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(f11191a, 2, "打开Activity: ".concat(String.valueOf(str)));
                Intent intent = new Intent();
                intent.setClassName(activity, str);
                intent.setFlags(CommonNetImpl.FLAG_SHARE);
                activity.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void openUrl(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(f11191a, 2, "打开链接: ".concat(String.valueOf(str)));
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
