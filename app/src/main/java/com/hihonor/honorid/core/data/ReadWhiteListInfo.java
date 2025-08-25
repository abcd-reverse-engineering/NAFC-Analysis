package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ReadWhiteListInfo implements Parcelable {
    public static final Parcelable.Creator<ReadWhiteListInfo> CREATOR = new a();

    class a implements Parcelable.Creator<ReadWhiteListInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadWhiteListInfo createFromParcel(Parcel parcel) {
            return new ReadWhiteListInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadWhiteListInfo[] newArray(int i2) {
            return new ReadWhiteListInfo[i2];
        }
    }

    protected ReadWhiteListInfo(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
    }
}
