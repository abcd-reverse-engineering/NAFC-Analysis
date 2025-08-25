package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PermissionInfo implements Parcelable {
    public static final Parcelable.Creator<PermissionInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6004a;

    /* renamed from: b, reason: collision with root package name */
    private String f6005b;

    /* renamed from: c, reason: collision with root package name */
    private String f6006c;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public PermissionInfo createFromParcel(Parcel parcel) {
            return new PermissionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PermissionInfo[] newArray(int i2) {
            return new PermissionInfo[i2];
        }
    }

    public PermissionInfo() {
    }

    public String a() {
        return this.f6006c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6004a);
        parcel.writeString(this.f6005b);
        parcel.writeString(this.f6006c);
    }

    public PermissionInfo(Parcel parcel) {
        this.f6004a = parcel.readString();
        this.f6005b = parcel.readString();
        this.f6006c = parcel.readString();
    }

    public PermissionInfo a(String str) {
        this.f6006c = str;
        return this;
    }
}
