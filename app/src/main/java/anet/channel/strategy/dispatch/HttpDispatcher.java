package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HttpDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<IDispatchEventListener> f1959a;

    /* renamed from: b, reason: collision with root package name */
    private anet.channel.strategy.dispatch.a f1960b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f1961c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f1962d;

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f1963e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f1964f;

    /* compiled from: Taobao */
    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    /* compiled from: Taobao */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static HttpDispatcher f1965a = new HttpDispatcher();

        private a() {
        }
    }

    public static HttpDispatcher getInstance() {
        return a.f1965a;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            DispatchConstants.initHostArray = (String[]) list.toArray(new String[0]);
        }
    }

    void a(DispatchEvent dispatchEvent) {
        Iterator<IDispatchEventListener> it = this.f1959a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(dispatchEvent);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.f1963e.addAll(list);
            this.f1962d.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.f1959a.add(iDispatchEventListener);
    }

    public synchronized Set<String> getInitHosts() {
        a();
        return new HashSet(this.f1963e);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zContains = this.f1962d.contains(str);
        if (!zContains) {
            this.f1962d.add(str);
        }
        return !zContains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.f1959a.remove(iDispatchEventListener);
    }

    public void sendAmdcRequest(Set<String> set, int i2) {
        if (!this.f1961c || set == null || set.isEmpty()) {
            ALog.e("awcn.HttpDispatcher", "invalid parameter", null, new Object[0]);
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.HttpDispatcher", "sendAmdcRequest", null, DispatchConstants.HOSTS, set.toString());
        }
        HashMap map = new HashMap();
        map.put(DispatchConstants.HOSTS, set);
        map.put(DispatchConstants.CONFIG_VERSION, String.valueOf(i2));
        this.f1960b.a(map);
    }

    public void setEnable(boolean z) {
        this.f1961c = z;
    }

    public void switchENV() {
        this.f1962d.clear();
        this.f1963e.clear();
        this.f1964f.set(false);
    }

    private HttpDispatcher() {
        this.f1959a = new CopyOnWriteArraySet<>();
        this.f1960b = new anet.channel.strategy.dispatch.a();
        this.f1961c = true;
        this.f1962d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f1963e = new TreeSet();
        this.f1964f = new AtomicBoolean();
        a();
    }

    private void a() {
        if (this.f1964f.get() || GlobalAppRuntimeInfo.getContext() == null || !this.f1964f.compareAndSet(false, true)) {
            return;
        }
        this.f1963e.add(DispatchConstants.getAmdcServerDomain());
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            this.f1963e.addAll(Arrays.asList(DispatchConstants.initHostArray));
        }
    }
}
