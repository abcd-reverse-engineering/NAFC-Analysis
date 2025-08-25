package com.sina.weibo.sdk.net;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public final class b implements a {
    @Override // com.sina.weibo.sdk.net.a
    public final f a(d dVar) {
        String url = dVar.getUrl();
        Bundle params = dVar.getParams();
        if (params != null && params.size() != 0 && !TextUtils.isEmpty(url)) {
            Uri uriBuild = Uri.parse(url);
            if (params != null && !params.isEmpty()) {
                Uri.Builder builderBuildUpon = uriBuild.buildUpon();
                for (String str : params.keySet()) {
                    builderBuildUpon.appendQueryParameter(str, String.valueOf(params.get(str)));
                }
                uriBuild = builderBuildUpon.build();
            }
            if (uriBuild != null) {
                url = uriBuild.toString();
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        try {
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                Bundle bundle = new Bundle();
                bundle.putString("Content-Type", "application/x-www-form-urlencoded");
                a(httpURLConnection, bundle);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(dVar.getReadTimeout());
                httpURLConnection.setConnectTimeout(dVar.getConnectTimeout());
                httpURLConnection.connect();
                a(httpURLConnection.getOutputStream(), dVar);
                int responseCode = httpURLConnection.getResponseCode();
                return new g(responseCode, responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
            } catch (Exception e2) {
                throw new Throwable(e2.getMessage());
            }
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Bundle bundle) {
        for (String str : bundle.keySet()) {
            httpURLConnection.addRequestProperty(str, String.valueOf(bundle.get(str)));
        }
    }

    private static void a(OutputStream outputStream, d dVar) {
        Bundle bundleD = dVar.d();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundleD.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String strValueOf = String.valueOf(bundleD.get(str));
            try {
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(URLEncoder.encode(strValueOf, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes("UTF-8"));
            dataOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
