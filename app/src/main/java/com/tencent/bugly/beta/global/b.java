package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final int f8785a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f8786b;

    public b(int i2, Object... objArr) {
        this.f8785a = i2;
        this.f8786b = objArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            switch (this.f8785a) {
                case 1:
                    if (((ViewGroup) this.f8786b[1]).getChildCount() <= 0) {
                        ((Activity) this.f8786b[0]).finish();
                        an.a("BetaAct closed by empty view", new Object[0]);
                        break;
                    }
                    break;
                case 2:
                    ((com.tencent.bugly.beta.ui.a) this.f8786b[0]).a();
                    break;
                case 3:
                    if (this.f8786b[1] != null) {
                        ((DownloadTask) this.f8786b[1]).download();
                    }
                    ((com.tencent.bugly.beta.ui.a) this.f8786b[0]).a();
                    break;
                case 4:
                    h hVar = (h) this.f8786b[0];
                    DownloadTask downloadTask = hVar.q;
                    y yVar = hVar.p;
                    BetaReceiver.addTask(downloadTask);
                    if (hVar.r != null) {
                        hVar.r.run();
                    }
                    if (downloadTask.getStatus() == 1 && a.a(e.G.u, downloadTask.getSaveFile(), yVar.f9480f.f9444a)) {
                        p.f9423a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, yVar.f9479e, yVar.f9487m, yVar.p, null));
                    } else {
                        downloadTask.download();
                    }
                    if (yVar.f9481g != 2) {
                        hVar.a();
                        break;
                    }
                    break;
                case 5:
                    h hVar2 = (h) this.f8786b[0];
                    DownloadTask downloadTask2 = hVar2.q;
                    BetaReceiver.netListeners.remove(downloadTask2.getDownloadUrl());
                    downloadTask2.stop();
                    hVar2.a(downloadTask2);
                    break;
                case 6:
                    h hVar3 = (h) this.f8786b[0];
                    if (hVar3.s != null) {
                        hVar3.s.run();
                    }
                    hVar3.a();
                    break;
                case 7:
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                    break;
                case 8:
                    ((com.tencent.bugly.beta.ui.e) this.f8786b[0]).a();
                    break;
                case 9:
                    Beta.installApk(Beta.getStrategyTask().getSaveFile());
                    Beta.saveInstallEvent(true);
                    break;
            }
        } catch (Exception e2) {
            if (an.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }
}
