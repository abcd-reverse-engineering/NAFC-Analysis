package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final AesDecrypt f6412a;

    public k(Context context, String str) {
        this.f6412a = (TextUtils.isEmpty(a(context, str)) || Build.VERSION.SDK_INT < 26) ? new g(context, str) : new h(context, str);
    }

    private String a(Context context, String str) {
        String strA = l.a(context, str, "agc_plugin_", "crypto");
        if (strA == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(strA), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
            String str2 = "UnsupportedEncodingException" + e2.getMessage();
            return null;
        }
    }

    public String a(String str, String str2) {
        return this.f6412a.decrypt(str, str2);
    }
}
