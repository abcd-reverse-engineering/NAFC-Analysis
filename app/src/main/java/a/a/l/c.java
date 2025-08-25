package a.a.l;

import anet.channel.util.ALog;
import java.net.HttpCookie;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1143a;

    c(String str) {
        this.f1143a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.f1136e == null) {
            return;
        }
        try {
            for (HttpCookie httpCookie : HttpCookie.parse(this.f1143a)) {
                if (httpCookie.getName().equals(a.f1136e.f1138a)) {
                    a.f1136e.f1139b = httpCookie.toString();
                    a.f1136e.f1141d = httpCookie.getDomain();
                    a.f1136e.f1140c = this.f1143a;
                    a.f1136e.a();
                    return;
                }
            }
        } catch (Exception e2) {
            ALog.e(a.f1132a, "cookieMonitorSave error.", null, e2, new Object[0]);
        }
    }
}
