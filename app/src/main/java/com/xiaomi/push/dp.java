package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class dp {

    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f339a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f342b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f345c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f347d;

        /* renamed from: e, reason: collision with other field name */
        private boolean f349e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f350f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f12660g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f12661h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f12662i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f12663j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f12664k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f12665l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f12666m;

        /* renamed from: a, reason: collision with root package name */
        private int f12654a = 0;

        /* renamed from: a, reason: collision with other field name */
        private long f337a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f338a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f341b = "";

        /* renamed from: c, reason: collision with other field name */
        private String f344c = "";

        /* renamed from: d, reason: collision with other field name */
        private String f346d = "";

        /* renamed from: e, reason: collision with other field name */
        private String f348e = "";

        /* renamed from: b, reason: collision with root package name */
        private int f12655b = 1;

        /* renamed from: c, reason: collision with root package name */
        private int f12656c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f12657d = 0;

        /* renamed from: f, reason: collision with root package name */
        private String f12659f = "";

        /* renamed from: b, reason: collision with other field name */
        private long f340b = 0;

        /* renamed from: c, reason: collision with other field name */
        private long f343c = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f12658e = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m287b() {
            return this.f342b;
        }

        public int c() {
            return this.f12654a;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m292d() {
            return this.f347d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m294e() {
            return this.f349e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m296f() {
            return this.f350f;
        }

        public boolean g() {
            return this.f12660g;
        }

        public boolean h() {
            return this.f12661h;
        }

        public boolean i() {
            return this.f12662i;
        }

        public boolean j() {
            return this.f12663j;
        }

        public boolean k() {
            return this.f12664k;
        }

        public boolean l() {
            return this.f12665l;
        }

        public boolean m() {
            return this.f12666m;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m284a() {
            return this.f339a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m286b() {
            return this.f341b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m290c() {
            return this.f345c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public String m291d() {
            return this.f346d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public String m293e() {
            return this.f348e;
        }

        public int f() {
            return this.f12657d;
        }

        public a a(int i2) {
            this.f339a = true;
            this.f12654a = i2;
            return this;
        }

        public a b(String str) {
            this.f347d = true;
            this.f341b = str;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public String m289c() {
            return this.f344c;
        }

        public a d(String str) {
            this.f350f = true;
            this.f346d = str;
            return this;
        }

        public a e(String str) {
            this.f12660g = true;
            this.f348e = str;
            return this;
        }

        /* renamed from: f, reason: collision with other method in class */
        public String m295f() {
            return this.f12659f;
        }

        public a c(String str) {
            this.f349e = true;
            this.f344c = str;
            return this;
        }

        public a f(String str) {
            this.f12664k = true;
            this.f12659f = str;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public long m281a() {
            return this.f337a;
        }

        public a b(int i2) {
            this.f12661h = true;
            this.f12655b = i2;
            return this;
        }

        public int d() {
            return this.f12655b;
        }

        public int e() {
            return this.f12656c;
        }

        public a a(long j2) {
            this.f342b = true;
            this.f337a = j2;
            return this;
        }

        public a c(int i2) {
            this.f12662i = true;
            this.f12656c = i2;
            return this;
        }

        public a d(int i2) {
            this.f12663j = true;
            this.f12657d = i2;
            return this;
        }

        /* renamed from: b, reason: collision with other method in class */
        public long m285b() {
            return this.f340b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m283a() {
            return this.f338a;
        }

        public a b(long j2) {
            this.f12665l = true;
            this.f340b = j2;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public long m288c() {
            return this.f343c;
        }

        public a a(String str) {
            this.f345c = true;
            this.f338a = str;
            return this;
        }

        public a c(long j2) {
            this.f12666m = true;
            this.f343c = j2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m284a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m287b()) {
                iA += com.xiaomi.push.c.b(2, m281a());
            }
            if (m290c()) {
                iA += com.xiaomi.push.c.a(3, m283a());
            }
            if (m292d()) {
                iA += com.xiaomi.push.c.a(4, m286b());
            }
            if (m294e()) {
                iA += com.xiaomi.push.c.a(5, m289c());
            }
            if (m296f()) {
                iA += com.xiaomi.push.c.a(6, m291d());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(7, m293e());
            }
            if (h()) {
                iA += com.xiaomi.push.c.a(8, d());
            }
            if (i()) {
                iA += com.xiaomi.push.c.a(9, e());
            }
            if (j()) {
                iA += com.xiaomi.push.c.a(10, f());
            }
            if (k()) {
                iA += com.xiaomi.push.c.a(11, m295f());
            }
            if (l()) {
                iA += com.xiaomi.push.c.b(12, m285b());
            }
            if (m()) {
                iA += com.xiaomi.push.c.b(13, m288c());
            }
            this.f12658e = iA;
            return iA;
        }

        /* renamed from: a, reason: collision with other method in class */
        public a m282a() {
            this.f350f = false;
            this.f346d = "";
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m284a()) {
                cVar.m198a(1, c());
            }
            if (m287b()) {
                cVar.m212b(2, m281a());
            }
            if (m290c()) {
                cVar.m202a(3, m283a());
            }
            if (m292d()) {
                cVar.m202a(4, m286b());
            }
            if (m294e()) {
                cVar.m202a(5, m289c());
            }
            if (m296f()) {
                cVar.m202a(6, m291d());
            }
            if (g()) {
                cVar.m202a(7, m293e());
            }
            if (h()) {
                cVar.m198a(8, d());
            }
            if (i()) {
                cVar.m198a(9, e());
            }
            if (j()) {
                cVar.m198a(10, f());
            }
            if (k()) {
                cVar.m202a(11, m295f());
            }
            if (l()) {
                cVar.m212b(12, m285b());
            }
            if (m()) {
                cVar.m212b(13, m288c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12658e < 0) {
                b();
            }
            return this.f12658e;
        }

        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                switch (iM162a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m171b());
                        break;
                    case 16:
                        a(bVar.m172b());
                        break;
                    case 26:
                        a(bVar.m165a());
                        break;
                    case 34:
                        b(bVar.m165a());
                        break;
                    case 42:
                        c(bVar.m165a());
                        break;
                    case 50:
                        d(bVar.m165a());
                        break;
                    case 58:
                        e(bVar.m165a());
                        break;
                    case 64:
                        b(bVar.m171b());
                        break;
                    case 72:
                        c(bVar.m171b());
                        break;
                    case 80:
                        d(bVar.m171b());
                        break;
                    case 90:
                        f(bVar.m165a());
                        break;
                    case 96:
                        b(bVar.m172b());
                        break;
                    case 104:
                        c(bVar.m172b());
                        break;
                    default:
                        if (!a(bVar, iM162a)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }

    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f351a;

        /* renamed from: c, reason: collision with other field name */
        private boolean f353c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f354d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f12671e;

        /* renamed from: b, reason: collision with other field name */
        private boolean f352b = false;

        /* renamed from: a, reason: collision with root package name */
        private int f12667a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f12668b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f12669c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f12670d = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m298b() {
            return this.f351a;
        }

        public int c() {
            return this.f12667a;
        }

        public int d() {
            return this.f12668b;
        }

        public int e() {
            return this.f12669c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m297a() {
            return this.f352b;
        }

        public b b(int i2) {
            this.f354d = true;
            this.f12668b = i2;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m299c() {
            return this.f353c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m300d() {
            return this.f354d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m301e() {
            return this.f12671e;
        }

        public b a(boolean z) {
            this.f351a = true;
            this.f352b = z;
            return this;
        }

        public b c(int i2) {
            this.f12671e = true;
            this.f12669c = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m298b() ? 0 + com.xiaomi.push.c.a(1, m297a()) : 0;
            if (m299c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m300d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m301e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            this.f12670d = iA;
            return iA;
        }

        public b a(int i2) {
            this.f353c = true;
            this.f12667a = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m298b()) {
                cVar.m203a(1, m297a());
            }
            if (m299c()) {
                cVar.m198a(3, c());
            }
            if (m300d()) {
                cVar.m198a(4, d());
            }
            if (m301e()) {
                cVar.m198a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12670d < 0) {
                b();
            }
            return this.f12670d;
        }

        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 8) {
                    a(bVar.m168a());
                } else if (iM162a == 24) {
                    a(bVar.m171b());
                } else if (iM162a == 32) {
                    b(bVar.m171b());
                } else if (iM162a != 40) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    c(bVar.m171b());
                }
            }
        }

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }
    }

    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f356a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f357b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f358c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f359d;

        /* renamed from: e, reason: collision with other field name */
        private boolean f360e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f361f;

        /* renamed from: a, reason: collision with other field name */
        private String f355a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f12673b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f12674c = "";

        /* renamed from: d, reason: collision with root package name */
        private String f12675d = "";

        /* renamed from: e, reason: collision with root package name */
        private String f12676e = "";

        /* renamed from: f, reason: collision with root package name */
        private String f12677f = "";

        /* renamed from: a, reason: collision with root package name */
        private int f12672a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public String m304b() {
            return this.f12673b;
        }

        public String c() {
            return this.f12674c;
        }

        public String d() {
            return this.f12675d;
        }

        public String e() {
            return this.f12676e;
        }

        public String f() {
            return this.f12677f;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m302a() {
            return this.f355a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m305b() {
            return this.f357b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m306c() {
            return this.f358c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m307d() {
            return this.f359d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m308e() {
            return this.f360e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m309f() {
            return this.f361f;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m303a() {
            return this.f356a;
        }

        public c b(String str) {
            this.f357b = true;
            this.f12673b = str;
            return this;
        }

        public c c(String str) {
            this.f358c = true;
            this.f12674c = str;
            return this;
        }

        public c d(String str) {
            this.f359d = true;
            this.f12675d = str;
            return this;
        }

        public c e(String str) {
            this.f360e = true;
            this.f12676e = str;
            return this;
        }

        public c f(String str) {
            this.f361f = true;
            this.f12677f = str;
            return this;
        }

        public c a(String str) {
            this.f356a = true;
            this.f355a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m303a() ? 0 + com.xiaomi.push.c.a(1, m302a()) : 0;
            if (m305b()) {
                iA += com.xiaomi.push.c.a(2, m304b());
            }
            if (m306c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m307d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m308e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (m309f()) {
                iA += com.xiaomi.push.c.a(6, f());
            }
            this.f12672a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m303a()) {
                cVar.m202a(1, m302a());
            }
            if (m305b()) {
                cVar.m202a(2, m304b());
            }
            if (m306c()) {
                cVar.m202a(3, c());
            }
            if (m307d()) {
                cVar.m202a(4, d());
            }
            if (m308e()) {
                cVar.m202a(5, e());
            }
            if (m309f()) {
                cVar.m202a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12672a < 0) {
                b();
            }
            return this.f12672a;
        }

        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 10) {
                    a(bVar.m165a());
                } else if (iM162a == 18) {
                    b(bVar.m165a());
                } else if (iM162a == 26) {
                    c(bVar.m165a());
                } else if (iM162a == 34) {
                    d(bVar.m165a());
                } else if (iM162a == 42) {
                    e(bVar.m165a());
                } else if (iM162a != 50) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    f(bVar.m165a());
                }
            }
        }
    }

    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f363a;

        /* renamed from: c, reason: collision with other field name */
        private boolean f365c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f12681d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f12682e;

        /* renamed from: b, reason: collision with other field name */
        private boolean f364b = false;

        /* renamed from: a, reason: collision with other field name */
        private String f362a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f12679b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f12680c = "";

        /* renamed from: a, reason: collision with root package name */
        private int f12678a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m313b() {
            return this.f363a;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m314c() {
            return this.f365c;
        }

        public boolean d() {
            return this.f12681d;
        }

        public boolean e() {
            return this.f12682e;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m311a() {
            return this.f364b;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m312b() {
            return this.f12679b;
        }

        public String c() {
            return this.f12680c;
        }

        public d a(boolean z) {
            this.f363a = true;
            this.f364b = z;
            return this;
        }

        public d b(String str) {
            this.f12681d = true;
            this.f12679b = str;
            return this;
        }

        public d c(String str) {
            this.f12682e = true;
            this.f12680c = str;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m310a() {
            return this.f362a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m313b() ? 0 + com.xiaomi.push.c.a(1, m311a()) : 0;
            if (m314c()) {
                iA += com.xiaomi.push.c.a(2, m310a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(3, m312b());
            }
            if (e()) {
                iA += com.xiaomi.push.c.a(4, c());
            }
            this.f12678a = iA;
            return iA;
        }

        public d a(String str) {
            this.f365c = true;
            this.f362a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m313b()) {
                cVar.m203a(1, m311a());
            }
            if (m314c()) {
                cVar.m202a(2, m310a());
            }
            if (d()) {
                cVar.m202a(3, m312b());
            }
            if (e()) {
                cVar.m202a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12678a < 0) {
                b();
            }
            return this.f12678a;
        }

        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 8) {
                    a(bVar.m168a());
                } else if (iM162a == 18) {
                    a(bVar.m165a());
                } else if (iM162a == 26) {
                    b(bVar.m165a());
                } else if (iM162a != 34) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    c(bVar.m165a());
                }
            }
        }

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }
    }

    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f366a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f369a;

        /* renamed from: b, reason: collision with other field name */
        private com.xiaomi.push.a f370b;

        /* renamed from: b, reason: collision with other field name */
        private boolean f372b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f374c;

        /* renamed from: d, reason: collision with root package name */
        private int f12686d;

        /* renamed from: d, reason: collision with other field name */
        private boolean f376d;

        /* renamed from: e, reason: collision with root package name */
        private int f12687e;

        /* renamed from: e, reason: collision with other field name */
        private boolean f378e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f379f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f12689g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f12690h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f12691i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f12692j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f12693k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f12694l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f12695m;

        /* renamed from: a, reason: collision with root package name */
        private int f12683a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f368a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f371b = "";

        /* renamed from: c, reason: collision with other field name */
        private String f373c = "";

        /* renamed from: b, reason: collision with root package name */
        private int f12684b = 0;

        /* renamed from: d, reason: collision with other field name */
        private String f375d = "";

        /* renamed from: e, reason: collision with other field name */
        private String f377e = "";

        /* renamed from: f, reason: collision with root package name */
        private String f12688f = "";

        /* renamed from: a, reason: collision with other field name */
        private b f367a = null;

        /* renamed from: c, reason: collision with root package name */
        private int f12685c = 0;

        public e() {
            com.xiaomi.push.a aVar = com.xiaomi.push.a.f12411a;
            this.f366a = aVar;
            this.f370b = aVar;
            this.f12686d = 0;
            this.f12687e = -1;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m321b() {
            return this.f372b;
        }

        public int c() {
            return this.f12683a;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m325d() {
            return this.f376d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m327e() {
            return this.f378e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m329f() {
            return this.f379f;
        }

        public boolean g() {
            return this.f12689g;
        }

        public boolean h() {
            return this.f12690h;
        }

        public boolean i() {
            return this.f12691i;
        }

        public boolean j() {
            return this.f12692j;
        }

        public boolean k() {
            return this.f12693k;
        }

        public boolean l() {
            return this.f12694l;
        }

        public boolean m() {
            return this.f12695m;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m318a() {
            return this.f369a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m320b() {
            return this.f371b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m323c() {
            return this.f374c;
        }

        public int d() {
            return this.f12684b;
        }

        /* renamed from: e, reason: collision with other method in class */
        public String m326e() {
            return this.f377e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public String m328f() {
            return this.f12688f;
        }

        public e a(int i2) {
            this.f369a = true;
            this.f12683a = i2;
            return this;
        }

        public e b(String str) {
            this.f374c = true;
            this.f371b = str;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public String m322c() {
            return this.f373c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public String m324d() {
            return this.f375d;
        }

        public e e(String str) {
            this.f12689g = true;
            this.f377e = str;
            return this;
        }

        public e f(String str) {
            this.f12690h = true;
            this.f12688f = str;
            return this;
        }

        public e c(String str) {
            this.f376d = true;
            this.f373c = str;
            return this;
        }

        public e d(String str) {
            this.f379f = true;
            this.f375d = str;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m317a() {
            return this.f368a;
        }

        public e b(int i2) {
            this.f378e = true;
            this.f12684b = i2;
            return this;
        }

        public int e() {
            return this.f12685c;
        }

        public int f() {
            return this.f12686d;
        }

        public e a(String str) {
            this.f372b = true;
            this.f368a = str;
            return this;
        }

        public e c(int i2) {
            this.f12692j = true;
            this.f12685c = i2;
            return this;
        }

        public e d(int i2) {
            this.f12695m = true;
            this.f12686d = i2;
            return this;
        }

        /* renamed from: b, reason: collision with other method in class */
        public com.xiaomi.push.a m319b() {
            return this.f370b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m316a() {
            return this.f367a;
        }

        public e b(com.xiaomi.push.a aVar) {
            this.f12694l = true;
            this.f370b = aVar;
            return this;
        }

        public e a(b bVar) {
            if (bVar != null) {
                this.f12691i = true;
                this.f367a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iB = m318a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m321b()) {
                iB += com.xiaomi.push.c.a(2, m317a());
            }
            if (m323c()) {
                iB += com.xiaomi.push.c.a(3, m320b());
            }
            if (m325d()) {
                iB += com.xiaomi.push.c.a(4, m322c());
            }
            if (m327e()) {
                iB += com.xiaomi.push.c.a(5, d());
            }
            if (m329f()) {
                iB += com.xiaomi.push.c.a(6, m324d());
            }
            if (g()) {
                iB += com.xiaomi.push.c.a(7, m326e());
            }
            if (h()) {
                iB += com.xiaomi.push.c.a(8, m328f());
            }
            if (i()) {
                iB += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m316a());
            }
            if (j()) {
                iB += com.xiaomi.push.c.a(10, e());
            }
            if (k()) {
                iB += com.xiaomi.push.c.a(11, m315a());
            }
            if (l()) {
                iB += com.xiaomi.push.c.a(12, m319b());
            }
            if (m()) {
                iB += com.xiaomi.push.c.a(13, f());
            }
            this.f12687e = iB;
            return iB;
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m315a() {
            return this.f366a;
        }

        public e a(com.xiaomi.push.a aVar) {
            this.f12693k = true;
            this.f366a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m318a()) {
                cVar.m211b(1, c());
            }
            if (m321b()) {
                cVar.m202a(2, m317a());
            }
            if (m323c()) {
                cVar.m202a(3, m320b());
            }
            if (m325d()) {
                cVar.m202a(4, m322c());
            }
            if (m327e()) {
                cVar.m198a(5, d());
            }
            if (m329f()) {
                cVar.m202a(6, m324d());
            }
            if (g()) {
                cVar.m202a(7, m326e());
            }
            if (h()) {
                cVar.m202a(8, m328f());
            }
            if (i()) {
                cVar.m201a(9, (com.xiaomi.push.e) m316a());
            }
            if (j()) {
                cVar.m198a(10, e());
            }
            if (k()) {
                cVar.m200a(11, m315a());
            }
            if (l()) {
                cVar.m200a(12, m319b());
            }
            if (m()) {
                cVar.m198a(13, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12687e < 0) {
                b();
            }
            return this.f12687e;
        }

        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                switch (iM162a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m165a());
                        break;
                    case 26:
                        b(bVar.m165a());
                        break;
                    case 34:
                        c(bVar.m165a());
                        break;
                    case 40:
                        b(bVar.m171b());
                        break;
                    case 50:
                        d(bVar.m165a());
                        break;
                    case 58:
                        e(bVar.m165a());
                        break;
                    case 66:
                        f(bVar.m165a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m171b());
                        break;
                    case 90:
                        a(bVar.m164a());
                        break;
                    case 98:
                        b(bVar.m164a());
                        break;
                    case 104:
                        d(bVar.m171b());
                        break;
                    default:
                        if (!a(bVar, iM162a)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }

    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f382a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f383b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f12698c;

        /* renamed from: a, reason: collision with other field name */
        private String f381a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f12697b = "";

        /* renamed from: a, reason: collision with other field name */
        private b f380a = null;

        /* renamed from: a, reason: collision with root package name */
        private int f12696a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public String m333b() {
            return this.f12697b;
        }

        public boolean c() {
            return this.f12698c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m331a() {
            return this.f381a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m334b() {
            return this.f383b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m332a() {
            return this.f382a;
        }

        public f b(String str) {
            this.f383b = true;
            this.f12697b = str;
            return this;
        }

        public f a(String str) {
            this.f382a = true;
            this.f381a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m332a() ? 0 + com.xiaomi.push.c.a(1, m331a()) : 0;
            if (m334b()) {
                iA += com.xiaomi.push.c.a(2, m333b());
            }
            if (c()) {
                iA += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m330a());
            }
            this.f12696a = iA;
            return iA;
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m330a() {
            return this.f380a;
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.f12698c = true;
                this.f380a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m332a()) {
                cVar.m202a(1, m331a());
            }
            if (m334b()) {
                cVar.m202a(2, m333b());
            }
            if (c()) {
                cVar.m201a(3, (com.xiaomi.push.e) m330a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12696a < 0) {
                b();
            }
            return this.f12696a;
        }

        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 10) {
                    a(bVar.m165a());
                } else if (iM162a == 18) {
                    b(bVar.m165a());
                } else if (iM162a != 26) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }
    }

    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f385a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f386b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f387c;

        /* renamed from: a, reason: collision with other field name */
        private String f384a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f12700b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f12701c = "";

        /* renamed from: a, reason: collision with root package name */
        private int f12699a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public String m337b() {
            return this.f12700b;
        }

        public String c() {
            return this.f12701c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m335a() {
            return this.f384a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m338b() {
            return this.f386b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m339c() {
            return this.f387c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m336a() {
            return this.f385a;
        }

        public g b(String str) {
            this.f386b = true;
            this.f12700b = str;
            return this;
        }

        public g c(String str) {
            this.f387c = true;
            this.f12701c = str;
            return this;
        }

        public g a(String str) {
            this.f385a = true;
            this.f384a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m336a() ? 0 + com.xiaomi.push.c.a(1, m335a()) : 0;
            if (m338b()) {
                iA += com.xiaomi.push.c.a(2, m337b());
            }
            if (m339c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            this.f12699a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m336a()) {
                cVar.m202a(1, m335a());
            }
            if (m338b()) {
                cVar.m202a(2, m337b());
            }
            if (m339c()) {
                cVar.m202a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12699a < 0) {
                b();
            }
            return this.f12699a;
        }

        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 10) {
                    a(bVar.m165a());
                } else if (iM162a == 18) {
                    b(bVar.m165a());
                } else if (iM162a != 26) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    c(bVar.m165a());
                }
            }
        }

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }
    }

    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f389a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f390b;

        /* renamed from: a, reason: collision with root package name */
        private int f12702a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f388a = "";

        /* renamed from: b, reason: collision with root package name */
        private int f12703b = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m342b() {
            return this.f390b;
        }

        public int c() {
            return this.f12702a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m341a() {
            return this.f389a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m341a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m342b()) {
                iA += com.xiaomi.push.c.a(2, m340a());
            }
            this.f12703b = iA;
            return iA;
        }

        public h a(int i2) {
            this.f389a = true;
            this.f12702a = i2;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m340a() {
            return this.f388a;
        }

        public h a(String str) {
            this.f390b = true;
            this.f388a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m341a()) {
                cVar.m198a(1, c());
            }
            if (m342b()) {
                cVar.m202a(2, m340a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12703b < 0) {
                b();
            }
            return this.f12703b;
        }

        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 8) {
                    a(bVar.m171b());
                } else if (iM162a != 18) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    a(bVar.m165a());
                }
            }
        }

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }
    }

    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f392a;

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f391a = com.xiaomi.push.a.f12411a;

        /* renamed from: a, reason: collision with root package name */
        private int f12704a = -1;

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m344a() ? 0 + com.xiaomi.push.c.a(1, m343a()) : 0;
            this.f12704a = iA;
            return iA;
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m343a() {
            return this.f391a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m344a() {
            return this.f392a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f392a = true;
            this.f391a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m344a()) {
                cVar.m200a(1, m343a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12704a < 0) {
                b();
            }
            return this.f12704a;
        }

        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a != 10) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    a(bVar.m164a());
                }
            }
        }

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }
    }

    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f395a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12706b;

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f393a = com.xiaomi.push.a.f12411a;

        /* renamed from: a, reason: collision with other field name */
        private b f394a = null;

        /* renamed from: a, reason: collision with root package name */
        private int f12705a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m348b() {
            return this.f12706b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m345a() {
            return this.f393a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m347a() ? 0 + com.xiaomi.push.c.a(1, m345a()) : 0;
            if (m348b()) {
                iA += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m346a());
            }
            this.f12705a = iA;
            return iA;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m347a() {
            return this.f395a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f395a = true;
            this.f393a = aVar;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m346a() {
            return this.f394a;
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.f12706b = true;
                this.f394a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m347a()) {
                cVar.m200a(1, m345a());
            }
            if (m348b()) {
                cVar.m201a(2, (com.xiaomi.push.e) m346a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12705a < 0) {
                b();
            }
            return this.f12705a;
        }

        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 10) {
                    a(bVar.m164a());
                } else if (iM162a != 18) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }
    }

    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f398a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f401b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f12709c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f12710d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f12711e;

        /* renamed from: g, reason: collision with root package name */
        private boolean f12713g;

        /* renamed from: a, reason: collision with other field name */
        private String f397a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f400b = "";

        /* renamed from: a, reason: collision with other field name */
        private long f396a = 0;

        /* renamed from: b, reason: collision with other field name */
        private long f399b = 0;

        /* renamed from: f, reason: collision with root package name */
        private boolean f12712f = false;

        /* renamed from: a, reason: collision with root package name */
        private int f12707a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f12708b = -1;

        /* renamed from: b, reason: collision with other method in class */
        public String m353b() {
            return this.f400b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m355c() {
            return this.f12709c;
        }

        public boolean d() {
            return this.f12710d;
        }

        public boolean e() {
            return this.f12712f;
        }

        public boolean f() {
            return this.f12711e;
        }

        public boolean g() {
            return this.f12713g;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m350a() {
            return this.f397a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m354b() {
            return this.f401b;
        }

        public int c() {
            return this.f12707a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m351a() {
            return this.f398a;
        }

        public k b(String str) {
            this.f401b = true;
            this.f400b = str;
            return this;
        }

        public k a(String str) {
            this.f398a = true;
            this.f397a = str;
            return this;
        }

        /* renamed from: b, reason: collision with other method in class */
        public long m352b() {
            return this.f399b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public long m349a() {
            return this.f396a;
        }

        public k b(long j2) {
            this.f12710d = true;
            this.f399b = j2;
            return this;
        }

        public k a(long j2) {
            this.f12709c = true;
            this.f396a = j2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m351a() ? 0 + com.xiaomi.push.c.a(1, m350a()) : 0;
            if (m354b()) {
                iA += com.xiaomi.push.c.a(2, m353b());
            }
            if (m355c()) {
                iA += com.xiaomi.push.c.a(3, m349a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(4, m352b());
            }
            if (f()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(6, c());
            }
            this.f12708b = iA;
            return iA;
        }

        public k a(boolean z) {
            this.f12711e = true;
            this.f12712f = z;
            return this;
        }

        public k a(int i2) {
            this.f12713g = true;
            this.f12707a = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m351a()) {
                cVar.m202a(1, m350a());
            }
            if (m354b()) {
                cVar.m202a(2, m353b());
            }
            if (m355c()) {
                cVar.m199a(3, m349a());
            }
            if (d()) {
                cVar.m199a(4, m352b());
            }
            if (f()) {
                cVar.m203a(5, e());
            }
            if (g()) {
                cVar.m198a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12708b < 0) {
                b();
            }
            return this.f12708b;
        }

        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 10) {
                    a(bVar.m165a());
                } else if (iM162a == 18) {
                    b(bVar.m165a());
                } else if (iM162a == 24) {
                    a(bVar.m163a());
                } else if (iM162a == 32) {
                    b(bVar.m163a());
                } else if (iM162a == 40) {
                    a(bVar.m168a());
                } else if (iM162a != 48) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    a(bVar.m171b());
                }
            }
        }

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }
    }
}
