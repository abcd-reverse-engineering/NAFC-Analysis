package com.umeng.message.proguard;

import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes2.dex */
public final class al {

    /* renamed from: a, reason: collision with root package name */
    public final aq f11287a = new aq(AgooConstants.MESSAGE_NOTIFICATION);

    private long f() {
        return this.f11287a.b("rep_ts", 0L);
    }

    public final boolean a() {
        return this.f11287a.b("e_u", true);
    }

    public final long b() {
        return this.f11287a.b("req_ts", 0L);
    }

    public final boolean c() {
        return Math.abs(System.currentTimeMillis() - f()) < com.heytap.mcssdk.constant.a.f5800d;
    }

    public final String d() {
        String strB = this.f11287a.b("info", "");
        if (!TextUtils.isEmpty(strB)) {
            try {
                return new String(as.a(strB));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final boolean e() {
        return this.f11287a.b("sync", false);
    }

    public final void a(boolean z) {
        this.f11287a.a("e_s", z);
    }

    public final void b(boolean z) {
        this.f11287a.a("sync", z);
    }

    public final void a(long j2) {
        this.f11287a.a("rep_ts", j2);
    }
}
