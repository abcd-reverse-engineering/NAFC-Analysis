package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class SecureX509TrustManager implements X509TrustManager {

    /* renamed from: c, reason: collision with root package name */
    private static final String f7599c = "SX509TM";

    /* renamed from: d, reason: collision with root package name */
    public static final String f7600d = "hmsrootcas.bks";

    /* renamed from: e, reason: collision with root package name */
    private static final String f7601e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final String f7602f = "X509";

    /* renamed from: g, reason: collision with root package name */
    private static final String f7603g = "bks";

    /* renamed from: h, reason: collision with root package name */
    private static final String f7604h = "AndroidCAStore";

    /* renamed from: a, reason: collision with root package name */
    protected List<X509TrustManager> f7605a;

    /* renamed from: b, reason: collision with root package name */
    private X509Certificate[] f7606b;

    public SecureX509TrustManager(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    private void a() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        e.c(f7599c, "loadSystemCA");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance(f7604h);
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f7602f);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (int i2 = 0; i2 < trustManagers.length; i2++) {
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.f7605a.add((X509TrustManager) trustManagers[i2]);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            e.b(f7599c, "loadSystemCA: exception : " + e2.getMessage());
        }
        e.a(f7599c, "loadSystemCA: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.c(f7599c, "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.f7605a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e2) {
                e.b(f7599c, "checkServerTrusted CertificateException" + e2.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        e.c(f7599c, "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            e.a(f7599c, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            e.a(f7599c, "IssuerDN :" + x509Certificate.getIssuerDN());
            e.a(f7599c, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.f7605a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                e.c(f7599c, "check server i=" + i2);
                X509TrustManager x509TrustManager = this.f7605a.get(i2);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    e.c(f7599c, "client root ca size=" + acceptedIssuers.length);
                    for (X509Certificate x509Certificate2 : acceptedIssuers) {
                        e.a(f7599c, "client root ca getIssuerDN :" + x509Certificate2.getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                e.c(f7599c, "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e2) {
                e.b(f7599c, "checkServerTrusted error :" + e2.getMessage() + " , time : " + i2);
                if (i2 == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        e.b(f7599c, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e2;
                }
            }
        }
        e.a(f7599c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f7605a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            e.b(f7599c, "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }

    public X509Certificate[] getChain() {
        return this.f7606b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.f7605a;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.f7606b = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.f7605a = list;
    }

    public SecureX509TrustManager(Context context, boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, IllegalArgumentException {
        this.f7605a = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        ContextUtil.setContext(context);
        if (z) {
            a();
        }
        a(context);
        if (this.f7605a.isEmpty()) {
            throw new CertificateException("X509TrustManager is empty");
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IOException, IllegalArgumentException {
        this.f7605a = new ArrayList();
        a(inputStream, str);
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    private void a(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        boolean z;
        e.c(f7599c, "loadBksCA");
        long jCurrentTimeMillis = System.currentTimeMillis();
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                e.c(f7599c, "get bks not from assets");
                a(filesBksIS);
                z = true;
            } catch (IOException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                e.b(f7599c, "loadBksCA: exception : " + e2.getMessage());
                z = false;
            }
        } else {
            z = true;
        }
        if (!z || filesBksIS == null) {
            e.c(f7599c, " get bks from assets ");
            a(context.getAssets().open("hmsrootcas.bks"));
        }
        e.a(f7599c, "loadBksCA: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    public SecureX509TrustManager(String str, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        this.f7605a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            a(fileInputStream, "");
            d.a((InputStream) fileInputStream);
            if (z) {
                a();
            }
        } catch (Throwable th2) {
            th = th2;
            d.a((InputStream) fileInputStream);
            throw th;
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, IllegalArgumentException {
        this.f7605a = new ArrayList();
        if (z) {
            a();
        }
        a(inputStream, str);
    }

    private void a(InputStream inputStream) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f7602f);
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (int i2 = 0; i2 < trustManagers.length; i2++) {
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.f7605a.add((X509TrustManager) trustManagers[i2]);
                }
            }
        } finally {
            d.a(inputStream);
        }
    }

    private void a(InputStream inputStream, String str) throws IOException {
        if (inputStream != null && str != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f7602f);
                    KeyStore keyStore = KeyStore.getInstance("bks");
                    keyStore.load(inputStream, str.toCharArray());
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    for (int i2 = 0; i2 < trustManagers.length; i2++) {
                        if (trustManagers[i2] instanceof X509TrustManager) {
                            this.f7605a.add((X509TrustManager) trustManagers[i2]);
                        }
                    }
                    d.a(inputStream);
                } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                    e.b(f7599c, "loadInputStream: exception : " + e2.getMessage());
                }
                e.a(f7599c, "loadInputStream: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                return;
            } finally {
                d.a(inputStream);
            }
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }
}
