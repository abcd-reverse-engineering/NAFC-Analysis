package com.hihonor.honorid.core.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class HonorAccount implements Parcelable {
    public static final Parcelable.Creator<HonorAccount> CREATOR = new a();
    private String A;

    /* renamed from: b, reason: collision with root package name */
    private String f6130b;

    /* renamed from: c, reason: collision with root package name */
    private String f6131c;

    /* renamed from: d, reason: collision with root package name */
    private String f6132d;

    /* renamed from: e, reason: collision with root package name */
    private String f6133e;

    /* renamed from: g, reason: collision with root package name */
    private String f6135g;

    /* renamed from: h, reason: collision with root package name */
    private String f6136h;

    /* renamed from: i, reason: collision with root package name */
    private String f6137i;

    /* renamed from: j, reason: collision with root package name */
    private String f6138j;

    /* renamed from: k, reason: collision with root package name */
    private String f6139k;

    /* renamed from: m, reason: collision with root package name */
    private String f6141m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private boolean y;
    private String z;

    /* renamed from: a, reason: collision with root package name */
    private String f6129a = "-1";

    /* renamed from: f, reason: collision with root package name */
    private int f6134f = 0;

    /* renamed from: l, reason: collision with root package name */
    private String f6140l = "";
    private int x = 0;

    class a implements Parcelable.Creator<HonorAccount> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HonorAccount createFromParcel(Parcel parcel) {
            HonorAccount honorAccount = new HonorAccount();
            honorAccount.f6129a = parcel.readString();
            honorAccount.f6130b = parcel.readString();
            honorAccount.f6131c = parcel.readString();
            honorAccount.f6132d = parcel.readString();
            honorAccount.f6133e = parcel.readString();
            honorAccount.f6134f = parcel.readInt();
            honorAccount.f6135g = parcel.readString();
            honorAccount.f6136h = parcel.readString();
            honorAccount.f6137i = parcel.readString();
            honorAccount.f6138j = parcel.readString();
            honorAccount.f6139k = parcel.readString();
            honorAccount.f6140l = parcel.readString();
            honorAccount.f6141m = parcel.readString();
            honorAccount.n = parcel.readString();
            honorAccount.o = parcel.readString();
            honorAccount.p = parcel.readString();
            honorAccount.q = parcel.readString();
            honorAccount.r = parcel.readString();
            honorAccount.s = parcel.readString();
            honorAccount.t = parcel.readString();
            honorAccount.u = parcel.readString();
            honorAccount.v = parcel.readString();
            honorAccount.y = parcel.readByte() == 1;
            honorAccount.z = parcel.readString();
            honorAccount.A = parcel.readString();
            return honorAccount;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HonorAccount[] newArray(int i2) {
            return new HonorAccount[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "HonorAccount";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6129a);
        parcel.writeString(this.f6130b);
        parcel.writeString(this.f6131c);
        parcel.writeString(this.f6132d);
        parcel.writeString(this.f6133e);
        parcel.writeInt(this.f6134f);
        parcel.writeString(this.f6135g);
        parcel.writeString(this.f6136h);
        parcel.writeString(this.f6137i);
        parcel.writeString(this.f6138j);
        parcel.writeString(this.f6139k);
        parcel.writeString(this.f6140l);
        parcel.writeString(this.f6141m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeByte(this.y ? (byte) 1 : (byte) 0);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
    }

    public void x(String str) {
        this.f6133e = str;
    }

    public void b(int i2) {
        this.f6134f = i2;
    }

    public String c() {
        return this.f6132d;
    }

    public String d() {
        return this.f6139k;
    }

    public String e() {
        return this.r;
    }

    public void f(String str) {
        this.f6135g = str;
    }

    public void g(String str) {
        this.f6136h = str;
    }

    public void h(String str) {
        this.f6138j = str;
    }

    public String i() {
        return this.A;
    }

    public String j() {
        return this.f6141m;
    }

    public String k() {
        String str = this.s;
        return str == null ? "0" : str;
    }

    public String l() {
        return this.f6140l;
    }

    public String m() {
        return this.v;
    }

    public void n(String str) {
        this.n = str;
    }

    public void o(String str) {
        this.f6129a = str;
    }

    public String p() {
        return this.w;
    }

    public int q() {
        return this.f6134f;
    }

    public String r() {
        return this.f6137i;
    }

    public String s() {
        return this.f6131c;
    }

    public String t() {
        return this.f6130b;
    }

    public void u(String str) {
        this.f6130b = str;
    }

    public String v() {
        return this.z;
    }

    public void w(String str) {
        this.z = str;
    }

    public void b(String str) {
        this.t = str;
    }

    public void c(String str) {
        this.f6132d = str;
    }

    public void d(String str) {
        this.f6139k = str;
    }

    public void e(String str) {
        this.r = str;
    }

    public String f() {
        return this.f6136h;
    }

    public String g() {
        return this.f6138j;
    }

    public int h() {
        return this.x;
    }

    public void i(String str) {
        this.A = str;
    }

    public void j(String str) {
        this.f6141m = str;
    }

    public void k(String str) {
        this.s = str;
    }

    public void l(String str) {
        this.f6140l = str;
    }

    public void m(String str) {
        this.v = str;
    }

    public String n() {
        return this.u;
    }

    public String o() {
        return TextUtils.isEmpty(this.o) ? "" : this.o;
    }

    public void p(String str) {
        this.u = str;
    }

    public void q(String str) {
        this.o = str;
    }

    public void r(String str) {
        this.w = str;
    }

    public void s(String str) {
        this.f6137i = str;
    }

    public void t(String str) {
        this.f6131c = str;
    }

    public String u() {
        return this.p;
    }

    public void v(String str) {
        this.p = str;
    }

    public String w() {
        return this.f6133e;
    }

    public String a() {
        return this.q;
    }

    public String b() {
        return this.t;
    }

    public void a(String str) {
        this.q = str;
    }

    public void a(int i2) {
        this.x = i2;
    }

    public void a(boolean z) {
        this.y = z;
    }

    public HonorAccount a(Bundle bundle) {
        o(bundle.getString("sL"));
        u(bundle.getString("requestTokenType"));
        t(bundle.getString(c.c.a.b.a.a.N));
        c(bundle.getString(c.c.a.b.a.a.H));
        x(bundle.getString("userId"));
        b(bundle.getInt(c.c.a.b.a.a.q));
        f(bundle.getString("Cookie"));
        g(bundle.getString("deviceId"));
        s(bundle.getString(c.c.a.b.a.a.t));
        h(bundle.getString("deviceType"));
        d(bundle.getString("accountType"));
        l(bundle.getString("loginUserName"));
        j(bundle.getString(c.c.a.b.a.a.D));
        n(bundle.getString(c.c.a.b.a.a.E));
        q(bundle.getString(c.c.a.b.a.a.F));
        v(bundle.getString("uuid"));
        a(bundle.getString(c.c.a.b.a.a.f3104k));
        e(bundle.getString(c.c.a.b.a.a.f3105l));
        r(bundle.getString(c.c.a.b.a.a.f3106m));
        a(bundle.getInt(c.c.a.b.a.a.o, 0));
        k(bundle.getString(c.c.a.b.a.a.p));
        b(bundle.getString("access_token"));
        p(bundle.getString("code"));
        m(bundle.getString("open_id"));
        a(bundle.getBoolean(c.c.a.b.a.a.N1));
        w(bundle.getString(c.c.a.b.a.a.O1));
        i(bundle.getString(c.c.a.b.a.a.P1));
        return this;
    }
}
