package com.hihonor.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class m implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f6307a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f6308b;

    public m(s sVar, boolean z) {
        this.f6308b = sVar;
        this.f6307a = z;
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        this.f6308b.f6325b.getClass();
        try {
            e1 e1Var = new e1(UpMsgType.REQUEST_PUSH_TOKEN, null);
            e1Var.f6280e = b.a();
            String pushToken = ((PushTokenResult) b.a(z.f6357c.a(e1Var))).getPushToken();
            if (this.f6307a) {
                s sVar = this.f6308b;
                sVar.getClass();
                if (!TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("event_type", DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    g0 g0Var = new g0();
                    Context context = sVar.f6324a;
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        g0Var.f6285c = applicationContext;
                        g0Var.f6284b = bundle;
                        applicationContext.bindService(intent, g0Var, 1);
                    } catch (Exception e2) {
                        String str = "bind service failed." + e2.getMessage();
                    }
                }
            }
            return pushToken;
        } catch (Exception e3) {
            throw b.a(e3);
        }
    }
}
