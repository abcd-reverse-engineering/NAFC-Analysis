package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.ad;
import com.vivo.push.util.af;
import com.vivo.push.util.k;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ICacheSettings.java */
/* loaded from: classes2.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    protected static final Object f11992a = new Object();

    /* renamed from: b, reason: collision with root package name */
    protected List<T> f11993b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    protected Context f11994c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f11995d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f11996e;

    protected c(Context context) {
        this.f11994c = ContextDelegate.getContext(context);
        ad adVarB = ad.b();
        adVarB.a(this.f11994c);
        this.f11995d = adVarB.c();
        this.f11996e = adVarB.d();
        c();
    }

    private String b() {
        return af.b(this.f11994c).a(a(), null);
    }

    private void d(String str) {
        af.b(this.f11994c).b(a(), str);
    }

    protected abstract String a();

    protected abstract List<T> a(String str);

    abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (f11992a) {
            k.a(a());
            this.f11993b.clear();
            c(b());
        }
    }

    protected final byte[] e() {
        byte[] bArr = this.f11995d;
        return (bArr == null || bArr.length <= 0) ? ad.b().c() : bArr;
    }

    protected final byte[] f() {
        byte[] bArr = this.f11996e;
        return (bArr == null || bArr.length <= 0) ? ad.b().d() : bArr;
    }

    public final void d() {
        synchronized (f11992a) {
            this.f11993b.clear();
            d("");
            u.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            u.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            return;
        }
        if (str.length() > 10000) {
            u.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
            return;
        }
        try {
            u.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
            List<T> listA = a(b(str));
            if (listA != null) {
                this.f11993b.addAll(listA);
            }
        } catch (Exception e2) {
            d();
            u.d("CacheSettings", u.a(e2));
        }
    }
}
