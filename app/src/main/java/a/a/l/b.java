package a.a.l;

import a.a.l.a;
import android.text.TextUtils;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class b implements Runnable {
    b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(a.f())) {
                return;
            }
            a.C0002a unused = a.f1136e = new a.C0002a(a.f());
        } catch (Exception e2) {
            ALog.e(a.f1132a, "", null, e2, new Object[0]);
        }
    }
}
