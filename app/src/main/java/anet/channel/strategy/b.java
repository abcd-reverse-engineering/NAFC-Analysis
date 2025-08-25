package anet.channel.strategy;

import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.net.InetAddress;
import java.util.Collections;
import java.util.LinkedList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1951a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f1952b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f1953c;

    b(a aVar, String str, Object obj) {
        this.f1953c = aVar;
        this.f1951a = str;
        this.f1952b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                String hostAddress = InetAddress.getByName(this.f1951a).getHostAddress();
                LinkedList linkedList = new LinkedList();
                ConnProtocol connProtocol = StrategyTemplate.getInstance().getConnProtocol(this.f1951a);
                if (connProtocol != null) {
                    linkedList.add(IPConnStrategy.a(hostAddress, !this.f1953c.a(connProtocol) ? 80 : Constants.PORT, connProtocol, 0, 0, 1, 45000));
                }
                linkedList.add(IPConnStrategy.a(hostAddress, 80, ConnProtocol.HTTP, 0, 0, 0, 0));
                linkedList.add(IPConnStrategy.a(hostAddress, Constants.PORT, ConnProtocol.HTTPS, 0, 0, 0, 0));
                this.f1953c.f1949a.put(this.f1951a, linkedList);
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, Constants.KEY_HOST, this.f1951a, "ip", hostAddress, "list", linkedList);
                }
                synchronized (this.f1953c.f1950b) {
                    this.f1953c.f1950b.remove(this.f1951a);
                }
                synchronized (this.f1952b) {
                    this.f1952b.notifyAll();
                }
            } catch (Exception unused) {
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.LocalDnsStrategyTable", "resolve ip by local dns failed", null, Constants.KEY_HOST, this.f1951a);
                }
                this.f1953c.f1949a.put(this.f1951a, Collections.EMPTY_LIST);
                synchronized (this.f1953c.f1950b) {
                    this.f1953c.f1950b.remove(this.f1951a);
                    synchronized (this.f1952b) {
                        this.f1952b.notifyAll();
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (this.f1953c.f1950b) {
                this.f1953c.f1950b.remove(this.f1951a);
                synchronized (this.f1952b) {
                    this.f1952b.notifyAll();
                    throw th;
                }
            }
        }
    }
}
