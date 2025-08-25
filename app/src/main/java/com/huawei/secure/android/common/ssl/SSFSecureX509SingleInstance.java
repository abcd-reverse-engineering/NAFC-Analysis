package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

/* loaded from: classes.dex */
public class SSFSecureX509SingleInstance {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7557a = "SSFSecureX509SingleInstance";

    /* renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f7558b;

    private SSFSecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        ContextUtil.setContext(context);
        if (f7558b == null) {
            synchronized (SSFSecureX509SingleInstance.class) {
                if (f7558b == null) {
                    InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                    if (filesBksIS == null) {
                        e.c(f7557a, "get assets bks");
                        filesBksIS = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        e.c(f7557a, "get files bks");
                    }
                    f7558b = new SecureX509TrustManager(filesBksIS, "", true);
                }
            }
        }
        return f7558b;
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        e.c(f7557a, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f7558b != null) {
            f7558b = new SecureX509TrustManager(inputStream, "", true);
            e.a(f7557a, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            SSFCompatiableSystemCA.a(f7558b);
            SASFCompatiableSystemCA.a(f7558b);
        }
        e.a(f7557a, "update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        e.c(f7557a, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f7558b != null) {
            f7558b = new SecureX509TrustManager(inputStream, "", true);
            e.a(f7557a, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            SSFCompatiableSystemCA.a(f7558b, secureRandom);
            SASFCompatiableSystemCA.a(f7558b, secureRandom);
        }
        e.a(f7557a, "update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }
}
