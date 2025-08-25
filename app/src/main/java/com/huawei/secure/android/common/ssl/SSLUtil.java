package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.e;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public abstract class SSLUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7559a = "SSLUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7560b = "TLSv1.3";

    /* renamed from: c, reason: collision with root package name */
    private static final String f7561c = "TLSv1.2";

    /* renamed from: d, reason: collision with root package name */
    private static final String f7562d = "TLS";

    /* renamed from: e, reason: collision with root package name */
    private static final String f7563e = "TLSv1";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f7564f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f7565g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f7566h = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static String[] getEnabledCipherSuites(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] getEnabledProtocols(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void printTLSAndCipher(SSLSocket sSLSocket) {
        for (String str : sSLSocket.getEnabledProtocols()) {
            e.c(f7559a, "new enable protocols is : " + str);
        }
        for (String str2 : sSLSocket.getEnabledCipherSuites()) {
            e.c(f7559a, "new cipher suites is : " + str2);
        }
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setBlackListCipherSuites(sSLSocket, f7566h);
    }

    public static void setEnableSafeCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null || setWhiteListCipherSuites(sSLSocket)) {
            return;
        }
        setBlackListCipherSuites(sSLSocket);
    }

    public static void setEnabledProtocols(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            sSLSocket.setEnabledProtocols(new String[]{f7560b, f7561c});
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && i2 < 29) {
            sSLSocket.setEnabledProtocols(new String[]{f7561c});
        } else if (Build.VERSION.SDK_INT < 16) {
            sSLSocket.setEnabledProtocols(new String[]{f7563e});
        }
    }

    public static SSLContext setSSLContext() throws NoSuchAlgorithmException {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 29 ? SSLContext.getInstance(f7560b) : i2 >= 16 ? SSLContext.getInstance(f7561c) : SSLContext.getInstance(f7562d);
    }

    public static void setSSLSocketOptions(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        setEnabledProtocols(sSLSocket);
        setEnableSafeCipherSuites(sSLSocket);
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return Build.VERSION.SDK_INT > 19 ? setWhiteListCipherSuites(sSLSocket, f7565g) : setWhiteListCipherSuites(sSLSocket, f7564f);
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= length) {
                break;
            }
            String str = enabledCipherSuites[i2];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z = false;
                    break;
                }
                if (upperCase.contains(strArr[i3].toUpperCase(Locale.ENGLISH))) {
                    break;
                }
                i3++;
            }
            if (!z) {
                arrayList.add(str);
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List listAsList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (listAsList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setEnabledProtocols(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e2) {
                e.b(f7559a, "setEnabledProtocols: exception : " + e2.getMessage());
            }
        }
        return false;
    }
}
