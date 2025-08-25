package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* compiled from: HttpManager.java */
/* loaded from: classes2.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static HostnameVerifier f10047a;

    private static HostnameVerifier a() {
        if (f10047a == null) {
            f10047a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.am.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str);
                }
            };
        }
        return f10047a;
    }

    public static void b(String str, byte[] bArr) {
        byte[] bArrA;
        HttpsURLConnection httpsURLConnectionA = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                as.a(bArr, byteArrayOutputStream);
                bArrA = as.a(byteArrayOutputStream.toByteArray(), UMConfigure.sAppkey.getBytes());
            } catch (Throwable unused) {
                bArrA = null;
            }
            httpsURLConnectionA = a(str, "appkey", bArrA);
            if (httpsURLConnectionA != null) {
                int responseCode = httpsURLConnectionA.getResponseCode();
                if (responseCode != 200) {
                    String str2 = "SC event report error, http error code: " + responseCode;
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "SC event report successful.");
                }
            }
            if (httpsURLConnectionA == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        httpsURLConnectionA.disconnect();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
        try {
            httpsURLConnectionA.disconnect();
        } catch (Throwable unused3) {
        }
    }

    public static byte[] a(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] streamToByteArray;
        byte[] bArrA = null;
        try {
            HttpsURLConnection httpsURLConnectionA = a(str, SocializeProtocolConstants.PROTOCOL_KEY_AK, as.a(bArr, UMConfigure.sAppkey.getBytes()));
            if (httpsURLConnectionA != null && httpsURLConnectionA.getResponseCode() == 200) {
                InputStream inputStream = httpsURLConnectionA.getInputStream();
                try {
                    streamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String headerField = httpsURLConnectionA.getHeaderField(SocializeProtocolConstants.PROTOCOL_KEY_AK);
                    if (!TextUtils.isEmpty(headerField)) {
                        bArrA = as.a(streamToByteArray, headerField.getBytes());
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                    }
                    HelperUtils.safeClose(inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(inputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
        return bArrA;
    }

    private static HttpsURLConnection a(String str, String str2, byte[] bArr) throws NoSuchAlgorithmException, IOException, KeyManagementException {
        HttpsURLConnection httpsURLConnection;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(a());
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(15000);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setReadTimeout(15000);
                httpsURLConnection.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                httpsURLConnection.addRequestProperty(str2, UMConfigure.sAppkey);
                httpsURLConnection.connect();
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return httpsURLConnection;
            }
        } catch (Exception e3) {
            e = e3;
            httpsURLConnection = null;
        }
        return httpsURLConnection;
    }
}
