package cn.cloudwalk.libproject.net;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class HttpsUrlConnectionUtil {

    private static class HttpsTrustManager implements X509TrustManager {
        private HttpsTrustManager() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5 A[Catch: Exception -> 0x00d9, PHI: r1 r8
  0x00a5: PHI (r1v6 java.lang.String) = (r1v2 java.lang.String), (r1v3 java.lang.String), (r1v4 java.lang.String), (r1v7 java.lang.String) binds: [B:38:0x00bc, B:45:0x00c9, B:52:0x00d6, B:22:0x00a3] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r8v9 ??) = (r8v6 ??), (r8v7 ??), (r8v8 ??), (r8v12 ??) binds: [B:38:0x00bc, B:45:0x00c9, B:52:0x00d6, B:22:0x00a3] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #8 {Exception -> 0x00d9, blocks: (B:21:0x00a0, B:23:0x00a5, B:37:0x00b9, B:44:0x00c6, B:51:0x00d3), top: B:63:0x0005 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [cn.cloudwalk.libproject.net.HttpsUrlConnectionUtil$1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r8v12, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [javax.net.ssl.HttpsURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String post(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.cloudwalk.libproject.net.HttpsUrlConnectionUtil.post(java.lang.String, java.lang.String):java.lang.String");
    }
}
