package com.tencent.bugly.beta;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.upgrade.c;
import com.tencent.bugly.beta.utils.e;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class Beta extends a {
    public static final String TAG_CANCEL_BUTTON = "beta_cancel_button";
    public static final String TAG_CONFIRM_BUTTON = "beta_confirm_button";
    public static final String TAG_IMG_BANNER = "beta_upgrade_banner";
    public static final String TAG_TIP_MESSAGE = "beta_tip_message";
    public static final String TAG_TITLE = "beta_title";
    public static final String TAG_UPGRADE_FEATURE = "beta_upgrade_feature";
    public static final String TAG_UPGRADE_INFO = "beta_upgrade_info";
    public static boolean autoCheckAppUpgrade = false;
    public static boolean autoCheckHotfix = false;
    public static boolean autoCheckUpgrade = true;
    public static boolean autoInit = true;
    public static BetaPatchListener betaPatchListener = null;
    public static int defaultBannerId = 0;
    public static DownloadListener downloadListener = null;
    public static long initDelay = 3000;
    public static String initProcessName = null;
    public static int largeIconId = 0;
    public static boolean showInterruptedStrategy = true;
    public static int smallIconId = 0;
    public static File storageDir = null;
    public static String strNetworkTipsCancelBtn = "取消";
    public static String strNetworkTipsConfirmBtn = "继续下载";
    public static String strNetworkTipsMessage = "你已切换到移动网络，是否继续当前下载？";
    public static String strNetworkTipsTitle = "网络提示";
    public static String strNotificationClickToContinue = "继续下载";
    public static String strNotificationClickToInstall = "点击安装";
    public static String strNotificationClickToRetry = "点击重试";
    public static String strNotificationClickToView = "点击查看";
    public static String strNotificationDownloadError = "下载失败";
    public static String strNotificationDownloadSucc = "下载完成";
    public static String strNotificationDownloading = "正在下载";
    public static String strNotificationHaveNewVersion = "有新版本";
    public static String strToastCheckUpgradeError = "检查新版本失败，请稍后重试";
    public static String strToastCheckingUpgrade = "正在检查，请稍候...";
    public static String strToastYourAreTheLatestVersion = "你已经是最新版了";
    public static String strUpgradeDialogCancelBtn = "下次再说";
    public static String strUpgradeDialogContinueBtn = "继续";
    public static String strUpgradeDialogFeatureLabel = "更新说明";
    public static String strUpgradeDialogFileSizeLabel = "包大小";
    public static String strUpgradeDialogInstallBtn = "安装";
    public static String strUpgradeDialogRetryBtn = "重试";
    public static String strUpgradeDialogUpdateTimeLabel = "更新时间";
    public static String strUpgradeDialogUpgradeBtn = "立即更新";
    public static String strUpgradeDialogVersionLabel = "版本";
    public static int tipsDialogLayoutId;
    public static long upgradeCheckPeriod;
    public static int upgradeDialogLayoutId;
    public static UILifecycleListener<UpgradeInfo> upgradeDialogLifecycleListener;
    public static UpgradeListener upgradeListener;
    public static UpgradeStateListener upgradeStateListener;
    public static List<Class<? extends Activity>> canShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static List<Class<? extends Activity>> canNotShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static boolean enableHotfix = false;
    public static boolean enableNotification = true;
    public static boolean autoDownloadOnWifi = false;
    public static boolean canShowApkInfo = true;
    public static boolean canAutoDownloadPatch = true;
    public static boolean canAutoPatch = true;
    public static String appVersionName = null;
    public static int appVersionCode = Integer.MIN_VALUE;
    public static String appChannel = null;
    public static boolean canNotifyUserRestart = false;
    public static List<String> soBlackList = Collections.synchronizedList(new ArrayList());
    public static boolean dialogFullScreen = false;
    public static boolean autoInstallApk = true;
    public static boolean autoDownloadOn4g = false;
    public static boolean setPatchRestartOnScreenOff = true;
    public static Beta instance = new Beta();

    /* renamed from: a, reason: collision with root package name */
    private static DownloadTask f8762a = null;

    private static void a(boolean z, boolean z2, int i2) {
        try {
            if (z) {
                c.f8860a.a(z, z2, i2);
                if (upgradeStateListener != null) {
                    e.a(new d(18, upgradeStateListener, 2, Boolean.valueOf(z)));
                } else {
                    e.a(new d(5, strToastCheckingUpgrade));
                }
            } else if (i2 == 0 || i2 == 1) {
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy == null || betaGrayStrategy.f8848a == null || System.currentTimeMillis() - betaGrayStrategy.f8852e > com.tencent.bugly.beta.global.e.G.f8793c) {
                    c.f8860a.a(z, z2, i2);
                } else {
                    c.f8860a.a(z, z2, 0, null, "");
                }
            } else if (i2 != 3) {
            } else {
                q.f9424a.a(z, z2, 3);
            }
        } catch (Exception e2) {
            if (an.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void applyDownloadedPatch() throws Throwable {
        if (new File(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath(), true);
        } else {
            an.c(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
        }
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cancelDownload() {
        /*
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.c.f8860a
            com.tencent.bugly.beta.global.d r1 = r0.f8869j
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L25
            java.lang.Object[] r1 = r1.f8790b
            r5 = r1[r4]
            com.tencent.bugly.beta.download.DownloadTask r6 = r0.f8862c
            if (r5 != r6) goto L25
            r5 = r1[r3]
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r0 = r0.f8861b
            if (r5 != r0) goto L25
            r0 = r1[r2]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.tencent.bugly.beta.upgrade.c r1 = com.tencent.bugly.beta.upgrade.c.f8860a
            boolean r1 = r1.f8866g
            if (r0 == r1) goto L43
        L25:
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.c.f8860a
            com.tencent.bugly.beta.global.d r1 = new com.tencent.bugly.beta.global.d
            r5 = 14
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.tencent.bugly.beta.download.DownloadTask r7 = r0.f8862c
            r6[r4] = r7
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r4 = r0.f8861b
            r6[r3] = r4
            boolean r3 = r0.f8866g
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r6[r2] = r3
            r1.<init>(r5, r6)
            r0.f8869j = r1
        L43:
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.c.f8860a
            com.tencent.bugly.beta.global.d r0 = r0.f8869j
            r0.run()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.cancelDownload():void");
    }

    public static void checkAppUpgrade() {
        a(true, false, 1);
    }

    public static void checkHotFix() {
        a(false, false, 3);
    }

    public static void checkUpgrade() {
        checkUpgrade(true, false);
    }

    public static void cleanTinkerPatch(boolean z) {
        com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
        TinkerManager.getInstance().cleanPatch(z);
    }

    public static void downloadPatch() {
        q qVar = q.f9424a;
        qVar.f9425b = qVar.a((y) null);
        try {
            if (q.f9424a.f9425b != null) {
                q.f9424a.a(0, q.f9424a.f9425b.f8848a, true);
            }
        } catch (Exception unused) {
        }
    }

    public static UpgradeInfo getAppUpgradeInfo() {
        try {
            c.f8860a.f8861b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (c.f8860a.f8861b != null) {
                return new UpgradeInfo(c.f8860a.f8861b.f8848a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static UpgradeInfo getHotfixUpgradeInfo() {
        try {
            q.f9424a.f9425b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            if (q.f9424a.f9425b != null) {
                return new UpgradeInfo(q.f9424a.f9425b.f8848a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Beta getInstance() {
        Beta beta = instance;
        beta.id = 1002;
        beta.version = "1.4.5";
        beta.versionKey = "G10";
        return beta;
    }

    public static DownloadTask getStrategyTask() {
        if (f8762a == null) {
            c.f8860a.f8861b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (c.f8860a.f8861b != null) {
                f8762a = com.tencent.bugly.beta.global.e.G.r.a(c.f8860a.f8861b.f8848a.f9480f.f9445b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, c.f8860a.f8861b.f8848a.f9480f.f9444a);
                f8762a.setDownloadType(1);
                c.f8860a.f8862c = f8762a;
            }
        }
        return c.f8860a.f8862c;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d A[Catch: Exception -> 0x0045, TRY_LEAVE, TryCatch #0 {Exception -> 0x0045, blocks: (B:3:0x0001, B:5:0x0017, B:8:0x001d, B:10:0x0021, B:24:0x003d, B:14:0x002c, B:18:0x0033), top: B:28:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.bugly.beta.UpgradeInfo getUpgradeInfo() {
        /*
            r0 = 0
            java.lang.String r1 = "hotfix.strategy.bch"
            android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaGrayStrategy> r2 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR     // Catch: java.lang.Exception -> L45
            android.os.Parcelable r1 = com.tencent.bugly.beta.global.a.a(r1, r2)     // Catch: java.lang.Exception -> L45
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r1 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r1     // Catch: java.lang.Exception -> L45
            java.lang.String r2 = "app.upgrade.strategy.bch"
            android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaGrayStrategy> r3 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR     // Catch: java.lang.Exception -> L45
            android.os.Parcelable r2 = com.tencent.bugly.beta.global.a.a(r2, r3)     // Catch: java.lang.Exception -> L45
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2     // Catch: java.lang.Exception -> L45
            if (r1 == 0) goto L2a
            com.tencent.bugly.proguard.y r3 = r1.f8848a     // Catch: java.lang.Exception -> L45
            if (r3 == 0) goto L2a
            if (r2 == 0) goto L2a
            com.tencent.bugly.proguard.y r3 = r2.f8848a     // Catch: java.lang.Exception -> L45
            if (r3 == 0) goto L2a
            long r3 = r1.f8852e     // Catch: java.lang.Exception -> L45
            long r5 = r2.f8852e     // Catch: java.lang.Exception -> L45
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L3a
            goto L3b
        L2a:
            if (r1 == 0) goto L3a
            com.tencent.bugly.proguard.y r3 = r1.f8848a     // Catch: java.lang.Exception -> L45
            if (r3 != 0) goto L31
            goto L3a
        L31:
            if (r2 == 0) goto L3b
            com.tencent.bugly.proguard.y r2 = r2.f8848a     // Catch: java.lang.Exception -> L45
            if (r2 != 0) goto L38
            goto L3b
        L38:
            r1 = r0
            goto L3b
        L3a:
            r1 = r2
        L3b:
            if (r1 == 0) goto L45
            com.tencent.bugly.beta.UpgradeInfo r2 = new com.tencent.bugly.beta.UpgradeInfo     // Catch: java.lang.Exception -> L45
            com.tencent.bugly.proguard.y r1 = r1.f8848a     // Catch: java.lang.Exception -> L45
            r2.<init>(r1)     // Catch: java.lang.Exception -> L45
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.getUpgradeInfo():com.tencent.bugly.beta.UpgradeInfo");
    }

    public static synchronized y getUpgradeStrategy() {
        c.f8860a.f8861b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
        try {
            if (c.f8860a.f8861b != null) {
                return (y) c.f8860a.f8861b.f8848a.clone();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02dd A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0314 A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0320 A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x042e A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x044b A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x046d A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x049f A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04da A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0116 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0148 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017d A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b2 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f9 A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x022a A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0024, B:7:0x002a, B:11:0x004e, B:13:0x0058, B:16:0x0065, B:18:0x0076, B:20:0x0091, B:22:0x0097, B:24:0x00b2, B:26:0x00b6, B:28:0x00c2, B:32:0x00e4, B:34:0x00e8, B:36:0x00f4, B:40:0x0116, B:42:0x011a, B:44:0x0126, B:48:0x0148, B:50:0x014c, B:52:0x0158, B:56:0x017d, B:58:0x0181, B:60:0x018d, B:64:0x01b2, B:66:0x01b6, B:70:0x01e1, B:72:0x01e5, B:74:0x01ed, B:75:0x01f3, B:77:0x01f9, B:79:0x0201, B:80:0x0207, B:81:0x0212, B:83:0x0216, B:85:0x021e, B:86:0x0224, B:88:0x022a, B:90:0x0232, B:91:0x0238, B:92:0x0243, B:96:0x025c, B:100:0x026e, B:104:0x0280, B:108:0x0296, B:112:0x02ac, B:116:0x02c2, B:120:0x02d4, B:122:0x02dd, B:124:0x02e5, B:126:0x02ed, B:127:0x02fd, B:128:0x0310, B:130:0x0314, B:131:0x0318, B:133:0x0320, B:134:0x032a, B:136:0x041a, B:138:0x0422, B:139:0x0428, B:141:0x042e, B:143:0x0436, B:144:0x043c, B:145:0x0447, B:147:0x044b, B:148:0x045a, B:150:0x046d, B:151:0x0474, B:153:0x048c, B:155:0x0490, B:156:0x049b, B:158:0x049f, B:159:0x04b4, B:161:0x04d0, B:164:0x05fa, B:163:0x04da, B:69:0x01d4, B:63:0x01a5, B:55:0x0170, B:47:0x013b, B:39:0x0109, B:31:0x00d7, B:23:0x009f, B:19:0x007e), top: B:174:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x026c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void init(android.content.Context r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 1577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.init(android.content.Context, boolean):void");
    }

    public static synchronized void installApk(File file) {
        y upgradeStrategy;
        try {
            upgradeStrategy = getUpgradeStrategy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (upgradeStrategy != null && com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.G.u, file, upgradeStrategy.f9480f.f9444a)) {
            p.f9423a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f9479e, upgradeStrategy.f9487m, upgradeStrategy.p, null));
        }
    }

    public static void installTinker() {
        enableHotfix = true;
        installTinker(TinkerApplicationLike.getTinkerPatchApplicationLike());
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerManager.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerManager.loadArmV7Library(context, str);
    }

    public static void loadLibrary(String str) {
        boolean zLoadLibraryFromTinker;
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    if (!com.tencent.bugly.beta.global.a.b("LoadSoFileResult", true)) {
                        System.loadLibrary(str);
                        com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", true);
                        cleanTinkerPatch(true);
                        return;
                    }
                    com.tencent.bugly.beta.global.a.a("LoadSoFileResult", false);
                    String strB = com.tencent.bugly.beta.global.a.b(str, "");
                    boolean zB = com.tencent.bugly.beta.global.a.b("PatchResult", false);
                    if (TextUtils.isEmpty(strB) || !zB) {
                        zLoadLibraryFromTinker = false;
                    } else {
                        zLoadLibraryFromTinker = TinkerManager.loadLibraryFromTinker(eVar.u, "lib/" + strB, str);
                    }
                    if (!zLoadLibraryFromTinker) {
                        System.loadLibrary(str);
                    }
                    com.tencent.bugly.beta.global.a.a("LoadSoFileResult", true);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                com.tencent.bugly.beta.global.a.a("LoadSoFileResult", false);
                return;
            }
        }
        an.e("libName is invalid", new Object[0]);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerManager.loadLibraryFromTinker(context, str, str2);
    }

    public static synchronized void onUpgradeReceived(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, int i6, long j4, String str7, boolean z, boolean z2, int i7, String str8, long j5) {
        HashMap map = new HashMap();
        map.put("IMG_title", str6);
        map.put("VAL_style", String.valueOf(i5));
        c.f8860a.a(z, z2, i7, new y(str, str2, j2, 0, new v(com.tencent.bugly.beta.global.e.G.w, (byte) 1, i4, str3, i3, "", 1L, "", str5, "", ""), new u(str5, str4, "", j3, ""), (byte) i2, i6, j4, null, "", map, str7, 1, j5, 1), str8 == null ? "" : str8);
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        DownloadTask downloadTask;
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
        eVar.s = downloadListener2;
        if (eVar.s == null || (downloadTask = c.f8860a.f8862c) == null) {
            return;
        }
        downloadTask.addListener(downloadListener2);
    }

    public static synchronized void saveInstallEvent(boolean z) {
        try {
            y upgradeStrategy = getUpgradeStrategy();
            if (upgradeStrategy != null && z) {
                com.tencent.bugly.beta.global.a.a("installApkMd5", upgradeStrategy.f9480f.f9444a);
                p.f9423a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f9479e, upgradeStrategy.f9487m, upgradeStrategy.p, null));
                an.a("安装事件保存成功", new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized void showUpgradeDialog(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z) {
        y yVar;
        HashMap map = new HashMap();
        map.put("IMG_title", str6);
        map.put("VAL_style", String.valueOf(i5));
        y yVar2 = new y(str, str2, j2, 0, new v(com.tencent.bugly.beta.global.e.G.w, (byte) 1, i4, str3, i3, "", 1L, "", str5, "1.4.5", ""), new u(str5, str4, "", j3, ""), (byte) i2, 0, 0L, null, "", map, null, 1, System.currentTimeMillis(), 1);
        if (f8762a != null && !f8762a.getDownloadUrl().equals(str4)) {
            f8762a.delete(true);
            f8762a = null;
        }
        if (f8762a == null) {
            yVar = yVar2;
            f8762a = com.tencent.bugly.beta.global.e.G.r.a(yVar.f9480f.f9445b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, yVar.f9480f.f9444a);
            f8762a.setDownloadType(1);
        } else {
            yVar = yVar2;
        }
        f8762a.addListener(downloadListener2);
        h.v.a(yVar, f8762a);
        h.v.r = runnable;
        h.v.s = runnable2;
        f.f8804a.a(com.tencent.bugly.beta.global.e.G.r, yVar.f9486l);
        if (z) {
            f fVar = f.f8804a;
            Object[] objArr = new Object[2];
            objArr[0] = h.v;
            objArr[1] = Boolean.valueOf(yVar.f9481g == 2);
            fVar.a(new d(2, objArr), PathInterpolatorCompat.MAX_NUM_POINTS);
        } else {
            f fVar2 = f.f8804a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = h.v;
            objArr2[1] = Boolean.valueOf(yVar.f9481g == 2);
            fVar2.a(new d(2, objArr2));
        }
    }

    public static DownloadTask startDownload() {
        c cVar = c.f8860a;
        d dVar = cVar.f8868i;
        if (dVar == null || dVar.f8790b[0] != cVar.f8862c) {
            c cVar2 = c.f8860a;
            cVar2.f8868i = new d(13, cVar2.f8862c, cVar2.f8861b);
        }
        c.f8860a.f8868i.run();
        return c.f8860a.f8862c;
    }

    public static void unInit() {
        if (com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false)) {
            com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }

    public static void unregisterDownloadListener() {
        DownloadTask downloadTask = c.f8860a.f8862c;
        if (downloadTask != null) {
            downloadTask.removeListener(com.tencent.bugly.beta.global.e.G.s);
        }
        com.tencent.bugly.beta.global.e.G.s = null;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    @Override // com.tencent.bugly.a
    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0135 A[PHI: r5
  0x0135: PHI (r5v4 android.database.Cursor) = (r5v3 android.database.Cursor), (r5v5 android.database.Cursor) binds: [B:39:0x0133, B:28:0x011a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // com.tencent.bugly.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDbUpgrade(android.database.sqlite.SQLiteDatabase r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.onDbUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    public static void checkAppUpgrade(boolean z, boolean z2) {
        a(z, z2, 1);
    }

    public static void checkUpgrade(boolean z, boolean z2) {
        a(z, z2, 0);
    }

    public static void installTinker(Object obj) {
        enableHotfix = true;
        TinkerManager.setPatchRestartOnScreenOff(setPatchRestartOnScreenOff);
        an.a("setPatchRestartOnScreenOff %s", setPatchRestartOnScreenOff + "");
        TinkerManager.installTinker(obj);
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerManager.TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        enableHotfix = true;
        TinkerManager.installTinker(obj, obj2, obj3, obj4, tinkerPatchResultListener, obj5);
    }

    @Override // com.tencent.bugly.a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        com.tencent.bugly.crashreport.common.info.a.b().c("G10", "1.4.5");
        if (autoInit) {
            init(context, z);
        }
    }
}
