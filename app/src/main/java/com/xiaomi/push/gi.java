package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class gi implements hq<gi, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<gj> f566a;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f565a = new Cif("ClientUploadData");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f12949a = new hx("", com.umeng.analytics.pro.cw.f10303m, 1);

    public int a() {
        List<gj> list = this.f566a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m460a();
        iaVar.a(f565a);
        if (this.f566a != null) {
            iaVar.a(f12949a);
            iaVar.a(new hy((byte) 12, this.f566a.size()));
            Iterator<gj> it = this.f566a.iterator();
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
        if (obj != null && (obj instanceof gi)) {
            return m462a((gi) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<gj> list = this.f566a;
        if (list == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(gj gjVar) {
        if (this.f566a == null) {
            this.f566a = new ArrayList();
        }
        this.f566a.add(gjVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m461a() {
        return this.f566a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m462a(gi giVar) {
        if (giVar == null) {
            return false;
        }
        boolean zM461a = m461a();
        boolean zM461a2 = giVar.m461a();
        if (zM461a || zM461a2) {
            return zM461a && zM461a2 && this.f566a.equals(giVar.f566a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gi giVar) {
        int iA;
        if (!gi.class.equals(giVar.getClass())) {
            return gi.class.getName().compareTo(giVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m461a()).compareTo(Boolean.valueOf(giVar.m461a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m461a() || (iA = hr.a(this.f566a, giVar.f566a)) == 0) {
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
                m460a();
                return;
            }
            if (hxVarMo603a.f898a != 1) {
                id.a(iaVar, b2);
            } else if (b2 == 15) {
                hy hyVarMo604a = iaVar.mo604a();
                this.f566a = new ArrayList(hyVarMo604a.f899a);
                for (int i2 = 0; i2 < hyVarMo604a.f899a; i2++) {
                    gj gjVar = new gj();
                    gjVar.a(iaVar);
                    this.f566a.add(gjVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m460a() throws ib {
        if (this.f566a != null) {
            return;
        }
        throw new ib("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }
}
