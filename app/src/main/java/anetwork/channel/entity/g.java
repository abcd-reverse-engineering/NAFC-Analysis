package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class g implements a.a.p.a {

    /* renamed from: a, reason: collision with root package name */
    private anetwork.channel.aidl.g f2204a;

    /* renamed from: b, reason: collision with root package name */
    private String f2205b;

    /* renamed from: c, reason: collision with root package name */
    private anetwork.channel.aidl.j.d f2206c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2207d;

    /* renamed from: e, reason: collision with root package name */
    private k f2208e;

    public g(anetwork.channel.aidl.g gVar, k kVar) {
        this.f2207d = false;
        this.f2208e = null;
        this.f2204a = gVar;
        this.f2208e = kVar;
        if (gVar != null) {
            try {
                if ((gVar.j() & 8) != 0) {
                    this.f2207d = true;
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // a.a.p.a
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onResponseCode]", this.f2205b, new Object[0]);
        }
        anetwork.channel.aidl.g gVar = this.f2204a;
        if (gVar != null) {
            a(new h(this, gVar, i2, map));
        }
    }

    @Override // a.a.p.a
    public void a(int i2, int i3, ByteArray byteArray) {
        anetwork.channel.aidl.g gVar = this.f2204a;
        if (gVar != null) {
            a(new i(this, i2, byteArray, i3, gVar));
        }
    }

    @Override // a.a.p.a
    public void a(DefaultFinishEvent defaultFinishEvent) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onFinish] ", this.f2205b, new Object[0]);
        }
        anetwork.channel.aidl.g gVar = this.f2204a;
        if (gVar != null) {
            j jVar = new j(this, defaultFinishEvent, gVar);
            RequestStatistic requestStatistic = defaultFinishEvent.f2070e;
            if (requestStatistic != null) {
                requestStatistic.rspCbDispatch = System.currentTimeMillis();
            }
            a(jVar);
        }
        this.f2204a = null;
    }

    private void a(Runnable runnable) {
        if (this.f2208e.c()) {
            runnable.run();
        } else {
            String str = this.f2205b;
            e.a(str != null ? str.hashCode() : hashCode(), runnable);
        }
    }

    public void a(String str) {
        this.f2205b = str;
    }
}
