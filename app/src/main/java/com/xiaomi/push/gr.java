package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gr implements hq<gr, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f608a;

    /* renamed from: a, reason: collision with other field name */
    public gs f609a;

    /* renamed from: a, reason: collision with other field name */
    public gu f610a;

    /* renamed from: a, reason: collision with other field name */
    public String f611a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f612a = new BitSet(4);

    /* renamed from: a, reason: collision with other field name */
    public boolean f613a = false;

    /* renamed from: b, reason: collision with other field name */
    public long f614b;

    /* renamed from: b, reason: collision with other field name */
    public String f615b;

    /* renamed from: c, reason: collision with other field name */
    public long f616c;

    /* renamed from: c, reason: collision with other field name */
    public String f617c;

    /* renamed from: d, reason: collision with other field name */
    public String f618d;

    /* renamed from: e, reason: collision with other field name */
    public String f619e;

    /* renamed from: f, reason: collision with other field name */
    public String f620f;

    /* renamed from: g, reason: collision with other field name */
    public String f621g;

    /* renamed from: h, reason: collision with other field name */
    public String f622h;

    /* renamed from: i, reason: collision with other field name */
    public String f623i;

    /* renamed from: j, reason: collision with other field name */
    public String f624j;

    /* renamed from: k, reason: collision with other field name */
    public String f625k;

    /* renamed from: l, reason: collision with other field name */
    public String f626l;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f607a = new Cif("PushMessage");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13006a = new hx("", (byte) 12, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13007b = new hx("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13008c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13009d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13010e = new hx("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13011f = new hx("", (byte) 10, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13012g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13013h = new hx("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13014i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13015j = new hx("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13016k = new hx("", (byte) 11, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13017l = new hx("", (byte) 12, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13018m = new hx("", (byte) 11, 13);
    private static final hx n = new hx("", (byte) 2, 14);
    private static final hx o = new hx("", (byte) 11, 15);
    private static final hx p = new hx("", (byte) 10, 16);
    private static final hx q = new hx("", (byte) 11, 20);
    private static final hx r = new hx("", (byte) 11, 21);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m489a() {
        return this.f610a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m491b() {
        return this.f611a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m492c() {
        return this.f615b != null;
    }

    public boolean d() {
        return this.f617c != null;
    }

    public boolean e() {
        return this.f612a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gr)) {
            return m490a((gr) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f612a.get(1);
    }

    public boolean g() {
        return this.f618d != null;
    }

    public boolean h() {
        return this.f619e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f620f != null;
    }

    public boolean j() {
        return this.f621g != null;
    }

    public boolean k() {
        return this.f622h != null;
    }

    public boolean l() {
        return this.f609a != null;
    }

    public boolean m() {
        return this.f623i != null;
    }

    public boolean n() {
        return this.f612a.get(2);
    }

    public boolean o() {
        return this.f624j != null;
    }

    public boolean p() {
        return this.f612a.get(3);
    }

    public boolean q() {
        return this.f625k != null;
    }

    public boolean r() {
        return this.f626l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m489a()) {
            sb.append("to:");
            gu guVar = this.f610a;
            if (guVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(guVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f611a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f615b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f617c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f608a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f614b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f618d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f619e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f620f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f621g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f622h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gs gsVar = this.f609a;
            if (gsVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(gsVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f623i;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f613a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f624j;
            if (str10 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f616c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f625k;
            if (str11 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f626l;
            if (str12 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m487a() {
        return this.f611a;
    }

    public String b() {
        return this.f615b;
    }

    public String c() {
        return this.f617c;
    }

    public void d(boolean z) {
        this.f612a.set(3, z);
    }

    public long a() {
        return this.f608a;
    }

    public void b(boolean z) {
        this.f612a.set(1, z);
    }

    public void c(boolean z) {
        this.f612a.set(2, z);
    }

    public void a(boolean z) {
        this.f612a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m488a();
        iaVar.a(f607a);
        if (this.f610a != null && m489a()) {
            iaVar.a(f13006a);
            this.f610a.b(iaVar);
            iaVar.b();
        }
        if (this.f611a != null) {
            iaVar.a(f13007b);
            iaVar.a(this.f611a);
            iaVar.b();
        }
        if (this.f615b != null) {
            iaVar.a(f13008c);
            iaVar.a(this.f615b);
            iaVar.b();
        }
        if (this.f617c != null) {
            iaVar.a(f13009d);
            iaVar.a(this.f617c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f13010e);
            iaVar.a(this.f608a);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f13011f);
            iaVar.a(this.f614b);
            iaVar.b();
        }
        if (this.f618d != null && g()) {
            iaVar.a(f13012g);
            iaVar.a(this.f618d);
            iaVar.b();
        }
        if (this.f619e != null && h()) {
            iaVar.a(f13013h);
            iaVar.a(this.f619e);
            iaVar.b();
        }
        if (this.f620f != null && i()) {
            iaVar.a(f13014i);
            iaVar.a(this.f620f);
            iaVar.b();
        }
        if (this.f621g != null && j()) {
            iaVar.a(f13015j);
            iaVar.a(this.f621g);
            iaVar.b();
        }
        if (this.f622h != null && k()) {
            iaVar.a(f13016k);
            iaVar.a(this.f622h);
            iaVar.b();
        }
        if (this.f609a != null && l()) {
            iaVar.a(f13017l);
            this.f609a.b(iaVar);
            iaVar.b();
        }
        if (this.f623i != null && m()) {
            iaVar.a(f13018m);
            iaVar.a(this.f623i);
            iaVar.b();
        }
        if (n()) {
            iaVar.a(n);
            iaVar.a(this.f613a);
            iaVar.b();
        }
        if (this.f624j != null && o()) {
            iaVar.a(o);
            iaVar.a(this.f624j);
            iaVar.b();
        }
        if (p()) {
            iaVar.a(p);
            iaVar.a(this.f616c);
            iaVar.b();
        }
        if (this.f625k != null && q()) {
            iaVar.a(q);
            iaVar.a(this.f625k);
            iaVar.b();
        }
        if (this.f626l != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f626l);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m490a(gr grVar) {
        if (grVar == null) {
            return false;
        }
        boolean zM489a = m489a();
        boolean zM489a2 = grVar.m489a();
        if ((zM489a || zM489a2) && !(zM489a && zM489a2 && this.f610a.m507a(grVar.f610a))) {
            return false;
        }
        boolean zM491b = m491b();
        boolean zM491b2 = grVar.m491b();
        if ((zM491b || zM491b2) && !(zM491b && zM491b2 && this.f611a.equals(grVar.f611a))) {
            return false;
        }
        boolean zM492c = m492c();
        boolean zM492c2 = grVar.m492c();
        if ((zM492c || zM492c2) && !(zM492c && zM492c2 && this.f615b.equals(grVar.f615b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = grVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f617c.equals(grVar.f617c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = grVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f608a == grVar.f608a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = grVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f614b == grVar.f614b)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = grVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f618d.equals(grVar.f618d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = grVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f619e.equals(grVar.f619e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = grVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f620f.equals(grVar.f620f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = grVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f621g.equals(grVar.f621g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = grVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f622h.equals(grVar.f622h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = grVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f609a.m499a(grVar.f609a))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = grVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f623i.equals(grVar.f623i))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = grVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f613a == grVar.f613a)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = grVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f624j.equals(grVar.f624j))) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = grVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f616c == grVar.f616c)) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = grVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f625k.equals(grVar.f625k))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = grVar.r();
        if (zR || zR2) {
            return zR && zR2 && this.f626l.equals(grVar.f626l);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gr grVar) {
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
        int iA13;
        int iA14;
        int iA15;
        int iA16;
        int iA17;
        int iA18;
        if (!gr.class.equals(grVar.getClass())) {
            return gr.class.getName().compareTo(grVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m489a()).compareTo(Boolean.valueOf(grVar.m489a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m489a() && (iA18 = hr.a(this.f610a, grVar.f610a)) != 0) {
            return iA18;
        }
        int iCompareTo2 = Boolean.valueOf(m491b()).compareTo(Boolean.valueOf(grVar.m491b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m491b() && (iA17 = hr.a(this.f611a, grVar.f611a)) != 0) {
            return iA17;
        }
        int iCompareTo3 = Boolean.valueOf(m492c()).compareTo(Boolean.valueOf(grVar.m492c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m492c() && (iA16 = hr.a(this.f615b, grVar.f615b)) != 0) {
            return iA16;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(grVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA15 = hr.a(this.f617c, grVar.f617c)) != 0) {
            return iA15;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(grVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA14 = hr.a(this.f608a, grVar.f608a)) != 0) {
            return iA14;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(grVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA13 = hr.a(this.f614b, grVar.f614b)) != 0) {
            return iA13;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(grVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA12 = hr.a(this.f618d, grVar.f618d)) != 0) {
            return iA12;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(grVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA11 = hr.a(this.f619e, grVar.f619e)) != 0) {
            return iA11;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(grVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA10 = hr.a(this.f620f, grVar.f620f)) != 0) {
            return iA10;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(grVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA9 = hr.a(this.f621g, grVar.f621g)) != 0) {
            return iA9;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(grVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA8 = hr.a(this.f622h, grVar.f622h)) != 0) {
            return iA8;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(grVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA7 = hr.a(this.f609a, grVar.f609a)) != 0) {
            return iA7;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(grVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA6 = hr.a(this.f623i, grVar.f623i)) != 0) {
            return iA6;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(grVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA5 = hr.a(this.f613a, grVar.f613a)) != 0) {
            return iA5;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(grVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA4 = hr.a(this.f624j, grVar.f624j)) != 0) {
            return iA4;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(grVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA3 = hr.a(this.f616c, grVar.f616c)) != 0) {
            return iA3;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(grVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA2 = hr.a(this.f625k, grVar.f625k)) != 0) {
            return iA2;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(grVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (!r() || (iA = hr.a(this.f626l, grVar.f626l)) == 0) {
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
                m488a();
                return;
            }
            short s = hxVarMo603a.f898a;
            if (s != 20) {
                if (s != 21) {
                    switch (s) {
                        case 1:
                            if (b2 == 12) {
                                this.f610a = new gu();
                                this.f610a.a(iaVar);
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 2:
                            if (b2 == 11) {
                                this.f611a = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 3:
                            if (b2 == 11) {
                                this.f615b = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 4:
                            if (b2 == 11) {
                                this.f617c = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 5:
                            if (b2 == 10) {
                                this.f608a = iaVar.mo602a();
                                a(true);
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 6:
                            if (b2 == 10) {
                                this.f614b = iaVar.mo602a();
                                b(true);
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 7:
                            if (b2 == 11) {
                                this.f618d = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 8:
                            if (b2 == 11) {
                                this.f619e = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 9:
                            if (b2 == 11) {
                                this.f620f = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 10:
                            if (b2 == 11) {
                                this.f621g = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 11:
                            if (b2 == 11) {
                                this.f622h = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 12:
                            if (b2 == 12) {
                                this.f609a = new gs();
                                this.f609a.a(iaVar);
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 13:
                            if (b2 == 11) {
                                this.f623i = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 14:
                            if (b2 == 2) {
                                this.f613a = iaVar.mo613a();
                                c(true);
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 15:
                            if (b2 == 11) {
                                this.f624j = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 16:
                            if (b2 == 10) {
                                this.f616c = iaVar.mo602a();
                                d(true);
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        default:
                            id.a(iaVar, b2);
                            break;
                    }
                } else if (b2 == 11) {
                    this.f626l = iaVar.mo608a();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 11) {
                this.f625k = iaVar.mo608a();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m488a() throws ib {
        if (this.f611a != null) {
            if (this.f615b != null) {
                if (this.f617c != null) {
                    return;
                }
                throw new ib("Required field 'payload' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
