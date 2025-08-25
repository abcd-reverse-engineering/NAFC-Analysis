package anetwork.channel.aidl.j;

import a.a.d;
import android.os.Handler;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.g;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class e extends g.a {

    /* renamed from: k, reason: collision with root package name */
    private static final String f2162k = "anet.ParcelableNetworkListenerWrapper";

    /* renamed from: g, reason: collision with root package name */
    private a.a.f f2163g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f2164h;

    /* renamed from: i, reason: collision with root package name */
    private Object f2165i;

    /* renamed from: j, reason: collision with root package name */
    private byte f2166j;

    public e(a.a.f fVar, Handler handler, Object obj) {
        this.f2166j = (byte) 0;
        this.f2163g = fVar;
        if (fVar != null) {
            if (d.a.class.isAssignableFrom(fVar.getClass())) {
                this.f2166j = (byte) (this.f2166j | 1);
            }
            if (d.c.class.isAssignableFrom(fVar.getClass())) {
                this.f2166j = (byte) (this.f2166j | 2);
            }
            if (d.InterfaceC0000d.class.isAssignableFrom(fVar.getClass())) {
                this.f2166j = (byte) (this.f2166j | 4);
            }
            if (d.b.class.isAssignableFrom(fVar.getClass())) {
                this.f2166j = (byte) (this.f2166j | 8);
            }
        }
        this.f2164h = handler;
        this.f2165i = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte b2, Object obj) {
        try {
            if (b2 == 4) {
                ParcelableHeader parcelableHeader = (ParcelableHeader) obj;
                ((d.InterfaceC0000d) this.f2163g).a(parcelableHeader.b(), parcelableHeader.a(), this.f2165i);
                if (ALog.isPrintLog(1)) {
                    ALog.d(f2162k, "[onResponseCode]" + parcelableHeader, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b2 == 2) {
                DefaultProgressEvent defaultProgressEvent = (DefaultProgressEvent) obj;
                if (defaultProgressEvent != null) {
                    defaultProgressEvent.a(this.f2165i);
                }
                ((d.c) this.f2163g).a(defaultProgressEvent, this.f2165i);
                if (ALog.isPrintLog(1)) {
                    ALog.d(f2162k, "[onDataReceived]" + defaultProgressEvent, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b2 != 1) {
                if (b2 == 8) {
                    ((d.b) this.f2163g).a((anetwork.channel.aidl.f) obj, this.f2165i);
                    if (ALog.isPrintLog(1)) {
                        ALog.d(f2162k, "[onInputStreamReceived]", null, new Object[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            DefaultFinishEvent defaultFinishEvent = (DefaultFinishEvent) obj;
            if (defaultFinishEvent != null) {
                defaultFinishEvent.a(this.f2165i);
            }
            ((d.a) this.f2163g).a(defaultFinishEvent, this.f2165i);
            if (ALog.isPrintLog(1)) {
                ALog.d(f2162k, "[onFinished]" + defaultFinishEvent, null, new Object[0]);
            }
        } catch (Exception unused) {
            ALog.e(f2162k, "dispatchCallback error", null, new Object[0]);
        }
    }

    @Override // anetwork.channel.aidl.g
    public byte j() throws RemoteException {
        return this.f2166j;
    }

    public a.a.f a() {
        return this.f2163g;
    }

    private void a(byte b2, Object obj) {
        Handler handler = this.f2164h;
        if (handler == null) {
            b(b2, obj);
        } else {
            handler.post(new h(this, b2, obj));
        }
    }

    @Override // anetwork.channel.aidl.g
    public void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
        if ((this.f2166j & 2) != 0) {
            a((byte) 2, defaultProgressEvent);
        }
    }

    @Override // anetwork.channel.aidl.g
    public void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
        if ((this.f2166j & 1) != 0) {
            a((byte) 1, defaultFinishEvent);
        }
        this.f2163g = null;
        this.f2165i = null;
        this.f2164h = null;
    }

    @Override // anetwork.channel.aidl.g
    public boolean a(int i2, ParcelableHeader parcelableHeader) throws RemoteException {
        if ((this.f2166j & 4) == 0) {
            return false;
        }
        a((byte) 4, (Object) parcelableHeader);
        return false;
    }

    @Override // anetwork.channel.aidl.g
    public void a(anetwork.channel.aidl.f fVar) throws RemoteException {
        if ((this.f2166j & 8) != 0) {
            a((byte) 8, fVar);
        }
    }
}
