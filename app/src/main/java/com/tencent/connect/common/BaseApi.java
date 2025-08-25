package com.tencent.connect.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import anet.channel.strategy.dispatch.DispatchConstants;
import cn.cloudwalk.util.LogUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public abstract class BaseApi {
    public static String businessId = null;
    public static String installChannel = null;
    public static boolean isOEM = false;
    public static String registerChannel;

    /* renamed from: b, reason: collision with root package name */
    protected c f9633b;

    /* renamed from: c, reason: collision with root package name */
    protected QQToken f9634c;

    /* compiled from: ProGuard */
    public class TempRequestListener implements IRequestListener {

        /* renamed from: b, reason: collision with root package name */
        private final IUiListener f9636b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f9637c;

        public TempRequestListener(IUiListener iUiListener) {
            this.f9636b = iUiListener;
            this.f9637c = new Handler(g.a().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.f9636b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.f9636b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message messageObtainMessage = this.f9637c.obtainMessage();
            messageObtainMessage.obj = jSONObject;
            messageObtainMessage.what = 0;
            this.f9637c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message messageObtainMessage = this.f9637c.obtainMessage();
            messageObtainMessage.obj = httpStatusException.getMessage();
            messageObtainMessage.what = -9;
            this.f9637c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message messageObtainMessage = this.f9637c.obtainMessage();
            messageObtainMessage.obj = iOException.getMessage();
            messageObtainMessage.what = -2;
            this.f9637c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message messageObtainMessage = this.f9637c.obtainMessage();
            messageObtainMessage.obj = jSONException.getMessage();
            messageObtainMessage.what = -4;
            this.f9637c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message messageObtainMessage = this.f9637c.obtainMessage();
            messageObtainMessage.obj = malformedURLException.getMessage();
            messageObtainMessage.what = -3;
            this.f9637c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message messageObtainMessage = this.f9637c.obtainMessage();
            messageObtainMessage.obj = networkUnavailableException.getMessage();
            messageObtainMessage.what = -10;
            this.f9637c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message messageObtainMessage = this.f9637c.obtainMessage();
            messageObtainMessage.obj = socketTimeoutException.getMessage();
            messageObtainMessage.what = -8;
            this.f9637c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message messageObtainMessage = this.f9637c.obtainMessage();
            messageObtainMessage.obj = exc.getMessage();
            messageObtainMessage.what = -6;
            this.f9637c.sendMessage(messageObtainMessage);
        }
    }

    public BaseApi(c cVar, QQToken qQToken) {
        this.f9633b = cVar;
        this.f9634c = qQToken;
    }

    protected Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", f.a().c(g.a()));
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", bh.ay);
        QQToken qQToken = this.f9634c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.f9634c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.f9634c.getAppId());
            bundle.putString("openid", this.f9634c.getOpenId());
        }
        SharedPreferences sharedPreferences = g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + DispatchConstants.ANDROID + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f9634c.getAppId());
        if (this.f9634c.isSessionValid()) {
            bundle.putString(Constants.PARAM_KEY_STR, this.f9634c.getAccessToken());
            bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
        }
        String openId = this.f9634c.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + DispatchConstants.ANDROID + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", bh.ay);
        return bundle;
    }

    protected Intent c() {
        Intent intent = new Intent();
        if (m.c(g.a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, "com.tencent.open.agent.AgentActivity");
            if (k.b(g.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
        if (k.b(g.a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, "com.tencent.open.agent.AgentActivity");
        if (k.b(g.a(), intent)) {
            return intent;
        }
        return null;
    }

    public void releaseResource() {
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    protected Intent c(String str) {
        Intent intent = new Intent();
        Intent intentB = b(str);
        if (intentB == null || intentB.getComponent() == null) {
            return null;
        }
        intent.setClassName(intentB.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        Bundle bundleA = a();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            bundleA.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.encodeUrl(bundleA));
        return sb.toString();
    }

    protected Intent b(String str) {
        Intent intent = new Intent();
        if (m.c(g.a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
            if (k.a(g.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (k.a(g.a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, str);
        if (k.a(g.a(), intent)) {
            return intent;
        }
        return null;
    }

    protected void a(StringBuilder sb, Activity activity) {
        if (sb.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(Constants.JumpUrlConstants.URL_KEY_SRC);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(Constants.JumpUrlConstants.SRC_TYPE_APP);
        String appId = this.f9634c.getAppId();
        String openId = this.f9634c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            a(sb, "app_id", appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            a(sb, "open_id", m.k(openId));
        }
        String strA = m.a(activity);
        if (!TextUtils.isEmpty(strA)) {
            if (strA.length() > 20) {
                strA = strA.substring(0, 20) + "...";
            }
            a(sb, "app_name", m.k(strA));
        }
        a(sb, "sdk_version", m.k(Constants.SDK_VERSION));
    }

    protected void a(StringBuilder sb, String str, String str2) {
        sb.append("&");
        sb.append(str);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(m.f(str2));
    }

    private Intent a(Activity activity, Intent intent, Map<String, Object> map, int i2) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        intent2.putExtra("is_login", true);
        a(activity, intent2, intent, i2);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(Constants.KEY_RESTORE_LANDSCAPE)) {
                intent2.putExtra(Constants.KEY_RESTORE_LANDSCAPE, ((Boolean) map.get(Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
            }
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.BaseApi", LogUtils.LOG_EXCEPTION, e2);
        }
        return intent2;
    }

    protected void a(Activity activity, int i2, Intent intent, boolean z) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        a(activity, intent2, intent, i2);
        try {
            activity.startActivityForResult(intent2, i2);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.BaseApi", "startAssistActivity exception", e2);
        }
    }

    protected void a(Activity activity, Intent intent, int i2) {
        a(activity, intent, i2, (Map<String, Object>) null);
    }

    protected void a(Activity activity, Intent intent, int i2, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i2);
        try {
            activity.startActivityForResult(a(activity, intent, map, i2), i2);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.BaseApi", "startAssitActivity exception", e2);
        }
    }

    protected void a(Fragment fragment, Intent intent, int i2, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i2);
        try {
            fragment.startActivityForResult(a(fragment.getActivity(), intent, map, i2), i2);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.BaseApi", "startAssitActivity exception", e2);
        }
    }

    private void a(Activity activity, Intent intent, Intent intent2, int i2) {
        PendingIntent activity2;
        if (intent == null || intent2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 16 && intent2.getClipData() == null) {
                intent2.setClipData(ClipData.newPlainText(null, null));
            }
            int flags = intent2.getFlags();
            if (Build.VERSION.SDK_INT >= 21) {
                intent2.setFlags(flags & (-196));
            } else if (Build.VERSION.SDK_INT >= 19) {
                intent2.setFlags(flags & (-68));
            } else {
                intent2.setFlags(flags & (-4));
            }
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.BaseApi", "setActivityIntent security catch exception", th);
        }
        intent.putExtra(AssistActivity.KEY_REQUEST_ORIENTATION, activity.getRequestedOrientation());
        intent.putExtra(AssistActivity.EXTRA_INTENT, intent2);
        try {
            SLog.i("openSDK_LOG.BaseApi", "setActivityIntent requestCode: " + i2);
            if (Build.VERSION.SDK_INT >= 23) {
                activity2 = PendingIntent.getActivity(activity, i2, intent2, 1140850688);
            } else {
                activity2 = PendingIntent.getActivity(activity, i2, intent2, 1073741824);
            }
            intent.putExtra(AssistActivity.KEY_EXTRA_PENDING_INTENT, activity2);
        } catch (Throwable th2) {
            SLog.e("openSDK_LOG.BaseApi", "setActivityIntent create pendingIntent exception", th2);
        }
    }

    protected void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new TDialog(activity, "", "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.f9634c).show();
    }
}
