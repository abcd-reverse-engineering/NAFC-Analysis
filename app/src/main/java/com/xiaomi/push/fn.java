package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class fn extends fo {

    /* renamed from: a, reason: collision with root package name */
    private boolean f12843a;

    /* renamed from: b, reason: collision with root package name */
    private String f12844b;

    /* renamed from: b, reason: collision with other field name */
    private boolean f526b;

    /* renamed from: c, reason: collision with root package name */
    private String f12845c;

    /* renamed from: d, reason: collision with root package name */
    private String f12846d;

    /* renamed from: e, reason: collision with root package name */
    private String f12847e;

    /* renamed from: f, reason: collision with root package name */
    private String f12848f;

    /* renamed from: g, reason: collision with root package name */
    private String f12849g;

    /* renamed from: h, reason: collision with root package name */
    private String f12850h;

    /* renamed from: i, reason: collision with root package name */
    private String f12851i;

    /* renamed from: j, reason: collision with root package name */
    private String f12852j;

    /* renamed from: k, reason: collision with root package name */
    private String f12853k;

    /* renamed from: l, reason: collision with root package name */
    private String f12854l;

    public fn() {
        this.f12844b = null;
        this.f12845c = null;
        this.f12843a = false;
        this.f12851i = "";
        this.f12852j = "";
        this.f12853k = "";
        this.f12854l = "";
        this.f526b = false;
    }

    public void a(boolean z) {
        this.f12843a = z;
    }

    public String b() {
        return this.f12844b;
    }

    public String c() {
        return this.f12850h;
    }

    public String d() {
        return this.f12851i;
    }

    public String e() {
        return this.f12852j;
    }

    @Override // com.xiaomi.push.fo
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fn.class != obj.getClass()) {
            return false;
        }
        fn fnVar = (fn) obj;
        if (!super.equals(fnVar)) {
            return false;
        }
        String str = this.f12848f;
        if (str == null ? fnVar.f12848f != null : !str.equals(fnVar.f12848f)) {
            return false;
        }
        String str2 = this.f12846d;
        if (str2 == null ? fnVar.f12846d != null : !str2.equals(fnVar.f12846d)) {
            return false;
        }
        String str3 = this.f12847e;
        if (str3 == null ? fnVar.f12847e != null : !str3.equals(fnVar.f12847e)) {
            return false;
        }
        String str4 = this.f12845c;
        if (str4 == null ? fnVar.f12845c == null : str4.equals(fnVar.f12845c)) {
            return this.f12844b == fnVar.f12844b;
        }
        return false;
    }

    public String f() {
        return this.f12853k;
    }

    public String g() {
        return this.f12854l;
    }

    public void h(String str) {
        this.f12848f = str;
    }

    @Override // com.xiaomi.push.fo
    public int hashCode() {
        String str = this.f12844b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f12848f;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12845c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f12846d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f12847e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.f12845c = str;
    }

    public void j(String str) {
        this.f12846d = str;
    }

    public void a(String str) {
        this.f12850h = str;
    }

    public void b(String str) {
        this.f12851i = str;
    }

    public void c(String str) {
        this.f12852j = str;
    }

    public void d(String str) {
        this.f12853k = str;
    }

    public void e(String str) {
        this.f12854l = str;
    }

    public void f(String str) {
        this.f12844b = str;
    }

    public void g(String str) {
        this.f12847e = str;
    }

    public String h() {
        return this.f12846d;
    }

    public void a(String str, String str2) {
        this.f12848f = str;
        this.f12849g = str2;
    }

    public void b(boolean z) {
        this.f526b = z;
    }

    @Override // com.xiaomi.push.fo
    public Bundle a() {
        Bundle bundleA = super.a();
        if (!TextUtils.isEmpty(this.f12844b)) {
            bundleA.putString("ext_msg_type", this.f12844b);
        }
        String str = this.f12846d;
        if (str != null) {
            bundleA.putString("ext_msg_lang", str);
        }
        String str2 = this.f12847e;
        if (str2 != null) {
            bundleA.putString("ext_msg_sub", str2);
        }
        String str3 = this.f12848f;
        if (str3 != null) {
            bundleA.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f12849g)) {
            bundleA.putString("ext_body_encode", this.f12849g);
        }
        String str4 = this.f12845c;
        if (str4 != null) {
            bundleA.putString("ext_msg_thread", str4);
        }
        String str5 = this.f12850h;
        if (str5 != null) {
            bundleA.putString("ext_msg_appid", str5);
        }
        if (this.f12843a) {
            bundleA.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f12851i)) {
            bundleA.putString("ext_msg_seq", this.f12851i);
        }
        if (!TextUtils.isEmpty(this.f12852j)) {
            bundleA.putString("ext_msg_mseq", this.f12852j);
        }
        if (!TextUtils.isEmpty(this.f12853k)) {
            bundleA.putString("ext_msg_fseq", this.f12853k);
        }
        if (this.f526b) {
            bundleA.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f12854l)) {
            bundleA.putString("ext_msg_status", this.f12854l);
        }
        return bundleA;
    }

    public fn(Bundle bundle) {
        super(bundle);
        this.f12844b = null;
        this.f12845c = null;
        this.f12843a = false;
        this.f12851i = "";
        this.f12852j = "";
        this.f12853k = "";
        this.f12854l = "";
        this.f526b = false;
        this.f12844b = bundle.getString("ext_msg_type");
        this.f12846d = bundle.getString("ext_msg_lang");
        this.f12845c = bundle.getString("ext_msg_thread");
        this.f12847e = bundle.getString("ext_msg_sub");
        this.f12848f = bundle.getString("ext_msg_body");
        this.f12849g = bundle.getString("ext_body_encode");
        this.f12850h = bundle.getString("ext_msg_appid");
        this.f12843a = bundle.getBoolean("ext_msg_trans", false);
        this.f526b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f12851i = bundle.getString("ext_msg_seq");
        this.f12852j = bundle.getString("ext_msg_mseq");
        this.f12853k = bundle.getString("ext_msg_fseq");
        this.f12854l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.fo
    /* renamed from: a */
    public String mo431a() {
        fs fsVarM432a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.f12846d != null) {
            sb.append(" xml:lang=\"");
            sb.append(h());
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
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"");
            sb.append(g());
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
        if (this.f12843a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f12850h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f12844b)) {
            sb.append(" type=\"");
            sb.append(this.f12844b);
            sb.append("\"");
        }
        if (this.f526b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f12847e != null) {
            sb.append("<subject>");
            sb.append(fx.a(this.f12847e));
            sb.append("</subject>");
        }
        if (this.f12848f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f12849g)) {
                sb.append(" encode=\"");
                sb.append(this.f12849g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(fx.a(this.f12848f));
            sb.append("</body>");
        }
        if (this.f12845c != null) {
            sb.append("<thread>");
            sb.append(this.f12845c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f12844b) && (fsVarM432a = m432a()) != null) {
            sb.append(fsVarM432a.m435a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }
}
