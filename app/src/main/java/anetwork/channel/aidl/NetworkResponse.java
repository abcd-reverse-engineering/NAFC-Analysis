package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkResponse implements Parcelable, a.a.i {
    public static final Parcelable.Creator<NetworkResponse> CREATOR = new l();

    /* renamed from: a, reason: collision with root package name */
    int f2077a;

    /* renamed from: b, reason: collision with root package name */
    private String f2078b;

    /* renamed from: c, reason: collision with root package name */
    byte[] f2079c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, List<String>> f2080d;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f2081e;

    /* renamed from: f, reason: collision with root package name */
    private a.a.s.a f2082f;

    public NetworkResponse() {
    }

    public void a(int i2) {
        this.f2077a = i2;
        this.f2078b = ErrorConstant.getErrMsg(i2);
    }

    @Override // a.a.i
    public String d() {
        return this.f2078b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a.a.i
    public a.a.s.a e() {
        return this.f2082f;
    }

    @Override // a.a.i
    public Map<String, List<String>> f() {
        return this.f2080d;
    }

    @Override // a.a.i
    public Throwable g() {
        return this.f2081e;
    }

    @Override // a.a.i
    public int getStatusCode() {
        return this.f2077a;
    }

    @Override // a.a.i
    public byte[] n() {
        return this.f2079c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkResponse [");
        sb.append("statusCode=");
        sb.append(this.f2077a);
        sb.append(", desc=");
        sb.append(this.f2078b);
        sb.append(", connHeadFields=");
        sb.append(this.f2080d);
        sb.append(", bytedata=");
        byte[] bArr = this.f2079c;
        sb.append(bArr != null ? new String(bArr) : "");
        sb.append(", error=");
        sb.append(this.f2081e);
        sb.append(", statisticData=");
        sb.append(this.f2082f);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2077a);
        parcel.writeString(this.f2078b);
        byte[] bArr = this.f2079c;
        int length = bArr != null ? bArr.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.f2079c);
        }
        parcel.writeMap(this.f2080d);
        a.a.s.a aVar = this.f2082f;
        if (aVar != null) {
            parcel.writeSerializable(aVar);
        }
    }

    public NetworkResponse(int i2) {
        this.f2077a = i2;
        this.f2078b = ErrorConstant.getErrMsg(i2);
    }

    public void a(byte[] bArr) {
        this.f2079c = bArr;
    }

    public void a(Map<String, List<String>> map) {
        this.f2080d = map;
    }

    public void a(String str) {
        this.f2078b = str;
    }

    public void a(Throwable th) {
        this.f2081e = th;
    }

    public static NetworkResponse a(Parcel parcel) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            networkResponse.f2077a = parcel.readInt();
            networkResponse.f2078b = parcel.readString();
            int i2 = parcel.readInt();
            if (i2 > 0) {
                networkResponse.f2079c = new byte[i2];
                parcel.readByteArray(networkResponse.f2079c);
            }
            networkResponse.f2080d = parcel.readHashMap(NetworkResponse.class.getClassLoader());
            try {
                networkResponse.f2082f = (a.a.s.a) parcel.readSerializable();
            } catch (Throwable unused) {
                ALog.i("anet.NetworkResponse", "[readFromParcel] source.readSerializable() error", null, new Object[0]);
            }
        } catch (Exception e2) {
            ALog.w("anet.NetworkResponse", "[readFromParcel]", null, e2, new Object[0]);
        }
        return networkResponse;
    }

    public void a(a.a.s.a aVar) {
        this.f2082f = aVar;
    }
}
