package com.airbnb.lottie.z;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DefaultLottieNetworkFetcher.java */
/* loaded from: classes.dex */
public class b implements f {
    @Override // com.airbnb.lottie.z.f
    @NonNull
    public d a(@NonNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new a(httpURLConnection);
    }
}
