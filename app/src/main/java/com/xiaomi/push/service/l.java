package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.hb;
import com.xiaomi.push.hg;
import com.xiaomi.push.hp;
import com.xiaomi.push.hu;

/* loaded from: classes2.dex */
public class l {
    static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] bArrB = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (bArrB != null) {
                x.m753a(context, u.a(bArrB), bArrB);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("notify fcm notification error ", th);
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.h.a(com.xiaomi.push.ay.m161a(str), bArr);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("dencryption error. ", e2);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.h.b(com.xiaomi.push.ay.m161a(str), bArr);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("encryption error. ", e2);
            return null;
        }
    }

    public static hg a(hb hbVar) {
        byte[] bArrM535a = hbVar.m535a();
        hg hgVar = new hg();
        try {
            hp.a(hgVar, bArrM535a);
            return hgVar;
        } catch (hu unused) {
            return null;
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }
}
