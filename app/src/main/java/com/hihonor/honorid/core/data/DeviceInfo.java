package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hihonor.honorid.d.a.d;
import com.hihonor.honorid.f.b;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new a();

    /* renamed from: h, reason: collision with root package name */
    public static final String f6116h = "deviceType";

    /* renamed from: i, reason: collision with root package name */
    public static final String f6117i = "deviceID";

    /* renamed from: j, reason: collision with root package name */
    public static final String f6118j = "uuid";

    /* renamed from: k, reason: collision with root package name */
    public static final String f6119k = "terminalType";

    /* renamed from: l, reason: collision with root package name */
    public static final String f6120l = "deviceAliasName";

    /* renamed from: m, reason: collision with root package name */
    public static final String f6121m = "loginTime";
    public static final String n = "logoutTime";
    public static final String o = "frequentlyUsed";
    public static final String p = "deviceInfo";
    public static final String q = "deviceIDList";

    /* renamed from: a, reason: collision with root package name */
    private String f6122a;

    /* renamed from: b, reason: collision with root package name */
    private String f6123b;

    /* renamed from: c, reason: collision with root package name */
    private String f6124c;

    /* renamed from: d, reason: collision with root package name */
    private String f6125d;

    /* renamed from: e, reason: collision with root package name */
    private String f6126e;

    /* renamed from: f, reason: collision with root package name */
    private String f6127f;

    /* renamed from: g, reason: collision with root package name */
    private String f6128g = "";

    class a implements Parcelable.Creator<DeviceInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.f6123b = parcel.readString();
            deviceInfo.f6125d = parcel.readString();
            deviceInfo.f6122a = parcel.readString();
            deviceInfo.f6124c = parcel.readString();
            deviceInfo.f6126e = parcel.readString();
            deviceInfo.f6127f = parcel.readString();
            deviceInfo.f6128g = parcel.readString();
            return deviceInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int i2) {
            return new DeviceInfo[i2];
        }
    }

    public DeviceInfo(String str, String str2, String str3) {
        this.f6122a = str;
        this.f6123b = str2;
        this.f6124c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean h() {
        return TextUtils.isEmpty(this.f6127f) && !TextUtils.isEmpty(this.f6126e);
    }

    public String toString() {
        return "{'mDeviceAliasName':" + d.a(this.f6125d) + ",'mDeviceId':" + d.a(this.f6123b) + ",'mTerminalType':" + this.f6124c + ",'mDeviceType':" + this.f6122a + ",'mLoginTime':" + this.f6126e + ",'mLogoutTime':" + this.f6127f + ",'mFrequentlyUsed':" + this.f6128g + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6123b);
        parcel.writeString(this.f6125d);
        parcel.writeString(this.f6122a);
        parcel.writeString(this.f6124c);
        parcel.writeString(this.f6126e);
        parcel.writeString(this.f6127f);
        parcel.writeString(this.f6128g);
    }

    public String a() {
        return this.f6125d;
    }

    public String b() {
        return this.f6123b;
    }

    public String c() {
        return this.f6122a;
    }

    public String d() {
        return this.f6124c;
    }

    public String e() {
        return this.f6128g;
    }

    public String f() {
        return this.f6126e;
    }

    public String g() {
        return this.f6127f;
    }

    public static void a(XmlPullParser xmlPullParser, DeviceInfo deviceInfo, String str) {
        if (xmlPullParser == null || deviceInfo == null || str == null) {
            return;
        }
        if (f6117i.equals(str)) {
            deviceInfo.b(xmlPullParser.nextText());
            return;
        }
        if ("deviceType".equals(str)) {
            deviceInfo.c(xmlPullParser.nextText());
            return;
        }
        if ("terminalType".equals(str)) {
            deviceInfo.d(xmlPullParser.nextText());
            return;
        }
        if (f6120l.equals(str)) {
            deviceInfo.a(xmlPullParser.nextText());
            return;
        }
        if (f6121m.equals(str)) {
            deviceInfo.f(xmlPullParser.nextText());
        } else if (n.equals(str)) {
            deviceInfo.g(xmlPullParser.nextText());
        } else if (o.equals(str)) {
            deviceInfo.e(xmlPullParser.nextText());
        }
    }

    public void b(String str) {
        this.f6123b = str;
    }

    public void c(String str) {
        this.f6122a = str;
    }

    public void d(String str) {
        this.f6124c = str;
    }

    public void e(String str) {
        this.f6128g = str;
    }

    public void f(String str) {
        this.f6126e = str;
    }

    public void g(String str) {
        this.f6127f = str;
    }

    public DeviceInfo() {
    }

    public boolean a(Object obj) {
        if (obj != null && (obj instanceof DeviceInfo)) {
            if (obj == this) {
                return true;
            }
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            if (b.a(this.f6125d, deviceInfo.f6125d) && b.a(this.f6123b, deviceInfo.f6123b) && b.a(this.f6124c, deviceInfo.f6124c) && b.a(this.f6122a, deviceInfo.f6122a)) {
                return true;
            }
        }
        return false;
    }

    public void a(String str) {
        this.f6125d = str;
    }
}
