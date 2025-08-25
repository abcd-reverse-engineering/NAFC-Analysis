package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.aa;

/* compiled from: BaseAppCommand.java */
/* loaded from: classes2.dex */
public class c extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f11936a;

    /* renamed from: b, reason: collision with root package name */
    private String f11937b;

    /* renamed from: c, reason: collision with root package name */
    private long f11938c;

    /* renamed from: d, reason: collision with root package name */
    private int f11939d;

    /* renamed from: e, reason: collision with root package name */
    private int f11940e;

    /* renamed from: f, reason: collision with root package name */
    private String f11941f;

    /* renamed from: g, reason: collision with root package name */
    private String f11942g;

    /* renamed from: h, reason: collision with root package name */
    private String f11943h;

    public c(int i2, String str) {
        super(i2);
        this.f11938c = -1L;
        this.f11939d = -1;
        this.f11936a = null;
        this.f11937b = str;
    }

    public final int a(Context context) {
        if (this.f11939d == -1) {
            String str = this.f11937b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.u.a("BaseAppCommand", "pkg name is null");
                String strA = a();
                if (TextUtils.isEmpty(strA)) {
                    com.vivo.push.util.u.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = strA;
            }
            this.f11939d = aa.b(context, str);
            if (!TextUtils.isEmpty(this.f11941f)) {
                this.f11939d = 2;
            }
        }
        return this.f11939d;
    }

    public final void b(int i2) {
        this.f11940e = i2;
    }

    public final void c(String str) {
        this.f11943h = str;
    }

    public final int d() {
        return this.f11940e;
    }

    public final void e() {
        this.f11941f = null;
    }

    public final String f() {
        return this.f11936a;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "BaseAppCommand";
    }

    public final void b(String str) {
        this.f11936a = str;
    }

    @Override // com.vivo.push.v
    protected void c(com.vivo.push.d dVar) {
        dVar.a("req_id", this.f11936a);
        dVar.a("package_name", this.f11937b);
        dVar.a("sdk_version", 341L);
        dVar.a("PUSH_APP_STATUS", this.f11939d);
        if (!TextUtils.isEmpty(this.f11941f)) {
            dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f11941f);
        }
        dVar.a("BaseAppCommand.EXTRA_APPID", this.f11943h);
        dVar.a("BaseAppCommand.EXTRA_APPKEY", this.f11942g);
    }

    public final void d(String str) {
        this.f11942g = str;
    }

    @Override // com.vivo.push.v
    protected void d(com.vivo.push.d dVar) {
        this.f11936a = dVar.a("req_id");
        this.f11937b = dVar.a("package_name");
        this.f11938c = dVar.b("sdk_version", 0L);
        this.f11939d = dVar.b("PUSH_APP_STATUS", 0);
        this.f11941f = dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.f11943h = dVar.a("BaseAppCommand.EXTRA_APPID");
        this.f11942g = dVar.a("BaseAppCommand.EXTRA_APPKEY");
    }
}
