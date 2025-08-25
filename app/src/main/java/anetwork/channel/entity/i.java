package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultProgressEvent;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f2213a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ByteArray f2214b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f2215c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f2216d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ g f2217e;

    i(g gVar, int i2, ByteArray byteArray, int i3, anetwork.channel.aidl.g gVar2) {
        this.f2217e = gVar;
        this.f2213a = i2;
        this.f2214b = byteArray;
        this.f2215c = i3;
        this.f2216d = gVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f2217e.f2207d) {
                try {
                    if (this.f2217e.f2206c == null) {
                        this.f2217e.f2206c = new anetwork.channel.aidl.j.d();
                        this.f2217e.f2206c.a(this.f2217e.f2208e, this.f2215c);
                        this.f2217e.f2206c.a(this.f2214b);
                        this.f2216d.a(this.f2217e.f2206c);
                    } else {
                        this.f2217e.f2206c.a(this.f2214b);
                    }
                } catch (Exception unused) {
                    if (this.f2217e.f2206c == null) {
                    } else {
                        this.f2217e.f2206c.close();
                    }
                }
            } else {
                this.f2216d.a(new DefaultProgressEvent(this.f2213a, this.f2214b.getDataLength(), this.f2215c, this.f2214b.getBuffer()));
            }
        } catch (RemoteException unused2) {
        }
    }
}
