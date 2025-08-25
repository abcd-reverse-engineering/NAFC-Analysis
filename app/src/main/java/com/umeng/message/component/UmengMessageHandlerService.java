package com.umeng.message.component;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.j;
import com.umeng.message.proguard.n;
import com.umeng.message.proguard.q;
import com.umeng.message.proguard.u;
import com.umeng.message.proguard.v;
import com.umeng.message.proguard.x;
import com.umeng.message.proguard.y;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class UmengMessageHandlerService extends q {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, String> f11138a = new LruCache<>(3);

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.umeng.message.proguard.q
    public final void onHandleWork(Intent intent) {
        final String stringExtra;
        boolean booleanExtra;
        final UPushRegisterCallback registerCallback;
        UPushMessageHandler messageHandler;
        super.onHandleWork(intent);
        final Application applicationA = x.a();
        if (applicationA == null) {
            UPLog.i("MsgHandlerService", "context null!");
            return;
        }
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        String stringExtra2 = intent.getStringExtra("um_command");
        UPLog.i("MsgHandlerService", "action:", action, stringExtra2);
        if (TextUtils.equals("com.umeng.message.action", action)) {
            if (stringExtra2 == null || stringExtra2.length() == 0) {
                return;
            }
            char c2 = 65535;
            switch (stringExtra2.hashCode()) {
                case -1298848381:
                    if (stringExtra2.equals("enable")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1224577496:
                    if (stringExtra2.equals("handle")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -690213213:
                    if (stringExtra2.equals("register")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3526536:
                    if (stringExtra2.equals("send")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 443595041:
                    if (stringExtra2.equals("third_token")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1671308008:
                    if (stringExtra2.equals("disable")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                try {
                    stringExtra = intent.getStringExtra("registration_id");
                    booleanExtra = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPLog.i("MsgHandlerService", "deviceToken:", stringExtra, "status:", Boolean.valueOf(booleanExtra));
                    registerCallback = u.a().getRegisterCallback();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (booleanExtra) {
                        b.c(new Runnable() { // from class: com.umeng.message.component.UmengMessageHandlerService.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                final String strK = "";
                                try {
                                    MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(applicationA);
                                    strK = messageSharedPrefs.k();
                                    if (stringExtra != null && strK != null && !stringExtra.equals(strK)) {
                                        String str = stringExtra;
                                        if (str == null) {
                                            messageSharedPrefs.f11128b.a(RemoteMessageConst.DEVICE_TOKEN);
                                        } else {
                                            messageSharedPrefs.f11128b.a(RemoteMessageConst.DEVICE_TOKEN, str);
                                        }
                                        Context context = applicationA;
                                        messageSharedPrefs.f11128b.a("has_register");
                                        messageSharedPrefs.f11128b.a(d.p);
                                        messageSharedPrefs.f11128b.a("re_pop_times");
                                        messageSharedPrefs.f11128b.a("re_pop_cfg");
                                        messageSharedPrefs.f11128b.a(SocializeProtocolConstants.TAGS);
                                        messageSharedPrefs.f11128b.a("tag_remain");
                                        messageSharedPrefs.b("tag_add_");
                                        messageSharedPrefs.b("tag_del_");
                                        messageSharedPrefs.b("tag_get_");
                                        messageSharedPrefs.b("alias_del_");
                                        messageSharedPrefs.b("alias_set_");
                                        messageSharedPrefs.b("alias_add_");
                                        try {
                                            context.getContentResolver().delete(h.b(context), null, null);
                                        } catch (Throwable th2) {
                                            UPLog.e("Prefs", th2);
                                        }
                                    }
                                } catch (Throwable th3) {
                                    UPLog.e("MsgHandlerService", th3);
                                }
                                try {
                                    if (registerCallback != null) {
                                        registerCallback.onSuccess(stringExtra);
                                    }
                                } catch (Throwable th4) {
                                    UPLog.e("MsgHandlerService", th4);
                                }
                                final y yVarA = y.a();
                                if (!y.c()) {
                                    final MessageSharedPrefs messageSharedPrefs2 = MessageSharedPrefs.getInstance(x.a());
                                    if (!messageSharedPrefs2.f11128b.b("has_register", false) && !y.f11462b) {
                                        y.f11462b = true;
                                        b.c(new Runnable() { // from class: com.umeng.message.proguard.y.3

                                            /* renamed from: a */
                                            final /* synthetic */ String f11471a;

                                            /* renamed from: b */
                                            final /* synthetic */ MessageSharedPrefs f11472b;

                                            public AnonymousClass3(final String strK2, final MessageSharedPrefs messageSharedPrefs22) {
                                                str = strK2;
                                                messageSharedPrefs = messageSharedPrefs22;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                try {
                                                    y.this.f11464d.a(str);
                                                    UPLog.d("Track", "trackRegister deviceToken:", messageSharedPrefs.k());
                                                } catch (Throwable th5) {
                                                    UPLog.e("Track", th5);
                                                    y.f11462b = false;
                                                }
                                            }
                                        });
                                    }
                                }
                                u.a().onAppStart();
                                n.a();
                            }
                        });
                        return;
                    } else {
                        if (registerCallback != null) {
                            registerCallback.onFailure(intent.getStringExtra("code"), intent.getStringExtra(SocialConstants.PARAM_APP_DESC));
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    UPLog.e("MsgHandlerService", th);
                    return;
                }
            }
            if (c2 == 1) {
                try {
                    boolean booleanExtra2 = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPushSettingCallback settingCallback = u.a().getSettingCallback();
                    UPLog.i("MsgHandlerService", "push open status:".concat(String.valueOf(booleanExtra2)));
                    if (booleanExtra2) {
                        if (settingCallback != null) {
                            settingCallback.onSuccess();
                            return;
                        }
                        return;
                    } else {
                        if (settingCallback != null) {
                            settingCallback.onFailure(intent.getStringExtra("code"), intent.getStringExtra(SocialConstants.PARAM_APP_DESC));
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    UPLog.e("MsgHandlerService", th3);
                    return;
                }
            }
            if (c2 == 2) {
                try {
                    boolean booleanExtra3 = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPushSettingCallback settingCallback2 = u.a().getSettingCallback();
                    UPLog.i("MsgHandlerService", "push close status:".concat(String.valueOf(booleanExtra3)));
                    if (booleanExtra3) {
                        if (settingCallback2 != null) {
                            settingCallback2.onSuccess();
                            return;
                        }
                        return;
                    } else {
                        if (settingCallback2 != null) {
                            settingCallback2.onFailure(intent.getStringExtra("code"), intent.getStringExtra(SocialConstants.PARAM_APP_DESC));
                            return;
                        }
                        return;
                    }
                } catch (Throwable th4) {
                    UPLog.e("MsgHandlerService", th4);
                    return;
                }
            }
            if (c2 == 3) {
                try {
                    String stringExtra3 = intent.getStringExtra("body");
                    if (stringExtra3 == null) {
                        return;
                    }
                    UMessage uMessage = new UMessage(new JSONObject(stringExtra3));
                    if (("notification".equals(uMessage.getDisplayType()) && uMessage.hasResourceFromInternet() && j.a().a(intent)) || (messageHandler = u.a().getMessageHandler()) == null) {
                        return;
                    }
                    messageHandler.handleMessage(applicationA, uMessage);
                    return;
                } catch (Throwable th5) {
                    UPLog.e("MsgHandlerService", th5);
                    return;
                }
            }
            if (c2 == 4) {
                try {
                    String stringExtra4 = intent.getStringExtra("send_message");
                    if (stringExtra4 == null) {
                        return;
                    }
                    String stringExtra5 = intent.getStringExtra("um_px_path");
                    JSONObject jSONObject = new JSONObject(stringExtra4);
                    jSONObject.put("um_px_path", stringExtra5);
                    UMWorkDispatch.sendEvent(applicationA, 16388, v.a(), jSONObject.toString());
                    return;
                } catch (Throwable th6) {
                    UPLog.e("MsgHandlerService", th6);
                    return;
                }
            }
            if (c2 != 5) {
                return;
            }
            try {
                String stringExtra6 = intent.getStringExtra("third_token");
                String strA = f.a(intent.getStringExtra("type"));
                if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(stringExtra6)) {
                    if (TextUtils.equals(f11138a.get(strA), stringExtra6)) {
                        UPLog.i("MsgHandlerService", "third push callback skipped! already called.");
                        return;
                    }
                    UPLog.i("MsgHandlerService", "third push type:", strA, "token:", stringExtra6);
                    UPushThirdTokenCallback thirdTokenCallback = u.a().getThirdTokenCallback();
                    if (thirdTokenCallback != null) {
                        thirdTokenCallback.onToken(strA, stringExtra6);
                    } else {
                        String pushIntentServiceClass = u.a().getPushIntentServiceClass();
                        if (!TextUtils.isEmpty(pushIntentServiceClass)) {
                            Class<?> cls = Class.forName(pushIntentServiceClass);
                            Intent intent2 = new Intent();
                            intent2.setPackage(applicationA.getPackageName());
                            intent2.putExtra("um_command", "third_token");
                            intent2.putExtra("third_token", stringExtra6);
                            intent2.putExtra("type", strA);
                            intent2.setClass(applicationA, cls);
                            q.enqueueWork(applicationA, cls, intent2);
                        }
                    }
                    f11138a.put(strA, stringExtra6);
                    return;
                }
                UPLog.i("MsgHandlerService", "third push skipped! type:", strA, "token:", stringExtra6);
            } catch (Throwable th7) {
                UPLog.e("MsgHandlerService", th7);
            }
        }
    }
}
