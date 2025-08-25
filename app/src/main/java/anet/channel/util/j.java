package anet.channel.util;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class j extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final String f2063a = "awcn.TlsSniSocketFactory";

    /* renamed from: b, reason: collision with root package name */
    private Method f2064b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f2065c;

    public j(String str) {
        this.f2065c = str;
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
        if (this.f2065c == null) {
            this.f2065c = str;
        }
        if (ALog.isPrintLog(1)) {
            ALog.i("awcn.TlsSniSocketFactory", "customized createSocket", null, Constants.KEY_HOST, this.f2065c);
        }
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f2065c);
        } else {
            try {
                if (this.f2064b == null) {
                    this.f2064b = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.f2064b.setAccessible(true);
                }
                this.f2064b.invoke(sSLSocket, this.f2065c);
            } catch (Exception e2) {
                ALog.w("awcn.TlsSniSocketFactory", "SNI not useable", null, e2, new Object[0]);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TlsSniSocketFactory", null, null, "SSLSession PeerHost", session.getPeerHost());
        }
        return sSLSocket;
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
