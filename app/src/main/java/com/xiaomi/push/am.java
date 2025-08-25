package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
class am {

    /* renamed from: a, reason: collision with root package name */
    static int f12443a;

    public static ai a(Context context) {
        if (j.m626a()) {
            f12443a = 1;
            return new al(context);
        }
        if (ah.a(context)) {
            f12443a = 2;
            return new ah(context);
        }
        if (ao.a(context)) {
            f12443a = 4;
            return new ao(context);
        }
        if (aq.a(context)) {
            f12443a = 5;
            return new aq(context);
        }
        if (ak.a(context)) {
            f12443a = 3;
            return new aj(context);
        }
        f12443a = 0;
        return new ap();
    }
}
