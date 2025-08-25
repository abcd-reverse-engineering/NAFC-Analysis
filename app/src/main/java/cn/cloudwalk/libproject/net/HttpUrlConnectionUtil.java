package cn.cloudwalk.libproject.net;

/* loaded from: classes.dex */
public class HttpUrlConnectionUtil {
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a A[Catch: Exception -> 0x00ae, PHI: r0 r7
  0x008a: PHI (r0v7 java.lang.String) = (r0v5 java.lang.String), (r0v9 java.lang.String) binds: [B:40:0x00ab, B:22:0x0088] A[DONT_GENERATE, DONT_INLINE]
  0x008a: PHI (r7v7 java.net.HttpURLConnection) = (r7v6 java.net.HttpURLConnection), (r7v9 java.net.HttpURLConnection) binds: [B:40:0x00ab, B:22:0x0088] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {Exception -> 0x00ae, blocks: (B:19:0x0080, B:21:0x0085, B:23:0x008a, B:37:0x00a3, B:39:0x00a8), top: B:55:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String post(java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = ""
            r1 = 0
            byte[] r8 = r8.getBytes()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            java.net.URLConnection r7 = r2.openConnection()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            r2 = 10000(0x2710, float:1.4013E-41)
            r7.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r2 = 15000(0x3a98, float:2.102E-41)
            r7.setReadTimeout(r2)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r2 = 1
            r7.setDoOutput(r2)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r7.setDoInput(r2)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r3 = "Connection"
            java.lang.String r4 = "keep-alive"
            r7.setRequestProperty(r3, r4)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded"
            r7.setRequestProperty(r3, r4)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r3 = 0
            r7.setUseCaches(r3)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r3 = "POST"
            r7.setRequestMethod(r3)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r7.setInstanceFollowRedirects(r2)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r2.write(r8)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Laf
            r2.flush()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Laf
            int r8 = r7.getResponseCode()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Laf
            r3 = 200(0xc8, float:2.8E-43)
            if (r8 != r3) goto L7d
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Laf
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Laf
            java.io.InputStream r4 = r7.getInputStream()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Laf
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Laf
            r8.<init>(r3)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Laf
        L5f:
            java.lang.String r1 = r8.readLine()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78
            if (r1 == 0) goto L7e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78
            r3.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78
            r3.append(r0)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78
            r3.append(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78
            goto L5f
        L75:
            r0 = move-exception
            r1 = r8
            goto Lb0
        L78:
            r1 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L9e
        L7d:
            r8 = r1
        L7e:
            if (r8 == 0) goto L83
            r8.close()     // Catch: java.lang.Exception -> Lae
        L83:
            if (r2 == 0) goto L88
            r2.close()     // Catch: java.lang.Exception -> Lae
        L88:
            if (r7 == 0) goto Lae
        L8a:
            r7.disconnect()     // Catch: java.lang.Exception -> Lae
            goto Lae
        L8e:
            r8 = move-exception
            goto L9e
        L90:
            r0 = move-exception
            r2 = r1
            goto Lb0
        L93:
            r8 = move-exception
            r2 = r1
            goto L9e
        L96:
            r0 = move-exception
            r7 = r1
            r2 = r7
            goto Lb0
        L9a:
            r7 = move-exception
            r8 = r7
            r7 = r1
            r2 = r7
        L9e:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto La6
            r1.close()     // Catch: java.lang.Exception -> Lae
        La6:
            if (r2 == 0) goto Lab
            r2.close()     // Catch: java.lang.Exception -> Lae
        Lab:
            if (r7 == 0) goto Lae
            goto L8a
        Lae:
            return r0
        Laf:
            r0 = move-exception
        Lb0:
            if (r1 == 0) goto Lb5
            r1.close()     // Catch: java.lang.Exception -> Lbf
        Lb5:
            if (r2 == 0) goto Lba
            r2.close()     // Catch: java.lang.Exception -> Lbf
        Lba:
            if (r7 == 0) goto Lbf
            r7.disconnect()     // Catch: java.lang.Exception -> Lbf
        Lbf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.cloudwalk.libproject.net.HttpUrlConnectionUtil.post(java.lang.String, java.lang.String):java.lang.String");
    }
}
