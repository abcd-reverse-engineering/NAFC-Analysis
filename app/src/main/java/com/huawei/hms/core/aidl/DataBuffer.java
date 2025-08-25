package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();
    public String URI;

    /* renamed from: a, reason: collision with root package name */
    private int f6791a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f6792b;
    public Bundle header;

    class a implements Parcelable.Creator<DataBuffer> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer[] newArray(int i2) {
            return new DataBuffer[i2];
        }
    }

    /* synthetic */ DataBuffer(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static ClassLoader a(Class cls) {
        return cls.getClassLoader();
    }

    public DataBuffer addBody(Bundle bundle) {
        this.f6792b = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.f6792b;
    }

    public int getBodySize() {
        return this.f6792b == null ? 0 : 1;
    }

    public int getProtocol() {
        return this.f6791a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.f6791a);
        parcel.writeString(this.URI);
        parcel.writeBundle(this.header);
        parcel.writeBundle(this.f6792b);
    }

    private DataBuffer(Parcel parcel) {
        this.header = null;
        this.f6791a = 1;
        this.f6792b = null;
        a(parcel);
    }

    private void a(Parcel parcel) {
        this.f6791a = parcel.readInt();
        this.URI = parcel.readString();
        this.header = parcel.readBundle(a(Bundle.class));
        this.f6792b = parcel.readBundle(a(Bundle.class));
    }

    public DataBuffer() {
        this.header = null;
        this.f6791a = 1;
        this.f6792b = null;
    }

    public DataBuffer(String str) {
        this.header = null;
        this.f6791a = 1;
        this.f6792b = null;
        this.URI = str;
    }

    public DataBuffer(String str, int i2) {
        this.header = null;
        this.f6792b = null;
        this.URI = str;
        this.f6791a = i2;
    }
}
