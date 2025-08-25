package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.d.a.d;

/* loaded from: classes.dex */
public class ChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<ChildrenInfo> CREATOR = new a();

    /* renamed from: h, reason: collision with root package name */
    public static final String f6103h = "childrenUserId";

    /* renamed from: i, reason: collision with root package name */
    public static final String f6104i = "birthDate";

    /* renamed from: j, reason: collision with root package name */
    public static final String f6105j = "uniquelyNickname";

    /* renamed from: k, reason: collision with root package name */
    public static final String f6106k = "headPictureUrl";

    /* renamed from: l, reason: collision with root package name */
    public static final String f6107l = "accountname";

    /* renamed from: m, reason: collision with root package name */
    public static final String f6108m = "nickName";
    public static final String n = "loginUserName";
    public static final String o = "children";
    public static final String p = "childrenList";

    /* renamed from: a, reason: collision with root package name */
    private String f6109a;

    /* renamed from: b, reason: collision with root package name */
    private String f6110b;

    /* renamed from: c, reason: collision with root package name */
    private String f6111c;

    /* renamed from: d, reason: collision with root package name */
    private String f6112d;

    /* renamed from: e, reason: collision with root package name */
    private String f6113e;

    /* renamed from: f, reason: collision with root package name */
    private String f6114f;

    /* renamed from: g, reason: collision with root package name */
    private String f6115g;

    class a implements Parcelable.Creator<ChildrenInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChildrenInfo createFromParcel(Parcel parcel) {
            ChildrenInfo childrenInfo = new ChildrenInfo();
            childrenInfo.f6109a = parcel.readString();
            childrenInfo.f6110b = parcel.readString();
            childrenInfo.f6111c = parcel.readString();
            childrenInfo.f6112d = parcel.readString();
            childrenInfo.f6113e = parcel.readString();
            childrenInfo.f6114f = parcel.readString();
            childrenInfo.f6115g = parcel.readString();
            return childrenInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChildrenInfo[] newArray(int i2) {
            return new ChildrenInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "{'childrenUserId':" + d.a(this.f6109a) + ",'birthDate':" + this.f6110b + ",'uniquelyNickname':" + this.f6111c + ",'headPictureUrl':" + d.a(this.f6113e) + ",'accountName':" + this.f6112d + this.f6114f + d.a(this.f6115g) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6109a);
        parcel.writeString(this.f6110b);
        parcel.writeString(this.f6111c);
        parcel.writeString(this.f6112d);
        parcel.writeString(this.f6113e);
        parcel.writeString(this.f6114f);
        parcel.writeString(this.f6115g);
    }
}
