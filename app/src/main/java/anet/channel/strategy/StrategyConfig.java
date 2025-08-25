package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyConfig implements Serializable {
    public static final String NO_RESULT = "No_Result";

    /* renamed from: a, reason: collision with root package name */
    private SerialLruCache<String, String> f1928a = null;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f1929b = null;

    /* renamed from: c, reason: collision with root package name */
    private transient StrategyInfoHolder f1930c = null;

    StrategyConfig() {
    }

    StrategyConfig a() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.f1928a = new SerialLruCache<>(this.f1928a, 256);
            strategyConfig.f1929b = new ConcurrentHashMap(this.f1929b);
            strategyConfig.f1930c = this.f1930c;
        }
        return strategyConfig;
    }

    void b() {
        if (this.f1928a == null) {
            this.f1928a = new SerialLruCache<>(256);
        }
        if (this.f1929b == null) {
            this.f1929b = new ConcurrentHashMap();
        }
    }

    String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f1929b.get(str);
        }
        return str2;
    }

    void a(StrategyInfoHolder strategyInfoHolder) {
        this.f1930c = strategyInfoHolder;
    }

    void a(l.d dVar) {
        if (dVar.f2012b == null) {
            return;
        }
        synchronized (this) {
            TreeMap treeMap = null;
            for (int i2 = 0; i2 < dVar.f2012b.length; i2++) {
                l.b bVar = dVar.f2012b[i2];
                if (bVar.f2006j) {
                    this.f1928a.remove(bVar.f1997a);
                } else if (bVar.f2000d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap();
                    }
                    treeMap.put(bVar.f1997a, bVar.f2000d);
                } else {
                    if (!HttpConstant.HTTP.equalsIgnoreCase(bVar.f1999c) && !HttpConstant.HTTPS.equalsIgnoreCase(bVar.f1999c)) {
                        this.f1928a.put(bVar.f1997a, NO_RESULT);
                    } else {
                        this.f1928a.put(bVar.f1997a, bVar.f1999c);
                    }
                    if (!TextUtils.isEmpty(bVar.f2001e)) {
                        this.f1929b.put(bVar.f1997a, bVar.f2001e);
                    } else {
                        this.f1929b.remove(bVar.f1997a);
                    }
                }
            }
            if (treeMap != null) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    String str = (String) entry.getValue();
                    if (this.f1928a.containsKey(str)) {
                        this.f1928a.put(entry.getKey(), this.f1928a.get(str));
                    } else {
                        this.f1928a.put(entry.getKey(), NO_RESULT);
                    }
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyConfig", "", null, "SchemeMap", this.f1928a.toString());
            ALog.d("awcn.StrategyConfig", "", null, "UnitMap", this.f1929b.toString());
        }
    }

    String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.c.c(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f1928a.get(str);
            if (str2 == null) {
                this.f1928a.put(str, NO_RESULT);
            }
        }
        if (str2 == null) {
            this.f1930c.d().a(str, false);
            return str2;
        }
        if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }
}
