package com.umeng.socialize.weixin.net;

import com.umeng.socialize.utils.SLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public class WXAuthUtils {
    public static String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("/n");
                    } catch (IOException e2) {
                        SLog.error(e2);
                    }
                } catch (IOException e3) {
                    SLog.error(e3);
                    inputStream.close();
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    SLog.error(e4);
                }
                throw th;
            }
        }
        inputStream.close();
        return sb.toString();
    }

    public static String request(String str) throws IOException {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            if (uRLConnectionOpenConnection == null) {
                return "";
            }
            uRLConnectionOpenConnection.connect();
            InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
            return inputStream == null ? "" : convertStreamToString(inputStream);
        } catch (Exception e2) {
            SLog.error(e2);
            return "";
        }
    }
}
