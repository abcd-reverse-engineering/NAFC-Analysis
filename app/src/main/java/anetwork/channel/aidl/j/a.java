package anetwork.channel.aidl.j;

import a.a.d;
import a.a.e;
import android.os.Build;
import android.os.RemoteException;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a extends a.AbstractBinderC0017a implements d.a, d.b, d.InterfaceC0000d {

    /* renamed from: h, reason: collision with root package name */
    private d f2146h;

    /* renamed from: i, reason: collision with root package name */
    private int f2147i;

    /* renamed from: j, reason: collision with root package name */
    private String f2148j;

    /* renamed from: k, reason: collision with root package name */
    private Map<String, List<String>> f2149k;

    /* renamed from: l, reason: collision with root package name */
    private a.a.s.a f2150l;

    /* renamed from: m, reason: collision with root package name */
    private CountDownLatch f2151m = new CountDownLatch(1);
    private CountDownLatch n = new CountDownLatch(1);
    private anetwork.channel.aidl.e o;
    private anetwork.channel.entity.k p;

    public a(int i2) {
        this.f2147i = i2;
        this.f2148j = ErrorConstant.getErrMsg(i2);
    }

    public void a(anetwork.channel.aidl.e eVar) {
        this.o = eVar;
    }

    @Override // anetwork.channel.aidl.a
    public void cancel() throws RemoteException {
        anetwork.channel.aidl.e eVar = this.o;
        if (eVar != null) {
            eVar.cancel(true);
        }
    }

    @Override // anetwork.channel.aidl.a
    public String d() throws RemoteException {
        a(this.f2151m);
        return this.f2148j;
    }

    @Override // anetwork.channel.aidl.a
    public a.a.s.a e() {
        return this.f2150l;
    }

    @Override // anetwork.channel.aidl.a
    public Map<String, List<String>> f() throws RemoteException {
        a(this.f2151m);
        return this.f2149k;
    }

    @Override // anetwork.channel.aidl.a
    public int getStatusCode() throws RemoteException {
        a(this.f2151m);
        return this.f2147i;
    }

    @Override // anetwork.channel.aidl.a
    public anetwork.channel.aidl.f k() throws RemoteException {
        a(this.n);
        return this.f2146h;
    }

    @Override // a.a.d.a
    public void a(e.a aVar, Object obj) {
        this.f2147i = aVar.f();
        this.f2148j = aVar.d() != null ? aVar.d() : ErrorConstant.getErrMsg(this.f2147i);
        this.f2150l = aVar.e();
        d dVar = this.f2146h;
        if (dVar != null) {
            dVar.a();
        }
        this.n.countDown();
        this.f2151m.countDown();
    }

    public a(anetwork.channel.entity.k kVar) {
        this.p = kVar;
    }

    private void a(CountDownLatch countDownLatch) throws RemoteException {
        try {
            if (countDownLatch.await(this.p.b() + 1000, TimeUnit.MILLISECONDS)) {
                return;
            }
            if (this.o != null) {
                this.o.cancel(true);
            }
            throw a("wait time out");
        } catch (InterruptedException unused) {
            throw a("thread interrupt");
        }
    }

    private RemoteException a(String str) {
        if (Build.VERSION.SDK_INT >= 15) {
            return new RemoteException(str);
        }
        return new RemoteException();
    }

    @Override // a.a.d.InterfaceC0000d
    public boolean a(int i2, Map<String, List<String>> map, Object obj) {
        this.f2147i = i2;
        this.f2148j = ErrorConstant.getErrMsg(this.f2147i);
        this.f2149k = map;
        this.f2151m.countDown();
        return false;
    }

    @Override // a.a.d.b
    public void a(anetwork.channel.aidl.f fVar, Object obj) {
        this.f2146h = (d) fVar;
        this.n.countDown();
    }
}
