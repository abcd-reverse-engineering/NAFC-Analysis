package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gu implements hq<gu, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public String f646a;

    /* renamed from: d, reason: collision with other field name */
    public String f651d;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f644a = new Cif("Target");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13035a = new hx("", (byte) 10, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13036b = new hx("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13037c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13038d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13039e = new hx("", (byte) 2, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13040f = new hx("", (byte) 11, 7);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f647a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public long f645a = 5;

    /* renamed from: b, reason: collision with other field name */
    public String f649b = "xiaomi.com";

    /* renamed from: c, reason: collision with other field name */
    public String f650c = "";

    /* renamed from: a, reason: collision with other field name */
    public boolean f648a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m506a() {
        return this.f647a.get(0);
    }

    public boolean b() {
        return this.f646a != null;
    }

    public boolean c() {
        return this.f649b != null;
    }

    public boolean d() {
        return this.f650c != null;
    }

    public boolean e() {
        return this.f647a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gu)) {
            return m507a((gu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f651d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f645a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f646a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f649b;
            if (str2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f650c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f648a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f651d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f647a.set(0, z);
    }

    public void b(boolean z) {
        this.f647a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m507a(gu guVar) {
        if (guVar == null || this.f645a != guVar.f645a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = guVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f646a.equals(guVar.f646a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = guVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f649b.equals(guVar.f649b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = guVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f650c.equals(guVar.f650c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = guVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f648a == guVar.f648a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = guVar.f();
        if (zF || zF2) {
            return zF && zF2 && this.f651d.equals(guVar.f651d);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f644a);
        iaVar.a(f13035a);
        iaVar.a(this.f645a);
        iaVar.b();
        if (this.f646a != null) {
            iaVar.a(f13036b);
            iaVar.a(this.f646a);
            iaVar.b();
        }
        if (this.f649b != null && c()) {
            iaVar.a(f13037c);
            iaVar.a(this.f649b);
            iaVar.b();
        }
        if (this.f650c != null && d()) {
            iaVar.a(f13038d);
            iaVar.a(this.f650c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f13039e);
            iaVar.a(this.f648a);
            iaVar.b();
        }
        if (this.f651d != null && f()) {
            iaVar.a(f13040f);
            iaVar.a(this.f651d);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gu guVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        if (!gu.class.equals(guVar.getClass())) {
            return gu.class.getName().compareTo(guVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m506a()).compareTo(Boolean.valueOf(guVar.m506a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m506a() && (iA6 = hr.a(this.f645a, guVar.f645a)) != 0) {
            return iA6;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(guVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA5 = hr.a(this.f646a, guVar.f646a)) != 0) {
            return iA5;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(guVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA4 = hr.a(this.f649b, guVar.f649b)) != 0) {
            return iA4;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(guVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA3 = hr.a(this.f650c, guVar.f650c)) != 0) {
            return iA3;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(guVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA2 = hr.a(this.f648a, guVar.f648a)) != 0) {
            return iA2;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(guVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (!f() || (iA = hr.a(this.f651d, guVar.f651d)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) {
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
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s != 7) {
                                    id.a(iaVar, b2);
                                } else if (b2 == 11) {
                                    this.f651d = iaVar.mo608a();
                                } else {
                                    id.a(iaVar, b2);
                                }
                            } else if (b2 == 2) {
                                this.f648a = iaVar.mo613a();
                                b(true);
                            } else {
                                id.a(iaVar, b2);
                            }
                        } else if (b2 == 11) {
                            this.f650c = iaVar.mo608a();
                        } else {
                            id.a(iaVar, b2);
                        }
                    } else if (b2 == 11) {
                        this.f649b = iaVar.mo608a();
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f646a = iaVar.mo608a();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 10) {
                this.f645a = iaVar.mo602a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m506a()) {
            a();
            return;
        }
        throw new ib("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a() throws ib {
        if (this.f646a != null) {
            return;
        }
        throw new ib("Required field 'userId' was not present! Struct: " + toString());
    }
}
