package a.a.t;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableRequest;
import anetwork.channel.aidl.h;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class b extends h.a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f1181f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final int f1182g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final String f1183h = "anet.UnifiedNetworkDelegate";

    /* renamed from: e, reason: collision with root package name */
    public int f1184e = 1;

    public b(Context context) {
        a.a.o.c.init(context);
    }

    private NetworkResponse c(ParcelableRequest parcelableRequest) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            anetwork.channel.aidl.j.a aVar = (anetwork.channel.aidl.j.a) b(parcelableRequest);
            anetwork.channel.aidl.f fVarK = aVar.k();
            if (fVarK != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(fVarK.length() > 0 ? fVarK.length() : 1024);
                ByteArray byteArrayA = a.C0012a.f1691a.a(2048);
                while (true) {
                    int i2 = fVarK.read(byteArrayA.getBuffer());
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(byteArrayA.getBuffer(), 0, i2);
                }
                networkResponse.a(byteArrayOutputStream.toByteArray());
            }
            int statusCode = aVar.getStatusCode();
            if (statusCode < 0) {
                networkResponse.a((byte[]) null);
            } else {
                networkResponse.a(aVar.f());
            }
            networkResponse.a(statusCode);
            networkResponse.a(aVar.e());
            return networkResponse;
        } catch (RemoteException e2) {
            networkResponse.a(-103);
            String message = e2.getMessage();
            if (!TextUtils.isEmpty(message)) {
                networkResponse.a(StringUtils.concatString(networkResponse.d(), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, message));
            }
            return networkResponse;
        } catch (Exception unused) {
            networkResponse.a(ErrorConstant.ERROR_REQUEST_FAIL);
            return networkResponse;
        }
    }

    @Override // anetwork.channel.aidl.h
    public NetworkResponse a(ParcelableRequest parcelableRequest) throws RemoteException {
        return c(parcelableRequest);
    }

    @Override // anetwork.channel.aidl.h
    public anetwork.channel.aidl.a b(ParcelableRequest parcelableRequest) throws RemoteException {
        try {
            anetwork.channel.entity.k kVar = new anetwork.channel.entity.k(parcelableRequest, this.f1184e, true);
            anetwork.channel.aidl.j.a aVar = new anetwork.channel.aidl.j.a(kVar);
            aVar.a(a(kVar, new anetwork.channel.aidl.j.e(aVar, null, null)));
            return aVar;
        } catch (Exception e2) {
            ALog.e(f1183h, "asyncSend failed", parcelableRequest.f2102m, e2, new Object[0]);
            throw new RemoteException(e2.getMessage());
        }
    }

    @Override // anetwork.channel.aidl.h
    public anetwork.channel.aidl.e a(ParcelableRequest parcelableRequest, anetwork.channel.aidl.g gVar) throws RemoteException {
        try {
            return a(new anetwork.channel.entity.k(parcelableRequest, this.f1184e, false), gVar);
        } catch (Exception e2) {
            ALog.e(f1183h, "asyncSend failed", parcelableRequest.f2102m, e2, new Object[0]);
            throw new RemoteException(e2.getMessage());
        }
    }

    private anetwork.channel.aidl.e a(anetwork.channel.entity.k kVar, anetwork.channel.aidl.g gVar) throws RemoteException {
        return new anetwork.channel.aidl.j.c(new m(kVar, new anetwork.channel.entity.g(gVar, kVar)).a());
    }
}
