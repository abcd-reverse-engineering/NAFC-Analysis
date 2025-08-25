package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.push.au;
import com.xiaomi.push.aw;
import com.xiaomi.push.ba;
import com.xiaomi.push.cs;
import com.xiaomi.push.dt;
import com.xiaomi.push.gf;
import com.xiaomi.push.gg;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hl;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static u f12395a = null;

    /* renamed from: a, reason: collision with other field name */
    private static final ArrayList<a> f133a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f12396b = false;

    /* renamed from: a, reason: collision with other field name */
    private long f134a;

    /* renamed from: a, reason: collision with other field name */
    private Context f135a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f137a;

    /* renamed from: a, reason: collision with other field name */
    private Messenger f138a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f142a;

    /* renamed from: a, reason: collision with other field name */
    private List<Message> f141a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f12397c = false;

    /* renamed from: b, reason: collision with other field name */
    private String f143b = null;

    /* renamed from: a, reason: collision with other field name */
    private Intent f136a = null;

    /* renamed from: a, reason: collision with other field name */
    private Integer f139a = null;

    /* renamed from: a, reason: collision with other field name */
    private String f140a = null;

    /* renamed from: com.xiaomi.mipush.sdk.u$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12402a = new int[v.values().length];

        static {
            try {
                f12402a[v.DISABLE_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12402a[v.ENABLE_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12402a[v.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12402a[v.UPLOAD_FCM_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12402a[v.UPLOAD_COS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12402a[v.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static class a<T extends hq<T, ?>> {

        /* renamed from: a, reason: collision with root package name */
        gf f12403a;

        /* renamed from: a, reason: collision with other field name */
        T f144a;

        /* renamed from: a, reason: collision with other field name */
        boolean f145a;

        a() {
        }
    }

    private u(Context context) {
        this.f142a = false;
        this.f137a = null;
        this.f135a = context.getApplicationContext();
        this.f142a = m113c();
        f12396b = m114d();
        this.f137a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.mipush.sdk.u.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message.what != 19) {
                    return;
                }
                String str = (String) message.obj;
                int i2 = message.arg1;
                synchronized (p.class) {
                    if (p.a(u.this.f135a).m105a(str)) {
                        if (p.a(u.this.f135a).a(str) < 10) {
                            String string = message.getData() != null ? message.getData().getString("third_sync_reason") : "";
                            if (v.DISABLE_PUSH.ordinal() == i2 && "syncing".equals(p.a(u.this.f135a).a(v.DISABLE_PUSH))) {
                                u.this.a(str, v.DISABLE_PUSH, true, (HashMap<String, String>) null);
                            } else if (v.ENABLE_PUSH.ordinal() == i2 && "syncing".equals(p.a(u.this.f135a).a(v.ENABLE_PUSH))) {
                                u.this.a(str, v.ENABLE_PUSH, true, (HashMap<String, String>) null);
                            } else if (v.UPLOAD_HUAWEI_TOKEN.ordinal() == i2 && "syncing".equals(p.a(u.this.f135a).a(v.UPLOAD_HUAWEI_TOKEN))) {
                                HashMap<String, String> mapM94a = f.m94a(u.this.f135a, d.ASSEMBLE_PUSH_HUAWEI);
                                mapM94a.put("third_sync_reason", string);
                                u.this.a(str, v.UPLOAD_HUAWEI_TOKEN, false, mapM94a);
                            } else if (v.UPLOAD_FCM_TOKEN.ordinal() == i2 && "syncing".equals(p.a(u.this.f135a).a(v.UPLOAD_FCM_TOKEN))) {
                                u.this.a(str, v.UPLOAD_FCM_TOKEN, false, f.m94a(u.this.f135a, d.ASSEMBLE_PUSH_FCM));
                            } else if (v.UPLOAD_COS_TOKEN.ordinal() == i2 && "syncing".equals(p.a(u.this.f135a).a(v.UPLOAD_COS_TOKEN))) {
                                HashMap<String, String> mapM94a2 = f.m94a(u.this.f135a, d.ASSEMBLE_PUSH_COS);
                                mapM94a2.put("third_sync_reason", string);
                                u.this.a(str, v.UPLOAD_COS_TOKEN, false, mapM94a2);
                            } else if (v.UPLOAD_FTOS_TOKEN.ordinal() == i2 && "syncing".equals(p.a(u.this.f135a).a(v.UPLOAD_FTOS_TOKEN))) {
                                HashMap<String, String> mapM94a3 = f.m94a(u.this.f135a, d.ASSEMBLE_PUSH_FTOS);
                                mapM94a3.put("third_sync_reason", string);
                                u.this.a(str, v.UPLOAD_FTOS_TOKEN, false, mapM94a3);
                            }
                            p.a(u.this.f135a).b(str);
                        } else {
                            p.a(u.this.f135a).c(str);
                        }
                    }
                }
            }
        };
        if (com.xiaomi.push.j.m627a(context)) {
            com.xiaomi.push.service.g.a(new g.b() { // from class: com.xiaomi.mipush.sdk.u.2
            });
        }
        Intent intentB = b();
        if (intentB != null) {
            b(intentB);
        }
    }

    private synchronized void c(int i2) {
        this.f135a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i2).commit();
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f135a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m111a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f135a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f135a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private void g() {
        this.f134a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f135a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f135a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f135a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f135a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public final void m122b() {
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(intentM108a);
    }

    public void f() {
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        intentM108a.putExtra(an.F, this.f135a.getPackageName());
        intentM108a.putExtra(an.K, ba.b(this.f135a.getPackageName()));
        c(intentM108a);
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f135a.getPackageName())) {
            return c();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return e();
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m113c() {
        try {
            PackageInfo packageInfo = this.f135a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    public void m126e() {
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) aw.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f135a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        intentM108a.putExtra(an.F, packageName);
        c(intentM108a);
    }

    private Intent c() {
        if (m120a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m125d() {
        synchronized (f133a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = f133a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f144a, next.f12403a, next.f145a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f133a.clear();
        }
    }

    public void b(int i2) {
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        intentM108a.putExtra(an.F, this.f135a.getPackageName());
        intentM108a.putExtra(an.I, i2);
        intentM108a.putExtra(an.K, ba.b(this.f135a.getPackageName() + i2));
        c(intentM108a);
    }

    public static synchronized u a(Context context) {
        if (f12395a == null) {
            f12395a = new u(context);
        }
        return f12395a;
    }

    private synchronized int a() {
        return this.f135a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m124c() {
        if (this.f136a != null) {
            g();
            c(this.f136a);
            this.f136a = null;
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m114d() {
        if (m120a()) {
            try {
                return this.f135a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m123b() {
        if (!m120a() || !m115e()) {
            return true;
        }
        if (this.f139a == null) {
            this.f139a = Integer.valueOf(ap.a(this.f135a).a());
            if (this.f139a.intValue() == 0) {
                this.f135a.getContentResolver().registerContentObserver(ap.a(this.f135a).m700a(), false, new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.mipush.sdk.u.3
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        u uVar = u.this;
                        uVar.f139a = Integer.valueOf(ap.a(uVar.f135a).a());
                        if (u.this.f139a.intValue() != 0) {
                            u.this.f135a.getContentResolver().unregisterContentObserver(this);
                            if (au.m151a(u.this.f135a)) {
                                u.this.m124c();
                            }
                        }
                    }
                });
            }
        }
        return this.f139a.intValue() != 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m116a() {
        return this.f134a;
    }

    private void c(Intent intent) {
        int iA = ah.a(this.f135a).a(gk.ServiceBootMode.a(), gg.START.a());
        int iA2 = a();
        boolean z = iA == gg.BIND.a() && f12396b;
        int iA3 = (z ? gg.BIND : gg.START).a();
        if (iA3 != iA2) {
            m121a(iA3);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    private boolean m115e() {
        String packageName = this.f135a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f135a.getApplicationInfo().flags & 1) != 0;
    }

    public final void a(hf hfVar, boolean z) {
        dt.a(this.f135a.getApplicationContext()).a(this.f135a.getPackageName(), "E100003", hfVar.a(), AuthCode.StatusCode.WAITING_CONNECT, null);
        this.f136a = null;
        b.m75a(this.f135a).f108a = hfVar.a();
        Intent intentM108a = m108a();
        byte[] bArrA = hp.a(r.a(this.f135a, hfVar, gf.Registration));
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("register fail, because msgBytes is null.");
            return;
        }
        intentM108a.setAction("com.xiaomi.mipush.REGISTER_APP");
        intentM108a.putExtra("mipush_app_id", b.m75a(this.f135a).m76a());
        intentM108a.putExtra("mipush_payload", bArrA);
        intentM108a.putExtra("mipush_session", this.f140a);
        intentM108a.putExtra("mipush_env_chanage", z);
        intentM108a.putExtra("mipush_env_type", b.m75a(this.f135a).a());
        if (au.m151a(this.f135a) && m123b()) {
            g();
            c(intentM108a);
        } else {
            this.f136a = intentM108a;
        }
    }

    private synchronized void d(Intent intent) {
        if (this.f12397c) {
            Message messageA = a(intent);
            if (this.f141a.size() >= 50) {
                this.f141a.remove(0);
            }
            this.f141a.add(messageA);
            return;
        }
        if (this.f138a == null) {
            this.f135a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.mipush.sdk.u.4
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (u.this) {
                        u.this.f138a = new Messenger(iBinder);
                        u.this.f12397c = false;
                        Iterator it = u.this.f141a.iterator();
                        while (it.hasNext()) {
                            try {
                                u.this.f138a.send((Message) it.next());
                            } catch (RemoteException e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                        u.this.f141a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    u.this.f138a = null;
                    u.this.f12397c = false;
                }
            }, 1);
            this.f12397c = true;
            this.f141a.clear();
            this.f141a.add(a(intent));
        } else {
            try {
                this.f138a.send(a(intent));
            } catch (RemoteException unused) {
                this.f138a = null;
                this.f12397c = false;
            }
        }
    }

    private void b(Intent intent) {
        try {
            if (!com.xiaomi.push.j.m626a() && Build.VERSION.SDK_INT >= 26) {
                d(intent);
            } else {
                this.f135a.startService(intent);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m117a() {
        b(m108a());
    }

    public final void a(hl hlVar) {
        byte[] bArrA = hp.a(r.a(this.f135a, hlVar, gf.UnRegistration));
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        intentM108a.putExtra("mipush_app_id", b.m75a(this.f135a).m76a());
        intentM108a.putExtra("mipush_payload", bArrA);
        c(intentM108a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            p.a(this.f135a).a(v.DISABLE_PUSH, "syncing");
            p.a(this.f135a).a(v.ENABLE_PUSH, "");
            a(str, v.DISABLE_PUSH, true, (HashMap<String, String>) null);
        } else {
            p.a(this.f135a).a(v.ENABLE_PUSH, "syncing");
            p.a(this.f135a).a(v.DISABLE_PUSH, "");
            a(str, v.ENABLE_PUSH, true, (HashMap<String, String>) null);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m118a(Context context) {
        if (com.xiaomi.push.j.m626a()) {
            return;
        }
        q qVarA = h.a(context);
        if (q.HUAWEI.equals(qVarA)) {
            a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (q.OPPO.equals(qVarA)) {
            a((String) null, v.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS, "update");
        }
        if (q.VIVO.equals(qVarA)) {
            a((String) null, v.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    public final void a(String str, v vVar, d dVar, String str2) {
        p.a(this.f135a).a(vVar, "syncing");
        HashMap<String, String> mapM94a = f.m94a(this.f135a, dVar);
        mapM94a.put("third_sync_reason", str2);
        a(str, vVar, false, mapM94a);
    }

    void a(int i2, String str) {
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.thirdparty");
        intentM108a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i2);
        intentM108a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(intentM108a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, v vVar, boolean z, HashMap<String, String> map) {
        he heVar;
        if (b.m75a(this.f135a).m82b() && au.m151a(this.f135a)) {
            he heVar2 = new he();
            heVar2.a(true);
            Intent intentM108a = m108a();
            if (TextUtils.isEmpty(str)) {
                str = aj.a();
                heVar2.a(str);
                heVar = z ? new he(str, true) : null;
                synchronized (p.class) {
                    p.a(this.f135a).m104a(str);
                }
            } else {
                heVar2.a(str);
                heVar = z ? new he(str, true) : null;
            }
            switch (AnonymousClass5.f12402a[vVar.ordinal()]) {
                case 1:
                    heVar2.c(gp.DisablePushMessage.f597a);
                    heVar.c(gp.DisablePushMessage.f597a);
                    if (map != null) {
                        heVar2.a(map);
                        heVar.a(map);
                    }
                    intentM108a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    heVar2.c(gp.EnablePushMessage.f597a);
                    heVar.c(gp.EnablePushMessage.f597a);
                    if (map != null) {
                        heVar2.a(map);
                        heVar.a(map);
                    }
                    intentM108a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    heVar2.c(gp.ThirdPartyRegUpdate.f597a);
                    if (map != null) {
                        heVar2.a(map);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + vVar + ", " + str);
            heVar2.b(b.m75a(this.f135a).m76a());
            heVar2.d(this.f135a.getPackageName());
            a((u) heVar2, gf.Notification, false, (gs) null);
            if (z) {
                heVar.b(b.m75a(this.f135a).m76a());
                heVar.d(this.f135a.getPackageName());
                Context context = this.f135a;
                byte[] bArrA = hp.a(r.a(context, heVar, gf.Notification, false, context.getPackageName(), b.m75a(this.f135a).m76a()));
                if (bArrA != null) {
                    cs.a(this.f135a.getPackageName(), this.f135a, heVar, gf.Notification, bArrA.length);
                    intentM108a.putExtra("mipush_payload", bArrA);
                    intentM108a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    intentM108a.putExtra("mipush_app_id", b.m75a(this.f135a).m76a());
                    intentM108a.putExtra("mipush_app_token", b.m75a(this.f135a).b());
                    c(intentM108a);
                }
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 19;
            int iOrdinal = vVar.ordinal();
            messageObtain.obj = str;
            messageObtain.arg1 = iOrdinal;
            if (map != null && map.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", map.get("third_sync_reason"));
                messageObtain.setData(bundle);
            }
            this.f137a.sendMessageDelayed(messageObtain, com.heytap.mcssdk.constant.a.r);
        }
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, gs gsVar) {
        a((u) t, gfVar, !gfVar.equals(gf.Registration), gsVar);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, gs gsVar, boolean z2) {
        a(t, gfVar, z, true, gsVar, z2);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, gs gsVar) {
        a(t, gfVar, z, true, gsVar, true);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, boolean z2, gs gsVar, boolean z3) {
        a(t, gfVar, z, z2, gsVar, z3, this.f135a.getPackageName(), b.m75a(this.f135a).m76a());
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, boolean z2, gs gsVar, boolean z3, String str, String str2) {
        a(t, gfVar, z, z2, gsVar, z3, str, str2, true);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, boolean z2, gs gsVar, boolean z3, String str, String str2, boolean z4) {
        a(t, gfVar, z, z2, gsVar, z3, str, str2, z4, true);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, boolean z2, gs gsVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        hb hbVarB;
        if (z5 && !b.m75a(this.f135a).m84c()) {
            if (z2) {
                a((u) t, gfVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("drop the message before initialization.");
                return;
            }
        }
        if (z4) {
            hbVarB = r.a(this.f135a, t, gfVar, z, str, str2);
        } else {
            hbVarB = r.b(this.f135a, t, gfVar, z, str, str2);
        }
        if (gsVar != null) {
            hbVarB.a(gsVar);
        }
        byte[] bArrA = hp.a(hbVarB);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("send message fail, because msgBytes is null.");
            return;
        }
        cs.a(this.f135a.getPackageName(), this.f135a, t, gfVar, bArrA.length);
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        intentM108a.putExtra("mipush_payload", bArrA);
        intentM108a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(intentM108a);
    }

    public final void a(gj gjVar) {
        Intent intentM108a = m108a();
        byte[] bArrA = hp.a(gjVar);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        intentM108a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        intentM108a.putExtra("mipush_payload", bArrA);
        b(intentM108a);
    }

    /* renamed from: a, reason: collision with other method in class */
    private Intent m108a() {
        if (m120a() && !"com.xiaomi.xmsf".equals(this.f135a.getPackageName())) {
            return d();
        }
        return e();
    }

    /* renamed from: a, reason: collision with other method in class */
    private String m111a() {
        String str = this.f143b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f135a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f143b = "com.xiaomi.push.service.XMPushService";
                return this.f143b;
            }
        } catch (Exception unused) {
        }
        this.f143b = "com.xiaomi.xmsf.push.service.XMPushService";
        return this.f143b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m120a() {
        return this.f142a && 1 == b.m75a(this.f135a).a();
    }

    public <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z) {
        a aVar = new a();
        aVar.f144a = t;
        aVar.f12403a = gfVar;
        aVar.f145a = z;
        synchronized (f133a) {
            f133a.add(aVar);
            if (f133a.size() > 10) {
                f133a.remove(0);
            }
        }
    }

    public void a(int i2) {
        a(i2, 0);
    }

    void a(int i2, int i3) {
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        intentM108a.putExtra(an.F, this.f135a.getPackageName());
        intentM108a.putExtra(an.G, i2);
        intentM108a.putExtra(an.H, i3);
        c(intentM108a);
    }

    public void a(String str, String str2) {
        Intent intentM108a = m108a();
        intentM108a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        intentM108a.putExtra(an.F, this.f135a.getPackageName());
        intentM108a.putExtra(an.L, str);
        intentM108a.putExtra(an.M, str2);
        c(intentM108a);
    }

    /* renamed from: a, reason: collision with other method in class */
    void m119a(Intent intent) {
        intent.fillIn(m108a(), 24);
        c(intent);
    }

    private Message a(Intent intent) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 17;
        messageObtain.obj = intent;
        return messageObtain;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m121a(int i2) {
        if (!b.m75a(this.f135a).m82b()) {
            return false;
        }
        c(i2);
        he heVar = new he();
        heVar.a(aj.a());
        heVar.b(b.m75a(this.f135a).m76a());
        heVar.d(this.f135a.getPackageName());
        heVar.c(gp.ClientABTest.f597a);
        heVar.f736a = new HashMap();
        heVar.f736a.put("boot_mode", i2 + "");
        a(this.f135a).a((u) heVar, gf.Notification, false, (gs) null);
        return true;
    }
}
