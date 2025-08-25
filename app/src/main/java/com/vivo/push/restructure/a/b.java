package com.vivo.push.restructure.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.u;
import com.vivo.push.util.v;
import org.json.JSONException;

/* compiled from: ReceivedMessageImpl.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private Intent f12163a;

    /* renamed from: c, reason: collision with root package name */
    private com.vivo.push.restructure.request.a.a f12165c;

    /* renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f12167e;

    /* renamed from: f, reason: collision with root package name */
    private UnvarnishedMessage f12168f;

    /* renamed from: b, reason: collision with root package name */
    private String f12164b = "";

    /* renamed from: d, reason: collision with root package name */
    private String f12166d = "";

    public b(Intent intent) {
        this.f12163a = intent;
    }

    private boolean m() {
        return j() == 4;
    }

    private boolean n() {
        return j() == 3;
    }

    private InsideNotificationItem o() {
        InsideNotificationItem insideNotificationItem = this.f12167e;
        if (insideNotificationItem != null) {
            return insideNotificationItem;
        }
        InsideNotificationItem insideNotificationItemA = null;
        Intent intent = this.f12163a;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("notification_v1");
                if (stringExtra != null && (insideNotificationItemA = v.a(stringExtra)) != null) {
                    insideNotificationItemA.setMsgId(Long.parseLong(a()));
                }
            } catch (Exception e2) {
                u.a("ReceivedMessageImpl", "getNotificationMessage " + e2.getMessage());
            }
        }
        this.f12167e = insideNotificationItemA;
        return insideNotificationItemA;
    }

    private UnvarnishedMessage p() {
        UnvarnishedMessage unvarnishedMessage = this.f12168f;
        if (unvarnishedMessage != null) {
            return unvarnishedMessage;
        }
        UnvarnishedMessage unvarnishedMessage2 = null;
        Intent intent = this.f12163a;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("msg_v1");
                if (!TextUtils.isEmpty(stringExtra)) {
                    UnvarnishedMessage unvarnishedMessage3 = new UnvarnishedMessage(stringExtra);
                    try {
                        unvarnishedMessage3.setMsgId(Long.parseLong(a()));
                        unvarnishedMessage2 = unvarnishedMessage3;
                    } catch (Exception e2) {
                        e = e2;
                        unvarnishedMessage2 = unvarnishedMessage3;
                        u.a("ReceivedMessageImpl", "getTransmissionMessage " + e.getMessage());
                        this.f12168f = unvarnishedMessage2;
                        return unvarnishedMessage2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        this.f12168f = unvarnishedMessage2;
        return unvarnishedMessage2;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String a() {
        Bundle extras;
        Intent intent = this.f12163a;
        long j2 = (intent == null || (extras = intent.getExtras()) == null) ? 0L : extras.getLong("notify_id", 0L);
        return j2 != 0 ? String.valueOf(j2) : "";
    }

    @Override // com.vivo.push.restructure.a.a
    public final Intent b() {
        return this.f12163a;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String c() {
        if (TextUtils.isEmpty(this.f12164b)) {
            this.f12164b = this.f12163a.getStringExtra("req_id");
        }
        return this.f12164b;
    }

    @Override // com.vivo.push.restructure.a.a
    public final long d() {
        Intent intent = this.f12163a;
        if (intent != null) {
            return intent.getLongExtra("ipc_start_time", 0L);
        }
        return 0L;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean e() {
        Intent intent = this.f12163a;
        if (intent != null) {
            return intent.getBooleanExtra("core_support_monitor", false);
        }
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean f() {
        Bundle extras;
        Intent intent = this.f12163a;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.getBoolean("client_collect_node", false);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean g() {
        com.vivo.push.restructure.request.a.a aVarH = h();
        return aVarH != null && aVarH.a() == 2018;
    }

    @Override // com.vivo.push.restructure.a.a
    public final com.vivo.push.restructure.request.a.a h() {
        String stringExtra;
        com.vivo.push.restructure.request.a.a.a aVar;
        if (this.f12165c == null && (stringExtra = this.f12163a.getStringExtra("cf_content")) != null) {
            try {
                aVar = new com.vivo.push.restructure.request.a.a.a(stringExtra);
            } catch (JSONException unused) {
                aVar = null;
            }
            if (aVar != null) {
                this.f12165c = com.vivo.push.restructure.request.a.a.f12181a.a(aVar);
            }
        }
        return this.f12165c;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String i() {
        if (TextUtils.isEmpty(this.f12166d)) {
            this.f12166d = this.f12163a.getStringExtra("content");
        }
        return this.f12166d;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int j() {
        Intent intent = this.f12163a;
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra("command", -1);
        return intExtra < 0 ? this.f12163a.getIntExtra("method", -1) : intExtra;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int k() {
        if (this.f12163a == null) {
            return 0;
        }
        if (m() && o() != null) {
            return o().getTargetType();
        }
        if (!n() || p() == null) {
            return 0;
        }
        return p().getTargetType();
    }

    @Override // com.vivo.push.restructure.a.a
    public final String l() {
        return this.f12163a == null ? "" : (!m() || o() == null) ? (!n() || p() == null) ? "" : p().getTragetContent() : o().getTragetContent();
    }
}
