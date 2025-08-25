package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.socialize.common.SocializeConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ai {

    /* renamed from: c, reason: collision with root package name */
    private static ai f9210c;

    /* renamed from: a, reason: collision with root package name */
    protected Context f9211a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f9212b = null;

    private ai(Context context) {
        this.f9211a = context;
    }

    public static ai a(Context context) {
        if (f9210c == null) {
            f9210c = new ai(context);
        }
        return f9210c;
    }

    private Map<String, String> b(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() >= 1) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    protected boolean a(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 307;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:135|24|25|(7:127|27|(1:29)(1:30)|31|139|32|38)(11:42|(3:121|44|(5:131|46|137|47|48)(9:56|57|58|129|59|60|133|61|62))(1:74)|117|75|76|(1:78)|119|79|123|80|103)|41|94|(1:96)|125|97|103) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0192, code lost:
    
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0197, code lost:
    
        if (com.tencent.bugly.proguard.an.a(r6) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0191, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0172 A[PHI: r5 r6 r10 r13 r14 r20
  0x0172: PHI (r5v4 int) = (r5v3 int), (r5v17 int) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r6v8 java.lang.Throwable) = (r6v7 java.lang.Throwable), (r6v12 java.lang.Throwable) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r10v8 int) = (r10v7 int), (r10v12 int) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r13v6 boolean) = (r13v5 boolean), (r13v13 boolean) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r14v3 java.lang.String) = (r14v2 java.lang.String), (r14v9 java.lang.String) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r20v2 long) = (r20v1 long), (r20v11 long) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018a A[Catch: all -> 0x017c, TRY_LEAVE, TryCatch #12 {all -> 0x017c, blocks: (B:24:0x009e, B:27:0x00a6, B:31:0x00b7, B:30:0x00b5, B:42:0x00d1, B:44:0x00d7, B:46:0x00df, B:59:0x0113, B:61:0x011d, B:75:0x013d, B:79:0x0163, B:94:0x0184, B:96:0x018a), top: B:135:0x009e }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.lang.String r23, byte[] r24, com.tencent.bugly.proguard.al r25, java.util.Map<java.lang.String, java.lang.String> r26) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ai.a(java.lang.String, byte[], com.tencent.bugly.proguard.al, java.util.Map):byte[]");
    }

    protected byte[] a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                ak.a().b(true);
                return null;
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    protected HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            an.e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection httpURLConnectionA = a(str2, str);
        if (httpURLConnectionA == null) {
            an.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            httpURLConnectionA.setRequestProperty("wup_version", SocializeConstants.PROTOCOL_VERSON);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnectionA.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            httpURLConnectionA.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            httpURLConnectionA.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return httpURLConnectionA;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            an.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    protected HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (ao.a() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(ao.a());
            } else if (str != null && str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (an.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
