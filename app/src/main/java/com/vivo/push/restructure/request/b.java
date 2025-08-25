package com.vivo.push.restructure.request;

import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.u;

/* compiled from: CommandRequest.java */
/* loaded from: classes2.dex */
public final class b<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private a<I, O> f12196a;

    /* renamed from: b, reason: collision with root package name */
    private c<O> f12197b;

    /* renamed from: c, reason: collision with root package name */
    private long f12198c;

    private b(a<I, O> aVar) {
        this.f12198c = com.heytap.mcssdk.constant.a.r;
        this.f12196a = aVar;
        if (this.f12196a == null) {
            u.a(JosStatusCodes.RTN_CODE_PARAMS_ERROR, "Command object is null, please construct command first");
        }
    }

    public final a a() {
        return this.f12196a;
    }

    public final c b() {
        return this.f12197b;
    }

    public final long c() {
        return this.f12198c;
    }

    private b(a<I, O> aVar, c<O> cVar) {
        this(aVar);
        this.f12197b = cVar;
    }

    public b(a<I, O> aVar, c<O> cVar, byte b2) {
        this(aVar, cVar);
        this.f12198c = 20000L;
    }
}
