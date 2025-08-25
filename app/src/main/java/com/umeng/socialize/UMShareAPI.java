package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UMShareAPI {

    /* renamed from: a, reason: collision with root package name */
    private static UMShareAPI f11515a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f11516b = true;
    public boolean isZyb = true;

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static UMShareAPI get(Context context) {
        if (!a(context) || CommonUtil.isSilentMode(context)) {
            f11515a = new b(context);
            return f11515a;
        }
        if (f11515a == null) {
            f11515a = new a(context);
            SLog.welcome();
        }
        return f11515a;
    }

    public static String getSdkVersion() {
        return "7.3.2";
    }

    public static boolean getSmartEnableFlag() {
        return f11516b;
    }

    public static void init(Context context, String str) {
        if (a(context)) {
            SocializeConstants.APPKEY = str;
            get(context);
            UMWorkDispatch.sendEvent(context, SocializeConstants.REGIST_TO_WORK_QUEUE, CommonNetImpl.get(context), null);
        }
    }

    public static void setSmartEnable(boolean z) {
        f11516b = z;
    }

    public void deleteOauth(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f11515a.deleteOauth(activity, share_media, uMAuthListener);
    }

    @Deprecated
    public void doOauthVerify(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f11515a.doOauthVerify(activity, share_media, uMAuthListener);
    }

    public void doShare(Activity activity, ShareAction shareAction, UMShareListener uMShareListener) {
        f11515a.doShare(activity, shareAction, uMShareListener);
    }

    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        f11515a.fetchAuthResultWithBundle(activity, bundle, uMAuthListener);
    }

    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        return f11515a.getHandler(share_media);
    }

    public void getPlatformInfo(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f11515a.getPlatformInfo(activity, share_media, uMAuthListener);
    }

    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return f11515a.getversion(activity, share_media);
    }

    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return f11515a.isAuthorize(activity, share_media);
    }

    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return f11515a.isInstall(activity, share_media);
    }

    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return f11515a.isSupport(activity, share_media);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        f11515a.onActivityResult(i2, i3, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        f11515a.onSaveInstanceState(bundle);
    }

    public void release() {
        f11515a.release();
    }

    public void setShareConfig(UMShareConfig uMShareConfig) {
        f11515a.setShareConfig(uMShareConfig);
    }

    private static boolean a() {
        try {
            Class<?> clsA = a("com.umeng.commonsdk.framework.UMEnvelopeBuild");
            if (clsA != null) {
                return clsA.getDeclaredMethod("buildEnvelopeWithExtHeader", Context.class, JSONObject.class, JSONObject.class, String.class, String.class, String.class) != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(final Context context) {
        if (a()) {
            return true;
        }
        new Thread() { // from class: com.umeng.socialize.UMShareAPI.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Looper.prepare();
                    Toast.makeText(context.getApplicationContext(), UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH, 1).show();
                    Looper.loop();
                } catch (Throwable unused) {
                }
            }
        }.start();
        SLog.E(UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH);
        return false;
    }
}
