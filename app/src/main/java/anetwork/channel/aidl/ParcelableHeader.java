package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ParcelableHeader implements Parcelable {

    /* renamed from: c, reason: collision with root package name */
    public static Parcelable.Creator<ParcelableHeader> f2087c = new m();

    /* renamed from: a, reason: collision with root package name */
    public int f2088a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, List<String>> f2089b;

    public ParcelableHeader(int i2, Map<String, List<String>> map) {
        this.f2089b = map;
        this.f2088a = i2;
    }

    public Map<String, List<String>> a() {
        return this.f2089b;
    }

    public int b() {
        return this.f2088a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ParcelableResponseHeader [responseCode=" + this.f2088a + ", header=" + this.f2089b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (this.f2089b != null) {
            parcel.writeInt(1);
            parcel.writeMap(this.f2089b);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f2088a);
    }

    static ParcelableHeader a(Parcel parcel) {
        ParcelableHeader parcelableHeader = new ParcelableHeader();
        try {
            if (parcel.readInt() == 1) {
                parcelableHeader.f2089b = parcel.readHashMap(ParcelableHeader.class.getClassLoader());
            }
            parcelableHeader.f2088a = parcel.readInt();
        } catch (Throwable th) {
            ALog.e("anet.ParcelableHeader", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableHeader;
    }

    ParcelableHeader() {
    }
}
