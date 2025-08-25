package anet.channel.session;

import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b {

    /* compiled from: Taobao */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1883a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f1884b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, List<String>> f1885c;

        /* renamed from: d, reason: collision with root package name */
        public int f1886d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1887e;
    }

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0346 A[Catch: all -> 0x0272, TRY_LEAVE, TryCatch #7 {all -> 0x0272, blocks: (B:12:0x0032, B:14:0x003c, B:15:0x0083, B:17:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:32:0x0175, B:33:0x0189, B:35:0x01ad, B:37:0x01b3, B:39:0x01b9, B:41:0x01bf, B:44:0x01c6, B:46:0x01e5, B:48:0x01f5, B:49:0x01fc, B:53:0x0219, B:55:0x0230, B:57:0x024b, B:51:0x020a, B:52:0x0211, B:108:0x031b, B:110:0x0346, B:120:0x0383, B:122:0x03ae, B:75:0x0278, B:77:0x027e, B:78:0x0282, B:80:0x028a, B:82:0x029e, B:81:0x0299, B:90:0x02bf, B:98:0x02f4, B:130:0x03e8, B:138:0x0410, B:146:0x0436, B:154:0x045c), top: B:175:0x0032, inners: #12, #15, #19, #20, #22, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03ae A[Catch: all -> 0x0272, TRY_LEAVE, TryCatch #7 {all -> 0x0272, blocks: (B:12:0x0032, B:14:0x003c, B:15:0x0083, B:17:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:32:0x0175, B:33:0x0189, B:35:0x01ad, B:37:0x01b3, B:39:0x01b9, B:41:0x01bf, B:44:0x01c6, B:46:0x01e5, B:48:0x01f5, B:49:0x01fc, B:53:0x0219, B:55:0x0230, B:57:0x024b, B:51:0x020a, B:52:0x0211, B:108:0x031b, B:110:0x0346, B:120:0x0383, B:122:0x03ae, B:75:0x0278, B:77:0x027e, B:78:0x0282, B:80:0x028a, B:82:0x029e, B:81:0x0299, B:90:0x02bf, B:98:0x02f4, B:130:0x03e8, B:138:0x0410, B:146:0x0436, B:154:0x045c), top: B:175:0x0032, inners: #12, #15, #19, #20, #22, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x036c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static anet.channel.session.b.a a(anet.channel.request.Request r22, anet.channel.RequestCb r23) {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.b.a(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.session.b$a");
    }

    private static void a(Request request, a aVar, RequestCb requestCb, int i2, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i2);
        ALog.e("awcn.HttpConnector", "onException", request.getSeq(), Constants.KEY_ERROR_CODE, Integer.valueOf(i2), "errMsg", errMsg, "url", request.getUrlString(), Constants.KEY_HOST, request.getHost());
        if (aVar != null) {
            aVar.f1883a = i2;
        }
        if (!request.f1841a.isDone.get()) {
            RequestStatistic requestStatistic = request.f1841a;
            requestStatistic.statusCode = i2;
            requestStatistic.msg = errMsg;
            requestStatistic.rspEnd = System.currentTimeMillis();
            if (i2 != -204) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(i2, errMsg, request.f1841a, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i2, errMsg, request.f1841a);
        }
    }

    private static HttpURLConnection a(Request request) throws IOException {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> wifiProxy = NetworkStatusHelper.getWifiProxy();
        Proxy proxy = wifiProxy != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) wifiProxy.first, ((Integer) wifiProxy.second).intValue())) : null;
        anet.channel.util.g gVarA = anet.channel.util.g.a();
        if (NetworkStatusHelper.getStatus().isMobile() && gVarA != null) {
            proxy = gVarA.b();
        }
        URL url = request.getUrl();
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(request.getConnectTimeout());
        httpURLConnection.setReadTimeout(request.getReadTimeout());
        httpURLConnection.setRequestMethod(request.getMethod());
        if (request.containsBody()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> headers = request.getHeaders();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        String host = headers.get("Host");
        if (host == null) {
            host = request.getHost();
        }
        String strConcatString = request.getHttpUrl().containsNonDefaultPort() ? StringUtils.concatString(host, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, String.valueOf(request.getHttpUrl().getPort())) : host;
        httpURLConnection.setRequestProperty("Host", strConcatString);
        if (NetworkStatusHelper.getApn().equals("cmwap")) {
            httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, strConcatString);
        }
        if (!headers.containsKey(HttpConstant.ACCEPT_ENCODING)) {
            httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
        }
        if (gVarA != null) {
            httpURLConnection.setRequestProperty("Authorization", gVarA.c());
        }
        if (url.getProtocol().equalsIgnoreCase(HttpConstant.HTTPS)) {
            a(httpURLConnection, request, host);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else {
            SSLSocketFactory sSLSocketFactory = anet.channel.util.b.f2045a;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                if (ALog.isPrintLog(2)) {
                    ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "SslSocketFactory", anet.channel.util.b.f2045a);
                }
            }
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
            return;
        }
        HostnameVerifier hostnameVerifier = anet.channel.util.b.f2046b;
        if (hostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "HostnameVerifier", anet.channel.util.b.f2046b);
                return;
            }
            return;
        }
        httpsURLConnection.setHostnameVerifier(new c(str));
    }

    private static int a(HttpURLConnection httpURLConnection, Request request) throws IOException {
        int i2 = 0;
        if (request.containsBody()) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    int iPostBody = request.postBody(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e2, new Object[0]);
                        }
                    }
                    i2 = iPostBody;
                } catch (Exception e3) {
                    ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), e3, new Object[0]);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e4) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e4, new Object[0]);
                        }
                    }
                }
                RequestStatistic requestStatistic = request.f1841a;
                long j2 = i2;
                requestStatistic.reqBodyInflateSize = j2;
                requestStatistic.reqBodyDeflateSize = j2;
                requestStatistic.sendDataSize = j2;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e5) {
                        ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e5, new Object[0]);
                    }
                }
                throw th;
            }
        }
        return i2;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, a aVar, RequestCb requestCb) throws Throwable {
        InputStream errorStream;
        ByteArrayOutputStream byteArrayOutputStream;
        anet.channel.util.a aVar2;
        httpURLConnection.getURL().toString();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                ALog.w("awcn.HttpConnector", "File not found", request.getSeq(), "url", request.getUrlString());
            }
            try {
                errorStream = httpURLConnection.getErrorStream();
            } catch (Exception e3) {
                ALog.e("awcn.HttpConnector", "get error stream failed.", request.getSeq(), e3, new Object[0]);
                errorStream = null;
            }
        }
        if (errorStream == null) {
            a(request, aVar, requestCb, -404, null);
            return;
        }
        if (requestCb == null) {
            int i2 = aVar.f1886d;
            if (i2 <= 0) {
                i2 = 1024;
            } else if (aVar.f1887e) {
                i2 *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i2);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            aVar2 = new anet.channel.util.a(errorStream);
        } catch (Throwable th) {
            th = th;
            aVar2 = null;
        }
        try {
            InputStream gZIPInputStream = aVar.f1887e ? new GZIPInputStream(aVar2) : aVar2;
            ByteArray byteArrayA = null;
            while (!Thread.currentThread().isInterrupted()) {
                if (byteArrayA == null) {
                    byteArrayA = a.C0012a.f1691a.a(2048);
                }
                int from = byteArrayA.readFrom(gZIPInputStream);
                if (from != -1) {
                    if (byteArrayOutputStream != null) {
                        byteArrayA.writeTo(byteArrayOutputStream);
                    } else {
                        requestCb.onDataReceive(byteArrayA, false);
                        byteArrayA = null;
                    }
                    long j2 = from;
                    request.f1841a.recDataSize += j2;
                    request.f1841a.rspBodyInflateSize += j2;
                } else {
                    if (byteArrayOutputStream != null) {
                        byteArrayA.recycle();
                    } else {
                        requestCb.onDataReceive(byteArrayA, true);
                    }
                    if (byteArrayOutputStream != null) {
                        aVar.f1884b = byteArrayOutputStream.toByteArray();
                    }
                    request.f1841a.recDataTime = System.currentTimeMillis() - request.f1841a.rspStart;
                    request.f1841a.rspBodyDeflateSize = aVar2.a();
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            }
            throw new CancellationException("task cancelled");
        } catch (Throwable th2) {
            th = th2;
            request.f1841a.recDataTime = System.currentTimeMillis() - request.f1841a.rspStart;
            request.f1841a.rspBodyDeflateSize = aVar2.a();
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
