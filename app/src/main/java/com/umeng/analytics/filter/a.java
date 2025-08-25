package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventBlackList.java */
/* loaded from: classes2.dex */
public class a extends EventList {

    /* renamed from: a, reason: collision with root package name */
    private d f10000a;

    /* renamed from: b, reason: collision with root package name */
    private Object f10001b;

    public a(String str, String str2) {
        super(str, str2);
        this.f10001b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f10001b) {
            this.f10000a = null;
            this.f10000a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean zA;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f10001b) {
            if (this.f10000a == null) {
                this.f10000a = new d(false, this.mEventList);
            }
            zA = this.f10000a.a(str);
        }
        return zA;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}
