package com.umeng.ut.a.b;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes2.dex */
class f implements X509TrustManager {

    /* renamed from: a, reason: collision with root package name */
    private static TrustManager[] f11900a;

    f() {
    }

    static synchronized TrustManager[] getTrustManagers() {
        if (f11900a == null) {
            f11900a = new TrustManager[]{new f()};
        }
        return f11900a;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws NoSuchAlgorithmException, KeyStoreException, CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length <= 0) {
            throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
        }
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init((KeyStore) null);
            if (trustManagerFactory == null || trustManagerFactory.getTrustManagers() == null) {
                return;
            }
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                try {
                    ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
                } catch (CertificateException e2) {
                    for (Throwable cause = e2; cause != null; cause = cause.getCause()) {
                        if ((cause instanceof CertificateExpiredException) || (cause instanceof CertificateNotYetValidException)) {
                            return;
                        }
                    }
                    throw e2;
                }
            }
        } catch (KeyStoreException e3) {
            throw new CertificateException(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new CertificateException(e4);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
