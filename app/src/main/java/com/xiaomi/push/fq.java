package com.xiaomi.push;

import android.os.Bundle;

/* loaded from: classes2.dex */
public class fq extends fo {

    /* renamed from: a, reason: collision with root package name */
    private int f12864a;

    /* renamed from: a, reason: collision with other field name */
    private a f533a;

    /* renamed from: a, reason: collision with other field name */
    private b f534a;

    /* renamed from: b, reason: collision with root package name */
    private String f12865b;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public fq(b bVar) {
        this.f534a = b.available;
        this.f12865b = null;
        this.f12864a = Integer.MIN_VALUE;
        this.f533a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.fo
    public Bundle a() {
        Bundle bundleA = super.a();
        b bVar = this.f534a;
        if (bVar != null) {
            bundleA.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f12865b;
        if (str != null) {
            bundleA.putString("ext_pres_status", str);
        }
        int i2 = this.f12864a;
        if (i2 != Integer.MIN_VALUE) {
            bundleA.putInt("ext_pres_prio", i2);
        }
        a aVar = this.f533a;
        if (aVar != null && aVar != a.available) {
            bundleA.putString("ext_pres_mode", aVar.toString());
        }
        return bundleA;
    }

    public fq(Bundle bundle) {
        super(bundle);
        this.f534a = b.available;
        this.f12865b = null;
        this.f12864a = Integer.MIN_VALUE;
        this.f533a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f534a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f12865b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f12864a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f533a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f534a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public void a(String str) {
        this.f12865b = str;
    }

    public void a(int i2) {
        if (i2 >= -128 && i2 <= 128) {
            this.f12864a = i2;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i2 + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.f533a = aVar;
    }

    @Override // com.xiaomi.push.fo
    /* renamed from: a */
    public String mo431a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(fx.a(l()));
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(fx.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(fx.a(k()));
            sb.append("\"");
        }
        if (this.f534a != null) {
            sb.append(" type=\"");
            sb.append(this.f534a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f12865b != null) {
            sb.append("<status>");
            sb.append(fx.a(this.f12865b));
            sb.append("</status>");
        }
        if (this.f12864a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f12864a);
            sb.append("</priority>");
        }
        a aVar = this.f533a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f533a);
            sb.append("</show>");
        }
        sb.append(o());
        fs fsVarM432a = m432a();
        if (fsVarM432a != null) {
            sb.append(fsVarM432a.m435a());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
