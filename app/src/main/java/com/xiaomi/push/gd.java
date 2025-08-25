package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gd {

    /* renamed from: a, reason: collision with root package name */
    private static volatile gd f12920a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f557a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, ge> f558a = new HashMap();

    private gd(Context context) {
        this.f557a = context;
    }

    public static gd a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f12920a == null) {
            synchronized (gd.class) {
                if (f12920a == null) {
                    f12920a = new gd(context);
                }
            }
        }
        return f12920a;
    }

    public void a(ge geVar, String str) {
        if (geVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m459a().put(str, geVar);
        }
    }

    ge a() {
        ge geVar = this.f558a.get("UPLOADER_PUSH_CHANNEL");
        if (geVar != null) {
            return geVar;
        }
        ge geVar2 = this.f558a.get("UPLOADER_HTTP");
        if (geVar2 != null) {
            return geVar2;
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    Map<String, ge> m459a() {
        return this.f558a;
    }

    public boolean a(gj gjVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (com.xiaomi.push.service.az.a(gjVar, false)) {
            return false;
        }
        if (TextUtils.isEmpty(gjVar.d())) {
            gjVar.f(com.xiaomi.push.service.az.a());
        }
        gjVar.g(str);
        com.xiaomi.push.service.ba.a(this.f557a, gjVar);
        return true;
    }
}
