package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.bk;
import com.tencent.bugly.proguard.m;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaUploadStrategy implements Parcelable, Parcelable.Creator<BetaUploadStrategy> {
    public static final Parcelable.Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();

    /* renamed from: a, reason: collision with root package name */
    public bk f8853a;

    /* renamed from: b, reason: collision with root package name */
    public long f8854b;

    public BetaUploadStrategy() {
        this.f8853a = new bk();
        bk bkVar = this.f8853a;
        bkVar.f9349b = true;
        bkVar.f9350c = true;
        if (e.G.S) {
            String str = StrategyBean.f8993b;
            bkVar.f9351d = str;
            bkVar.f9352e = str;
        } else {
            bkVar.f9351d = "http://android.bugly.qq.com/rqd/async";
            bkVar.f9352e = "http://android.bugly.qq.com/rqd/async";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f8853a.f9355h = jCurrentTimeMillis;
        this.f8854b = jCurrentTimeMillis;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaUploadStrategy createFromParcel(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(ah.a((m) this.f8853a));
        parcel.writeLong(this.f8854b);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaUploadStrategy[] newArray(int i2) {
        return new BetaUploadStrategy[i2];
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.f8853a = (bk) ah.a(parcel.createByteArray(), bk.class);
        this.f8854b = parcel.readLong();
    }
}
