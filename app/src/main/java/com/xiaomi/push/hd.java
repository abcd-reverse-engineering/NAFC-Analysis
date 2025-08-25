package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hd implements hq<hd, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<go> f729a;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f728a = new Cif("XmPushActionNormalConfig");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13097a = new hx("", com.umeng.analytics.pro.cw.f10303m, 1);

    public List<go> a() {
        return this.f729a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m541a();
        iaVar.a(f728a);
        if (this.f729a != null) {
            iaVar.a(f13097a);
            iaVar.a(new hy((byte) 12, this.f729a.size()));
            Iterator<go> it = this.f729a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hd)) {
            return m543a((hd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<go> list = this.f729a;
        if (list == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m542a() {
        return this.f729a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m543a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        boolean zM542a = m542a();
        boolean zM542a2 = hdVar.m542a();
        if (zM542a || zM542a2) {
            return zM542a && zM542a2 && this.f729a.equals(hdVar.f729a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hd hdVar) {
        int iA;
        if (!hd.class.equals(hdVar.getClass())) {
            return hd.class.getName().compareTo(hdVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m542a()).compareTo(Boolean.valueOf(hdVar.m542a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m542a() || (iA = hr.a(this.f729a, hdVar.f729a)) == 0) {
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
                m541a();
                return;
            }
            if (hxVarMo603a.f898a != 1) {
                id.a(iaVar, b2);
            } else if (b2 == 15) {
                hy hyVarMo604a = iaVar.mo604a();
                this.f729a = new ArrayList(hyVarMo604a.f899a);
                for (int i2 = 0; i2 < hyVarMo604a.f899a; i2++) {
                    go goVar = new go();
                    goVar.a(iaVar);
                    this.f729a.add(goVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m541a() throws ib {
        if (this.f729a != null) {
            return;
        }
        throw new ib("Required field 'normalConfigs' was not present! Struct: " + toString());
    }
}
