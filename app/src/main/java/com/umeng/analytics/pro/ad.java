package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: HourOnCondition.java */
/* loaded from: classes2.dex */
public class ad implements aa {

    /* renamed from: a, reason: collision with root package name */
    private Set<Integer> f10022a;

    public ad(Set<Integer> set) {
        this.f10022a = null;
        this.f10022a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            int i2 = Calendar.getInstance().get(11);
            if (this.f10022a != null && this.f10022a.contains(Integer.valueOf(i2))) {
                return true;
            }
            String str = "";
            Iterator<Integer> it = this.f10022a.iterator();
            while (it.hasNext()) {
                str = str + it.next() + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "HourOn skipped. hour of day: " + i2 + "; config: " + str);
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
