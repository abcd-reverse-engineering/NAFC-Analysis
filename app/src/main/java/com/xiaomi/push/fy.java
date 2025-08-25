package com.xiaomi.push;

import com.xiaomi.push.af;

/* loaded from: classes2.dex */
public class fy {

    /* renamed from: a, reason: collision with root package name */
    private static af f12906a = new af(true, 20);

    public static void a(final Runnable runnable) {
        f12906a.a(new af.b() { // from class: com.xiaomi.push.fy.1
            @Override // com.xiaomi.push.af.b
            public void b() {
                runnable.run();
            }
        });
    }

    public static void a(af.b bVar) {
        f12906a.a(bVar);
    }

    public static void a(af.b bVar, long j2) {
        f12906a.a(bVar, j2);
    }
}
