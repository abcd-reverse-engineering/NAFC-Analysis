package com.vivo.push.b;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ReporterCommand.java */
/* loaded from: classes2.dex */
public final class x extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f11982a;

    /* renamed from: b, reason: collision with root package name */
    private long f11983b;

    public x() {
        super(2012);
    }

    public final void a(HashMap<String, String> map) {
        this.f11982a = map;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("ReporterCommand.EXTRA_PARAMS", this.f11982a);
        dVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f11983b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f11982a = (HashMap) dVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f11983b = dVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f11983b);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand（" + this.f11983b + ")";
    }

    public x(long j2) {
        this();
        this.f11983b = j2;
    }

    public final void d() {
        if (this.f11982a == null) {
            com.vivo.push.util.u.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.f11983b);
        sb.append(",msgId:");
        String str = this.f11982a.get(com.heytap.mcssdk.constant.b.f5825c);
        if (TextUtils.isEmpty(str)) {
            str = this.f11982a.get("message_id");
        }
        sb.append(str);
        com.vivo.push.util.u.d("ReporterCommand", sb.toString());
    }
}
