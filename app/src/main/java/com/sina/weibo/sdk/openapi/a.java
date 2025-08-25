package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.e;
import com.sina.weibo.sdk.web.b.d;
import com.xiaomi.mipush.sdk.PushMessageHelper;

/* loaded from: classes.dex */
public final class a implements IWBAPI {
    private Context mContext;
    private com.sina.weibo.sdk.auth.a r = new com.sina.weibo.sdk.auth.a();
    private e s = new e();

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorize(Activity activity, WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.r;
        c.a("WBSsoTag", "authorize()");
        if (wbAuthListener == null) {
            throw new RuntimeException("listener can not be null.");
        }
        aVar.f8358d = wbAuthListener;
        if (com.sina.weibo.sdk.a.a(activity)) {
            if (com.sina.weibo.sdk.b.a.e(activity) != null) {
                aVar.a(activity);
                return;
            }
        }
        aVar.b(activity);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeCallback(Activity activity, int i2, int i3, Intent intent) {
        com.sina.weibo.sdk.auth.a aVar = this.r;
        c.a("WBSsoTag", "authorizeCallback()");
        WbAuthListener wbAuthListener = aVar.f8358d;
        if (wbAuthListener != null) {
            if (32973 != i2) {
                wbAuthListener.onError(new UiError(-7, "request code is error", "requestCode is error"));
                return;
            }
            if (i3 != -1) {
                if (i3 == 0) {
                    wbAuthListener.onCancel();
                    return;
                } else {
                    wbAuthListener.onError(new UiError(-6, "result code is error", "result code is error"));
                    return;
                }
            }
            if (intent != null) {
                String stringExtra = intent.getStringExtra("error");
                String stringExtra2 = intent.getStringExtra(PushMessageHelper.ERROR_TYPE);
                String stringExtra3 = intent.getStringExtra("error_description");
                if (!TextUtils.isEmpty(stringExtra) || !TextUtils.isEmpty(stringExtra2) || !TextUtils.isEmpty(stringExtra3)) {
                    if ("access_denied".equals(stringExtra) || "OAuthAccessDeniedException".equals(stringExtra)) {
                        aVar.f8358d.onCancel();
                        return;
                    } else {
                        aVar.f8358d.onError(new UiError(-5, stringExtra2, stringExtra3));
                        return;
                    }
                }
                Oauth2AccessToken accessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                if (accessToken == null) {
                    aVar.f8358d.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
                } else {
                    AccessTokenHelper.writeAccessToken(activity, accessToken);
                    aVar.f8358d.onComplete(accessToken);
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeClient(Activity activity, WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.r;
        c.a("WBSsoTag", "authorizeClient()");
        if (wbAuthListener == null) {
            throw new RuntimeException("listener can not be null.");
        }
        aVar.f8358d = wbAuthListener;
        aVar.a(activity);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeWeb(Activity activity, WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.r;
        c.a("WBSsoTag", "authorizeWeb()");
        if (wbAuthListener == null) {
            throw new RuntimeException("listener can not be null.");
        }
        aVar.f8358d = wbAuthListener;
        aVar.b(activity);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        if (intent == null || wbShareCallback == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            int i2 = extras.getInt("_weibo_resp_errcode", -1);
            if (i2 == 0) {
                wbShareCallback.onComplete();
            } else if (i2 == 1) {
                wbShareCallback.onCancel();
            } else {
                if (i2 != 2) {
                    return;
                }
                wbShareCallback.onError(new UiError(i2, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
            }
        } catch (Exception e2) {
            wbShareCallback.onError(new UiError(-1, e2.getMessage(), e2.getMessage()));
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppInstalled() {
        return com.sina.weibo.sdk.a.a(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppSupportMultipleImage() {
        return com.sina.weibo.sdk.a.b(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo) {
        registerApp(context, authInfo, null);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void setLoggerEnable(boolean z) {
        c.setLoggerEnable(z);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareMessage(Activity activity, WeiboMultiMessage weiboMultiMessage, boolean z) {
        AuthInfo authInfoA;
        e eVar = this.s;
        if (activity != null) {
            if (com.sina.weibo.sdk.a.a(activity) || !z) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - eVar.D >= com.heytap.mcssdk.constant.a.r) {
                    eVar.D = jCurrentTimeMillis;
                    if (z) {
                        e.a(activity, weiboMultiMessage);
                        return;
                    }
                    a.C0121a c0121aE = com.sina.weibo.sdk.b.a.e(activity);
                    if (com.sina.weibo.sdk.a.a(activity) && c0121aE != null) {
                        a.C0121a c0121aE2 = com.sina.weibo.sdk.b.a.e(activity);
                        boolean z2 = false;
                        if (c0121aE2 != null && c0121aE2.ah > 10000) {
                            z2 = true;
                        }
                        if (z2) {
                            e.a(activity, weiboMultiMessage);
                            return;
                        }
                    }
                    if (activity == null || (authInfoA = com.sina.weibo.sdk.a.a()) == null) {
                        return;
                    }
                    d dVar = new d(authInfoA);
                    dVar.setContext(activity);
                    dVar.aE = weiboMultiMessage;
                    dVar.packageName = activity.getPackageName();
                    Oauth2AccessToken accessToken = AccessTokenHelper.readAccessToken(activity);
                    if (accessToken != null) {
                        String accessToken2 = accessToken.getAccessToken();
                        if (!TextUtils.isEmpty(accessToken.getAccessToken())) {
                            dVar.ae = accessToken2;
                        }
                    }
                    Bundle bundle = new Bundle();
                    dVar.writeToBundle(bundle);
                    Intent intent = new Intent(activity, (Class<?>) ShareTransActivity.class);
                    intent.putExtra("start_flag", 1001);
                    intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, 10001);
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener) {
        com.sina.weibo.sdk.a.a(authInfo, sdkListener);
    }
}
