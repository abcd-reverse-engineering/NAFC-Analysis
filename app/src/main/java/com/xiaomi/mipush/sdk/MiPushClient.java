package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.ae;
import com.xiaomi.push.an;
import com.xiaomi.push.au;
import com.xiaomi.push.bb;
import com.xiaomi.push.cx;
import com.xiaomi.push.dg;
import com.xiaomi.push.dh;
import com.xiaomi.push.dq;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.ed;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gz;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        protected void setResultCode(long j2) {
            this.resultCode = j2;
        }
    }

    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        protected String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j2, String str2, List<String> list) {
        }

        public void onInitializeResult(long j2, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j2, String str, String str2) {
        }

        public void onUnsubscribeResult(long j2, String str, String str2) {
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        protected void setResultCode(long j2) {
            this.resultCode = j2;
        }

        protected void setToken(String str) {
            this.token = str;
        }
    }

    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        com.xiaomi.push.p.a(editorEdit);
    }

    static synchronized void addAccount(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
    }

    static synchronized void addAlias(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putLong("last_pull_notification", System.currentTimeMillis());
        com.xiaomi.push.p.a(editorEdit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.push.p.a(editorEdit);
    }

    static synchronized void addTopic(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    protected static void clearExtras(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            editorEdit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            editorEdit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            editorEdit.remove("topic_" + it3.next());
        }
        editorEdit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        editorEdit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        u.a(context).f();
    }

    public static void clearNotification(Context context, int i2) {
        u.a(context).a(i2);
    }

    public static void disablePush(Context context) {
        u.a(context).a(true);
    }

    public static void enablePush(Context context) {
        u.a(context).a(false);
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m75a(context).m84c()) {
            return b.m75a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.push.j.m630b();
    }

    protected static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, com.umeng.analytics.pro.d.R);
        return e.a(context).b(d.ASSEMBLE_PUSH_FCM);
    }

    protected static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, com.umeng.analytics.pro.d.R);
        return e.a(context).b(d.ASSEMBLE_PUSH_HUAWEI);
    }

    protected static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, com.umeng.analytics.pro.d.R);
        return e.a(context).b(d.ASSEMBLE_PUSH_COS);
    }

    protected static boolean getOpenVIVOPush(Context context) {
        return e.a(context).b(d.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m75a(context).m84c()) {
            return b.m75a(context).m83c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        ds.a(new ds.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.ds.a
            public void uploader(Context context2, gj gjVar) {
                MiTinyDataClient.upload(context2, gjVar);
            }
        });
        Config configA = ds.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a(BuildConfig.VERSION_NAME);
        ClientReportClient.init(context, configA, new dq(context), new dr(context));
        a.a(context);
        k.a(context, configA);
        ah.a(context).a(new ah.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ah.a
            protected void onCallback() {
                ds.m358a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(p.a(sContext).a(v.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(p.a(sContext).a(v.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(p.a(sContext).a(v.UPLOAD_HUAWEI_TOKEN))) {
            u.a(sContext).a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(p.a(sContext).a(v.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(p.a(sContext).a(v.UPLOAD_COS_TOKEN))) {
            u.a(sContext).a((String) null, v.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS, "init");
        }
        if ("syncing".equals(p.a(sContext).a(v.UPLOAD_FTOS_TOKEN))) {
            u.a(context).a((String) null, v.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, gt gtVar) {
        com.xiaomi.channel.commonutils.logger.b.e("re-register reason: " + gtVar);
        String strA = bb.a(6);
        String strM76a = b.m75a(context).m76a();
        String strB = b.m75a(context).b();
        b.m75a(context).m77a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.m75a(context).a(Constants.a());
        b.m75a(context).a(strM76a, strB, strA);
        hf hfVar = new hf();
        hfVar.a(aj.b());
        hfVar.b(strM76a);
        hfVar.e(strB);
        hfVar.f(strA);
        hfVar.d(context.getPackageName());
        hfVar.c(com.xiaomi.push.g.m451a(context, context.getPackageName()));
        hfVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        hfVar.h(BuildConfig.VERSION_NAME);
        hfVar.a(BuildConfig.VERSION_CODE);
        hfVar.a(gtVar);
        int iA = com.xiaomi.push.i.a();
        if (iA >= 0) {
            hfVar.c(iA);
        }
        u.a(context).a(hfVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            com.xiaomi.push.m.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m50a("dynamic register network status receiver failed:" + th);
        }
        au.m146a(sContext);
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    static synchronized void removeAcceptTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        com.xiaomi.push.p.a(editorEdit);
    }

    static synchronized void removeAccount(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
    }

    static synchronized void removeAlias(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
    }

    static synchronized void removeAllAccounts(Context context) {
        Iterator<String> it = getAllUserAccount(context).iterator();
        while (it.hasNext()) {
            removeAccount(context, it.next());
        }
    }

    static synchronized void removeAllAliases(Context context) {
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            removeAlias(context, it.next());
        }
    }

    static synchronized void removeAllTopics(Context context) {
        Iterator<String> it = getAllTopic(context).iterator();
        while (it.hasNext()) {
            removeTopic(context, it.next());
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
    }

    public static void removeWindow(Context context) {
        u.a(context).m126e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m75a(context).m82b()) {
            gp gpVar = z ? gp.APP_SLEEP : gp.APP_WAKEUP;
            he heVar = new he();
            heVar.b(b.m75a(context).m76a());
            heVar.c(gpVar.f597a);
            heVar.d(context.getPackageName());
            heVar.a(aj.a());
            heVar.a(false);
            u.a(context).a((u) heVar, gf.Notification, false, (gs) null, false);
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, gs gsVar, String str2, String str3) {
        he heVar = new he();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        heVar.b(str3);
        heVar.c("bar:click");
        heVar.a(str);
        heVar.a(false);
        u.a(context).a(heVar, gf.Notification, false, true, gsVar, true, str2, str3);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (ah.a(sContext).a(gk.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dg.a().a(new i(context));
            ae.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    dh.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        ae.a(sContext).a(new o(sContext), ah.a(sContext).a(gk.OcVersionCheckFrequency.a(), RemoteMessageConst.DEFAULT_TTL), 5);
    }

    public static void setAcceptTime(Context context, int i2, int i3, int i4, int i5, String str) {
        if (i2 < 0 || i2 >= 24 || i4 < 0 || i4 >= 24 || i3 < 0 || i3 >= 60 || i5 < 0 || i5 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j2 = ((((i2 * 60) + i3) + rawOffset) + 1440) % 1440;
        long j3 = ((((i4 * 60) + i5) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j3 / 60), Long.valueOf(j3 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i2), Integer.valueOf(i3)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i4), Integer.valueOf(i5)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ed.COMMAND_SET_ACCEPT_TIME.f424a, (ArrayList<String>) arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ed.COMMAND_SET_ACCEPT_TIME.f424a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ed.COMMAND_SET_ACCEPT_TIME.f424a, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ed.COMMAND_SET_ALIAS.f424a, str, str2);
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (ed.COMMAND_SET_ALIAS.f424a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ed.COMMAND_SET_ALIAS.f424a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (ed.COMMAND_UNSET_ALIAS.f424a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Don't cancel alias for " + bb.a(arrayList.toString(), 3) + " is unseted");
            return;
        }
        if (ed.COMMAND_SET_ACCOUNT.f424a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < com.heytap.mcssdk.constant.a.f5801e) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ed.COMMAND_SET_ACCOUNT.f424a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (!ed.COMMAND_UNSET_ACCOUNT.f424a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, (ArrayList<String>) arrayList, str3);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("Don't cancel account for " + bb.a(arrayList.toString(), 3) + " is unseted");
    }

    public static void setLocalNotificationType(Context context, int i2) {
        u.a(context).b(i2 & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ed.COMMAND_SET_ACCOUNT.f424a, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > com.heytap.mcssdk.constant.a.r;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return u.a(context).m120a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(b.m75a(context).m76a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ed.COMMAND_SUBSCRIBE_TOPIC.f424a, arrayList, 0L, null, null, null));
            return;
        }
        hj hjVar = new hj();
        String strA = aj.a();
        hjVar.a(strA);
        hjVar.b(b.m75a(context).m76a());
        hjVar.c(str);
        hjVar.d(context.getPackageName());
        hjVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ed.COMMAND_SUBSCRIBE_TOPIC + ", " + strA);
        u.a(context).a((u) hjVar, gf.Subscription, (gs) null);
    }

    @Deprecated
    public static void syncAssembleCOSPushToken(Context context) {
    }

    public static void syncAssembleFCMPushToken(Context context) {
        u.a(context).a((String) null, v.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM, "");
    }

    @Deprecated
    public static void syncAssembleFTOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssemblePushToken(Context context) {
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        f.c(context);
        ah.a(context).a();
        if (b.m75a(context).m82b()) {
            hl hlVar = new hl();
            hlVar.a(aj.a());
            hlVar.b(b.m75a(context).m76a());
            hlVar.c(b.m75a(context).m83c());
            hlVar.e(b.m75a(context).b());
            hlVar.d(context.getPackageName());
            u.a(context).a(hlVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m75a(context).m81b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ed.COMMAND_UNSET_ALIAS.f424a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ed.COMMAND_UNSET_ACCOUNT.f424a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m75a(context).m82b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m50a("Don't cancel subscribe for " + bb.a(str, 3) + " is unsubscribed");
                return;
            }
            hn hnVar = new hn();
            String strA = aj.a();
            hnVar.a(strA);
            hnVar.b(b.m75a(context).m76a());
            hnVar.c(str);
            hnVar.d(context.getPackageName());
            hnVar.e(str2);
            com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ed.COMMAND_UNSUBSCRIBE_TOPIC + ", " + strA);
            u.a(context).a((u) hnVar, gf.UnSubscription, (gs) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.xiaomi.push.j.m632d()) {
                    return;
                }
                if (com.xiaomi.push.i.c(MiPushClient.sContext) != null || an.a(MiPushClient.sContext).mo137a()) {
                    he heVar = new he();
                    heVar.b(b.m75a(MiPushClient.sContext).m76a());
                    heVar.c(gp.ClientInfoUpdate.f597a);
                    heVar.a(aj.a());
                    heVar.a(new HashMap());
                    String str = "";
                    String strC = com.xiaomi.push.i.c(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(strC)) {
                        str = "" + bb.a(strC);
                    }
                    String strE = com.xiaomi.push.i.e(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strE)) {
                        str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + strE;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        heVar.m545a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    an.a(MiPushClient.sContext).a(heVar.m545a());
                    int iA = com.xiaomi.push.i.a();
                    if (iA >= 0) {
                        heVar.m545a().put("space_id", Integer.toString(iA));
                    }
                    u.a(MiPushClient.sContext).a((u) heVar, gf.Notification, false, (gs) null);
                }
            }
        }).start();
    }

    public static void clearNotification(Context context, String str, String str2) {
        u.a(context).a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
            com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 5_9_9-C");
            an.a(context).a();
            cx.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (C0343r.m639a(sContext)) {
                m.a(sContext);
            }
            boolean z = b.m75a(sContext).a() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                u.a(sContext).m117a();
                com.xiaomi.channel.commonutils.logger.b.m50a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !b.m75a(sContext).a(str, str2) || b.m75a(sContext).m87f()) {
                String strA = bb.a(6);
                b.m75a(sContext).m77a();
                b.m75a(sContext).a(Constants.a());
                b.m75a(sContext).a(str, str2, strA);
                MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                hf hfVar = new hf();
                hfVar.a(aj.b());
                hfVar.b(str);
                hfVar.e(str2);
                hfVar.d(sContext.getPackageName());
                hfVar.f(strA);
                hfVar.c(com.xiaomi.push.g.m451a(sContext, sContext.getPackageName()));
                hfVar.b(com.xiaomi.push.g.a(sContext, sContext.getPackageName()));
                hfVar.h(BuildConfig.VERSION_NAME);
                hfVar.a(BuildConfig.VERSION_CODE);
                hfVar.a(gt.Init);
                if (!TextUtils.isEmpty(str3)) {
                    hfVar.g(str3);
                }
                if (!com.xiaomi.push.j.m632d()) {
                    String strD = com.xiaomi.push.i.d(sContext);
                    if (!TextUtils.isEmpty(strD)) {
                        hfVar.i(bb.a(strD) + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.push.i.f(sContext));
                    }
                }
                int iA = com.xiaomi.push.i.a();
                if (iA >= 0) {
                    hfVar.c(iA);
                }
                u.a(sContext).a(hfVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, b.m75a(sContext).m83c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b.m75a(sContext).m83c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ed.COMMAND_REGISTER.f424a, arrayList, 0L, null, null, null));
                }
                u.a(sContext).m117a();
                if (b.m75a(sContext).m79a()) {
                    he heVar = new he();
                    heVar.b(b.m75a(sContext).m76a());
                    heVar.c(gp.ClientInfoUpdate.f597a);
                    heVar.a(aj.a());
                    heVar.f736a = new HashMap();
                    heVar.f736a.put("app_version", com.xiaomi.push.g.m451a(sContext, sContext.getPackageName()));
                    heVar.f736a.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(sContext, sContext.getPackageName())));
                    heVar.f736a.put("push_sdk_vn", BuildConfig.VERSION_NAME);
                    heVar.f736a.put("push_sdk_vc", Integer.toString(BuildConfig.VERSION_CODE));
                    String strE = b.m75a(sContext).e();
                    if (!TextUtils.isEmpty(strE)) {
                        heVar.f736a.put("deviceid", strE);
                    }
                    u.a(sContext).a((u) heVar, gf.Notification, false, (gs) null);
                    u.a(sContext).m118a(sContext);
                }
                if (!com.xiaomi.push.l.m634a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    com.xiaomi.push.l.a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    he heVar2 = new he();
                    heVar2.b(b.m75a(sContext).m76a());
                    heVar2.c(gp.PullOfflineMessage.f597a);
                    heVar2.a(aj.a());
                    heVar2.a(false);
                    u.a(sContext).a((u) heVar2, gf.Notification, false, (gs) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            w.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                com.xiaomi.channel.commonutils.logger.b.a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        gs gsVar = new gs();
        gsVar.a(miPushMessage.getMessageId());
        gsVar.b(miPushMessage.getTopic());
        gsVar.d(miPushMessage.getDescription());
        gsVar.c(miPushMessage.getTitle());
        gsVar.c(miPushMessage.getNotifyId());
        gsVar.a(miPushMessage.getNotifyType());
        gsVar.b(miPushMessage.getPassThrough());
        gsVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), gsVar, null);
    }

    public static void clearNotification(Context context) {
        u.a(context).a(-1);
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, com.umeng.analytics.pro.d.R);
        checkNotNull(str, com.heytap.mcssdk.constant.b.u);
        checkNotNull(str2, "appToken");
        sContext = context.getApplicationContext();
        if (sContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        C0343r.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        e.a(sContext).a(pushConfiguration);
        ae.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    static void reportMessageClicked(Context context, String str, gs gsVar, String str2) {
        he heVar = new he();
        if (TextUtils.isEmpty(str2)) {
            if (b.m75a(context).m82b()) {
                heVar.b(b.m75a(context).m76a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
        } else {
            heVar.b(str2);
        }
        heVar.c("bar:click");
        heVar.a(str);
        heVar.a(false);
        u.a(context).a((u) heVar, gf.Notification, false, gsVar);
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m75a(context).m76a())) {
            return;
        }
        gz gzVar = new gz();
        String strA = aj.a();
        gzVar.a(strA);
        gzVar.b(b.m75a(context).m76a());
        gzVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            gzVar.m520a(it.next());
        }
        gzVar.e(str2);
        gzVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + ", " + strA);
        u.a(context).a((u) gzVar, gf.Command, (gs) null);
    }
}
