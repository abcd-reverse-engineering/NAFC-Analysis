package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class hf implements hq<hf, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f748a;

    /* renamed from: a, reason: collision with other field name */
    public long f749a;

    /* renamed from: a, reason: collision with other field name */
    public gt f750a;

    /* renamed from: a, reason: collision with other field name */
    public gu f751a;

    /* renamed from: a, reason: collision with other field name */
    public String f752a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f754a;

    /* renamed from: b, reason: collision with other field name */
    public int f756b;

    /* renamed from: b, reason: collision with other field name */
    public long f757b;

    /* renamed from: b, reason: collision with other field name */
    public String f758b;

    /* renamed from: c, reason: collision with other field name */
    public int f760c;

    /* renamed from: c, reason: collision with other field name */
    public String f761c;

    /* renamed from: d, reason: collision with other field name */
    public String f763d;

    /* renamed from: e, reason: collision with other field name */
    public String f764e;

    /* renamed from: f, reason: collision with other field name */
    public String f765f;

    /* renamed from: g, reason: collision with other field name */
    public String f766g;

    /* renamed from: h, reason: collision with other field name */
    public String f767h;

    /* renamed from: i, reason: collision with other field name */
    public String f768i;

    /* renamed from: j, reason: collision with other field name */
    public String f769j;

    /* renamed from: k, reason: collision with other field name */
    public String f770k;

    /* renamed from: l, reason: collision with other field name */
    public String f771l;

    /* renamed from: m, reason: collision with other field name */
    public String f772m;

    /* renamed from: n, reason: collision with other field name */
    public String f773n;

    /* renamed from: o, reason: collision with other field name */
    public String f774o;

    /* renamed from: p, reason: collision with other field name */
    public String f775p;

    /* renamed from: q, reason: collision with other field name */
    public String f776q;

    /* renamed from: r, reason: collision with other field name */
    public String f777r;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f747a = new Cif("XmPushActionRegistration");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13111a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13112b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13113c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13114d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13115e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13116f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13117g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13118h = new hx("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13119i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13120j = new hx("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13121k = new hx("", (byte) 11, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13122l = new hx("", (byte) 11, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13123m = new hx("", (byte) 8, 13);
    private static final hx n = new hx("", (byte) 8, 14);
    private static final hx o = new hx("", (byte) 11, 15);
    private static final hx p = new hx("", (byte) 11, 16);
    private static final hx q = new hx("", (byte) 11, 17);
    private static final hx r = new hx("", (byte) 11, 18);
    private static final hx s = new hx("", (byte) 8, 19);
    private static final hx t = new hx("", (byte) 8, 20);
    private static final hx u = new hx("", (byte) 2, 21);
    private static final hx v = new hx("", (byte) 10, 22);
    private static final hx w = new hx("", (byte) 10, 23);
    private static final hx x = new hx("", (byte) 11, 24);
    private static final hx y = new hx("", (byte) 11, 25);
    private static final hx z = new hx("", (byte) 2, 26);
    private static final hx A = new hx("", com.umeng.analytics.pro.cw.f10301k, 100);
    private static final hx B = new hx("", (byte) 2, 101);
    private static final hx C = new hx("", (byte) 11, 102);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f753a = new BitSet(8);

    /* renamed from: a, reason: collision with other field name */
    public boolean f755a = true;

    /* renamed from: c, reason: collision with other field name */
    public boolean f762c = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f759b = false;

    public boolean A() {
        return this.f754a != null;
    }

    public boolean B() {
        return this.f753a.get(7);
    }

    public boolean C() {
        return this.f777r != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m555a() {
        return this.f752a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m557b() {
        return this.f751a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m558c() {
        return this.f758b != null;
    }

    public boolean d() {
        return this.f761c != null;
    }

    public boolean e() {
        return this.f763d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hf)) {
            return m556a((hf) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f764e != null;
    }

    public boolean g() {
        return this.f765f != null;
    }

    public boolean h() {
        return this.f766g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f767h != null;
    }

    public boolean j() {
        return this.f768i != null;
    }

    public boolean k() {
        return this.f769j != null;
    }

    public boolean l() {
        return this.f770k != null;
    }

    public boolean m() {
        return this.f753a.get(0);
    }

    public boolean n() {
        return this.f753a.get(1);
    }

    public boolean o() {
        return this.f771l != null;
    }

    public boolean p() {
        return this.f772m != null;
    }

    public boolean q() {
        return this.f773n != null;
    }

    public boolean r() {
        return this.f774o != null;
    }

    public boolean s() {
        return this.f753a.get(2);
    }

    public boolean t() {
        return this.f750a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        if (m555a()) {
            sb.append("debug:");
            String str = this.f752a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m557b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f751a;
            if (guVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(guVar);
            }
            z2 = false;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f758b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f761c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f763d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f764e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f765f;
        if (str6 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f766g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f767h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f768i;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f769j;
            if (str10 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f770k;
            if (str11 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f748a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f756b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f771l;
            if (str12 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f772m;
            if (str13 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f773n;
            if (str14 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f774o;
            if (str15 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f760c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            gt gtVar = this.f750a;
            if (gtVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(gtVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f755a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f749a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f757b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f775p;
            if (str16 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f776q;
            if (str17 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f759b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f754a;
            if (map == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f762c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f777r;
            if (str18 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f753a.get(3);
    }

    public boolean v() {
        return this.f753a.get(4);
    }

    public boolean w() {
        return this.f753a.get(5);
    }

    public boolean x() {
        return this.f775p != null;
    }

    public boolean y() {
        return this.f776q != null;
    }

    public boolean z() {
        return this.f753a.get(6);
    }

    public String a() {
        return this.f758b;
    }

    public String b() {
        return this.f761c;
    }

    public hf c(String str) {
        this.f763d = str;
        return this;
    }

    public hf d(String str) {
        this.f764e = str;
        return this;
    }

    public hf e(String str) {
        this.f765f = str;
        return this;
    }

    public hf f(String str) {
        this.f766g = str;
        return this;
    }

    public hf g(String str) {
        this.f767h = str;
        return this;
    }

    public hf h(String str) {
        this.f770k = str;
        return this;
    }

    public hf i(String str) {
        this.f774o = str;
        return this;
    }

    public hf a(String str) {
        this.f758b = str;
        return this;
    }

    public hf b(String str) {
        this.f761c = str;
        return this;
    }

    public String c() {
        return this.f765f;
    }

    public void d(boolean z2) {
        this.f753a.set(3, z2);
    }

    public void e(boolean z2) {
        this.f753a.set(4, z2);
    }

    public void f(boolean z2) {
        this.f753a.set(5, z2);
    }

    public void g(boolean z2) {
        this.f753a.set(6, z2);
    }

    public void h(boolean z2) {
        this.f753a.set(7, z2);
    }

    public hf a(int i2) {
        this.f748a = i2;
        a(true);
        return this;
    }

    public hf b(int i2) {
        this.f756b = i2;
        b(true);
        return this;
    }

    public hf c(int i2) {
        this.f760c = i2;
        c(true);
        return this;
    }

    public void a(boolean z2) {
        this.f753a.set(0, z2);
    }

    public void b(boolean z2) {
        this.f753a.set(1, z2);
    }

    public void c(boolean z2) {
        this.f753a.set(2, z2);
    }

    public hf a(gt gtVar) {
        this.f750a = gtVar;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m554a();
        iaVar.a(f747a);
        if (this.f752a != null && m555a()) {
            iaVar.a(f13111a);
            iaVar.a(this.f752a);
            iaVar.b();
        }
        if (this.f751a != null && m557b()) {
            iaVar.a(f13112b);
            this.f751a.b(iaVar);
            iaVar.b();
        }
        if (this.f758b != null) {
            iaVar.a(f13113c);
            iaVar.a(this.f758b);
            iaVar.b();
        }
        if (this.f761c != null) {
            iaVar.a(f13114d);
            iaVar.a(this.f761c);
            iaVar.b();
        }
        if (this.f763d != null && e()) {
            iaVar.a(f13115e);
            iaVar.a(this.f763d);
            iaVar.b();
        }
        if (this.f764e != null && f()) {
            iaVar.a(f13116f);
            iaVar.a(this.f764e);
            iaVar.b();
        }
        if (this.f765f != null) {
            iaVar.a(f13117g);
            iaVar.a(this.f765f);
            iaVar.b();
        }
        if (this.f766g != null && h()) {
            iaVar.a(f13118h);
            iaVar.a(this.f766g);
            iaVar.b();
        }
        if (this.f767h != null && i()) {
            iaVar.a(f13119i);
            iaVar.a(this.f767h);
            iaVar.b();
        }
        if (this.f768i != null && j()) {
            iaVar.a(f13120j);
            iaVar.a(this.f768i);
            iaVar.b();
        }
        if (this.f769j != null && k()) {
            iaVar.a(f13121k);
            iaVar.a(this.f769j);
            iaVar.b();
        }
        if (this.f770k != null && l()) {
            iaVar.a(f13122l);
            iaVar.a(this.f770k);
            iaVar.b();
        }
        if (m()) {
            iaVar.a(f13123m);
            iaVar.mo612a(this.f748a);
            iaVar.b();
        }
        if (n()) {
            iaVar.a(n);
            iaVar.mo612a(this.f756b);
            iaVar.b();
        }
        if (this.f771l != null && o()) {
            iaVar.a(o);
            iaVar.a(this.f771l);
            iaVar.b();
        }
        if (this.f772m != null && p()) {
            iaVar.a(p);
            iaVar.a(this.f772m);
            iaVar.b();
        }
        if (this.f773n != null && q()) {
            iaVar.a(q);
            iaVar.a(this.f773n);
            iaVar.b();
        }
        if (this.f774o != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f774o);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.mo612a(this.f760c);
            iaVar.b();
        }
        if (this.f750a != null && t()) {
            iaVar.a(t);
            iaVar.mo612a(this.f750a.a());
            iaVar.b();
        }
        if (u()) {
            iaVar.a(u);
            iaVar.a(this.f755a);
            iaVar.b();
        }
        if (v()) {
            iaVar.a(v);
            iaVar.a(this.f749a);
            iaVar.b();
        }
        if (w()) {
            iaVar.a(w);
            iaVar.a(this.f757b);
            iaVar.b();
        }
        if (this.f775p != null && x()) {
            iaVar.a(x);
            iaVar.a(this.f775p);
            iaVar.b();
        }
        if (this.f776q != null && y()) {
            iaVar.a(y);
            iaVar.a(this.f776q);
            iaVar.b();
        }
        if (z()) {
            iaVar.a(z);
            iaVar.a(this.f759b);
            iaVar.b();
        }
        if (this.f754a != null && A()) {
            iaVar.a(A);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f754a.size()));
            for (Map.Entry<String, String> entry : this.f754a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (B()) {
            iaVar.a(B);
            iaVar.a(this.f762c);
            iaVar.b();
        }
        if (this.f777r != null && C()) {
            iaVar.a(C);
            iaVar.a(this.f777r);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m556a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean zM555a = m555a();
        boolean zM555a2 = hfVar.m555a();
        if ((zM555a || zM555a2) && !(zM555a && zM555a2 && this.f752a.equals(hfVar.f752a))) {
            return false;
        }
        boolean zM557b = m557b();
        boolean zM557b2 = hfVar.m557b();
        if ((zM557b || zM557b2) && !(zM557b && zM557b2 && this.f751a.m507a(hfVar.f751a))) {
            return false;
        }
        boolean zM558c = m558c();
        boolean zM558c2 = hfVar.m558c();
        if ((zM558c || zM558c2) && !(zM558c && zM558c2 && this.f758b.equals(hfVar.f758b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hfVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f761c.equals(hfVar.f761c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hfVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f763d.equals(hfVar.f763d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hfVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f764e.equals(hfVar.f764e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hfVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f765f.equals(hfVar.f765f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hfVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f766g.equals(hfVar.f766g))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hfVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f767h.equals(hfVar.f767h))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hfVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f768i.equals(hfVar.f768i))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hfVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f769j.equals(hfVar.f769j))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hfVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f770k.equals(hfVar.f770k))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = hfVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f748a == hfVar.f748a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = hfVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f756b == hfVar.f756b)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = hfVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f771l.equals(hfVar.f771l))) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = hfVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f772m.equals(hfVar.f772m))) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = hfVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f773n.equals(hfVar.f773n))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = hfVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f774o.equals(hfVar.f774o))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = hfVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f760c == hfVar.f760c)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = hfVar.t();
        if ((zT || zT2) && !(zT && zT2 && this.f750a.equals(hfVar.f750a))) {
            return false;
        }
        boolean zU = u();
        boolean zU2 = hfVar.u();
        if ((zU || zU2) && !(zU && zU2 && this.f755a == hfVar.f755a)) {
            return false;
        }
        boolean zV = v();
        boolean zV2 = hfVar.v();
        if ((zV || zV2) && !(zV && zV2 && this.f749a == hfVar.f749a)) {
            return false;
        }
        boolean zW = w();
        boolean zW2 = hfVar.w();
        if ((zW || zW2) && !(zW && zW2 && this.f757b == hfVar.f757b)) {
            return false;
        }
        boolean zX = x();
        boolean zX2 = hfVar.x();
        if ((zX || zX2) && !(zX && zX2 && this.f775p.equals(hfVar.f775p))) {
            return false;
        }
        boolean zY = y();
        boolean zY2 = hfVar.y();
        if ((zY || zY2) && !(zY && zY2 && this.f776q.equals(hfVar.f776q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = hfVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f759b == hfVar.f759b)) {
            return false;
        }
        boolean zA = A();
        boolean zA2 = hfVar.A();
        if ((zA || zA2) && !(zA && zA2 && this.f754a.equals(hfVar.f754a))) {
            return false;
        }
        boolean zB = B();
        boolean zB2 = hfVar.B();
        if ((zB || zB2) && !(zB && zB2 && this.f762c == hfVar.f762c)) {
            return false;
        }
        boolean zC = C();
        boolean zC2 = hfVar.C();
        if (zC || zC2) {
            return zC && zC2 && this.f777r.equals(hfVar.f777r);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hf hfVar) {
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
        int iA21;
        int iA22;
        int iA23;
        int iA24;
        int iA25;
        int iA26;
        int iA27;
        int iA28;
        int iA29;
        if (!hf.class.equals(hfVar.getClass())) {
            return hf.class.getName().compareTo(hfVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m555a()).compareTo(Boolean.valueOf(hfVar.m555a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m555a() && (iA29 = hr.a(this.f752a, hfVar.f752a)) != 0) {
            return iA29;
        }
        int iCompareTo2 = Boolean.valueOf(m557b()).compareTo(Boolean.valueOf(hfVar.m557b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m557b() && (iA28 = hr.a(this.f751a, hfVar.f751a)) != 0) {
            return iA28;
        }
        int iCompareTo3 = Boolean.valueOf(m558c()).compareTo(Boolean.valueOf(hfVar.m558c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m558c() && (iA27 = hr.a(this.f758b, hfVar.f758b)) != 0) {
            return iA27;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hfVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA26 = hr.a(this.f761c, hfVar.f761c)) != 0) {
            return iA26;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA25 = hr.a(this.f763d, hfVar.f763d)) != 0) {
            return iA25;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hfVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA24 = hr.a(this.f764e, hfVar.f764e)) != 0) {
            return iA24;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hfVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA23 = hr.a(this.f765f, hfVar.f765f)) != 0) {
            return iA23;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hfVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA22 = hr.a(this.f766g, hfVar.f766g)) != 0) {
            return iA22;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hfVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA21 = hr.a(this.f767h, hfVar.f767h)) != 0) {
            return iA21;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hfVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA20 = hr.a(this.f768i, hfVar.f768i)) != 0) {
            return iA20;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hfVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA19 = hr.a(this.f769j, hfVar.f769j)) != 0) {
            return iA19;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hfVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA18 = hr.a(this.f770k, hfVar.f770k)) != 0) {
            return iA18;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hfVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA17 = hr.a(this.f748a, hfVar.f748a)) != 0) {
            return iA17;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hfVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA16 = hr.a(this.f756b, hfVar.f756b)) != 0) {
            return iA16;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hfVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA15 = hr.a(this.f771l, hfVar.f771l)) != 0) {
            return iA15;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hfVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA14 = hr.a(this.f772m, hfVar.f772m)) != 0) {
            return iA14;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hfVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA13 = hr.a(this.f773n, hfVar.f773n)) != 0) {
            return iA13;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hfVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA12 = hr.a(this.f774o, hfVar.f774o)) != 0) {
            return iA12;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hfVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA11 = hr.a(this.f760c, hfVar.f760c)) != 0) {
            return iA11;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hfVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (t() && (iA10 = hr.a(this.f750a, hfVar.f750a)) != 0) {
            return iA10;
        }
        int iCompareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hfVar.u()));
        if (iCompareTo21 != 0) {
            return iCompareTo21;
        }
        if (u() && (iA9 = hr.a(this.f755a, hfVar.f755a)) != 0) {
            return iA9;
        }
        int iCompareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hfVar.v()));
        if (iCompareTo22 != 0) {
            return iCompareTo22;
        }
        if (v() && (iA8 = hr.a(this.f749a, hfVar.f749a)) != 0) {
            return iA8;
        }
        int iCompareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(hfVar.w()));
        if (iCompareTo23 != 0) {
            return iCompareTo23;
        }
        if (w() && (iA7 = hr.a(this.f757b, hfVar.f757b)) != 0) {
            return iA7;
        }
        int iCompareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(hfVar.x()));
        if (iCompareTo24 != 0) {
            return iCompareTo24;
        }
        if (x() && (iA6 = hr.a(this.f775p, hfVar.f775p)) != 0) {
            return iA6;
        }
        int iCompareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hfVar.y()));
        if (iCompareTo25 != 0) {
            return iCompareTo25;
        }
        if (y() && (iA5 = hr.a(this.f776q, hfVar.f776q)) != 0) {
            return iA5;
        }
        int iCompareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(hfVar.z()));
        if (iCompareTo26 != 0) {
            return iCompareTo26;
        }
        if (z() && (iA4 = hr.a(this.f759b, hfVar.f759b)) != 0) {
            return iA4;
        }
        int iCompareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(hfVar.A()));
        if (iCompareTo27 != 0) {
            return iCompareTo27;
        }
        if (A() && (iA3 = hr.a(this.f754a, hfVar.f754a)) != 0) {
            return iA3;
        }
        int iCompareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(hfVar.B()));
        if (iCompareTo28 != 0) {
            return iCompareTo28;
        }
        if (B() && (iA2 = hr.a(this.f762c, hfVar.f762c)) != 0) {
            return iA2;
        }
        int iCompareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(hfVar.C()));
        if (iCompareTo29 != 0) {
            return iCompareTo29;
        }
        if (!C() || (iA = hr.a(this.f777r, hfVar.f777r)) == 0) {
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
                m554a();
                return;
            }
            short s2 = hxVarMo603a.f898a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f752a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f751a = new gu();
                        this.f751a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f758b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f761c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f763d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f764e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f765f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f766g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f767h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f768i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f769j = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f770k = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 8) {
                        this.f748a = iaVar.mo601a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 8) {
                        this.f756b = iaVar.mo601a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f771l = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 11) {
                        this.f772m = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.f773n = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 11) {
                        this.f774o = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 19:
                    if (b2 == 8) {
                        this.f760c = iaVar.mo601a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 8) {
                        this.f750a = gt.a(iaVar.mo601a());
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 2) {
                        this.f755a = iaVar.mo613a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 22:
                    if (b2 == 10) {
                        this.f749a = iaVar.mo602a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 23:
                    if (b2 == 10) {
                        this.f757b = iaVar.mo602a();
                        f(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 24:
                    if (b2 == 11) {
                        this.f775p = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 25:
                    if (b2 == 11) {
                        this.f776q = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 26:
                    if (b2 == 2) {
                        this.f759b = iaVar.mo613a();
                        g(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                hz hzVarMo605a = iaVar.mo605a();
                                this.f754a = new HashMap(hzVarMo605a.f900a * 2);
                                for (int i2 = 0; i2 < hzVarMo605a.f900a; i2++) {
                                    this.f754a.put(iaVar.mo608a(), iaVar.mo608a());
                                }
                                iaVar.h();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 101:
                            if (b2 == 2) {
                                this.f762c = iaVar.mo613a();
                                h(true);
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        case 102:
                            if (b2 == 11) {
                                this.f777r = iaVar.mo608a();
                                break;
                            } else {
                                id.a(iaVar, b2);
                                break;
                            }
                        default:
                            id.a(iaVar, b2);
                            break;
                    }
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m554a() throws ib {
        if (this.f758b != null) {
            if (this.f761c != null) {
                if (this.f765f != null) {
                    return;
                }
                throw new ib("Required field 'token' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
