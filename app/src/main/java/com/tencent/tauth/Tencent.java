package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.api.QQAuthManage;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.commonchannel.CommonChannelApi;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.b.b;
import com.tencent.open.im.IM;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    public static boolean USE_ONE_HOUR = false;

    /* renamed from: c, reason: collision with root package name */
    private static Tencent f9958c = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f9959d = false;
    public static boolean disableResetOrientation = false;

    /* renamed from: a, reason: collision with root package name */
    private final c f9960a;

    /* renamed from: b, reason: collision with root package name */
    private String f9961b;

    private Tencent(String str, Context context) {
        this.f9960a = c.a(str, context);
        b.a().a(str, context);
        f.a().a(context);
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.Tencent", "checkManifestConfig exception", th);
        }
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
            return true;
        } catch (PackageManager.NameNotFoundException unused2) {
            SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
            return false;
        } catch (Throwable th2) {
            SLog.e("openSDK_LOG.Tencent", "checkManifestConfig exception", th2);
            return true;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        Tencent tencentCreateInstance;
        tencentCreateInstance = createInstance(str, context);
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
        a("createInstance_authority", "appid", str, "authorities", str2);
        if (tencentCreateInstance != null) {
            tencentCreateInstance.f9961b = str2;
        } else {
            SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
        }
        return tencentCreateInstance;
    }

    public static synchronized String getAuthorities(String str) {
        a("getAuthorities", "appid", str);
        if (TextUtils.isEmpty(str)) {
            SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
            return null;
        }
        if (f9958c != null) {
            return str.equals(f9958c.getAppId()) ? f9958c.f9961b : "";
        }
        SLog.i("openSDK_LOG.Tencent", "sInstance == null");
        return null;
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("handleResultData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean isPermissionNotGranted() {
        return !f9959d || TextUtils.isEmpty(f.a().b());
    }

    public static boolean isSupportPushToQZone(Context context) {
        boolean z = k.c(context, "5.9.5") >= 0;
        SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z);
        a("isSupportPushToQZone", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSupportShareToQQ(Context context) {
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z = true;
        if (m.c(context) && k.a(context, Constants.PACKAGE_QQ_PAD) != null) {
            a("isSupportShareToQQ", (Object) true);
            return true;
        }
        if (k.c(context, "4.1") < 0 && k.a(context, Constants.PACKAGE_TIM) == null) {
            z = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z);
        a("isSupportShareToQQ", Boolean.valueOf(z));
        return z;
    }

    public static boolean onActivityResultData(int i2, int i3, Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i2);
        sb.append(", resultcode = ");
        sb.append(i3);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("onActivityResultData", "requestCode", Integer.valueOf(i2), com.taobao.agoo.a.a.b.JSON_ERRORCODE, Integer.valueOf(i3));
        return UIListenerManager.getInstance().onActivityResult(i2, i3, intent, iUiListener);
    }

    public static Map<String, String> parseMiniParameters(Intent intent) {
        String stringExtra;
        a("parseMiniParameters", new Object[0]);
        HashMap map = new HashMap();
        if (intent == null) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return map;
        }
        try {
            stringExtra = intent.getStringExtra("appParameter");
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e2);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        }
        Uri data = intent.getData();
        if (data == null) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
            return map;
        }
        String string = data.toString();
        if (TextUtils.isEmpty(string)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
            return map;
        }
        String strSubstring = string.substring(string.lastIndexOf(63) + 1);
        if (TextUtils.isEmpty(strSubstring)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
            return map;
        }
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + strSubstring);
        for (String str : strSubstring.split("&")) {
            String[] strArrSplit = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (strArrSplit.length == 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map;
    }

    public static void resetQQAppInfoCache() {
        k.a("com.tencent.mobileqq");
    }

    public static void resetTargetAppInfoCache() {
        k.a();
    }

    public static void resetTimAppInfoCache() {
        k.a(Constants.PACKAGE_TIM);
    }

    public static void setCustomLogger(Tracer tracer) {
        SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        a("setCustomLogger", new Object[0]);
        SLog.getInstance().setCustomLogger(tracer);
    }

    public static void setIsPermissionGranted(boolean z) {
        String strB;
        SLog.i("openSDK_LOG.Tencent", "setIsPermissionGranted, isPermissionGranted: " + z);
        if (z) {
            f.a().a(g.a());
            strB = f.a().b();
            if (strB == null || strB.isEmpty()) {
                strB = Build.MODEL;
            }
        } else {
            strB = "";
        }
        setIsPermissionGranted(z, strB);
    }

    public void bindQQGroup(Activity activity, String str, String str2, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "bindQQGroup()");
        a("bindQQGroup", "organizationId", str, "organizationName", str2);
        new SocialOperation(getQQToken()).bindQQGroup(activity, str, str2, iUiListener);
    }

    public void callCommonChannelApi(Activity activity, Bundle bundle, IUiListener iUiListener) {
        c cVar = this.f9960a;
        SLog.i("openSDK_LOG.Tencent", "callCommonChannelApi ret: " + new CommonChannelApi(cVar, cVar.b()).launchQQ(activity, bundle, iUiListener));
    }

    public void checkLogin(IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        a("checkLogin", new Object[0]);
        this.f9960a.a(iUiListener);
    }

    public String getAccessToken() {
        String accessToken = this.f9960a.b().getAccessToken();
        SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
        a("getAccessToken", new Object[0]);
        return accessToken;
    }

    public String getAppId() {
        String appId = this.f9960a.b().getAppId();
        SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        a("getAppId", appId);
        return appId;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.f9960a.b().getExpireTimeInSecond();
        SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        a("getExpiresIn", Long.valueOf(expireTimeInSecond));
        return expireTimeInSecond;
    }

    public String getOpenId() {
        String openId = this.f9960a.b().getOpenId();
        SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        a("getOpenId", new Object[0]);
        return openId;
    }

    public QQToken getQQToken() {
        SLog.i("openSDK_LOG.Tencent", "getQQToken()");
        a("getQQToken", new Object[0]);
        return this.f9960a.b();
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("handleLoginData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(JSONObject jSONObject) throws JSONException {
        a("initSessionCache", new Object[0]);
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            SLog.i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (Exception e2) {
            SLog.i("QQToken", "initSessionCache " + e2.toString());
        }
    }

    public boolean isQQInstalled(Context context) {
        boolean zB = k.b(context);
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + zB);
        a("isQQInstalled", Boolean.valueOf(zB));
        return zB;
    }

    public boolean isReady() {
        boolean z = isSessionValid() && getOpenId() != null;
        SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + z);
        a("isReady", Boolean.valueOf(z));
        return z;
    }

    public boolean isSessionValid() {
        boolean zC = this.f9960a.c();
        SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + zC);
        a("isSessionValid", Boolean.valueOf(zC));
        return zC;
    }

    public boolean isSupportSSOLogin(Activity activity) {
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z = true;
        if (m.c(activity) && k.a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
            a("isSupportSSOLogin", (Object) true);
            return true;
        }
        if (k.c(activity, "4.1") < 0 && k.d(activity, "1.1") < 0) {
            z = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z);
        a("isSupportSSOLogin", Boolean.valueOf(z));
        return z;
    }

    public void joinQQGroup(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "joinQQGroup()");
        a("joinQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).joinGroup(activity, str, iUiListener);
    }

    public JSONObject loadSession(String str) {
        JSONObject jSONObjectLoadSession = this.f9960a.b().loadSession(str);
        StringBuilder sb = new StringBuilder();
        sb.append("loadSession() appid ");
        sb.append(str);
        sb.append(", length=");
        sb.append(jSONObjectLoadSession != null ? jSONObjectLoadSession.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("loadSession", "appid", str);
        return jSONObjectLoadSession;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        a("login_scope", Constants.PARAM_SCOPE, str);
        return this.f9960a.a(activity, str, iUiListener);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        a("loginServerSide_activity", Constants.PARAM_SCOPE, str);
        return this.f9960a.a(activity, str + ",server_side", iUiListener);
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        a("loginWithOEM", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z), "registerChannel", str2, "installChannel", str3, com.taobao.accs.common.Constants.KEY_BUSINESSID, str4);
        return this.f9960a.a(activity, str, iUiListener, z, str2, str3, str4);
    }

    public void logout(Context context) throws NumberFormatException {
        SLog.i("openSDK_LOG.Tencent", "logout()");
        a("logout", new Object[0]);
        this.f9960a.b().setAccessToken(null, "0");
        this.f9960a.b().setOpenId(null);
        this.f9960a.b().removeSession(this.f9960a.b().getAppId());
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        a("publishToQzone", new Object[0]);
        new QzonePublish(activity, this.f9960a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        a("reAuth", Constants.PARAM_SCOPE, str);
        return this.f9960a.b(activity, str, iUiListener);
    }

    public void reportDAU() {
        SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        a("reportDAU", new Object[0]);
        this.f9960a.a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws JSONException, IOException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.i("openSDK_LOG.Tencent", "request()");
        a(SocialConstants.TYPE_REQUEST, "graphPath", str, "httpMethod", str2);
        return HttpUtils.request(this.f9960a.b(), g.a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        a("requestAsync", "graphPath", str, "httpMethod", str2);
        HttpUtils.requestAsync(this.f9960a.b(), g.a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveSession() length=");
        sb.append(jSONObject != null ? jSONObject.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("saveSession", new Object[0]);
        this.f9960a.b().saveSession(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        a("setAccessToken", new Object[0]);
        this.f9960a.a(str, str2);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar", new Object[0]);
        String string = bundle.getString("picture");
        new QQAvatar(this.f9960a.b()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        a("setAvatarByQQ", new Object[0]);
        new QQAvatar(this.f9960a.b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        a("setDynamicAvatar", new Object[0]);
        new QQAvatar(this.f9960a.b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        a("setEmotions", new Object[0]);
        new QQEmotion(this.f9960a.b()).setEmotions(activity, arrayList, iUiListener);
    }

    public void setOpenId(String str) {
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        a("setOpenId", new Object[0]);
        this.f9960a.b(g.a(), str);
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        a("shareToQQ", new Object[0]);
        if (TextUtils.isEmpty(this.f9961b)) {
            iUiListener.onWarning(-19);
        }
        new QQShare(activity, this.f9960a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        a("shareToQzone", new Object[0]);
        new QzoneShare(activity, this.f9960a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public void startAuthManagePage(Activity activity, IApiCallback iApiCallback) {
        SLog.i("openSDK_LOG.Tencent", "startAuthManagePage");
        new QQAuthManage(this.f9960a, getQQToken()).gotoManagePage(activity, iApiCallback);
    }

    public int startIMAio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        a("startIMAio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        a("startIMAudio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        a("startIMConversation", "chatType", str, "uin", str2, Constants.PARAM_PKG_NAME, str3);
        return new IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        a("startIMVideo", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        a("startMiniApp", "miniAppId", str, "miniAppPath", str2, "miniAppVersion", str3);
        return new MiniApp(getQQToken()).startMiniApp(activity, MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
    }

    public void unBindQQGroup(Context context, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "unBindQQGroup()");
        a("unBindQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).unBindGroup(context, str, iUiListener);
    }

    public boolean isQQInstalled(Context context, String str) {
        boolean z = k.c(context, str) >= 0;
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled version[" + str + "] = " + z);
        return z;
    }

    public int login(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.Tencent", "login activity with params");
        a("login_param", new Object[0]);
        return this.f9960a.a(activity, iUiListener, map);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        a("loginServerSide_fragment", Constants.PARAM_SCOPE, str);
        return this.f9960a.a(fragment, str + ",server_side", iUiListener, "");
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        g.a(context.getApplicationContext());
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
        if (TextUtils.isEmpty(str)) {
            SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");
            return null;
        }
        if (f9958c == null) {
            f9958c = new Tencent(str, context);
        } else if (!str.equals(f9958c.getAppId())) {
            f9958c.logout(context);
            f9958c = new Tencent(str, context);
        }
        if (!a(context, str)) {
            return null;
        }
        a("createInstance", "appid", str);
        com.tencent.open.a.f.a().a(i.a(context, str));
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
        return f9958c;
    }

    public static void setIsPermissionGranted(boolean z, String str) {
        SLog.i("openSDK_LOG.Tencent", "setIsPermissionGranted, isPermissionGranted: " + z + ", model = " + str);
        String str2 = null;
        if (z) {
            if (str == null || str.trim().isEmpty()) {
                SLog.e("openSDK_LOG.Tencent", "setIsPermissionGranted error! model= [" + str + "]");
                z = false;
            } else {
                str2 = str;
            }
        }
        f9959d = z;
        f.a().a(g.a(), str2);
    }

    public int login(Activity activity, String str, IUiListener iUiListener, boolean z) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        a("login_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z));
        return this.f9960a.a(activity, str, iUiListener, z);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i2, int i3) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar_anim", new Object[0]);
        bundle.putInt("exitAnim", i3);
        activity.overridePendingTransition(i2, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        a("login_fragment_scope", Constants.PARAM_SCOPE, str);
        return this.f9960a.a(fragment, str, iUiListener, "");
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, boolean z) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        a("login_fragment_scope_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z));
        return this.f9960a.a(fragment, str, iUiListener, "", z);
    }

    private static void a(String str, Object... objArr) {
        b.a().a(str, a(objArr));
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0 || objArr.length % 2 != 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2 += 2) {
            if (i2 > 0) {
                sb.append('|');
            }
            sb.append(objArr[i2]);
            sb.append(':');
            sb.append(objArr[i2 + 1]);
        }
        return sb.toString();
    }

    private static void a(String str, Object obj) {
        b.a().a(str, obj);
    }
}
