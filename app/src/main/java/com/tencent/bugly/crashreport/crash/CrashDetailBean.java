package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.aq;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CrashDetailBean[] newArray(int i2) {
            return new CrashDetailBean[i2];
        }
    };
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public long N;
    public boolean O;
    public Map<String, String> P;
    public int Q;
    public int R;
    public Map<String, String> S;
    public Map<String, String> T;
    public byte[] U;
    public String V;
    public String W;

    /* renamed from: a, reason: collision with root package name */
    public long f9022a;

    /* renamed from: b, reason: collision with root package name */
    public int f9023b;

    /* renamed from: c, reason: collision with root package name */
    public String f9024c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9025d;

    /* renamed from: e, reason: collision with root package name */
    public String f9026e;

    /* renamed from: f, reason: collision with root package name */
    public String f9027f;

    /* renamed from: g, reason: collision with root package name */
    public String f9028g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f9029h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f9030i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9031j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9032k;

    /* renamed from: l, reason: collision with root package name */
    public int f9033l;

    /* renamed from: m, reason: collision with root package name */
    public String f9034m;
    public String n;
    public String o;
    public String p;
    public String q;
    public long r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;
    public byte[] y;
    public Map<String, String> z;

    public CrashDetailBean() {
        this.f9022a = -1L;
        this.f9023b = 0;
        this.f9024c = UUID.randomUUID().toString();
        this.f9025d = false;
        this.f9026e = "";
        this.f9027f = "";
        this.f9028g = "";
        this.f9029h = null;
        this.f9030i = null;
        this.f9031j = false;
        this.f9032k = false;
        this.f9033l = 0;
        this.f9034m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return 1;
        }
        long j2 = this.r - crashDetailBean.r;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f9023b);
        parcel.writeString(this.f9024c);
        parcel.writeByte(this.f9025d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f9026e);
        parcel.writeString(this.f9027f);
        parcel.writeString(this.f9028g);
        parcel.writeByte(this.f9031j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9032k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f9033l);
        parcel.writeString(this.f9034m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeLong(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        aq.b(parcel, this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeLong(this.N);
        parcel.writeByte(this.O ? (byte) 1 : (byte) 0);
        aq.b(parcel, this.P);
        aq.a(parcel, this.f9029h);
        aq.a(parcel, this.f9030i);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        aq.b(parcel, this.S);
        aq.b(parcel, this.T);
        parcel.writeByteArray(this.U);
        parcel.writeByteArray(this.y);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeString(this.x);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f9022a = -1L;
        this.f9023b = 0;
        this.f9024c = UUID.randomUUID().toString();
        this.f9025d = false;
        this.f9026e = "";
        this.f9027f = "";
        this.f9028g = "";
        this.f9029h = null;
        this.f9030i = null;
        this.f9031j = false;
        this.f9032k = false;
        this.f9033l = 0;
        this.f9034m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.f9023b = parcel.readInt();
        this.f9024c = parcel.readString();
        this.f9025d = parcel.readByte() == 1;
        this.f9026e = parcel.readString();
        this.f9027f = parcel.readString();
        this.f9028g = parcel.readString();
        this.f9031j = parcel.readByte() == 1;
        this.f9032k = parcel.readByte() == 1;
        this.f9033l = parcel.readInt();
        this.f9034m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readLong();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.z = aq.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readLong();
        this.O = parcel.readByte() == 1;
        this.P = aq.b(parcel);
        this.f9029h = aq.a(parcel);
        this.f9030i = aq.a(parcel);
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = aq.b(parcel);
        this.T = aq.b(parcel);
        this.U = parcel.createByteArray();
        this.y = parcel.createByteArray();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.x = parcel.readString();
    }
}
