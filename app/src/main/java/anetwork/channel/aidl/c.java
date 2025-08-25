package anetwork.channel.aidl;

import android.os.RemoteException;
import anetwork.channel.aidl.b;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class c extends b.a {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NetworkService f2114c;

    c(NetworkService networkService) {
        this.f2114c = networkService;
    }

    @Override // anetwork.channel.aidl.b
    public h get(int i2) throws RemoteException {
        return i2 == 1 ? this.f2114c.f2084b : this.f2114c.f2085c;
    }
}
