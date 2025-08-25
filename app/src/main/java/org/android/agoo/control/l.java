package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17346a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17347b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17348c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f17349d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NotifManager f17350e;

    l(NotifManager notifManager, String str, String str2, String str3, boolean z) {
        this.f17350e = notifManager;
        this.f17346a = str;
        this.f17347b = str2;
        this.f17348c = str3;
        this.f17349d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HashMap map = new HashMap();
            map.put("thirdTokenType", this.f17346a);
            map.put("token", this.f17347b);
            map.put("appkey", Config.a(this.f17350e.mContext));
            map.put("utdid", com.taobao.accs.utl.j.b(this.f17350e.mContext));
            if (!TextUtils.isEmpty(this.f17348c)) {
                map.put("vendorSdkVersion", this.f17348c);
            }
            ALog.d("NotifManager", "report,utdid=" + com.taobao.accs.utl.j.b(this.f17350e.mContext) + ",regId=" + this.f17347b + ",type=" + this.f17346a, new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, "agooTokenReport", new JSONObject(map).toString().getBytes("UTF-8"), null, null, null, null);
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(this.f17350e.mContext, Config.a(this.f17350e.mContext), Config.c(this.f17350e.mContext));
            String strA = this.f17349d ? accsInstance.a(this.f17350e.mContext, accsRequest) : accsInstance.a(this.f17350e.mContext, accsRequest, new TaoBaseService.ExtraInfo());
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.i("NotifManager", "reportThirdPushToken,dataId=" + strA + ",regId=" + this.f17347b + ",type=" + this.f17346a, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", com.taobao.accs.utl.j.b(this.f17350e.mContext), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
