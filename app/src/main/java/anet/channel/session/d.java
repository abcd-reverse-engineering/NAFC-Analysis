package anet.channel.session;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d extends Session {
    private SSLSocketFactory w;

    public d(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        if (this.f1631k == null) {
            String str = this.f1623c;
            this.f1630j = (str == null || !str.startsWith(HttpConstant.HTTPS)) ? ConnType.HTTP : ConnType.HTTPS;
        } else if (AwcnConfig.isHttpsSniEnable() && this.f1630j.equals(ConnType.HTTPS)) {
            this.w = new anet.channel.util.j(this.f1624d);
        }
    }

    @Override // anet.channel.Session
    public void close() {
        notifyStatus(6, null);
    }

    @Override // anet.channel.Session
    public void connect() {
        try {
            if (this.f1631k != null && this.f1631k.getIpSource() == 1) {
                notifyStatus(4, new anet.channel.entity.b(1));
                return;
            }
            Request.Builder redirectEnable = new Request.Builder().setUrl(this.f1623c).setSeq(this.p).setConnectTimeout((int) (this.r * Utils.getNetworkTimeFactor())).setReadTimeout((int) (this.s * Utils.getNetworkTimeFactor())).setRedirectEnable(false);
            if (this.w != null) {
                redirectEnable.setSslSocketFactory(this.w);
            }
            if (this.f1633m) {
                redirectEnable.addHeader("Host", this.f1625e);
            }
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(this.f1625e)) {
                try {
                    this.f1626f = anet.channel.util.c.a(this.f1625e);
                } catch (Exception unused) {
                }
            }
            ALog.i("awcn.HttpSession", "HttpSession connect", null, Constants.KEY_HOST, this.f1623c, "ip", this.f1626f, "port", Integer.valueOf(this.f1627g));
            Request requestBuild = redirectEnable.build();
            requestBuild.setDnsOptimize(this.f1626f, this.f1627g);
            ThreadPoolExecutorFactory.submitPriorityTask(new e(this, requestBuild), ThreadPoolExecutorFactory.Priority.LOW);
        } catch (Throwable th) {
            ALog.e("awcn.HttpSession", "HTTP connect fail.", null, th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return null;
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.n == 4;
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        anet.channel.request.b bVar = anet.channel.request.b.NULL;
        Request.Builder builderNewBuilder = null;
        RequestStatistic requestStatistic = request != null ? request.f1841a : new RequestStatistic(this.f1624d, null);
        requestStatistic.setConnType(this.f1630j);
        if (requestStatistic.start == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = jCurrentTimeMillis;
            requestStatistic.start = jCurrentTimeMillis;
        }
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), requestStatistic);
            }
            return bVar;
        }
        try {
            if (request.getSslSocketFactory() == null && this.w != null) {
                builderNewBuilder = request.newBuilder().setSslSocketFactory(this.w);
            }
            if (this.f1633m) {
                if (builderNewBuilder == null) {
                    builderNewBuilder = request.newBuilder();
                }
                builderNewBuilder.addHeader("Host", this.f1625e);
            }
            if (builderNewBuilder != null) {
                request = builderNewBuilder.build();
            }
            if (this.f1626f == null) {
                String strHost = request.getHttpUrl().host();
                if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(strHost)) {
                    try {
                        this.f1626f = anet.channel.util.c.a(strHost);
                    } catch (Exception unused) {
                    }
                }
            }
            request.setDnsOptimize(this.f1626f, this.f1627g);
            request.setUrlScheme(this.f1630j.isSSL());
            if (this.f1631k != null) {
                request.f1841a.setIpInfo(this.f1631k.getIpSource(), this.f1631k.getIpType());
            } else {
                request.f1841a.setIpInfo(1, 1);
            }
            request.f1841a.unit = this.f1632l;
            return new anet.channel.request.b(ThreadPoolExecutorFactory.submitPriorityTask(new f(this, request, requestCb, requestStatistic), anet.channel.util.h.a(request)), request.getSeq());
        } catch (Throwable th) {
            if (requestCb == null) {
                return bVar;
            }
            requestCb.onFinish(-101, ErrorConstant.formatMsg(-101, th.toString()), requestStatistic);
            return bVar;
        }
    }

    @Override // anet.channel.Session
    public void close(boolean z) {
        this.t = false;
        close();
    }
}
