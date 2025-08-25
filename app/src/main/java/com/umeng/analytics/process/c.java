package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMProcessDBManager.java */
/* loaded from: classes2.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f10582a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f10583b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private Context f10584c;

    private c() {
    }

    static c a(Context context) {
        if (f10582a == null) {
            synchronized (c.class) {
                if (f10582a == null) {
                    f10582a = new c();
                }
            }
        }
        c cVar = f10582a;
        cVar.f10584c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f10583b.get(str) != null) {
            return this.f10583b.get(str);
        }
        a aVarA = a.a(this.f10584c, str);
        this.f10583b.put(str, aVarA);
        return aVarA;
    }

    synchronized void b(String str) {
        c(str).b();
    }

    /* compiled from: UMProcessDBManager.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private AtomicInteger f10585a = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        private SQLiteOpenHelper f10586b;

        /* renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f10587c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f10586b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.f10585a.decrementAndGet() == 0) {
                    this.f10587c.close();
                }
            } catch (Throwable unused) {
            }
        }

        synchronized SQLiteDatabase a() {
            if (this.f10585a.incrementAndGet() == 1) {
                this.f10587c = this.f10586b.getWritableDatabase();
            }
            return this.f10587c;
        }
    }

    synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
