package anet.channel.session;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class c implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1888a;

    c(String str) {
        this.f1888a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f1888a, sSLSession);
    }
}
