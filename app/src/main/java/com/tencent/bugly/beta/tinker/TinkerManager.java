package com.tencent.bugly.beta.tinker;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.bugly.beta.tinker.TinkerUtils;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.library.TinkerLoadLibrary;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerApplicationHelper;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.lang.Thread;
import java.util.HashMap;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerManager {
    public static final String MF_FILE = "YAPATCH.MF";
    public static final String PATCH_DIR = "dex";
    public static final String PATCH_NAME = "patch.apk";
    private static final String TAG = "Tinker.TinkerManager";
    private static boolean isInstalled = false;
    static TinkerPatchResultListener patchResultListener;
    private static Thread.UncaughtExceptionHandler systemExceptionHandler;
    public static TinkerReport tinkerReport;
    private static TinkerUncaughtExceptionHandler uncaughtExceptionHandler;
    static LoadReporter userLoadReporter;
    static PatchListener userPatchListener;
    static PatchReporter userPatchReporter;
    static AbstractPatch userUpgradePatchProcessor;
    private Application application;
    private ApplicationLike applicationLike;
    private TinkerListener tinkerListener;
    private static TinkerManager tinkerManager = new TinkerManager();
    public static String apkOriginalBuildNum = "";
    public static String patchCurBuildNum = "";
    public static boolean patchRestartOnScreenOff = true;

    /* compiled from: BUGLY */
    public interface TinkerListener {
        void onApplyFailure(String str);

        void onApplySuccess(String str);

        void onDownloadFailure(String str);

        void onDownloadSuccess(String str);

        void onPatchRollback();

        void onPatchStart();
    }

    /* compiled from: BUGLY */
    public interface TinkerPatchResultListener {
        void onPatchResult(PatchResult patchResult);
    }

    public static Application getApplication() {
        return getInstance().application;
    }

    public static TinkerManager getInstance() {
        return tinkerManager;
    }

    public static String getNewTinkerId() {
        HashMap packageConfigs = TinkerApplicationHelper.getPackageConfigs(getTinkerApplicationLike());
        return packageConfigs != null ? String.valueOf(packageConfigs.get("NEW_TINKER_ID")).replace("tinker_id_", "") : "";
    }

    public static ApplicationLike getTinkerApplicationLike() {
        return getInstance().applicationLike;
    }

    public static String getTinkerId() {
        if (Tinker.with(getApplication()).isTinkerLoaded()) {
            HashMap packageConfigs = TinkerApplicationHelper.getPackageConfigs(getTinkerApplicationLike());
            return packageConfigs != null ? String.valueOf(packageConfigs.get("TINKER_ID")).replace("tinker_id_", "") : "";
        }
        String manifestTinkerID = ShareTinkerInternals.getManifestTinkerID(getApplication());
        return !TextUtils.isEmpty(manifestTinkerID) ? manifestTinkerID.replace("tinker_id_", "") : "";
    }

    private static void installDefaultTinker(ApplicationLike applicationLike) {
        if (isInstalled) {
            TinkerLog.w(TAG, "install tinker, but has installed, ignore", new Object[0]);
            return;
        }
        if (applicationLike == null) {
            TinkerLog.e(TAG, "Tinker ApplicationLike is null", new Object[0]);
            return;
        }
        getInstance().setTinkerApplicationLike(applicationLike);
        registJavaCrashHandler();
        setUpgradeRetryEnable(true);
        tinkerReport = new TinkerReport();
        TinkerLog.setTinkerLogImp(new TinkerLogger());
        if (TinkerInstaller.install(applicationLike, new TinkerLoadReporter(applicationLike.getApplication()), new TinkerPatchReporter(applicationLike.getApplication()), new TinkerPatchListener(applicationLike.getApplication()), TinkerResultService.class, new UpgradePatch()) != null) {
            isInstalled = true;
        }
    }

    public static void installTinker(Object obj) {
        if (obj == null) {
            TinkerLog.e(TAG, "Tinker ApplicationLike is null", new Object[0]);
        } else if (obj instanceof ApplicationLike) {
            installDefaultTinker((ApplicationLike) obj);
        } else {
            TinkerLog.e(TAG, "NOT tinker ApplicationLike object", new Object[0]);
        }
    }

    public static boolean isPatchRestartOnScreenOff() {
        return patchRestartOnScreenOff;
    }

    public static boolean isTinkerManagerInstalled() {
        return isInstalled;
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerLoadLibrary.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerLoadLibrary.loadArmV7Library(context, str);
    }

    public static boolean loadLibraryFromTinker(Context context, String str, String str2) {
        return TinkerLoadLibrary.loadLibraryFromTinker(context, str, str2);
    }

    public static void registJavaCrashHandler() {
        if (uncaughtExceptionHandler == null) {
            systemExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            uncaughtExceptionHandler = new TinkerUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    public static void setPatchRestartOnScreenOff(boolean z) {
        patchRestartOnScreenOff = z;
    }

    private void setTinkerApplicationLike(ApplicationLike applicationLike) {
        this.applicationLike = applicationLike;
        if (applicationLike != null) {
            this.application = applicationLike.getApplication();
        }
    }

    public static void setUpgradeRetryEnable(boolean z) {
        UpgradePatchRetry.getInstance(getTinkerApplicationLike().getApplication()).setRetryEnable(z);
    }

    public static void unregistJavaCrashHandler() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = systemExceptionHandler;
        if (uncaughtExceptionHandler2 != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler2);
        }
    }

    public void applyPatch(Context context, String str) {
        if (!isInstalled) {
            TinkerLog.w(TAG, "Tinker has not been installed.", new Object[0]);
            return;
        }
        TinkerListener tinkerListener = this.tinkerListener;
        if (tinkerListener != null) {
            tinkerListener.onPatchStart();
        }
        TinkerInstaller.onReceiveUpgradePatch(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkNewPatch(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "To"
            java.lang.String r1 = "From"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "Tinker.TinkerManager"
            java.lang.String r5 = "check if has new patch."
            com.tencent.tinker.lib.util.TinkerLog.d(r4, r5, r3)
            java.lang.String r3 = getTinkerId()
            com.tencent.bugly.beta.tinker.TinkerManager.apkOriginalBuildNum = r3
            java.lang.String r3 = getNewTinkerId()
            com.tencent.bugly.beta.tinker.TinkerManager.patchCurBuildNum = r3
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r5 = 1
            if (r3 == 0) goto L25
            r7 = 0
            r3 = r7
        L23:
            r7 = 0
            goto L32
        L25:
            java.io.File r3 = new java.io.File
            r3.<init>(r7)
            boolean r7 = r3.exists()
            if (r7 != 0) goto L31
            goto L23
        L31:
            r7 = 1
        L32:
            if (r7 == 0) goto L8f
            java.lang.String r7 = "YAPATCH.MF"
            byte[] r7 = com.tencent.bugly.beta.tinker.TinkerUtils.readJarEntry(r3, r7)
            if (r7 != 0) goto L3d
            return r2
        L3d:
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r7)
            java.util.Properties r7 = new java.util.Properties     // Catch: java.lang.Exception -> L87
            r7.<init>()     // Catch: java.lang.Exception -> L87
            r7.load(r3)     // Catch: java.lang.Exception -> L87
            java.lang.String r3 = r7.getProperty(r1)     // Catch: java.lang.Exception -> L87
            if (r3 == 0) goto L7f
            java.lang.String r3 = r7.getProperty(r0)     // Catch: java.lang.Exception -> L87
            if (r3 != 0) goto L57
            goto L7f
        L57:
            java.lang.String r3 = com.tencent.bugly.beta.tinker.TinkerManager.apkOriginalBuildNum     // Catch: java.lang.Exception -> L87
            if (r3 != 0) goto L63
            java.lang.String r7 = "patchCurBuildNum is null"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L87
            com.tencent.tinker.lib.util.TinkerLog.e(r4, r7, r0)     // Catch: java.lang.Exception -> L87
            return r2
        L63:
            java.lang.String r3 = com.tencent.bugly.beta.tinker.TinkerManager.apkOriginalBuildNum     // Catch: java.lang.Exception -> L87
            java.lang.String r1 = r7.getProperty(r1)     // Catch: java.lang.Exception -> L87
            boolean r1 = r3.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L87
            if (r1 == 0) goto L77
            java.lang.String r7 = r7.getProperty(r0)     // Catch: java.lang.Exception -> L87
            com.tencent.bugly.beta.tinker.TinkerManager.patchCurBuildNum = r7     // Catch: java.lang.Exception -> L87
            r2 = 1
            goto L90
        L77:
            java.lang.String r7 = "orign buildno invalid"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L87
            com.tencent.tinker.lib.util.TinkerLog.e(r4, r7, r0)     // Catch: java.lang.Exception -> L87
            goto L90
        L7f:
            java.lang.String r7 = "From/To is null"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L87
            com.tencent.tinker.lib.util.TinkerLog.e(r4, r7, r0)     // Catch: java.lang.Exception -> L87
            return r2
        L87:
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.lang.String r0 = "get properties failed"
            com.tencent.tinker.lib.util.TinkerLog.e(r4, r0, r7)
            goto L90
        L8f:
            r2 = r7
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerManager.checkNewPatch(java.lang.String):boolean");
    }

    public void cleanPatch(boolean z) {
        onPatchRollback(z);
    }

    public File getPatchDirectory(Context context) {
        return SharePatchFileUtil.getPatchDirectory(context);
    }

    public TinkerListener getTinkerListener() {
        return this.tinkerListener;
    }

    public void onApplyFailure(String str) {
        TinkerListener tinkerListener = this.tinkerListener;
        if (tinkerListener != null) {
            tinkerListener.onApplyFailure(str);
        }
    }

    public void onApplySuccess(String str) {
        TinkerListener tinkerListener = this.tinkerListener;
        if (tinkerListener != null) {
            tinkerListener.onApplySuccess(str);
        }
    }

    public void onDownloadFailure(String str) {
        TinkerListener tinkerListener = this.tinkerListener;
        if (tinkerListener != null) {
            tinkerListener.onDownloadFailure(str);
        }
    }

    public void onDownloadSuccess(String str, boolean z) throws Throwable {
        try {
            TinkerLog.d(TAG, "onDownloadSuccess.", new Object[0]);
            if (this.tinkerListener != null) {
                this.tinkerListener.onDownloadSuccess(str);
            }
            applyPatch(str, z);
        } catch (Exception unused) {
            TinkerLog.e(TAG, "apply patch failed", new Object[0]);
        }
    }

    public void onPatchRollback(boolean z) {
        if (!Tinker.with(getApplication()).isTinkerLoaded()) {
            TinkerLog.w("Tinker.PatchRequestCallback", "TinkerPatchRequestCallback: onPatchRollback, tinker is not loaded, just return", new Object[0]);
            return;
        }
        if (z) {
            TinkerLog.i(TAG, "delete patch now", new Object[0]);
            TinkerUtils.rollbackPatch(getApplication());
        } else {
            TinkerLog.i(TAG, "tinker wait screen to restart process", new Object[0]);
            new TinkerUtils.ScreenState(getApplication(), new TinkerUtils.ScreenState.IOnScreenOff() { // from class: com.tencent.bugly.beta.tinker.TinkerManager.1
                @Override // com.tencent.bugly.beta.tinker.TinkerUtils.ScreenState.IOnScreenOff
                public void onScreenOff() {
                    TinkerUtils.rollbackPatch(TinkerManager.getApplication());
                }
            });
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.beta.tinker.TinkerManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (TinkerManager.this.tinkerListener != null) {
                    TinkerManager.this.tinkerListener.onPatchRollback();
                }
            }
        });
    }

    public void setTinkerListener(TinkerListener tinkerListener) {
        this.tinkerListener = tinkerListener;
    }

    public void setTinkerReport(TinkerReport.Reporter reporter) {
        TinkerReport tinkerReport2 = tinkerReport;
        if (tinkerReport2 != null) {
            tinkerReport2.setReporter(reporter);
        }
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        if (obj2 != null) {
            if (obj2 instanceof LoadReporter) {
                userLoadReporter = (LoadReporter) obj2;
            } else {
                TinkerLog.e(TAG, "NOT LoadReporter object", new Object[0]);
                return;
            }
        }
        if (obj3 != null) {
            if (obj3 instanceof PatchReporter) {
                userPatchReporter = (PatchReporter) obj3;
            } else {
                TinkerLog.e(TAG, "NOT PatchReporter object", new Object[0]);
                return;
            }
        }
        if (obj4 != null) {
            if (obj4 instanceof PatchListener) {
                userPatchListener = (PatchListener) obj4;
            } else {
                TinkerLog.e(TAG, "NOT PatchListener object", new Object[0]);
                return;
            }
        }
        if (tinkerPatchResultListener != null) {
            if (tinkerPatchResultListener instanceof TinkerPatchResultListener) {
                patchResultListener = tinkerPatchResultListener;
            } else {
                TinkerLog.e(TAG, "NOT TinkerPatchResultListener object", new Object[0]);
                return;
            }
        }
        if (obj5 != null) {
            if (obj5 instanceof AbstractPatch) {
                userUpgradePatchProcessor = (AbstractPatch) obj5;
            } else {
                TinkerLog.e(TAG, "NOT AbstractPatch object", new Object[0]);
                return;
            }
        }
        installTinker(obj);
    }

    public void applyPatch(String str, boolean z) throws Throwable {
        try {
            File file = new File(this.applicationLike.getApplication().getDir(PATCH_DIR, 0).getAbsolutePath(), PATCH_NAME);
            File file2 = null;
            if (checkNewPatch(str)) {
                TinkerLog.d(TAG, "has new patch.", new Object[0]);
                file2 = new File(str);
                TinkerUtils.copy(file2, file);
            }
            if (!file.exists()) {
                TinkerLog.d(TAG, "patch not exist, just return.", new Object[0]);
            } else {
                if (file2 == null || !z) {
                    return;
                }
                TinkerLog.d(TAG, "starting patch.", new Object[0]);
                applyPatch(this.applicationLike.getApplication(), file2.getAbsolutePath());
            }
        } catch (Exception e2) {
            TinkerLog.e(TAG, e2.getMessage(), new Object[0]);
        }
    }
}
