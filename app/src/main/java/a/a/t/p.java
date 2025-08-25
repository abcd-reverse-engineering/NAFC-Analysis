package a.a.t;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f1243a;

    p(m mVar) {
        this.f1243a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1243a.f1236a.f1233d.compareAndSet(false, true)) {
            RequestStatistic requestStatistic = this.f1243a.f1236a.f1230a.f2226f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_TIME_OUT;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_TIME_OUT);
                requestStatistic.rspEnd = System.currentTimeMillis();
                ALog.e("anet.UnifiedRequestTask", "task time out", this.f1243a.f1236a.f1232c, "rs", requestStatistic);
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_TIME_OUT, null, requestStatistic, null));
            }
            this.f1243a.f1236a.b();
            l lVar = this.f1243a.f1236a;
            lVar.f1231b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_TIME_OUT, (String) null, lVar.f1230a.a()));
        }
    }
}
