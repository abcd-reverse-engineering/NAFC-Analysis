package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class k implements Parcelable.Creator<DefaultProgressEvent> {
    k() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultProgressEvent createFromParcel(Parcel parcel) {
        return DefaultProgressEvent.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultProgressEvent[] newArray(int i2) {
        return new DefaultProgressEvent[i2];
    }
}
