package com.bumptech.glide.load.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.o.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class j implements d<InputStream> {

    /* renamed from: g, reason: collision with root package name */
    private static final String f4275g = "HttpUrlFetcher";

    /* renamed from: h, reason: collision with root package name */
    private static final int f4276h = 5;

    /* renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final b f4277i = new a();

    /* renamed from: j, reason: collision with root package name */
    private static final int f4278j = -1;

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.q.g f4279a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4280b;

    /* renamed from: c, reason: collision with root package name */
    private final b f4281c;

    /* renamed from: d, reason: collision with root package name */
    private HttpURLConnection f4282d;

    /* renamed from: e, reason: collision with root package name */
    private InputStream f4283e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f4284f;

    /* compiled from: HttpUrlFetcher.java */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.o.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher.java */
    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(com.bumptech.glide.load.q.g gVar, int i2) {
        this(gVar, i2, f4277i);
    }

    private static boolean b(int i2) {
        return i2 / 100 == 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.o.d
    public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb;
        String str = f4275g;
        long jA = com.bumptech.glide.util.f.a();
        try {
            try {
                aVar.a((d.a<? super InputStream>) a(this.f4279a.d(), 0, null, this.f4279a.b()));
                str = str;
            } catch (IOException e2) {
                Log.isLoggable(f4275g, 3);
                aVar.a((Exception) e2);
                str = str;
                if (Log.isLoggable(f4275g, 2)) {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable(f4275g, 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                double dA = com.bumptech.glide.util.f.a(jA);
                sb.append(dA);
                sb.toString();
                str = dA;
            }
        } catch (Throwable th) {
            if (Log.isLoggable(str, 2)) {
                String str2 = "Finished http url fetcher fetch in " + com.bumptech.glide.util.f.a(jA);
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.o.d
    public void cancel() {
        this.f4284f = true;
    }

    @VisibleForTesting
    j(com.bumptech.glide.load.q.g gVar, int i2, b bVar) {
        this.f4279a = gVar;
        this.f4280b = i2;
        this.f4281c = bVar;
    }

    @Override // com.bumptech.glide.load.o.d
    public void b() throws IOException {
        InputStream inputStream = this.f4283e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f4282d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f4282d = null;
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new com.bumptech.glide.load.e("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f4282d = this.f4281c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f4282d.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f4282d.setConnectTimeout(this.f4280b);
            this.f4282d.setReadTimeout(this.f4280b);
            this.f4282d.setUseCaches(false);
            this.f4282d.setDoInput(true);
            this.f4282d.setInstanceFollowRedirects(false);
            this.f4282d.connect();
            this.f4283e = this.f4282d.getInputStream();
            if (this.f4284f) {
                return null;
            }
            int responseCode = this.f4282d.getResponseCode();
            if (a(responseCode)) {
                return a(this.f4282d);
            }
            if (!b(responseCode)) {
                if (responseCode == -1) {
                    throw new com.bumptech.glide.load.e(responseCode);
                }
                throw new com.bumptech.glide.load.e(this.f4282d.getResponseMessage(), responseCode);
            }
            String headerField = this.f4282d.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                b();
                return a(url3, i2 + 1, url, map);
            }
            throw new com.bumptech.glide.load.e("Received empty or null redirect url");
        }
        throw new com.bumptech.glide.load.e("Too many (> 5) redirects!");
    }

    private static boolean a(int i2) {
        return i2 / 100 == 2;
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f4283e = com.bumptech.glide.util.b.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(f4275g, 3)) {
                String str = "Got non empty content encoding: " + httpURLConnection.getContentEncoding();
            }
            this.f4283e = httpURLConnection.getInputStream();
        }
        return this.f4283e;
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
