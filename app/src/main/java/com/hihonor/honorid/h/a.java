package com.hihonor.honorid.h;

import android.content.Context;
import com.hihonor.honorid.core.data.HonorAccount;
import java.util.ArrayList;
import java.util.HashMap;
import k.a.a.a.j.e;

/* compiled from: HnIDMemCache.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f6231c;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f6232d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f6233a;

    /* renamed from: b, reason: collision with root package name */
    private HonorAccount f6234b;

    private a(Context context) {
        new HashMap();
        this.f6233a = context;
    }

    public static a a(Context context) {
        a aVar;
        synchronized (f6232d) {
            if (f6231c == null) {
                f6231c = new a(context.getApplicationContext());
            }
            aVar = f6231c;
        }
        return aVar;
    }

    public String b() {
        HonorAccount honorAccount = this.f6234b;
        return honorAccount == null ? "" : honorAccount.w();
    }

    public void c() {
        e.b("HnIDMemCache", "initHnAccountMemCache", true);
        ArrayList<HonorAccount> arrayListA = com.hihonor.honorid.g.a.a(this.f6233a).a(this.f6233a);
        if (arrayListA.size() > 0) {
            this.f6234b = arrayListA.get(0);
        } else {
            e.b("HnIDMemCache", "file has no account", true);
        }
    }

    public void a(HonorAccount honorAccount) {
        e.b("HnIDMemCache", "saveHnAccountToCache", true);
        if (com.hihonor.honorid.f.a.a(honorAccount)) {
            this.f6234b = honorAccount;
        } else {
            e.a("HnIDMemCache", "save honorAccount is null", true);
            this.f6234b = null;
        }
    }

    public HonorAccount a() {
        if (this.f6234b == null) {
            c();
        }
        return this.f6234b;
    }
}
