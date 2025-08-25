package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.message.common.UPLog;

/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private static Application f11460a;

    public static void a(Context context) {
        if (f11460a != null || context == null) {
            return;
        }
        f11460a = (Application) context.getApplicationContext();
    }

    public static Application a() {
        Application application = f11460a;
        if (application != null) {
            return application;
        }
        try {
            Context appContext = UMGlobalContext.getAppContext();
            if (appContext != null) {
                Application application2 = (Application) appContext.getApplicationContext();
                f11460a = application2;
                if (application2 != null) {
                    return f11460a;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Application application3 = (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]), new Object[0]);
            f11460a = application3;
            if (application3 != null) {
                return f11460a;
            }
        } catch (Exception unused2) {
        }
        UPLog.e("Core", "context null! make sure PushAgent.setup(...) be called in Application.onCreate().");
        throw new IllegalStateException("context null! make sure PushAgent.setup(...) be called in Application.onCreate().");
    }
}
