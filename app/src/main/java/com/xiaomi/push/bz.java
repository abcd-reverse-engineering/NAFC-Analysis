package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* loaded from: classes2.dex */
public class bz {

    /* renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f243a = new SimpleDateFormat("yyyy/MM/dd");

    /* renamed from: a, reason: collision with root package name */
    private static String f12533a = f243a.format(Long.valueOf(System.currentTimeMillis()));

    public static gj a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gj gjVar = new gj();
        gjVar.d("category_push_stat");
        gjVar.a("push_sdk_stat_channel");
        gjVar.a(1L);
        gjVar.b(str);
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(bn.a(context).m191a());
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f("");
        gjVar.c("push_stat");
        return gjVar;
    }
}
