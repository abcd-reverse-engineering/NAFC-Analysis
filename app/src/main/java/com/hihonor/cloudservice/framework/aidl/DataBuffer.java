package com.hihonor.cloudservice.framework.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f5983a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5984b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f5985c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f5986d;

    class a implements Parcelable.Creator<DataBuffer> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (a) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataBuffer[] newArray(int i2) {
            return new DataBuffer[i2];
        }
    }

    /* synthetic */ DataBuffer(Parcel parcel, a aVar) {
        this(parcel);
    }

    public DataBuffer a(Bundle bundle) {
        this.f5986d = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f5983a);
        parcel.writeString(this.f5984b);
        parcel.writeBundle(this.f5985c);
        parcel.writeBundle(this.f5986d);
    }

    private DataBuffer(Parcel parcel) {
        this.f5985c = null;
        this.f5986d = null;
        this.f5983a = parcel.readInt();
        this.f5984b = parcel.readString();
        this.f5985c = parcel.readBundle(a((Class<?>) Bundle.class));
        this.f5986d = parcel.readBundle(a((Class<?>) Bundle.class));
    }

    private static ClassLoader a(Class<?> cls) {
        return cls == null ? ClassLoader.getSystemClassLoader() : cls.getClassLoader();
    }

    public DataBuffer(String str, int i2) {
        this.f5985c = null;
        this.f5986d = null;
        this.f5984b = str;
        this.f5983a = i2;
    }
}
