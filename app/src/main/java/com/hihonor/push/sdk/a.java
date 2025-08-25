package com.hihonor.push.sdk;

import org.json.JSONException;

/* loaded from: classes.dex */
public class a implements k0<HonorPushDataMsg> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorMessageService f6248a;

    public a(HonorMessageService honorMessageService) {
        this.f6248a = honorMessageService;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1<HonorPushDataMsg> a1Var) {
        if (!a1Var.e()) {
            boolean z = a1Var.b() instanceof JSONException;
            return;
        }
        HonorPushDataMsg honorPushDataMsgC = a1Var.c();
        if (honorPushDataMsgC != null) {
            String str = "onMessageReceived. msgId is " + honorPushDataMsgC.getMsgId();
            this.f6248a.onMessageReceived(honorPushDataMsgC);
        }
    }
}
