package com.umeng.socialize.net.utils;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import d.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UClient {
    private static final String END = "\r\n";
    private static final String TAG = "UClient";

    protected static class ResponseObj {
        public int httpResponseCode;
        public JSONObject jsonObject;

        protected ResponseObj() {
        }
    }

    private void addBodyParams(URequest uRequest, OutputStream outputStream, String str) throws IOException {
        boolean z;
        StringBuilder sb = new StringBuilder();
        Map<String, Object> bodyPair = uRequest.getBodyPair();
        for (String str2 : bodyPair.keySet()) {
            if (bodyPair.get(str2) != null) {
                addFormField(sb, str2, bodyPair.get(str2).toString(), str);
            }
        }
        if (sb.length() > 0) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes());
            outputStream = dataOutputStream;
            z = true;
        } else {
            z = false;
        }
        Map<String, URequest.FilePair> filePair = uRequest.getFilePair();
        if (filePair != null && filePair.size() > 0) {
            Iterator<String> it = filePair.keySet().iterator();
            while (it.hasNext()) {
                URequest.FilePair filePair2 = filePair.get(it.next());
                byte[] bArr = filePair2.mBinaryData;
                if (bArr != null && bArr.length >= 1) {
                    addFilePart(filePair2.mFileName, bArr, str, outputStream);
                    z = true;
                }
            }
        }
        if (z) {
            finishWrite(outputStream, str);
        }
    }

    private void addFilePart(String str, byte[] bArr, String str2, OutputStream outputStream) throws IOException {
        outputStream.write((d.D + str2 + END + "Content-Disposition: form-data; name=\"pic\"; filename=\"" + str + "\"" + END + "Content-Type: " + OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE + END + "Content-Transfer-Encoding: binary" + END + END).getBytes());
        outputStream.write(bArr);
        outputStream.write(END.getBytes());
    }

    private void addFormField(StringBuilder sb, String str, String str2, String str3) {
        sb.append(d.D);
        sb.append(str3);
        sb.append(END);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append(END);
        sb.append("Content-Type: text/plain; charset=");
        sb.append("UTF-8");
        sb.append(END);
        sb.append(END);
        sb.append(str2);
        sb.append(END);
    }

    private JSONObject decryptData(URequest uRequest, String str) {
        try {
            return new JSONObject(uRequest.getDecryptString(str));
        } catch (Throwable th) {
            SLog.error(UmengText.NET.CREATE, th);
            return null;
        }
    }

    private void finishWrite(OutputStream outputStream, String str) throws IOException {
        outputStream.write(END.getBytes());
        outputStream.write((d.D + str + d.D).getBytes());
        outputStream.write(END.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private ResponseObj httpGetRequest(URequest uRequest) {
        HttpURLConnection httpURLConnectionOpenUrlConnection;
        InputStream inputStream;
        try {
            httpURLConnectionOpenUrlConnection = openUrlConnection(uRequest);
            if (httpURLConnectionOpenUrlConnection == null) {
                closeQuietly(null);
                if (httpURLConnectionOpenUrlConnection != null) {
                    httpURLConnectionOpenUrlConnection.disconnect();
                }
                return null;
            }
            try {
                int responseCode = httpURLConnectionOpenUrlConnection.getResponseCode();
                ResponseObj responseObj = new ResponseObj();
                responseObj.httpResponseCode = responseCode;
                if (responseCode != 200) {
                    closeQuietly(null);
                    if (httpURLConnectionOpenUrlConnection != null) {
                        httpURLConnectionOpenUrlConnection.disconnect();
                    }
                    return null;
                }
                inputStream = httpURLConnectionOpenUrlConnection.getInputStream();
                try {
                    responseObj.jsonObject = parseResult(uRequest, httpURLConnectionOpenUrlConnection.getRequestMethod(), httpURLConnectionOpenUrlConnection.getContentEncoding(), inputStream);
                    SLog.debug(UmengText.NET.JSONRESULT);
                    return responseObj;
                } catch (Throwable th) {
                    th = th;
                    try {
                        SLog.error(UmengText.NET.PARSEERROR, th);
                        closeQuietly(inputStream);
                        if (httpURLConnectionOpenUrlConnection != null) {
                            httpURLConnectionOpenUrlConnection.disconnect();
                        }
                        return null;
                    } finally {
                        closeQuietly(inputStream);
                        if (httpURLConnectionOpenUrlConnection != null) {
                            httpURLConnectionOpenUrlConnection.disconnect();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnectionOpenUrlConnection = null;
            inputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b5  */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.umeng.socialize.net.utils.UClient] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.umeng.socialize.net.utils.UClient.ResponseObj httpPostRequest(com.umeng.socialize.net.utils.URequest r10) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.UClient.httpPostRequest(com.umeng.socialize.net.utils.URequest):com.umeng.socialize.net.utils.UClient$ResponseObj");
    }

    private HttpURLConnection openUrlConnection(URequest uRequest) throws IOException {
        String strTrim = uRequest.getHttpMethod().trim();
        String getUrl = URequest.GET.equals(strTrim) ? uRequest.toGetUrl() : URequest.POST.equals(strTrim) ? uRequest.mBaseUrl : null;
        if (TextUtils.isEmpty(getUrl)) {
            return null;
        }
        URL url = new URL(getUrl);
        HttpURLConnection httpURLConnection = HttpConstant.HTTPS.equals(url.getProtocol()) ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(Config.connectionTimeOut);
        httpURLConnection.setReadTimeout(Config.readSocketTimeOut);
        httpURLConnection.setRequestMethod(strTrim);
        if (URequest.GET.equals(strTrim)) {
            httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
            Map<String, String> map = uRequest.mHeaders;
            if (map != null && map.size() > 0) {
                for (String str : uRequest.mHeaders.keySet()) {
                    httpURLConnection.setRequestProperty(str, uRequest.mHeaders.get(str));
                }
            }
        } else if (URequest.POST.equals(strTrim)) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    private void verifyMethod(String str) {
        if (TextUtils.isEmpty(str) || URequest.GET.equals(str.trim()) == URequest.POST.equals(str.trim())) {
            throw new RuntimeException(UmengText.netMethodError(str));
        }
    }

    protected void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                SLog.error(UmengText.NET.CLOSE, th);
            }
        }
    }

    protected String convertStreamToString(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 512);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    closeQuietly(inputStreamReader);
                    closeQuietly(bufferedReader);
                    return sb.toString();
                }
                sb.append(line + "\n");
            } catch (Throwable th) {
                try {
                    SLog.error(UmengText.NET.TOOL, th);
                    return null;
                } finally {
                    closeQuietly(inputStreamReader);
                    closeQuietly(bufferedReader);
                }
            }
        }
    }

    protected <T extends UResponse> T createResponse(ResponseObj responseObj, Class<T> cls) {
        if (responseObj == null) {
            return null;
        }
        try {
            return cls.getConstructor(Integer.class, JSONObject.class).newInstance(Integer.valueOf(responseObj.httpResponseCode), responseObj.jsonObject);
        } catch (Throwable th) {
            SLog.error(UmengText.NET.CREATE, th);
            return null;
        }
    }

    public <T extends UResponse> T execute(URequest uRequest, Class<T> cls) {
        uRequest.onPrepareRequest();
        String strTrim = uRequest.getHttpMethod().trim();
        verifyMethod(strTrim);
        return (T) createResponse(URequest.GET.equals(strTrim) ? httpGetRequest(uRequest) : URequest.POST.equals(strTrim) ? httpPostRequest(uRequest) : null, cls);
    }

    protected JSONObject parseResult(URequest uRequest, String str, String str2, InputStream inputStream) {
        InputStream inputStreamWrapStream;
        String strConvertStreamToString;
        try {
            inputStreamWrapStream = wrapStream(str2, inputStream);
        } catch (Throwable th) {
            th = th;
            inputStreamWrapStream = null;
        }
        try {
            strConvertStreamToString = convertStreamToString(inputStreamWrapStream);
        } catch (Throwable th2) {
            th = th2;
            try {
                SLog.error(UmengText.NET.PARSEERROR, th);
                return null;
            } finally {
                closeQuietly(inputStreamWrapStream);
            }
        }
        if ("POST".equals(str)) {
            try {
                return new JSONObject(strConvertStreamToString);
            } catch (Throwable th3) {
                SLog.error(UmengText.NET.PARSEERROR, th3);
                return decryptData(uRequest, strConvertStreamToString);
            }
        }
        if ("GET".equals(str)) {
            if (TextUtils.isEmpty(strConvertStreamToString)) {
                return null;
            }
            return decryptData(uRequest, strConvertStreamToString);
        }
        return null;
    }

    protected InputStream wrapStream(String str, InputStream inputStream) throws IOException {
        if (str == null || "identity".equalsIgnoreCase(str)) {
            return inputStream;
        }
        if (HttpConstant.GZIP.equalsIgnoreCase(str)) {
            return new GZIPInputStream(inputStream);
        }
        if ("deflate".equalsIgnoreCase(str)) {
            return new InflaterInputStream(inputStream, new Inflater(false), 512);
        }
        throw new RuntimeException("unsupported content-encoding: " + str);
    }
}
