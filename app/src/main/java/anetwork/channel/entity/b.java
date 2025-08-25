package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.aidl.d;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class b implements Parcelable.Creator<BodyHandlerEntry> {
    b() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BodyHandlerEntry createFromParcel(Parcel parcel) {
        BodyHandlerEntry bodyHandlerEntry = new BodyHandlerEntry((b) null);
        bodyHandlerEntry.f2184a = d.a.a(parcel.readStrongBinder());
        return bodyHandlerEntry;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BodyHandlerEntry[] newArray(int i2) {
        return new BodyHandlerEntry[i2];
    }
}
