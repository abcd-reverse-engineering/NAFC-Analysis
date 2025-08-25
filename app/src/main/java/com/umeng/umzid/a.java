package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.tencent.bugly.BuglyStrategy;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* loaded from: classes2.dex */
public class a {
    public static SharedPreferences a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("umzid_general_config", 0);
        }
        return null;
    }

    public static synchronized String a(String str, String str2) {
        byte[] byteArray;
        try {
            String host = Uri.parse(str).getHost();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setHostnameVerifier(new b(host));
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
            httpsURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
            httpsURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            byte[] bytes = str2.getBytes();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                byteArray = null;
            }
            outputStream.write(a(byteArray, "7EC2papS9acZxgIb".getBytes()));
            outputStream.flush();
            outputStream.close();
            if (httpsURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        return new String(a(byteArrayOutputStream2.toByteArray(), "7EC2papS9acZxgIb".getBytes()));
                    }
                    byteArrayOutputStream2.write(bArr, 0, i2);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) ((bArr[i2] ^ bArr2[i2 % bArr2.length]) ^ (i2 & 255));
            }
        }
        return bArr;
    }
}
