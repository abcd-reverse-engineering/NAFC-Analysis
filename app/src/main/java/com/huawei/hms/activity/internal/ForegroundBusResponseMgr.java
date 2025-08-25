package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ForegroundBusResponseMgr {

    /* renamed from: b, reason: collision with root package name */
    private static final ForegroundBusResponseMgr f6534b = new ForegroundBusResponseMgr();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, BusResponseCallback> f6535a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return f6534b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f6535a) {
            busResponseCallback = this.f6535a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.f6535a) {
            if (!this.f6535a.containsKey(str)) {
                this.f6535a.put(str, busResponseCallback);
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f6535a) {
            this.f6535a.remove(str);
        }
    }
}
