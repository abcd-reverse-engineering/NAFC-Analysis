package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f6920a = new ConcurrentHashMap(16);

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f6921a;

        /* renamed from: b, reason: collision with root package name */
        private final long f6922b;

        public a(long j2, long j3) {
            this.f6921a = j2;
            this.f6922b = j3;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.f6922b <= this.f6921a;
        }
    }

    public static a a(String str) {
        Logger.v("RequestUtil", "map size of get is before: " + f6920a.size());
        a aVar = f6920a.get(str);
        Logger.v("RequestUtil", "map size of get is after: " + f6920a.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        Logger.v("RequestUtil", "map size of put is before: " + f6920a.size());
        f6920a.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after: " + f6920a.size());
    }
}
