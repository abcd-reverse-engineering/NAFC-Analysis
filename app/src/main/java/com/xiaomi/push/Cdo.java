package com.xiaomi.push;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.do, reason: invalid class name */
/* loaded from: classes2.dex */
public final class Cdo {

    /* renamed from: com.xiaomi.push.do$a */
    public static final class a extends e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f334a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f335b;

        /* renamed from: d, reason: collision with root package name */
        private boolean f12651d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f12652e;

        /* renamed from: a, reason: collision with root package name */
        private int f12648a = 0;

        /* renamed from: c, reason: collision with other field name */
        private boolean f336c = false;

        /* renamed from: b, reason: collision with root package name */
        private int f12649b = 0;

        /* renamed from: f, reason: collision with root package name */
        private boolean f12653f = false;

        /* renamed from: a, reason: collision with other field name */
        private List<String> f333a = Collections.emptyList();

        /* renamed from: c, reason: collision with root package name */
        private int f12650c = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m277b() {
            return this.f336c;
        }

        public int c() {
            return this.f12648a;
        }

        public int d() {
            return this.f12649b;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m280e() {
            return this.f12653f;
        }

        public boolean f() {
            return this.f12652e;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m276a() {
            return this.f334a;
        }

        public a b(int i2) {
            this.f12651d = true;
            this.f12649b = i2;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m278c() {
            return this.f335b;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m279d() {
            return this.f12651d;
        }

        public int e() {
            return this.f333a.size();
        }

        public a a(int i2) {
            this.f334a = true;
            this.f12648a = i2;
            return this;
        }

        public a b(boolean z) {
            this.f12652e = true;
            this.f12653f = z;
            return this;
        }

        public a a(boolean z) {
            this.f335b = true;
            this.f336c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = 0;
            int iB = m276a() ? c.b(1, c()) + 0 : 0;
            if (m278c()) {
                iB += c.a(2, m277b());
            }
            if (m279d()) {
                iB += c.a(3, d());
            }
            if (f()) {
                iB += c.a(4, m280e());
            }
            Iterator<String> it = m275a().iterator();
            while (it.hasNext()) {
                iA += c.a(it.next());
            }
            int size = iB + iA + (m275a().size() * 1);
            this.f12650c = size;
            return size;
        }

        /* renamed from: a, reason: collision with other method in class */
        public List<String> m275a() {
            return this.f333a;
        }

        public a a(String str) {
            if (str != null) {
                if (this.f333a.isEmpty()) {
                    this.f333a = new ArrayList();
                }
                this.f333a.add(str);
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) throws IOException {
            if (m276a()) {
                cVar.m211b(1, c());
            }
            if (m278c()) {
                cVar.m203a(2, m277b());
            }
            if (m279d()) {
                cVar.m198a(3, d());
            }
            if (f()) {
                cVar.m203a(4, m280e());
            }
            Iterator<String> it = m275a().iterator();
            while (it.hasNext()) {
                cVar.m202a(5, it.next());
            }
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f12650c < 0) {
                b();
            }
            return this.f12650c;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) throws d {
            while (true) {
                int iM162a = bVar.m162a();
                if (iM162a == 0) {
                    return this;
                }
                if (iM162a == 8) {
                    a(bVar.c());
                } else if (iM162a == 16) {
                    a(bVar.m168a());
                } else if (iM162a == 24) {
                    b(bVar.m171b());
                } else if (iM162a == 32) {
                    b(bVar.m168a());
                } else if (iM162a != 42) {
                    if (!a(bVar, iM162a)) {
                        return this;
                    }
                } else {
                    a(bVar.m165a());
                }
            }
        }

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }
    }
}
