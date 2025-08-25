package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hb implements hq<hb, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gf f717a;

    /* renamed from: a, reason: collision with other field name */
    public gs f718a;

    /* renamed from: a, reason: collision with other field name */
    public gu f719a;

    /* renamed from: a, reason: collision with other field name */
    public String f720a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f721a;

    /* renamed from: b, reason: collision with other field name */
    public String f724b;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f716a = new Cif("XmPushActionContainer");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13088a = new hx("", (byte) 8, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13089b = new hx("", (byte) 2, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13090c = new hx("", (byte) 2, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13091d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13092e = new hx("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13093f = new hx("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final hx f13094g = new hx("", (byte) 12, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final hx f13095h = new hx("", (byte) 12, 8);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f722a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f723a = true;

    /* renamed from: b, reason: collision with other field name */
    public boolean f725b = true;

    public gf a() {
        return this.f717a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m537b() {
        return this.f723a;
    }

    public boolean c() {
        return this.f722a.get(0);
    }

    public boolean d() {
        return this.f722a.get(1);
    }

    public boolean e() {
        return this.f721a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hb)) {
            return m534a((hb) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f720a != null;
    }

    public boolean g() {
        return this.f724b != null;
    }

    public boolean h() {
        return this.f719a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f718a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        gf gfVar = this.f717a;
        if (gfVar == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(gfVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f723a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f725b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f720a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f724b;
            if (str2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        gu guVar = this.f719a;
        if (guVar == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(guVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gs gsVar = this.f718a;
            if (gsVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(gsVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hb a(gf gfVar) {
        this.f717a = gfVar;
        return this;
    }

    public hb b(boolean z) {
        this.f725b = z;
        m536b(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m533a() {
        return this.f717a != null;
    }

    public hb a(boolean z) {
        this.f723a = z;
        m532a(true);
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m536b(boolean z) {
        this.f722a.set(1, z);
    }

    public String b() {
        return this.f724b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m532a(boolean z) {
        this.f722a.set(0, z);
    }

    public hb b(String str) {
        this.f724b = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m535a() {
        a(hr.a(this.f721a));
        return this.f721a.array();
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m531a();
        iaVar.a(f716a);
        if (this.f717a != null) {
            iaVar.a(f13088a);
            iaVar.mo612a(this.f717a.a());
            iaVar.b();
        }
        iaVar.a(f13089b);
        iaVar.a(this.f723a);
        iaVar.b();
        iaVar.a(f13090c);
        iaVar.a(this.f725b);
        iaVar.b();
        if (this.f721a != null) {
            iaVar.a(f13091d);
            iaVar.a(this.f721a);
            iaVar.b();
        }
        if (this.f720a != null && f()) {
            iaVar.a(f13092e);
            iaVar.a(this.f720a);
            iaVar.b();
        }
        if (this.f724b != null && g()) {
            iaVar.a(f13093f);
            iaVar.a(this.f724b);
            iaVar.b();
        }
        if (this.f719a != null) {
            iaVar.a(f13094g);
            this.f719a.b(iaVar);
            iaVar.b();
        }
        if (this.f718a != null && i()) {
            iaVar.a(f13095h);
            this.f718a.b(iaVar);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public hb a(ByteBuffer byteBuffer) {
        this.f721a = byteBuffer;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m530a() {
        return this.f720a;
    }

    public hb a(String str) {
        this.f720a = str;
        return this;
    }

    public hb a(gu guVar) {
        this.f719a = guVar;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public gs m529a() {
        return this.f718a;
    }

    public hb a(gs gsVar) {
        this.f718a = gsVar;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m534a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        boolean zM533a = m533a();
        boolean zM533a2 = hbVar.m533a();
        if (((zM533a || zM533a2) && (!zM533a || !zM533a2 || !this.f717a.equals(hbVar.f717a))) || this.f723a != hbVar.f723a || this.f725b != hbVar.f725b) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hbVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f721a.equals(hbVar.f721a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hbVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f720a.equals(hbVar.f720a))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hbVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f724b.equals(hbVar.f724b))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hbVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f719a.m507a(hbVar.f719a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hbVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f718a.m499a(hbVar.f718a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hb hbVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!hb.class.equals(hbVar.getClass())) {
            return hb.class.getName().compareTo(hbVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m533a()).compareTo(Boolean.valueOf(hbVar.m533a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m533a() && (iA8 = hr.a(this.f717a, hbVar.f717a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hbVar.c()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (c() && (iA7 = hr.a(this.f723a, hbVar.f723a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hbVar.d()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (d() && (iA6 = hr.a(this.f725b, hbVar.f725b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hbVar.e()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (e() && (iA5 = hr.a(this.f721a, hbVar.f721a)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hbVar.f()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (f() && (iA4 = hr.a(this.f720a, hbVar.f720a)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hbVar.g()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (g() && (iA3 = hr.a(this.f724b, hbVar.f724b)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hbVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (h() && (iA2 = hr.a(this.f719a, hbVar.f719a)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hbVar.i()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!i() || (iA = hr.a(this.f718a, hbVar.f718a)) == 0) {
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
                if (c()) {
                    if (d()) {
                        m531a();
                        return;
                    }
                    throw new ib("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                throw new ib("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo603a.f898a) {
                case 1:
                    if (b2 == 8) {
                        this.f717a = gf.a(iaVar.mo601a());
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 2) {
                        this.f723a = iaVar.mo613a();
                        m532a(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 2) {
                        this.f725b = iaVar.mo613a();
                        m536b(true);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f721a = iaVar.mo609a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f720a = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f724b = iaVar.mo608a();
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 12) {
                        this.f719a = new gu();
                        this.f719a.a(iaVar);
                        break;
                    } else {
                        id.a(iaVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        this.f718a = new gs();
                        this.f718a.a(iaVar);
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
    public void m531a() throws ib {
        if (this.f717a != null) {
            if (this.f721a != null) {
                if (this.f719a != null) {
                    return;
                }
                throw new ib("Required field 'target' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'pushAction' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'action' was not present! Struct: " + toString());
    }
}
