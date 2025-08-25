package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.j;
import com.vivo.push.util.u;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AppConfigSettings.java */
/* loaded from: classes2.dex */
public final class a extends c<com.vivo.push.model.a> {
    public a(Context context) {
        super(context);
    }

    public static boolean a(int i2) {
        return (i2 == -1 || (i2 & 1) == 0) ? false : true;
    }

    @Override // com.vivo.push.cache.c
    protected final String a() {
        return "com.vivo.pushservice.back_up";
    }

    @Override // com.vivo.push.cache.c
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.trim().split("@#")) {
                String strTrim = str2.trim();
                String[] strArrSplit = strTrim.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (strArrSplit.length >= 2) {
                    try {
                        arrayList.add(new com.vivo.push.model.a(strArrSplit[0], strTrim.substring(strArrSplit[0].length() + 1)));
                    } catch (Exception e2) {
                        u.d("AppConfigSettings", "str2Clients E: ".concat(String.valueOf(e2)));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.c
    final String b(String str) throws Exception {
        return new String(j.a(j.a(e()), j.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final com.vivo.push.model.a c(String str) {
        synchronized (c.f11992a) {
            for (T t : this.f11993b) {
                if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t;
                }
            }
            return null;
        }
    }

    public final int b() {
        com.vivo.push.model.a aVarC = c("push_mode");
        if (aVarC != null && !TextUtils.isEmpty(aVarC.b())) {
            try {
                return Integer.parseInt(aVarC.b());
            } catch (Exception unused) {
            }
        }
        return -1;
    }
}
