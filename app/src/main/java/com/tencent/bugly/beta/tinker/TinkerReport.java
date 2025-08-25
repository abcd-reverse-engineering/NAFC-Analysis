package com.tencent.bugly.beta.tinker;

import com.heytap.mcssdk.constant.a;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerReport {
    public static final int KEY_APPLIED = 5;
    public static final int KEY_APPLIED_DEXOPT_EXIST = 122;
    public static final int KEY_APPLIED_DEXOPT_FORMAT = 123;
    public static final int KEY_APPLIED_DEXOPT_OTHER = 121;
    public static final int KEY_APPLIED_DEX_EXTRACT = 182;
    public static final int KEY_APPLIED_EXCEPTION = 120;
    public static final int KEY_APPLIED_FAIL_COST_10S_LESS = 206;
    public static final int KEY_APPLIED_FAIL_COST_30S_LESS = 207;
    public static final int KEY_APPLIED_FAIL_COST_5S_LESS = 205;
    public static final int KEY_APPLIED_FAIL_COST_60S_LESS = 208;
    public static final int KEY_APPLIED_FAIL_COST_OTHER = 209;
    public static final int KEY_APPLIED_INFO_CORRUPTED = 124;
    public static final int KEY_APPLIED_LIB_EXTRACT = 183;
    public static final int KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = 153;
    public static final int KEY_APPLIED_PACKAGE_CHECK_DEX_META = 151;
    public static final int KEY_APPLIED_PACKAGE_CHECK_LIB_META = 152;
    public static final int KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND = 155;
    public static final int KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = 154;
    public static final int KEY_APPLIED_PACKAGE_CHECK_RES_META = 157;
    public static final int KEY_APPLIED_PACKAGE_CHECK_SIGNATURE = 150;
    public static final int KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = 158;
    public static final int KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = 156;
    public static final int KEY_APPLIED_PATCH_FILE_EXTRACT = 181;
    public static final int KEY_APPLIED_RESOURCE_EXTRACT = 184;
    public static final int KEY_APPLIED_START = 4;
    public static final int KEY_APPLIED_SUCC_COST_10S_LESS = 201;
    public static final int KEY_APPLIED_SUCC_COST_30S_LESS = 202;
    public static final int KEY_APPLIED_SUCC_COST_5S_LESS = 200;
    public static final int KEY_APPLIED_SUCC_COST_60S_LESS = 203;
    public static final int KEY_APPLIED_SUCC_COST_OTHER = 204;
    public static final int KEY_APPLIED_UPGRADE = 100;
    public static final int KEY_APPLIED_UPGRADE_FAIL = 101;
    public static final int KEY_APPLIED_VERSION_CHECK = 180;
    public static final int KEY_APPLY_WITH_RETRY = 10;
    public static final int KEY_CRASH_CAUSE_XPOSED_ART = 9;
    public static final int KEY_CRASH_CAUSE_XPOSED_DALVIK = 8;
    public static final int KEY_CRASH_FAST_PROTECT = 7;
    public static final int KEY_DOWNLOAD = 1;
    public static final int KEY_LOADED = 6;
    public static final int KEY_LOADED_EXCEPTION_DEX = 252;
    public static final int KEY_LOADED_EXCEPTION_DEX_CHECK = 253;
    public static final int KEY_LOADED_EXCEPTION_RESOURCE = 254;
    public static final int KEY_LOADED_EXCEPTION_RESOURCE_CHECK = 255;
    public static final int KEY_LOADED_INFO_CORRUPTED = 309;
    public static final int KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR = 450;
    public static final int KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR = 451;
    public static final int KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK = 452;
    public static final int KEY_LOADED_MISMATCH_DEX = 300;
    public static final int KEY_LOADED_MISMATCH_LIB = 301;
    public static final int KEY_LOADED_MISMATCH_RESOURCE = 302;
    public static final int KEY_LOADED_MISSING_DEX = 303;
    public static final int KEY_LOADED_MISSING_DEX_OPT = 307;
    public static final int KEY_LOADED_MISSING_LIB = 304;
    public static final int KEY_LOADED_MISSING_PATCH_FILE = 305;
    public static final int KEY_LOADED_MISSING_PATCH_INFO = 306;
    public static final int KEY_LOADED_MISSING_RES = 308;
    public static final int KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = 353;
    public static final int KEY_LOADED_PACKAGE_CHECK_DEX_META = 351;
    public static final int KEY_LOADED_PACKAGE_CHECK_LIB_META = 352;
    public static final int KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND = 356;
    public static final int KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = 354;
    public static final int KEY_LOADED_PACKAGE_CHECK_RES_META = 357;
    public static final int KEY_LOADED_PACKAGE_CHECK_SIGNATURE = 350;
    public static final int KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = 358;
    public static final int KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = 355;
    public static final int KEY_LOADED_SUCC_COST_1000_LESS = 401;
    public static final int KEY_LOADED_SUCC_COST_3000_LESS = 402;
    public static final int KEY_LOADED_SUCC_COST_5000_LESS = 403;
    public static final int KEY_LOADED_SUCC_COST_500_LESS = 400;
    public static final int KEY_LOADED_SUCC_COST_OTHER = 404;
    public static final int KEY_LOADED_UNCAUGHT_EXCEPTION = 251;
    public static final int KEY_LOADED_UNKNOWN_EXCEPTION = 250;
    public static final int KEY_REQUEST = 0;
    public static final int KEY_TRY_APPLY = 2;
    public static final int KEY_TRY_APPLY_ALREADY_APPLY = 77;
    public static final int KEY_TRY_APPLY_CONDITION_NOT_SATISFIED = 80;
    public static final int KEY_TRY_APPLY_CRASH_LIMIT = 79;
    public static final int KEY_TRY_APPLY_DISABLE = 71;
    public static final int KEY_TRY_APPLY_GOOGLEPLAY = 75;
    public static final int KEY_TRY_APPLY_INSERVICE = 73;
    public static final int KEY_TRY_APPLY_JIT = 81;
    public static final int KEY_TRY_APPLY_MEMORY_LIMIT = 78;
    public static final int KEY_TRY_APPLY_NOT_EXIST = 74;
    public static final int KEY_TRY_APPLY_ROM_SPACE = 76;
    public static final int KEY_TRY_APPLY_RUNNING = 72;
    public static final int KEY_TRY_APPLY_SUCCESS = 3;
    public static final int KEY_TRY_APPLY_UPGRADE = 70;
    private static final String TAG = "Tinker.TinkerReport";
    private static Reporter reporter;

    /* compiled from: BUGLY */
    public interface Reporter {
        void onReport(int i2);

        void onReport(String str);
    }

    public static void onApplied(long j2, boolean z) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (z) {
            reporter2.onReport(5);
        }
        if (z) {
            reporter.onReport(100);
        } else {
            reporter.onReport(101);
        }
        TinkerLog.i(TAG, "hp_report report apply cost = %d", new Object[]{Long.valueOf(j2)});
        if (j2 < 0) {
            TinkerLog.e(TAG, "hp_report report apply cost failed, invalid cost", new Object[0]);
            return;
        }
        if (j2 <= a.r) {
            if (z) {
                reporter.onReport(200);
                return;
            } else {
                reporter.onReport(205);
                return;
            }
        }
        if (j2 <= a.q) {
            if (z) {
                reporter.onReport(201);
                return;
            } else {
                reporter.onReport(206);
                return;
            }
        }
        if (j2 <= 30000) {
            if (z) {
                reporter.onReport(202);
                return;
            } else {
                reporter.onReport(KEY_APPLIED_FAIL_COST_30S_LESS);
                return;
            }
        }
        if (j2 <= a.f5800d) {
            if (z) {
                reporter.onReport(203);
                return;
            } else {
                reporter.onReport(KEY_APPLIED_FAIL_COST_60S_LESS);
                return;
            }
        }
        if (z) {
            reporter.onReport(204);
        } else {
            reporter.onReport(KEY_APPLIED_FAIL_COST_OTHER);
        }
    }

    public static void onApplyCrash(Throwable th) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(120);
        reporter.onReport("Tinker Exception:apply tinker occur exception " + TinkerUtils.getExceptionCauseString(th));
    }

    public static void onApplyDexOptFail(Throwable th) {
        if (reporter == null) {
            return;
        }
        if (th.getMessage().contains("checkDexOptExist failed")) {
            reporter.onReport(122);
            return;
        }
        if (th.getMessage().contains("checkDexOptFormat failed")) {
            reporter.onReport(123);
            return;
        }
        reporter.onReport(121);
        reporter.onReport("Tinker Exception:apply tinker occur exception " + TinkerUtils.getExceptionCauseString(th));
    }

    public static void onApplyExtractFail(int i2) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i2 == 1) {
            reporter2.onReport(KEY_APPLIED_PATCH_FILE_EXTRACT);
            return;
        }
        if (i2 == 3) {
            reporter2.onReport(KEY_APPLIED_DEX_EXTRACT);
        } else if (i2 == 5) {
            reporter2.onReport(KEY_APPLIED_LIB_EXTRACT);
        } else {
            if (i2 != 6) {
                return;
            }
            reporter2.onReport(KEY_APPLIED_RESOURCE_EXTRACT);
        }
    }

    public static void onApplyInfoCorrupted() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(124);
    }

    public static void onApplyPackageCheckFail(int i2) {
        if (reporter == null) {
        }
        TinkerLog.i(TAG, "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i2)});
        switch (i2) {
            case -9:
                reporter.onReport(KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                break;
            case -8:
                reporter.onReport(KEY_APPLIED_PACKAGE_CHECK_RES_META);
                break;
            case -7:
                reporter.onReport(156);
                break;
            case -6:
                reporter.onReport(154);
                break;
            case -5:
                reporter.onReport(153);
                break;
            case -4:
                reporter.onReport(152);
                break;
            case -3:
                reporter.onReport(151);
                break;
            case -2:
                reporter.onReport(155);
                break;
            case -1:
                reporter.onReport(150);
                break;
        }
    }

    public static void onApplyPatchServiceStart() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(4);
    }

    public static void onApplyVersionCheckFail() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(180);
    }

    public static void onFastCrashProtect() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(7);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void onLoadException(java.lang.Throwable r5, int r6) {
        /*
            com.tencent.bugly.beta.tinker.TinkerReport$Reporter r0 = com.tencent.bugly.beta.tinker.TinkerReport.reporter
            if (r0 != 0) goto L5
            return
        L5:
            r1 = -4
            r2 = 1
            r3 = 0
            if (r6 == r1) goto Lbf
            r1 = -3
            java.lang.String r4 = "Tinker.TinkerReport"
            if (r6 == r1) goto L6f
            r1 = -2
            if (r6 == r1) goto L1e
            r1 = -1
            if (r6 == r1) goto L17
            goto Lc4
        L17:
            r6 = 250(0xfa, float:3.5E-43)
            r0.onReport(r6)
            goto Lc4
        L1e:
            java.lang.String r6 = r5.getMessage()
            java.lang.String r0 = "checkDexInstall failed"
            boolean r6 = r6.contains(r0)
            if (r6 == 0) goto L4d
            com.tencent.bugly.beta.tinker.TinkerReport$Reporter r6 = com.tencent.bugly.beta.tinker.TinkerReport.reporter
            r0 = 253(0xfd, float:3.55E-43)
            r6.onReport(r0)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "tinker dex check fail:"
            r6.append(r0)
            java.lang.String r0 = r5.getMessage()
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r0 = new java.lang.Object[r3]
            com.tencent.tinker.lib.util.TinkerLog.e(r4, r6, r0)
            goto Lc5
        L4d:
            com.tencent.bugly.beta.tinker.TinkerReport$Reporter r6 = com.tencent.bugly.beta.tinker.TinkerReport.reporter
            r0 = 252(0xfc, float:3.53E-43)
            r6.onReport(r0)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "tinker dex reflect fail:"
            r6.append(r0)
            java.lang.String r0 = r5.getMessage()
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r0 = new java.lang.Object[r3]
            com.tencent.tinker.lib.util.TinkerLog.e(r4, r6, r0)
            goto Lc4
        L6f:
            java.lang.String r6 = r5.getMessage()
            java.lang.String r0 = "checkResInstall failed"
            boolean r6 = r6.contains(r0)
            if (r6 == 0) goto L9d
            com.tencent.bugly.beta.tinker.TinkerReport$Reporter r6 = com.tencent.bugly.beta.tinker.TinkerReport.reporter
            r0 = 255(0xff, float:3.57E-43)
            r6.onReport(r0)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "tinker res check fail:"
            r6.append(r0)
            java.lang.String r0 = r5.getMessage()
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r0 = new java.lang.Object[r3]
            com.tencent.tinker.lib.util.TinkerLog.e(r4, r6, r0)
            goto Lc5
        L9d:
            com.tencent.bugly.beta.tinker.TinkerReport$Reporter r6 = com.tencent.bugly.beta.tinker.TinkerReport.reporter
            r0 = 254(0xfe, float:3.56E-43)
            r6.onReport(r0)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "tinker res reflect fail:"
            r6.append(r0)
            java.lang.String r0 = r5.getMessage()
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r0 = new java.lang.Object[r3]
            com.tencent.tinker.lib.util.TinkerLog.e(r4, r6, r0)
            goto Lc4
        Lbf:
            r6 = 251(0xfb, float:3.52E-43)
            r0.onReport(r6)
        Lc4:
            r2 = 0
        Lc5:
            if (r2 != 0) goto Le1
            com.tencent.bugly.beta.tinker.TinkerReport$Reporter r6 = com.tencent.bugly.beta.tinker.TinkerReport.reporter
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Tinker Exception:load tinker occur exception "
            r0.append(r1)
            java.lang.String r5 = com.tencent.bugly.beta.tinker.TinkerUtils.getExceptionCauseString(r5)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.onReport(r5)
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerReport.onLoadException(java.lang.Throwable, int):void");
    }

    public static void onLoadFileMisMatch(int i2) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i2 == 3) {
            reporter2.onReport(300);
        } else if (i2 == 5) {
            reporter2.onReport(301);
        } else {
            if (i2 != 6) {
                return;
            }
            reporter2.onReport(302);
        }
    }

    public static void onLoadFileNotFound(int i2) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
        }
        switch (i2) {
            case 1:
                reporter2.onReport(KEY_LOADED_MISSING_PATCH_FILE);
                break;
            case 2:
                reporter2.onReport(KEY_LOADED_MISSING_PATCH_INFO);
                break;
            case 3:
                reporter2.onReport(303);
                break;
            case 4:
                reporter2.onReport(307);
                break;
            case 5:
                reporter2.onReport(304);
                break;
            case 6:
                reporter2.onReport(308);
                break;
        }
    }

    public static void onLoadInfoCorrupted() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(KEY_LOADED_INFO_CORRUPTED);
    }

    public static void onLoadInterpretReport(int i2, Throwable th) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i2 == 0) {
            reporter2.onReport(KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK);
            return;
        }
        if (i2 == 1) {
            reporter2.onReport(450);
            reporter.onReport("Tinker Exception:interpret occur exception " + TinkerUtils.getExceptionCauseString(th));
            return;
        }
        if (i2 != 2) {
            return;
        }
        reporter2.onReport(KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR);
        reporter.onReport("Tinker Exception:interpret occur exception " + TinkerUtils.getExceptionCauseString(th));
    }

    public static void onLoadPackageCheckFail(int i2) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
        }
        switch (i2) {
            case -9:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                break;
            case -8:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_RES_META);
                break;
            case -7:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL);
                break;
            case -6:
                reporter2.onReport(354);
                break;
            case -5:
                reporter2.onReport(353);
                break;
            case -4:
                reporter2.onReport(352);
                break;
            case -3:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_DEX_META);
                break;
            case -2:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND);
                break;
            case -1:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_SIGNATURE);
                break;
        }
    }

    public static void onLoaded(long j2) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(6);
        if (j2 < 0) {
            TinkerLog.e(TAG, "hp_report report load cost failed, invalid cost", new Object[0]);
            return;
        }
        if (j2 <= 500) {
            reporter.onReport(400);
            return;
        }
        if (j2 <= 1000) {
            reporter.onReport(401);
            return;
        }
        if (j2 <= 3000) {
            reporter.onReport(402);
        } else if (j2 <= a.r) {
            reporter.onReport(403);
        } else {
            reporter.onReport(KEY_LOADED_SUCC_COST_OTHER);
        }
    }

    public static void onReportRetryPatch() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(10);
    }

    public static void onTryApply(boolean z) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(2);
        reporter.onReport(70);
        if (z) {
            reporter.onReport(3);
        }
    }

    public static void onTryApplyFail(int i2) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
        }
        switch (i2) {
            case TinkerUtils.ERROR_PATCH_CONDITION_NOT_SATISFIED /* -24 */:
                reporter2.onReport(80);
                break;
            case TinkerUtils.ERROR_PATCH_CRASH_LIMIT /* -23 */:
                reporter2.onReport(79);
                break;
            case TinkerUtils.ERROR_PATCH_MEMORY_LIMIT /* -22 */:
                reporter2.onReport(78);
                break;
            case -21:
                reporter2.onReport(76);
                break;
            case -20:
                reporter2.onReport(75);
                break;
            default:
                switch (i2) {
                    case -6:
                        reporter2.onReport(77);
                        break;
                    case -5:
                        reporter2.onReport(81);
                        break;
                    case -4:
                        reporter2.onReport(73);
                        break;
                    case -3:
                        reporter2.onReport(72);
                        break;
                    case -2:
                        reporter2.onReport(74);
                        break;
                    case -1:
                        reporter2.onReport(71);
                        break;
                }
        }
    }

    public static void onXposedCrash() {
        if (reporter == null) {
            return;
        }
        if (ShareTinkerInternals.isVmArt()) {
            reporter.onReport(9);
        } else {
            reporter.onReport(8);
        }
    }

    public void setReporter(Reporter reporter2) {
        reporter = reporter2;
    }
}
