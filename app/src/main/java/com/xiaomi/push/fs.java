package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class fs {

    /* renamed from: a, reason: collision with root package name */
    private int f12880a;

    /* renamed from: a, reason: collision with other field name */
    private String f537a;

    /* renamed from: a, reason: collision with other field name */
    private List<fl> f538a;

    /* renamed from: b, reason: collision with root package name */
    private String f12881b;

    /* renamed from: c, reason: collision with root package name */
    private String f12882c;

    /* renamed from: d, reason: collision with root package name */
    private String f12883d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f12884a = new a("internal-server-error");

        /* renamed from: b, reason: collision with root package name */
        public static final a f12885b = new a("forbidden");

        /* renamed from: c, reason: collision with root package name */
        public static final a f12886c = new a("bad-request");

        /* renamed from: d, reason: collision with root package name */
        public static final a f12887d = new a("conflict");

        /* renamed from: e, reason: collision with root package name */
        public static final a f12888e = new a("feature-not-implemented");

        /* renamed from: f, reason: collision with root package name */
        public static final a f12889f = new a("gone");

        /* renamed from: g, reason: collision with root package name */
        public static final a f12890g = new a("item-not-found");

        /* renamed from: h, reason: collision with root package name */
        public static final a f12891h = new a("jid-malformed");

        /* renamed from: i, reason: collision with root package name */
        public static final a f12892i = new a("not-acceptable");

        /* renamed from: j, reason: collision with root package name */
        public static final a f12893j = new a("not-allowed");

        /* renamed from: k, reason: collision with root package name */
        public static final a f12894k = new a("not-authorized");

        /* renamed from: l, reason: collision with root package name */
        public static final a f12895l = new a("payment-required");

        /* renamed from: m, reason: collision with root package name */
        public static final a f12896m = new a("recipient-unavailable");
        public static final a n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");

        /* renamed from: a, reason: collision with other field name */
        private String f539a;

        public a(String str) {
            this.f539a = str;
        }

        public String toString() {
            return this.f539a;
        }
    }

    public fs(a aVar) {
        this.f538a = null;
        a(aVar);
        this.f12883d = null;
    }

    private void a(a aVar) {
        this.f12881b = aVar.f539a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f12881b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f12880a);
        sb.append(")");
        if (this.f12883d != null) {
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append(this.f12883d);
        }
        return sb.toString();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f537a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f12880a);
        String str2 = this.f12882c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f12881b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f12883d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<fl> list = this.f538a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            Iterator<fl> it = this.f538a.iterator();
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i2] = bundleA;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public fs(int i2, String str, String str2, String str3, String str4, List<fl> list) {
        this.f538a = null;
        this.f12880a = i2;
        this.f537a = str;
        this.f12882c = str2;
        this.f12881b = str3;
        this.f12883d = str4;
        this.f538a = list;
    }

    public fs(Bundle bundle) {
        this.f538a = null;
        this.f12880a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f537a = bundle.getString("ext_err_type");
        }
        this.f12881b = bundle.getString("ext_err_cond");
        this.f12882c = bundle.getString("ext_err_reason");
        this.f12883d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f538a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fl flVarA = fl.a((Bundle) parcelable);
                if (flVarA != null) {
                    this.f538a.add(flVarA);
                }
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m435a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.f12880a);
        sb.append("\"");
        if (this.f537a != null) {
            sb.append(" type=\"");
            sb.append(this.f537a);
            sb.append("\"");
        }
        if (this.f12882c != null) {
            sb.append(" reason=\"");
            sb.append(this.f12882c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f12881b != null) {
            sb.append("<");
            sb.append(this.f12881b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f12883d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f12883d);
            sb.append("</text>");
        }
        Iterator<fl> it = m436a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized List<fl> m436a() {
        if (this.f538a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.f538a);
    }
}
