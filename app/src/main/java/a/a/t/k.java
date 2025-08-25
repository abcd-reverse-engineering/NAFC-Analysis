package a.a.t;

import a.a.j.a;
import a.a.t.g;
import android.support.v4.media.session.PlaybackStateCompat;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ConnType;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.HttpUrl;
import anetwork.channel.aidl.DefaultFinishEvent;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class k implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f1227a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f1228b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f1229c;

    k(g gVar, Request request, RequestStatistic requestStatistic) {
        this.f1229c = gVar;
        this.f1227a = request;
        this.f1228b = requestStatistic;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        if (this.f1229c.f1204h.get()) {
            return;
        }
        g gVar = this.f1229c;
        if (gVar.f1206j == 0) {
            ALog.i(g.n, "[onDataReceive] receive first data chunk!", gVar.f1197a.f1232c, new Object[0]);
        }
        if (z) {
            ALog.i(g.n, "[onDataReceive] receive last data chunk!", this.f1229c.f1197a.f1232c, new Object[0]);
        }
        g gVar2 = this.f1229c;
        gVar2.f1206j++;
        try {
            if (gVar2.f1209m != null) {
                gVar2.f1209m.f1212c.add(byteArray);
                if (this.f1228b.recDataSize > PlaybackStateCompat.ACTION_PREPARE_FROM_URI || z) {
                    this.f1229c.f1206j = this.f1229c.f1209m.a(this.f1229c.f1197a.f1231b, this.f1229c.f1205i);
                    this.f1229c.f1207k = true;
                    this.f1229c.f1208l = this.f1229c.f1206j > 1;
                    this.f1229c.f1209m = null;
                }
            } else {
                gVar2.f1197a.f1231b.a(gVar2.f1206j, gVar2.f1205i, byteArray);
                this.f1229c.f1208l = true;
            }
            if (this.f1229c.f1200d != null) {
                this.f1229c.f1200d.write(byteArray.getBuffer(), 0, byteArray.getDataLength());
                if (z) {
                    String strG = this.f1229c.f1197a.f1230a.g();
                    this.f1229c.f1199c.data = this.f1229c.f1200d.toByteArray();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.f1229c.f1198b.put(strG, this.f1229c.f1199c);
                    ALog.i(g.n, "write cache", this.f1229c.f1197a.f1232c, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "size", Integer.valueOf(this.f1229c.f1199c.data.length), "key", strG);
                }
            }
        } catch (Exception e2) {
            ALog.w(g.n, "[onDataReceive] error.", this.f1229c.f1197a.f1232c, e2, new Object[0]);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        String strValueOf;
        DefaultFinishEvent defaultFinishEvent;
        if (this.f1229c.f1204h.getAndSet(true)) {
            return;
        }
        int i3 = 3;
        if (ALog.isPrintLog(2)) {
            ALog.i(g.n, "[onFinish]", this.f1229c.f1197a.f1232c, "code", Integer.valueOf(i2), "msg", str);
        }
        if (i2 < 0) {
            try {
                if (this.f1229c.f1197a.f1230a.d()) {
                    if (!this.f1229c.f1207k && !this.f1229c.f1208l) {
                        ALog.e(g.n, "clear response buffer and retry", this.f1229c.f1197a.f1232c, new Object[0]);
                        if (this.f1229c.f1209m != null) {
                            if (!this.f1229c.f1209m.f1212c.isEmpty()) {
                                i3 = 4;
                            }
                            requestStatistic.roaming = i3;
                            this.f1229c.f1209m.a();
                            this.f1229c.f1209m = null;
                        }
                        if (this.f1229c.f1197a.f1230a.f2225e == 0) {
                            requestStatistic.firstProtocol = requestStatistic.protocolType;
                            requestStatistic.firstErrorCode = requestStatistic.tnetErrorCode != 0 ? requestStatistic.tnetErrorCode : i2;
                        }
                        this.f1229c.f1197a.f1230a.k();
                        this.f1229c.f1197a.f1233d = new AtomicBoolean();
                        this.f1229c.f1197a.f1234e = new g(this.f1229c.f1197a, this.f1229c.f1198b, this.f1229c.f1199c);
                        if (requestStatistic.tnetErrorCode != 0) {
                            strValueOf = i2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + requestStatistic.protocolType + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + requestStatistic.tnetErrorCode;
                            requestStatistic.tnetErrorCode = 0;
                        } else {
                            strValueOf = String.valueOf(i2);
                        }
                        requestStatistic.appendErrorTrace(strValueOf);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        requestStatistic.retryCostTime += jCurrentTimeMillis - requestStatistic.start;
                        requestStatistic.start = jCurrentTimeMillis;
                        ThreadPoolExecutorFactory.submitPriorityTask(this.f1229c.f1197a.f1234e, ThreadPoolExecutorFactory.Priority.HIGH);
                        return;
                    }
                    requestStatistic.msg += ":回调后触发重试";
                    if (this.f1229c.f1208l) {
                        requestStatistic.roaming = 2;
                    } else if (this.f1229c.f1207k) {
                        requestStatistic.roaming = 1;
                    }
                    ALog.e(g.n, "Cannot retry request after onHeader/onDataReceived callback!", this.f1229c.f1197a.f1232c, new Object[0]);
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (this.f1229c.f1209m != null) {
            this.f1229c.f1209m.a(this.f1229c.f1197a.f1231b, this.f1229c.f1205i);
        }
        this.f1229c.f1197a.a();
        requestStatistic.isDone.set(true);
        if (this.f1229c.f1197a.f1230a.j() && requestStatistic.contentLength != 0 && requestStatistic.contentLength != requestStatistic.rspBodyDeflateSize) {
            requestStatistic.ret = 0;
            requestStatistic.statusCode = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
            str = ErrorConstant.getErrMsg(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH);
            requestStatistic.msg = str;
            ALog.e(g.n, "received data length not match with content-length", this.f1229c.f1197a.f1232c, "content-length", Integer.valueOf(this.f1229c.f1205i), "recDataLength", Long.valueOf(requestStatistic.rspBodyDeflateSize));
            ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH, str, "rt");
            exceptionStatistic.url = this.f1229c.f1197a.f1230a.g();
            AppMonitor.getInstance().commitStat(exceptionStatistic);
            i2 = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
        }
        if (i2 != 304 || this.f1229c.f1199c == null) {
            defaultFinishEvent = new DefaultFinishEvent(i2, str, this.f1227a);
        } else {
            requestStatistic.protocolType = "cache";
            defaultFinishEvent = new DefaultFinishEvent(200, str, this.f1227a);
        }
        this.f1229c.f1197a.f1231b.a(defaultFinishEvent);
        if (i2 >= 0) {
            anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize);
        } else {
            requestStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        }
        NetworkAnalysis.getInstance().commitFlow(new FlowStat(this.f1229c.f1201e, requestStatistic));
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        String singleHeaderFieldByKey;
        if (this.f1229c.f1204h.get()) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i(g.n, "onResponseCode", this.f1227a.getSeq(), "code", Integer.valueOf(i2));
            ALog.i(g.n, "onResponseCode", this.f1227a.getSeq(), "headers", map);
        }
        if (HttpHelper.checkRedirect(this.f1227a, i2) && (singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Location")) != null) {
            HttpUrl httpUrl = HttpUrl.parse(singleHeaderFieldByKey);
            if (httpUrl != null) {
                if (this.f1229c.f1204h.compareAndSet(false, true)) {
                    httpUrl.lockScheme();
                    this.f1229c.f1197a.f1230a.a(httpUrl);
                    this.f1229c.f1197a.f1233d = new AtomicBoolean();
                    l lVar = this.f1229c.f1197a;
                    lVar.f1234e = new g(lVar, null, null);
                    this.f1228b.recordRedirect(i2, httpUrl.simpleUrlString());
                    this.f1228b.locationUrl = singleHeaderFieldByKey;
                    ThreadPoolExecutorFactory.submitPriorityTask(this.f1229c.f1197a.f1234e, ThreadPoolExecutorFactory.Priority.HIGH);
                    return;
                }
                return;
            }
            ALog.e(g.n, "redirect url is invalid!", this.f1227a.getSeq(), "redirect url", singleHeaderFieldByKey);
        }
        try {
            this.f1229c.f1197a.a();
            a.a.l.a.a(this.f1229c.f1197a.f1230a.g(), map);
            this.f1229c.f1205i = HttpHelper.parseContentLength(map);
            String strG = this.f1229c.f1197a.f1230a.g();
            if (this.f1229c.f1199c != null && i2 == 304) {
                this.f1229c.f1199c.responseHeaders.putAll(map);
                a.C0001a c0001aA = a.a.j.d.a(map);
                if (c0001aA != null && c0001aA.ttl > this.f1229c.f1199c.ttl) {
                    this.f1229c.f1199c.ttl = c0001aA.ttl;
                }
                this.f1229c.f1197a.f1231b.onResponseCode(200, this.f1229c.f1199c.responseHeaders);
                this.f1229c.f1197a.f1231b.a(1, this.f1229c.f1199c.data.length, ByteArray.wrap(this.f1229c.f1199c.data));
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f1229c.f1198b.put(strG, this.f1229c.f1199c);
                ALog.i(g.n, "update cache", this.f1229c.f1197a.f1232c, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "key", strG);
                return;
            }
            if (this.f1229c.f1198b != null) {
                if ("no-store".equals(HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control"))) {
                    this.f1229c.f1198b.remove(strG);
                } else {
                    g gVar = this.f1229c;
                    a.C0001a c0001aA2 = a.a.j.d.a(map);
                    gVar.f1199c = c0001aA2;
                    if (c0001aA2 != null) {
                        HttpHelper.removeHeaderFiledByKey(map, "Cache-Control");
                        map.put("Cache-Control", Arrays.asList("no-store"));
                        this.f1229c.f1200d = new ByteArrayOutputStream(this.f1229c.f1205i != 0 ? this.f1229c.f1205i : 5120);
                    }
                }
            }
            map.put(HttpConstant.X_PROTOCOL, Arrays.asList(this.f1228b.protocolType));
            if (!ConnType.PK_OPEN.equalsIgnoreCase(HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.STREAMING_PARSER)) && a.a.k.b.p() && this.f1229c.f1205i <= 131072) {
                this.f1229c.f1209m = new g.a(i2, map);
            } else {
                this.f1229c.f1197a.f1231b.onResponseCode(i2, map);
                this.f1229c.f1207k = true;
            }
        } catch (Exception e2) {
            ALog.w(g.n, "[onResponseCode] error.", this.f1229c.f1197a.f1232c, e2, new Object[0]);
        }
    }
}
