package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gk;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class e implements AbstractPushManager {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f12368a;

    /* renamed from: a, reason: collision with other field name */
    private Context f116a;

    /* renamed from: a, reason: collision with other field name */
    private PushConfiguration f117a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f119a = false;

    /* renamed from: a, reason: collision with other field name */
    private Map<d, AbstractPushManager> f118a = new HashMap();

    /* renamed from: com.xiaomi.mipush.sdk.e$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12370a = new int[d.values().length];

        static {
            try {
                f12370a[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12370a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12370a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12370a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private e(Context context) {
        this.f116a = context.getApplicationContext();
    }

    public boolean b(d dVar) {
        int i2 = AnonymousClass2.f12370a[dVar.ordinal()];
        boolean openCOSPush = false;
        if (i2 == 1) {
            PushConfiguration pushConfiguration = this.f117a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        }
        if (i2 == 2) {
            PushConfiguration pushConfiguration2 = this.f117a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        }
        if (i2 == 3) {
            PushConfiguration pushConfiguration3 = this.f117a;
            if (pushConfiguration3 != null) {
                openCOSPush = pushConfiguration3.getOpenCOSPush();
            }
        } else if (i2 != 4) {
            return false;
        }
        PushConfiguration pushConfiguration4 = this.f117a;
        return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : openCOSPush;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : assemble push register");
        if (this.f118a.size() <= 0) {
            a();
        }
        if (this.f118a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f118a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            f.m95a(this.f116a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f118a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f118a.clear();
    }

    public static e a(Context context) {
        if (f12368a == null) {
            synchronized (e.class) {
                if (f12368a == null) {
                    f12368a = new e(context);
                }
            }
        }
        return f12368a;
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f117a = pushConfiguration;
        this.f119a = ah.a(this.f116a).a(gk.AggregatePushSwitch.a(), true);
        if (this.f117a.getOpenHmsPush() || this.f117a.getOpenFCMPush() || this.f117a.getOpenCOSPush() || this.f117a.getOpenFTOSPush()) {
            ah.a(this.f116a).a(new ah.a(101, "assemblePush") { // from class: com.xiaomi.mipush.sdk.e.1
                @Override // com.xiaomi.push.service.ah.a
                protected void onCallback() {
                    boolean zA = ah.a(e.this.f116a).a(gk.AggregatePushSwitch.a(), true);
                    if (e.this.f119a != zA) {
                        e.this.f119a = zA;
                        f.b(e.this.f116a);
                    }
                }
            });
        }
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f118a.containsKey(dVar)) {
                this.f118a.remove(dVar);
            }
            this.f118a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m92a(d dVar) {
        this.f118a.remove(dVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m93a(d dVar) {
        return this.f118a.containsKey(dVar);
    }

    public AbstractPushManager a(d dVar) {
        return this.f118a.get(dVar);
    }

    private void a() {
        AbstractPushManager abstractPushManagerA;
        AbstractPushManager abstractPushManagerA2;
        AbstractPushManager abstractPushManagerA3;
        AbstractPushManager abstractPushManagerA4;
        PushConfiguration pushConfiguration = this.f117a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f117a.getOpenHmsPush() + " HW online switch : " + f.m99a(this.f116a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + h.m103a(this.f116a));
                com.xiaomi.channel.commonutils.logger.b.m50a(sb.toString());
            }
            if (this.f117a.getOpenHmsPush() && f.m99a(this.f116a, d.ASSEMBLE_PUSH_HUAWEI) && h.m103a(this.f116a)) {
                if (!m93a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    d dVar = d.ASSEMBLE_PUSH_HUAWEI;
                    a(dVar, s.a(this.f116a, dVar));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m93a(d.ASSEMBLE_PUSH_HUAWEI) && (abstractPushManagerA = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m92a(d.ASSEMBLE_PUSH_HUAWEI);
                abstractPushManagerA.unregister();
            }
            if (this.f117a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f117a.getOpenFCMPush() + " FCM online switch : " + f.m99a(this.f116a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + h.b(this.f116a));
                com.xiaomi.channel.commonutils.logger.b.m50a(sb2.toString());
            }
            if (this.f117a.getOpenFCMPush() && f.m99a(this.f116a, d.ASSEMBLE_PUSH_FCM) && h.b(this.f116a)) {
                if (!m93a(d.ASSEMBLE_PUSH_FCM)) {
                    d dVar2 = d.ASSEMBLE_PUSH_FCM;
                    a(dVar2, s.a(this.f116a, dVar2));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m93a(d.ASSEMBLE_PUSH_FCM) && (abstractPushManagerA2 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m92a(d.ASSEMBLE_PUSH_FCM);
                abstractPushManagerA2.unregister();
            }
            if (this.f117a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f117a.getOpenCOSPush() + " COS online switch : " + f.m99a(this.f116a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + h.c(this.f116a));
                com.xiaomi.channel.commonutils.logger.b.m50a(sb3.toString());
            }
            if (this.f117a.getOpenCOSPush() && f.m99a(this.f116a, d.ASSEMBLE_PUSH_COS) && h.c(this.f116a)) {
                d dVar3 = d.ASSEMBLE_PUSH_COS;
                a(dVar3, s.a(this.f116a, dVar3));
            } else if (m93a(d.ASSEMBLE_PUSH_COS) && (abstractPushManagerA3 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m92a(d.ASSEMBLE_PUSH_COS);
                abstractPushManagerA3.unregister();
            }
            if (this.f117a.getOpenFTOSPush() && f.m99a(this.f116a, d.ASSEMBLE_PUSH_FTOS) && h.d(this.f116a)) {
                d dVar4 = d.ASSEMBLE_PUSH_FTOS;
                a(dVar4, s.a(this.f116a, dVar4));
            } else {
                if (!m93a(d.ASSEMBLE_PUSH_FTOS) || (abstractPushManagerA4 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
                    return;
                }
                m92a(d.ASSEMBLE_PUSH_FTOS);
                abstractPushManagerA4.unregister();
            }
        }
    }
}
