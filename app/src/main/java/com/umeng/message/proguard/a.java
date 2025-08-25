package com.umeng.message.proguard;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f11215b;

    /* renamed from: a, reason: collision with root package name */
    public Class<?> f11216a;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f11217c;

    /* renamed from: d, reason: collision with root package name */
    private Class<?> f11218d;

    /* renamed from: e, reason: collision with root package name */
    private Class<?> f11219e;

    private a() {
        Application applicationA = x.a();
        String resourcePackageName = PushAgent.getInstance(applicationA).getResourcePackageName();
        resourcePackageName = TextUtils.isEmpty(resourcePackageName) ? applicationA.getPackageName() : resourcePackageName;
        UPLog.d("R2", "resPackageName:", resourcePackageName);
        try {
            this.f11218d = Class.forName(resourcePackageName + ".R$drawable");
        } catch (ClassNotFoundException e2) {
            UPLog.d("R2", UPLog.getStackTrace(e2));
            UMLog.aq(ab.f11221b, 0, "\\|");
        }
        try {
            this.f11216a = Class.forName(resourcePackageName + ".R$layout");
        } catch (ClassNotFoundException e3) {
            UPLog.d("R2", UPLog.getStackTrace(e3));
        }
        try {
            this.f11217c = Class.forName(resourcePackageName + ".R$id");
        } catch (ClassNotFoundException e4) {
            UPLog.d("R2", UPLog.getStackTrace(e4));
        }
        try {
            this.f11219e = Class.forName(resourcePackageName + ".R$raw");
        } catch (ClassNotFoundException e5) {
            UPLog.d("R2", UPLog.getStackTrace(e5));
        }
    }

    public static int a(String str) {
        return a(a().f11217c, str);
    }

    public final int b(String str) {
        return a(this.f11218d, str);
    }

    public final int c(String str) {
        return a(this.f11219e, str);
    }

    public static a a() {
        if (f11215b == null) {
            f11215b = new a();
        }
        return f11215b;
    }

    public static int a(Class<?> cls, String str) {
        if (cls != null) {
            return cls.getField(str).getInt(str);
        }
        UPLog.e("R2", "getRes(null,", str, ")");
        throw new Resources.NotFoundException(x.a().getPackageName() + ".R$* field=" + str + " not exist.");
    }
}
