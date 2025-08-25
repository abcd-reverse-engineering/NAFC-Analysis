package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlugInBean[] newArray(int i2) {
            return new PlugInBean[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f8971a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8972b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8973c;

    public PlugInBean(String str, String str2, String str3) {
        this.f8971a = str;
        this.f8972b = str2;
        this.f8973c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f8971a + " plV:" + this.f8972b + " plUUID:" + this.f8973c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8971a);
        parcel.writeString(this.f8972b);
        parcel.writeString(this.f8973c);
    }

    public PlugInBean(Parcel parcel) {
        this.f8971a = parcel.readString();
        this.f8972b = parcel.readString();
        this.f8973c = parcel.readString();
    }
}
