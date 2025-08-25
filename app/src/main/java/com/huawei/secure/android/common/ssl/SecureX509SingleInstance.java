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
public class SecureX509SingleInstance {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7597a = "SecureX509SingleInstance";

    /* renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f7598b;

    private SecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        ContextUtil.setContext(context);
        if (f7598b == null) {
            synchronized (SecureX509SingleInstance.class) {
                if (f7598b == null) {
                    InputStream inputStreamOpen = null;
                    try {
                        inputStreamOpen = BksUtil.getFilesBksIS(context);
                    } catch (RuntimeException unused) {
                        e.b(f7597a, "get files bks error");
                    }
                    if (inputStreamOpen == null) {
                        e.c(f7597a, "get assets bks");
                        inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        e.c(f7597a, "get files bks");
                    }
                    f7598b = new SecureX509TrustManager(inputStreamOpen, "");
                }
            }
        }
        e.a(f7597a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f7598b;
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        e.c(f7597a, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f7598b != null) {
            f7598b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.a(f7598b);
            SecureApacheSSLSocketFactory.a(f7598b);
        }
        e.c(f7597a, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        e.c(f7597a, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f7598b != null) {
            f7598b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.a(f7598b, secureRandom);
            SecureApacheSSLSocketFactory.a(f7598b, secureRandom);
        }
        e.c(f7597a, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }
}
