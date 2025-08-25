package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class l implements Parcelable.Creator<NetworkResponse> {
    l() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NetworkResponse createFromParcel(Parcel parcel) {
        return NetworkResponse.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NetworkResponse[] newArray(int i2) {
        return new NetworkResponse[i2];
    }
}
