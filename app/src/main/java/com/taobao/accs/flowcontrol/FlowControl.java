package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import c.c.a.b.a.a;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;

    /* renamed from: a, reason: collision with root package name */
    private Context f8478a;

    /* renamed from: b, reason: collision with root package name */
    private FlowCtrlInfoHolder f8479b;

    /* compiled from: Taobao */
    public static class FlowControlInfo implements Serializable {
        private static final long serialVersionUID = -2259991484877844919L;
        public String bizId;
        public long delayTime;
        public long expireTime;
        public String serviceId;
        public long startTime;
        public int status;

        public FlowControlInfo(String str, String str2, int i2, long j2, long j3, long j4) {
            this.serviceId = str;
            this.bizId = str2;
            this.status = i2;
            this.delayTime = j2;
            this.expireTime = j3 <= 0 ? 0L : j3;
            this.startTime = j4 > 0 ? j4 : 0L;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - (this.startTime + this.expireTime) > 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("flow ctrl serviceId:");
            stringBuffer.append(this.serviceId);
            stringBuffer.append(" bizId:");
            stringBuffer.append(this.bizId);
            stringBuffer.append(" status:");
            stringBuffer.append(this.status);
            stringBuffer.append(" delayTime:");
            stringBuffer.append(this.delayTime);
            stringBuffer.append(" startTime:");
            stringBuffer.append(this.startTime);
            stringBuffer.append(" expireTime:");
            stringBuffer.append(this.expireTime);
            return stringBuffer.toString();
        }
    }

    /* compiled from: Taobao */
    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        Map<String, FlowControlInfo> flowCtrlMap = null;

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str + a.s1 + str2;
            }
            return this.flowCtrlMap.get(str);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + a.s1 + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(str, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.f8478a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.util.Map<java.lang.Integer, java.lang.String> r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.flowcontrol.FlowControl.a(java.util.Map, java.lang.String):int");
    }

    private boolean a(long j2, long j3) {
        if (j2 != 0 && j3 > 0) {
            return true;
        }
        ALog.e("FlowControl", "error flow ctrl info", new Object[0]);
        return false;
    }

    public long a(String str, String str2) {
        long j2;
        long j3;
        long j4;
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f8479b;
        long j5 = 0;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        synchronized (this) {
            FlowControlInfo flowControlInfo = this.f8479b.get("ALL", null);
            FlowControlInfo flowControlInfo2 = this.f8479b.get(SERVICE_ALL_BRUSH, null);
            FlowControlInfo flowControlInfo3 = this.f8479b.get(str, null);
            FlowControlInfo flowControlInfo4 = this.f8479b.get(str, str2);
            j2 = (flowControlInfo == null || flowControlInfo.isExpired()) ? 0L : flowControlInfo.delayTime;
            long j6 = (flowControlInfo2 == null || flowControlInfo2.isExpired()) ? 0L : flowControlInfo2.delayTime;
            j3 = (flowControlInfo3 == null || flowControlInfo3.isExpired()) ? 0L : flowControlInfo3.delayTime;
            if (flowControlInfo4 != null && !flowControlInfo4.isExpired()) {
                j5 = flowControlInfo4.delayTime;
            }
            j4 = -1;
            if (j2 != -1 && j5 != -1 && j3 != -1) {
                if (j6 == -1) {
                    j4 = -1000;
                } else {
                    long j7 = j2 > j5 ? j2 : j5;
                    j4 = j7 > j3 ? j7 : j3;
                }
            }
            if ((flowControlInfo4 != null && flowControlInfo4.isExpired()) || (flowControlInfo != null && flowControlInfo.isExpired())) {
                a();
            }
        }
        ALog.e("FlowControl", "getFlowCtrlDelay service " + str + " biz " + str2 + " result:" + j4 + " global:" + j2 + " serviceDelay:" + j3 + " bidDelay:" + j5, new Object[0]);
        return j4;
    }

    private void a() {
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f8479b;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null) {
            return;
        }
        synchronized (this) {
            Iterator<Map.Entry<String, FlowControlInfo>> it = this.f8479b.flowCtrlMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().isExpired()) {
                    it.remove();
                }
            }
        }
    }
}
