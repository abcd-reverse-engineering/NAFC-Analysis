package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParamInfo implements Parcelable {
    public static final Parcelable.Creator<ParamInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6142a;

    /* renamed from: b, reason: collision with root package name */
    private String f6143b;

    /* renamed from: c, reason: collision with root package name */
    private String f6144c;

    /* renamed from: d, reason: collision with root package name */
    private int f6145d;

    /* renamed from: e, reason: collision with root package name */
    private String f6146e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6147f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6148g;

    /* renamed from: h, reason: collision with root package name */
    private String f6149h;

    /* renamed from: i, reason: collision with root package name */
    private String f6150i;

    class a implements Parcelable.Creator<ParamInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParamInfo createFromParcel(Parcel parcel) {
            return new ParamInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParamInfo[] newArray(int i2) {
            return new ParamInfo[i2];
        }
    }

    protected ParamInfo(Parcel parcel) {
        this.f6142a = parcel.readString();
        this.f6143b = parcel.readString();
        this.f6144c = parcel.readString();
        this.f6145d = parcel.readInt();
        this.f6146e = parcel.readString();
        this.f6147f = parcel.readByte() != 0;
        this.f6148g = parcel.readByte() != 0;
        this.f6149h = parcel.readString();
        this.f6150i = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6142a);
        parcel.writeString(this.f6143b);
        parcel.writeString(this.f6144c);
        parcel.writeInt(this.f6145d);
        parcel.writeString(this.f6146e);
        parcel.writeByte(this.f6147f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6148g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6149h);
        parcel.writeString(this.f6150i);
    }
}
