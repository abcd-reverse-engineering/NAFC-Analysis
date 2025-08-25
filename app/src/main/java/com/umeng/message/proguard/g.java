package com.umeng.message.proguard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.message.common.UPLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g {
    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z) throws Exception {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (UPLog.isEnable() && z) {
                UPLog.d("Net", "req:", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (UPLog.isEnable() && z) {
                UPLog.d("Net", "req:", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(JSONObject jSONObject, String str, String str2) throws Exception {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream;
        String string = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bc.a(string.getBytes(), byteArrayOutputStream);
        byte[] bArrA = ay.a(byteArrayOutputStream.toByteArray(), bytes);
        SystemClock.elapsedRealtime();
        InputStream inputStream2 = null;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                httpURLConnection2.addRequestProperty("Connection", "close");
                httpURLConnection2.addRequestProperty("appkey", str2);
                httpURLConnection2.setFixedLengthStreamingMode(bArrA.length);
                httpURLConnection2.setDoOutput(true);
                outputStream = httpURLConnection2.getOutputStream();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            httpURLConnection = null;
        }
        try {
            outputStream.write(bArrA);
            int responseCode = httpURLConnection2.getResponseCode();
            inputStream2 = responseCode < 400 ? httpURLConnection2.getInputStream() : httpURLConnection2.getErrorStream();
            byteArrayOutputStream.reset();
            if (inputStream2 != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = inputStream2.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                }
            }
            f.a(outputStream);
            f.a(inputStream2);
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.disconnect();
                } catch (Throwable unused) {
                }
            }
            if (responseCode == 200) {
                byte[] bArrA2 = ay.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                bc.b(bArrA2, byteArrayOutputStream);
            }
            if (responseCode != 200) {
                throw new Exception("response code:".concat(String.valueOf(responseCode)));
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = httpURLConnection2;
            inputStream = inputStream2;
            inputStream2 = outputStream;
            f.a(inputStream2);
            f.a(inputStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    public static JSONObject a(JSONObject jSONObject, String str, String str2) throws Exception {
        try {
            return a(jSONObject, str, str2, true);
        } catch (UnknownHostException unused) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String host = new URL(str).getHost();
            String strA = au.a("174658", host);
            if (strA == null) {
                return null;
            }
            URL url = new URL(str.replaceFirst(host, strA));
            String string = jSONObject.toString();
            try {
                final HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Host", host);
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.umeng.message.proguard.g.1
                        @Override // javax.net.ssl.HostnameVerifier
                        public final boolean verify(String str3, SSLSession sSLSession) {
                            String requestProperty = httpURLConnection.getRequestProperty("Host");
                            if (requestProperty == null) {
                                requestProperty = httpURLConnection.getURL().getHost();
                            }
                            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
                        }
                    });
                }
                JSONObject jSONObject2 = new JSONObject(a(string, httpURLConnection, str2));
                if (UPLog.isEnable()) {
                    UPLog.d("Net", "req:", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                }
                return jSONObject2;
            } catch (Throwable th) {
                if (UPLog.isEnable()) {
                    UPLog.d("Net", "req:", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                }
                throw th;
            }
        }
    }

    private static String a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream errorStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bc.a(str.getBytes(), byteArrayOutputStream);
        byte[] bArrA = ay.a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("Connection", "close");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(bArrA.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            outputStream.write(bArrA);
            f.a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                errorStream = httpURLConnection.getInputStream();
            } else {
                errorStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (errorStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int i2 = errorStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    } finally {
                        f.a(errorStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] bArrA2 = ay.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                bc.b(bArrA2, byteArrayOutputStream);
            }
            String string = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return string;
            }
            throw new IOException("code:" + responseCode + "msg:" + string);
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(org.json.JSONObject r16, java.lang.String r17, java.lang.String r18, java.io.File r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.g.a(org.json.JSONObject, java.lang.String, java.lang.String, java.io.File):org.json.JSONObject");
    }
}
