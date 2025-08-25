package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.e;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c extends e.a {

    /* renamed from: h, reason: collision with root package name */
    private static final String f2154h = "anet.ParcelableFutureResponse";

    /* renamed from: f, reason: collision with root package name */
    Future<a.a.i> f2155f;

    /* renamed from: g, reason: collision with root package name */
    NetworkResponse f2156g;

    public c(Future<a.a.i> future) {
        this.f2155f = future;
    }

    @Override // anetwork.channel.aidl.e
    public NetworkResponse a(long j2) throws RemoteException {
        Future<a.a.i> future = this.f2155f;
        if (future == null) {
            NetworkResponse networkResponse = this.f2156g;
            return networkResponse != null ? networkResponse : new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
        try {
            return (NetworkResponse) future.get(j2, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            if ("NO SUPPORT".equalsIgnoreCase(e2.getMessage())) {
                ALog.e(f2154h, "[get]有listener将不支持future.get()方法，如有需要请listener传入null", null, e2, new Object[0]);
            }
            return new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
    }

    @Override // anetwork.channel.aidl.e
    public boolean cancel(boolean z) throws RemoteException {
        Future<a.a.i> future = this.f2155f;
        if (future == null) {
            return true;
        }
        return future.cancel(z);
    }

    @Override // anetwork.channel.aidl.e
    public boolean isCancelled() throws RemoteException {
        Future<a.a.i> future = this.f2155f;
        if (future == null) {
            return true;
        }
        return future.isCancelled();
    }

    @Override // anetwork.channel.aidl.e
    public boolean isDone() throws RemoteException {
        Future<a.a.i> future = this.f2155f;
        if (future == null) {
            return true;
        }
        return future.isDone();
    }
}
