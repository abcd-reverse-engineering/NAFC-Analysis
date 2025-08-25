package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public class AgHmsUpdateState {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f7347c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static volatile AgHmsUpdateState f7348d;

    /* renamed from: a, reason: collision with root package name */
    private HmsCheckedState f7349a = HmsCheckedState.UNCHECKED;

    /* renamed from: b, reason: collision with root package name */
    private int f7350b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (f7348d == null) {
            synchronized (f7347c) {
                if (f7348d == null) {
                    f7348d = new AgHmsUpdateState();
                }
            }
        }
        return f7348d;
    }

    public HmsCheckedState getCheckedState() {
        return this.f7349a;
    }

    public int getTargetVersionCode() {
        return this.f7350b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.f7350b != 0;
    }

    public void resetUpdateState() {
        if (getCheckedState() != HmsCheckedState.NEED_UPDATE) {
            return;
        }
        setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        setTargetVersionCode(0);
    }

    public void setCheckedState(HmsCheckedState hmsCheckedState) {
        if (hmsCheckedState == null) {
            HMSLog.e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.f7349a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i2) {
        this.f7350b = i2;
    }
}
