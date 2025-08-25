package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: WeekOnCondition.java */
/* loaded from: classes2.dex */
public class aj implements aa {

    /* renamed from: a, reason: collision with root package name */
    private Set<Integer> f10033a;

    public aj(Set<Integer> set) {
        this.f10033a = null;
        this.f10033a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i2 = calendar.get(7) - 1;
            if (i2 == 0) {
                i2 = 7;
            }
            if (this.f10033a != null && this.f10033a.contains(Integer.valueOf(i2))) {
                return true;
            }
            String str = "";
            Iterator<Integer> it = this.f10033a.iterator();
            while (it.hasNext()) {
                str = str + it.next() + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "WeekOn skipped. day of week: " + i2 + "; config: " + str);
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }
}
