package com.xiaomi.push;

import java.util.Map;

/* loaded from: classes2.dex */
public class eh implements ef {

    /* renamed from: a, reason: collision with root package name */
    private ef f12741a;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static eh f12742a = new eh();
    }

    public static eh a() {
        return a.f12742a;
    }

    private eh() {
    }

    @Override // com.xiaomi.push.ef
    public void a(ee eeVar) {
        ef efVar = this.f12741a;
        if (efVar != null) {
            efVar.a(eeVar);
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(String str, Map<String, Object> map) {
        ef efVar = this.f12741a;
        if (efVar != null) {
            efVar.a(str, map);
        }
    }
}
