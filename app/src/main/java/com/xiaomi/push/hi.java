package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class hi implements hq<hi, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gr f810a;

    /* renamed from: a, reason: collision with other field name */
    public gu f811a;

    /* renamed from: a, reason: collision with other field name */
    public String f812a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f814a;

    /* renamed from: b, reason: collision with other field name */
    public String f816b;

    /* renamed from: c, reason: collision with other field name */
    public String f817c;

    /* renamed from: d, reason: collision with other field name */
    public String f818d;

    /* renamed from: e, reason: collision with other field name */
    public String f819e;

    /* renamed from: f, reason: collision with other field name */
    public String f820f;

    /* renamed from: g, reason: collision with other field name */
    public String f821g;

    /* renamed from: h, reason: collision with other field name */
    public String f822h;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f809a = new Cif("XmPushActionSendMessage");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13144a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13145b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13146c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13147d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13148e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13149f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13150g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13151h = new hx("", (byte) 12, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13152i = new hx("", (byte) 2, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13153j = new hx("", com.umeng.analytics.pro.cw.f10301k, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13154k = new hx("", (byte) 11, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13155l = new hx("", (byte) 11, 12);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f813a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public boolean f815a = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m570a() {
        return this.f812a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m572b() {
        return this.f811a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m573c() {
        return this.f816b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m574d() {
        return this.f817c != null;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m575e() {
        return this.f818d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return m571a((hi) obj);
        }
        return false;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m576f() {
        return this.f819e != null;
    }

    public boolean g() {
        return this.f820f != null;
    }

    public boolean h() {
        return this.f810a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f813a.get(0);
    }

    public boolean j() {
        return this.f814a != null;
    }

    public boolean k() {
        return this.f821g != null;
    }

    public boolean l() {
        return this.f822h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        if (m570a()) {
            sb.append("debug:");
            String str = this.f812a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m572b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f811a;
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
        String str2 = this.f816b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f817c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        if (m575e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f818d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (m576f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f819e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f820f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            gr grVar = this.f810a;
            if (grVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(grVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f815a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f814a;
            if (map == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f821g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f822h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m568a() {
        return this.f816b;
    }

    public String b() {
        return this.f817c;
    }

    public String c() {
        return this.f819e;
    }

    public String d() {
        return this.f820f;
    }

    public String e() {
        return this.f821g;
    }

    public String f() {
        return this.f822h;
    }

    public gr a() {
        return this.f810a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m569a();
        iaVar.a(f809a);
        if (this.f812a != null && m570a()) {
            iaVar.a(f13144a);
            iaVar.a(this.f812a);
            iaVar.b();
        }
        if (this.f811a != null && m572b()) {
            iaVar.a(f13145b);
            this.f811a.b(iaVar);
            iaVar.b();
        }
        if (this.f816b != null) {
            iaVar.a(f13146c);
            iaVar.a(this.f816b);
            iaVar.b();
        }
        if (this.f817c != null) {
            iaVar.a(f13147d);
            iaVar.a(this.f817c);
            iaVar.b();
        }
        if (this.f818d != null && m575e()) {
            iaVar.a(f13148e);
            iaVar.a(this.f818d);
            iaVar.b();
        }
        if (this.f819e != null && m576f()) {
            iaVar.a(f13149f);
            iaVar.a(this.f819e);
            iaVar.b();
        }
        if (this.f820f != null && g()) {
            iaVar.a(f13150g);
            iaVar.a(this.f820f);
            iaVar.b();
        }
        if (this.f810a != null && h()) {
            iaVar.a(f13151h);
            this.f810a.b(iaVar);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(f13152i);
            iaVar.a(this.f815a);
            iaVar.b();
        }
        if (this.f814a != null && j()) {
            iaVar.a(f13153j);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f814a.size()));
            for (Map.Entry<String, String> entry : this.f814a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f821g != null && k()) {
            iaVar.a(f13154k);
            iaVar.a(this.f821g);
            iaVar.b();
        }
        if (this.f822h != null && l()) {
            iaVar.a(f13155l);
            iaVar.a(this.f822h);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public void a(boolean z) {
        this.f813a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m571a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean zM570a = m570a();
        boolean zM570a2 = hiVar.m570a();
        if ((zM570a || zM570a2) && !(zM570a && zM570a2 && this.f812a.equals(hiVar.f812a))) {
            return false;
        }
        boolean zM572b = m572b();
        boolean zM572b2 = hiVar.m572b();
        if ((zM572b || zM572b2) && !(zM572b && zM572b2 && this.f811a.m507a(hiVar.f811a))) {
            return false;
        }
        boolean zM573c = m573c();
        boolean zM573c2 = hiVar.m573c();
        if ((zM573c || zM573c2) && !(zM573c && zM573c2 && this.f816b.equals(hiVar.f816b))) {
            return false;
        }
        boolean zM574d = m574d();
        boolean zM574d2 = hiVar.m574d();
        if ((zM574d || zM574d2) && !(zM574d && zM574d2 && this.f817c.equals(hiVar.f817c))) {
            return false;
        }
        boolean zM575e = m575e();
        boolean zM575e2 = hiVar.m575e();
        if ((zM575e || zM575e2) && !(zM575e && zM575e2 && this.f818d.equals(hiVar.f818d))) {
            return false;
        }
        boolean zM576f = m576f();
        boolean zM576f2 = hiVar.m576f();
        if ((zM576f || zM576f2) && !(zM576f && zM576f2 && this.f819e.equals(hiVar.f819e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hiVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f820f.equals(hiVar.f820f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hiVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f810a.m490a(hiVar.f810a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hiVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f815a == hiVar.f815a)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hiVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f814a.equals(hiVar.f814a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hiVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f821g.equals(hiVar.f821g))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hiVar.l();
        if (zL || zL2) {
            return zL && zL2 && this.f822h.equals(hiVar.f822h);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hi hiVar) {
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
        if (!hi.class.equals(hiVar.getClass())) {
            return hi.class.getName().compareTo(hiVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m570a()).compareTo(Boolean.valueOf(hiVar.m570a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m570a() && (iA12 = hr.a(this.f812a, hiVar.f812a)) != 0) {
            return iA12;
        }
        int iCompareTo2 = Boolean.valueOf(m572b()).compareTo(Boolean.valueOf(hiVar.m572b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m572b() && (iA11 = hr.a(this.f811a, hiVar.f811a)) != 0) {
            return iA11;
        }
        int iCompareTo3 = Boolean.valueOf(m573c()).compareTo(Boolean.valueOf(hiVar.m573c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m573c() && (iA10 = hr.a(this.f816b, hiVar.f816b)) != 0) {
            return iA10;
        }
        int iCompareTo4 = Boolean.valueOf(m574d()).compareTo(Boolean.valueOf(hiVar.m574d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m574d() && (iA9 = hr.a(this.f817c, hiVar.f817c)) != 0) {
            return iA9;
        }
        int iCompareTo5 = Boolean.valueOf(m575e()).compareTo(Boolean.valueOf(hiVar.m575e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m575e() && (iA8 = hr.a(this.f818d, hiVar.f818d)) != 0) {
            return iA8;
        }
        int iCompareTo6 = Boolean.valueOf(m576f()).compareTo(Boolean.valueOf(hiVar.m576f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (m576f() && (iA7 = hr.a(this.f819e, hiVar.f819e)) != 0) {
            return iA7;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hiVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA6 = hr.a(this.f820f, hiVar.f820f)) != 0) {
            return iA6;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hiVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA5 = hr.a(this.f810a, hiVar.f810a)) != 0) {
            return iA5;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hiVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA4 = hr.a(this.f815a, hiVar.f815a)) != 0) {
            return iA4;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hiVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA3 = hr.a(this.f814a, hiVar.f814a)) != 0) {
            return iA3;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hiVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA2 = hr.a(this.f821g, hiVar.f821g)) != 0) {
            return iA2;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hiVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (!l() || (iA = hr.a(this.f822h, hiVar.f822h)) == 0) {
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
                m569a();
                return;
            }
            switch (hxVarMo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f812a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f811a = new gu();
                        this.f811a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f816b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f817c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f818d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f819e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f820f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        this.f810a = new gr();
                        this.f810a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 2) {
                        this.f815a = iaVar.mo613a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        hz hzVarMo605a = iaVar.mo605a();
                        this.f814a = new HashMap(hzVarMo605a.f900a * 2);
                        for (int i2 = 0; i2 < hzVarMo605a.f900a; i2++) {
                            this.f814a.put(iaVar.mo608a(), iaVar.mo608a());
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f821g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f822h = iaVar.mo608a();
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

    /* renamed from: a, reason: collision with other method in class */
    public void m569a() throws ib {
        if (this.f816b != null) {
            if (this.f817c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
