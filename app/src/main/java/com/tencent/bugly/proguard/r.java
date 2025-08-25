package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;
import java.util.Iterator;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class r {
    public static synchronized void a(Context context) {
        String str;
        File[] fileArrListFiles;
        String strA;
        final com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
        String absolutePath = context.getDir(TinkerManager.PATCH_DIR, 0).getAbsolutePath();
        String absolutePath2 = context.getDir("tmpPatch", 32768).getAbsolutePath();
        eVar.I = new File(absolutePath, TinkerManager.PATCH_NAME);
        if (TextUtils.isEmpty(com.tencent.bugly.beta.global.a.b("PatchFile", ""))) {
            com.tencent.bugly.beta.global.a.a("PatchFile", eVar.I.getAbsolutePath());
        }
        eVar.J = new File(absolutePath2, "tmpPatch.apk");
        if (eVar.I != null && TextUtils.isEmpty(com.tencent.bugly.beta.global.a.b("PatchFile", ""))) {
            com.tencent.bugly.beta.global.a.a("PatchFile", eVar.I.getAbsolutePath());
        }
        eVar.K = context.getDir("tmpPatch", 0);
        if (eVar.K != null && TextUtils.isEmpty(com.tencent.bugly.beta.global.a.b("PatchTmpDir", ""))) {
            com.tencent.bugly.beta.global.a.a("PatchTmpDir", eVar.I.getAbsolutePath());
        }
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.f8848a == null || betaGrayStrategy.f8848a.p != 3) {
            if (TinkerManager.getInstance().getPatchDirectory(eVar.u) != null && !TinkerManager.getInstance().getPatchDirectory(eVar.u).exists()) {
                com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
            }
            if (com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false)) {
                TinkerManager.getInstance().onPatchRollback(false);
            }
        } else {
            if (betaGrayStrategy.f8848a.f9486l != null) {
                eVar.O = betaGrayStrategy.f8848a.f9486l.get("H2");
            }
            eVar.P = com.tencent.bugly.beta.global.a.b("PatchResult", false);
            eVar.Q = Integer.valueOf(com.tencent.bugly.beta.global.a.b("PATCH_MAX_TIMES", "0")).intValue();
            if (eVar.P) {
                an.a("[patch] inject success", new Object[0]);
                if (!com.tencent.bugly.beta.global.a.b("UPLOAD_PATCH_RESULT", false)) {
                    com.tencent.bugly.beta.global.a.a("UPLOAD_PATCH_RESULT", true);
                    if (p.f9423a.a(new w("active", System.currentTimeMillis(), (byte) 0, 0L, null, betaGrayStrategy.f8848a.f9487m, betaGrayStrategy.f8848a.p, null))) {
                        an.a("save patch success event success!", new Object[0]);
                    } else {
                        an.e("save patch success event failed!", new Object[0]);
                    }
                }
            } else {
                an.a("[patch] inject failure", new Object[0]);
                if (!com.tencent.bugly.beta.global.a.b("UPLOAD_PATCH_RESULT", false)) {
                    com.tencent.bugly.beta.global.a.a("UPLOAD_PATCH_RESULT", true);
                    if (p.f9423a.a(new w("active", System.currentTimeMillis(), (byte) 1, 0L, null, betaGrayStrategy.f8848a.f9487m, betaGrayStrategy.f8848a.p, null))) {
                        an.a("save patch failed event success!", new Object[0]);
                    } else {
                        an.e("save patch failed event failed!", new Object[0]);
                    }
                }
            }
        }
        if (TextUtils.isEmpty(TinkerManager.getNewTinkerId())) {
            an.d("[patch] tinker new id is null ,so patch version is invalid", new Object[0]);
            eVar.O = "";
        }
        aq.b("G15", eVar.O);
        File file = com.tencent.bugly.beta.global.e.G.J;
        if (file != null && file.exists() && file.delete()) {
            an.a("[patch] delete tmpPatch.apk success", new Object[0]);
        }
        File file2 = com.tencent.bugly.beta.global.e.G.I;
        if (file2 != null && file2.exists() && (strA = aq.a(file2, "SHA")) != null) {
            com.tencent.bugly.beta.global.e.G.N = strA;
        }
        if (TinkerManager.isTinkerManagerInstalled()) {
            if (TextUtils.isEmpty(eVar.L)) {
                eVar.L = TinkerManager.getTinkerId();
            }
            an.a("TINKER_ID:" + eVar.L, new Object[0]);
            eVar.M = TinkerManager.getNewTinkerId();
            an.a("NEW_TINKER_ID:" + eVar.M, new Object[0]);
            TinkerManager.getInstance().setTinkerListener(new TinkerManager.TinkerListener() { // from class: com.tencent.bugly.proguard.r.1
                @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                public void onApplyFailure(String str2) {
                    eVar.P = false;
                    com.tencent.bugly.beta.global.a.a("PatchResult", false);
                    com.tencent.bugly.beta.global.a.a("IS_PATCHING", false);
                    an.a("Tinker patch failure, result: " + str2, new Object[0]);
                    BetaPatchListener betaPatchListener = eVar.Y;
                    if (betaPatchListener != null) {
                        betaPatchListener.onApplyFailure(str2);
                    }
                }

                @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                public void onApplySuccess(String str2) {
                    com.tencent.bugly.beta.global.e eVar2 = eVar;
                    eVar2.ae = false;
                    eVar2.P = true;
                    com.tencent.bugly.beta.global.a.a("IS_PATCHING", false);
                    com.tencent.bugly.beta.global.a.a("PatchResult", true);
                    an.a("Tinker patch success, result: " + str2, new Object[0]);
                    if (eVar.Z) {
                        com.tencent.bugly.beta.ui.g.a(new com.tencent.bugly.beta.ui.e(), true);
                    }
                    BetaPatchListener betaPatchListener = eVar.Y;
                    if (betaPatchListener != null) {
                        betaPatchListener.onApplySuccess(str2);
                    }
                }

                @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                public void onDownloadFailure(String str2) {
                    BetaPatchListener betaPatchListener = eVar.Y;
                    if (betaPatchListener != null) {
                        betaPatchListener.onDownloadFailure(str2);
                    }
                }

                @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                public void onDownloadSuccess(String str2) {
                    BetaPatchListener betaPatchListener = eVar.Y;
                    if (betaPatchListener != null) {
                        betaPatchListener.onDownloadSuccess(str2);
                    }
                }

                @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                public void onPatchRollback() {
                    an.a("patch rollback callback.", new Object[0]);
                    BetaPatchListener betaPatchListener = eVar.Y;
                    if (betaPatchListener != null) {
                        betaPatchListener.onPatchRollback();
                    }
                    if (TinkerManager.getInstance().getPatchDirectory(eVar.u) == null || TinkerManager.getInstance().getPatchDirectory(eVar.u).exists()) {
                        return;
                    }
                    com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
                }

                @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                public void onPatchStart() {
                    eVar.ae = true;
                    com.tencent.bugly.beta.global.a.a("IS_PATCHING", true);
                }
            });
        }
        if (TextUtils.isEmpty(com.tencent.bugly.beta.global.a.b("BaseArchName", "")) && (str = eVar.u.getApplicationInfo().nativeLibraryDir) != null && (fileArrListFiles = new File(str).listFiles()) != null && fileArrListFiles.length > 0) {
            boolean z = false;
            for (File file3 : fileArrListFiles) {
                if (file3.getName().endsWith(".so")) {
                    String strReplace = file3.getName().replace(".so", "");
                    if (strReplace.startsWith("lib")) {
                        strReplace = strReplace.substring(strReplace.indexOf("lib") + 3);
                    }
                    an.a("libName:" + strReplace, new Object[0]);
                    String absolutePath3 = file3.getAbsolutePath();
                    an.a("soFilePath:" + absolutePath3, new Object[0]);
                    Iterator<String> it = eVar.ac.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (strReplace.equals(it.next())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        String strB = com.tencent.bugly.beta.global.a.b(absolutePath3);
                        an.a("archName:" + strB, new Object[0]);
                        if (strB != null && strB.equals("armeabi-v5te")) {
                            strB = "armeabi";
                        }
                        com.tencent.bugly.beta.global.a.a(strReplace, strB);
                        if (TextUtils.isEmpty(com.tencent.bugly.beta.global.a.b("BaseArchName", ""))) {
                            com.tencent.bugly.beta.global.a.a("BaseArchName", strB);
                        }
                        z = false;
                    }
                }
            }
        }
    }
}
