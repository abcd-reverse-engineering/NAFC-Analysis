package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.h;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class c implements X509TrustManager {

    /* renamed from: c, reason: collision with root package name */
    private static final String f7629c = "WebViewX509TrustManger";

    /* renamed from: a, reason: collision with root package name */
    private X509Certificate f7630a;

    /* renamed from: b, reason: collision with root package name */
    private List<X509TrustManager> f7631b = new ArrayList();

    public c(Context context) {
        if (context == null) {
            throw new NullPointerException("WebViewX509TrustManger context is null");
        }
        ContextUtil.setContext(context);
        this.f7630a = new h(context).b();
        if (this.f7630a == null) {
            throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.c(f7629c, "checkClientTrusted");
        if (this.f7631b.isEmpty()) {
            throw new CertificateException("checkClientTrusted CertificateException");
        }
        this.f7631b.get(0).checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.c(f7629c, "checkServerTrusted");
        boolean zA = false;
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            e.a(f7629c, "checkServerTrusted " + i2 + " : " + x509CertificateArr[i2].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i3 = 0; i3 < x509CertificateArr.length; i3++) {
            x509CertificateArr2[i3] = x509CertificateArr[(x509CertificateArr.length - 1) - i3];
        }
        CertificateException e2 = new CertificateException("CBG root CA CertificateException");
        try {
            zA = com.huawei.secure.android.common.ssl.util.b.a(this.f7630a, x509CertificateArr2);
        } catch (InvalidKeyException e3) {
            e.b(f7629c, "checkServerTrusted InvalidKeyException: " + e3.getMessage());
        } catch (NoSuchAlgorithmException e4) {
            e.b(f7629c, "checkServerTrusted NoSuchAlgorithmException: " + e4.getMessage());
        } catch (NoSuchProviderException e5) {
            e.b(f7629c, "checkServerTrusted NoSuchProviderException: " + e5.getMessage());
        } catch (SignatureException e6) {
            e.b(f7629c, "checkServerTrusted SignatureException: " + e6.getMessage());
        } catch (CertificateException e7) {
            e2 = e7;
            e.b(f7629c, "checkServerTrusted CertificateException: " + e2.getMessage());
        }
        if (!zA) {
            throw e2;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f7631b.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            e.b(f7629c, "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }
}
