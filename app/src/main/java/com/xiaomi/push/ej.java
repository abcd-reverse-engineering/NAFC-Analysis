package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class ej implements hq<ej, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public byte f429a;

    /* renamed from: a, reason: collision with other field name */
    public int f430a;

    /* renamed from: a, reason: collision with other field name */
    public String f431a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f432a = new BitSet(6);

    /* renamed from: b, reason: collision with other field name */
    public int f433b;

    /* renamed from: b, reason: collision with other field name */
    public String f434b;

    /* renamed from: c, reason: collision with other field name */
    public int f435c;

    /* renamed from: c, reason: collision with other field name */
    public String f436c;

    /* renamed from: d, reason: collision with other field name */
    public int f437d;

    /* renamed from: d, reason: collision with other field name */
    public String f438d;

    /* renamed from: e, reason: collision with other field name */
    public int f439e;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f428a = new Cif("StatsEvent");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f12756a = new hx("", (byte) 3, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f12757b = new hx("", (byte) 8, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f12758c = new hx("", (byte) 8, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f12759d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f12760e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f12761f = new hx("", (byte) 8, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f12762g = new hx("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f12763h = new hx("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final hx f12764i = new hx("", (byte) 8, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final hx f12765j = new hx("", (byte) 8, 10);

    public ej a(byte b2) {
        this.f429a = b2;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f432a.get(1);
    }

    public boolean c() {
        return this.f432a.get(2);
    }

    public boolean d() {
        return this.f431a != null;
    }

    public boolean e() {
        return this.f434b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ej)) {
            return m376a((ej) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f432a.get(3);
    }

    public boolean g() {
        return this.f436c != null;
    }

    public boolean h() {
        return this.f438d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f432a.get(4);
    }

    public boolean j() {
        return this.f432a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f429a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f430a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f433b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f431a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f434b;
            if (str2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f435c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f436c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f438d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f437d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f439e);
        }
        sb.append(")");
        return sb.toString();
    }

    public void b(boolean z) {
        this.f432a.set(1, z);
    }

    public void c(boolean z) {
        this.f432a.set(2, z);
    }

    public void d(boolean z) {
        this.f432a.set(3, z);
    }

    public void e(boolean z) {
        this.f432a.set(4, z);
    }

    public void f(boolean z) {
        this.f432a.set(5, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m375a() {
        return this.f432a.get(0);
    }

    public ej b(int i2) {
        this.f433b = i2;
        c(true);
        return this;
    }

    public ej c(int i2) {
        this.f435c = i2;
        d(true);
        return this;
    }

    public ej d(String str) {
        this.f438d = str;
        return this;
    }

    public void a(boolean z) {
        this.f432a.set(0, z);
    }

    public ej d(int i2) {
        this.f437d = i2;
        e(true);
        return this;
    }

    public ej a(int i2) {
        this.f430a = i2;
        b(true);
        return this;
    }

    public ej b(String str) {
        this.f434b = str;
        return this;
    }

    public ej c(String str) {
        this.f436c = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f428a);
        iaVar.a(f12756a);
        iaVar.a(this.f429a);
        iaVar.b();
        iaVar.a(f12757b);
        iaVar.mo612a(this.f430a);
        iaVar.b();
        iaVar.a(f12758c);
        iaVar.mo612a(this.f433b);
        iaVar.b();
        if (this.f431a != null) {
            iaVar.a(f12759d);
            iaVar.a(this.f431a);
            iaVar.b();
        }
        if (this.f434b != null && e()) {
            iaVar.a(f12760e);
            iaVar.a(this.f434b);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f12761f);
            iaVar.mo612a(this.f435c);
            iaVar.b();
        }
        if (this.f436c != null && g()) {
            iaVar.a(f12762g);
            iaVar.a(this.f436c);
            iaVar.b();
        }
        if (this.f438d != null && h()) {
            iaVar.a(f12763h);
            iaVar.a(this.f438d);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(f12764i);
            iaVar.mo612a(this.f437d);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(f12765j);
            iaVar.mo612a(this.f439e);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public ej a(String str) {
        this.f431a = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m376a(ej ejVar) {
        if (ejVar == null || this.f429a != ejVar.f429a || this.f430a != ejVar.f430a || this.f433b != ejVar.f433b) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ejVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f431a.equals(ejVar.f431a))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ejVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f434b.equals(ejVar.f434b))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ejVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f435c == ejVar.f435c)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ejVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f436c.equals(ejVar.f436c))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ejVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f438d.equals(ejVar.f438d))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ejVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f437d == ejVar.f437d)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ejVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f439e == ejVar.f439e;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ej ejVar) {
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
        if (!ej.class.equals(ejVar.getClass())) {
            return ej.class.getName().compareTo(ejVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m375a()).compareTo(Boolean.valueOf(ejVar.m375a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m375a() && (iA10 = hr.a(this.f429a, ejVar.f429a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ejVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA9 = hr.a(this.f430a, ejVar.f430a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ejVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hr.a(this.f433b, ejVar.f433b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ejVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f431a, ejVar.f431a)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ejVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f434b, ejVar.f434b)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ejVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f435c, ejVar.f435c)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ejVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f436c, ejVar.f436c)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ejVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f438d, ejVar.f438d)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ejVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f437d, ejVar.f437d)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ejVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f439e, ejVar.f439e)) == 0) {
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
                if (m375a()) {
                    if (b()) {
                        if (c()) {
                            a();
                            return;
                        }
                        throw new ib("Required field 'value' was not found in serialized data! Struct: " + toString());
                    }
                    throw new ib("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                throw new ib("Required field 'chid' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo603a.f898a) {
                case 1:
                    if (b2 == 3) {
                        this.f429a = iaVar.a();
                        a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 8) {
                        this.f430a = iaVar.mo601a();
                        b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 8) {
                        this.f433b = iaVar.mo601a();
                        c(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f431a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f434b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 8) {
                        this.f435c = iaVar.mo601a();
                        d(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f436c = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f438d = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 8) {
                        this.f437d = iaVar.mo601a();
                        e(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 8) {
                        this.f439e = iaVar.mo601a();
                        f(true);
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
        if (this.f431a != null) {
            return;
        }
        throw new ib("Required field 'connpt' was not present! Struct: " + toString());
    }
}
