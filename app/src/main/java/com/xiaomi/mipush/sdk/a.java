package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import java.util.HashSet;
import java.util.Set;

@TargetApi(14)
/* loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f12354a = new HashSet();

    public static void a(Context context) {
        a((Application) context.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.f12354a.contains(stringExtra)) {
                this.f12354a.add(stringExtra);
                if (intExtra == 3000) {
                    dt.a(activity.getApplicationContext()).a(activity.getPackageName(), ds.m357a(intExtra), stringExtra, 3008, null);
                } else if (intExtra == 1000) {
                    dt.a(activity.getApplicationContext()).a(activity.getPackageName(), ds.m357a(intExtra), stringExtra, 1008, null);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("An error occurred in onActivityResumed method: " + th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    private static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }
}
