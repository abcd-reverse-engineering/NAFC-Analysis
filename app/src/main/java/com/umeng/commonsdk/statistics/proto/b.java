package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cp;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cs;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
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

/* compiled from: IdSnapshot.java */
/* loaded from: classes2.dex */
public class b implements bq<b, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, cc> f10997d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f10998e = -6496538196005191531L;

    /* renamed from: f, reason: collision with root package name */
    private static final cu f10999f = new cu("IdSnapshot");

    /* renamed from: g, reason: collision with root package name */
    private static final ck f11000g = new ck("identity", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ck f11001h = new ck("ts", (byte) 10, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final ck f11002i = new ck("version", (byte) 8, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cx>, cy> f11003j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private static final int f11004k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f11005l = 1;

    /* renamed from: a, reason: collision with root package name */
    public String f11006a;

    /* renamed from: b, reason: collision with root package name */
    public long f11007b;

    /* renamed from: c, reason: collision with root package name */
    public int f11008c;

    /* renamed from: m, reason: collision with root package name */
    private byte f11009m;

    /* compiled from: IdSnapshot.java */
    private static class a extends cz<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, b bVar) throws bw {
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
                        } else if (b2 == 8) {
                            bVar.f11008c = cpVar.w();
                            bVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 10) {
                        bVar.f11007b = cpVar.x();
                        bVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 11) {
                    bVar.f11006a = cpVar.z();
                    bVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
            cpVar.k();
            if (!bVar.g()) {
                throw new cq("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new cq("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, b bVar) throws bw {
            bVar.k();
            cpVar.a(b.f10999f);
            if (bVar.f11006a != null) {
                cpVar.a(b.f11000g);
                cpVar.a(bVar.f11006a);
                cpVar.c();
            }
            cpVar.a(b.f11001h);
            cpVar.a(bVar.f11007b);
            cpVar.c();
            cpVar.a(b.f11002i);
            cpVar.a(bVar.f11008c);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    private static class C0146b implements cy {
        private C0146b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: IdSnapshot.java */
    private static class c extends da<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, b bVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(bVar.f11006a);
            cvVar.a(bVar.f11007b);
            cvVar.a(bVar.f11008c);
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, b bVar) throws bw {
            cv cvVar = (cv) cpVar;
            bVar.f11006a = cvVar.z();
            bVar.a(true);
            bVar.f11007b = cvVar.x();
            bVar.b(true);
            bVar.f11008c = cvVar.w();
            bVar.c(true);
        }
    }

    /* compiled from: IdSnapshot.java */
    private static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f11003j.put(cz.class, new C0146b());
        f11003j.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new cc("identity", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new cc("ts", (byte) 1, new cd((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new cc("version", (byte) 1, new cd((byte) 8)));
        f10997d = Collections.unmodifiableMap(enumMap);
        cc.a(b.class, f10997d);
    }

    public b() {
        this.f11009m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f11006a;
    }

    public void c() {
        this.f11006a = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f11006a = null;
        b(false);
        this.f11007b = 0L;
        c(false);
        this.f11008c = 0;
    }

    public boolean d() {
        return this.f11006a != null;
    }

    public long e() {
        return this.f11007b;
    }

    public void f() {
        this.f11009m = bn.b(this.f11009m, 0);
    }

    public boolean g() {
        return bn.a(this.f11009m, 0);
    }

    public int h() {
        return this.f11008c;
    }

    public void i() {
        this.f11009m = bn.b(this.f11009m, 1);
    }

    public boolean j() {
        return bn.a(this.f11009m, 1);
    }

    public void k() throws bw {
        if (this.f11006a != null) {
            return;
        }
        throw new cq("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f11003j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f11006a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f11007b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f11008c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f11003j.get(cpVar.D()).b().a(cpVar, this);
    }

    /* compiled from: IdSnapshot.java */
    public enum e implements bx {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f11013d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11015e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11016f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11013d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f11015e = s;
            this.f11016f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return IDENTITY;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return VERSION;
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
            return this.f11016f;
        }

        public static e a(String str) {
            return f11013d.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f11015e;
        }
    }

    public b a(String str) {
        this.f11006a = str;
        return this;
    }

    public void b(boolean z) {
        this.f11009m = bn.a(this.f11009m, 0, z);
    }

    public void c(boolean z) {
        this.f11009m = bn.a(this.f11009m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.f11006a = str;
        this.f11007b = j2;
        b(true);
        this.f11008c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f11006a = null;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.f11007b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f11008c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cj(new db(objectOutputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.f11009m = (byte) 0;
        this.f11009m = bVar.f11009m;
        if (bVar.d()) {
            this.f11006a = bVar.f11006a;
        }
        this.f11007b = bVar.f11007b;
        this.f11008c = bVar.f11008c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f11009m = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
