package org.android.agoo.vivo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.android.agoo.control.NotifManager;

/* loaded from: classes2.dex */
public class VivoRegister {
    public static final String TAG = "VivoRegister";
    public static final String VERSION = "2.1.0";

    public class a implements IPushActionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17359a;

        /* renamed from: org.android.agoo.vivo.VivoRegister$a$a, reason: collision with other inner class name */
        public class C0276a implements IPushQueryActionListener {
            public C0276a() {
            }

            @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
            public void onFail(Integer num) {
            }

            @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
            public void onSuccess(String str) {
                String str2 = str;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    NotifManager notifManager = new NotifManager();
                    notifManager.init(a.this.f17359a);
                    notifManager.reportThirdPushToken(str2, PushMessageReceiverImpl.VIVO_TOKEN, "2.0.0", true);
                } catch (Throwable th) {
                    ALog.e(VivoRegister.TAG, "report token failed:", th, new Object[0]);
                }
            }
        }

        public a(Context context) {
            this.f17359a = context;
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i2) {
            ALog.i(VivoRegister.TAG, "turnOnPush", "state", Integer.valueOf(i2));
            if (i2 == 0) {
                VivoRegister.getToken(this.f17359a, new C0276a());
            }
        }
    }

    public class b implements IPushQueryActionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IPushQueryActionListener f17361a;

        public b(IPushQueryActionListener iPushQueryActionListener) {
            this.f17361a = iPushQueryActionListener;
        }

        @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onFail(Integer num) {
            ALog.e(VivoRegister.TAG, "getToken failed, code", num);
            IPushQueryActionListener iPushQueryActionListener = this.f17361a;
            if (iPushQueryActionListener != null) {
                iPushQueryActionListener.onFail(num);
            }
        }

        @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            ALog.e(VivoRegister.TAG, "getToken regId", str);
            IPushQueryActionListener iPushQueryActionListener = this.f17361a;
            if (iPushQueryActionListener != null) {
                iPushQueryActionListener.onSuccess(str);
            }
        }
    }

    public class c implements IPushActionListener {
        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i2) {
            ALog.i(VivoRegister.TAG, "turnOffPush", "state", Integer.valueOf(i2));
        }
    }

    public static void getToken(Context context, IPushQueryActionListener iPushQueryActionListener) {
        try {
            PushClient.getInstance(context).getRegId(new b(iPushQueryActionListener));
        } catch (Throwable th) {
            ALog.e(TAG, "getToken failed:", th, new Object[0]);
        }
    }

    public static void register(Context context) {
        if (context == null) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (!UtilityImpl.isMainProcess(applicationContext)) {
                ALog.i(TAG, "not in main process, skipped.", new Object[0]);
                return;
            }
            if (!PushClient.getInstance(applicationContext).isSupport()) {
                ALog.i(TAG, "device check, skipped.", new Object[0]);
                return;
            }
            ALog.i(TAG, "ver:", "2.1.0");
            ALog.i(TAG, "register start", new Object[0]);
            BaseNotifyClickActivity.addNotifyListener(new VivoMsgParseImpl());
            PushClient.getInstance(applicationContext).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());
            PushClient.getInstance(applicationContext).turnOnPush(new a(applicationContext));
        } catch (Throwable th) {
            ALog.e(TAG, "register failed:", th, new Object[0]);
        }
    }

    public static void unregister(Context context) {
        try {
            ALog.i(TAG, MiPushClient.COMMAND_UNREGISTER, new Object[0]);
            PushClient.getInstance(context).turnOffPush(new c());
        } catch (Throwable th) {
            ALog.e(TAG, "unregister failed:", th, new Object[0]);
        }
    }
}
