package com.hihonor.push.sdk;

import java.util.List;

/* renamed from: com.hihonor.push.sdk.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0340r implements k0<List<HonorPushDataMsg>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6319a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f6320b;

    public C0340r(s sVar, HonorPushCallback honorPushCallback) {
        this.f6320b = sVar;
        this.f6319a = honorPushCallback;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1<List<HonorPushDataMsg>> a1Var) {
        if (!a1Var.e()) {
            s.a(this.f6320b, this.f6319a, -1, a1Var.b().toString());
            return;
        }
        s sVar = this.f6320b;
        HonorPushCallback honorPushCallback = this.f6319a;
        List<HonorPushDataMsg> listC = a1Var.c();
        sVar.getClass();
        b1.a(new t(sVar, honorPushCallback, listC));
    }
}
