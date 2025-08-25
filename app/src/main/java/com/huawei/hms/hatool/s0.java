package com.huawei.hms.hatool;

import java.util.Map;

/* loaded from: classes.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7085a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7086b;

    /* renamed from: c, reason: collision with root package name */
    private String f7087c;

    /* renamed from: d, reason: collision with root package name */
    private String f7088d;

    /* renamed from: e, reason: collision with root package name */
    private String f7089e;

    /* renamed from: f, reason: collision with root package name */
    private String f7090f;

    /* renamed from: g, reason: collision with root package name */
    private j0 f7091g;

    /* renamed from: h, reason: collision with root package name */
    private String f7092h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, String> f7093i;

    /* renamed from: j, reason: collision with root package name */
    private String f7094j;

    /* renamed from: k, reason: collision with root package name */
    private int f7095k;

    /* renamed from: l, reason: collision with root package name */
    private int f7096l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7097m;
    private boolean n;
    private boolean o;
    private String p;
    private long q;

    public s0() {
        this.f7089e = "";
        this.f7090f = "";
        this.f7091g = new j0();
        this.f7092h = "";
        this.f7094j = "";
        this.f7095k = 10;
        this.f7096l = 7;
        this.f7097m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
    }

    public s0(s0 s0Var) {
        this.f7089e = "";
        this.f7090f = "";
        this.f7091g = new j0();
        this.f7092h = "";
        this.f7094j = "";
        this.f7095k = 10;
        this.f7096l = 7;
        this.f7097m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
        this.f7091g = s0Var.f7091g;
        b(s0Var.f7085a);
        a(s0Var.f7087c);
        b(s0Var.f7088d);
        e(s0Var.f7089e);
        g(s0Var.f7090f);
        d(s0Var.f7092h);
        f(s0Var.f7094j);
        c(s0Var.f7086b);
        a(s0Var.f7095k);
        b(s0Var.f7096l);
        d(s0Var.f7097m);
        a(s0Var.n);
        e(s0Var.o);
        a(s0Var.f7093i);
        c(s0Var.p);
        a(s0Var.q);
    }

    public void a(int i2) {
        this.f7095k = i2;
    }

    public void a(long j2) {
        this.q = j2;
    }

    public void a(String str) {
        this.f7087c = str;
    }

    public void a(Map<String, String> map) {
        this.f7093i = map;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.f7095k;
    }

    public void b(int i2) {
        this.f7096l = i2;
    }

    public void b(String str) {
        this.f7088d = str;
    }

    public void b(boolean z) {
        this.f7085a = z;
    }

    public void c(String str) {
        this.p = str;
    }

    public void c(boolean z) {
        this.f7086b = z;
    }

    public boolean c() {
        return this.f7085a;
    }

    public int d() {
        return this.f7096l;
    }

    public void d(String str) {
        this.f7092h = str;
    }

    public void d(boolean z) {
        this.f7097m = z;
    }

    public void e(String str) {
        this.f7089e = str;
    }

    public void e(boolean z) {
        this.o = z;
    }

    public boolean e() {
        return this.f7086b;
    }

    public String f() {
        return this.f7087c;
    }

    public void f(String str) {
        this.f7094j = str;
    }

    public void g(String str) {
        this.f7090f = str;
    }

    public boolean g() {
        return this.f7097m;
    }

    public String h() {
        return this.f7088d;
    }

    public boolean i() {
        return this.o;
    }

    public j0 j() {
        return this.f7091g;
    }

    public Map<String, String> k() {
        return this.f7093i;
    }

    public long l() {
        return this.q;
    }

    public String m() {
        return this.p;
    }

    public String n() {
        return this.f7092h;
    }

    public String o() {
        return this.f7089e;
    }

    public String p() {
        return this.f7094j;
    }

    public String q() {
        return this.f7090f;
    }
}
