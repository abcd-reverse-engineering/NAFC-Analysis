package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.MsgDO;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17331a;

    c(AgooFactory agooFactory) {
        this.f17331a = agooFactory;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<MsgDO> arrayListB = this.f17331a.messageService.b();
        if (arrayListB == null || arrayListB.size() <= 0) {
            return;
        }
        ALog.e("AgooFactory", "reportCacheMsg", "size", Integer.valueOf(arrayListB.size()));
        Iterator<MsgDO> it = arrayListB.iterator();
        while (it.hasNext()) {
            MsgDO next = it.next();
            if (next != null) {
                next.isFromCache = true;
                this.f17331a.notifyManager.report(next, null);
            }
        }
    }
}
