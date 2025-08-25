package com.vivo.push;

import android.text.TextUtils;

/* compiled from: SubscribeImpl.java */
/* loaded from: classes2.dex */
public final class z implements k {

    /* renamed from: a, reason: collision with root package name */
    private y f12313a = new y();

    /* renamed from: b, reason: collision with root package name */
    private y f12314b = new y();

    /* renamed from: c, reason: collision with root package name */
    private com.vivo.push.c.a f12315c;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f12316d;

    /* renamed from: e, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f12317e;

    public z(com.vivo.push.c.a aVar, com.vivo.push.restructure.b.a aVar2) {
        this.f12315c = aVar;
        this.f12317e = aVar2;
    }

    private void d(String str) {
        this.f12316d = str;
        this.f12317e.c(this.f12316d);
    }

    @Override // com.vivo.push.k
    public final String b() throws Throwable {
        if (!TextUtils.isEmpty(this.f12316d)) {
            return this.f12316d;
        }
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            strD = this.f12317e.f();
            t.c(new aa(this, strD));
        }
        this.f12316d = strD;
        com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(strD)));
        return strD;
    }

    @Override // com.vivo.push.k
    public final void c(String str) {
        d(str);
    }

    private int c() throws Throwable {
        if (!this.f12315c.d()) {
            return 8013;
        }
        if (this.f12314b.a()) {
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe 两秒内重复调用  ");
            return 1002;
        }
        int i2 = 1;
        try {
            String strA = new e(1, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(strA)));
            String strA2 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), strA);
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(strA2)));
            if (!TextUtils.isEmpty(strA2)) {
                i2 = 1 ^ (Boolean.parseBoolean(g.f12076a.a(strA2).b()) ? 1 : 0);
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("SubscribeImpl", "isAppSubscribe", e2);
        }
        com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(i2)));
        return i2;
    }

    @Override // com.vivo.push.k
    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f12315c.c() || iPushActionListener == null) {
            m.a().b(iPushActionListener, str, str2);
        } else {
            iPushActionListener.onStateChanged(8012);
        }
    }

    private String d() throws Throwable {
        String strB = "";
        if (!this.f12315c.d()) {
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk 系统不支持查询regid  ");
            return "";
        }
        if (this.f12313a.a()) {
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk 两秒内重复调用  ");
            return "";
        }
        try {
            String strA = new e(2, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(strA)));
            String strA2 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), strA);
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(strA2)));
            if (!TextUtils.isEmpty(strA2)) {
                strB = g.f12076a.a(strA2).b();
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("SubscribeImpl", "getRegidByCoreSdk", e2);
        }
        com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(strB)));
        return strB;
    }

    @Override // com.vivo.push.k
    public final int a() {
        return c();
    }

    @Override // com.vivo.push.k
    public final void a(String str, String str2, String str3) {
        d(str);
        this.f12317e.a(str2);
        this.f12317e.b(str3);
    }

    @Override // com.vivo.push.k
    public final void a(String str) {
        d(str);
        this.f12317e.d();
        this.f12317e.b();
    }

    @Override // com.vivo.push.k
    public final void b(String str) {
        d(str);
        m.a().e();
        this.f12317e.h();
        this.f12317e.d();
        this.f12317e.b();
    }
}
