package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class n implements Parcelable.Creator<ParcelableRequest> {
    n() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableRequest createFromParcel(Parcel parcel) {
        return ParcelableRequest.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableRequest[] newArray(int i2) {
        return new ParcelableRequest[i2];
    }
}
