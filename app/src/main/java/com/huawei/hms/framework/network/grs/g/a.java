package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected d f6852a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6853b;

    /* renamed from: c, reason: collision with root package name */
    private final c f6854c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6855d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f6856e;

    /* renamed from: f, reason: collision with root package name */
    private final String f6857f;

    /* renamed from: g, reason: collision with root package name */
    private final GrsBaseInfo f6858g;

    /* renamed from: h, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.c f6859h;

    public a(String str, int i2, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.f6853b = str;
        this.f6854c = cVar;
        this.f6855d = i2;
        this.f6856e = context;
        this.f6857f = str2;
        this.f6858g = grsBaseInfo;
        this.f6859h = cVar2;
    }

    public Context a() {
        return this.f6856e;
    }

    public c b() {
        return this.f6854c;
    }

    public String c() {
        return this.f6853b;
    }

    public int d() {
        return this.f6855d;
    }

    public String e() {
        return this.f6857f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.f6859h;
    }

    public Callable<d> g() {
        return new f(this.f6853b, this.f6855d, this.f6854c, this.f6856e, this.f6857f, this.f6858g, this.f6859h);
    }
}
