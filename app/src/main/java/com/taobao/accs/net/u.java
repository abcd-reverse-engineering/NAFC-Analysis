package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.net.k;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class u implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IAuth.AuthCallback f8557a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ k.a f8558b;

    u(k.a aVar, IAuth.AuthCallback authCallback) {
        this.f8558b = aVar;
        this.f8557a = authCallback;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 < 0) {
            ALog.e(this.f8558b.f8535c, "auth onFinish", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2));
            this.f8557a.onAuthFail(i2, "onFinish auth fail");
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        ALog.e(this.f8558b.f8535c, "auth", "httpStatusCode", Integer.valueOf(i2));
        if (i2 == 200) {
            this.f8557a.onAuthSuccess();
            if (this.f8558b.f8536d instanceof k) {
                ((k) this.f8558b.f8536d).o();
            }
        } else {
            this.f8557a.onAuthFail(i2, "auth fail");
        }
        Map<String, String> mapA = UtilityImpl.a(map);
        ALog.d(this.f8558b.f8535c, "auth", "header", mapA);
        String str = mapA.get("x-at");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8558b.f8536d.f8510k = str;
    }
}
