package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hl implements hq<hl, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f844a;

    /* renamed from: a, reason: collision with other field name */
    public gu f845a;

    /* renamed from: a, reason: collision with other field name */
    public String f846a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f847a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f848a = true;

    /* renamed from: b, reason: collision with other field name */
    public String f849b;

    /* renamed from: c, reason: collision with other field name */
    public String f850c;

    /* renamed from: d, reason: collision with other field name */
    public String f851d;

    /* renamed from: e, reason: collision with other field name */
    public String f852e;

    /* renamed from: f, reason: collision with other field name */
    public String f853f;

    /* renamed from: g, reason: collision with other field name */
    public String f854g;

    /* renamed from: h, reason: collision with other field name */
    public String f855h;

    /* renamed from: i, reason: collision with other field name */
    public String f856i;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f843a = new Cif("XmPushActionUnRegistration");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13173a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13174b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13175c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13176d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13177e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13178f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13179g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13180h = new hx("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13181i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13182j = new hx("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13183k = new hx("", (byte) 2, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13184l = new hx("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m584a() {
        return this.f846a != null;
    }

    public boolean b() {
        return this.f845a != null;
    }

    public boolean c() {
        return this.f849b != null;
    }

    public boolean d() {
        return this.f850c != null;
    }

    public boolean e() {
        return this.f851d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return m585a((hl) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f852e != null;
    }

    public boolean g() {
        return this.f853f != null;
    }

    public boolean h() {
        return this.f854g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f855h != null;
    }

    public boolean j() {
        return this.f856i != null;
    }

    public boolean k() {
        return this.f847a.get(0);
    }

    public boolean l() {
        return this.f847a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        if (m584a()) {
            sb.append("debug:");
            String str = this.f846a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f845a;
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
        String str2 = this.f849b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f850c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f851d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f852e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f853f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f854g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f855h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f856i;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f848a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f844a);
        }
        sb.append(")");
        return sb.toString();
    }

    public hl a(String str) {
        this.f849b = str;
        return this;
    }

    public hl b(String str) {
        this.f850c = str;
        return this;
    }

    public hl c(String str) {
        this.f851d = str;
        return this;
    }

    public hl d(String str) {
        this.f853f = str;
        return this;
    }

    public hl e(String str) {
        this.f854g = str;
        return this;
    }

    public void a(boolean z) {
        this.f847a.set(0, z);
    }

    public void b(boolean z) {
        this.f847a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m585a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean zM584a = m584a();
        boolean zM584a2 = hlVar.m584a();
        if ((zM584a || zM584a2) && !(zM584a && zM584a2 && this.f846a.equals(hlVar.f846a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hlVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f845a.m507a(hlVar.f845a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hlVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f849b.equals(hlVar.f849b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hlVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f850c.equals(hlVar.f850c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hlVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f851d.equals(hlVar.f851d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hlVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f852e.equals(hlVar.f852e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hlVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f853f.equals(hlVar.f853f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hlVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f854g.equals(hlVar.f854g))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hlVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f855h.equals(hlVar.f855h))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hlVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f856i.equals(hlVar.f856i))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hlVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f848a == hlVar.f848a)) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hlVar.l();
        if (zL || zL2) {
            return zL && zL2 && this.f844a == hlVar.f844a;
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f843a);
        if (this.f846a != null && m584a()) {
            iaVar.a(f13173a);
            iaVar.a(this.f846a);
            iaVar.b();
        }
        if (this.f845a != null && b()) {
            iaVar.a(f13174b);
            this.f845a.b(iaVar);
            iaVar.b();
        }
        if (this.f849b != null) {
            iaVar.a(f13175c);
            iaVar.a(this.f849b);
            iaVar.b();
        }
        if (this.f850c != null) {
            iaVar.a(f13176d);
            iaVar.a(this.f850c);
            iaVar.b();
        }
        if (this.f851d != null && e()) {
            iaVar.a(f13177e);
            iaVar.a(this.f851d);
            iaVar.b();
        }
        if (this.f852e != null && f()) {
            iaVar.a(f13178f);
            iaVar.a(this.f852e);
            iaVar.b();
        }
        if (this.f853f != null && g()) {
            iaVar.a(f13179g);
            iaVar.a(this.f853f);
            iaVar.b();
        }
        if (this.f854g != null && h()) {
            iaVar.a(f13180h);
            iaVar.a(this.f854g);
            iaVar.b();
        }
        if (this.f855h != null && i()) {
            iaVar.a(f13181i);
            iaVar.a(this.f855h);
            iaVar.b();
        }
        if (this.f856i != null && j()) {
            iaVar.a(f13182j);
            iaVar.a(this.f856i);
            iaVar.b();
        }
        if (k()) {
            iaVar.a(f13183k);
            iaVar.a(this.f848a);
            iaVar.b();
        }
        if (l()) {
            iaVar.a(f13184l);
            iaVar.a(this.f844a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hl hlVar) {
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
        int iA11;
        int iA12;
        if (!hl.class.equals(hlVar.getClass())) {
            return hl.class.getName().compareTo(hlVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m584a()).compareTo(Boolean.valueOf(hlVar.m584a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m584a() && (iA12 = hr.a(this.f846a, hlVar.f846a)) != 0) {
            return iA12;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA11 = hr.a(this.f845a, hlVar.f845a)) != 0) {
            return iA11;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA10 = hr.a(this.f849b, hlVar.f849b)) != 0) {
            return iA10;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hlVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA9 = hr.a(this.f850c, hlVar.f850c)) != 0) {
            return iA9;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA8 = hr.a(this.f851d, hlVar.f851d)) != 0) {
            return iA8;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA7 = hr.a(this.f852e, hlVar.f852e)) != 0) {
            return iA7;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA6 = hr.a(this.f853f, hlVar.f853f)) != 0) {
            return iA6;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA5 = hr.a(this.f854g, hlVar.f854g)) != 0) {
            return iA5;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA4 = hr.a(this.f855h, hlVar.f855h)) != 0) {
            return iA4;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hlVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA3 = hr.a(this.f856i, hlVar.f856i)) != 0) {
            return iA3;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hlVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA2 = hr.a(this.f848a, hlVar.f848a)) != 0) {
            return iA2;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hlVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (!l() || (iA = hr.a(this.f844a, hlVar.f844a)) == 0) {
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
                a();
                return;
            }
            switch (hxVarMo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f846a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f845a = new gu();
                        this.f845a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f849b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f850c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f851d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f852e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f853f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f854g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f855h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f856i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f848a = iaVar.mo613a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 10) {
                        this.f844a = iaVar.mo602a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                default:
                    id.a(iaVar, b2);
                    break;
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f849b != null) {
            if (this.f850c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
