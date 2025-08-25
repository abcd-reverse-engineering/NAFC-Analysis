package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static volatile p f12385a;

    /* renamed from: a, reason: collision with other field name */
    private Context f127a;

    /* renamed from: a, reason: collision with other field name */
    private List<n> f128a = new ArrayList();

    private p(Context context) {
        this.f127a = context.getApplicationContext();
        if (this.f127a == null) {
            this.f127a = context;
        }
    }

    public static p a(Context context) {
        if (f12385a == null) {
            synchronized (p.class) {
                if (f12385a == null) {
                    f12385a = new p(context);
                }
            }
        }
        return f12385a;
    }

    public void b(String str) {
        synchronized (this.f128a) {
            n nVar = new n();
            nVar.f125a = str;
            if (this.f128a.contains(nVar)) {
                Iterator<n> it = this.f128a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (nVar.equals(next)) {
                        nVar = next;
                        break;
                    }
                }
            }
            nVar.f12383a++;
            this.f128a.remove(nVar);
            this.f128a.add(nVar);
        }
    }

    public void c(String str) {
        synchronized (this.f128a) {
            n nVar = new n();
            nVar.f125a = str;
            if (this.f128a.contains(nVar)) {
                this.f128a.remove(nVar);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m104a(String str) {
        synchronized (this.f128a) {
            n nVar = new n();
            nVar.f12383a = 0;
            nVar.f125a = str;
            if (this.f128a.contains(nVar)) {
                this.f128a.remove(nVar);
            }
            this.f128a.add(nVar);
        }
    }

    public int a(String str) {
        synchronized (this.f128a) {
            n nVar = new n();
            nVar.f125a = str;
            if (this.f128a.contains(nVar)) {
                for (n nVar2 : this.f128a) {
                    if (nVar2.equals(nVar)) {
                        return nVar2.f12383a;
                    }
                }
            }
            return 0;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m105a(String str) {
        synchronized (this.f128a) {
            n nVar = new n();
            nVar.f125a = str;
            return this.f128a.contains(nVar);
        }
    }

    public synchronized String a(v vVar) {
        return this.f127a.getSharedPreferences("mipush_extra", 0).getString(vVar.name(), "");
    }

    public synchronized void a(v vVar, String str) {
        SharedPreferences sharedPreferences = this.f127a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(vVar.name(), str).apply();
    }
}
