package anetwork.channel.entity;

import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableHeader;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f2209a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f2210b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Map f2211c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f2212d;

    h(g gVar, anetwork.channel.aidl.g gVar2, int i2, Map map) {
        this.f2212d = gVar;
        this.f2209a = gVar2;
        this.f2210b = i2;
        this.f2211c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2209a.a(this.f2210b, new ParcelableHeader(this.f2210b, this.f2211c));
        } catch (RemoteException unused) {
        }
    }
}
