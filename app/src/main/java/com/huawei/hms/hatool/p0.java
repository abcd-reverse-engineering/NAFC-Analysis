package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: classes.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private long f7066a = 1800000;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f7067b = false;

    /* renamed from: c, reason: collision with root package name */
    private a f7068c = null;

    private class a {

        /* renamed from: a, reason: collision with root package name */
        String f7069a = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");

        /* renamed from: b, reason: collision with root package name */
        boolean f7070b;

        /* renamed from: c, reason: collision with root package name */
        private long f7071c;

        a(long j2) {
            this.f7069a += c.c.a.b.a.a.s1 + j2;
            this.f7071c = j2;
            this.f7070b = true;
            p0.this.f7067b = false;
        }

        private boolean a(long j2, long j3) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private void b(long j2) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String string = UUID.randomUUID().toString();
            this.f7069a = string;
            this.f7069a = string.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.f7069a += c.c.a.b.a.a.s1 + j2;
            this.f7071c = j2;
            this.f7070b = true;
        }

        private boolean b(long j2, long j3) {
            return j3 - j2 >= p0.this.f7066a;
        }

        void a(long j2) {
            if (p0.this.f7067b) {
                p0.this.f7067b = false;
                b(j2);
            } else if (b(this.f7071c, j2) || a(this.f7071c, j2)) {
                b(j2);
            } else {
                this.f7071c = j2;
                this.f7070b = false;
            }
        }
    }

    public String a() {
        a aVar = this.f7068c;
        if (aVar != null) {
            return aVar.f7069a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    void a(long j2) {
        a aVar = this.f7068c;
        if (aVar != null) {
            aVar.a(j2);
        } else {
            v.c("hmsSdk", "Session is first flush");
            this.f7068c = new a(j2);
        }
    }

    public boolean b() {
        a aVar = this.f7068c;
        if (aVar != null) {
            return aVar.f7070b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
