package com.umeng.commonsdk.statistics.proto;

import bean.SurveyH5Bean;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cp;
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

/* compiled from: ImprintValue.java */
/* loaded from: classes2.dex */
public class e implements bq<e, EnumC0149e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<EnumC0149e, cc> f11054d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f11055e = 7501688097813630241L;

    /* renamed from: f, reason: collision with root package name */
    private static final cu f11056f = new cu("ImprintValue");

    /* renamed from: g, reason: collision with root package name */
    private static final ck f11057g = new ck(SurveyH5Bean.VALUE, (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ck f11058h = new ck("ts", (byte) 10, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final ck f11059i = new ck("guid", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cx>, cy> f11060j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private static final int f11061k = 0;

    /* renamed from: a, reason: collision with root package name */
    public String f11062a;

    /* renamed from: b, reason: collision with root package name */
    public long f11063b;

    /* renamed from: c, reason: collision with root package name */
    public String f11064c;

    /* renamed from: l, reason: collision with root package name */
    private byte f11065l;

    /* renamed from: m, reason: collision with root package name */
    private EnumC0149e[] f11066m;

    /* compiled from: ImprintValue.java */
    private static class a extends cz<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, e eVar) throws bw {
            cpVar.j();
            while (true) {
                ck ckVarL = cpVar.l();
                byte b2 = ckVarL.f10264b;
                if (b2 == 0) {
                    cpVar.k();
                    eVar.k();
                    return;
                }
                short s = ckVarL.f10265c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, b2);
                        } else if (b2 == 11) {
                            eVar.f11064c = cpVar.z();
                            eVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 10) {
                        eVar.f11063b = cpVar.x();
                        eVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 11) {
                    eVar.f11062a = cpVar.z();
                    eVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, e eVar) throws bw {
            eVar.k();
            cpVar.a(e.f11056f);
            if (eVar.f11062a != null && eVar.d()) {
                cpVar.a(e.f11057g);
                cpVar.a(eVar.f11062a);
                cpVar.c();
            }
            if (eVar.g()) {
                cpVar.a(e.f11058h);
                cpVar.a(eVar.f11063b);
                cpVar.c();
            }
            if (eVar.f11064c != null && eVar.j()) {
                cpVar.a(e.f11059i);
                cpVar.a(eVar.f11064c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* compiled from: ImprintValue.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: ImprintValue.java */
    private static class c extends da<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, e eVar) throws bw {
            cv cvVar = (cv) cpVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            cvVar.a(bitSet, 3);
            if (eVar.d()) {
                cvVar.a(eVar.f11062a);
            }
            if (eVar.g()) {
                cvVar.a(eVar.f11063b);
            }
            if (eVar.j()) {
                cvVar.a(eVar.f11064c);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, e eVar) throws bw {
            cv cvVar = (cv) cpVar;
            BitSet bitSetB = cvVar.b(3);
            if (bitSetB.get(0)) {
                eVar.f11062a = cvVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.f11063b = cvVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.f11064c = cvVar.z();
                eVar.c(true);
            }
        }
    }

    /* compiled from: ImprintValue.java */
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
        f11060j.put(cz.class, new b());
        f11060j.put(da.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0149e.class);
        enumMap.put((EnumMap) EnumC0149e.VALUE, (EnumC0149e) new cc(SurveyH5Bean.VALUE, (byte) 2, new cd((byte) 11)));
        enumMap.put((EnumMap) EnumC0149e.TS, (EnumC0149e) new cc("ts", (byte) 2, new cd((byte) 10)));
        enumMap.put((EnumMap) EnumC0149e.GUID, (EnumC0149e) new cc("guid", (byte) 2, new cd((byte) 11)));
        f11054d = Collections.unmodifiableMap(enumMap);
        cc.a(e.class, f11054d);
    }

    public e() {
        this.f11065l = (byte) 0;
        this.f11066m = new EnumC0149e[]{EnumC0149e.VALUE, EnumC0149e.TS, EnumC0149e.GUID};
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f11062a;
    }

    public void c() {
        this.f11062a = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f11062a = null;
        b(false);
        this.f11063b = 0L;
        this.f11064c = null;
    }

    public boolean d() {
        return this.f11062a != null;
    }

    public long e() {
        return this.f11063b;
    }

    public void f() {
        this.f11065l = bn.b(this.f11065l, 0);
    }

    public boolean g() {
        return bn.a(this.f11065l, 0);
    }

    public String h() {
        return this.f11064c;
    }

    public void i() {
        this.f11064c = null;
    }

    public boolean j() {
        return this.f11064c != null;
    }

    public void k() throws bw {
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f11060j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f11062a;
            if (str == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f11063b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f11064c;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f11060j.get(cpVar.D()).b().a(cpVar, this);
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    public enum EnumC0149e implements bx {
        VALUE(1, SurveyH5Bean.VALUE),
        TS(2, "ts"),
        GUID(3, "guid");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, EnumC0149e> f11070d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11072e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11073f;

        static {
            Iterator it = EnumSet.allOf(EnumC0149e.class).iterator();
            while (it.hasNext()) {
                EnumC0149e enumC0149e = (EnumC0149e) it.next();
                f11070d.put(enumC0149e.b(), enumC0149e);
            }
        }

        EnumC0149e(short s, String str) {
            this.f11072e = s;
            this.f11073f = str;
        }

        public static EnumC0149e a(int i2) {
            if (i2 == 1) {
                return VALUE;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0149e b(int i2) {
            EnumC0149e enumC0149eA = a(i2);
            if (enumC0149eA != null) {
                return enumC0149eA;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bx
        public String b() {
            return this.f11073f;
        }

        public static EnumC0149e a(String str) {
            return f11070d.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f11072e;
        }
    }

    public e a(String str) {
        this.f11062a = str;
        return this;
    }

    public void b(boolean z) {
        this.f11065l = bn.a(this.f11065l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f11064c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f11062a = null;
    }

    public e b(String str) {
        this.f11064c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.f11063b = j2;
        b(true);
        this.f11064c = str;
    }

    public e a(long j2) {
        this.f11063b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0149e fieldForId(int i2) {
        return EnumC0149e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cj(new db(objectOutputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.f11065l = (byte) 0;
        this.f11066m = new EnumC0149e[]{EnumC0149e.VALUE, EnumC0149e.TS, EnumC0149e.GUID};
        this.f11065l = eVar.f11065l;
        if (eVar.d()) {
            this.f11062a = eVar.f11062a;
        }
        this.f11063b = eVar.f11063b;
        if (eVar.j()) {
            this.f11064c = eVar.f11064c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f11065l = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
