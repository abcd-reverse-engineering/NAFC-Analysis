package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anetwork.channel.aidl.d;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b extends d.a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f2152e = "anet.ParcelableBodyHandlerWrapper";

    /* renamed from: d, reason: collision with root package name */
    private a.a.b f2153d;

    public b(a.a.b bVar) {
        this.f2153d = bVar;
    }

    @Override // anetwork.channel.aidl.d
    public boolean g() throws RemoteException {
        a.a.b bVar = this.f2153d;
        if (bVar != null) {
            return bVar.g();
        }
        return true;
    }

    @Override // anetwork.channel.aidl.d
    public int read(byte[] bArr) throws RemoteException {
        a.a.b bVar = this.f2153d;
        if (bVar != null) {
            return bVar.read(bArr);
        }
        return 0;
    }

    public String toString() {
        return super.toString() + " handle:" + this.f2153d;
    }
}
