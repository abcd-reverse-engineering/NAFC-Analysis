package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.k;
import com.vivo.push.restructure.a.a.d;
import com.vivo.push.restructure.b.b;
import com.vivo.push.restructure.b.f;
import com.vivo.push.util.z;

/* compiled from: PushClientController.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f12133a;

    /* renamed from: b, reason: collision with root package name */
    private com.vivo.push.restructure.c.a f12134b;

    /* renamed from: c, reason: collision with root package name */
    private d f12135c;

    /* renamed from: d, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f12136d;

    /* renamed from: e, reason: collision with root package name */
    private b f12137e;

    /* renamed from: f, reason: collision with root package name */
    private com.vivo.push.c.a f12138f;

    /* renamed from: g, reason: collision with root package name */
    private k f12139g;

    /* compiled from: PushClientController.java */
    /* renamed from: com.vivo.push.restructure.a$a, reason: collision with other inner class name */
    private static class C0162a {

        /* renamed from: a, reason: collision with root package name */
        static a f12140a = new a(0);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0162a.f12140a;
    }

    public final synchronized Context b() {
        return this.f12133a;
    }

    public final com.vivo.push.restructure.c.a c() {
        return this.f12134b;
    }

    public final d d() {
        return this.f12135c;
    }

    public final synchronized com.vivo.push.restructure.b.a e() {
        return this.f12136d;
    }

    public final b f() {
        return this.f12137e;
    }

    public final com.vivo.push.c.a g() {
        return this.f12138f;
    }

    public final k h() {
        return this.f12139g;
    }

    private a() {
    }

    public final synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        if (context == null) {
            this.f12136d = new com.vivo.push.restructure.b.d(new z(context));
            this.f12134b = new com.vivo.push.restructure.c.b(this.f12136d);
            this.f12135c = new d();
            this.f12137e = new f();
            this.f12138f = new com.vivo.push.c.a(context);
            this.f12139g = new com.vivo.push.z(this.f12138f, e());
            return;
        }
        this.f12133a = context;
        this.f12136d = new com.vivo.push.restructure.b.d(new z(context));
        this.f12134b = new com.vivo.push.restructure.c.b(this.f12136d);
        this.f12135c = new d();
        this.f12137e = new f();
        this.f12138f = new com.vivo.push.c.a(context);
        this.f12139g = new com.vivo.push.z(this.f12138f, e());
        return;
    }
}
