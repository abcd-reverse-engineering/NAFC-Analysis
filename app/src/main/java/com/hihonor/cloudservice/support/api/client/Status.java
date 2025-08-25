package com.hihonor.cloudservice.support.api.client;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Status extends com.hihonor.cloudservice.support.api.client.a implements Parcelable {

    /* renamed from: b, reason: collision with root package name */
    private PendingIntent f5999b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f6000c;

    /* renamed from: d, reason: collision with root package name */
    private int f6001d;

    /* renamed from: e, reason: collision with root package name */
    private String f6002e;

    /* renamed from: f, reason: collision with root package name */
    public static final Status f5991f = new Status(0);

    /* renamed from: g, reason: collision with root package name */
    public static final Status f5992g = new Status(1);

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final Status f5993h = new Status(16);

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final Status f5994i = new Status(18);

    /* renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final Status f5995j = new Status(8);

    /* renamed from: k, reason: collision with root package name */
    @Deprecated
    public static final Status f5996k = new Status(14);

    /* renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final Status f5997l = new Status(15);

    /* renamed from: m, reason: collision with root package name */
    public static final Status f5998m = new Status(TinkerReport.KEY_LOADED_SUCC_COST_OTHER);
    public static final Status n = new Status(500);
    public static final Parcelable.Creator<Status> CREATOR = new a();

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel.readInt(), parcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public Status[] newArray(int i2) {
            return new Status[i2];
        }
    }

    public Status(int i2) {
        this(i2, null);
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // com.hihonor.cloudservice.support.api.client.a
    public Status a() {
        return this;
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        sb.append(": ");
        sb.append(d() != null ? d() : "");
        return sb.toString();
    }

    public int c() {
        return this.f6001d;
    }

    public String d() {
        return this.f6002e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f6001d <= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f6001d == status.f6001d && a(this.f6002e, status.f6002e) && a(this.f5999b, status.f5999b);
    }

    public int hashCode() {
        Object[] objArr = new Object[3];
        Object[] objArr2 = new Object[0];
        objArr2[0] = Integer.valueOf(this.f6001d);
        objArr2[1] = this.f6002e;
        objArr[2] = this.f5999b;
        return Arrays.hashCode(objArr);
    }

    public String toString() {
        return "{statusCode: " + this.f6001d + ", statusMessage: " + this.f6002e + ", pendingIntent: " + this.f5999b + ", }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6001d);
        parcel.writeString(this.f6002e);
        PendingIntent pendingIntent = this.f5999b;
        if (pendingIntent != null) {
            pendingIntent.writeToParcel(parcel, i2);
        }
        PendingIntent.writePendingIntentOrNullToParcel(this.f5999b, parcel);
        if (this.f6000c != null) {
            writeToParcel(parcel, i2);
        }
    }

    public Status(int i2, String str) {
        this.f6001d = i2;
        this.f6002e = str;
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this.f6001d = i2;
        this.f6002e = str;
        this.f5999b = pendingIntent;
    }
}
