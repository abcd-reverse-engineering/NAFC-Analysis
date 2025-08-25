package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class g extends m {

    /* renamed from: g, reason: collision with root package name */
    public byte[] f9399g;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f9401i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f9402j;

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f9392m = !g.class.desiredAssertionStatus();

    /* renamed from: k, reason: collision with root package name */
    static byte[] f9390k = null;

    /* renamed from: l, reason: collision with root package name */
    static Map<String, String> f9391l = null;

    /* renamed from: a, reason: collision with root package name */
    public short f9393a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f9394b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f9395c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f9396d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f9397e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f9398f = null;

    /* renamed from: h, reason: collision with root package name */
    public int f9400h = 0;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9393a, 1);
        lVar.b(this.f9394b, 2);
        lVar.a(this.f9395c, 3);
        lVar.a(this.f9396d, 4);
        lVar.a(this.f9397e, 5);
        lVar.a(this.f9398f, 6);
        lVar.a(this.f9399g, 7);
        lVar.a(this.f9400h, 8);
        lVar.a((Map) this.f9401i, 9);
        lVar.a((Map) this.f9402j, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9392m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        g gVar = (g) obj;
        return n.a(1, (int) gVar.f9393a) && n.a(1, (int) gVar.f9394b) && n.a(1, gVar.f9395c) && n.a(1, gVar.f9396d) && n.a((Object) 1, (Object) gVar.f9397e) && n.a((Object) 1, (Object) gVar.f9398f) && n.a((Object) 1, (Object) gVar.f9399g) && n.a(1, gVar.f9400h) && n.a((Object) 1, (Object) gVar.f9401i) && n.a((Object) 1, (Object) gVar.f9402j);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        try {
            this.f9393a = kVar.a(this.f9393a, 1, true);
            this.f9394b = kVar.a(this.f9394b, 2, true);
            this.f9395c = kVar.a(this.f9395c, 3, true);
            this.f9396d = kVar.a(this.f9396d, 4, true);
            this.f9397e = kVar.a(5, true);
            this.f9398f = kVar.a(6, true);
            if (f9390k == null) {
                f9390k = new byte[]{0};
            }
            this.f9399g = kVar.a(f9390k, 7, true);
            this.f9400h = kVar.a(this.f9400h, 8, true);
            if (f9391l == null) {
                f9391l = new HashMap();
                f9391l.put("", "");
            }
            this.f9401i = (Map) kVar.a((k) f9391l, 9, true);
            if (f9391l == null) {
                f9391l = new HashMap();
                f9391l.put("", "");
            }
            this.f9402j = (Map) kVar.a((k) f9391l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + f.a(this.f9399g));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.f9393a, "iVersion");
        iVar.a(this.f9394b, "cPacketType");
        iVar.a(this.f9395c, "iMessageType");
        iVar.a(this.f9396d, "iRequestId");
        iVar.a(this.f9397e, "sServantName");
        iVar.a(this.f9398f, "sFuncName");
        iVar.a(this.f9399g, "sBuffer");
        iVar.a(this.f9400h, "iTimeout");
        iVar.a((Map) this.f9401i, com.umeng.analytics.pro.d.R);
        iVar.a((Map) this.f9402j, NotificationCompat.CATEGORY_STATUS);
    }
}
