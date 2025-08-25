package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.bh;
import com.xiaomi.push.cg;
import com.xiaomi.push.cn;
import com.xiaomi.push.ct;
import com.xiaomi.push.cx;
import com.xiaomi.push.db;
import com.xiaomi.push.dp;
import com.xiaomi.push.dt;
import com.xiaomi.push.dz;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.er;
import com.xiaomi.push.ey;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fd;
import com.xiaomi.push.ff;
import com.xiaomi.push.fg;
import com.xiaomi.push.fi;
import com.xiaomi.push.fk;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fz;
import com.xiaomi.push.ga;
import com.xiaomi.push.gd;
import com.xiaomi.push.gf;
import com.xiaomi.push.gk;
import com.xiaomi.push.hb;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.n;
import com.xiaomi.push.service.q;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class XMPushService extends Service implements fd {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f13275b = false;

    /* renamed from: a, reason: collision with other field name */
    private ContentObserver f934a;

    /* renamed from: a, reason: collision with other field name */
    private ey f936a;

    /* renamed from: a, reason: collision with other field name */
    private fa f937a;

    /* renamed from: a, reason: collision with other field name */
    private fb f938a;

    /* renamed from: a, reason: collision with other field name */
    private a f940a;

    /* renamed from: a, reason: collision with other field name */
    private f f941a;

    /* renamed from: a, reason: collision with other field name */
    private k f942a;

    /* renamed from: a, reason: collision with other field name */
    private r f943a;

    /* renamed from: a, reason: collision with other field name */
    private t f944a;

    /* renamed from: a, reason: collision with other field name */
    private as f946a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.h f947a;

    /* renamed from: a, reason: collision with other field name */
    private Object f950a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f953a = false;

    /* renamed from: a, reason: collision with root package name */
    private int f13276a = 0;

    /* renamed from: b, reason: collision with other field name */
    private int f954b = 0;

    /* renamed from: a, reason: collision with other field name */
    private long f933a = 0;

    /* renamed from: a, reason: collision with other field name */
    protected Class f949a = XMJobService.class;

    /* renamed from: c, reason: collision with root package name */
    private int f13277c = -1;

    /* renamed from: a, reason: collision with other field name */
    private ak f945a = null;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.n f948a = null;

    /* renamed from: a, reason: collision with other field name */
    Messenger f935a = null;

    /* renamed from: a, reason: collision with other field name */
    private Collection<aa> f952a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<n> f951a = new ArrayList<>();

    /* renamed from: a, reason: collision with other field name */
    private ff f939a = new ff() { // from class: com.xiaomi.push.service.XMPushService.1
        @Override // com.xiaomi.push.ff
        public void a(fo foVar) {
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new m(foVar));
        }

        @Override // com.xiaomi.push.ff
        public void a(er erVar) {
            if (com.xiaomi.push.service.e.a(erVar)) {
                at.a().a(erVar.e(), SystemClock.elapsedRealtime(), XMPushService.this.m659a());
            }
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new d(erVar));
        }
    };

    private class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with other field name */
        private final Object f960a;

        private a() {
            this.f960a = new Object();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!an.q.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.m50a("[Alarm] cancel the old ping timer");
                dz.a();
                return;
            }
            if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000L);
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }

        private void a(long j2) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f960a) {
                try {
                    this.f960a.wait(j2);
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Alarm] interrupt from waiting state. " + e2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f960a) {
                try {
                    this.f960a.notifyAll();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Alarm] notify lock. " + e2);
                }
            }
        }
    }

    static class c extends j {

        /* renamed from: a, reason: collision with root package name */
        private final am.b f13295a;

        public c(am.b bVar) {
            super(12);
            this.f13295a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            this.f13295a.a(am.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).f13295a.f13350g, this.f13295a.f13350g);
            }
            return false;
        }

        public int hashCode() {
            return this.f13295a.f13350g.hashCode();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind time out. chid=" + this.f13295a.f13350g;
        }
    }

    class d extends j {

        /* renamed from: a, reason: collision with root package name */
        private er f13296a;

        public d(er erVar) {
            super(8);
            this.f13296a = null;
            this.f13296a = erVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            XMPushService.this.f945a.a(this.f13296a);
            if (com.xiaomi.push.service.e.a(this.f13296a)) {
                XMPushService.this.a(new at.a(), 15000L);
            }
        }
    }

    public class e extends j {
        e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            if (XMPushService.this.m663a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("should not connect. quit the job.");
        }
    }

    class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.au.m150a();
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class g extends j {

        /* renamed from: a, reason: collision with other field name */
        public Exception f963a;

        /* renamed from: b, reason: collision with root package name */
        public int f13300b;

        g(int i2, Exception exc) {
            super(2);
            this.f13300b = i2;
            this.f963a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            XMPushService.this.a(this.f13300b, this.f963a);
        }
    }

    class h extends j {
        h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            XMPushService.this.c();
        }
    }

    class i extends j {

        /* renamed from: a, reason: collision with root package name */
        private Intent f13302a;

        public i(Intent intent) {
            super(15);
            this.f13302a = null;
            this.f13302a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() throws PackageManager.NameNotFoundException, NumberFormatException {
            XMPushService.this.d(this.f13302a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Handle intent action = " + this.f13302a.getAction();
        }
    }

    public static abstract class j extends n.b {
        public j(int i2) {
            super(i2);
        }

        public abstract String a();

        /* renamed from: a */
        public abstract void mo379a();

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f13433a;
            if (i2 != 4 && i2 != 8) {
                com.xiaomi.channel.commonutils.logger.b.m51a(com.xiaomi.channel.commonutils.logger.a.f12318a, a());
            }
            mo379a();
        }
    }

    class k extends BroadcastReceiver {
        k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m50a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            XMPushService.this.f948a.m730a();
        }
    }

    class m extends j {

        /* renamed from: a, reason: collision with root package name */
        private fo f13305a;

        public m(fo foVar) {
            super(8);
            this.f13305a = null;
            this.f13305a = foVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            XMPushService.this.f945a.a(this.f13305a);
        }
    }

    public interface n {
        /* renamed from: a */
        void mo458a();
    }

    class o extends j {

        /* renamed from: a, reason: collision with other field name */
        boolean f966a;

        public o(boolean z) {
            super(4);
            this.f966a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            if (XMPushService.this.m668c()) {
                try {
                    if (!this.f966a) {
                        ep.a();
                    }
                    XMPushService.this.f937a.b(this.f966a);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
        }
    }

    class q extends j {
        q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m663a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    class r extends BroadcastReceiver {
        r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    class t extends BroadcastReceiver {
        t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f953a) {
                XMPushService.this.f953a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    private void d() {
        com.xiaomi.push.av avVarM144a = com.xiaomi.push.au.m144a();
        com.xiaomi.push.service.m.a(getApplicationContext()).a(avVarM144a);
        if (avVarM144a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + avVarM144a.m154a() + "[" + avVarM144a.m156b() + "], state: " + avVarM144a.m153a() + "/" + avVarM144a.m152a());
            com.xiaomi.channel.commonutils.logger.b.m51a("XMPushService", sb.toString());
            NetworkInfo.State stateM153a = avVarM144a.m153a();
            if (stateM153a == NetworkInfo.State.SUSPENDED || stateM153a == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m51a("XMPushService", "network changed, no active network");
        }
        if (eo.a() != null) {
            eo.a().m381a();
        }
        fz.m447a((Context) this);
        this.f936a.d();
        if (com.xiaomi.push.au.m151a((Context) this)) {
            if (m668c() && m655f()) {
                b(false);
            }
            if (!m668c() && !m669d()) {
                this.f948a.a(1);
                a(new e());
            }
            db.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m663a()) {
            dz.a();
        } else {
            if (dz.m371a()) {
                return;
            }
            dz.a(true);
        }
    }

    /* renamed from: f, reason: collision with other method in class */
    private boolean m655f() {
        if (SystemClock.elapsedRealtime() - this.f933a < 30000) {
            return false;
        }
        return com.xiaomi.push.au.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: collision with other method in class */
    public boolean m656g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h, reason: collision with other method in class */
    private boolean m657h() {
        boolean zEquals;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("current sdk expect region is cn");
            zEquals = com.xiaomi.push.n.China.name().equals(com.xiaomi.push.service.b.a(getApplicationContext()).a());
        } else {
            zEquals = !com.xiaomi.push.service.r.a(this).m746b(packageName);
        }
        if (!zEquals) {
            com.xiaomi.channel.commonutils.logger.b.m52a("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(zEquals), ", package=", packageName, ", region=", com.xiaomi.push.service.b.a(getApplicationContext()).a());
        }
        return zEquals;
    }

    /* renamed from: i, reason: collision with other method in class */
    private boolean m658i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m620b((Context) this) && !com.xiaomi.push.i.m617a(getApplicationContext());
    }

    private boolean j() {
        int iIntValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f13276a;
        int i3 = this.f954b;
        if (i2 > i3) {
            if (iIntValue >= i2 || iIntValue < i3) {
                return true;
            }
        } else if (i2 < i3 && iIntValue >= i2 && iIntValue < i3) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ah.a(this).a(gk.ForegroundServiceSwitch.a(), false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f935a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() throws PackageManager.NameNotFoundException {
        String[] strArrSplit;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        C0343r.a((Context) this);
        com.xiaomi.push.service.p pVarM741a = com.xiaomi.push.service.q.m741a((Context) this);
        if (pVarM741a != null) {
            com.xiaomi.push.x.a(pVarM741a.f13445a);
        }
        if (com.xiaomi.push.j.m627a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f940a = new a();
            com.xiaomi.push.m.a(this, this.f940a, new IntentFilter(an.q), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            f13275b = true;
            handler.post(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m50a("[Alarm] disable ping receiver may be failure. " + th);
                    }
                }
            });
        }
        this.f935a = new Messenger(new Handler() { // from class: com.xiaomi.push.service.XMPushService.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    try {
                        int i2 = message.what;
                        if (i2 != 17) {
                            if (i2 == 18) {
                                Message messageObtain = Message.obtain((Handler) null, 0);
                                messageObtain.what = 18;
                                Bundle bundle = new Bundle();
                                bundle.putString("xmsf_region", com.xiaomi.push.service.b.a(XMPushService.this.getApplicationContext()).a());
                                messageObtain.setData(bundle);
                                message.replyTo.send(messageObtain);
                            }
                        } else if (message.obj != null) {
                            XMPushService.this.onStart((Intent) message.obj, 1);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        ao.a(this);
        this.f938a = new fb(null, 5222, "xiaomi.com", null) { // from class: com.xiaomi.push.service.XMPushService.9
            @Override // com.xiaomi.push.fb
            /* renamed from: a */
            public byte[] mo422a() {
                try {
                    dp.b bVar = new dp.b();
                    bVar.a(ax.a().m708a());
                    return bVar.m374a();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("getOBBString err: " + e2.toString());
                    return null;
                }
            }
        };
        this.f938a.a(true);
        this.f936a = new ey(this, this.f938a);
        this.f947a = m661a();
        dz.a(this);
        this.f936a.a(this);
        this.f945a = new ak(this);
        this.f946a = new as(this);
        new com.xiaomi.push.service.i().a();
        eo.m382a().a(this);
        this.f948a = new com.xiaomi.push.service.n("Connection Controller Thread");
        am amVarA = am.a();
        amVarA.b();
        amVarA.a(new am.a() { // from class: com.xiaomi.push.service.XMPushService.10
            @Override // com.xiaomi.push.service.am.a
            public void a() {
                XMPushService.this.e();
                if (am.a().m691a() <= 0) {
                    XMPushService xMPushService = XMPushService.this;
                    xMPushService.a(xMPushService.new g(12, null));
                }
            }
        });
        if (k()) {
            h();
        }
        gd.a(this).a(new com.xiaomi.push.service.o(this), "UPLOADER_PUSH_CHANNEL");
        a(new ga(this));
        a(new bd(this));
        if (com.xiaomi.push.j.m627a((Context) this)) {
            a(new al());
            if (com.xiaomi.push.i.m616a()) {
                a(new n() { // from class: com.xiaomi.push.service.XMPushService.11
                    @Override // com.xiaomi.push.service.XMPushService.n
                    /* renamed from: a */
                    public void mo458a() {
                        bh.a(XMPushService.this.getApplicationContext());
                    }
                });
            }
        }
        a(new h());
        this.f952a.add(ay.a(this));
        if (m657h()) {
            this.f941a = new f();
            com.xiaomi.push.m.a(this, this.f941a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
            this.f950a = com.xiaomi.push.au.m146a((Context) this);
        }
        if (com.xiaomi.push.j.m627a(getApplicationContext())) {
            this.f944a = new t();
            com.xiaomi.push.m.a(this, this.f944a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            this.f942a = new k();
            com.xiaomi.push.m.a(this, this.f942a, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f934a = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.push.service.XMPushService.12
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        super.onChange(z);
                        boolean zM656g = XMPushService.this.m656g();
                        com.xiaomi.channel.commonutils.logger.b.m50a("SuperPowerMode:" + zM656g);
                        XMPushService.this.e();
                        if (!zM656g) {
                            XMPushService.this.a(true);
                        } else {
                            XMPushService xMPushService = XMPushService.this;
                            xMPushService.a(xMPushService.new g(24, null));
                        }
                    }
                };
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f934a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] iArrM652a = m652a();
            if (iArrM652a != null) {
                this.f943a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                com.xiaomi.push.m.a(this, this.f943a, intentFilter, (String) null, (Handler) null);
                this.f13276a = iArrM652a[0];
                this.f954b = iArrM652a[1];
                com.xiaomi.channel.commonutils.logger.b.m50a("falldown initialized: " + this.f13276a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f954b);
            }
        }
        cn.a(this, this.f936a);
        ct.a(this, this.f936a);
        String str = "";
        if (pVarM741a != null) {
            try {
                if (!TextUtils.isEmpty(pVarM741a.f1067a) && (strArrSplit = pVarM741a.f1067a.split("@")) != null && strArrSplit.length > 0) {
                    str = strArrSplit[0];
                }
            } catch (Exception unused) {
            }
        }
        cx.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f941a;
        if (fVar != null) {
            a(fVar);
            this.f941a = null;
        }
        Object obj = this.f950a;
        if (obj != null) {
            com.xiaomi.push.au.a(this, obj);
            this.f950a = null;
        }
        t tVar = this.f944a;
        if (tVar != null) {
            a(tVar);
            this.f944a = null;
        }
        k kVar = this.f942a;
        if (kVar != null) {
            a(kVar);
            this.f942a = null;
        }
        r rVar = this.f943a;
        if (rVar != null) {
            a(rVar);
            this.f943a = null;
        }
        a aVar = this.f940a;
        if (aVar != null) {
            a(aVar);
            this.f940a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f934a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f934a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f952a.clear();
        this.f948a.m733b();
        a(new j(2) { // from class: com.xiaomi.push.service.XMPushService.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "disconnect for service destroy.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                if (XMPushService.this.f937a != null) {
                    XMPushService.this.f937a.b(15, (Exception) null);
                    XMPushService.this.f937a = null;
                }
            }
        });
        a(new l());
        am.a().b();
        am.a().a(this, 15);
        am.a().m695a();
        this.f936a.b(this);
        ax.a().m710a();
        dz.a();
        i();
        cn.b(this, this.f936a);
        ct.b(this, this.f936a);
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m50a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(an.v);
                String stringExtra2 = intent.getStringExtra(an.F);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || "miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", intent.getAction(), stringExtra, stringExtra2, stringExtra3, com.xiaomi.push.j.a(intent)));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m51a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), stringExtra, stringExtra2, stringExtra3));
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f948a.m731a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    am.a().a(this, 14);
                    stopSelf();
                } else {
                    a(new i(intent));
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                a(new i(intent));
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + jCurrentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return com.xiaomi.push.j.m627a((Context) this) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        cg.a().m237d();
        com.xiaomi.push.service.m.a(getApplicationContext()).m724a();
        com.xiaomi.push.service.b bVarA = com.xiaomi.push.service.b.a(getApplicationContext());
        String strA = bVarA.a();
        com.xiaomi.channel.commonutils.logger.b.m51a("XMPushService", "region of cache is " + strA);
        if (TextUtils.isEmpty(strA)) {
            String strB = b();
            str = strB;
            strA = com.xiaomi.push.j.a(strB).name();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(strA) && com.xiaomi.push.n.China.name().equals(strA)) {
            bVarA.a(strA, true);
            bVarA.b("CN", true);
            str = "CN";
        } else if (TextUtils.isEmpty(strA)) {
            strA = com.xiaomi.push.n.China.name();
        } else {
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                strA = "";
                str = strA;
            } else {
                strA = com.xiaomi.push.n.China.name();
                str = "CN";
            }
            bVarA.a(strA, true);
            bVarA.b(str, true);
        }
        com.xiaomi.channel.commonutils.logger.b.m52a("XMPushService", "after check, appRegion is ", strA, ", countryCode=", str);
        if (com.xiaomi.push.n.China.name().equals(strA)) {
            fb.a("cn.app.chat.xiaomi.net");
        }
        a(strA);
        if (m657h()) {
            com.xiaomi.channel.commonutils.logger.b.m51a("XMPushService", "-->postOnCreate(): try trigger connect now");
            final j jVar = new j(11) { // from class: com.xiaomi.push.service.XMPushService.13
                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "prepare the mi push account.";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* renamed from: a */
                public void mo379a() {
                    w.a(XMPushService.this);
                    if (com.xiaomi.push.au.m151a((Context) XMPushService.this)) {
                        XMPushService.this.a(true);
                    }
                }
            };
            a(jVar);
            com.xiaomi.push.service.q.a(new q.a() { // from class: com.xiaomi.push.service.XMPushService.14
                @Override // com.xiaomi.push.service.q.a
                public void a() {
                    XMPushService.this.a(jVar);
                }
            });
        }
        try {
            if (C0343r.m638a()) {
                this.f947a.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            com.xiaomi.push.g.a((Context) this, getApplicationInfo(), true);
        }
    }

    private String b() {
        String strA;
        com.xiaomi.push.ag.a();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            ap apVarA = ap.a(this);
            String strA2 = null;
            while (true) {
                if (!TextUtils.isEmpty(strA2) && apVarA.a() != 0) {
                    strA = a();
                    break;
                }
                if (TextUtils.isEmpty(strA2)) {
                    strA2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
        } else {
            strA = "CN";
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("wait coutrycode :" + strA + " cost = " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " , count = " + i2);
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        fa faVar = this.f937a;
        if (faVar != null && faVar.m418b()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
            return;
        }
        fa faVar2 = this.f937a;
        if (faVar2 != null && faVar2.m419c()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
            return;
        }
        this.f938a.b(com.xiaomi.push.au.m147a((Context) this));
        g();
        if (this.f937a == null) {
            am.a().a(this);
            c(false);
        }
    }

    private void g() {
        try {
            this.f936a.a(this.f939a, new fk() { // from class: com.xiaomi.push.service.XMPushService.5
                @Override // com.xiaomi.push.fk
                /* renamed from: a */
                public boolean mo240a(fo foVar) {
                    return true;
                }
            });
            this.f936a.e();
            this.f937a = this.f936a;
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f936a.b(3, e2);
        }
    }

    private void i() {
        synchronized (this.f951a) {
            this.f951a.clear();
        }
    }

    class p extends j {

        /* renamed from: a, reason: collision with other field name */
        am.b f967a;

        public p(am.b bVar) {
            super(4);
            this.f967a = null;
            this.f967a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            try {
                this.f967a.a(am.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f937a.a(this.f967a.f13350g, this.f967a.f1001b);
                XMPushService.this.a(XMPushService.this.new b(this.f967a), 300L);
            } catch (fi e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                XMPushService.this.a(10, e2);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "rebind the client. " + this.f967a.f13350g;
        }
    }

    class s extends j {

        /* renamed from: a, reason: collision with other field name */
        am.b f968a;

        /* renamed from: a, reason: collision with other field name */
        String f969a;

        /* renamed from: b, reason: collision with root package name */
        int f13311b;

        /* renamed from: b, reason: collision with other field name */
        String f970b;

        public s(am.b bVar, int i2, String str, String str2) {
            super(9);
            this.f968a = null;
            this.f968a = bVar;
            this.f13311b = i2;
            this.f969a = str;
            this.f970b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            if (this.f968a.f996a != am.c.unbind && XMPushService.this.f937a != null) {
                try {
                    XMPushService.this.f937a.a(this.f968a.f13350g, this.f968a.f1001b);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
            this.f968a.a(am.c.unbind, this.f13311b, 0, this.f970b, this.f969a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "unbind the channel. " + this.f968a.f13350g;
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    public static boolean m654e() {
        return f13275b;
    }

    class b extends j {

        /* renamed from: a, reason: collision with other field name */
        am.b f961a;

        public b(am.b bVar) {
            super(9);
            this.f961a = null;
            this.f961a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            try {
                if (XMPushService.this.m668c()) {
                    am.b bVarA = am.a().a(this.f961a.f13350g, this.f961a.f1001b);
                    if (bVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.m50a("ignore bind because the channel " + this.f961a.f13350g + " is removed ");
                    } else if (bVarA.f996a == am.c.unbind) {
                        bVarA.a(am.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f937a.a(bVarA);
                        ep.a(XMPushService.this, bVarA);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m50a("trying duplicate bind, ingore! " + bVarA.f996a);
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e2);
                XMPushService.this.a(10, e2);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind the client. " + this.f961a.f13350g;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m659a() {
        if (this.f13277c < 0) {
            this.f13277c = com.xiaomi.push.g.a((Context) this, "com.xiaomi.xmsf");
        }
        return this.f13277c;
    }

    /* renamed from: a, reason: collision with other method in class */
    private int[] m652a() {
        String[] strArrSplit;
        String strA = ah.a(getApplicationContext()).a(gk.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(strA) && (strArrSplit = strA.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && strArrSplit.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(strArrSplit[0]).intValue();
                iArr[1] = Integer.valueOf(strArrSplit[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private void b(boolean z) {
        this.f933a = SystemClock.elapsedRealtime();
        if (!m668c()) {
            a(true);
        } else if (com.xiaomi.push.au.m151a((Context) this)) {
            c(new o(z));
        } else {
            c(new g(17, null));
            a(true);
        }
    }

    private String a() {
        String strM624a = com.xiaomi.push.j.m624a("ro.miui.region");
        return TextUtils.isEmpty(strM624a) ? com.xiaomi.push.j.m624a("ro.product.locale.region") : strM624a;
    }

    private void b(Intent intent) throws NumberFormatException {
        long j2;
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.J);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        am amVarA = am.a();
        er erVarA = null;
        if (bundleExtra != null) {
            fn fnVar = (fn) a(new fn(bundleExtra), stringExtra, stringExtra2);
            if (fnVar == null) {
                return;
            } else {
                erVarA = er.a(fnVar, amVarA.a(fnVar.k(), fnVar.m()).f13351h);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(an.s));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(an.t);
                String stringExtra4 = intent.getStringExtra(an.u);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                am.b bVarA = amVarA.a(stringExtra5, String.valueOf(j2));
                if (bVarA != null) {
                    er erVar = new er();
                    try {
                        erVar.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    erVar.a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    erVar.a(j2, stringExtra3, stringExtra4);
                    erVar.a(intent.getStringExtra("ext_pkt_id"));
                    erVar.a(byteArrayExtra, bVarA.f13351h);
                    com.xiaomi.channel.commonutils.logger.b.m50a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    erVarA = erVar;
                }
            }
        }
        if (erVarA != null) {
            c(new aw(this, erVarA));
        }
    }

    private static void a(String str) {
        if (com.xiaomi.push.n.China.name().equals(str)) {
            cg.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            cg.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            cg.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            cg.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            cg.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            cg.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            cg.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:152:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:363:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(android.content.Intent r15) throws android.content.pm.PackageManager.NameNotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 2266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.d(android.content.Intent):void");
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.J);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        fn[] fnVarArr = new fn[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            fnVarArr[i2] = new fn((Bundle) parcelableArrayExtra[i2]);
            fnVarArr[i2] = (fn) a(fnVarArr[i2], stringExtra, stringExtra2);
            if (fnVarArr[i2] == null) {
                return;
            }
        }
        am amVarA = am.a();
        er[] erVarArr = new er[fnVarArr.length];
        for (int i3 = 0; i3 < fnVarArr.length; i3++) {
            fn fnVar = fnVarArr[i3];
            erVarArr[i3] = er.a(fnVar, amVarA.a(fnVar.k(), fnVar.m()).f13351h);
        }
        c(new com.xiaomi.push.service.c(this, erVarArr));
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("digest");
        com.xiaomi.push.service.m.a(getApplicationContext()).m725a(string);
        cn.a(this, string);
    }

    /* renamed from: a, reason: collision with other method in class */
    void m662a() {
        if (SystemClock.elapsedRealtime() - this.f933a >= fg.a() && com.xiaomi.push.au.c(this)) {
            b(true);
        }
    }

    void a(final String str, final byte[] bArr, boolean z) {
        Collection<am.b> collectionM693a = am.a().m693a("5");
        if (collectionM693a.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.t.b(str, bArr);
            }
        } else if (collectionM693a.iterator().next().f996a == am.c.binded) {
            a(new j(4) { // from class: com.xiaomi.push.service.XMPushService.3
                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "send mi push message";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* renamed from: a */
                public void mo379a() {
                    try {
                        w.a(XMPushService.this, str, bArr);
                    } catch (fi e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        XMPushService.this.a(10, e2);
                    }
                }
            });
        } else if (z) {
            com.xiaomi.push.service.t.b(str, bArr);
        }
    }

    private void c(j jVar) {
        this.f948a.a(jVar);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m50a("register request without payload");
            return;
        }
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            if (hbVar.f717a == gf.Registration) {
                hf hfVar = new hf();
                try {
                    hp.a(hfVar, hbVar.m535a());
                    a(new com.xiaomi.push.service.s(this, hbVar.b(), hfVar.b(), hfVar.c(), bArr));
                    dt.a(getApplicationContext()).a(hbVar.b(), "E100003", hfVar.a(), AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, null);
                } catch (hu e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m50a("register request with invalid payload");
            }
        } catch (hu e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    private void c(boolean z) {
        try {
            if (C0343r.m638a()) {
                if (z) {
                    if (com.xiaomi.push.j.m627a((Context) this)) {
                        Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                        intent.addFlags(1073741824);
                        sendBroadcast(intent);
                    }
                    for (aa aaVar : (aa[]) this.f952a.toArray(new aa[0])) {
                        aaVar.mo712a();
                    }
                    return;
                }
                if (com.xiaomi.push.j.m627a((Context) this)) {
                    Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                    intent2.addFlags(1073741824);
                    sendBroadcast(intent2);
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m667b() {
        try {
            Class<?> clsA = C0343r.a(this, "miui.os.Build");
            Field field = clsA.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = clsA.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = clsA.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public com.xiaomi.push.service.h m665b() {
        return this.f947a;
    }

    public void b(j jVar) {
        this.f948a.a(jVar.f13433a, jVar);
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        eo.a().b(faVar);
        c(true);
        this.f946a.m703a();
        if (!dz.m371a() && !m658i()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("reconnection successful, reactivate alarm.");
            dz.a(true);
        }
        Iterator<am.b> it = am.a().m692a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f953a || !com.xiaomi.push.j.m627a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.ae.a(getApplicationContext()).a(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.6
            @Override // java.lang.Runnable
            public void run() {
                XMPushService.this.f953a = true;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m50a("try to trigger the wifi digest broadcast.");
                    Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                    if (systemService != null) {
                        com.xiaomi.push.aw.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m668c() {
        fa faVar = this.f937a;
        return faVar != null && faVar.m419c();
    }

    /* renamed from: b, reason: collision with other method in class */
    void m666b() {
        com.xiaomi.push.service.m.a(getApplicationContext()).m729d();
        Iterator it = new ArrayList(this.f951a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).mo458a();
        }
    }

    private fo a(fo foVar, String str, String str2) {
        am amVarA = am.a();
        List<String> listM694a = amVarA.m694a(str);
        if (listM694a.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        foVar.o(str);
        String strK = foVar.k();
        if (TextUtils.isEmpty(strK)) {
            strK = listM694a.get(0);
            foVar.l(strK);
        }
        am.b bVarA = amVarA.a(strK, foVar.m());
        if (!m668c()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("drop a packet as the channel is not connected, chid=" + strK);
            return null;
        }
        if (bVarA != null && bVarA.f996a == am.c.binded) {
            if (TextUtils.equals(str2, bVarA.f13352i)) {
                return foVar;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("invalid session. " + str2);
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("drop a packet as the channel is not opened, chid=" + strK);
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m651a(String str, Intent intent) {
        am.b bVarA = am.a().a(str, intent.getStringExtra(an.s));
        boolean z = false;
        if (bVarA == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(an.J);
        String stringExtra2 = intent.getStringExtra(an.B);
        if (!TextUtils.isEmpty(bVarA.f13352i) && !TextUtils.equals(stringExtra, bVarA.f13352i)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("session changed. old session=" + bVarA.f13352i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(bVarA.f13351h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.ba.a(stringExtra2));
        return true;
    }

    private am.b a(String str, Intent intent) {
        am.b bVarA = am.a().a(str, intent.getStringExtra(an.s));
        if (bVarA == null) {
            bVarA = new am.b(this);
        }
        bVarA.f13350g = intent.getStringExtra(an.v);
        bVarA.f1001b = intent.getStringExtra(an.s);
        bVarA.f13346c = intent.getStringExtra(an.z);
        bVarA.f998a = intent.getStringExtra(an.F);
        bVarA.f13348e = intent.getStringExtra(an.D);
        bVarA.f13349f = intent.getStringExtra(an.E);
        bVarA.f1000a = intent.getBooleanExtra(an.C, false);
        bVarA.f13351h = intent.getStringExtra(an.B);
        bVarA.f13352i = intent.getStringExtra(an.J);
        bVarA.f13347d = intent.getStringExtra(an.A);
        bVarA.f997a = this.f947a;
        bVarA.a((Messenger) intent.getParcelableExtra(an.N));
        bVarA.f990a = getApplicationContext();
        am.a().a(bVarA);
        return bVarA;
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        am.b bVarA = am.a().a(str, str2);
        if (bVarA != null) {
            a(new s(bVarA, i2, str4, str3));
        }
        am.a().m697a(str, str2);
    }

    private void a(String str, int i2) {
        Collection<am.b> collectionM693a = am.a().m693a(str);
        if (collectionM693a != null) {
            for (am.b bVar : collectionM693a) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        am.a().m696a(str);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.f948a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("can't execute job err = " + e2.getMessage());
        }
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public void a(er erVar) throws fi {
        fa faVar = this.f937a;
        if (faVar != null) {
            faVar.b(erVar);
            return;
        }
        throw new fi("try send msg while connection is null.");
    }

    public void a(er[] erVarArr) throws fi {
        fa faVar = this.f937a;
        if (faVar != null) {
            faVar.a(erVarArr);
            return;
        }
        throw new fi("try send msg while connection is null.");
    }

    public void a(boolean z) {
        this.f946a.a(z);
    }

    public void a(am.b bVar) {
        if (bVar != null) {
            long jA = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m50a("schedule rebind job in " + (jA / 1000));
            a(new b(bVar), jA);
        }
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        fa faVar = this.f937a;
        sb.append(faVar == null ? null : Integer.valueOf(faVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m50a(sb.toString());
        fa faVar2 = this.f937a;
        if (faVar2 != null) {
            faVar2.b(i2, exc);
            this.f937a = null;
        }
        a(7);
        a(4);
        am.a().a(this, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m663a() {
        boolean zM151a = com.xiaomi.push.au.m151a((Context) this);
        boolean z = am.a().m691a() > 0;
        boolean z2 = !m667b();
        boolean zM657h = m657h();
        boolean z3 = !m656g();
        boolean z4 = zM151a && z && z2 && zM657h && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(zM151a), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(zM657h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a, reason: collision with other method in class */
    public com.xiaomi.push.service.h m661a() {
        return new com.xiaomi.push.service.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) throws InterruptedException {
        try {
            com.xiaomi.push.ag.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.au.b(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public fa m660a() {
        return this.f937a;
    }

    public void a(int i2) {
        this.f948a.a(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m664a(int i2) {
        return this.f948a.m732a(i2);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        eo.a().a(faVar);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i2, Exception exc) {
        eo.a().a(faVar, i2, exc);
        if (m658i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
        eo.a().a(faVar, exc);
        c(false);
        if (m658i()) {
            return;
        }
        a(false);
    }

    public void a(n nVar) {
        synchronized (this.f951a) {
            this.f951a.add(nVar);
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m669d() {
        fa faVar = this.f937a;
        return faVar != null && faVar.m418b();
    }
}
