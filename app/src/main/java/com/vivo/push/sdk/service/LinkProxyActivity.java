package com.vivo.push.sdk.service;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.vivo.push.util.ag;
import com.vivo.push.util.u;
import java.util.List;

/* loaded from: classes2.dex */
public class LinkProxyActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PackageManager packageManager;
        List<ResolveInfo> listQueryIntentServices;
        ResolveInfo resolveInfo;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            u.d("LinkProxyActivity", "enter RequestPermissionsActivity onCreate, intent is null, finish");
            finish();
            return;
        }
        boolean z = false;
        try {
            Window window = getWindow();
            window.setGravity(8388659);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
        } catch (Throwable th) {
            u.b("LinkProxyActivity", "enter onCreate error ", th);
        }
        String packageName = getPackageName();
        u.d("LinkProxyActivity", hashCode() + " enter onCreate " + packageName);
        if ("com.vivo.abe".equals(packageName)) {
            try {
                if (intent == null) {
                    u.d("LinkProxyActivity", "adapterToService intent is null");
                } else if (intent.getExtras() == null) {
                    u.d("LinkProxyActivity", "adapterToService getExtras() is null");
                } else {
                    Intent intent2 = (Intent) intent.getExtras().get("previous_intent");
                    if (intent2 == null) {
                        u.d("LinkProxyActivity", "adapterToService proxyIntent is null");
                    } else {
                        ag.a(this, intent2);
                    }
                }
            } catch (Exception e2) {
                u.a("LinkProxyActivity", e2.toString(), e2);
            }
        } else {
            try {
                if (intent.getExtras() != null) {
                    Intent intent3 = (Intent) intent.getExtras().get("previous_intent");
                    if (intent3 != null && (packageManager = getPackageManager()) != null && (listQueryIntentServices = packageManager.queryIntentServices(intent3, 576)) != null && !listQueryIntentServices.isEmpty() && (resolveInfo = listQueryIntentServices.get(0)) != null && resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.exported) {
                        z = true;
                    }
                    if (z) {
                        startService(intent3);
                    } else {
                        u.b("LinkProxyActivity", "service's exported is ".concat(String.valueOf(z)));
                    }
                }
            } catch (Exception e3) {
                u.a("LinkProxyActivity", e3.toString(), e3);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        u.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
