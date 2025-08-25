package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ParcelableRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableRequest> CREATOR = new n();

    /* renamed from: a, reason: collision with root package name */
    public a.a.h f2090a;

    /* renamed from: b, reason: collision with root package name */
    public BodyEntry f2091b;

    /* renamed from: c, reason: collision with root package name */
    public int f2092c;

    /* renamed from: d, reason: collision with root package name */
    public String f2093d;

    /* renamed from: e, reason: collision with root package name */
    public String f2094e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2095f;

    /* renamed from: g, reason: collision with root package name */
    public String f2096g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f2097h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f2098i;

    /* renamed from: j, reason: collision with root package name */
    public int f2099j;

    /* renamed from: k, reason: collision with root package name */
    public int f2100k;

    /* renamed from: l, reason: collision with root package name */
    public String f2101l;

    /* renamed from: m, reason: collision with root package name */
    public String f2102m;
    public Map<String, String> n;

    public ParcelableRequest(a.a.h hVar) {
        this.f2097h = null;
        this.f2098i = null;
        this.f2090a = hVar;
        if (hVar != null) {
            this.f2093d = hVar.b();
            this.f2092c = hVar.k();
            this.f2094e = hVar.g();
            this.f2095f = hVar.h();
            this.f2096g = hVar.f();
            List<a.a.a> listA = hVar.a();
            if (listA != null) {
                this.f2097h = new HashMap();
                for (a.a.a aVar : listA) {
                    this.f2097h.put(aVar.getName(), aVar.getValue());
                }
            }
            List<a.a.g> params = hVar.getParams();
            if (params != null) {
                this.f2098i = new HashMap();
                for (a.a.g gVar : params) {
                    this.f2098i.put(gVar.getKey(), gVar.getValue());
                }
            }
            this.f2091b = hVar.i();
            this.f2099j = hVar.getConnectTimeout();
            this.f2100k = hVar.getReadTimeout();
            this.f2101l = hVar.n();
            this.f2102m = hVar.l();
            this.n = hVar.d();
        }
    }

    public static ParcelableRequest a(Parcel parcel) {
        ParcelableRequest parcelableRequest = new ParcelableRequest();
        try {
            parcelableRequest.f2092c = parcel.readInt();
            parcelableRequest.f2093d = parcel.readString();
            parcelableRequest.f2094e = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            parcelableRequest.f2095f = z;
            parcelableRequest.f2096g = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.f2097h = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            if (parcel.readInt() != 0) {
                parcelableRequest.f2098i = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            parcelableRequest.f2091b = (BodyEntry) parcel.readParcelable(ParcelableRequest.class.getClassLoader());
            parcelableRequest.f2099j = parcel.readInt();
            parcelableRequest.f2100k = parcel.readInt();
            parcelableRequest.f2101l = parcel.readString();
            parcelableRequest.f2102m = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.n = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
        } catch (Throwable th) {
            ALog.w("anet.ParcelableRequest", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        a.a.h hVar = this.f2090a;
        if (hVar == null) {
            return;
        }
        try {
            parcel.writeInt(hVar.k());
            parcel.writeString(this.f2093d);
            parcel.writeString(this.f2090a.g());
            parcel.writeInt(this.f2090a.h() ? 1 : 0);
            parcel.writeString(this.f2090a.f());
            parcel.writeInt(this.f2097h == null ? 0 : 1);
            if (this.f2097h != null) {
                parcel.writeMap(this.f2097h);
            }
            parcel.writeInt(this.f2098i == null ? 0 : 1);
            if (this.f2098i != null) {
                parcel.writeMap(this.f2098i);
            }
            parcel.writeParcelable(this.f2091b, 0);
            parcel.writeInt(this.f2090a.getConnectTimeout());
            parcel.writeInt(this.f2090a.getReadTimeout());
            parcel.writeString(this.f2090a.n());
            parcel.writeString(this.f2090a.l());
            Map<String, String> mapD = this.f2090a.d();
            parcel.writeInt(mapD == null ? 0 : 1);
            if (mapD != null) {
                parcel.writeMap(mapD);
            }
        } catch (Throwable th) {
            ALog.w("anet.ParcelableRequest", "[writeToParcel]", null, th, new Object[0]);
        }
    }

    public String a(String str) {
        Map<String, String> map = this.n;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public ParcelableRequest() {
        this.f2097h = null;
        this.f2098i = null;
    }
}
