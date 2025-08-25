package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class SocialApiIml extends BaseApi {

    /* renamed from: a, reason: collision with root package name */
    private Activity f9716a;

    /* compiled from: ProGuard */
    private class a extends DefaultUiListener {

        /* renamed from: b, reason: collision with root package name */
        private IUiListener f9718b;

        /* renamed from: c, reason: collision with root package name */
        private String f9719c;

        /* renamed from: d, reason: collision with root package name */
        private String f9720d;

        /* renamed from: e, reason: collision with root package name */
        private Bundle f9721e;

        /* renamed from: f, reason: collision with root package name */
        private Activity f9722f;

        a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.f9718b = iUiListener;
            this.f9719c = str;
            this.f9720d = str2;
            this.f9721e = bundle;
            this.f9722f = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f9718b.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) throws JSONException, NoSuchAlgorithmException {
            String string;
            try {
                string = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e2) {
                e2.printStackTrace();
                SLog.e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e2);
                string = null;
            }
            this.f9721e.putString("encrytoken", string);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a((Context) socialApiIml.f9716a, this.f9719c, this.f9721e, this.f9720d, this.f9718b);
            if (TextUtils.isEmpty(string)) {
                SLog.d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f9722f);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.f9718b.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    @Override // com.tencent.connect.common.BaseApi
    protected Intent b(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
        if (m.c(g.a()) && k.a(g.a(), intent)) {
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        if (k.a(g.a(), intent2) && k.c(g.a(), "4.7") >= 0) {
            return intent2;
        }
        Intent intent3 = new Intent();
        intent3.setClassName(Constants.PACKAGE_QZONE, str);
        if (k.a(g.a(), intent3) && k.a(k.a(g.a(), Constants.PACKAGE_QZONE), "4.2") >= 0 && k.a(g.a(), intent3.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
            return intent3;
        }
        return null;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        this.f9716a = activity;
        Intent intentC = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (intentC == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            intentC = c(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(b());
        a(activity, intentC, SocialConstants.ACTION_INVITE, bundle, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        this.f9716a = activity;
        Intent intentC = c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(b());
        a(activity, intentC, SocialConstants.ACTION_STORY, bundle, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) throws NoSuchAlgorithmException {
        String strG;
        String accessToken = this.f9634c.getAccessToken();
        String appId = this.f9634c.getAppId();
        String openId = this.f9634c.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            strG = null;
        } else {
            strG = m.g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        com.tencent.open.web.a.a(bVar);
        String str = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f9634c.getOpenId() + c.c.a.b.a.a.s1 + this.f9634c.getAppId() + "\"]=\"" + strG + "\";</script></head><body></body></html>";
        String strA = j.a().a(context, "https://imgcache.qq.com");
        bVar.loadDataWithBaseURL(strA, str, "text/html", "utf-8", strA);
    }

    public SocialApiIml(com.tencent.connect.auth.c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        this.f9716a = activity;
        Intent intentC = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (intentC == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            intentC = c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = intentC;
        bundle.putAll(b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_REQUEST);
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        a(activity, intent, str, bundle, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) throws JSONException, NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        boolean z2 = true;
        sb.append(intent == null);
        SLog.i("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        i iVarA = i.a(g.a(), this.f9634c.getAppId());
        if (!z && !iVarA.b("C_LoginH5")) {
            z2 = false;
        }
        if (z2) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        a(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent intentC = c();
        IUiListener aVar = new a(activity, iUiListener, str, str2, bundle);
        Intent intentB = b("com.tencent.open.agent.EncryTokenActivity");
        if (intentB != null && intentC != null && intentC.getComponent() != null && intentB.getComponent() != null && intentC.getComponent().getPackageName().equals(intentB.getComponent().getPackageName())) {
            intentB.putExtra("oauth_consumer_key", this.f9634c.getAppId());
            intentB.putExtra("openid", this.f9634c.getOpenId());
            intentB.putExtra("access_token", this.f9634c.getAccessToken());
            intentB.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, aVar);
            a(activity, intentB, Constants.REQUEST_SOCIAL_H5);
            return;
        }
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String strG = m.g("tencent&sdk&qazxc***14969%%" + this.f9634c.getAccessToken() + this.f9634c.getAppId() + this.f9634c.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, strG);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aVar.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.f9634c.getAppId());
        if (this.f9634c.isSessionValid()) {
            bundle.putString("access_token", this.f9634c.getAccessToken());
        }
        String openId = this.f9634c.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString("pf", g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
        } catch (Exception e2) {
            e2.printStackTrace();
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            new TDialog(this.f9716a, str, str3, iUiListener, this.f9634c).show();
        } else {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new d(this.f9716a, str, str3, iUiListener, this.f9634c).show();
        }
    }
}
