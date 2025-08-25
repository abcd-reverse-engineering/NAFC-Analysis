package com.tencent.bugly.proguard;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class v extends m implements Cloneable {

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ boolean f9449l = !v.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public String f9450a;

    /* renamed from: b, reason: collision with root package name */
    public byte f9451b;

    /* renamed from: c, reason: collision with root package name */
    public int f9452c;

    /* renamed from: d, reason: collision with root package name */
    public String f9453d;

    /* renamed from: e, reason: collision with root package name */
    public int f9454e;

    /* renamed from: f, reason: collision with root package name */
    public String f9455f;

    /* renamed from: g, reason: collision with root package name */
    public long f9456g;

    /* renamed from: h, reason: collision with root package name */
    public String f9457h;

    /* renamed from: i, reason: collision with root package name */
    public String f9458i;

    /* renamed from: j, reason: collision with root package name */
    public String f9459j;

    /* renamed from: k, reason: collision with root package name */
    public String f9460k;

    public v() {
        this.f9450a = "";
        this.f9451b = (byte) 0;
        this.f9452c = 0;
        this.f9453d = "";
        this.f9454e = 0;
        this.f9455f = "";
        this.f9456g = 0L;
        this.f9457h = "";
        this.f9458i = "";
        this.f9459j = "";
        this.f9460k = "";
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9450a, 0);
        lVar.b(this.f9451b, 1);
        lVar.a(this.f9452c, 2);
        String str = this.f9453d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f9454e, 4);
        String str2 = this.f9455f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        lVar.a(this.f9456g, 6);
        String str3 = this.f9457h;
        if (str3 != null) {
            lVar.a(str3, 7);
        }
        String str4 = this.f9458i;
        if (str4 != null) {
            lVar.a(str4, 8);
        }
        String str5 = this.f9459j;
        if (str5 != null) {
            lVar.a(str5, 9);
        }
        String str6 = this.f9460k;
        if (str6 != null) {
            lVar.a(str6, 10);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9449l) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        v vVar = (v) obj;
        return n.a(this.f9450a, vVar.f9450a) && n.a(this.f9451b, vVar.f9451b) && n.a(this.f9452c, vVar.f9452c) && n.a(this.f9453d, vVar.f9453d) && n.a(this.f9454e, vVar.f9454e) && n.a(this.f9455f, vVar.f9455f) && n.a(this.f9456g, vVar.f9456g) && n.a(this.f9457h, vVar.f9457h) && n.a(this.f9458i, vVar.f9458i) && n.a(this.f9459j, vVar.f9459j) && n.a(this.f9460k, vVar.f9460k);
    }

    public int hashCode() throws Exception {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public v(String str, byte b2, int i2, String str2, int i3, String str3, long j2, String str4, String str5, String str6, String str7) {
        this.f9450a = "";
        this.f9451b = (byte) 0;
        this.f9452c = 0;
        this.f9453d = "";
        this.f9454e = 0;
        this.f9455f = "";
        this.f9456g = 0L;
        this.f9457h = "";
        this.f9458i = "";
        this.f9459j = "";
        this.f9460k = "";
        this.f9450a = str;
        this.f9451b = b2;
        this.f9452c = i2;
        this.f9453d = str2;
        this.f9454e = i3;
        this.f9455f = str3;
        this.f9456g = j2;
        this.f9457h = str4;
        this.f9458i = str5;
        this.f9459j = str6;
        this.f9460k = str7;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9450a = kVar.a(0, true);
        this.f9451b = kVar.a(this.f9451b, 1, true);
        this.f9452c = kVar.a(this.f9452c, 2, true);
        this.f9453d = kVar.a(3, false);
        this.f9454e = kVar.a(this.f9454e, 4, false);
        this.f9455f = kVar.a(5, false);
        this.f9456g = kVar.a(this.f9456g, 6, false);
        this.f9457h = kVar.a(7, false);
        this.f9458i = kVar.a(8, false);
        this.f9459j = kVar.a(9, false);
        this.f9460k = kVar.a(10, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.f9450a, "appId");
        iVar.a(this.f9451b, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
        iVar.a(this.f9452c, "versionCode");
        iVar.a(this.f9453d, "versionName");
        iVar.a(this.f9454e, "buildNo");
        iVar.a(this.f9455f, "iconUrl");
        iVar.a(this.f9456g, "apkId");
        iVar.a(this.f9457h, RemoteMessageConst.Notification.CHANNEL_ID);
        iVar.a(this.f9458i, "md5");
        iVar.a(this.f9459j, "sdkVer");
        iVar.a(this.f9460k, "bundleId");
    }
}
