package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: IdTracking.java */
/* loaded from: classes2.dex */
public class c implements bq<c, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, cc> f11017d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f11018e = -5764118265293965743L;

    /* renamed from: f, reason: collision with root package name */
    private static final cu f11019f = new cu("IdTracking");

    /* renamed from: g, reason: collision with root package name */
    private static final ck f11020g = new ck("snapshots", cw.f10301k, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ck f11021h = new ck("journals", cw.f10303m, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final ck f11022i = new ck("checksum", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cx>, cy> f11023j = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f11024a;

    /* renamed from: b, reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f11025b;

    /* renamed from: c, reason: collision with root package name */
    public String f11026c;

    /* renamed from: k, reason: collision with root package name */
    private e[] f11027k;

    /* compiled from: IdTracking.java */
    private static class a extends cz<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, c cVar) throws bw {
            cpVar.j();
            while (true) {
                ck ckVarL = cpVar.l();
                byte b2 = ckVarL.f10264b;
                if (b2 == 0) {
                    cpVar.k();
                    cVar.n();
                    return;
                }
                short s = ckVarL.f10265c;
                int i2 = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, b2);
                        } else if (b2 == 11) {
                            cVar.f11026c = cpVar.z();
                            cVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 15) {
                        cl clVarP = cpVar.p();
                        cVar.f11025b = new ArrayList(clVarP.f10267b);
                        while (i2 < clVarP.f10267b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(cpVar);
                            cVar.f11025b.add(aVar);
                            i2++;
                        }
                        cpVar.q();
                        cVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 13) {
                    cm cmVarN = cpVar.n();
                    cVar.f11024a = new HashMap(cmVarN.f10270c * 2);
                    while (i2 < cmVarN.f10270c) {
                        String strZ = cpVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(cpVar);
                        cVar.f11024a.put(strZ, bVar);
                        i2++;
                    }
                    cpVar.o();
                    cVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, c cVar) throws bw {
            cVar.n();
            cpVar.a(c.f11019f);
            if (cVar.f11024a != null) {
                cpVar.a(c.f11020g);
                cpVar.a(new cm((byte) 11, (byte) 12, cVar.f11024a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f11024a.entrySet()) {
                    cpVar.a(entry.getKey());
                    entry.getValue().write(cpVar);
                }
                cpVar.e();
                cpVar.c();
            }
            if (cVar.f11025b != null && cVar.j()) {
                cpVar.a(c.f11021h);
                cpVar.a(new cl((byte) 12, cVar.f11025b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f11025b.iterator();
                while (it.hasNext()) {
                    it.next().write(cpVar);
                }
                cpVar.f();
                cpVar.c();
            }
            if (cVar.f11026c != null && cVar.m()) {
                cpVar.a(c.f11022i);
                cpVar.a(cVar.f11026c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* compiled from: IdTracking.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    private static class C0147c extends da<c> {
        private C0147c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, c cVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(cVar.f11024a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f11024a.entrySet()) {
                cvVar.a(entry.getKey());
                entry.getValue().write(cvVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            cvVar.a(bitSet, 2);
            if (cVar.j()) {
                cvVar.a(cVar.f11025b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f11025b.iterator();
                while (it.hasNext()) {
                    it.next().write(cvVar);
                }
            }
            if (cVar.m()) {
                cvVar.a(cVar.f11026c);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, c cVar) throws bw {
            cv cvVar = (cv) cpVar;
            cm cmVar = new cm((byte) 11, (byte) 12, cvVar.w());
            cVar.f11024a = new HashMap(cmVar.f10270c * 2);
            for (int i2 = 0; i2 < cmVar.f10270c; i2++) {
                String strZ = cvVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(cvVar);
                cVar.f11024a.put(strZ, bVar);
            }
            cVar.a(true);
            BitSet bitSetB = cvVar.b(2);
            if (bitSetB.get(0)) {
                cl clVar = new cl((byte) 12, cvVar.w());
                cVar.f11025b = new ArrayList(clVar.f10267b);
                for (int i3 = 0; i3 < clVar.f10267b; i3++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(cvVar);
                    cVar.f11025b.add(aVar);
                }
                cVar.b(true);
            }
            if (bitSetB.get(1)) {
                cVar.f11026c = cvVar.z();
                cVar.c(true);
            }
        }
    }

    /* compiled from: IdTracking.java */
    private static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0147c b() {
            return new C0147c();
        }
    }

    static {
        f11023j.put(cz.class, new b());
        f11023j.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new cc("snapshots", (byte) 1, new cf(cw.f10301k, new cd((byte) 11), new ch((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new cc("journals", (byte) 2, new ce(cw.f10303m, new ch((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cc("checksum", (byte) 2, new cd((byte) 11)));
        f11017d = Collections.unmodifiableMap(enumMap);
        cc.a(c.class, f11017d);
    }

    public c() {
        this.f11027k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f11024a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f11024a;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f11024a = null;
        this.f11025b = null;
        this.f11026c = null;
    }

    public void d() {
        this.f11024a = null;
    }

    public boolean e() {
        return this.f11024a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f11025b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f11025b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f11025b;
    }

    public void i() {
        this.f11025b = null;
    }

    public boolean j() {
        return this.f11025b != null;
    }

    public String k() {
        return this.f11026c;
    }

    public void l() {
        this.f11026c = null;
    }

    public boolean m() {
        return this.f11026c != null;
    }

    public void n() throws bw {
        if (this.f11024a != null) {
            return;
        }
        throw new cq("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f11023j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f11024a;
        if (map == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f11025b;
            if (list == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f11026c;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f11023j.get(cpVar.D()).b().a(cpVar, this);
    }

    /* compiled from: IdTracking.java */
    public enum e implements bx {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f11031d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11033e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11034f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11031d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f11033e = s;
            this.f11034f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return SNAPSHOTS;
            }
            if (i2 == 2) {
                return JOURNALS;
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
            return this.f11034f;
        }

        public static e a(String str) {
            return f11031d.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f11033e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f11024a == null) {
            this.f11024a = new HashMap();
        }
        this.f11024a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f11025b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f11026c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f11024a = map;
    }

    public c(c cVar) {
        this.f11027k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f11024a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f11024a = map;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f11025b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f11025b = arrayList;
        }
        if (cVar.m()) {
            this.f11026c = cVar.f11026c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f11024a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f11024a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f11025b == null) {
            this.f11025b = new ArrayList();
        }
        this.f11025b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f11025b = list;
        return this;
    }

    public c a(String str) {
        this.f11026c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
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
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
