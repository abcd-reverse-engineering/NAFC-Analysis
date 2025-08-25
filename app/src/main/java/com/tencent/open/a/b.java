package com.tencent.open.a;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.open.log.SLog;
import h.z2.h0;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private int f9755a = 15000;

    /* renamed from: b, reason: collision with root package name */
    private int f9756b = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;

    /* renamed from: c, reason: collision with root package name */
    private final String f9757c;

    public b(String str) {
        this.f9757c = str;
    }

    private static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.open.a.a
    public void a(long j2, long j3) {
        if (j2 <= 0 || j3 <= 0) {
            return;
        }
        this.f9755a = (int) j2;
        this.f9756b = (int) j3;
    }

    @Override // com.tencent.open.a.a
    public g a(String str, String str2) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "get. ");
        if (!TextUtils.isEmpty(str2)) {
            int iIndexOf = str2.indexOf("?");
            if (iIndexOf == -1) {
                str = str + "?";
            } else if (iIndexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return a(str, str2.length());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "post. ");
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(h0.f16706c);
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        String string = sb.toString();
        return a(str, string.length(), string);
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() > 0) {
            Iterator<Map.Entry<String, byte[]>> it = map2.entrySet().iterator();
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<String, byte[]> next = it.next();
            return a(str, map, next.getKey(), next.getValue());
        }
        return a(str, map);
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.f9757c);
        httpURLConnection.setConnectTimeout(this.f9755a);
        httpURLConnection.setReadTimeout(this.f9756b);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
    }

    private g a(String str, int i2) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("GET");
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i3 = inputStream.read(bArr);
                            if (i3 != -1) {
                                byteArrayOutputStream.write(bArr, 0, i3);
                            } else {
                                c cVar = new c(httpURLConnection, byteArrayOutputStream.toString(), httpURLConnection.getContentLength(), i2, httpURLConnection.getResponseCode(), "");
                                a(byteArrayOutputStream);
                                a(inputStream);
                                b(httpURLConnection);
                                return cVar;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        a(byteArrayOutputStream2);
                        a(inputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "请求失败 code:" + httpURLConnection.getResponseCode();
                    }
                    c cVar2 = new c(httpURLConnection, "", httpURLConnection.getContentLength(), i2, httpURLConnection.getResponseCode(), responseMessage);
                    a((Closeable) null);
                    a((Closeable) null);
                    b(httpURLConnection);
                    return cVar2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    private g a(String str, int i2, String str2) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(str2);
                outputStreamWriter.flush();
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i3 = inputStream.read(bArr);
                            if (i3 != -1) {
                                byteArrayOutputStream.write(bArr, 0, i3);
                            } else {
                                c cVar = new c(httpURLConnection, byteArrayOutputStream.toString(), contentLength, i2, httpURLConnection.getResponseCode(), "");
                                a(byteArrayOutputStream);
                                a(inputStream);
                                b(httpURLConnection);
                                return cVar;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        a(byteArrayOutputStream2);
                        a(inputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "Unknown fail: " + httpURLConnection.getResponseCode();
                    }
                    c cVar2 = new c(httpURLConnection, "", 0, i2, httpURLConnection.getResponseCode(), responseMessage);
                    a((Closeable) null);
                    a((Closeable) null);
                    b(httpURLConnection);
                    return cVar2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    public g a(String str, Map<String, String> map, String str2, byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        int i2;
        String string;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        Map<String, String> map2 = map;
        SLog.i("DefaultHttpServiceImpl", "文件上传");
        String string2 = UUID.randomUUID().toString();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + string2);
            } catch (Throwable th) {
                th = th;
            }
            try {
                a(httpURLConnection);
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                if (map2 != null) {
                    try {
                        if (map.size() > 0) {
                            Iterator<String> it = map.keySet().iterator();
                            while (it.hasNext()) {
                                StringBuffer stringBuffer = new StringBuffer();
                                String strEncode = URLEncoder.encode(it.next(), "UTF-8");
                                String strEncode2 = URLEncoder.encode(map2.get(strEncode), "UTF-8");
                                stringBuffer.append(d.d.D);
                                stringBuffer.append(string2);
                                stringBuffer.append("\r\n");
                                stringBuffer.append("Content-Disposition: form-data; name=\"");
                                stringBuffer.append(strEncode);
                                stringBuffer.append("\"");
                                stringBuffer.append("\r\n");
                                stringBuffer.append("\r\n");
                                stringBuffer.append(strEncode2);
                                stringBuffer.append("\r\n");
                                String string3 = stringBuffer.toString();
                                SLog.i("DefaultHttpServiceImpl", strEncode + ContainerUtils.KEY_VALUE_DELIMITER + string3 + "##");
                                dataOutputStream.write(string3.getBytes());
                                map2 = map;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        a(dataOutputStream);
                        a(inputStream);
                        a(byteArrayOutputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                }
                if (bArr == null || bArr.length <= 0) {
                    i2 = 0;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(d.d.D);
                    stringBuffer2.append(string2);
                    stringBuffer2.append("\r\n");
                    stringBuffer2.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str2 + "\"\r\n");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Content-Type: application/octet-stream; charset=UTF-8");
                    sb.append("\r\n");
                    stringBuffer2.append(sb.toString());
                    stringBuffer2.append("\r\n");
                    dataOutputStream.write(stringBuffer2.toString().getBytes());
                    dataOutputStream.write(bArr, 0, bArr.length);
                    dataOutputStream.write("\r\n".getBytes());
                    byte[] bytes = (d.d.D + string2 + d.d.D + "\r\n").getBytes();
                    dataOutputStream.write(bytes);
                    int length = bytes.length + 0;
                    dataOutputStream.flush();
                    i2 = length;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                dataOutputStream = null;
                inputStream = null;
                a(dataOutputStream);
                a(inputStream);
                a(byteArrayOutputStream);
                b(httpURLConnection);
                throw th;
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                SLog.i("DefaultHttpServiceImpl", responseCode + "");
                if (responseCode == 200) {
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i3 = inputStream2.read(bArr2);
                                if (i3 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i3);
                            }
                            string = byteArrayOutputStream.toString();
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream2;
                            a(dataOutputStream);
                            a(inputStream);
                            a(byteArrayOutputStream);
                            b(httpURLConnection);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = inputStream2;
                        byteArrayOutputStream = null;
                        a(dataOutputStream);
                        a(inputStream);
                        a(byteArrayOutputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                } else {
                    string = httpURLConnection.getResponseCode() + "";
                    inputStream2 = null;
                    byteArrayOutputStream2 = null;
                }
                try {
                    try {
                        c cVar = new c(httpURLConnection, string, httpURLConnection.getContentLength(), i2, httpURLConnection.getResponseCode(), "");
                        a(dataOutputStream);
                        a(inputStream2);
                        a(byteArrayOutputStream2);
                        b(httpURLConnection);
                        return cVar;
                    } catch (Throwable th6) {
                        th = th6;
                        dataOutputStream = dataOutputStream;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream2;
                        a(dataOutputStream);
                        a(inputStream);
                        a(byteArrayOutputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                byteArrayOutputStream = null;
                inputStream = null;
                a(dataOutputStream);
                a(inputStream);
                a(byteArrayOutputStream);
                b(httpURLConnection);
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            byteArrayOutputStream = null;
            httpURLConnection = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
