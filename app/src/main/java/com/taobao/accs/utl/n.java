package com.taobao.accs.utl;

import android.app.Application;
import com.taobao.accs.utl.l;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f8694a;

    n(l lVar) {
        this.f8694a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = l.f8683d.iterator();
        while (it.hasNext()) {
            l.b bVar = (l.b) it.next();
            if (bVar != null) {
                Application unused = l.f8684e;
                bVar.b();
            }
        }
    }
}
