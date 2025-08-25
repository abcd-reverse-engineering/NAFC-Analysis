package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hn implements hq<hn, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gu f869a;

    /* renamed from: a, reason: collision with other field name */
    public String f870a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f871a;

    /* renamed from: b, reason: collision with other field name */
    public String f872b;

    /* renamed from: c, reason: collision with other field name */
    public String f873c;

    /* renamed from: d, reason: collision with other field name */
    public String f874d;

    /* renamed from: e, reason: collision with other field name */
    public String f875e;

    /* renamed from: f, reason: collision with other field name */
    public String f876f;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f868a = new Cif("XmPushActionUnSubscription");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13194a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13195b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13196c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13197d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13198e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13199f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13200g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13201h = new hx("", com.umeng.analytics.pro.cw.f10303m, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m589a() {
        return this.f870a != null;
    }

    public boolean b() {
        return this.f869a != null;
    }

    public boolean c() {
        return this.f872b != null;
    }

    public boolean d() {
        return this.f873c != null;
    }

    public boolean e() {
        return this.f874d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return m590a((hn) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f875e != null;
    }

    public boolean g() {
        return this.f876f != null;
    }

    public boolean h() {
        return this.f871a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        if (m589a()) {
            sb.append("debug:");
            String str = this.f870a;
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
            gu guVar = this.f869a;
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
        String str2 = this.f872b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f873c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f874d;
        if (str4 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f875e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f876f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f871a;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hn a(String str) {
        this.f872b = str;
        return this;
    }

    public hn b(String str) {
        this.f873c = str;
        return this;
    }

    public hn c(String str) {
        this.f874d = str;
        return this;
    }

    public hn d(String str) {
        this.f875e = str;
        return this;
    }

    public hn e(String str) {
        this.f876f = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m590a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean zM589a = m589a();
        boolean zM589a2 = hnVar.m589a();
        if ((zM589a || zM589a2) && !(zM589a && zM589a2 && this.f870a.equals(hnVar.f870a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hnVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f869a.m507a(hnVar.f869a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hnVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f872b.equals(hnVar.f872b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hnVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f873c.equals(hnVar.f873c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hnVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f874d.equals(hnVar.f874d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hnVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f875e.equals(hnVar.f875e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hnVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f876f.equals(hnVar.f876f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hnVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f871a.equals(hnVar.f871a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f868a);
        if (this.f870a != null && m589a()) {
            iaVar.a(f13194a);
            iaVar.a(this.f870a);
            iaVar.b();
        }
        if (this.f869a != null && b()) {
            iaVar.a(f13195b);
            this.f869a.b(iaVar);
            iaVar.b();
        }
        if (this.f872b != null) {
            iaVar.a(f13196c);
            iaVar.a(this.f872b);
            iaVar.b();
        }
        if (this.f873c != null) {
            iaVar.a(f13197d);
            iaVar.a(this.f873c);
            iaVar.b();
        }
        if (this.f874d != null) {
            iaVar.a(f13198e);
            iaVar.a(this.f874d);
            iaVar.b();
        }
        if (this.f875e != null && f()) {
            iaVar.a(f13199f);
            iaVar.a(this.f875e);
            iaVar.b();
        }
        if (this.f876f != null && g()) {
            iaVar.a(f13200g);
            iaVar.a(this.f876f);
            iaVar.b();
        }
        if (this.f871a != null && h()) {
            iaVar.a(f13201h);
            iaVar.a(new hy((byte) 11, this.f871a.size()));
            Iterator<String> it = this.f871a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hn hnVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!hn.class.equals(hnVar.getClass())) {
            return hn.class.getName().compareTo(hnVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m589a()).compareTo(Boolean.valueOf(hnVar.m589a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m589a() && (iA8 = hr.a(this.f870a, hnVar.f870a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = hr.a(this.f869a, hnVar.f869a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hnVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = hr.a(this.f872b, hnVar.f872b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = hr.a(this.f873c, hnVar.f873c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = hr.a(this.f874d, hnVar.f874d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = hr.a(this.f875e, hnVar.f875e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = hr.a(this.f876f, hnVar.f876f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = hr.a(this.f871a, hnVar.f871a)) == 0) {
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
                        this.f870a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f869a = new gu();
                        this.f869a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f872b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f873c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f874d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f875e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f876f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 15) {
                        hy hyVarMo604a = iaVar.mo604a();
                        this.f871a = new ArrayList(hyVarMo604a.f899a);
                        for (int i2 = 0; i2 < hyVarMo604a.f899a; i2++) {
                            this.f871a.add(iaVar.mo608a());
                        }
                        iaVar.i();
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
        if (this.f872b != null) {
            if (this.f873c != null) {
                if (this.f874d != null) {
                    return;
                }
                throw new ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
