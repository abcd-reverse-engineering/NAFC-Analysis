package com.umeng.socialize.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.tencent.bugly.BuglyStrategy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: NetClient.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11549a = "NetClient";

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z) throws Exception {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (m.a() && (z || a.f11537c)) {
                m.a(f11549a, "req: ", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (m.a() && (z || a.f11537c)) {
                m.a(f11549a, "req: ", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            throw th;
        }
    }

    private static String a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream errorStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(str.getBytes(), byteArrayOutputStream);
        byte[] bArrA = i.a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
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
            c.a(outputStream);
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
                        c.a(errorStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] bArrA2 = i.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                l.b(bArrA2, byteArrayOutputStream);
            }
            String string = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return string;
            }
            throw new IOException("code:" + responseCode + " msg:" + string);
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(org.json.JSONObject r16, java.lang.String r17, java.lang.String r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.a.d.a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }
}
