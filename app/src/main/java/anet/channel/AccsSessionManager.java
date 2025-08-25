package anet.channel;

import android.content.Intent;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class AccsSessionManager {

    /* renamed from: c, reason: collision with root package name */
    private static CopyOnWriteArraySet<ISessionListener> f1583c = new CopyOnWriteArraySet<>();

    /* renamed from: a, reason: collision with root package name */
    SessionCenter f1584a;

    /* renamed from: b, reason: collision with root package name */
    Set<String> f1585b = Collections.EMPTY_SET;

    AccsSessionManager(SessionCenter sessionCenter) {
        this.f1584a = null;
        this.f1584a = sessionCenter;
    }

    private boolean b() {
        return !(GlobalAppRuntimeInfo.isAppBackground() && AwcnConfig.isAccsSessionCreateForbiddenInBg()) && NetworkStatusHelper.isConnected();
    }

    public synchronized void checkAndStartSession() {
        Collection<SessionInfo> collectionA = this.f1584a.f1642g.a();
        Set<String> treeSet = Collections.EMPTY_SET;
        if (!collectionA.isEmpty()) {
            treeSet = new TreeSet<>();
        }
        for (SessionInfo sessionInfo : collectionA) {
            if (sessionInfo.isKeepAlive) {
                treeSet.add(StringUtils.concatString(StrategyCenter.getInstance().getSchemeByHost(sessionInfo.host, sessionInfo.isAccs ? HttpConstant.HTTPS : HttpConstant.HTTP), HttpConstant.SCHEME_SPLIT, sessionInfo.host));
            }
        }
        for (String str : this.f1585b) {
            if (!treeSet.contains(str)) {
                a(str);
            }
        }
        if (b()) {
            for (String str2 : treeSet) {
                try {
                    this.f1584a.get(str2, ConnType.TypeLevel.SPDY, 0L);
                } catch (Exception unused) {
                    ALog.e("start session failed", null, Constants.KEY_HOST, str2);
                }
            }
            this.f1585b = treeSet;
        }
    }

    public synchronized void forceCloseSession(boolean z) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.AccsSessionManager", "forceCloseSession", this.f1584a.f1638c, "reCreate", Boolean.valueOf(z));
        }
        Iterator<String> it = this.f1585b.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        if (z) {
            checkAndStartSession();
        }
    }

    public void notifyListener(Intent intent) {
        ThreadPoolExecutorFactory.submitScheduledTask(new a(this, intent));
    }

    public void registerListener(ISessionListener iSessionListener) {
        if (iSessionListener != null) {
            f1583c.add(iSessionListener);
        }
    }

    public void unregisterListener(ISessionListener iSessionListener) {
        f1583c.remove(iSessionListener);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.d("awcn.AccsSessionManager", "closeSessions", this.f1584a.f1638c, Constants.KEY_HOST, str);
        this.f1584a.a(str).b(false);
    }
}
