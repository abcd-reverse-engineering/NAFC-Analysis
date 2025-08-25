package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMDBManager.java */
/* loaded from: classes2.dex */
class g {

    /* renamed from: b, reason: collision with root package name */
    private static SQLiteOpenHelper f10399b;

    /* renamed from: d, reason: collision with root package name */
    private static Context f10400d;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f10401a;

    /* renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f10402c;

    /* compiled from: UMDBManager.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final g f10403a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (f10400d == null && context != null) {
            f10400d = context.getApplicationContext();
            f10399b = f.a(f10400d);
        }
        return a.f10403a;
    }

    public synchronized void b() {
        try {
            if (this.f10401a.decrementAndGet() == 0) {
                this.f10402c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private g() {
        this.f10401a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f10401a.incrementAndGet() == 1) {
            this.f10402c = f10399b.getWritableDatabase();
        }
        return this.f10402c;
    }
}
