package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class UserLoginInfo implements Parcelable {
    public static final Parcelable.Creator<UserLoginInfo> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    public static final String f6190i = "userID";

    /* renamed from: j, reason: collision with root package name */
    public static final String f6191j = "registerTime";

    /* renamed from: k, reason: collision with root package name */
    public static final String f6192k = "unRegisterTime";

    /* renamed from: l, reason: collision with root package name */
    public static final String f6193l = "lastLoginTime";

    /* renamed from: m, reason: collision with root package name */
    public static final String f6194m = "registerClientType";
    public static final String n = "registerClientIP";
    public static final String o = "registerFrom";
    public static final String p = "lastLoginIP";

    /* renamed from: a, reason: collision with root package name */
    private String f6195a;

    /* renamed from: b, reason: collision with root package name */
    private String f6196b;

    /* renamed from: c, reason: collision with root package name */
    private String f6197c;

    /* renamed from: d, reason: collision with root package name */
    private String f6198d;

    /* renamed from: e, reason: collision with root package name */
    private String f6199e;

    /* renamed from: f, reason: collision with root package name */
    private String f6200f;

    /* renamed from: g, reason: collision with root package name */
    private String f6201g;

    /* renamed from: h, reason: collision with root package name */
    private String f6202h;

    class a implements Parcelable.Creator<UserLoginInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserLoginInfo createFromParcel(Parcel parcel) {
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.f6202h = parcel.readString();
            userLoginInfo.f6198d = parcel.readString();
            userLoginInfo.f6200f = parcel.readString();
            userLoginInfo.f6199e = parcel.readString();
            userLoginInfo.f6201g = parcel.readString();
            userLoginInfo.f6196b = parcel.readString();
            userLoginInfo.f6197c = parcel.readString();
            userLoginInfo.f6195a = parcel.readString();
            return userLoginInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserLoginInfo[] newArray(int i2) {
            return new UserLoginInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6202h);
        parcel.writeString(this.f6198d);
        parcel.writeString(this.f6200f);
        parcel.writeString(this.f6199e);
        parcel.writeString(this.f6201g);
        parcel.writeString(this.f6196b);
        parcel.writeString(this.f6197c);
        parcel.writeString(this.f6195a);
    }

    public static void a(XmlPullParser xmlPullParser, UserLoginInfo userLoginInfo, String str) {
        if (xmlPullParser == null || userLoginInfo == null || str == null) {
            return;
        }
        if (f6190i.equals(str)) {
            userLoginInfo.h(xmlPullParser.nextText());
            return;
        }
        if (f6191j.equals(str)) {
            userLoginInfo.f(xmlPullParser.nextText());
            return;
        }
        if (f6192k.equals(str)) {
            userLoginInfo.g(xmlPullParser.nextText());
            return;
        }
        if (f6193l.equals(str)) {
            userLoginInfo.b(xmlPullParser.nextText());
            return;
        }
        if (f6194m.equals(str)) {
            userLoginInfo.d(xmlPullParser.nextText());
            return;
        }
        if (p.equals(str)) {
            userLoginInfo.a(xmlPullParser.nextText());
        } else if (n.equals(str)) {
            userLoginInfo.c(xmlPullParser.nextText());
        } else if (o.equals(str)) {
            userLoginInfo.e(xmlPullParser.nextText());
        }
    }

    private void b(String str) {
        this.f6198d = str;
    }

    private void c(String str) {
        this.f6200f = str;
    }

    private void d(String str) {
        this.f6199e = str;
    }

    private void e(String str) {
        this.f6201g = str;
    }

    private void f(String str) {
        this.f6196b = str;
    }

    private void g(String str) {
        this.f6197c = str;
    }

    private void h(String str) {
        this.f6195a = str;
    }

    private void a(String str) {
        this.f6202h = str;
    }
}
