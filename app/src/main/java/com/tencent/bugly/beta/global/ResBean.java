package com.tencent.bugly.beta.global;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ResBean implements Parcelable, Parcelable.Creator<ResBean> {

    /* renamed from: a, reason: collision with root package name */
    public static ResBean f8780a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f8781b = {"IMG_title", "VAL_style"};
    public static final Parcelable.Creator<ResBean> CREATOR = new ResBean();

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f8784e = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final String f8782c = "#273238";

    /* renamed from: d, reason: collision with root package name */
    public final String f8783d = "#757575";

    public ResBean() {
    }

    public String a(String str) {
        return this.f8784e.get(str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResBean[] newArray(int i2) {
        return new ResBean[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        for (String str : f8781b) {
            parcel.writeString(this.f8784e.get(str));
        }
    }

    public void a(String str, Object obj) {
        if (obj instanceof String) {
            this.f8784e.put(str, (String) obj);
        }
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResBean createFromParcel(Parcel parcel) {
        return new ResBean(parcel);
    }

    public ResBean(Parcel parcel) {
        try {
            for (String str : f8781b) {
                this.f8784e.put(str, parcel.readString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
