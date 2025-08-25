package com.umeng.ut.a.b;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
class e extends SSLSocketFactory {

    /* renamed from: b, reason: collision with root package name */
    private String f11899b;

    /* renamed from: a, reason: collision with root package name */
    private Method f11898a = null;
    private HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

    public e(String str) {
        this.f11899b = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        SSLSocket sSLSocket;
        com.umeng.ut.a.c.e.b("", "peerHost", this.f11899b, Constants.KEY_HOST, str, "port", Integer.valueOf(i2), "autoClose", Boolean.valueOf(z));
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        if (Build.VERSION.SDK_INT < 24) {
            sSLCertificateSocketFactory.setTrustManagers(f.getTrustManagers());
        } else {
            sSLCertificateSocketFactory.setTrustManagers(c.getTrustManagers());
        }
        com.umeng.ut.a.c.e.m44a("", "createSocket");
        if (Build.VERSION.SDK_INT < 23) {
            InetAddress inetAddress = socket.getInetAddress();
            if (z) {
                socket.close();
            }
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
        } else {
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f11899b, i2, true);
        }
        com.umeng.ut.a.c.e.m44a("", "createSocket end");
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f11899b);
        } else {
            try {
                if (this.f11898a == null) {
                    this.f11898a = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.f11898a.setAccessible(true);
                }
                this.f11898a.invoke(sSLSocket, this.f11899b);
            } catch (Exception e2) {
                com.umeng.ut.a.c.e.m44a("", "SNI not useable", e2);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (this.hostnameVerifier.verify(this.f11899b, session)) {
            com.umeng.ut.a.c.e.b("", "SSLSession PeerHost", session.getPeerHost());
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + this.f11899b);
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f11899b) || !(obj instanceof e)) {
            return false;
        }
        String str = ((e) obj).f11899b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f11899b.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
