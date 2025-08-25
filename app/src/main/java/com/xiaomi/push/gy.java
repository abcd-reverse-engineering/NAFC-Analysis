package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class gy implements hq<gy, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<gn> f691a;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f690a = new Cif("XmPushActionCollectData");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13066a = new hx("", com.umeng.analytics.pro.cw.f10303m, 1);

    public gy a(List<gn> list) {
        this.f691a = list;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f690a);
        if (this.f691a != null) {
            iaVar.a(f13066a);
            iaVar.a(new hy((byte) 12, this.f691a.size()));
            Iterator<gn> it = this.f691a.iterator();
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
        if (obj != null && (obj instanceof gy)) {
            return m518a((gy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<gn> list = this.f691a;
        if (list == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m517a() {
        return this.f691a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m518a(gy gyVar) {
        if (gyVar == null) {
            return false;
        }
        boolean zM517a = m517a();
        boolean zM517a2 = gyVar.m517a();
        if (zM517a || zM517a2) {
            return zM517a && zM517a2 && this.f691a.equals(gyVar.f691a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gy gyVar) {
        int iA;
        if (!gy.class.equals(gyVar.getClass())) {
            return gy.class.getName().compareTo(gyVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m517a()).compareTo(Boolean.valueOf(gyVar.m517a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m517a() || (iA = hr.a(this.f691a, gyVar.f691a)) == 0) {
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
            if (hxVarMo603a.f898a != 1) {
                id.a(iaVar, b2);
            } else if (b2 == 15) {
                hy hyVarMo604a = iaVar.mo604a();
                this.f691a = new ArrayList(hyVarMo604a.f899a);
                for (int i2 = 0; i2 < hyVarMo604a.f899a; i2++) {
                    gn gnVar = new gn();
                    gnVar.a(iaVar);
                    this.f691a.add(gnVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f691a != null) {
            return;
        }
        throw new ib("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }
}
