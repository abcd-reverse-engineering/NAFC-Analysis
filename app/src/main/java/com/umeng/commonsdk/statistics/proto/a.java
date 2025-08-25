package com.umeng.commonsdk.statistics.proto;

import anet.channel.strategy.dispatch.DispatchConstants;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdJournal.java */
/* loaded from: classes2.dex */
public class a implements bq<a, e>, Serializable, Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final Map<e, cc> f10976e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f10977f = 9132678615281394583L;

    /* renamed from: g, reason: collision with root package name */
    private static final cu f10978g = new cu("IdJournal");

    /* renamed from: h, reason: collision with root package name */
    private static final ck f10979h = new ck(DispatchConstants.DOMAIN, (byte) 11, 1);

    /* renamed from: i, reason: collision with root package name */
    private static final ck f10980i = new ck("old_id", (byte) 11, 2);

    /* renamed from: j, reason: collision with root package name */
    private static final ck f10981j = new ck("new_id", (byte) 11, 3);

    /* renamed from: k, reason: collision with root package name */
    private static final ck f10982k = new ck("ts", (byte) 10, 4);

    /* renamed from: l, reason: collision with root package name */
    private static final Map<Class<? extends cx>, cy> f10983l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private static final int f10984m = 0;

    /* renamed from: a, reason: collision with root package name */
    public String f10985a;

    /* renamed from: b, reason: collision with root package name */
    public String f10986b;

    /* renamed from: c, reason: collision with root package name */
    public String f10987c;

    /* renamed from: d, reason: collision with root package name */
    public long f10988d;
    private byte n;
    private e[] o;

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    private static class C0145a extends cz<a> {
        private C0145a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, a aVar) throws bw {
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
                            if (s != 4) {
                                cs.a(cpVar, b2);
                            } else if (b2 == 10) {
                                aVar.f10988d = cpVar.x();
                                aVar.d(true);
                            } else {
                                cs.a(cpVar, b2);
                            }
                        } else if (b2 == 11) {
                            aVar.f10987c = cpVar.z();
                            aVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 11) {
                        aVar.f10986b = cpVar.z();
                        aVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 11) {
                    aVar.f10985a = cpVar.z();
                    aVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
            cpVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new cq("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, a aVar) throws bw {
            aVar.n();
            cpVar.a(a.f10978g);
            if (aVar.f10985a != null) {
                cpVar.a(a.f10979h);
                cpVar.a(aVar.f10985a);
                cpVar.c();
            }
            if (aVar.f10986b != null && aVar.g()) {
                cpVar.a(a.f10980i);
                cpVar.a(aVar.f10986b);
                cpVar.c();
            }
            if (aVar.f10987c != null) {
                cpVar.a(a.f10981j);
                cpVar.a(aVar.f10987c);
                cpVar.c();
            }
            cpVar.a(a.f10982k);
            cpVar.a(aVar.f10988d);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* compiled from: IdJournal.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0145a b() {
            return new C0145a();
        }
    }

    /* compiled from: IdJournal.java */
    private static class c extends da<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, a aVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(aVar.f10985a);
            cvVar.a(aVar.f10987c);
            cvVar.a(aVar.f10988d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            cvVar.a(bitSet, 1);
            if (aVar.g()) {
                cvVar.a(aVar.f10986b);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, a aVar) throws bw {
            cv cvVar = (cv) cpVar;
            aVar.f10985a = cvVar.z();
            aVar.a(true);
            aVar.f10987c = cvVar.z();
            aVar.c(true);
            aVar.f10988d = cvVar.x();
            aVar.d(true);
            if (cvVar.b(1).get(0)) {
                aVar.f10986b = cvVar.z();
                aVar.b(true);
            }
        }
    }

    /* compiled from: IdJournal.java */
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
        f10983l.put(cz.class, new b());
        f10983l.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new cc(DispatchConstants.DOMAIN, (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new cc("old_id", (byte) 2, new cd((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new cc("new_id", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new cc("ts", (byte) 1, new cd((byte) 10)));
        f10976e = Collections.unmodifiableMap(enumMap);
        cc.a(a.class, f10976e);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f10985a;
    }

    public void c() {
        this.f10985a = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f10985a = null;
        this.f10986b = null;
        this.f10987c = null;
        d(false);
        this.f10988d = 0L;
    }

    public boolean d() {
        return this.f10985a != null;
    }

    public String e() {
        return this.f10986b;
    }

    public void f() {
        this.f10986b = null;
    }

    public boolean g() {
        return this.f10986b != null;
    }

    public String h() {
        return this.f10987c;
    }

    public void i() {
        this.f10987c = null;
    }

    public boolean j() {
        return this.f10987c != null;
    }

    public long k() {
        return this.f10988d;
    }

    public void l() {
        this.n = bn.b(this.n, 0);
    }

    public boolean m() {
        return bn.a(this.n, 0);
    }

    public void n() throws bw {
        if (this.f10985a == null) {
            throw new cq("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f10987c != null) {
            return;
        }
        throw new cq("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f10983l.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f10985a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f10986b;
            if (str2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f10987c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f10988d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f10983l.get(cpVar.D()).b().a(cpVar, this);
    }

    /* compiled from: IdJournal.java */
    public enum e implements bx {
        DOMAIN(1, DispatchConstants.DOMAIN),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* renamed from: e, reason: collision with root package name */
        private static final Map<String, e> f10993e = new HashMap();

        /* renamed from: f, reason: collision with root package name */
        private final short f10995f;

        /* renamed from: g, reason: collision with root package name */
        private final String f10996g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f10993e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f10995f = s;
            this.f10996g = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return DOMAIN;
            }
            if (i2 == 2) {
                return OLD_ID;
            }
            if (i2 == 3) {
                return NEW_ID;
            }
            if (i2 != 4) {
                return null;
            }
            return TS;
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
            return this.f10996g;
        }

        public static e a(String str) {
            return f10993e.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f10995f;
        }
    }

    public a a(String str) {
        this.f10985a = str;
        return this;
    }

    public a b(String str) {
        this.f10986b = str;
        return this;
    }

    public a c(String str) {
        this.f10987c = str;
        return this;
    }

    public void d(boolean z) {
        this.n = bn.a(this.n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f10985a = null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f10986b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f10987c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.f10985a = str;
        this.f10987c = str2;
        this.f10988d = j2;
        d(true);
    }

    public a a(long j2) {
        this.f10988d = j2;
        d(true);
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

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f10985a = aVar.f10985a;
        }
        if (aVar.g()) {
            this.f10986b = aVar.f10986b;
        }
        if (aVar.j()) {
            this.f10987c = aVar.f10987c;
        }
        this.f10988d = aVar.f10988d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
