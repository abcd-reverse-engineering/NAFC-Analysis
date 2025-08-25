package com.tencent.bugly.beta.tinker;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerLoadReporter extends DefaultLoadReporter {
    private static final String TAG = "Tinker.TinkerLoadReporter";
    private final LoadReporter userLoadReporter;

    public TinkerLoadReporter(Context context) {
        super(context);
        this.userLoadReporter = TinkerManager.userLoadReporter;
    }

    public void onLoadException(Throwable th, int i2) {
        super.onLoadException(th, i2);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadException(th, i2);
        } else {
            TinkerReport.onLoadException(th, i2);
        }
    }

    public void onLoadFileMd5Mismatch(File file, int i2) {
        super.onLoadFileMd5Mismatch(file, i2);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadFileMd5Mismatch(file, i2);
        } else {
            TinkerReport.onLoadFileMisMatch(i2);
        }
    }

    public void onLoadFileNotFound(File file, int i2, boolean z) {
        File file2;
        super.onLoadFileNotFound(file, i2, z);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadFileNotFound(file, i2, z);
            return;
        }
        TinkerLog.i(TAG, "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[]{file.getAbsolutePath(), Integer.valueOf(i2), Boolean.valueOf(z)});
        if (i2 == 4) {
            Tinker tinkerWith = Tinker.with(this.context);
            if (tinkerWith.isMainProcess() && (file2 = tinkerWith.getTinkerLoadResultIfPresent().patchVersionFile) != null) {
                if (UpgradePatchRetry.getInstance(this.context).onPatchListenerCheck(SharePatchFileUtil.getMD5(file2))) {
                    TinkerLog.i(TAG, "try to repair oat file on patch process", new Object[0]);
                    TinkerInstaller.onReceiveUpgradePatch(this.context, file2.getAbsolutePath());
                } else {
                    TinkerLog.i(TAG, "repair retry exceed must max time, just clean", new Object[0]);
                    checkAndCleanPatch();
                }
            }
        } else {
            checkAndCleanPatch();
        }
        TinkerReport.onLoadFileNotFound(i2);
    }

    public void onLoadInterpret(int i2, Throwable th) {
        super.onLoadInterpret(i2, th);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadInterpret(i2, th);
        } else {
            TinkerReport.onLoadInterpretReport(i2, th);
        }
    }

    public void onLoadPackageCheckFail(File file, int i2) {
        super.onLoadPackageCheckFail(file, i2);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPackageCheckFail(file, i2);
        } else {
            TinkerReport.onLoadPackageCheckFail(i2);
        }
    }

    public void onLoadPatchInfoCorrupted(String str, String str2, File file) {
        super.onLoadPatchInfoCorrupted(str, str2, file);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchInfoCorrupted(str, str2, file);
        } else {
            TinkerReport.onLoadInfoCorrupted();
        }
    }

    public void onLoadPatchListenerReceiveFail(File file, int i2) {
        super.onLoadPatchListenerReceiveFail(file, i2);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchListenerReceiveFail(file, i2);
        } else {
            TinkerReport.onTryApplyFail(i2);
        }
    }

    public void onLoadPatchVersionChanged(String str, String str2, File file, String str3) {
        super.onLoadPatchVersionChanged(str, str2, file, str3);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchVersionChanged(str, str2, file, str3);
        }
    }

    public void onLoadResult(File file, int i2, long j2) {
        super.onLoadResult(file, i2, j2);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadResult(file, i2, j2);
            return;
        }
        if (i2 == 0) {
            TinkerReport.onLoaded(j2);
        }
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.bugly.beta.tinker.TinkerLoadReporter.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (!UpgradePatchRetry.getInstance(TinkerLoadReporter.this.context).onPatchRetryLoad()) {
                    return false;
                }
                TinkerReport.onReportRetryPatch();
                return false;
            }
        });
    }
}
