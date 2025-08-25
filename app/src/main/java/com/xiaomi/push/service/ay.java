package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class ay implements aa {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ay f13399a;

    /* renamed from: a, reason: collision with other field name */
    private long f1020a;

    /* renamed from: a, reason: collision with other field name */
    Context f1021a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f1022a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f1024a = false;

    /* renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, a> f1023a = new ConcurrentHashMap<>();

    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        long f13401a;

        /* renamed from: a, reason: collision with other field name */
        String f1025a;

        a(String str, long j2) {
            this.f1025a = str;
            this.f13401a = j2;
        }

        abstract void a(ay ayVar);

        @Override // java.lang.Runnable
        public void run() {
            if (ay.f13399a != null) {
                Context context = ay.f13399a.f1021a;
                if (com.xiaomi.push.au.c(context)) {
                    if (System.currentTimeMillis() - ay.f13399a.f1022a.getLong(":ts-" + this.f1025a, 0L) > this.f13401a || com.xiaomi.push.ab.a(context)) {
                        com.xiaomi.push.p.a(ay.f13399a.f1022a.edit().putLong(":ts-" + this.f1025a, System.currentTimeMillis()));
                        a(ay.f13399a);
                    }
                }
            }
        }
    }

    private ay(Context context) {
        this.f1021a = context.getApplicationContext();
        this.f1022a = context.getSharedPreferences("sync", 0);
    }

    public static ay a(Context context) {
        if (f13399a == null) {
            synchronized (ay.class) {
                if (f13399a == null) {
                    f13399a = new ay(context);
                }
            }
        }
        return f13399a;
    }

    @Override // com.xiaomi.push.service.aa
    /* renamed from: a, reason: collision with other method in class */
    public void mo712a() {
        if (this.f1024a) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f1020a < com.heytap.mcssdk.constant.a.f5801e) {
            return;
        }
        this.f1020a = jCurrentTimeMillis;
        this.f1024a = true;
        com.xiaomi.push.ae.a(this.f1021a).a(new Runnable() { // from class: com.xiaomi.push.service.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = ay.this.f1023a.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).run();
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("Sync job exception :" + e2.getMessage());
                }
                ay.this.f1024a = false;
            }
        }, (int) (Math.random() * 10.0d));
    }

    public String a(String str, String str2) {
        return this.f1022a.getString(str + Constants.COLON_SEPARATOR + str2, "");
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.p.a(f13399a.f1022a.edit().putString(str + Constants.COLON_SEPARATOR + str2, str3));
    }

    public void a(a aVar) {
        if (this.f1023a.putIfAbsent(aVar.f1025a, aVar) == null) {
            com.xiaomi.push.ae.a(this.f1021a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }
}
