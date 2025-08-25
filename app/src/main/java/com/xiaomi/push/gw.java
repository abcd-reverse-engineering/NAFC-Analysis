package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gw implements hq<gw, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gu f676a;

    /* renamed from: a, reason: collision with other field name */
    public String f677a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f679a;

    /* renamed from: b, reason: collision with other field name */
    public String f680b;

    /* renamed from: c, reason: collision with other field name */
    public String f681c;

    /* renamed from: d, reason: collision with other field name */
    public String f682d;

    /* renamed from: e, reason: collision with other field name */
    public String f683e;

    /* renamed from: f, reason: collision with other field name */
    public String f684f;

    /* renamed from: g, reason: collision with other field name */
    public String f685g;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f674a = new Cif("XmPushActionAckNotification");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13054a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13055b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13056c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13057d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13058e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13059f = new hx("", (byte) 10, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13060g = new hx("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13061h = new hx("", com.umeng.analytics.pro.cw.f10301k, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13062i = new hx("", (byte) 11, 10);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13063j = new hx("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f678a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public long f675a = 0;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m512a() {
        return this.f677a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m514b() {
        return this.f676a != null;
    }

    public boolean c() {
        return this.f680b != null;
    }

    public boolean d() {
        return this.f681c != null;
    }

    public boolean e() {
        return this.f682d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gw)) {
            return m513a((gw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f678a.get(0);
    }

    public boolean g() {
        return this.f683e != null;
    }

    public boolean h() {
        return this.f679a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f684f != null;
    }

    public boolean j() {
        return this.f685g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        if (m512a()) {
            sb.append("debug:");
            String str = this.f677a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m514b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f676a;
            if (guVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(guVar);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f680b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f681c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f682d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f675a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f683e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f679a;
            if (map == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f684f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f685g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gw a(gu guVar) {
        this.f676a = guVar;
        return this;
    }

    public gw b(String str) {
        this.f681c = str;
        return this;
    }

    public gw c(String str) {
        this.f682d = str;
        return this;
    }

    public gw d(String str) {
        this.f683e = str;
        return this;
    }

    public gw e(String str) {
        this.f684f = str;
        return this;
    }

    public String a() {
        return this.f680b;
    }

    public String b() {
        return this.f682d;
    }

    public gw a(String str) {
        this.f680b = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m511a();
        iaVar.a(f674a);
        if (this.f677a != null && m512a()) {
            iaVar.a(f13054a);
            iaVar.a(this.f677a);
            iaVar.b();
        }
        if (this.f676a != null && m514b()) {
            iaVar.a(f13055b);
            this.f676a.b(iaVar);
            iaVar.b();
        }
        if (this.f680b != null) {
            iaVar.a(f13056c);
            iaVar.a(this.f680b);
            iaVar.b();
        }
        if (this.f681c != null && d()) {
            iaVar.a(f13057d);
            iaVar.a(this.f681c);
            iaVar.b();
        }
        if (this.f682d != null && e()) {
            iaVar.a(f13058e);
            iaVar.a(this.f682d);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f13059f);
            iaVar.a(this.f675a);
            iaVar.b();
        }
        if (this.f683e != null && g()) {
            iaVar.a(f13060g);
            iaVar.a(this.f683e);
            iaVar.b();
        }
        if (this.f679a != null && h()) {
            iaVar.a(f13061h);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f679a.size()));
            for (Map.Entry<String, String> entry : this.f679a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f684f != null && i()) {
            iaVar.a(f13062i);
            iaVar.a(this.f684f);
            iaVar.b();
        }
        if (this.f685g != null && j()) {
            iaVar.a(f13063j);
            iaVar.a(this.f685g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public gw a(long j2) {
        this.f675a = j2;
        a(true);
        return this;
    }

    public void a(boolean z) {
        this.f678a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m510a() {
        return this.f679a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m513a(gw gwVar) {
        if (gwVar == null) {
            return false;
        }
        boolean zM512a = m512a();
        boolean zM512a2 = gwVar.m512a();
        if ((zM512a || zM512a2) && !(zM512a && zM512a2 && this.f677a.equals(gwVar.f677a))) {
            return false;
        }
        boolean zM514b = m514b();
        boolean zM514b2 = gwVar.m514b();
        if ((zM514b || zM514b2) && !(zM514b && zM514b2 && this.f676a.m507a(gwVar.f676a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gwVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f680b.equals(gwVar.f680b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gwVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f681c.equals(gwVar.f681c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gwVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f682d.equals(gwVar.f682d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gwVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f675a == gwVar.f675a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gwVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f683e.equals(gwVar.f683e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gwVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f679a.equals(gwVar.f679a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gwVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f684f.equals(gwVar.f684f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gwVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f685g.equals(gwVar.f685g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gw gwVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        if (!gw.class.equals(gwVar.getClass())) {
            return gw.class.getName().compareTo(gwVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m512a()).compareTo(Boolean.valueOf(gwVar.m512a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m512a() && (iA10 = hr.a(this.f677a, gwVar.f677a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m514b()).compareTo(Boolean.valueOf(gwVar.m514b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m514b() && (iA9 = hr.a(this.f676a, gwVar.f676a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gwVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hr.a(this.f680b, gwVar.f680b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gwVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f681c, gwVar.f681c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gwVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f682d, gwVar.f682d)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gwVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f675a, gwVar.f675a)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gwVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f683e, gwVar.f683e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gwVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f679a, gwVar.f679a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gwVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f684f, gwVar.f684f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gwVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f685g, gwVar.f685g)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) throws ib {
        iaVar.mo607a();
        while (true) {
            hx hxVarMo603a = iaVar.mo603a();
            byte b2 = hxVarMo603a.f13224a;
            if (b2 == 0) {
                iaVar.f();
                m511a();
                return;
            }
            switch (hxVarMo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f677a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f676a = new gu();
                        this.f676a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f680b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f681c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f682d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                default:
                    id.a(iaVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f675a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f683e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 13) {
                        hz hzVarMo605a = iaVar.mo605a();
                        this.f679a = new HashMap(hzVarMo605a.f900a * 2);
                        for (int i2 = 0; i2 < hzVarMo605a.f900a; i2++) {
                            this.f679a.put(iaVar.mo608a(), iaVar.mo608a());
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f684f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f685g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m511a() throws ib {
        if (this.f680b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
