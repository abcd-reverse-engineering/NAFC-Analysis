package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f7537i = SASFCompatiableSystemCA.class.getSimpleName();

    /* renamed from: j, reason: collision with root package name */
    private static volatile SASFCompatiableSystemCA f7538j = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f7539a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f7540b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7541c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f7542d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f7543e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f7544f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f7545g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f7546h;

    private SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException {
        super(keyStore);
        this.f7540b = null;
    }

    @Deprecated
    static void a(X509TrustManager x509TrustManager) {
        e.c(f7537i, "sasfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f7538j = new SASFCompatiableSystemCA(null, x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f7537i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            e.b(f7537i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            e.b(f7537i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            e.b(f7537i, "UnrecoverableKeyException");
        }
        e.a(f7537i, "sasf system ca update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Deprecated
    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f7538j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f7538j == null) {
                    f7538j = new SASFCompatiableSystemCA(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f7538j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f7537i, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.f7539a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7540b = (SSLSocket) socketCreateSocket;
            this.f7542d = (String[]) this.f7540b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f7544f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f7543e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f7541c;
    }

    public String[] getProtocols() {
        return this.f7546h;
    }

    public SSLContext getSslContext() {
        return this.f7539a;
    }

    public SSLSocket getSslSocket() {
        return this.f7540b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f7542d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f7545g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f7543e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f7544f = strArr;
    }

    public void setContext(Context context) {
        this.f7541c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f7546h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f7539a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f7540b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f7545g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f7543e = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f7540b = null;
        if (context == null) {
            e.b(f7537i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f7543e = SSFSecureX509SingleInstance.getInstance(context);
        this.f7539a.init(null, new X509TrustManager[]{this.f7543e}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.c(f7537i, "createSocket: ");
        Socket socketCreateSocket = this.f7539a.getSocketFactory().createSocket();
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7540b = (SSLSocket) socketCreateSocket;
            this.f7542d = (String[]) this.f7540b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f7538j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f7538j == null) {
                    f7538j = new SASFCompatiableSystemCA(keyStore, context, secureRandom);
                }
            }
        }
        return f7538j;
    }

    static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f7537i, "sasfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f7538j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f7537i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            e.b(f7537i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            e.b(f7537i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            e.b(f7537i, "UnrecoverableKeyException");
        }
        e.a(f7537i, "sasf system ca update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Deprecated
    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException, IllegalArgumentException {
        super(keyStore);
        this.f7540b = null;
        this.f7539a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7539a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException, IllegalArgumentException {
        super(keyStore);
        this.f7540b = null;
        this.f7539a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7539a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7546h)) {
            z = false;
        } else {
            e.c(f7537i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f7546h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7545g) && com.huawei.secure.android.common.ssl.util.a.a(this.f7544f)) {
            z2 = false;
        } else {
            e.c(f7537i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f7545g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f7545g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f7544f);
            }
        }
        if (!z) {
            e.c(f7537i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f7537i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }
}
