package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class ResolutionFlagUtil {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ResolutionFlagUtil f7405a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f7406b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f7407c = new Object();

    private ResolutionFlagUtil() {
    }

    private void a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String str : f7406b.keySet()) {
            Map<String, Long> map = f7406b;
            Long l2 = map.get(str);
            if (l2 == null || l2.longValue() == 0) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + str);
            } else if (time >= l2.longValue()) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because aging time: " + str);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f7405a != null) {
            return f7405a;
        }
        synchronized (f7407c) {
            if (f7405a == null) {
                f7405a = new ResolutionFlagUtil();
            }
        }
        return f7405a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return 0L;
        }
        Map<String, Long> map = f7406b;
        if (map.get(str) != null) {
            return map.get(str).longValue();
        }
        return 0L;
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
        } else {
            f7406b.remove(str);
            HMSLog.i("ResolutionFlagUtil", "remove resolution flag");
        }
    }

    public void saveResolutionFlag(String str, long j2) {
        if (!TextUtils.isEmpty(str) && j2 != 0) {
            a(str, j2);
            return;
        }
        HMSLog.e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j2);
    }

    private void a(String str, long j2) {
        Map<String, Long> map = f7406b;
        synchronized (map) {
            a();
            map.put(str, Long.valueOf(j2));
            HMSLog.i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
