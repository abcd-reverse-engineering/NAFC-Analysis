package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: b, reason: collision with root package name */
    static Map<String, l1> f7082b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static s f7083c;

    /* renamed from: a, reason: collision with root package name */
    private g1 f7084a = new g1();

    private s() {
    }

    public static s c() {
        if (f7083c == null) {
            d();
        }
        return f7083c;
    }

    private static synchronized void d() {
        if (f7083c == null) {
            f7083c = new s();
        }
    }

    public l1 a(String str) {
        return f7082b.get(str);
    }

    public Set<String> a() {
        return f7082b.keySet();
    }

    public void a(String str, l1 l1Var) {
        f7082b.put(str, l1Var);
    }

    public g1 b() {
        return this.f7084a;
    }
}
