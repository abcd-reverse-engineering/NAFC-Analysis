package network;

import java.util.concurrent.TimeUnit;
import l.n;
import l.q.a.h;
import network.interceptor.RequestParamInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import util.n1;
import util.p1;
import util.u1;

/* loaded from: classes2.dex */
public class Api {
    private static final int TIMEOUT_IDVAR = 300;
    private static final int TIMEOUT_NOR = 6;
    private static String mHost = null;
    private static Api mImeiApi = null;
    private static int timeOut = 6;
    HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: network.a
        @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
        public final void log(String str) {
            n1.b("RetrofitLog", "retrofitBack = " + str);
        }
    });
    RequestParamInterceptor paramInterceptor = new RequestParamInterceptor();
    private n mRetrofit = new n.b().a(d.a.i()).a(l.r.a.a.a()).a(h.a()).a(createClient()).a();
    private n mRetrofitUnHeader = new n.b().a(d.a.i()).a(l.r.a.a.a()).a(h.a()).a(createClientUnHeader()).a();

    private static class SingleHodle {
        private static final Api mApi = new Api();

        private SingleHodle() {
        }
    }

    private OkHttpClient createClient() {
        this.mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true).connectTimeout(timeOut, TimeUnit.SECONDS).readTimeout(timeOut, TimeUnit.SECONDS).writeTimeout(timeOut, TimeUnit.SECONDS).addInterceptor(this.mLoggingInterceptor);
        builder.addInterceptor(this.paramInterceptor);
        return builder.build();
    }

    private OkHttpClient createClientUnHeader() {
        this.mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true).connectTimeout(timeOut, TimeUnit.SECONDS).readTimeout(timeOut, TimeUnit.SECONDS).writeTimeout(timeOut, TimeUnit.SECONDS).addInterceptor(this.mLoggingInterceptor);
        return builder.build();
    }

    public static synchronized Api getInstance() {
        timeOut = 6;
        return SingleHodle.mApi;
    }

    public static synchronized Api getInstanceImei() {
        if (!u1.a(p1.y, true)) {
            return SingleHodle.mApi;
        }
        if (mImeiApi == null) {
            synchronized (Api.class) {
                if (mImeiApi == null) {
                    mImeiApi = new Api();
                }
            }
        }
        return mImeiApi;
    }

    public static synchronized Api getInstanceMode() {
        timeOut = 300;
        return new Api();
    }

    public static String getmHost() {
        return mHost;
    }

    public static void setHost(String str) {
        mHost = str;
    }

    public IReportService getReportService() {
        return (IReportService) this.mRetrofit.a(IReportService.class);
    }

    public IReportService getReportServiceUnHeader() {
        return (IReportService) this.mRetrofitUnHeader.a(IReportService.class);
    }
}
