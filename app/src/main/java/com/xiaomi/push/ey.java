package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.dp;
import com.xiaomi.push.fa;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ey extends fh {

    /* renamed from: a, reason: collision with root package name */
    private et f12795a;

    /* renamed from: a, reason: collision with other field name */
    private eu f484a;

    /* renamed from: a, reason: collision with other field name */
    private Thread f485a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f486a;

    public ey(XMPushService xMPushService, fb fbVar) {
        super(xMPushService, fbVar);
    }

    private void h() throws fi {
        try {
            this.f12795a = new et(((fh) this).f514a.getInputStream(), this);
            this.f484a = new eu(((fh) this).f514a.getOutputStream(), this);
            this.f485a = new Thread("Blob Reader (" + ((fa) this).f12806b + ")") { // from class: com.xiaomi.push.ey.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ey.this.f12795a.m402a();
                    } catch (Exception e2) {
                        ey.this.c(9, e2);
                    }
                }
            };
            this.f485a.start();
        } catch (Exception e2) {
            throw new fi("Error to init reader and writer", e2);
        }
    }

    @Override // com.xiaomi.push.fa
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo407a() {
        return true;
    }

    void b(fo foVar) {
        if (foVar == null) {
            return;
        }
        Iterator<fa.a> it = ((fa) this).f503a.values().iterator();
        while (it.hasNext()) {
            it.next().a(foVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    synchronized byte[] m408a() {
        if (this.f486a == null && !TextUtils.isEmpty(((fa) this).f500a)) {
            String strM705a = com.xiaomi.push.service.ax.m705a();
            this.f486a = com.xiaomi.push.service.ar.a(((fa) this).f500a.getBytes(), (((fa) this).f500a.substring(((fa) this).f500a.length() / 2) + strM705a.substring(strM705a.length() / 2)).getBytes());
        }
        return this.f486a;
    }

    @Override // com.xiaomi.push.fa
    public void b(er erVar) throws fi {
        eu euVar = this.f484a;
        if (euVar != null) {
            try {
                int iA = euVar.a(erVar);
                ((fa) this).f12808d = SystemClock.elapsedRealtime();
                String strF = erVar.f();
                if (!TextUtils.isEmpty(strF)) {
                    fz.a(((fa) this).f499a, strF, iA, false, true, System.currentTimeMillis());
                }
                Iterator<fa.a> it = ((fa) this).f506b.values().iterator();
                while (it.hasNext()) {
                    it.next().a(erVar);
                }
                return;
            } catch (Exception e2) {
                throw new fi(e2);
            }
        }
        throw new fi("the writer is null.");
    }

    private er a(boolean z) {
        ex exVar = new ex();
        if (z) {
            exVar.a("1");
        }
        byte[] bArrM388a = ep.m388a();
        if (bArrM388a != null) {
            dp.j jVar = new dp.j();
            jVar.a(a.a(bArrM388a));
            exVar.a(jVar.m374a(), (String) null);
        }
        return exVar;
    }

    @Override // com.xiaomi.push.fh
    /* renamed from: a, reason: collision with other method in class */
    protected void mo406a(boolean z) throws fi {
        if (this.f484a != null) {
            er erVarA = a(z);
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] SND ping id=" + erVarA.e());
            b(erVarA);
            f();
            return;
        }
        throw new fi("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.fa
    public synchronized void a(am.b bVar) {
        eq.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fa
    public synchronized void a(String str, String str2) {
        eq.a(str, str2, this);
    }

    @Override // com.xiaomi.push.fh
    protected synchronized void a(int i2, Exception exc) {
        if (this.f12795a != null) {
            this.f12795a.b();
            this.f12795a = null;
        }
        if (this.f484a != null) {
            try {
                this.f484a.b();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("SlimConnection shutdown cause exception: " + e2);
            }
            this.f484a = null;
            this.f486a = null;
            super.a(i2, exc);
        } else {
            this.f486a = null;
            super.a(i2, exc);
        }
    }

    @Override // com.xiaomi.push.fh, com.xiaomi.push.fa
    public void a(er[] erVarArr) throws fi {
        for (er erVar : erVarArr) {
            b(erVar);
        }
    }

    @Override // com.xiaomi.push.fa
    @Deprecated
    public void a(fo foVar) throws fi {
        b(er.a(foVar, (String) null));
    }

    @Override // com.xiaomi.push.fh
    /* renamed from: a */
    protected synchronized void mo426a() {
        h();
        this.f484a.a();
    }

    void a(er erVar) {
        if (erVar == null) {
            return;
        }
        if (com.xiaomi.push.service.e.a(erVar)) {
            er erVar2 = new er();
            erVar2.a(erVar.a());
            erVar2.a("SYNC", "ACK_RTT");
            erVar2.a(erVar.e());
            erVar2.b(erVar.m396b());
            erVar2.a(erVar.m399c());
            XMPushService xMPushService = ((fa) this).f499a;
            xMPushService.a(new com.xiaomi.push.service.aw(xMPushService, erVar2));
        }
        if (erVar.m393a()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] RCV blob chid=" + erVar.a() + "; id=" + erVar.e() + "; errCode=" + erVar.b() + "; err=" + erVar.m400c());
        }
        if (erVar.a() == 0) {
            if ("PING".equals(erVar.m390a())) {
                com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] RCV ping id=" + erVar.e());
                g();
            } else if ("CLOSE".equals(erVar.m390a())) {
                c(13, null);
            }
        }
        Iterator<fa.a> it = ((fa) this).f503a.values().iterator();
        while (it.hasNext()) {
            it.next().a(erVar);
        }
    }
}
