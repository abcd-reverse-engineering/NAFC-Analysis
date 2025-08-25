package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.m;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.aa;
import com.vivo.push.util.u;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BasePushMessageReceiver extends BroadcastReceiver implements PushMessageCallback {
    public static final String TAG = "PushMessageReceiver";

    @Override // com.vivo.push.sdk.PushMessageCallback
    public boolean isAllowNet(Context context) {
        if (context == null) {
            u.a(TAG, "isAllowNet sContext is null");
            return false;
        }
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            u.a(TAG, "isAllowNet pkgName is null");
            return false;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(packageName);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
            return aa.a(context, packageName);
        }
        u.a(TAG, "this is client sdk");
        return true;
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onBind(Context context, int i2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onListTags(Context context, int i2, List<String> list, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onLog(Context context, String str, int i2, boolean z) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onPublish(Context context, int i2, String str) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        m.a().a(context2);
        u.d(TAG, "PushMessageReceiver " + context2.getPackageName() + " ; requestId = " + intent.getStringExtra("req_id"));
        try {
            m.a().a(intent, this);
        } catch (Exception e2) {
            u.d(TAG, "onReceive doReceiveCommand erroe" + e2.getMessage());
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onUnBind(Context context, int i2, String str) {
    }
}
