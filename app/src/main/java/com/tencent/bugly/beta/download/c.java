package com.tencent.bugly.beta.download;

import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.f;
import com.tencent.bugly.beta.ui.g;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import java.util.ArrayList;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    final int f8778a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f8779b;

    public c(int i2, Object... objArr) {
        this.f8778a = i2;
        this.f8779b = objArr;
    }

    public synchronized void a(int i2, int i3) {
        try {
            int i4 = this.f8778a;
            if (i4 != 1) {
                if (i4 == 2) {
                    DownloadTask downloadTask = (DownloadTask) this.f8779b[0];
                    f fVar = (f) this.f8779b[2];
                    if (i3 == 1) {
                        downloadTask.download();
                        an.c("continue download", new Object[0]);
                        this.f8779b[1] = false;
                        fVar.a();
                    } else if ((i2 == 1 || ((Boolean) this.f8779b[1]).booleanValue()) && !e.G.U && !e.G.V) {
                        downloadTask.stop();
                        an.c("wifi network change to mobile network, stop download", new Object[0]);
                        this.f8779b[1] = true;
                        if (com.tencent.bugly.crashreport.common.info.b.f(e.G.u) != null) {
                            g.a(fVar, true);
                            this.f8779b[1] = false;
                        }
                    }
                }
            } else if (i3 == 1 || i3 == 3 || i3 == 4) {
                ArrayList arrayList = (ArrayList) p.f9423a.a();
                if (arrayList != null && !arrayList.isEmpty()) {
                    com.tencent.bugly.beta.upgrade.b.f8859a.a(new x(arrayList), true);
                }
            }
        } catch (Exception e2) {
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
    }
}
