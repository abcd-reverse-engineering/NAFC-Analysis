package anetwork.channel.aidl.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableRequest;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class g implements a.a.c {

    /* renamed from: d, reason: collision with root package name */
    protected static String f2169d = "anet.NetworkProxy";

    /* renamed from: e, reason: collision with root package name */
    protected static final int f2170e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected static final int f2171f = 1;

    /* renamed from: a, reason: collision with root package name */
    private volatile anetwork.channel.aidl.h f2172a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f2173b;

    /* renamed from: c, reason: collision with root package name */
    private Context f2174c;

    public g(Context context, int i2) {
        this.f2173b = 0;
        this.f2174c = context;
        this.f2173b = i2;
    }

    @Override // a.a.c
    public a.a.i a(a.a.h hVar, Object obj) {
        ALog.i(f2169d, "networkProxy syncSend", hVar.l(), new Object[0]);
        a(hVar);
        a(true);
        ParcelableRequest parcelableRequest = new ParcelableRequest(hVar);
        if (parcelableRequest.f2093d == null) {
            return new NetworkResponse(-102);
        }
        try {
            return this.f2172a.a(parcelableRequest);
        } catch (Throwable th) {
            a(th, "[syncSend]call syncSend method failed.");
            return new NetworkResponse(-103);
        }
    }

    @Override // a.a.c
    public anetwork.channel.aidl.a b(a.a.h hVar, Object obj) {
        ALog.i(f2169d, "networkProxy getConnection", hVar.l(), new Object[0]);
        a(hVar);
        a(true);
        ParcelableRequest parcelableRequest = new ParcelableRequest(hVar);
        if (parcelableRequest.f2093d == null) {
            return new a(-102);
        }
        try {
            return this.f2172a.b(parcelableRequest);
        } catch (Throwable th) {
            a(th, "[getConnection]call getConnection method failed.");
            return new a(-103);
        }
    }

    private void a(boolean z) {
        if (this.f2172a != null) {
            return;
        }
        if (a.a.k.b.n()) {
            boolean zIsTargetProcess = GlobalAppRuntimeInfo.isTargetProcess();
            if (a.a.k.b.h() && zIsTargetProcess) {
                i.a(this.f2174c, false);
                if (i.f2180c && this.f2172a == null) {
                    this.f2172a = this.f2173b == 1 ? new a.a.m.b(this.f2174c) : new a.a.o.b(this.f2174c);
                    ALog.i(f2169d, "[initDelegateInstance] getNetworkInstance when binding service", null, new Object[0]);
                    return;
                } else {
                    a(this.f2173b);
                    if (this.f2172a != null) {
                        return;
                    }
                }
            } else {
                i.a(this.f2174c, z);
                a(this.f2173b);
                if (this.f2172a != null) {
                    return;
                }
            }
            if (a.a.k.b.f() && zIsTargetProcess && i.f2179b) {
                synchronized (this) {
                    if (this.f2172a == null) {
                        this.f2172a = this.f2173b == 1 ? new a.a.m.b(this.f2174c) : new a.a.o.b(this.f2174c);
                        ALog.e(f2169d, "[initDelegateInstance] getNetworkInstance when bindService failed.", null, new Object[0]);
                        return;
                    }
                }
            }
        }
        synchronized (this) {
            if (this.f2172a == null) {
                if (ALog.isPrintLog(2)) {
                    ALog.i(f2169d, "[getLocalNetworkInstance]", null, new Object[0]);
                }
                this.f2172a = new a.a.o.b(this.f2174c);
            }
        }
    }

    @Override // a.a.c
    public Future<a.a.i> a(a.a.h hVar, Object obj, Handler handler, a.a.f fVar) {
        ALog.i(f2169d, "networkProxy asyncSend", hVar.l(), new Object[0]);
        a(hVar);
        a(Looper.myLooper() != Looper.getMainLooper());
        ParcelableRequest parcelableRequest = new ParcelableRequest(hVar);
        e eVar = (fVar == null && handler == null) ? null : new e(fVar, handler, obj);
        if (parcelableRequest.f2093d == null) {
            if (eVar != null) {
                try {
                    eVar.a(new DefaultFinishEvent(-102));
                } catch (RemoteException unused) {
                }
            }
            return new f(new NetworkResponse(-102));
        }
        try {
            return new f(this.f2172a.a(parcelableRequest, eVar));
        } catch (Throwable th) {
            if (eVar != null) {
                try {
                    eVar.a(new DefaultFinishEvent(-102));
                } catch (RemoteException unused2) {
                }
            }
            a(th, "[asyncSend]call asyncSend exception");
            return new f(new NetworkResponse(-103));
        }
    }

    private synchronized void a(int i2) {
        if (this.f2172a != null) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i(f2169d, "[tryGetRemoteNetworkInstance] type=" + i2, null, new Object[0]);
        }
        anetwork.channel.aidl.b bVarA = i.a();
        if (bVarA != null) {
            try {
                this.f2172a = bVarA.get(i2);
            } catch (Throwable th) {
                a(th, "[tryGetRemoteNetworkInstance]get RemoteNetwork Delegate failed.");
            }
        }
    }

    private void a(Throwable th, String str) {
        ALog.e(f2169d, null, str, th, new Object[0]);
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(-103, null, "rt");
        exceptionStatistic.exceptionStack = th.toString();
        AppMonitor.getInstance().commitStat(exceptionStatistic);
    }

    private void a(a.a.h hVar) {
        if (hVar == null) {
            return;
        }
        hVar.a(a.a.u.a.o, String.valueOf(System.currentTimeMillis()));
        String strF = hVar.f(a.a.u.a.p);
        if (TextUtils.isEmpty(strF)) {
            strF = anet.channel.fulltrace.a.a().createRequest();
        }
        hVar.a(a.a.u.a.p, strF);
        hVar.a(a.a.u.a.q, GlobalAppRuntimeInfo.getCurrentProcess());
    }
}
