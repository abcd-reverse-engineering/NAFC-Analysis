package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ha implements hq<ha, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f705a;

    /* renamed from: a, reason: collision with other field name */
    public gu f706a;

    /* renamed from: a, reason: collision with other field name */
    public String f707a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f709a;

    /* renamed from: b, reason: collision with other field name */
    public String f711b;

    /* renamed from: c, reason: collision with other field name */
    public String f712c;

    /* renamed from: d, reason: collision with other field name */
    public String f713d;

    /* renamed from: e, reason: collision with other field name */
    public String f714e;

    /* renamed from: f, reason: collision with other field name */
    public String f715f;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f704a = new Cif("XmPushActionCommandResult");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13078a = new hx("", (byte) 12, 2);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13079b = new hx("", (byte) 11, 3);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13080c = new hx("", (byte) 11, 4);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13081d = new hx("", (byte) 11, 5);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13082e = new hx("", (byte) 10, 7);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13083f = new hx("", (byte) 11, 8);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13084g = new hx("", (byte) 11, 9);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13085h = new hx("", com.umeng.analytics.pro.cw.f10303m, 10);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f13086i = new hx("", (byte) 11, 12);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f13087j = new hx("", (byte) 2, 13);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f708a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f710a = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m525a() {
        return this.f706a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m527b() {
        return this.f707a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m528c() {
        return this.f711b != null;
    }

    public boolean d() {
        return this.f712c != null;
    }

    public boolean e() {
        return this.f708a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ha)) {
            return m526a((ha) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f713d != null;
    }

    public boolean g() {
        return this.f714e != null;
    }

    public boolean h() {
        return this.f709a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f715f != null;
    }

    public boolean j() {
        return this.f708a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m525a()) {
            sb.append("target:");
            gu guVar = this.f706a;
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
        String str = this.f707a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f711b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f712c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f705a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f713d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f714e;
            if (str5 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f709a;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f715f;
            if (str6 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f710a);
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f707a;
    }

    public String b() {
        return this.f712c;
    }

    public String c() {
        return this.f715f;
    }

    public void a(boolean z) {
        this.f708a.set(0, z);
    }

    public void b(boolean z) {
        this.f708a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m523a() {
        return this.f709a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m524a();
        iaVar.a(f704a);
        if (this.f706a != null && m525a()) {
            iaVar.a(f13078a);
            this.f706a.b(iaVar);
            iaVar.b();
        }
        if (this.f707a != null) {
            iaVar.a(f13079b);
            iaVar.a(this.f707a);
            iaVar.b();
        }
        if (this.f711b != null) {
            iaVar.a(f13080c);
            iaVar.a(this.f711b);
            iaVar.b();
        }
        if (this.f712c != null) {
            iaVar.a(f13081d);
            iaVar.a(this.f712c);
            iaVar.b();
        }
        iaVar.a(f13082e);
        iaVar.a(this.f705a);
        iaVar.b();
        if (this.f713d != null && f()) {
            iaVar.a(f13083f);
            iaVar.a(this.f713d);
            iaVar.b();
        }
        if (this.f714e != null && g()) {
            iaVar.a(f13084g);
            iaVar.a(this.f714e);
            iaVar.b();
        }
        if (this.f709a != null && h()) {
            iaVar.a(f13085h);
            iaVar.a(new hy((byte) 11, this.f709a.size()));
            Iterator<String> it = this.f709a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f715f != null && i()) {
            iaVar.a(f13086i);
            iaVar.a(this.f715f);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(f13087j);
            iaVar.a(this.f710a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m526a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean zM525a = m525a();
        boolean zM525a2 = haVar.m525a();
        if ((zM525a || zM525a2) && !(zM525a && zM525a2 && this.f706a.m507a(haVar.f706a))) {
            return false;
        }
        boolean zM527b = m527b();
        boolean zM527b2 = haVar.m527b();
        if ((zM527b || zM527b2) && !(zM527b && zM527b2 && this.f707a.equals(haVar.f707a))) {
            return false;
        }
        boolean zM528c = m528c();
        boolean zM528c2 = haVar.m528c();
        if ((zM528c || zM528c2) && !(zM528c && zM528c2 && this.f711b.equals(haVar.f711b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = haVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f712c.equals(haVar.f712c))) || this.f705a != haVar.f705a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = haVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f713d.equals(haVar.f713d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = haVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f714e.equals(haVar.f714e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = haVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f709a.equals(haVar.f709a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = haVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f715f.equals(haVar.f715f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = haVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f710a == haVar.f710a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ha haVar) {
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
        if (!ha.class.equals(haVar.getClass())) {
            return ha.class.getName().compareTo(haVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m525a()).compareTo(Boolean.valueOf(haVar.m525a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m525a() && (iA10 = hr.a(this.f706a, haVar.f706a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m527b()).compareTo(Boolean.valueOf(haVar.m527b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m527b() && (iA9 = hr.a(this.f707a, haVar.f707a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(m528c()).compareTo(Boolean.valueOf(haVar.m528c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m528c() && (iA8 = hr.a(this.f711b, haVar.f711b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f712c, haVar.f712c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f705a, haVar.f705a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f713d, haVar.f713d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f714e, haVar.f714e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f709a, haVar.f709a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(haVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f715f, haVar.f715f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(haVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f710a, haVar.f710a)) == 0) {
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
                    m524a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo603a.f898a) {
                case 2:
                    if (b2 == 12) {
                        this.f706a = new gu();
                        this.f706a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f707a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f711b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f712c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                case 11:
                default:
                    id.a(iaVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f705a = iaVar.mo602a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f713d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f714e = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 15) {
                        hy hyVarMo604a = iaVar.mo604a();
                        this.f709a = new ArrayList(hyVarMo604a.f899a);
                        for (int i2 = 0; i2 < hyVarMo604a.f899a; i2++) {
                            this.f709a.add(iaVar.mo608a());
                        }
                        iaVar.i();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f715f = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 2) {
                        this.f710a = iaVar.mo613a();
                        b(true);
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
    public void m524a() throws ib {
        if (this.f707a != null) {
            if (this.f711b != null) {
                if (this.f712c != null) {
                    return;
                }
                throw new ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
