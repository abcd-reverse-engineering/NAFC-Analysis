package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.f.b;
import com.hihonor.honorid.f.c;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class UserAccountInfo implements Parcelable {
    public static final Parcelable.Creator<UserAccountInfo> CREATOR = new a();

    /* renamed from: j, reason: collision with root package name */
    public static final String f6164j = "userAccount";

    /* renamed from: k, reason: collision with root package name */
    public static final String f6165k = "accountType";

    /* renamed from: l, reason: collision with root package name */
    public static final String f6166l = "accountState";

    /* renamed from: m, reason: collision with root package name */
    public static final String f6167m = "accountValidStatus";
    public static final String n = "updateTime";
    public static final String o = "userAcctInfo";
    public static final String p = "userAcctInfoList";
    public static final String q = "memberRight";
    public static final String r = "memberRightList";
    public static final String s = "userEMail";
    public static final String t = "mobilePhone";
    public static final String u = "emailState";
    public static final String v = "mobilePhoneState";
    public static final String w = "age";

    /* renamed from: a, reason: collision with root package name */
    private String f6168a;

    /* renamed from: b, reason: collision with root package name */
    private String f6169b;

    /* renamed from: c, reason: collision with root package name */
    private String f6170c;

    /* renamed from: d, reason: collision with root package name */
    private String f6171d;

    /* renamed from: e, reason: collision with root package name */
    private String f6172e;

    /* renamed from: f, reason: collision with root package name */
    private String f6173f;

    /* renamed from: g, reason: collision with root package name */
    private String f6174g;

    /* renamed from: h, reason: collision with root package name */
    private String f6175h;

    /* renamed from: i, reason: collision with root package name */
    private String f6176i;

    class a implements Parcelable.Creator<UserAccountInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAccountInfo createFromParcel(Parcel parcel) {
            UserAccountInfo userAccountInfo = new UserAccountInfo();
            userAccountInfo.f6168a = parcel.readString();
            userAccountInfo.f6169b = parcel.readString();
            userAccountInfo.f6170c = parcel.readString();
            userAccountInfo.f6171d = parcel.readString();
            userAccountInfo.f6172e = parcel.readString();
            userAccountInfo.f6173f = parcel.readString();
            userAccountInfo.f6174g = parcel.readString();
            userAccountInfo.f6175h = parcel.readString();
            userAccountInfo.f6176i = parcel.readString();
            return userAccountInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAccountInfo[] newArray(int i2) {
            return new UserAccountInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6168a);
        parcel.writeString(this.f6169b);
        parcel.writeString(this.f6170c);
        parcel.writeString(this.f6171d);
        parcel.writeString(this.f6172e);
        parcel.writeString(this.f6173f);
        parcel.writeString(this.f6174g);
        parcel.writeString(this.f6175h);
        parcel.writeString(this.f6176i);
    }

    private void d(String str) {
        this.f6171d = str;
    }

    private void e(String str) {
        this.f6174g = str;
    }

    private void f(String str) {
        this.f6176i = str;
    }

    private void g(String str) {
        this.f6172e = str;
    }

    private void h(String str) {
        this.f6173f = str;
    }

    private void i(String str) {
        this.f6175h = str;
    }

    public String a() {
        return this.f6170c;
    }

    public String b() {
        return this.f6168a;
    }

    public String c() {
        return this.f6169b;
    }

    public static void a(XmlPullParser xmlPullParser, UserAccountInfo userAccountInfo, String str) {
        if (xmlPullParser == null || userAccountInfo == null || str == null) {
            return;
        }
        if (f6166l.equals(str)) {
            userAccountInfo.a(xmlPullParser.nextText());
            return;
        }
        if ("accountType".equals(str)) {
            userAccountInfo.b(xmlPullParser.nextText());
            return;
        }
        if (f6167m.equals(str)) {
            userAccountInfo.d(xmlPullParser.nextText());
            return;
        }
        if ("updateTime".equals(str)) {
            userAccountInfo.g(xmlPullParser.nextText());
            return;
        }
        if ("userAccount".equals(str)) {
            userAccountInfo.c(xmlPullParser.nextText());
            return;
        }
        if (s.equals(str)) {
            userAccountInfo.h(xmlPullParser.nextText());
            return;
        }
        if (t.equals(str)) {
            userAccountInfo.e(xmlPullParser.nextText());
        } else if (u.equals(str)) {
            userAccountInfo.i(xmlPullParser.nextText());
        } else if (v.equals(str)) {
            userAccountInfo.f(xmlPullParser.nextText());
        }
    }

    public void b(String str) {
        this.f6168a = str;
    }

    public void c(String str) {
        this.f6169b = str;
    }

    public boolean a(Object obj) {
        if (obj != null && (obj instanceof UserAccountInfo)) {
            return this == obj || b.a(this.f6174g, ((UserAccountInfo) obj).f6174g);
        }
        return false;
    }

    public void a(String str) {
        this.f6170c = str;
    }

    public static void a(XmlSerializer xmlSerializer, UserAccountInfo userAccountInfo) throws IllegalStateException, IOException, IllegalArgumentException {
        if (xmlSerializer == null || userAccountInfo == null) {
            return;
        }
        c.a(xmlSerializer, "accountType", userAccountInfo.b());
        c.a(xmlSerializer, "userAccount", userAccountInfo.c());
    }
}
