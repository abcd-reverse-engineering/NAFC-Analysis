package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gx implements hq<gx, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f687a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f688a = new BitSet(2);

    /* renamed from: b, reason: collision with other field name */
    public int f689b;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f686a = new Cif("XmPushActionCheckClientInfo");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13064a = new hx("", (byte) 8, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13065b = new hx("", (byte) 8, 2);

    public gx a(int i2) {
        this.f687a = i2;
        a(true);
        return this;
    }

    public void a() {
    }

    public gx b(int i2) {
        this.f689b = i2;
        b(true);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gx)) {
            return m516a((gx) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f687a + ", pluginConfigVersion:" + this.f689b + ")";
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m515a() {
        return this.f688a.get(0);
    }

    public boolean b() {
        return this.f688a.get(1);
    }

    public void a(boolean z) {
        this.f688a.set(0, z);
    }

    public void b(boolean z) {
        this.f688a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m516a(gx gxVar) {
        return gxVar != null && this.f687a == gxVar.f687a && this.f689b == gxVar.f689b;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f686a);
        iaVar.a(f13064a);
        iaVar.mo612a(this.f687a);
        iaVar.b();
        iaVar.a(f13065b);
        iaVar.mo612a(this.f689b);
        iaVar.b();
        iaVar.c();
        iaVar.mo611a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gx gxVar) {
        int iA;
        int iA2;
        if (!gx.class.equals(gxVar.getClass())) {
            return gx.class.getName().compareTo(gxVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m515a()).compareTo(Boolean.valueOf(gxVar.m515a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m515a() && (iA2 = hr.a(this.f687a, gxVar.f687a)) != 0) {
            return iA2;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gxVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (!b() || (iA = hr.a(this.f689b, gxVar.f689b)) == 0) {
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
                break;
            }
            short s = hxVarMo603a.f898a;
            if (s != 1) {
                if (s != 2) {
                    id.a(iaVar, b2);
                } else if (b2 == 8) {
                    this.f689b = iaVar.mo601a();
                    b(true);
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 8) {
                this.f687a = iaVar.mo601a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m515a()) {
            if (b()) {
                a();
                return;
            }
            throw new ib("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        throw new ib("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
    }
}
