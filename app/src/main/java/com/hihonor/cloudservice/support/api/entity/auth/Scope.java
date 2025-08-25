package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Scope implements Parcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6007a;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public Scope createFromParcel(Parcel parcel) {
            return new Scope(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Scope[] newArray(int i2) {
            return new Scope[i2];
        }
    }

    public Scope() {
        this.f6007a = null;
    }

    public String a() {
        return this.f6007a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Scope)) {
            return false;
        }
        return ((Scope) obj).f6007a.equals(this.f6007a);
    }

    public final int hashCode() {
        String str = this.f6007a;
        return str == null ? super.hashCode() : str.hashCode();
    }

    public final String toString() {
        return this.f6007a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6007a);
    }

    public Scope(String str) {
        this.f6007a = str;
    }

    protected Scope(Parcel parcel) {
        this.f6007a = parcel.readString();
    }
}
