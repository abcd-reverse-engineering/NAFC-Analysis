package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes.dex */
public class i1 {

    /* renamed from: a, reason: collision with root package name */
    private String f7007a;

    /* renamed from: b, reason: collision with root package name */
    private String f7008b;

    /* renamed from: c, reason: collision with root package name */
    private String f7009c;

    /* renamed from: d, reason: collision with root package name */
    private String f7010d;

    /* renamed from: e, reason: collision with root package name */
    private long f7011e;

    public i1(String str, String str2, String str3, String str4, long j2) {
        this.f7007a = str;
        this.f7008b = str2;
        this.f7009c = str3;
        this.f7010d = str4;
        this.f7011e = j2;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.f7009c);
        b1Var.d(this.f7008b);
        b1Var.a(this.f7010d);
        b1Var.c(String.valueOf(this.f7011e));
        if ("oper".equals(this.f7008b) && z.i(this.f7007a, "oper")) {
            p0 p0VarA = y.a().a(this.f7007a, this.f7011e);
            String strA = p0VarA.a();
            Boolean boolValueOf = Boolean.valueOf(p0VarA.b());
            b1Var.f(strA);
            b1Var.e(String.valueOf(boolValueOf));
        }
        String strReplace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.f7007a, this.f7008b, q0.g(), arrayList, strReplace).a();
    }
}
