package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.aq;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoBean[] newArray(int i2) {
            return new UserInfoBean[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public long f8927a;

    /* renamed from: b, reason: collision with root package name */
    public int f8928b;

    /* renamed from: c, reason: collision with root package name */
    public String f8929c;

    /* renamed from: d, reason: collision with root package name */
    public String f8930d;

    /* renamed from: e, reason: collision with root package name */
    public long f8931e;

    /* renamed from: f, reason: collision with root package name */
    public long f8932f;

    /* renamed from: g, reason: collision with root package name */
    public long f8933g;

    /* renamed from: h, reason: collision with root package name */
    public long f8934h;

    /* renamed from: i, reason: collision with root package name */
    public long f8935i;

    /* renamed from: j, reason: collision with root package name */
    public String f8936j;

    /* renamed from: k, reason: collision with root package name */
    public long f8937k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8938l;

    /* renamed from: m, reason: collision with root package name */
    public String f8939m;
    public String n;
    public int o;
    public int p;
    public int q;
    public Map<String, String> r;
    public Map<String, String> s;

    public UserInfoBean() {
        this.f8937k = 0L;
        this.f8938l = false;
        this.f8939m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8928b);
        parcel.writeString(this.f8929c);
        parcel.writeString(this.f8930d);
        parcel.writeLong(this.f8931e);
        parcel.writeLong(this.f8932f);
        parcel.writeLong(this.f8933g);
        parcel.writeLong(this.f8934h);
        parcel.writeLong(this.f8935i);
        parcel.writeString(this.f8936j);
        parcel.writeLong(this.f8937k);
        parcel.writeByte(this.f8938l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8939m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        aq.b(parcel, this.r);
        aq.b(parcel, this.s);
        parcel.writeString(this.n);
        parcel.writeInt(this.o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f8937k = 0L;
        this.f8938l = false;
        this.f8939m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.f8928b = parcel.readInt();
        this.f8929c = parcel.readString();
        this.f8930d = parcel.readString();
        this.f8931e = parcel.readLong();
        this.f8932f = parcel.readLong();
        this.f8933g = parcel.readLong();
        this.f8934h = parcel.readLong();
        this.f8935i = parcel.readLong();
        this.f8936j = parcel.readString();
        this.f8937k = parcel.readLong();
        this.f8938l = parcel.readByte() == 1;
        this.f8939m = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = aq.b(parcel);
        this.s = aq.b(parcel);
        this.n = parcel.readString();
        this.o = parcel.readInt();
    }
}
