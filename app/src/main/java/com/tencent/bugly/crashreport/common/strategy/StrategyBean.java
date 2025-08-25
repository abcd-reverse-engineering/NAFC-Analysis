package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.aq;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyBean[] newArray(int i2) {
            return new StrategyBean[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public static String f8992a = "http://rqd.uu.qq.com/rqd/sync";

    /* renamed from: b, reason: collision with root package name */
    public static String f8993b = "http://android.bugly.qq.com/rqd/async";

    /* renamed from: c, reason: collision with root package name */
    public static String f8994c = "http://android.bugly.qq.com/rqd/async";

    /* renamed from: d, reason: collision with root package name */
    public static String f8995d;

    /* renamed from: e, reason: collision with root package name */
    public long f8996e;

    /* renamed from: f, reason: collision with root package name */
    public long f8997f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8998g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8999h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9000i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9001j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9002k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9003l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9004m;
    public boolean n;
    public boolean o;
    public long p;
    public long q;
    public String r;
    public String s;
    public String t;
    public String u;
    public Map<String, String> v;
    public int w;
    public long x;
    public long y;

    public StrategyBean() {
        this.f8996e = -1L;
        this.f8997f = -1L;
        this.f8998g = true;
        this.f8999h = true;
        this.f9000i = true;
        this.f9001j = true;
        this.f9002k = false;
        this.f9003l = true;
        this.f9004m = true;
        this.n = true;
        this.o = true;
        this.q = 30000L;
        this.r = f8993b;
        this.s = f8994c;
        this.t = f8992a;
        this.w = 10;
        this.x = 300000L;
        this.y = -1L;
        this.f8997f = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(");
        sb.append("@L@L");
        sb.append("@)");
        f8995d = sb.toString();
        sb.setLength(0);
        sb.append("*^");
        sb.append("@K#K");
        sb.append("@!");
        this.u = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8997f);
        parcel.writeByte(this.f8998g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8999h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9000i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.u);
        aq.b(parcel, this.v);
        parcel.writeByte(this.f9001j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9002k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.q);
        parcel.writeByte(this.f9003l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9004m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p);
        parcel.writeInt(this.w);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
    }

    public StrategyBean(Parcel parcel) {
        this.f8996e = -1L;
        this.f8997f = -1L;
        boolean z = true;
        this.f8998g = true;
        this.f8999h = true;
        this.f9000i = true;
        this.f9001j = true;
        this.f9002k = false;
        this.f9003l = true;
        this.f9004m = true;
        this.n = true;
        this.o = true;
        this.q = 30000L;
        this.r = f8993b;
        this.s = f8994c;
        this.t = f8992a;
        this.w = 10;
        this.x = 300000L;
        this.y = -1L;
        try {
            f8995d = "S(@L@L@)";
            this.f8997f = parcel.readLong();
            this.f8998g = parcel.readByte() == 1;
            this.f8999h = parcel.readByte() == 1;
            this.f9000i = parcel.readByte() == 1;
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.u = parcel.readString();
            this.v = aq.b(parcel);
            this.f9001j = parcel.readByte() == 1;
            this.f9002k = parcel.readByte() == 1;
            this.n = parcel.readByte() == 1;
            this.o = parcel.readByte() == 1;
            this.q = parcel.readLong();
            this.f9003l = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f9004m = z;
            this.p = parcel.readLong();
            this.w = parcel.readInt();
            this.x = parcel.readLong();
            this.y = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
