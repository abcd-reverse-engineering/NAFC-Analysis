package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* loaded from: classes.dex */
public abstract class f1<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public n0<TResult> f6276a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6277b;

    /* renamed from: c, reason: collision with root package name */
    public final IMessageEntity f6278c;

    /* renamed from: d, reason: collision with root package name */
    public final w f6279d;

    /* renamed from: e, reason: collision with root package name */
    public RequestHeader f6280e;

    public f1(String str, IMessageEntity iMessageEntity) {
        this.f6277b = str;
        this.f6278c = iMessageEntity;
        this.f6279d = w.a(str);
    }

    public abstract void a(ApiException apiException, Object obj);

    public final void b(ApiException apiException, Object obj) {
        if (this.f6276a != null) {
            a(apiException, obj);
            return;
        }
        String str = "This Task has been canceled, uri:" + this.f6277b;
    }
}
