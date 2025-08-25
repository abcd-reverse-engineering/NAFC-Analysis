package com.tencent.bugly.beta.utils;

import com.tencent.bugly.proguard.an;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class c {
    private static HashMap<Long, String> u = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private String f8891b;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.bugly.beta.utils.a f8890a = null;

    /* renamed from: c, reason: collision with root package name */
    private long f8892c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f8893d = 0;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, b> f8894e = null;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f8895f = new byte[16];

    /* renamed from: g, reason: collision with root package name */
    private long f8896g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f8897h = 0;

    /* renamed from: i, reason: collision with root package name */
    private String f8898i = null;

    /* renamed from: j, reason: collision with root package name */
    private long f8899j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f8900k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f8901l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f8902m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;

    /* compiled from: BUGLY */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private long f8903a = -1;

        /* renamed from: b, reason: collision with root package name */
        private long f8904b = 0;

        /* renamed from: c, reason: collision with root package name */
        private long f8905c = 0;

        /* renamed from: d, reason: collision with root package name */
        private long f8906d = -1;

        /* renamed from: e, reason: collision with root package name */
        private long f8907e = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f8908f = 0;

        /* renamed from: g, reason: collision with root package name */
        private long f8909g = 0;

        /* renamed from: h, reason: collision with root package name */
        private long f8910h = 0;

        /* renamed from: i, reason: collision with root package name */
        private long f8911i = 0;

        /* renamed from: j, reason: collision with root package name */
        private long f8912j = 0;

        public long a() {
            return this.f8903a;
        }

        public long b() {
            return this.f8906d;
        }

        public long c() {
            return this.f8907e;
        }

        public long d() {
            return this.f8908f;
        }

        public long e() {
            return this.f8912j;
        }

        public synchronized void f(long j2) {
            this.f8908f = j2;
        }

        public synchronized void g(long j2) {
            this.f8909g = j2;
        }

        public synchronized void h(long j2) {
            this.f8910h = j2;
        }

        public synchronized void i(long j2) {
            this.f8911i = j2;
        }

        public synchronized void j(long j2) {
            this.f8912j = j2;
        }

        public synchronized void a(long j2) {
            this.f8903a = j2;
        }

        public synchronized void b(long j2) {
            this.f8904b = j2;
        }

        public synchronized void c(long j2) {
            this.f8905c = j2;
        }

        public synchronized void d(long j2) {
            this.f8907e = j2;
        }

        public synchronized void e(long j2) {
            this.f8906d = j2;
        }
    }

    /* compiled from: BUGLY */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f8913a = null;

        /* renamed from: b, reason: collision with root package name */
        private long f8914b = -1;

        /* renamed from: c, reason: collision with root package name */
        private long f8915c = -1;

        /* renamed from: d, reason: collision with root package name */
        private long f8916d = 0;

        /* renamed from: e, reason: collision with root package name */
        private long f8917e = 0;

        public long a() {
            return this.f8915c;
        }

        public synchronized void b(long j2) {
            this.f8915c = j2;
        }

        public synchronized void c(long j2) {
            this.f8916d = j2;
        }

        public synchronized void d(long j2) {
            this.f8917e = j2;
        }

        public synchronized void a(String str) {
            this.f8913a = str;
        }

        public synchronized void a(long j2) {
            this.f8914b = j2;
        }
    }

    public c(String str) {
        this.f8891b = null;
        this.f8891b = str;
        u.put(3L, "x86");
        u.put(7L, "x86");
        u.put(8L, "mips");
        u.put(10L, "mips");
        u.put(40L, "armeabi");
        u.put(62L, "x86_64");
        u.put(183L, "arm64-v8a");
    }

    private long a(byte b2) {
        if (1 == b2) {
            return 32L;
        }
        return 2 == b2 ? 64L : 0L;
    }

    private String b() {
        return this.f8898i;
    }

    private long c() {
        return this.f8902m;
    }

    private long d() {
        return this.s;
    }

    private long e() {
        return this.t;
    }

    private boolean f() {
        if (!l()) {
            return false;
        }
        if (g()) {
            j();
            return true;
        }
        j();
        return false;
    }

    private synchronized boolean g() {
        if (!h()) {
            return false;
        }
        try {
            this.f8896g = this.f8890a.g();
            this.f8897h = this.f8890a.g();
            this.f8898i = a(this.f8897h, this.f8892c);
            this.f8899j = this.f8890a.h();
            if (32 == this.f8892c) {
                long jH = this.f8890a.h();
                this.f8899j = jH;
                this.f8900k = jH;
                this.f8901l = this.f8890a.h();
                this.f8902m = this.f8890a.h();
            } else {
                if (64 != this.f8892c) {
                    return false;
                }
                long jI = this.f8890a.i();
                this.f8899j = jI;
                this.f8900k = jI;
                this.f8901l = this.f8890a.i();
                this.f8902m = this.f8890a.i();
            }
            this.n = this.f8890a.h();
            this.o = this.f8890a.g();
            this.p = this.f8890a.g();
            this.q = this.f8890a.g();
            this.r = this.f8890a.g();
            this.s = this.f8890a.g();
            this.t = this.f8890a.g();
            return true;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
    }

    private synchronized boolean h() {
        if (!this.f8890a.a(this.f8895f)) {
            return false;
        }
        if (!a(this.f8895f)) {
            String str = "Not a elf file: " + this.f8891b;
            return false;
        }
        this.f8892c = a(this.f8895f[4]);
        if (0 == this.f8892c) {
            String str2 = "File format error: " + ((int) this.f8895f[4]);
            return false;
        }
        this.f8893d = b(this.f8895f[5]);
        if (com.tencent.bugly.beta.utils.a.f8873a != this.f8893d) {
            this.f8890a.a(this.f8893d);
            return true;
        }
        String str3 = "Endian error: " + ((int) this.f8895f[5]);
        return false;
    }

    private synchronized boolean i() {
        this.f8894e = a(c(), d(), e());
        return this.f8894e != null;
    }

    private synchronized void j() {
        if (this.f8890a == null) {
            return;
        }
        if (this.f8890a.a()) {
            this.f8890a = null;
        }
    }

    private synchronized boolean k() {
        if (this.f8890a != null) {
            j();
        }
        try {
            this.f8890a = new com.tencent.bugly.beta.utils.a(this.f8891b, this.f8893d);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private synchronized boolean l() {
        if (this.f8890a != null) {
            j();
        }
        try {
            this.f8890a = new com.tencent.bugly.beta.utils.a(this.f8891b);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private synchronized a m() {
        a aVar = new a();
        try {
            aVar.a(this.f8890a.h());
            aVar.b(this.f8890a.h());
            if (32 == this.f8892c) {
                aVar.c(this.f8890a.h());
                aVar.e(this.f8890a.h());
                aVar.d(this.f8890a.h());
                aVar.f(this.f8890a.h());
            } else {
                if (64 != this.f8892c) {
                    return null;
                }
                aVar.c(this.f8890a.i());
                aVar.e(this.f8890a.i());
                aVar.d(this.f8890a.i());
                aVar.f(this.f8890a.i());
            }
            aVar.g(this.f8890a.h());
            aVar.h(this.f8890a.h());
            if (32 == this.f8892c) {
                aVar.i(this.f8890a.h());
                aVar.j(this.f8890a.h());
            } else {
                if (64 != this.f8892c) {
                    return null;
                }
                aVar.i(this.f8890a.i());
                aVar.j(this.f8890a.i());
            }
            return aVar;
        } catch (IOException e2) {
            e2.getMessage();
            return null;
        }
    }

    public synchronized String a() {
        if (!f()) {
            return null;
        }
        String strB = b();
        if (!strB.equals("armeabi")) {
            return strB;
        }
        if (!i()) {
            return strB;
        }
        b bVar = this.f8894e.get(".ARM.attributes");
        if (bVar == null) {
            return strB;
        }
        return com.tencent.bugly.beta.utils.b.a(this.f8891b, this.f8893d, bVar.a());
    }

    private long b(byte b2) {
        return 1 == b2 ? com.tencent.bugly.beta.utils.a.f8875c : 2 == b2 ? com.tencent.bugly.beta.utils.a.f8874b : com.tencent.bugly.beta.utils.a.f8873a;
    }

    private synchronized HashMap<String, b> b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            Vector vector = new Vector();
            for (int i2 = 0; i2 < j2; i2++) {
                vector.add(m());
            }
            a aVar = (a) vector.get((int) j3);
            long length = new File(this.f8891b).length();
            an.c("File length = %d", Long.valueOf(length));
            if (aVar.c() >= length) {
                an.d("The SO file is invalid or has a shell.", new Object[0]);
                return null;
            }
            d dVar = new d(this.f8891b, aVar.c(), aVar.d());
            HashMap<String, b> map = new HashMap<>();
            Iterator it = vector.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                String strA = dVar.a(aVar2.a());
                b bVar = new b();
                bVar.a(strA);
                bVar.a(aVar2.b());
                bVar.b(aVar2.c());
                bVar.c(aVar2.d());
                bVar.d(aVar2.e());
                map.put(strA, bVar);
            }
            dVar.a();
            return map;
        }
        an.d("The SO file is invalid or has a shell.", new Object[0]);
        return null;
    }

    private static String a(long j2, long j3) {
        String str = u.get(Long.valueOf(j2));
        return (64 == j3 && str.equals("mips")) ? "mips64" : str;
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 3 && Byte.MAX_VALUE == bArr[0] && 69 == bArr[1] && 76 == bArr[2] && 70 == bArr[3];
    }

    private synchronized HashMap<String, b> a(long j2, long j3, long j4) {
        if (!k()) {
            j();
            return null;
        }
        if (!this.f8890a.b(j2)) {
            j();
            return null;
        }
        HashMap<String, b> mapB = b(j3, j4);
        j();
        return mapB;
    }
}
