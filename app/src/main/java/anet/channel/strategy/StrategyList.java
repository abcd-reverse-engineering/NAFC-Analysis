package anet.channel.strategy;

import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyList implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private List<IPConnStrategy> f1937a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, ConnHistoryItem> f1938b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1939c;

    /* renamed from: d, reason: collision with root package name */
    private transient Comparator<IPConnStrategy> f1940d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    interface Predicate<T> {
        boolean apply(T t);
    }

    public StrategyList() {
        this.f1937a = new ArrayList();
        this.f1938b = new SerialLruCache(40);
        this.f1939c = false;
        this.f1940d = null;
    }

    public void checkInit() {
        if (this.f1937a == null) {
            this.f1937a = new ArrayList();
        }
        if (this.f1938b == null) {
            this.f1938b = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.f1938b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().d()) {
                it.remove();
            }
        }
        for (IPConnStrategy iPConnStrategy : this.f1937a) {
            if (!this.f1938b.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.f1938b.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.f1937a, a());
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.f1937a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy iPConnStrategy : this.f1937a) {
            ConnHistoryItem connHistoryItem = this.f1938b.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            if (connHistoryItem == null || !connHistoryItem.c()) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(iPConnStrategy);
            } else {
                ALog.i("awcn.StrategyList", "strategy ban!", null, Constants.KEY_STRATEGY, iPConnStrategy);
            }
        }
        return linkedList == null ? Collections.EMPTY_LIST : linkedList;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (!(iConnStrategy instanceof IPConnStrategy) || this.f1937a.indexOf(iConnStrategy) == -1) {
            return;
        }
        this.f1938b.get(Integer.valueOf(((IPConnStrategy) iConnStrategy).getUniqueId())).a(connEvent.isSuccess);
        Collections.sort(this.f1937a, this.f1940d);
    }

    public boolean shouldRefresh() {
        boolean z = true;
        boolean z2 = true;
        for (IPConnStrategy iPConnStrategy : this.f1937a) {
            if (!this.f1938b.get(Integer.valueOf(iPConnStrategy.getUniqueId())).b()) {
                if (iPConnStrategy.f1917a == 0) {
                    z = false;
                }
                z2 = false;
            }
        }
        return (this.f1939c && z) || z2;
    }

    public String toString() {
        return new ArrayList(this.f1937a).toString();
    }

    public void update(l.b bVar) {
        Iterator<IPConnStrategy> it = this.f1937a.iterator();
        while (it.hasNext()) {
            it.next().f1919c = true;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bVar.f2004h.length; i3++) {
            int i4 = 0;
            while (true) {
                String[] strArr = bVar.f2002f;
                if (i4 >= strArr.length) {
                    break;
                }
                a(strArr[i4], 1, bVar.f2004h[i3]);
                i4++;
            }
            if (bVar.f2003g != null) {
                this.f1939c = true;
                int i5 = 0;
                while (true) {
                    String[] strArr2 = bVar.f2003g;
                    if (i5 < strArr2.length) {
                        a(strArr2[i5], 0, bVar.f2004h[i3]);
                        i5++;
                    }
                }
            } else {
                this.f1939c = false;
            }
        }
        if (bVar.f2005i != null) {
            while (true) {
                l.e[] eVarArr = bVar.f2005i;
                if (i2 >= eVarArr.length) {
                    break;
                }
                l.e eVar = eVarArr[i2];
                String str = eVar.f2019a;
                a(str, anet.channel.strategy.utils.c.c(str) ? -1 : 1, eVar.f2020b);
                i2++;
            }
        }
        ListIterator<IPConnStrategy> listIterator = this.f1937a.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f1919c) {
                listIterator.remove();
            }
        }
        Collections.sort(this.f1937a, a());
    }

    private void a(String str, int i2, l.a aVar) {
        int iA = a(this.f1937a, new j(this, aVar, str, ConnProtocol.valueOf(aVar)));
        if (iA != -1) {
            IPConnStrategy iPConnStrategy = this.f1937a.get(iA);
            iPConnStrategy.cto = aVar.f1991c;
            iPConnStrategy.rto = aVar.f1992d;
            iPConnStrategy.heartbeat = aVar.f1994f;
            iPConnStrategy.f1917a = i2;
            iPConnStrategy.f1918b = 0;
            iPConnStrategy.f1919c = false;
            return;
        }
        IPConnStrategy iPConnStrategyA = IPConnStrategy.a(str, aVar);
        if (iPConnStrategyA != null) {
            iPConnStrategyA.f1917a = i2;
            iPConnStrategyA.f1918b = 0;
            if (!this.f1938b.containsKey(Integer.valueOf(iPConnStrategyA.getUniqueId()))) {
                this.f1938b.put(Integer.valueOf(iPConnStrategyA.getUniqueId()), new ConnHistoryItem());
            }
            this.f1937a.add(iPConnStrategyA);
        }
    }

    StrategyList(List<IPConnStrategy> list) {
        this.f1937a = new ArrayList();
        this.f1938b = new SerialLruCache(40);
        this.f1939c = false;
        this.f1940d = null;
        this.f1937a = list;
    }

    private Comparator a() {
        if (this.f1940d == null) {
            this.f1940d = new k(this);
        }
        return this.f1940d;
    }

    private static <T> int a(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        int i2 = 0;
        Iterator<T> it = collection.iterator();
        while (it.hasNext() && !predicate.apply(it.next())) {
            i2++;
        }
        if (i2 == collection.size()) {
            return -1;
        }
        return i2;
    }
}
