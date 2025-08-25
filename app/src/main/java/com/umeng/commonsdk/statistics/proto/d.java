package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cp;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cs;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cx;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.cz;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Imprint.java */
/* loaded from: classes2.dex */
public class d implements bq<d, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, cc> f11035d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f11036e = 2846460275012375038L;

    /* renamed from: f, reason: collision with root package name */
    private static final cu f11037f = new cu("Imprint");

    /* renamed from: g, reason: collision with root package name */
    private static final ck f11038g = new ck("property", cw.f10301k, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ck f11039h = new ck("version", (byte) 8, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final ck f11040i = new ck("checksum", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cx>, cy> f11041j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private static final int f11042k = 0;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f11043a;

    /* renamed from: b, reason: collision with root package name */
    public int f11044b;

    /* renamed from: c, reason: collision with root package name */
    public String f11045c;

    /* renamed from: l, reason: collision with root package name */
    private byte f11046l;

    /* compiled from: Imprint.java */
    private static class a extends cz<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, d dVar) throws bw {
            cpVar.j();
            while (true) {
                ck ckVarL = cpVar.l();
                byte b2 = ckVarL.f10264b;
                if (b2 == 0) {
                    break;
                }
                short s = ckVarL.f10265c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, b2);
                        } else if (b2 == 11) {
                            dVar.f11045c = cpVar.z();
                            dVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 8) {
                        dVar.f11044b = cpVar.w();
                        dVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 13) {
                    cm cmVarN = cpVar.n();
                    dVar.f11043a = new HashMap(cmVarN.f10270c * 2);
                    for (int i2 = 0; i2 < cmVarN.f10270c; i2++) {
                        String strZ = cpVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(cpVar);
                        dVar.f11043a.put(strZ, eVar);
                    }
                    cpVar.o();
                    dVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
            cpVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new cq("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, d dVar) throws bw {
            dVar.l();
            cpVar.a(d.f11037f);
            if (dVar.f11043a != null) {
                cpVar.a(d.f11038g);
                cpVar.a(new cm((byte) 11, (byte) 12, dVar.f11043a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f11043a.entrySet()) {
                    cpVar.a(entry.getKey());
                    entry.getValue().write(cpVar);
                }
                cpVar.e();
                cpVar.c();
            }
            cpVar.a(d.f11039h);
            cpVar.a(dVar.f11044b);
            cpVar.c();
            if (dVar.f11045c != null) {
                cpVar.a(d.f11040i);
                cpVar.a(dVar.f11045c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* compiled from: Imprint.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: Imprint.java */
    private static class c extends da<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, d dVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(dVar.f11043a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f11043a.entrySet()) {
                cvVar.a(entry.getKey());
                entry.getValue().write(cvVar);
            }
            cvVar.a(dVar.f11044b);
            cvVar.a(dVar.f11045c);
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, d dVar) throws bw {
            cv cvVar = (cv) cpVar;
            cm cmVar = new cm((byte) 11, (byte) 12, cvVar.w());
            dVar.f11043a = new HashMap(cmVar.f10270c * 2);
            for (int i2 = 0; i2 < cmVar.f10270c; i2++) {
                String strZ = cvVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(cvVar);
                dVar.f11043a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.f11044b = cvVar.w();
            dVar.b(true);
            dVar.f11045c = cvVar.z();
            dVar.c(true);
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    private static class C0148d implements cy {
        private C0148d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f11041j.put(cz.class, new b());
        f11041j.put(da.class, new C0148d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new cc("property", (byte) 1, new cf(cw.f10301k, new cd((byte) 11), new ch((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new cc("version", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cc("checksum", (byte) 1, new cd((byte) 11)));
        f11035d = Collections.unmodifiableMap(enumMap);
        cc.a(d.class, f11035d);
    }

    public d() {
        this.f11046l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f11043a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f11043a;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f11043a = null;
        b(false);
        this.f11044b = 0;
        this.f11045c = null;
    }

    public void d() {
        this.f11043a = null;
    }

    public boolean e() {
        return this.f11043a != null;
    }

    public int f() {
        return this.f11044b;
    }

    public void g() {
        this.f11046l = bn.b(this.f11046l, 0);
    }

    public boolean h() {
        return bn.a(this.f11046l, 0);
    }

    public String i() {
        return this.f11045c;
    }

    public void j() {
        this.f11045c = null;
    }

    public boolean k() {
        return this.f11045c != null;
    }

    public void l() throws bw {
        if (this.f11043a == null) {
            throw new cq("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f11045c != null) {
            return;
        }
        throw new cq("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f11041j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f11043a;
        if (map == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f11044b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f11045c;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f11041j.get(cpVar.D()).b().a(cpVar, this);
    }

    /* compiled from: Imprint.java */
    public enum e implements bx {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f11050d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11052e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11053f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11050d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f11052e = s;
            this.f11053f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return PROPERTY;
            }
            if (i2 == 2) {
                return VERSION;
            }
            if (i2 != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static e b(int i2) {
            e eVarA = a(i2);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bx
        public String b() {
            return this.f11053f;
        }

        public static e a(String str) {
            return f11050d.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f11052e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f11043a == null) {
            this.f11043a = new HashMap();
        }
        this.f11043a.put(str, eVar);
    }

    public void b(boolean z) {
        this.f11046l = bn.a(this.f11046l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f11045c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.f11043a = map;
        this.f11044b = i2;
        b(true);
        this.f11045c = str;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f11043a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f11043a = null;
    }

    public d a(int i2) {
        this.f11044b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f11046l = (byte) 0;
        this.f11046l = dVar.f11046l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f11043a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f11043a = map;
        }
        this.f11044b = dVar.f11044b;
        if (dVar.k()) {
            this.f11045c = dVar.f11045c;
        }
    }

    public d a(String str) {
        this.f11045c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cj(new db(objectOutputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f11046l = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
