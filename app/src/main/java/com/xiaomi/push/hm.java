package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hm implements hq<hm, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f858a;

    /* renamed from: a, reason: collision with other field name */
    public gu f859a;

    /* renamed from: a, reason: collision with other field name */
    public String f860a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f861a = new BitSet(3);

    /* renamed from: b, reason: collision with other field name */
    public long f862b;

    /* renamed from: b, reason: collision with other field name */
    public String f863b;

    /* renamed from: c, reason: collision with other field name */
    public long f864c;

    /* renamed from: c, reason: collision with other field name */
    public String f865c;

    /* renamed from: d, reason: collision with other field name */
    public String f866d;

    /* renamed from: e, reason: collision with other field name */
    public String f867e;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f857a = new Cif("XmPushActionUnRegistrationResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13185a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13186b = new hx("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13187c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13188d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13189e = new hx("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13190f = new hx("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13191g = new hx("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13192h = new hx("", (byte) 10, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13193i = new hx("", (byte) 10, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m587a() {
        return this.f860a != null;
    }

    public boolean b() {
        return this.f859a != null;
    }

    public boolean c() {
        return this.f863b != null;
    }

    public boolean d() {
        return this.f865c != null;
    }

    public boolean e() {
        return this.f861a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return m588a((hm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f866d != null;
    }

    public boolean g() {
        return this.f867e != null;
    }

    public boolean h() {
        return this.f861a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f861a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        if (m587a()) {
            sb.append("debug:");
            String str = this.f860a;
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
            gu guVar = this.f859a;
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
        String str2 = this.f863b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f865c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f858a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f866d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f867e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f862b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f864c);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f861a.set(0, z);
    }

    public void b(boolean z) {
        this.f861a.set(1, z);
    }

    public void c(boolean z) {
        this.f861a.set(2, z);
    }

    public String a() {
        return this.f867e;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m586a();
        iaVar.a(f857a);
        if (this.f860a != null && m587a()) {
            iaVar.a(f13185a);
            iaVar.a(this.f860a);
            iaVar.b();
        }
        if (this.f859a != null && b()) {
            iaVar.a(f13186b);
            this.f859a.b(iaVar);
            iaVar.b();
        }
        if (this.f863b != null) {
            iaVar.a(f13187c);
            iaVar.a(this.f863b);
            iaVar.b();
        }
        if (this.f865c != null) {
            iaVar.a(f13188d);
            iaVar.a(this.f865c);
            iaVar.b();
        }
        iaVar.a(f13189e);
        iaVar.a(this.f858a);
        iaVar.b();
        if (this.f866d != null && f()) {
            iaVar.a(f13190f);
            iaVar.a(this.f866d);
            iaVar.b();
        }
        if (this.f867e != null && g()) {
            iaVar.a(f13191g);
            iaVar.a(this.f867e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(f13192h);
            iaVar.a(this.f862b);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(f13193i);
            iaVar.a(this.f864c);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m588a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean zM587a = m587a();
        boolean zM587a2 = hmVar.m587a();
        if ((zM587a || zM587a2) && !(zM587a && zM587a2 && this.f860a.equals(hmVar.f860a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hmVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f859a.m507a(hmVar.f859a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hmVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f863b.equals(hmVar.f863b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hmVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f865c.equals(hmVar.f865c))) || this.f858a != hmVar.f858a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hmVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f866d.equals(hmVar.f866d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hmVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f867e.equals(hmVar.f867e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hmVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f862b == hmVar.f862b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hmVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f864c == hmVar.f864c;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hm hmVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!hm.class.equals(hmVar.getClass())) {
            return hm.class.getName().compareTo(hmVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m587a()).compareTo(Boolean.valueOf(hmVar.m587a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m587a() && (iA9 = hr.a(this.f860a, hmVar.f860a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hmVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA8 = hr.a(this.f859a, hmVar.f859a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hmVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA7 = hr.a(this.f863b, hmVar.f863b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hr.a(this.f865c, hmVar.f865c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hmVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hr.a(this.f858a, hmVar.f858a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hr.a(this.f866d, hmVar.f866d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hr.a(this.f867e, hmVar.f867e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hmVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hr.a(this.f862b, hmVar.f862b)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hmVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hr.a(this.f864c, hmVar.f864c)) == 0) {
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
                    m586a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo603a.f898a) {
                case 1:
                    if (b2 == 11) {
                        this.f860a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f859a = new gu();
                        this.f859a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f863b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f865c = iaVar.mo608a();
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
                        this.f858a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f866d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f867e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 10) {
                        this.f862b = iaVar.mo602a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 10) {
                        this.f864c = iaVar.mo602a();
                        c(true);
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
    public void m586a() throws ib {
        if (this.f863b != null) {
            if (this.f865c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
