package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* compiled from: TimePeriodChain.java */
/* loaded from: classes2.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private String f10026a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<ai> f10027b = new ArrayList<>();

    public ah(String str) {
        this.f10026a = "";
        this.f10026a = str;
        if (TextUtils.isEmpty(this.f10026a)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f10026a.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String str = this.f10026a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String strTrim = str.trim();
                if (this.f10027b != null) {
                    this.f10027b.add(new ai(strTrim));
                    return;
                }
                return;
            }
            for (String str2 : this.f10026a.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (!TextUtils.isEmpty(str2)) {
                    String strTrim2 = str2.trim();
                    if (this.f10027b != null) {
                        this.f10027b.add(new ai(strTrim2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i2) {
        try {
            if (this.f10027b == null) {
                return false;
            }
            int size = this.f10027b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ai aiVar = this.f10027b.get(i3);
                if (aiVar != null && aiVar.a(i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
