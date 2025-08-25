package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<a<av>> f12461a = new AtomicReference<>(a());

    /* renamed from: a, reason: collision with other field name */
    public static final Pattern f197a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f12462b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f12463c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    private static class a<T> extends FutureTask<T> {

        /* renamed from: a, reason: collision with root package name */
        private long f12464a;

        public a(Callable<T> callable) {
            super(callable);
        }

        public boolean a() {
            return j.m627a(C0343r.m636a()) || (isDone() && Math.abs(SystemClock.elapsedRealtime() - this.f12464a) > 1800000);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f12464a = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    public static final class b extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private boolean f12465a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int i4;
            if (!this.f12465a && (i4 = super.read(bArr, i2, i3)) != -1) {
                return i4;
            }
            this.f12465a = true;
            return -1;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f12466a;

        /* renamed from: a, reason: collision with other field name */
        public Map<String, String> f198a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f12466a), this.f198a.toString());
        }
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static void b() {
        f12461a.set(a());
    }

    public static boolean c(Context context) {
        av avVarM144a = m144a();
        return avVarM144a != null && avVarM144a.m155a();
    }

    public static boolean d(Context context) {
        av avVarM144a = m144a();
        return avVarM144a != null && 1 == avVarM144a.a();
    }

    public static boolean e(Context context) {
        av avVarM145a = m145a(context);
        return avVarM145a != null && avVarM145a.a() == 0 && 20 == avVarM145a.b();
    }

    public static boolean f(Context context) {
        av avVarM145a = m145a(context);
        return avVarM145a != null && avVarM145a.a() == 0 && 13 == avVarM145a.b();
    }

    public static boolean g(Context context) {
        av avVarM145a = m145a(context);
        if (avVarM145a == null || avVarM145a.a() != 0) {
            return false;
        }
        String strM156b = avVarM145a.m156b();
        if (!"TD-SCDMA".equalsIgnoreCase(strM156b) && !"CDMA2000".equalsIgnoreCase(strM156b) && !"WCDMA".equalsIgnoreCase(strM156b)) {
            switch (avVarM145a.b()) {
            }
            return false;
        }
        return true;
    }

    public static boolean h(Context context) {
        av avVarM145a = m145a(context);
        if (avVarM145a == null || avVarM145a.a() != 0) {
            return false;
        }
        int iB = avVarM145a.b();
        return iB == 1 || iB == 2 || iB == 4 || iB == 7 || iB == 11;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m150a() {
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r4) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r1 = 0
            if (r0 == 0) goto L27
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 < r3) goto L22
            android.net.Network r2 = r0.getActiveNetwork()     // Catch: java.lang.Exception -> L27
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r2)     // Catch: java.lang.Exception -> L27
            if (r0 == 0) goto L27
            r2 = 16
            boolean r0 = r0.hasCapability(r2)     // Catch: java.lang.Exception -> L27
            goto L28
        L22:
            boolean r0 = m151a(r4)
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L31
            boolean r4 = c(r4)
            if (r4 == 0) goto L31
            r1 = 1
        L31:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.au.b(android.content.Context):boolean");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Object m146a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkRequest networkRequestBuild;
        ConnectivityManager.NetworkCallback networkCallback;
        if (context == null) {
            context = C0343r.m636a();
        }
        ConnectivityManager.NetworkCallback networkCallback2 = null;
        if (context == null || j.m627a(context) || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            networkRequestBuild = new NetworkRequest.Builder().build();
            networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.au.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    super.onAvailable(network2);
                    au.b();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    super.onLost(network2);
                    au.b();
                }
            };
        } catch (Throwable th) {
            th = th;
        }
        try {
            connectivityManager.registerNetworkCallback(networkRequestBuild, networkCallback);
            return networkCallback;
        } catch (Throwable th2) {
            th = th2;
            networkCallback2 = networkCallback;
            com.xiaomi.channel.commonutils.logger.b.m50a("exception occurred in adding network callback :" + th);
            return networkCallback2;
        }
    }

    public static void a(Context context, Object obj) {
        if (Build.VERSION.SDK_INT < 21) {
            com.xiaomi.channel.commonutils.logger.b.b("less than LOLLIPOP(21) not support channel ");
            return;
        }
        if (context == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof ConnectivityManager.NetworkCallback) {
                ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m50a("exception occurred in removing network callback :" + th);
        }
    }

    private static a<av> a() {
        return new a<>(new Callable<av>() { // from class: com.xiaomi.push.au.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public av call() {
                NetworkInfo activeNetworkInfo;
                Context contextM636a = C0343r.m636a();
                if (contextM636a == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) contextM636a.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new av(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* renamed from: a, reason: collision with other method in class */
    public static av m144a() {
        a<av> aVar = f12461a.get();
        if (aVar != null) {
            try {
                if (aVar.a()) {
                    AtomicReference<a<av>> atomicReference = f12461a;
                    a<av> aVarA = a();
                    atomicReference.set(aVarA);
                    aVar = aVarA;
                }
                if (!aVar.isDone()) {
                    aVar.run();
                }
                return aVar.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, c cVar) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException(com.umeng.analytics.pro.d.R);
        }
        if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection httpURLConnectionM148a = m148a(context, url2);
                httpURLConnectionM148a.setConnectTimeout(10000);
                httpURLConnectionM148a.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    httpURLConnectionM148a.setRequestProperty(HttpHeaders.USER_AGENT, str);
                }
                if (str2 != null) {
                    httpURLConnectionM148a.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        httpURLConnectionM148a.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (cVar != null && (url.getProtocol().equals(HttpConstant.HTTP) || url.getProtocol().equals(HttpConstant.HTTPS))) {
                    cVar.f12466a = httpURLConnectionM148a.getResponseCode();
                    if (cVar.f198a == null) {
                        cVar.f198a = new HashMap();
                    }
                    int i2 = 0;
                    while (true) {
                        String headerFieldKey = httpURLConnectionM148a.getHeaderFieldKey(i2);
                        String headerField = httpURLConnectionM148a.getHeaderField(i2);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                            cVar.f198a.put(headerFieldKey, headerField);
                        }
                        i2++;
                    }
                }
                return new b(httpURLConnectionM148a.getInputStream());
            } catch (IOException e2) {
                throw new IOException("IOException:" + e2.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }
        throw new IllegalArgumentException("url");
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) throws Throwable {
        InputStream inputStreamA;
        try {
            inputStreamA = a(context, url, z, str, str3);
        } catch (Throwable th) {
            th = th;
            inputStreamA = null;
        }
        try {
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamA, str2));
            char[] cArr = new char[4096];
            while (true) {
                int i2 = bufferedReader.read(cArr);
                if (-1 != i2) {
                    sb.append(cArr, 0, i2);
                } else {
                    w.a((Closeable) inputStreamA);
                    return sb.toString();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            w.a((Closeable) inputStreamA);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, ba.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) throws IOException {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, i2);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes(d.d.D);
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes(d.d.D);
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                stringBuffer.append(line);
                            } else {
                                String string = stringBuffer.toString();
                                w.a((Closeable) fileInputStream);
                                w.a(bufferedReader);
                                return string;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            w.a((Closeable) null);
            w.a((Closeable) file);
            throw th4;
        }
    }

    public static int a(Context context) {
        av avVarM144a = m144a();
        if (avVarM144a == null) {
            return -1;
        }
        return avVarM144a.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static HttpURLConnection m148a(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m151a(Context context) {
        return a(context) >= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static av m145a(Context context) {
        return m144a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m147a(Context context) {
        if (d(context)) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        av avVarM144a = m144a();
        if (avVarM144a == null) {
            return "";
        }
        return (avVarM144a.m154a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + avVarM144a.m156b()).toLowerCase();
    }

    public static as a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static as a(Context context, String str, String str2, Map<String, String> map, String str3) throws IOException {
        boolean zEqualsIgnoreCase;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        as asVar = new as();
        try {
            try {
                try {
                    HttpURLConnection httpURLConnectionM148a = m148a(context, m149a(str));
                    httpURLConnectionM148a.setConnectTimeout(10000);
                    httpURLConnectionM148a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    httpURLConnectionM148a.setRequestMethod(str4);
                    int i2 = 0;
                    if (map != null) {
                        zEqualsIgnoreCase = HttpConstant.GZIP.equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            httpURLConnectionM148a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        zEqualsIgnoreCase = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnectionM148a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (zEqualsIgnoreCase) {
                            outputStream = new GZIPOutputStream(httpURLConnectionM148a.getOutputStream());
                        } else {
                            outputStream = httpURLConnectionM148a.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    asVar.f12460a = httpURLConnectionM148a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.m50a("Http POST Response Code: " + asVar.f12460a);
                    while (true) {
                        String headerFieldKey = httpURLConnectionM148a.getHeaderFieldKey(i2);
                        String headerField = httpURLConnectionM148a.getHeaderField(i2);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM148a.getErrorStream())));
                            }
                        } else {
                            asVar.f196a.put(headerFieldKey, headerField);
                            i2 = i2 + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM148a.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            stringBuffer.append(line);
                            stringBuffer.append(property);
                        }
                        asVar.f195a = stringBuffer.toString();
                        bufferedReader.close();
                        w.a((Closeable) null);
                        w.a((Closeable) null);
                        return asVar;
                    } catch (IOException e3) {
                        e = e3;
                        throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                    } catch (Throwable th2) {
                        th = th2;
                        throw new IOException(th.getMessage());
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th4) {
            w.a((Closeable) null);
            w.a((Closeable) str2);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("Failed to convert from params map to string: " + e2);
                    com.xiaomi.channel.commonutils.logger.b.m50a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    private static URL m149a(String str) {
        return new URL(str);
    }
}
