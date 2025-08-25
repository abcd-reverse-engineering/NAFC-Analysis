package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static q f9424a = new q();

    /* renamed from: b, reason: collision with root package name */
    public BetaGrayStrategy f9425b;

    /* renamed from: c, reason: collision with root package name */
    public DownloadTask f9426c;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.bugly.beta.global.d f9430g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9431h;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f9427d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private DownloadListener f9428e = new com.tencent.bugly.beta.download.a(4, this, 0);

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.bugly.beta.upgrade.a f9429f = null;

    /* renamed from: i, reason: collision with root package name */
    private final Object f9432i = new Object();

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057 A[Catch: all -> 0x00df, TryCatch #2 {, blocks: (B:7:0x000f, B:8:0x0019, B:10:0x001f, B:12:0x0025, B:15:0x002a, B:16:0x002c, B:19:0x0042, B:43:0x00dd, B:23:0x0050, B:24:0x0051, B:26:0x0057, B:27:0x005b, B:40:0x00d4, B:42:0x00da, B:30:0x0090, B:32:0x0094, B:33:0x009c, B:37:0x00b3, B:17:0x002d, B:18:0x0041), top: B:52:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r19, boolean r20, int r21) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.q.a(boolean, boolean, int):void");
    }

    public synchronized void a(int i2, y yVar, boolean z) {
        final u uVarB;
        File file;
        this.f9426c = null;
        this.f9425b = a(yVar);
        if (i2 == 0 && this.f9425b != null) {
            if (this.f9425b == null || this.f9425b.f8848a == null || this.f9425b.f8848a.f9480f == null || (file = com.tencent.bugly.beta.global.e.G.I) == null || !file.exists() || !com.tencent.bugly.beta.global.a.a(file, this.f9425b.f8848a.f9480f.f9444a, "SHA")) {
                if (yVar != null) {
                    if (com.tencent.bugly.beta.global.e.G.Y != null && (uVarB = this.f9425b.f8848a.b()) != null) {
                        this.f9427d.post(new Runnable() { // from class: com.tencent.bugly.proguard.q.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.tencent.bugly.beta.global.e.G.Y.onPatchReceived(uVarB.a());
                            }
                        });
                    }
                    if ((com.tencent.bugly.beta.global.e.G.aa || z) && com.tencent.bugly.beta.global.e.G.ab) {
                        a();
                    }
                }
                return;
            }
            an.a("patch has downloaded!", new Object[0]);
            if (!com.tencent.bugly.beta.global.e.G.P && com.tencent.bugly.beta.global.e.G.Q <= 3) {
                an.a("patch has downloaded but not patched execute patch!", new Object[0]);
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
                int i3 = eVar.Q + 1;
                eVar.Q = i3;
                com.tencent.bugly.beta.global.a.a("PATCH_MAX_TIMES", String.valueOf(i3));
                com.tencent.bugly.beta.global.a.a(file, com.tencent.bugly.beta.global.e.G.J);
                TinkerManager.getInstance().onDownloadSuccess(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath(), com.tencent.bugly.beta.global.e.G.X);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018f  */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.bugly.beta.upgrade.BetaGrayStrategy a(com.tencent.bugly.proguard.y r24) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.q.a(com.tencent.bugly.proguard.y):com.tencent.bugly.beta.upgrade.BetaGrayStrategy");
    }

    private void a() {
        BetaGrayStrategy betaGrayStrategy = this.f9425b;
        if (betaGrayStrategy == null) {
            return;
        }
        if (this.f9426c == null) {
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
            this.f9426c = eVar.r.a(betaGrayStrategy.f8848a.f9480f.f9445b, eVar.K.getAbsolutePath(), null, this.f9425b.f8848a.f9480f.f9444a);
            this.f9426c.setDownloadType(3);
        }
        DownloadTask downloadTask = this.f9426c;
        if (downloadTask == null) {
            return;
        }
        downloadTask.addListener(this.f9428e);
        this.f9426c.setNeededNotify(false);
        this.f9426c.download();
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        y yVar = betaGrayStrategy.f8848a;
        if (yVar == null || yVar.p != 3) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", betaGrayStrategy);
    }
}
