package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TmemberRight implements Parcelable {
    public static final Parcelable.Creator<TmemberRight> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    public static final String f6151i = "userId";

    /* renamed from: j, reason: collision with root package name */
    public static final String f6152j = "deviceType";

    /* renamed from: k, reason: collision with root package name */
    public static final String f6153k = "deviceId";

    /* renamed from: l, reason: collision with root package name */
    public static final String f6154l = "deviceID2";

    /* renamed from: m, reason: collision with root package name */
    public static final String f6155m = "terminalType";
    public static final String n = "rightsId";
    public static final String o = "memberBindTime";
    public static final String p = "expiredDate";

    /* renamed from: a, reason: collision with root package name */
    private long f6156a;

    /* renamed from: b, reason: collision with root package name */
    private int f6157b;

    /* renamed from: c, reason: collision with root package name */
    private String f6158c;

    /* renamed from: d, reason: collision with root package name */
    private String f6159d;

    /* renamed from: e, reason: collision with root package name */
    private String f6160e;

    /* renamed from: f, reason: collision with root package name */
    private int f6161f;

    /* renamed from: g, reason: collision with root package name */
    private String f6162g;

    /* renamed from: h, reason: collision with root package name */
    private String f6163h;

    class a implements Parcelable.Creator<TmemberRight> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TmemberRight createFromParcel(Parcel parcel) {
            TmemberRight tmemberRight = new TmemberRight();
            tmemberRight.f6156a = parcel.readLong();
            tmemberRight.f6157b = parcel.readInt();
            tmemberRight.f6158c = parcel.readString();
            tmemberRight.f6159d = parcel.readString();
            tmemberRight.f6160e = parcel.readString();
            tmemberRight.f6161f = parcel.readInt();
            tmemberRight.f6162g = parcel.readString();
            tmemberRight.f6163h = parcel.readString();
            return tmemberRight;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TmemberRight[] newArray(int i2) {
            return new TmemberRight[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f6156a);
        parcel.writeInt(this.f6157b);
        parcel.writeString(this.f6158c);
        parcel.writeString(this.f6159d);
        parcel.writeString(this.f6160e);
        parcel.writeInt(this.f6161f);
        parcel.writeString(this.f6162g);
        parcel.writeString(this.f6163h);
    }
}
