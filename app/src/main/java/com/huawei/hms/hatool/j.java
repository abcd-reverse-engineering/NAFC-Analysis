package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* loaded from: classes.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static j f7012b;

    /* renamed from: a, reason: collision with root package name */
    private Context f7013a;

    private static class a extends e0 {

        /* renamed from: a, reason: collision with root package name */
        String f7014a;

        /* renamed from: b, reason: collision with root package name */
        String f7015b;

        public a(String str, String str2) {
            this.f7014a = str;
            this.f7015b = str2;
        }

        @Override // com.huawei.hms.hatool.e0
        public String a() {
            return z.d(this.f7014a, this.f7015b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String a(String str) {
            return SHA.sha256Encrypt(str);
        }

        @Override // com.huawei.hms.hatool.e0
        public String b() {
            return z.g(this.f7014a, this.f7015b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String c() {
            return z.j(this.f7014a, this.f7015b);
        }

        @Override // com.huawei.hms.hatool.e0
        public int d() {
            return (z.k(this.f7014a, this.f7015b) ? 4 : 0) | 0 | (z.e(this.f7014a, this.f7015b) ? 2 : 0) | (z.h(this.f7014a, this.f7015b) ? 1 : 0);
        }
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            if (f7012b == null) {
                f7012b = new j();
            }
            jVar = f7012b;
        }
        return jVar;
    }

    public String a(String str, String str2) {
        return i0.a(this.f7013a, str, str2);
    }

    public String a(boolean z) {
        if (!z) {
            return "";
        }
        String strE = q0.e();
        if (TextUtils.isEmpty(strE)) {
            strE = d.a(this.f7013a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(strE)) {
                strE = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                d.b(this.f7013a, "global_v2", "uuid", strE);
            }
            q0.h(strE);
        }
        return strE;
    }

    public void a(Context context) {
        if (this.f7013a == null) {
            this.f7013a = context;
        }
    }

    public String b(String str, String str2) {
        return i0.b(this.f7013a, str, str2);
    }

    public i c(String str, String str2) {
        return new a(str, str2).a(this.f7013a);
    }

    public String d(String str, String str2) {
        return f1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (!z.f(str, str2)) {
            return new Pair<>("", "");
        }
        String strP = s.c().b().p();
        String strQ = s.c().b().q();
        if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(strQ)) {
            return new Pair<>(strP, strQ);
        }
        Pair<String, String> pairE = x0.e(this.f7013a);
        s.c().b().k((String) pairE.first);
        s.c().b().l((String) pairE.second);
        return pairE;
    }

    public String f(String str, String str2) {
        return f1.a(str, str2);
    }
}
