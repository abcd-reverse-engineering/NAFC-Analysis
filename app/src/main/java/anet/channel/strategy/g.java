package anet.channel.strategy;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.strategy.c;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class g implements IStrategyInstance, HttpDispatcher.IDispatchEventListener {

    /* renamed from: a, reason: collision with root package name */
    boolean f1977a = false;

    /* renamed from: b, reason: collision with root package name */
    StrategyInfoHolder f1978b = null;

    /* renamed from: c, reason: collision with root package name */
    long f1979c = 0;

    /* renamed from: d, reason: collision with root package name */
    CopyOnWriteArraySet<IStrategyListener> f1980d = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name */
    private IStrategyFilter f1981e = new h(this);

    g() {
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void forceRefreshStrategy(String str) {
        if (a() || TextUtils.isEmpty(str)) {
            return;
        }
        ALog.i("awcn.StrategyCenter", "force refresh strategy", null, Constants.KEY_HOST, str);
        this.f1978b.d().a(str, true);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getCNameByHost(String str) {
        if (a() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f1978b.d().getCnameByHost(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getClientIp() {
        return a() ? "" : this.f1978b.d().f1943b;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        return getConnStrategyListByHost(str, this.f1981e);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getFormalizeUrl(String str) {
        HttpUrl httpUrl = HttpUrl.parse(str);
        if (httpUrl == null) {
            ALog.e("awcn.StrategyCenter", "url is invalid.", null, "URL", str);
            return null;
        }
        String strUrlString = httpUrl.urlString();
        try {
            String schemeByHost = getSchemeByHost(httpUrl.host(), httpUrl.scheme());
            if (!schemeByHost.equalsIgnoreCase(httpUrl.scheme())) {
                strUrlString = StringUtils.concatString(schemeByHost, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, str.substring(str.indexOf("//")));
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.StrategyCenter", "", null, "raw", StringUtils.simplifyString(str, 128), "ret", StringUtils.simplifyString(strUrlString, 128));
            }
        } catch (Exception e2) {
            ALog.e("awcn.StrategyCenter", "getFormalizeUrl failed", null, e2, "raw", str);
        }
        return strUrlString;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    @Deprecated
    public String getSchemeByHost(String str) {
        return getSchemeByHost(str, null);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getUnitByHost(String str) {
        if (a()) {
            return null;
        }
        return this.f1978b.f1932b.b(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void initialize(Context context) {
        if (this.f1977a || context == null) {
            return;
        }
        try {
            ALog.i("awcn.StrategyCenter", "StrategyCenter initialize started.", null, new Object[0]);
            AmdcRuntimeInfo.setContext(context);
            m.a(context);
            HttpDispatcher.getInstance().addListener(this);
            this.f1978b = StrategyInfoHolder.a();
            this.f1977a = true;
            ALog.i("awcn.StrategyCenter", "StrategyCenter initialize finished.", null, new Object[0]);
        } catch (Exception e2) {
            ALog.e("awcn.StrategyCenter", "StrategyCenter initialize failed.", null, e2, new Object[0]);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (a() || iConnStrategy == null || !(iConnStrategy instanceof IPConnStrategy)) {
            return;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
        if (iPConnStrategy.f1918b == 1) {
            this.f1978b.f1933c.a(str, iConnStrategy, connEvent);
        } else if (iPConnStrategy.f1918b == 0) {
            this.f1978b.d().a(str, iConnStrategy, connEvent);
        }
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(DispatchEvent dispatchEvent) {
        if (dispatchEvent.eventType != 1 || this.f1978b == null) {
            return;
        }
        ALog.d("awcn.StrategyCenter", "receive amdc event", null, new Object[0]);
        l.d dVarA = l.a((JSONObject) dispatchEvent.extraObject);
        if (dVarA == null) {
            return;
        }
        this.f1978b.a(dVarA);
        saveData();
        Iterator<IStrategyListener> it = this.f1980d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStrategyUpdated(dVarA);
            } catch (Exception e2) {
                ALog.e("awcn.StrategyCenter", "onStrategyUpdated failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void registerListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "registerListener", null, "listener", this.f1980d);
        if (iStrategyListener != null) {
            this.f1980d.add(iStrategyListener);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void saveData() {
        ALog.i("awcn.StrategyCenter", "saveData", null, new Object[0]);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f1979c > 30000) {
            this.f1979c = jCurrentTimeMillis;
            anet.channel.strategy.utils.a.a(new i(this), 500L);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void switchEnv() {
        m.a();
        HttpDispatcher.getInstance().switchENV();
        if (this.f1978b != null) {
            this.f1978b.b();
            this.f1978b = StrategyInfoHolder.a();
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void unregisterListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "unregisterListener", null, "listener", this.f1980d);
        this.f1980d.remove(iStrategyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        if (this.f1978b != null) {
            return false;
        }
        ALog.w("StrategyCenter not initialized", null, "isInitialized", Boolean.valueOf(this.f1977a));
        return true;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str, IStrategyFilter iStrategyFilter) {
        if (TextUtils.isEmpty(str) || a()) {
            return Collections.EMPTY_LIST;
        }
        String cnameByHost = this.f1978b.d().getCnameByHost(str);
        if (!TextUtils.isEmpty(cnameByHost)) {
            str = cnameByHost;
        }
        List listQueryByHost = this.f1978b.d().queryByHost(str);
        if (listQueryByHost.isEmpty()) {
            listQueryByHost = this.f1978b.f1933c.a(str);
        }
        if (listQueryByHost.isEmpty() || iStrategyFilter == null) {
            ALog.d("getConnStrategyListByHost", null, Constants.KEY_HOST, str, "result", listQueryByHost);
            return listQueryByHost;
        }
        boolean z = !AwcnConfig.isIpv6Enable() || (AwcnConfig.isIpv6BlackListEnable() && this.f1978b.d().a(str, AwcnConfig.getIpv6BlackListTtl()));
        ListIterator<IConnStrategy> listIterator = listQueryByHost.listIterator();
        while (listIterator.hasNext()) {
            IConnStrategy next = listIterator.next();
            if (!iStrategyFilter.accept(next)) {
                listIterator.remove();
            } else if (z && anet.channel.strategy.utils.c.b(next.getIp())) {
                listIterator.remove();
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("getConnStrategyListByHost", null, Constants.KEY_HOST, str, "result", listQueryByHost);
        }
        return listQueryByHost;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getSchemeByHost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (a()) {
            return str2;
        }
        String strA = this.f1978b.f1932b.a(str);
        if (strA != null || TextUtils.isEmpty(str2)) {
            str2 = strA;
        }
        if (str2 == null && (str2 = c.a.f1956a.a(str)) == null) {
            str2 = HttpConstant.HTTP;
        }
        ALog.d("awcn.StrategyCenter", "getSchemeByHost", null, Constants.KEY_HOST, str, "scheme", str2);
        return str2;
    }
}
