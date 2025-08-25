package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f7587i = "SSLFNew";

    /* renamed from: j, reason: collision with root package name */
    private static volatile SecureSSLSocketFactoryNew f7588j;

    /* renamed from: a, reason: collision with root package name */
    protected SSLContext f7589a;

    /* renamed from: b, reason: collision with root package name */
    protected SSLSocket f7590b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f7591c;

    /* renamed from: d, reason: collision with root package name */
    protected String[] f7592d;

    /* renamed from: e, reason: collision with root package name */
    protected X509TrustManager f7593e;

    /* renamed from: f, reason: collision with root package name */
    protected String[] f7594f;

    /* renamed from: g, reason: collision with root package name */
    protected String[] f7595g;

    /* renamed from: h, reason: collision with root package name */
    protected String[] f7596h;

    @Deprecated
    public SecureSSLSocketFactoryNew(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f7589a = null;
        this.f7590b = null;
        this.f7589a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f7589a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7596h)) {
            z = false;
        } else {
            e.c(f7587i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f7596h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f7595g) && com.huawei.secure.android.common.ssl.util.a.a(this.f7594f)) {
            z2 = false;
        } else {
            e.c(f7587i, "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (com.huawei.secure.android.common.ssl.util.a.a(this.f7595g)) {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f7594f);
            } else {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f7595g);
            }
        }
        if (!z) {
            e.c(f7587i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f7587i, "set default cipher");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public static SecureSSLSocketFactoryNew getInstance(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f7588j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f7588j == null) {
                    f7588j = new SecureSSLSocketFactoryNew(context, (SecureRandom) null);
                }
            }
        }
        if (f7588j.f7591c == null && context != null) {
            f7588j.setContext(context);
        }
        e.a(f7587i, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f7588j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.c(f7587i, "createSocket: host , port");
        Socket socketCreateSocket = this.f7589a.getSocketFactory().createSocket(str, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7590b = (SSLSocket) socketCreateSocket;
            this.f7592d = (String[]) this.f7590b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f7594f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f7593e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f7591c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f7596h;
    }

    public SSLContext getSslContext() {
        return this.f7589a;
    }

    public SSLSocket getSslSocket() {
        return this.f7590b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f7592d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f7595g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f7593e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f7594f = strArr;
    }

    public void setContext(Context context) {
        this.f7591c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f7596h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f7589a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f7595g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f7593e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public SecureSSLSocketFactoryNew(InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f7589a = null;
        this.f7590b = null;
        this.f7589a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f7589a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f7587i, "createSocket");
        Socket socketCreateSocket = this.f7589a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f7590b = (SSLSocket) socketCreateSocket;
            this.f7592d = (String[]) this.f7590b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SecureSSLSocketFactoryNew getInstance(Context context, SecureRandom secureRandom) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f7588j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f7588j == null) {
                    f7588j = new SecureSSLSocketFactoryNew(context, secureRandom);
                }
            }
        }
        if (f7588j.f7591c == null && context != null) {
            f7588j.setContext(context);
        }
        e.a(f7587i, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f7588j;
    }

    private SecureSSLSocketFactoryNew(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException {
        this.f7589a = null;
        this.f7590b = null;
        if (context == null) {
            e.b(f7587i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f7593e = SecureX509SingleInstance.getInstance(context);
        this.f7589a.init(null, new X509TrustManager[]{this.f7593e}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f7589a = null;
        this.f7590b = null;
        this.f7589a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7589a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f7589a = null;
        this.f7590b = null;
        this.f7589a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f7589a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
