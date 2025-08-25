package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* compiled from: SystemCache.java */
/* loaded from: classes2.dex */
public final class af implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f12243a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Long> f12244b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f12245c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static af f12246d;

    /* renamed from: e, reason: collision with root package name */
    private Context f12247e;

    /* renamed from: f, reason: collision with root package name */
    private e f12248f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12249g;

    private af(Context context) {
        this.f12249g = false;
        this.f12247e = context;
        this.f12249g = a(context);
        u.d("SystemCache", "init status is " + this.f12249g + ";  curCache is " + this.f12248f);
    }

    public static synchronized af b(Context context) {
        if (f12246d == null) {
            f12246d = new af(context.getApplicationContext());
        }
        return f12246d;
    }

    public final void a() {
        ae aeVar = new ae();
        if (aeVar.a(this.f12247e)) {
            aeVar.a();
            u.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        e eVar;
        f12245c.put(str, str2);
        if (!this.f12249g || (eVar = this.f12248f) == null) {
            return;
        }
        eVar.b(str, str2);
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        this.f12248f = new ac();
        boolean zA = this.f12248f.a(context);
        if (!zA) {
            this.f12248f = new ae();
            zA = this.f12248f.a(context);
        }
        if (!zA) {
            this.f12248f = null;
        }
        return zA;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        e eVar;
        String str3 = f12245c.get(str);
        return (str3 != null || (eVar = this.f12248f) == null) ? str3 : eVar.a(str, str2);
    }
}
