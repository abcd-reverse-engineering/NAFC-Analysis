package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.u;

/* compiled from: NodeReportItem.java */
/* loaded from: classes2.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private String f12160a;

    /* renamed from: b, reason: collision with root package name */
    private String f12161b;

    public m(com.vivo.push.restructure.a.a aVar, String str) {
        if (aVar != null) {
            this.f12160a = aVar.a();
        }
        this.f12161b = str;
    }

    public final com.vivo.push.b.h a() {
        if (!TextUtils.isEmpty(this.f12160a) && !TextUtils.isEmpty(this.f12161b)) {
            return new com.vivo.push.b.h(this.f12160a, this.f12161b);
        }
        u.a("convertOffLineMsg() error, mMessageID = " + this.f12160a + ", mNodeArrayInfo = " + this.f12161b);
        return null;
    }
}
