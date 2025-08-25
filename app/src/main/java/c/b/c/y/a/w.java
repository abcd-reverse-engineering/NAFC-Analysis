package c.b.c.y.a;

import com.just.agentweb.DefaultWebClient;

/* compiled from: SMSParsedResult.java */
/* loaded from: classes.dex */
public final class w extends q {

    /* renamed from: b, reason: collision with root package name */
    private final String[] f2993b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f2994c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2995d;

    /* renamed from: e, reason: collision with root package name */
    private final String f2996e;

    public w(String str, String str2, String str3, String str4) {
        super(r.SMS);
        this.f2993b = new String[]{str};
        this.f2994c = new String[]{str2};
        this.f2995d = str3;
        this.f2996e = str4;
    }

    @Override // c.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.a(this.f2993b, sb);
        q.a(this.f2995d, sb);
        q.a(this.f2996e, sb);
        return sb.toString();
    }

    public String c() {
        return this.f2996e;
    }

    public String[] d() {
        return this.f2993b;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultWebClient.SCHEME_SMS);
        boolean z = true;
        for (int i2 = 0; i2 < this.f2993b.length; i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(this.f2993b[i2]);
            String[] strArr = this.f2994c;
            if (strArr != null && strArr[i2] != null) {
                sb.append(";via=");
                sb.append(this.f2994c[i2]);
            }
        }
        boolean z2 = this.f2996e != null;
        boolean z3 = this.f2995d != null;
        if (z2 || z3) {
            sb.append('?');
            if (z2) {
                sb.append("body=");
                sb.append(this.f2996e);
            }
            if (z3) {
                if (z2) {
                    sb.append(h.z2.h0.f16706c);
                }
                sb.append("subject=");
                sb.append(this.f2995d);
            }
        }
        return sb.toString();
    }

    public String f() {
        return this.f2995d;
    }

    public String[] g() {
        return this.f2994c;
    }

    public w(String[] strArr, String[] strArr2, String str, String str2) {
        super(r.SMS);
        this.f2993b = strArr;
        this.f2994c = strArr2;
        this.f2995d = str;
        this.f2996e = str2;
    }
}
