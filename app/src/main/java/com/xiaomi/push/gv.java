package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gv implements hq<gv, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f653a;

    /* renamed from: a, reason: collision with other field name */
    public long f654a;

    /* renamed from: a, reason: collision with other field name */
    public gu f655a;

    /* renamed from: a, reason: collision with other field name */
    public hi f656a;

    /* renamed from: a, reason: collision with other field name */
    public String f657a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f659a;

    /* renamed from: a, reason: collision with other field name */
    public short f660a;

    /* renamed from: b, reason: collision with other field name */
    public String f662b;

    /* renamed from: b, reason: collision with other field name */
    public short f663b;

    /* renamed from: c, reason: collision with other field name */
    public String f664c;

    /* renamed from: d, reason: collision with other field name */
    public String f665d;

    /* renamed from: e, reason: collision with other field name */
    public String f666e;

    /* renamed from: f, reason: collision with other field name */
    public String f667f;

    /* renamed from: g, reason: collision with other field name */
    public String f668g;

    /* renamed from: h, reason: collision with other field name */
    public String f669h;

    /* renamed from: i, reason: collision with other field name */
    public String f670i;

    /* renamed from: j, reason: collision with other field name */
    public String f671j;

    /* renamed from: k, reason: collision with other field name */
    public String f672k;

    /* renamed from: l, reason: collision with other field name */
    public String f673l;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f652a = new Cif("XmPushActionAckMessage");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13041a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13042b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13043c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13044d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13045e = new hx("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13046f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13047g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13048h = new hx("", (byte) 12, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13049i = new hx("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13050j = new hx("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final hx f13051k = new hx("", (byte) 2, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final hx f13052l = new hx("", (byte) 11, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final hx f13053m = new hx("", (byte) 11, 13);
    private static final hx n = new hx("", (byte) 11, 14);
    private static final hx o = new hx("", (byte) 6, 15);
    private static final hx p = new hx("", (byte) 6, 16);
    private static final hx q = new hx("", (byte) 11, 20);
    private static final hx r = new hx("", (byte) 11, 21);
    private static final hx s = new hx("", (byte) 8, 22);
    private static final hx t = new hx("", com.umeng.analytics.pro.cw.f10301k, 23);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f658a = new BitSet(5);

    /* renamed from: a, reason: collision with other field name */
    public boolean f661a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m508a() {
        return this.f657a != null;
    }

    public boolean b() {
        return this.f655a != null;
    }

    public boolean c() {
        return this.f662b != null;
    }

    public boolean d() {
        return this.f664c != null;
    }

    public boolean e() {
        return this.f658a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gv)) {
            return m509a((gv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f665d != null;
    }

    public boolean g() {
        return this.f666e != null;
    }

    public boolean h() {
        return this.f656a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f667f != null;
    }

    public boolean j() {
        return this.f668g != null;
    }

    public boolean k() {
        return this.f658a.get(1);
    }

    public boolean l() {
        return this.f669h != null;
    }

    public boolean m() {
        return this.f670i != null;
    }

    public boolean n() {
        return this.f671j != null;
    }

    public boolean o() {
        return this.f658a.get(2);
    }

    public boolean p() {
        return this.f658a.get(3);
    }

    public boolean q() {
        return this.f672k != null;
    }

    public boolean r() {
        return this.f673l != null;
    }

    public boolean s() {
        return this.f658a.get(4);
    }

    public boolean t() {
        return this.f659a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        if (m508a()) {
            sb.append("debug:");
            String str = this.f657a;
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
            gu guVar = this.f655a;
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
        String str2 = this.f662b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f664c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f654a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f665d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f666e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            hi hiVar = this.f656a;
            if (hiVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(hiVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f667f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f668g;
            if (str7 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f661a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f669h;
            if (str8 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f670i;
            if (str9 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f671j;
            if (str10 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f660a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f663b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f672k;
            if (str11 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f673l;
            if (str12 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f653a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f659a;
            if (map == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gv a(String str) {
        this.f662b = str;
        return this;
    }

    public gv b(String str) {
        this.f664c = str;
        return this;
    }

    public gv c(String str) {
        this.f665d = str;
        return this;
    }

    public gv d(String str) {
        this.f666e = str;
        return this;
    }

    public void e(boolean z) {
        this.f658a.set(4, z);
    }

    public gv a(long j2) {
        this.f654a = j2;
        a(true);
        return this;
    }

    public void b(boolean z) {
        this.f658a.set(1, z);
    }

    public void c(boolean z) {
        this.f658a.set(2, z);
    }

    public void d(boolean z) {
        this.f658a.set(3, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f652a);
        if (this.f657a != null && m508a()) {
            iaVar.a(f13041a);
            iaVar.a(this.f657a);
            iaVar.b();
        }
        if (this.f655a != null && b()) {
            iaVar.a(f13042b);
            this.f655a.b(iaVar);
            iaVar.b();
        }
        if (this.f662b != null) {
            iaVar.a(f13043c);
            iaVar.a(this.f662b);
            iaVar.b();
        }
        if (this.f664c != null) {
            iaVar.a(f13044d);
            iaVar.a(this.f664c);
            iaVar.b();
        }
        iaVar.a(f13045e);
        iaVar.a(this.f654a);
        iaVar.b();
        if (this.f665d != null && f()) {
            iaVar.a(f13046f);
            iaVar.a(this.f665d);
            iaVar.b();
        }
        if (this.f666e != null && g()) {
            iaVar.a(f13047g);
            iaVar.a(this.f666e);
            iaVar.b();
        }
        if (this.f656a != null && h()) {
            iaVar.a(f13048h);
            this.f656a.b(iaVar);
            iaVar.b();
        }
        if (this.f667f != null && i()) {
            iaVar.a(f13049i);
            iaVar.a(this.f667f);
            iaVar.b();
        }
        if (this.f668g != null && j()) {
            iaVar.a(f13050j);
            iaVar.a(this.f668g);
            iaVar.b();
        }
        if (k()) {
            iaVar.a(f13051k);
            iaVar.a(this.f661a);
            iaVar.b();
        }
        if (this.f669h != null && l()) {
            iaVar.a(f13052l);
            iaVar.a(this.f669h);
            iaVar.b();
        }
        if (this.f670i != null && m()) {
            iaVar.a(f13053m);
            iaVar.a(this.f670i);
            iaVar.b();
        }
        if (this.f671j != null && n()) {
            iaVar.a(n);
            iaVar.a(this.f671j);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.a(this.f660a);
            iaVar.b();
        }
        if (p()) {
            iaVar.a(p);
            iaVar.a(this.f663b);
            iaVar.b();
        }
        if (this.f672k != null && q()) {
            iaVar.a(q);
            iaVar.a(this.f672k);
            iaVar.b();
        }
        if (this.f673l != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f673l);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.mo612a(this.f653a);
            iaVar.b();
        }
        if (this.f659a != null && t()) {
            iaVar.a(t);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f659a.size()));
            for (Map.Entry<String, String> entry : this.f659a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public void a(boolean z) {
        this.f658a.set(0, z);
    }

    public gv a(short s2) {
        this.f660a = s2;
        c(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m509a(gv gvVar) {
        if (gvVar == null) {
            return false;
        }
        boolean zM508a = m508a();
        boolean zM508a2 = gvVar.m508a();
        if ((zM508a || zM508a2) && !(zM508a && zM508a2 && this.f657a.equals(gvVar.f657a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = gvVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f655a.m507a(gvVar.f655a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gvVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f662b.equals(gvVar.f662b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gvVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f664c.equals(gvVar.f664c))) || this.f654a != gvVar.f654a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gvVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f665d.equals(gvVar.f665d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gvVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f666e.equals(gvVar.f666e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gvVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f656a.m571a(gvVar.f656a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gvVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f667f.equals(gvVar.f667f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gvVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f668g.equals(gvVar.f668g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gvVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f661a == gvVar.f661a)) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = gvVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f669h.equals(gvVar.f669h))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = gvVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f670i.equals(gvVar.f670i))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = gvVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f671j.equals(gvVar.f671j))) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = gvVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f660a == gvVar.f660a)) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = gvVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f663b == gvVar.f663b)) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = gvVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f672k.equals(gvVar.f672k))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = gvVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f673l.equals(gvVar.f673l))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = gvVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f653a == gvVar.f653a)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = gvVar.t();
        if (zT || zT2) {
            return zT && zT2 && this.f659a.equals(gvVar.f659a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gv gvVar) {
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
        if (!gv.class.equals(gvVar.getClass())) {
            return gv.class.getName().compareTo(gvVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m508a()).compareTo(Boolean.valueOf(gvVar.m508a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m508a() && (iA20 = hr.a(this.f657a, gvVar.f657a)) != 0) {
            return iA20;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gvVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA19 = hr.a(this.f655a, gvVar.f655a)) != 0) {
            return iA19;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gvVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA18 = hr.a(this.f662b, gvVar.f662b)) != 0) {
            return iA18;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gvVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA17 = hr.a(this.f664c, gvVar.f664c)) != 0) {
            return iA17;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gvVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA16 = hr.a(this.f654a, gvVar.f654a)) != 0) {
            return iA16;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gvVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA15 = hr.a(this.f665d, gvVar.f665d)) != 0) {
            return iA15;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gvVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA14 = hr.a(this.f666e, gvVar.f666e)) != 0) {
            return iA14;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gvVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA13 = hr.a(this.f656a, gvVar.f656a)) != 0) {
            return iA13;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gvVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA12 = hr.a(this.f667f, gvVar.f667f)) != 0) {
            return iA12;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gvVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA11 = hr.a(this.f668g, gvVar.f668g)) != 0) {
            return iA11;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gvVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA10 = hr.a(this.f661a, gvVar.f661a)) != 0) {
            return iA10;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gvVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA9 = hr.a(this.f669h, gvVar.f669h)) != 0) {
            return iA9;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gvVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA8 = hr.a(this.f670i, gvVar.f670i)) != 0) {
            return iA8;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gvVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA7 = hr.a(this.f671j, gvVar.f671j)) != 0) {
            return iA7;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gvVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA6 = hr.a(this.f660a, gvVar.f660a)) != 0) {
            return iA6;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gvVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA5 = hr.a(this.f663b, gvVar.f663b)) != 0) {
            return iA5;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gvVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA4 = hr.a(this.f672k, gvVar.f672k)) != 0) {
            return iA4;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gvVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA3 = hr.a(this.f673l, gvVar.f673l)) != 0) {
            return iA3;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(gvVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA2 = hr.a(this.f653a, gvVar.f653a)) != 0) {
            return iA2;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(gvVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (!t() || (iA = hr.a(this.f659a, gvVar.f659a)) == 0) {
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
                    a();
                    return;
                }
                throw new ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f657a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f655a = new gu();
                        this.f655a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f662b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f664c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f654a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f665d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f666e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        this.f656a = new hi();
                        this.f656a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f667f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f668g = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f661a = iaVar.mo613a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f669h = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f670i = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.f671j = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 6) {
                        this.f660a = iaVar.mo610a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 6) {
                        this.f663b = iaVar.mo610a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    id.a(iaVar, b2);
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f672k = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 11) {
                        this.f673l = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 22:
                    if (b2 == 8) {
                        this.f653a = iaVar.mo601a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 23:
                    if (b2 == 13) {
                        hz hzVarMo605a = iaVar.mo605a();
                        this.f659a = new HashMap(hzVarMo605a.f900a * 2);
                        for (int i2 = 0; i2 < hzVarMo605a.f900a; i2++) {
                            this.f659a.put(iaVar.mo608a(), iaVar.mo608a());
                        }
                        iaVar.h();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f662b != null) {
            if (this.f664c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
