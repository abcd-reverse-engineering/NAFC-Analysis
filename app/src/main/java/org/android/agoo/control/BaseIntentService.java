package org.android.agoo.control;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.t;
import com.taobao.accs.utl.v;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.huawei.HuaweiRcvService;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;
import org.android.agoo.xiaomi.MiPushBroadcastReceiver;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseIntentService extends Service {
    private static final String TAG = "BaseIntentService";
    private static boolean isBinded = false;
    private static final String msgStatus = "4";
    private AgooFactory agooFactory;
    private MessageService messageService;
    private NotifManager notifyManager;
    private Context mContext = null;
    private Messenger messenger = new Messenger(new g(this));

    private final String getTrace(Context context, long j2) {
        String str = TextUtils.isEmpty(null) ? "unknow" : null;
        String str2 = TextUtils.isEmpty(null) ? "unknow" : null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appkey");
        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        stringBuffer.append(j2);
        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        stringBuffer.append(str);
        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0354 A[Catch: Exception -> 0x035f, all -> 0x036c, TRY_LEAVE, TryCatch #8 {Exception -> 0x035f, blocks: (B:110:0x0339, B:112:0x0354), top: B:146:0x0339, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d0 A[Catch: all -> 0x036e, TryCatch #5 {all -> 0x036e, blocks: (B:35:0x00c2, B:37:0x00d0, B:38:0x010d, B:40:0x0136, B:42:0x0140, B:44:0x0152, B:46:0x015c, B:49:0x016e, B:54:0x0186, B:52:0x017d, B:34:0x00a3), top: B:141:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0136 A[Catch: all -> 0x036e, TryCatch #5 {all -> 0x036e, blocks: (B:35:0x00c2, B:37:0x00d0, B:38:0x010d, B:40:0x0136, B:42:0x0140, B:44:0x0152, B:46:0x015c, B:49:0x016e, B:54:0x0186, B:52:0x017d, B:34:0x00a3), top: B:141:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0186 A[Catch: all -> 0x036e, TRY_LEAVE, TryCatch #5 {all -> 0x036e, blocks: (B:35:0x00c2, B:37:0x00d0, B:38:0x010d, B:40:0x0136, B:42:0x0140, B:44:0x0152, B:46:0x015c, B:49:0x016e, B:54:0x0186, B:52:0x017d, B:34:0x00a3), top: B:141:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0205 A[Catch: all -> 0x036c, TryCatch #2 {all -> 0x036c, blocks: (B:68:0x01fd, B:70:0x0205, B:72:0x020d, B:73:0x0230, B:75:0x0238, B:77:0x0240, B:109:0x02f2, B:110:0x0339, B:112:0x0354, B:116:0x0368, B:115:0x0360, B:92:0x0294, B:94:0x029c, B:67:0x01e2), top: B:136:0x01e2, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0238 A[Catch: all -> 0x036c, TryCatch #2 {all -> 0x036c, blocks: (B:68:0x01fd, B:70:0x0205, B:72:0x020d, B:73:0x0230, B:75:0x0238, B:77:0x0240, B:109:0x02f2, B:110:0x0339, B:112:0x0354, B:116:0x0368, B:115:0x0360, B:92:0x0294, B:94:0x029c, B:67:0x01e2), top: B:136:0x01e2, inners: #8 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void handleRemoteMessage(android.content.Context r35, android.content.Intent r36) {
        /*
            Method dump skipped, instructions count: 919
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.BaseIntentService.handleRemoteMessage(android.content.Context, android.content.Intent):void");
    }

    private final void handleRemovePackage(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "handleRemovePackage---->[replacing:" + booleanExtra + "],uninstallPack=" + schemeSpecificPart, new Object[0]);
        }
        if (booleanExtra) {
            return;
        }
        this.notifyManager.doUninstall(schemeSpecificPart, booleanExtra);
    }

    public static void runIntentInService(Context context, Intent intent, String str) {
        try {
            intent.setClassName(context, str);
            context.startService(intent);
        } catch (Throwable th) {
            ALog.w(TAG, "runIntentInService", th, new Object[0]);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        getApplication();
        if (t.b() && v.a(this) && !isBinded) {
            isBinded = true;
            getApplicationContext().bindService(new Intent(getApplication(), getClass()), new i(this), 1);
        }
        return this.messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new j(this));
    }

    protected abstract void onError(Context context, String str);

    protected void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        String agooCommand = IntentUtil.getAgooCommand(this.mContext);
        String thirdPushCommand = IntentUtil.getThirdPushCommand(this.mContext);
        ALog.i(TAG, "onHandleIntent,action=" + action + ",agooCommand=" + agooCommand + ",mipushCommand=" + thirdPushCommand, new Object[0]);
        try {
            if (TextUtils.equals(action, agooCommand)) {
                String stringExtra = intent.getStringExtra("command");
                ALog.d(TAG, "actionCommand --->[" + stringExtra + "]", new Object[0]);
                if (TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_READED) || TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_DELETED)) {
                    onUserCommand(this.mContext, intent);
                }
            } else if (TextUtils.equals(action, thirdPushCommand)) {
                String stringExtra2 = intent.getStringExtra("command");
                String stringExtra3 = intent.getStringExtra(AgooConstants.THIRD_PUSH_ID);
                if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_MIPUSHID_REPORT)) {
                    this.notifyManager.reportThirdPushToken(stringExtra3, MiPushBroadcastReceiver.MI_TOKEN, false);
                } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_HUAWEIPUSHID_REPORT)) {
                    ALog.d(TAG, "HW_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                    this.notifyManager.reportThirdPushToken(stringExtra3, HuaweiRcvService.HUAWEI_TOKEN, false);
                } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_GCMIPUSHID_REPORT)) {
                    ALog.i(TAG, "GCM_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                    this.notifyManager.reportThirdPushToken(stringExtra3, AgooConstants.MESSAGE_SYSTEM_SOURCE_GCM, false);
                }
            } else if (action.equals(AgooConstants.INTENT_FROM_AGOO_MESSAGE)) {
                handleRemoteMessage(this.mContext, intent);
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                handleRemovePackage(this.mContext, intent);
            } else if (TextUtils.equals(action, AgooConstants.INTENT_FROM_AGOO_REPORT) || TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE") || TextUtils.equals(action, "android.intent.action.BOOT_COMPLETED") || TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || TextUtils.equals(action, "android.intent.action.USER_PRESENT") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                try {
                    ALog.i(TAG, "is report cache msg,Config.isReportCacheMsg(mContext)=" + Config.d(this.mContext), new Object[0]);
                    if (Config.d(this.mContext) && UtilityImpl.i(this.mContext)) {
                        Config.e(this.mContext);
                        this.agooFactory.reportCacheMsg();
                        this.messageService.a();
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "is clear all msg=" + Config.b(this.mContext, jCurrentTimeMillis), new Object[0]);
                    }
                    if (Config.b(this.mContext, jCurrentTimeMillis)) {
                        Config.a(this.mContext, jCurrentTimeMillis);
                        this.messageService.a();
                    }
                } catch (Throwable th) {
                    ALog.e(TAG, "reportCacheMsg", th, new Object[0]);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    protected abstract void onMessage(Context context, Intent intent);

    protected abstract void onRegistered(Context context, String str);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        ThreadPoolExecutorFactory.execute(new k(this, intent));
        return 2;
    }

    protected void onUserCommand(Context context, Intent intent) {
    }
}
