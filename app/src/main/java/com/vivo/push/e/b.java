package com.vivo.push.e;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: PushSecurityManager.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f12026c;

    /* renamed from: a, reason: collision with root package name */
    private a f12027a;

    /* renamed from: b, reason: collision with root package name */
    private Context f12028b;

    private b() {
    }

    public static synchronized b a() {
        if (f12026c == null) {
            f12026c = new b();
        }
        return f12026c;
    }

    public final synchronized a a(Context context) {
        if (this.f12027a != null) {
            return this.f12027a;
        }
        if (context == null) {
            return null;
        }
        if (this.f12027a == null) {
            this.f12028b = ContextDelegate.getContext(context.getApplicationContext());
            this.f12027a = new c(this.f12028b);
        }
        return this.f12027a;
    }
}
