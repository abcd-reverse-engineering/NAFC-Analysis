package com.umeng.analytics.pro;

import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.open.SocialOperation;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: UMEnvelope.java */
/* loaded from: classes2.dex */
public class bi implements bq<bi, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* renamed from: k, reason: collision with root package name */
    public static final Map<e, cc> f10129k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f10130l = 420342210744516016L;

    /* renamed from: m, reason: collision with root package name */
    private static final cu f10131m = new cu("UMEnvelope");
    private static final ck n = new ck("version", (byte) 11, 1);
    private static final ck o = new ck(UserInfo.ADDRESS, (byte) 11, 2);
    private static final ck p = new ck(SocialOperation.GAME_SIGNATURE, (byte) 11, 3);
    private static final ck q = new ck("serial_num", (byte) 8, 4);
    private static final ck r = new ck("ts_secs", (byte) 8, 5);
    private static final ck s = new ck("length", (byte) 8, 6);
    private static final ck t = new ck("entity", (byte) 11, 7);
    private static final ck u = new ck("guid", (byte) 11, 8);
    private static final ck v = new ck("checksum", (byte) 11, 9);
    private static final ck w = new ck("codex", (byte) 8, 10);
    private static final Map<Class<? extends cx>, cy> x = new HashMap();
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a, reason: collision with root package name */
    public String f10132a;

    /* renamed from: b, reason: collision with root package name */
    public String f10133b;

    /* renamed from: c, reason: collision with root package name */
    public String f10134c;

    /* renamed from: d, reason: collision with root package name */
    public int f10135d;

    /* renamed from: e, reason: collision with root package name */
    public int f10136e;

    /* renamed from: f, reason: collision with root package name */
    public int f10137f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f10138g;

    /* renamed from: h, reason: collision with root package name */
    public String f10139h;

    /* renamed from: i, reason: collision with root package name */
    public String f10140i;

    /* renamed from: j, reason: collision with root package name */
    public int f10141j;

    /* compiled from: UMEnvelope.java */
    private static class a extends cz<bi> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, bi biVar) throws bw {
            cpVar.j();
            while (true) {
                ck ckVarL = cpVar.l();
                byte b2 = ckVarL.f10264b;
                if (b2 == 0) {
                    cpVar.k();
                    if (!biVar.m()) {
                        throw new cq("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!biVar.p()) {
                        throw new cq("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (biVar.s()) {
                        biVar.G();
                        return;
                    }
                    throw new cq("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (ckVarL.f10265c) {
                    case 1:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10132a = cpVar.z();
                            biVar.a(true);
                            break;
                        }
                    case 2:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10133b = cpVar.z();
                            biVar.b(true);
                            break;
                        }
                    case 3:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10134c = cpVar.z();
                            biVar.c(true);
                            break;
                        }
                    case 4:
                        if (b2 != 8) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10135d = cpVar.w();
                            biVar.d(true);
                            break;
                        }
                    case 5:
                        if (b2 != 8) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10136e = cpVar.w();
                            biVar.e(true);
                            break;
                        }
                    case 6:
                        if (b2 != 8) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10137f = cpVar.w();
                            biVar.f(true);
                            break;
                        }
                    case 7:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10138g = cpVar.A();
                            biVar.g(true);
                            break;
                        }
                    case 8:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10139h = cpVar.z();
                            biVar.h(true);
                            break;
                        }
                    case 9:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10140i = cpVar.z();
                            biVar.i(true);
                            break;
                        }
                    case 10:
                        if (b2 != 8) {
                            cs.a(cpVar, b2);
                            break;
                        } else {
                            biVar.f10141j = cpVar.w();
                            biVar.j(true);
                            break;
                        }
                    default:
                        cs.a(cpVar, b2);
                        break;
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, bi biVar) throws bw {
            biVar.G();
            cpVar.a(bi.f10131m);
            if (biVar.f10132a != null) {
                cpVar.a(bi.n);
                cpVar.a(biVar.f10132a);
                cpVar.c();
            }
            if (biVar.f10133b != null) {
                cpVar.a(bi.o);
                cpVar.a(biVar.f10133b);
                cpVar.c();
            }
            if (biVar.f10134c != null) {
                cpVar.a(bi.p);
                cpVar.a(biVar.f10134c);
                cpVar.c();
            }
            cpVar.a(bi.q);
            cpVar.a(biVar.f10135d);
            cpVar.c();
            cpVar.a(bi.r);
            cpVar.a(biVar.f10136e);
            cpVar.c();
            cpVar.a(bi.s);
            cpVar.a(biVar.f10137f);
            cpVar.c();
            if (biVar.f10138g != null) {
                cpVar.a(bi.t);
                cpVar.a(biVar.f10138g);
                cpVar.c();
            }
            if (biVar.f10139h != null) {
                cpVar.a(bi.u);
                cpVar.a(biVar.f10139h);
                cpVar.c();
            }
            if (biVar.f10140i != null) {
                cpVar.a(bi.v);
                cpVar.a(biVar.f10140i);
                cpVar.c();
            }
            if (biVar.F()) {
                cpVar.a(bi.w);
                cpVar.a(biVar.f10141j);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* compiled from: UMEnvelope.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: UMEnvelope.java */
    private static class c extends da<bi> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, bi biVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(biVar.f10132a);
            cvVar.a(biVar.f10133b);
            cvVar.a(biVar.f10134c);
            cvVar.a(biVar.f10135d);
            cvVar.a(biVar.f10136e);
            cvVar.a(biVar.f10137f);
            cvVar.a(biVar.f10138g);
            cvVar.a(biVar.f10139h);
            cvVar.a(biVar.f10140i);
            BitSet bitSet = new BitSet();
            if (biVar.F()) {
                bitSet.set(0);
            }
            cvVar.a(bitSet, 1);
            if (biVar.F()) {
                cvVar.a(biVar.f10141j);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, bi biVar) throws bw {
            cv cvVar = (cv) cpVar;
            biVar.f10132a = cvVar.z();
            biVar.a(true);
            biVar.f10133b = cvVar.z();
            biVar.b(true);
            biVar.f10134c = cvVar.z();
            biVar.c(true);
            biVar.f10135d = cvVar.w();
            biVar.d(true);
            biVar.f10136e = cvVar.w();
            biVar.e(true);
            biVar.f10137f = cvVar.w();
            biVar.f(true);
            biVar.f10138g = cvVar.A();
            biVar.g(true);
            biVar.f10139h = cvVar.z();
            biVar.h(true);
            biVar.f10140i = cvVar.z();
            biVar.i(true);
            if (cvVar.b(1).get(0)) {
                biVar.f10141j = cvVar.w();
                biVar.j(true);
            }
        }
    }

    /* compiled from: UMEnvelope.java */
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
        x.put(cz.class, new b());
        x.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new cc("version", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new cc(UserInfo.ADDRESS, (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new cc(SocialOperation.GAME_SIGNATURE, (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new cc("serial_num", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new cc("ts_secs", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new cc("length", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new cc("entity", (byte) 1, new cd((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new cc("guid", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cc("checksum", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new cc("codex", (byte) 2, new cd((byte) 8)));
        f10129k = Collections.unmodifiableMap(enumMap);
        cc.a(bi.class, f10129k);
    }

    public bi() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f10140i;
    }

    public void B() {
        this.f10140i = null;
    }

    public boolean C() {
        return this.f10140i != null;
    }

    public int D() {
        return this.f10141j;
    }

    public void E() {
        this.C = bn.b(this.C, 3);
    }

    public boolean F() {
        return bn.a(this.C, 3);
    }

    public void G() throws bw {
        if (this.f10132a == null) {
            throw new cq("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f10133b == null) {
            throw new cq("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f10134c == null) {
            throw new cq("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f10138g == null) {
            throw new cq("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f10139h == null) {
            throw new cq("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f10140i != null) {
            return;
        }
        throw new cq("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bi deepCopy() {
        return new bi(this);
    }

    public String b() {
        return this.f10132a;
    }

    public void c() {
        this.f10132a = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f10132a = null;
        this.f10133b = null;
        this.f10134c = null;
        d(false);
        this.f10135d = 0;
        e(false);
        this.f10136e = 0;
        f(false);
        this.f10137f = 0;
        this.f10138g = null;
        this.f10139h = null;
        this.f10140i = null;
        j(false);
        this.f10141j = 0;
    }

    public boolean d() {
        return this.f10132a != null;
    }

    public String e() {
        return this.f10133b;
    }

    public void f() {
        this.f10133b = null;
    }

    public boolean g() {
        return this.f10133b != null;
    }

    public String h() {
        return this.f10134c;
    }

    public void i() {
        this.f10134c = null;
    }

    public boolean j() {
        return this.f10134c != null;
    }

    public int k() {
        return this.f10135d;
    }

    public void l() {
        this.C = bn.b(this.C, 0);
    }

    public boolean m() {
        return bn.a(this.C, 0);
    }

    public int n() {
        return this.f10136e;
    }

    public void o() {
        this.C = bn.b(this.C, 1);
    }

    public boolean p() {
        return bn.a(this.C, 1);
    }

    public int q() {
        return this.f10137f;
    }

    public void r() {
        this.C = bn.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        x.get(cpVar.D()).b().b(cpVar, this);
    }

    public boolean s() {
        return bn.a(this.C, 2);
    }

    public byte[] t() {
        a(br.c(this.f10138g));
        ByteBuffer byteBuffer = this.f10138g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f10132a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f10133b;
        if (str2 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f10134c;
        if (str3 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f10135d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f10136e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f10137f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f10138g;
        if (byteBuffer == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            br.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f10139h;
        if (str4 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f10140i;
        if (str5 == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f10141j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f10138g;
    }

    public void v() {
        this.f10138g = null;
    }

    public boolean w() {
        return this.f10138g != null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        x.get(cpVar.D()).b().a(cpVar, this);
    }

    public String x() {
        return this.f10139h;
    }

    public void y() {
        this.f10139h = null;
    }

    public boolean z() {
        return this.f10139h != null;
    }

    /* compiled from: UMEnvelope.java */
    public enum e implements bx {
        VERSION(1, "version"),
        ADDRESS(2, UserInfo.ADDRESS),
        SIGNATURE(3, SocialOperation.GAME_SIGNATURE),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* renamed from: k, reason: collision with root package name */
        private static final Map<String, e> f10152k = new HashMap();

        /* renamed from: l, reason: collision with root package name */
        private final short f10153l;

        /* renamed from: m, reason: collision with root package name */
        private final String f10154m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f10152k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f10153l = s;
            this.f10154m = str;
        }

        public static e a(int i2) {
            switch (i2) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.f10154m;
        }

        public static e a(String str) {
            return f10152k.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f10153l;
        }
    }

    public bi a(String str) {
        this.f10132a = str;
        return this;
    }

    public bi b(String str) {
        this.f10133b = str;
        return this;
    }

    public bi c(String str) {
        this.f10134c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = bn.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = bn.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = bn.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.f10138g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.f10139h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.f10140i = null;
    }

    public void j(boolean z2) {
        this.C = bn.a(this.C, 3, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f10132a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f10133b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f10134c = null;
    }

    public bi d(String str) {
        this.f10139h = str;
        return this;
    }

    public bi e(String str) {
        this.f10140i = str;
        return this;
    }

    public bi(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f10132a = str;
        this.f10133b = str2;
        this.f10134c = str3;
        this.f10135d = i2;
        d(true);
        this.f10136e = i3;
        e(true);
        this.f10137f = i4;
        f(true);
        this.f10138g = byteBuffer;
        this.f10139h = str4;
        this.f10140i = str5;
    }

    public bi a(int i2) {
        this.f10135d = i2;
        d(true);
        return this;
    }

    public bi b(int i2) {
        this.f10136e = i2;
        e(true);
        return this;
    }

    public bi c(int i2) {
        this.f10137f = i2;
        f(true);
        return this;
    }

    public bi d(int i2) {
        this.f10141j = i2;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public bi a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bi a(ByteBuffer byteBuffer) {
        this.f10138g = byteBuffer;
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
            this.C = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public bi(bi biVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = biVar.C;
        if (biVar.d()) {
            this.f10132a = biVar.f10132a;
        }
        if (biVar.g()) {
            this.f10133b = biVar.f10133b;
        }
        if (biVar.j()) {
            this.f10134c = biVar.f10134c;
        }
        this.f10135d = biVar.f10135d;
        this.f10136e = biVar.f10136e;
        this.f10137f = biVar.f10137f;
        if (biVar.w()) {
            this.f10138g = br.d(biVar.f10138g);
        }
        if (biVar.z()) {
            this.f10139h = biVar.f10139h;
        }
        if (biVar.C()) {
            this.f10140i = biVar.f10140i;
        }
        this.f10141j = biVar.f10141j;
    }
}
