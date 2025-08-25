package anet.channel.detect;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class i implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f1728a;

    i(h hVar) {
        this.f1728a = hVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        ALog.i("anet.HorseRaceDetector", "LongLinkTask request finish", this.f1728a.f1724c, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2), "msg", str);
        if (this.f1728a.f1722a.reqErrorCode == 0) {
            this.f1728a.f1722a.reqErrorCode = i2;
        } else {
            HorseRaceStat horseRaceStat = this.f1728a.f1722a;
            horseRaceStat.reqRet = horseRaceStat.reqErrorCode == 200 ? 1 : 0;
        }
        HorseRaceStat horseRaceStat2 = this.f1728a.f1722a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        h hVar = this.f1728a;
        horseRaceStat2.reqTime = (jCurrentTimeMillis - hVar.f1723b) + hVar.f1722a.connTime;
        synchronized (this.f1728a.f1722a) {
            this.f1728a.f1722a.notify();
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        this.f1728a.f1722a.reqErrorCode = i2;
    }
}
