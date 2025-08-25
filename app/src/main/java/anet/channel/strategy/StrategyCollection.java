package anet.channel.strategy;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyCollection implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    String f1920a;

    /* renamed from: b, reason: collision with root package name */
    volatile long f1921b;

    /* renamed from: c, reason: collision with root package name */
    volatile String f1922c;

    /* renamed from: d, reason: collision with root package name */
    boolean f1923d;

    /* renamed from: e, reason: collision with root package name */
    int f1924e;

    /* renamed from: f, reason: collision with root package name */
    private StrategyList f1925f;

    /* renamed from: g, reason: collision with root package name */
    private transient long f1926g;

    /* renamed from: h, reason: collision with root package name */
    private transient boolean f1927h;

    public StrategyCollection() {
        this.f1925f = null;
        this.f1921b = 0L;
        this.f1922c = null;
        this.f1923d = false;
        this.f1924e = 0;
        this.f1926g = 0L;
        this.f1927h = true;
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.f1921b > 172800000) {
            this.f1925f = null;
        } else {
            if (this.f1925f != null) {
                this.f1925f.checkInit();
            }
        }
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f1921b;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (this.f1925f != null) {
            this.f1925f.notifyConnEvent(iConnStrategy, connEvent);
            if (!connEvent.isSuccess && this.f1925f.shouldRefresh()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f1926g > com.heytap.mcssdk.constant.a.f5800d) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.f1920a);
                    this.f1926g = jCurrentTimeMillis;
                }
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.f1925f == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.f1927h) {
            this.f1927h = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f1920a, this.f1924e);
            policyVersionStat.reportType = 0;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        return this.f1925f.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyList = ");
        sb.append(this.f1921b);
        StrategyList strategyList = this.f1925f;
        if (strategyList != null) {
            sb.append(strategyList.toString());
        } else if (this.f1922c != null) {
            sb.append('[');
            sb.append(this.f1920a);
            sb.append("=>");
            sb.append(this.f1922c);
            sb.append(']');
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    public synchronized void update(l.b bVar) {
        this.f1921b = System.currentTimeMillis() + (bVar.f1998b * 1000);
        if (!bVar.f1997a.equalsIgnoreCase(this.f1920a)) {
            ALog.e("StrategyCollection", "update error!", null, Constants.KEY_HOST, this.f1920a, "dnsInfo.host", bVar.f1997a);
            return;
        }
        if (this.f1924e != bVar.f2008l) {
            this.f1924e = bVar.f2008l;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f1920a, this.f1924e);
            policyVersionStat.reportType = 1;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        this.f1922c = bVar.f2000d;
        if ((bVar.f2002f != null && bVar.f2002f.length != 0 && bVar.f2004h != null && bVar.f2004h.length != 0) || (bVar.f2005i != null && bVar.f2005i.length != 0)) {
            if (this.f1925f == null) {
                this.f1925f = new StrategyList();
            }
            this.f1925f.update(bVar);
            return;
        }
        this.f1925f = null;
    }

    protected StrategyCollection(String str) {
        this.f1925f = null;
        this.f1921b = 0L;
        this.f1922c = null;
        this.f1923d = false;
        this.f1924e = 0;
        this.f1926g = 0L;
        this.f1927h = true;
        this.f1920a = str;
        this.f1923d = DispatchConstants.isAmdcServerDomain(str);
    }
}
