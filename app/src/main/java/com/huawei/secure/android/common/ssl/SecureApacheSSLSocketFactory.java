package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* loaded from: classes.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i, reason: collision with root package name */
    private static final String f7567i = SecureApacheSSLSocketFactory.class.getSimpleName();

    /* renamed from: j, reason: collision with root package name */
    private static volatile SecureApacheSSLSocketFactory f7568j = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f7569a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f7570b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7571c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f7572d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f7573e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f7574f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f7575g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f7576h;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException {
        super(keyStore);
        this.f7570b = null;
    }

    @Deprecated
    static void a(X509TrustManager x509TrustManager) {
        e.c(f7567i, "sasf update socket factory trust manager");
        try {
            f7568j = new SecureApacheSSLSocketFactory(null, x509TrustManager);
        } catch (IOException unused) {
            e.b(f7567i, "IOException");
        } catch (KeyManagementException unused2) {
            e.b(f7567i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            e.b(f7567i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            e.b(f7567i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            e.b(f7567i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            e.b(f7567i, "CertificateException");
        }
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f7568j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f7568j == null) {
                    f7568j = new SecureApacheSSLSocketFactory(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f7568j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f7567i, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.f7569a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7570b = (SSLSocket) socketCreateSocket;
            this.f7572d = (String[]) this.f7570b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f7574f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f7573e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f7571c;
    }

    public String[] getProtocols() {
        return this.f7576h;
    }

    public SSLContext getSslContext() {
        return this.f7569a;
    }

    public SSLSocket getSslSocket() {
        return this.f7570b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f7572d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f7575g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f7573e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f7574f = strArr;
    }

    public void setContext(Context context) {
        this.f7571c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f7576h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f7569a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f7570b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f7575g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f7573e = x509TrustManager;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f7570b = null;
        if (context == null) {
            e.b(f7567i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f7573e = SecureX509SingleInstance.getInstance(context);
        this.f7569a.init(null, new X509TrustManager[]{this.f7573e}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.c(f7567i, "createSocket: ");
        Socket socketCreateSocket = this.f7569a.getSocketFactory().createSocket();
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7570b = (SSLSocket) socketCreateSocket;
            this.f7572d = (String[]) this.f7570b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f7568j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f7568j == null) {
                    f7568j = new SecureApacheSSLSocketFactory(keyStore, context, secureRandom);
                }
            }
        }
        return f7568j;
    }

    static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f7567i, "sasf update socket factory trust manager");
        try {
            f7568j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager, secureRandom);
        } catch (IOException unused) {
            e.b(f7567i, "IOException");
        } catch (KeyManagementException unused2) {
            e.b(f7567i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            e.b(f7567i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            e.b(f7567i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            e.b(f7567i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            e.b(f7567i, "CertificateException");
        }
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f7570b = null;
        this.f7569a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f7569a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f7570b = null;
        this.f7569a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f7569a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7576h)) {
            z = false;
        } else {
            e.c(f7567i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f7576h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7575g) && com.huawei.secure.android.common.ssl.util.a.a(this.f7574f)) {
            z2 = false;
        } else {
            e.c(f7567i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f7575g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f7575g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f7574f);
            }
        }
        if (!z) {
            e.c(f7567i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f7567i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f7570b = null;
        this.f7569a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7569a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f7570b = null;
        this.f7569a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7569a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
