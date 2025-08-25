package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class fm extends fo {

    /* renamed from: a, reason: collision with root package name */
    private a f12837a;

    /* renamed from: a, reason: collision with other field name */
    private final Map<String, String> f524a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f12838a = new a("get");

        /* renamed from: b, reason: collision with root package name */
        public static final a f12839b = new a("set");

        /* renamed from: c, reason: collision with root package name */
        public static final a f12840c = new a("result");

        /* renamed from: d, reason: collision with root package name */
        public static final a f12841d = new a("error");

        /* renamed from: e, reason: collision with root package name */
        public static final a f12842e = new a("command");

        /* renamed from: a, reason: collision with other field name */
        private String f525a;

        private a(String str) {
            this.f525a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f12838a.toString().equals(lowerCase)) {
                return f12838a;
            }
            if (f12839b.toString().equals(lowerCase)) {
                return f12839b;
            }
            if (f12841d.toString().equals(lowerCase)) {
                return f12841d;
            }
            if (f12840c.toString().equals(lowerCase)) {
                return f12840c;
            }
            if (f12842e.toString().equals(lowerCase)) {
                return f12842e;
            }
            return null;
        }

        public String toString() {
            return this.f525a;
        }
    }

    public fm() {
        this.f12837a = a.f12838a;
        this.f524a = new HashMap();
    }

    public synchronized void a(Map<String, String> map) {
        this.f524a.putAll(map);
    }

    public String b() {
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m430a() {
        return this.f12837a;
    }

    public fm(Bundle bundle) {
        super(bundle);
        this.f12837a = a.f12838a;
        this.f524a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f12837a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f12837a = a.f12838a;
        } else {
            this.f12837a = aVar;
        }
    }

    @Override // com.xiaomi.push.fo
    public Bundle a() {
        Bundle bundleA = super.a();
        a aVar = this.f12837a;
        if (aVar != null) {
            bundleA.putString("ext_iq_type", aVar.toString());
        }
        return bundleA;
    }

    @Override // com.xiaomi.push.fo
    /* renamed from: a, reason: collision with other method in class */
    public String mo431a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(fx.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(fx.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(fx.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f524a.entrySet()) {
            sb.append(fx.a(entry.getKey()));
            sb.append("=\"");
            sb.append(fx.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.f12837a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(m430a());
            sb.append("\">");
        }
        String strB = b();
        if (strB != null) {
            sb.append(strB);
        }
        sb.append(o());
        fs fsVarM432a = m432a();
        if (fsVarM432a != null) {
            sb.append(fsVarM432a.m435a());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
