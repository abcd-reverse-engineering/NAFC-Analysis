package com.tencent.bugly.beta.download;

import android.os.Build;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.utils.e;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    final int f8776a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f8777b;

    public a(int i2, Object... objArr) {
        this.f8776a = i2;
        this.f8777b = objArr;
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onCompleted(DownloadTask downloadTask) throws Throwable {
        try {
            int i2 = this.f8776a;
            if (i2 == 1) {
                synchronized (this.f8777b[0]) {
                    Map map = (Map) this.f8777b[1];
                    if (map.size() == 0) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        if (((DownloadTask) it.next()).getStatus() == 1) {
                            i3++;
                        }
                    }
                    an.c(i3 + " has completed", new Object[0]);
                    if (i3 < map.size()) {
                        return;
                    }
                    for (String str : map.keySet()) {
                        if (((DownloadTask) map.get(str)).getSaveFile() != null && ((DownloadTask) map.get(str)).getSaveFile().exists()) {
                            ResBean.f8780a.a(str, ((DownloadTask) map.get(str)).getSaveFile().getAbsolutePath());
                        }
                    }
                    com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.f8780a);
                    f fVar = (f) this.f8777b[0];
                    fVar.a();
                    fVar.b();
                    return;
                }
            }
            if (i2 == 2) {
                ((h) this.f8777b[0]).a(downloadTask);
                return;
            }
            if (i2 == 3) {
                com.tencent.bugly.beta.upgrade.c cVar = (com.tencent.bugly.beta.upgrade.c) this.f8777b[0];
                BetaGrayStrategy betaGrayStrategy = cVar.f8861b;
                if (betaGrayStrategy != null && betaGrayStrategy.f8848a != null) {
                    if (cVar.f8865f != null) {
                        e.a(new d(18, cVar.f8865f, 3, Boolean.valueOf(cVar.f8866g)));
                    }
                    an.a("apk download completed", new Object[0]);
                    w wVar = new w("download", System.currentTimeMillis(), (byte) 0, downloadTask.getCostTime(), betaGrayStrategy.f8848a.f9479e, betaGrayStrategy.f8848a.f9487m, betaGrayStrategy.f8848a.p, null);
                    if (p.f9423a.a(wVar)) {
                        com.tencent.bugly.beta.upgrade.b.f8859a.a(wVar, true);
                    }
                    if (com.tencent.bugly.beta.global.e.G.af) {
                        File saveFile = downloadTask.getSaveFile();
                        Integer num = (Integer) this.f8777b[1];
                        if (com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.G.u, saveFile, betaGrayStrategy.f8848a.f9480f.f9444a)) {
                            this.f8777b[1] = 0;
                            p.f9423a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, betaGrayStrategy.f8848a.f9479e, betaGrayStrategy.f8848a.f9487m, betaGrayStrategy.f8848a.p, null));
                            return;
                        }
                        if (num.intValue() >= 2) {
                            this.f8777b[1] = 0;
                            onFailed(downloadTask, 2080, "file md5 verify fail");
                            downloadTask.delete(true);
                            return;
                        } else {
                            if (Build.VERSION.SDK_INT >= 24) {
                                this.f8777b[1] = 0;
                                onFailed(downloadTask, 2080, "安装失败，请检查您的App是否兼容7.0设备");
                                downloadTask.delete(true);
                                return;
                            }
                            this.f8777b[1] = Integer.valueOf(num.intValue() + 1);
                            downloadTask.delete(true);
                            cVar.f8862c = com.tencent.bugly.beta.global.e.G.r.a(betaGrayStrategy.f8848a.f9480f.f9445b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, betaGrayStrategy.f8848a.f9480f.f9445b);
                            cVar.f8862c.setDownloadType(1);
                            h.v.a(betaGrayStrategy.f8848a, cVar.f8862c);
                            cVar.f8862c.addListener(this);
                            BetaReceiver.addTask(cVar.f8862c);
                            cVar.f8862c.download();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (i2 != 4) {
                return;
            }
            q qVar = (q) this.f8777b[0];
            Integer num2 = (Integer) this.f8777b[1];
            BetaGrayStrategy betaGrayStrategy2 = qVar.f9425b;
            if (betaGrayStrategy2 != null && betaGrayStrategy2.f8848a != null) {
                an.a("patch download success !!!", new Object[0]);
                File saveFile2 = downloadTask.getSaveFile();
                if (!com.tencent.bugly.beta.global.a.a(saveFile2, betaGrayStrategy2.f8848a.f9480f.f9444a, "SHA")) {
                    if (num2.intValue() >= 2) {
                        this.f8777b[1] = 0;
                        onFailed(downloadTask, 2080, "file sha1 verify fail");
                        downloadTask.delete(true);
                        TinkerManager.getInstance().onDownloadFailure("retry download patch too many times.");
                        return;
                    }
                    this.f8777b[1] = Integer.valueOf(num2.intValue() + 1);
                    downloadTask.delete(true);
                    qVar.f9426c = com.tencent.bugly.beta.global.e.G.r.a(betaGrayStrategy2.f8848a.f9480f.f9445b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, betaGrayStrategy2.f8848a.f9480f.f9445b);
                    qVar.f9426c.setDownloadType(3);
                    qVar.f9426c.setNeededNotify(false);
                    qVar.f9426c.addListener(this);
                    BetaReceiver.addTask(qVar.f9426c);
                    qVar.f9426c.download();
                    return;
                }
                this.f8777b[1] = 0;
                if (!com.tencent.bugly.beta.global.a.a(saveFile2, com.tencent.bugly.beta.global.e.G.J)) {
                    an.a("copy file failed", new Object[0]);
                    TinkerManager.getInstance().onDownloadFailure("copy file failure.");
                    return;
                }
                an.c("copy " + saveFile2.getAbsolutePath() + " to " + com.tencent.bugly.beta.global.e.G.J.getAbsolutePath() + " success!", new Object[0]);
                if (qVar.f9426c != null) {
                    an.c("delete temp file", new Object[0]);
                    qVar.f9426c.delete(true);
                }
                com.tencent.bugly.beta.global.a.a("UPLOAD_PATCH_RESULT", false);
                TinkerManager.getInstance().onDownloadSuccess(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath(), com.tencent.bugly.beta.global.e.G.X);
            }
        } catch (Exception e2) {
            if (an.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onFailed(DownloadTask downloadTask, int i2, String str) {
        try {
            int i3 = this.f8776a;
            if (i3 == 1) {
                synchronized (this.f8777b[0]) {
                    f fVar = (f) this.f8777b[0];
                    fVar.a();
                    fVar.b();
                }
                return;
            }
            if (i3 == 2) {
                ((h) this.f8777b[0]).a(downloadTask);
                return;
            }
            if (i3 == 3) {
                com.tencent.bugly.beta.upgrade.c cVar = (com.tencent.bugly.beta.upgrade.c) this.f8777b[0];
                if (downloadTask != null) {
                    p.f9423a.a(new w("download", System.currentTimeMillis(), (byte) 1, downloadTask.getCostTime(), cVar.f8861b.f8848a.f9479e, cVar.f8861b.f8848a.f9487m, cVar.f8861b.f8848a.p, null));
                }
                an.e("upgrade failed：(%d)%s", Integer.valueOf(i2), str);
                return;
            }
            if (i3 != 4) {
                return;
            }
            q qVar = (q) this.f8777b[0];
            if (downloadTask != null) {
                p.f9423a.a(new w("download", System.currentTimeMillis(), (byte) 1, downloadTask.getCostTime(), qVar.f9425b.f8848a.f9479e, qVar.f9425b.f8848a.f9487m, qVar.f9425b.f8848a.p, null));
            }
            an.e("hotfix download failed：(%d)%s", Integer.valueOf(i2), str);
            TinkerManager.getInstance().onDownloadFailure(str);
        } catch (Exception e2) {
            if (an.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onReceive(DownloadTask downloadTask) {
        if (this.f8776a != 2) {
            return;
        }
        ((h) this.f8777b[0]).a(downloadTask);
    }
}
