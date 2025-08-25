package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: classes.dex */
public class m1 {

    /* renamed from: b, reason: collision with root package name */
    private static m1 f7053b = new m1();

    /* renamed from: a, reason: collision with root package name */
    private a f7054a = new a();

    class a {

        /* renamed from: a, reason: collision with root package name */
        String f7055a;

        /* renamed from: b, reason: collision with root package name */
        String f7056b;

        /* renamed from: c, reason: collision with root package name */
        long f7057c = 0;

        a() {
        }

        void a(long j2) {
            m1.this.f7054a.f7057c = j2;
        }

        void a(String str) {
            m1.this.f7054a.f7056b = str;
        }

        void b(String str) {
            m1.this.f7054a.f7055a = str;
        }
    }

    public static m1 d() {
        return f7053b;
    }

    public String a() {
        return this.f7054a.f7056b;
    }

    public void a(String str, String str2) {
        long jB = b();
        String strC = w0.c(str, str2);
        if (strC == null || strC.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (jB == 0) {
            jB = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - jB <= com.heytap.mcssdk.constant.a.f5803g) {
            return;
        }
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String strA = h0.a(strC, strGenerateSecureRandomStr);
        this.f7054a.a(jB);
        this.f7054a.b(strGenerateSecureRandomStr);
        this.f7054a.a(strA);
    }

    public long b() {
        return this.f7054a.f7057c;
    }

    public String c() {
        return this.f7054a.f7055a;
    }
}
