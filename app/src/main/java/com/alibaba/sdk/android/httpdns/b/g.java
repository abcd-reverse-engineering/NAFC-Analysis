package com.alibaba.sdk.android.httpdns.b;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes.dex */
public class g {

    /* renamed from: i, reason: collision with root package name */
    public long f4010i;
    public long id;
    public String o;
    public String p;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[IpRecord] ");
        sb.append("id:");
        sb.append(this.id);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("host_id:");
        sb.append(this.f4010i);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("ip:");
        sb.append(this.o);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("ttl:");
        sb.append(this.p);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        return sb.toString();
    }
}
