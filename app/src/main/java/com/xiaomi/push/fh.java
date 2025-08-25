package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* loaded from: classes2.dex */
public abstract class fh extends fa {

    /* renamed from: a, reason: collision with root package name */
    protected Exception f12820a;

    /* renamed from: a, reason: collision with other field name */
    protected Socket f514a;

    /* renamed from: b, reason: collision with root package name */
    protected XMPushService f12821b;

    /* renamed from: c, reason: collision with root package name */
    private int f12822c;

    /* renamed from: c, reason: collision with other field name */
    String f515c;

    /* renamed from: d, reason: collision with root package name */
    private String f12823d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile long f12824e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile long f12825f;

    /* renamed from: g, reason: collision with root package name */
    protected volatile long f12826g;

    /* renamed from: h, reason: collision with root package name */
    private long f12827h;

    public fh(XMPushService xMPushService, fb fbVar) {
        super(xMPushService, fbVar);
        this.f12820a = null;
        this.f515c = null;
        this.f12824e = 0L;
        this.f12825f = 0L;
        this.f12826g = 0L;
        this.f12827h = 0L;
        this.f12821b = xMPushService;
    }

    public Context a() {
        return this.f12821b;
    }

    /* renamed from: a */
    protected abstract void mo406a(boolean z);

    @Override // com.xiaomi.push.fa
    public void b(boolean z) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        mo406a(z);
        com.xiaomi.push.service.m.a(this.f12821b).m728c();
        if (z) {
            return;
        }
        this.f12821b.a(new XMPushService.j(13) { // from class: com.xiaomi.push.fh.1
            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                Thread.yield();
                if (!fh.this.m419c() || fh.this.a(jElapsedRealtime)) {
                    return;
                }
                com.xiaomi.push.service.m.a(fh.this.f12821b).m727b();
                fh.this.f12821b.a(22, (Exception) null);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "check the ping-pong." + jCurrentTimeMillis;
            }
        }, com.heytap.mcssdk.constant.a.q);
    }

    public String c() {
        return ((fa) this).f500a;
    }

    public synchronized void e() {
        try {
            if (!m419c() && !m418b()) {
                a(0, 0, (Exception) null);
                a(((fa) this).f497a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new fi(e2);
        }
    }

    public void f() {
        this.f12824e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f12825f = SystemClock.elapsedRealtime();
    }

    @Override // com.xiaomi.push.fa
    /* renamed from: a */
    public String mo414a() {
        return this.f12823d;
    }

    public void c(final int i2, final Exception exc) {
        au.b();
        this.f12821b.a(new XMPushService.j(2) { // from class: com.xiaomi.push.fh.2
            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                fh.this.f12821b.a(i2, exc);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "shutdown the connection. " + i2 + ", " + exc;
            }
        });
    }

    protected synchronized void a(int i2, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i2, exc);
        ((fa) this).f500a = "";
        try {
            this.f514a.close();
        } catch (Throwable unused) {
        }
        this.f12824e = 0L;
        this.f12825f = 0L;
    }

    @Override // com.xiaomi.push.fa
    public void b(int i2, Exception exc) {
        a(i2, exc);
        if ((exc != null || i2 == 18) && this.f12826g != 0) {
            a(exc);
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f12826g < 300000) {
            if (au.m151a((Context) this.f12821b)) {
                this.f12822c++;
                if (this.f12822c >= 2) {
                    String strMo414a = mo414a();
                    com.xiaomi.channel.commonutils.logger.b.m50a("max short conn time reached, sink down current host:" + strMo414a);
                    a(strMo414a, 0L, exc);
                    this.f12822c = 0;
                    return;
                }
                return;
            }
            return;
        }
        this.f12822c = 0;
    }

    protected void a(String str, long j2, Exception exc) {
        cc ccVarA = cg.a().a(fb.a(), false);
        if (ccVarA != null) {
            ccVarA.b(str, j2, 0L, exc);
            cg.a().m236c();
        }
    }

    @Override // com.xiaomi.push.fa
    public void a(er[] erVarArr) throws fi {
        throw new fi("Don't support send Blob");
    }

    private void a(fb fbVar) throws Throwable {
        a(fbVar.c(), fbVar.m420a());
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x033d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r32, int r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fh.a(java.lang.String, int):void");
    }

    /* renamed from: a, reason: collision with other method in class */
    protected synchronized void mo426a() {
    }

    /* renamed from: a, reason: collision with other method in class */
    public Socket m425a() {
        return new Socket();
    }

    cc a(final String str) {
        cc ccVarA = cg.a().a(str, false);
        if (!ccVarA.b()) {
            fy.a(new Runnable() { // from class: com.xiaomi.push.fh.3
                @Override // java.lang.Runnable
                public void run() {
                    cg.a().a(str, true);
                }
            });
        }
        return ccVarA;
    }
}
