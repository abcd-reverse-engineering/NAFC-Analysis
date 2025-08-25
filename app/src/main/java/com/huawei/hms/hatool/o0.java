package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: classes.dex */
public class o0 {

    /* renamed from: c, reason: collision with root package name */
    private static o0 f7062c;

    /* renamed from: a, reason: collision with root package name */
    private String f7063a;

    /* renamed from: b, reason: collision with root package name */
    private String f7064b;

    private String a(String str) {
        String strDecrypt = f() ? AesGcmKS.decrypt("analytics_keystore", str) : "";
        if (TextUtils.isEmpty(strDecrypt)) {
            v.c("hmsSdk", "deCrypt work key first");
            strDecrypt = n.a(str, e());
            if (TextUtils.isEmpty(strDecrypt)) {
                strDecrypt = EncryptUtil.generateSecureRandomStr(16);
                c(b(strDecrypt));
                if (f()) {
                    x.c();
                }
            } else if (f()) {
                c(b(strDecrypt));
                x.c();
            }
        }
        return strDecrypt;
    }

    private String b(String str) {
        return f() ? AesGcmKS.encrypt("analytics_keystore", str) : n.b(str, e());
    }

    private String c() {
        String strA = d.a(q0.i(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(strA)) {
            return a(strA);
        }
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        c(b(strGenerateSecureRandomStr));
        return strGenerateSecureRandomStr;
    }

    private boolean c(String str) {
        v.c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            v.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        d.b(q0.i(), "Privacy_MY", "PrivacyData", str);
        d.b(q0.i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public static o0 d() {
        if (f7062c == null) {
            g();
        }
        return f7062c;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f7064b)) {
            this.f7064b = new x().a();
        }
        return this.f7064b;
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static synchronized void g() {
        if (f7062c == null) {
            f7062c = new o0();
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f7063a)) {
            this.f7063a = c();
        }
        return this.f7063a;
    }

    public void b() {
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        if (c(b(strGenerateSecureRandomStr))) {
            this.f7063a = strGenerateSecureRandomStr;
        }
    }
}
