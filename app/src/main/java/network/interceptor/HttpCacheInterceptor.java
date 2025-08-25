package network.interceptor;

import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import util.q1;

/* loaded from: classes2.dex */
public class HttpCacheInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (!q1.f()) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }
        Response responseProceed = chain.proceed(request);
        if (q1.f()) {
            responseProceed.newBuilder().removeHeader("Pragma").header("Cache-Control", "public, max-age=3600").build();
        } else {
            responseProceed.newBuilder().removeHeader("Pragma").header("Cache-Control", "public, only-if-cached, max-stale=2419200").build();
        }
        return responseProceed;
    }
}
