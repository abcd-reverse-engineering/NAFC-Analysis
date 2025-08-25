package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hg implements hq<hg, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f779a;

    /* renamed from: a, reason: collision with other field name */
    public long f780a;

    /* renamed from: a, reason: collision with other field name */
    public gu f781a;

    /* renamed from: a, reason: collision with other field name */
    public String f782a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f784a;

    /* renamed from: b, reason: collision with other field name */
    public int f786b;

    /* renamed from: b, reason: collision with other field name */
    public long f787b;

    /* renamed from: b, reason: collision with other field name */
    public String f788b;

    /* renamed from: c, reason: collision with other field name */
    public long f789c;

    /* renamed from: c, reason: collision with other field name */
    public String f790c;

    /* renamed from: d, reason: collision with other field name */
    public String f791d;

    /* renamed from: e, reason: collision with other field name */
    public String f792e;

    /* renamed from: f, reason: collision with other field name */
    public String f793f;

    /* renamed from: g, reason: collision with other field name */
    public String f794g;

    /* renamed from: h, reason: collision with other field name */
    public String f795h;

    /* renamed from: i, reason: collision with other field name */
    public String f796i;

    /* renamed from: j, reason: collision with other field name */
    public String f797j;

    /* renamed from: k, reason: collision with other field name */
    public String f798k;

    /* renamed from: l, reason: collision with other field name */
    public String f799l;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f778a = new Cif("XmPushActionRegistrationResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13124a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13125b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13126c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13127d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13128e = new hx("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13129f = new hx("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13130g = new hx("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13131h = new hx("", (byte) 11, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13132i = new hx("", (byte) 11, 10);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13133j = new hx("", (byte) 10, 11);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13134k = new hx("", (byte) 11, 12);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13135l = new hx("", (byte) 11, 13);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13136m = new hx("", (byte) 10, 14);
    private static final hx n = new hx("", (byte) 11, 15);
    private static final hx o = new hx("", (byte) 8, 16);
    private static final hx p = new hx("", (byte) 11, 17);
    private static final hx q = new hx("", (byte) 8, 18);
    private static final hx r = new hx("", (byte) 11, 19);
    private static final hx s = new hx("", (byte) 2, 20);
    private static final hx t = new hx("", com.umeng.analytics.pro.cw.f10303m, 21);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f783a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f785a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m562a() {
        return this.f782a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m564b() {
        return this.f781a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m565c() {
        return this.f788b != null;
    }

    public boolean d() {
        return this.f790c != null;
    }

    public boolean e() {
        return this.f783a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hg)) {
            return m563a((hg) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f791d != null;
    }

    public boolean g() {
        return this.f792e != null;
    }

    public boolean h() {
        return this.f793f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f794g != null;
    }

    public boolean j() {
        return this.f783a.get(1);
    }

    public boolean k() {
        return this.f795h != null;
    }

    public boolean l() {
        return this.f796i != null;
    }

    public boolean m() {
        return this.f783a.get(2);
    }

    public boolean n() {
        return this.f797j != null;
    }

    public boolean o() {
        return this.f783a.get(3);
    }

    public boolean p() {
        return this.f798k != null;
    }

    public boolean q() {
        return this.f783a.get(4);
    }

    public boolean r() {
        return this.f799l != null;
    }

    public boolean s() {
        return this.f783a.get(5);
    }

    public boolean t() {
        return this.f784a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        if (m562a()) {
            sb.append("debug:");
            String str = this.f782a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m564b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f781a;
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
        String str2 = this.f788b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f790c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f780a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f791d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f792e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f794g;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f787b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f795h;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f796i;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f789c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f797j;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f779a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f798k;
            if (str10 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f786b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f799l;
            if (str11 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f785a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f784a;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m559a() {
        return this.f788b;
    }

    public String b() {
        return this.f793f;
    }

    public String c() {
        return this.f794g;
    }

    public void d(boolean z) {
        this.f783a.set(3, z);
    }

    public void e(boolean z) {
        this.f783a.set(4, z);
    }

    public void f(boolean z) {
        this.f783a.set(5, z);
    }

    public long a() {
        return this.f780a;
    }

    public void b(boolean z) {
        this.f783a.set(1, z);
    }

    public void c(boolean z) {
        this.f783a.set(2, z);
    }

    public void a(boolean z) {
        this.f783a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m561a();
        iaVar.a(f778a);
        if (this.f782a != null && m562a()) {
            iaVar.a(f13124a);
            iaVar.a(this.f782a);
            iaVar.b();
        }
        if (this.f781a != null && m564b()) {
            iaVar.a(f13125b);
            this.f781a.b(iaVar);
            iaVar.b();
        }
        if (this.f788b != null) {
            iaVar.a(f13126c);
            iaVar.a(this.f788b);
            iaVar.b();
        }
        if (this.f790c != null) {
            iaVar.a(f13127d);
            iaVar.a(this.f790c);
            iaVar.b();
        }
        iaVar.a(f13128e);
        iaVar.a(this.f780a);
        iaVar.b();
        if (this.f791d != null && f()) {
            iaVar.a(f13129f);
            iaVar.a(this.f791d);
            iaVar.b();
        }
        if (this.f792e != null && g()) {
            iaVar.a(f13130g);
            iaVar.a(this.f792e);
            iaVar.b();
        }
        if (this.f793f != null && h()) {
            iaVar.a(f13131h);
            iaVar.a(this.f793f);
            iaVar.b();
        }
        if (this.f794g != null && i()) {
            iaVar.a(f13132i);
            iaVar.a(this.f794g);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(f13133j);
            iaVar.a(this.f787b);
            iaVar.b();
        }
        if (this.f795h != null && k()) {
            iaVar.a(f13134k);
            iaVar.a(this.f795h);
            iaVar.b();
        }
        if (this.f796i != null && l()) {
            iaVar.a(f13135l);
            iaVar.a(this.f796i);
            iaVar.b();
        }
        if (m()) {
            iaVar.a(f13136m);
            iaVar.a(this.f789c);
            iaVar.b();
        }
        if (this.f797j != null && n()) {
            iaVar.a(n);
            iaVar.a(this.f797j);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.mo612a(this.f779a);
            iaVar.b();
        }
        if (this.f798k != null && p()) {
            iaVar.a(p);
            iaVar.a(this.f798k);
            iaVar.b();
        }
        if (q()) {
            iaVar.a(q);
            iaVar.mo612a(this.f786b);
            iaVar.b();
        }
        if (this.f799l != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f799l);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.a(this.f785a);
            iaVar.b();
        }
        if (this.f784a != null && t()) {
            iaVar.a(t);
            iaVar.a(new hy((byte) 11, this.f784a.size()));
            Iterator<String> it = this.f784a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m560a() {
        return this.f784a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m563a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean zM562a = m562a();
        boolean zM562a2 = hgVar.m562a();
        if ((zM562a || zM562a2) && !(zM562a && zM562a2 && this.f782a.equals(hgVar.f782a))) {
            return false;
        }
        boolean zM564b = m564b();
        boolean zM564b2 = hgVar.m564b();
        if ((zM564b || zM564b2) && !(zM564b && zM564b2 && this.f781a.m507a(hgVar.f781a))) {
            return false;
        }
        boolean zM565c = m565c();
        boolean zM565c2 = hgVar.m565c();
        if ((zM565c || zM565c2) && !(zM565c && zM565c2 && this.f788b.equals(hgVar.f788b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hgVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f790c.equals(hgVar.f790c))) || this.f780a != hgVar.f780a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hgVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f791d.equals(hgVar.f791d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hgVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f792e.equals(hgVar.f792e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hgVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f793f.equals(hgVar.f793f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hgVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f794g.equals(hgVar.f794g))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hgVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f787b == hgVar.f787b)) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hgVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f795h.equals(hgVar.f795h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hgVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f796i.equals(hgVar.f796i))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = hgVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f789c == hgVar.f789c)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = hgVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f797j.equals(hgVar.f797j))) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = hgVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f779a == hgVar.f779a)) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = hgVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f798k.equals(hgVar.f798k))) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = hgVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f786b == hgVar.f786b)) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = hgVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f799l.equals(hgVar.f799l))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = hgVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f785a == hgVar.f785a)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = hgVar.t();
        if (zT || zT2) {
            return zT && zT2 && this.f784a.equals(hgVar.f784a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hg hgVar) {
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
        int iA19;
        int iA20;
        if (!hg.class.equals(hgVar.getClass())) {
            return hg.class.getName().compareTo(hgVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m562a()).compareTo(Boolean.valueOf(hgVar.m562a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m562a() && (iA20 = hr.a(this.f782a, hgVar.f782a)) != 0) {
            return iA20;
        }
        int iCompareTo2 = Boolean.valueOf(m564b()).compareTo(Boolean.valueOf(hgVar.m564b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m564b() && (iA19 = hr.a(this.f781a, hgVar.f781a)) != 0) {
            return iA19;
        }
        int iCompareTo3 = Boolean.valueOf(m565c()).compareTo(Boolean.valueOf(hgVar.m565c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m565c() && (iA18 = hr.a(this.f788b, hgVar.f788b)) != 0) {
            return iA18;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hgVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA17 = hr.a(this.f790c, hgVar.f790c)) != 0) {
            return iA17;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hgVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA16 = hr.a(this.f780a, hgVar.f780a)) != 0) {
            return iA16;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hgVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA15 = hr.a(this.f791d, hgVar.f791d)) != 0) {
            return iA15;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hgVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA14 = hr.a(this.f792e, hgVar.f792e)) != 0) {
            return iA14;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hgVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA13 = hr.a(this.f793f, hgVar.f793f)) != 0) {
            return iA13;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hgVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA12 = hr.a(this.f794g, hgVar.f794g)) != 0) {
            return iA12;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hgVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA11 = hr.a(this.f787b, hgVar.f787b)) != 0) {
            return iA11;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hgVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA10 = hr.a(this.f795h, hgVar.f795h)) != 0) {
            return iA10;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hgVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA9 = hr.a(this.f796i, hgVar.f796i)) != 0) {
            return iA9;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hgVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA8 = hr.a(this.f789c, hgVar.f789c)) != 0) {
            return iA8;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hgVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA7 = hr.a(this.f797j, hgVar.f797j)) != 0) {
            return iA7;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hgVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA6 = hr.a(this.f779a, hgVar.f779a)) != 0) {
            return iA6;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hgVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA5 = hr.a(this.f798k, hgVar.f798k)) != 0) {
            return iA5;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hgVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA4 = hr.a(this.f786b, hgVar.f786b)) != 0) {
            return iA4;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hgVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA3 = hr.a(this.f799l, hgVar.f799l)) != 0) {
            return iA3;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hgVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA2 = hr.a(this.f785a, hgVar.f785a)) != 0) {
            return iA2;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hgVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (!t() || (iA = hr.a(this.f784a, hgVar.f784a)) == 0) {
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
                if (e()) {
                    m561a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f782a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f781a = new gu();
                        this.f781a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f788b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f790c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                default:
                    id.a(iaVar, b2);
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f780a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f791d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f792e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f793f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f794g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 10) {
                        this.f787b = iaVar.mo602a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f795h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f796i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 10) {
                        this.f789c = iaVar.mo602a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f797j = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 8) {
                        this.f779a = iaVar.mo601a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.f798k = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 8) {
                        this.f786b = iaVar.mo601a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 19:
                    if (b2 == 11) {
                        this.f799l = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.f785a = iaVar.mo613a();
                        f(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 15) {
                        hy hyVarMo604a = iaVar.mo604a();
                        this.f784a = new ArrayList(hyVarMo604a.f899a);
                        for (int i2 = 0; i2 < hyVarMo604a.f899a; i2++) {
                            this.f784a.add(iaVar.mo608a());
                        }
                        iaVar.i();
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
    public void m561a() throws ib {
        if (this.f788b != null) {
            if (this.f790c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
