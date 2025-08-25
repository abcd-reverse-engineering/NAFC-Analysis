package com.xiaomi.push;

import com.xiaomi.push.em;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;

/* loaded from: classes2.dex */
class el implements am.b.a {

    /* renamed from: a, reason: collision with root package name */
    private int f12769a;

    /* renamed from: a, reason: collision with other field name */
    private fa f444a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f445a;

    /* renamed from: a, reason: collision with other field name */
    private am.b f446a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f448a = false;

    /* renamed from: a, reason: collision with other field name */
    private am.c f447a = am.c.binding;

    /* renamed from: com.xiaomi.push.el$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12771a = new int[am.c.values().length];

        static {
            try {
                f12771a[am.c.unbind.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12771a[am.c.binding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12771a[am.c.binded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    el(XMPushService xMPushService, am.b bVar) {
        this.f445a = xMPushService;
        this.f446a = bVar;
    }

    private void b() {
        this.f446a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f448a && this.f12769a != 11) {
            ej ejVarM384a = eo.m382a().m384a();
            int i2 = AnonymousClass2.f12771a[this.f447a.ordinal()];
            if (i2 == 1) {
                int i3 = this.f12769a;
                if (i3 == 17) {
                    ejVarM384a.f430a = ei.BIND_TCP_READ_TIMEOUT.a();
                } else if (i3 == 21) {
                    ejVarM384a.f430a = ei.BIND_TIMEOUT.a();
                } else {
                    try {
                        em.a aVarC = em.c(eo.a().a());
                        ejVarM384a.f430a = aVarC.f12772a.a();
                        ejVarM384a.c(aVarC.f449a);
                    } catch (NullPointerException unused) {
                        ejVarM384a = null;
                    }
                }
            } else if (i2 != 2 && i2 == 3) {
                ejVarM384a.f430a = ei.BIND_SUCCESS.a();
            }
            if (ejVarM384a != null) {
                ejVarM384a.b(this.f444a.mo414a());
                ejVarM384a.d(this.f446a.f1001b);
                ejVarM384a.f433b = 1;
                try {
                    ejVarM384a.a((byte) Integer.parseInt(this.f446a.f13350g));
                } catch (NumberFormatException unused2) {
                }
                eo.m382a().a(ejVarM384a);
            }
        }
    }

    void a() {
        this.f446a.a(this);
        this.f444a = this.f445a.m660a();
    }

    @Override // com.xiaomi.push.service.am.b.a
    public void a(am.c cVar, am.c cVar2, int i2) {
        if (!this.f448a && cVar == am.c.binding) {
            this.f447a = cVar2;
            this.f12769a = i2;
            this.f448a = true;
        }
        this.f445a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.el.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Handling bind stats";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a, reason: collision with other method in class */
            public void mo379a() {
                el.this.c();
            }
        });
    }
}
