package a.a.l;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.CookieMonitorStat;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.HttpCookie;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1144a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1145b;

    d(String str, String str2) {
        this.f1144a = str;
        this.f1145b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.f1136e == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(a.f1136e.f1138a) || !HttpCookie.domainMatches(a.f1136e.f1141d, HttpUrl.parse(this.f1144a).host()) || TextUtils.isEmpty(this.f1145b)) {
                return;
            }
            if (this.f1145b.contains(a.f1136e.f1138a + ContainerUtils.KEY_VALUE_DELIMITER)) {
                return;
            }
            CookieMonitorStat cookieMonitorStat = new CookieMonitorStat(this.f1144a);
            cookieMonitorStat.cookieName = a.f1136e.f1138a;
            cookieMonitorStat.cookieText = a.f1136e.f1139b;
            cookieMonitorStat.setCookie = a.f1136e.f1140c;
            cookieMonitorStat.missType = 1;
            AppMonitor.getInstance().commitStat(cookieMonitorStat);
        } catch (Exception e2) {
            ALog.e(a.f1132a, "cookieMonitorReport error.", null, e2, new Object[0]);
        }
    }
}
