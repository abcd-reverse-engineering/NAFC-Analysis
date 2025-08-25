package com.bumptech.glide.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ManifestParser.java */
@Deprecated
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static final String f5192b = "ManifestParser";

    /* renamed from: c, reason: collision with root package name */
    private static final String f5193c = "GlideModule";

    /* renamed from: a, reason: collision with root package name */
    private final Context f5194a;

    public e(Context context) {
        this.f5194a = context;
    }

    public List<c> a() {
        Log.isLoggable(f5192b, 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f5194a.getPackageManager().getApplicationInfo(this.f5194a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable(f5192b, 3);
                return arrayList;
            }
            if (Log.isLoggable(f5192b, 2)) {
                String str = "Got app info metadata: " + applicationInfo.metaData;
            }
            for (String str2 : applicationInfo.metaData.keySet()) {
                if (f5193c.equals(applicationInfo.metaData.get(str2))) {
                    arrayList.add(a(str2));
                    if (Log.isLoggable(f5192b, 3)) {
                        String str3 = "Loaded Glide module: " + str2;
                    }
                }
            }
            Log.isLoggable(f5192b, 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }

    private static c a(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            Object objNewInstance = null;
            try {
                objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                a(cls, e2);
            } catch (InstantiationException e3) {
                a(cls, e3);
            } catch (NoSuchMethodException e4) {
                a(cls, e4);
            } catch (InvocationTargetException e5) {
                a(cls, e5);
            }
            if (objNewInstance instanceof c) {
                return (c) objNewInstance;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    private static void a(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
