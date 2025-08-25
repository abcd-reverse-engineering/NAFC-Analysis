package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.m;
import com.tencent.bugly.proguard.y;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaGrayStrategy implements Parcelable, Parcelable.Creator<BetaGrayStrategy> {
    public static final Parcelable.Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();

    /* renamed from: a, reason: collision with root package name */
    public y f8848a;

    /* renamed from: b, reason: collision with root package name */
    public int f8849b;

    /* renamed from: c, reason: collision with root package name */
    public long f8850c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8851d;

    /* renamed from: e, reason: collision with root package name */
    public long f8852e;

    public BetaGrayStrategy(Parcel parcel) {
        this.f8849b = 0;
        this.f8850c = -1L;
        this.f8851d = false;
        this.f8852e = -1L;
        this.f8848a = (y) ah.a(parcel.createByteArray(), y.class);
        this.f8849b = parcel.readInt();
        this.f8850c = parcel.readLong();
        this.f8851d = 1 == parcel.readByte();
        this.f8852e = parcel.readLong();
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaGrayStrategy createFromParcel(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(ah.a((m) this.f8848a));
        parcel.writeInt(this.f8849b);
        parcel.writeLong(this.f8850c);
        parcel.writeByte(this.f8851d ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8852e);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaGrayStrategy[] newArray(int i2) {
        return new BetaGrayStrategy[i2];
    }

    public BetaGrayStrategy() {
        this.f8849b = 0;
        this.f8850c = -1L;
        this.f8851d = false;
        this.f8852e = -1L;
    }
}
