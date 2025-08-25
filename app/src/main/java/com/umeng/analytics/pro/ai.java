package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: TimePeriodItem.java */
/* loaded from: classes2.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    private String f10028a;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10032e = false;

    /* renamed from: d, reason: collision with root package name */
    private int f10031d = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f10030c = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f10029b = -1;

    public ai(String str) {
        this.f10028a = str;
        if (TextUtils.isEmpty(this.f10028a)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f10028a.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                this.f10031d = Integer.valueOf(this.f10028a).intValue();
                this.f10032e = false;
                return;
            }
            String[] strArrSplit = this.f10028a.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (strArrSplit.length == 2) {
                this.f10029b = Integer.valueOf(strArrSplit[0]).intValue();
                this.f10030c = Integer.valueOf(strArrSplit[1]).intValue();
                if (this.f10029b < 1) {
                    this.f10029b = 1;
                }
                if (this.f10030c > 24) {
                    this.f10030c = 24;
                }
            }
            this.f10032e = true;
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i2) {
        int i3;
        if (this.f10032e) {
            int i4 = this.f10029b;
            if (i4 != -1 && (i3 = this.f10030c) != -1 && i2 >= i4 && i2 <= i3) {
                return true;
            }
        } else {
            int i5 = this.f10031d;
            if (i5 != -1 && i2 == i5) {
                return true;
            }
        }
        return false;
    }
}
