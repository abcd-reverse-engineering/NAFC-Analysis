package a.a.t;

import a.a.p.b;
import android.os.Looper;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    protected l f1236a;

    /* compiled from: Taobao */
    class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private int f1237a;

        /* renamed from: b, reason: collision with root package name */
        private Request f1238b;

        /* renamed from: c, reason: collision with root package name */
        private a.a.p.a f1239c;

        a(int i2, Request request, a.a.p.a aVar) {
            this.f1237a = 0;
            this.f1238b = null;
            this.f1239c = null;
            this.f1237a = i2;
            this.f1238b = request;
            this.f1239c = aVar;
        }

        @Override // a.a.p.b.a
        public Future a(Request request, a.a.p.a aVar) {
            if (m.this.f1236a.f1233d.get()) {
                ALog.i("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", request.getSeq(), new Object[0]);
                return null;
            }
            if (this.f1237a < a.a.p.c.a()) {
                return a.a.p.c.a(this.f1237a).a(m.this.new a(this.f1237a + 1, request, aVar));
            }
            m.this.f1236a.f1230a.a(request);
            m.this.f1236a.f1231b = aVar;
            a.a.j.a aVarA = a.a.k.b.l() ? a.a.j.b.a(m.this.f1236a.f1230a.g(), m.this.f1236a.f1230a.h()) : null;
            l lVar = m.this.f1236a;
            lVar.f1234e = aVarA != null ? new c(lVar, aVarA) : new g(lVar, null, null);
            m.this.f1236a.f1234e.run();
            m.this.c();
            return null;
        }

        @Override // a.a.p.b.a
        public a.a.p.a callback() {
            return this.f1239c;
        }

        @Override // a.a.p.b.a
        public Request request() {
            return this.f1238b;
        }
    }

    public m(anetwork.channel.entity.k kVar, anetwork.channel.entity.g gVar) {
        gVar.a(kVar.f2229i);
        this.f1236a = new l(kVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f1236a.f1235f = ThreadPoolExecutorFactory.submitScheduledTask(new p(this), this.f1236a.f1230a.b(), TimeUnit.MILLISECONDS);
    }

    void b() {
        if (this.f1236a.f1233d.compareAndSet(false, true)) {
            ALog.e("anet.UnifiedRequestTask", "task cancelled", this.f1236a.f1232c, "URL", this.f1236a.f1230a.f().simpleUrlString());
            RequestStatistic requestStatistic = this.f1236a.f1230a.f2226f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.ret = 2;
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_CANCEL;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_CANCEL);
                requestStatistic.rspEnd = System.currentTimeMillis();
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_CANCEL, null, requestStatistic, null));
                if (requestStatistic.recDataSize > OSSConstants.MIN_PART_SIZE_LIMIT) {
                    anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.recDataSize);
                }
            }
            this.f1236a.b();
            this.f1236a.a();
            l lVar = this.f1236a;
            lVar.f1231b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_CANCEL, (String) null, lVar.f1230a.a()));
        }
    }

    public Future a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        anetwork.channel.entity.k kVar = this.f1236a.f1230a;
        RequestStatistic requestStatistic = kVar.f2226f;
        requestStatistic.reqServiceTransmissionEnd = jCurrentTimeMillis;
        requestStatistic.start = jCurrentTimeMillis;
        requestStatistic.isReqSync = kVar.c();
        this.f1236a.f1230a.f2226f.isReqMain = Looper.myLooper() == Looper.getMainLooper();
        try {
            this.f1236a.f1230a.f2226f.netReqStart = Long.valueOf(this.f1236a.f1230a.a(a.a.u.a.o)).longValue();
        } catch (Exception unused) {
        }
        String strA = this.f1236a.f1230a.a(a.a.u.a.p);
        if (!TextUtils.isEmpty(strA)) {
            this.f1236a.f1230a.f2226f.traceId = strA;
        }
        String strA2 = this.f1236a.f1230a.a(a.a.u.a.q);
        anetwork.channel.entity.k kVar2 = this.f1236a.f1230a;
        RequestStatistic requestStatistic2 = kVar2.f2226f;
        requestStatistic2.process = strA2;
        requestStatistic2.pTraceId = kVar2.a(a.a.u.a.r);
        l lVar = this.f1236a;
        ALog.e("anet.UnifiedRequestTask", "[traceId:" + strA + "]start", lVar.f1232c, "bizId", lVar.f1230a.a().getBizId(), "processFrom", strA2, "url", this.f1236a.f1230a.g());
        if (!a.a.k.b.a(this.f1236a.f1230a.f())) {
            ThreadPoolExecutorFactory.submitPriorityTask(new o(this), ThreadPoolExecutorFactory.Priority.HIGH);
            return new f(this);
        }
        d dVar = new d(this.f1236a);
        this.f1236a.f1234e = dVar;
        dVar.f1189b = new anet.channel.request.b(ThreadPoolExecutorFactory.submitBackupTask(new n(this)), this.f1236a.f1230a.a().getSeq());
        c();
        return new f(this);
    }
}
