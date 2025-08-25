package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes2.dex */
public class CacheApi {

    /* renamed from: a, reason: collision with root package name */
    private static String f11767a = "CacheApi";

    /* renamed from: e, reason: collision with root package name */
    private static CacheApi f11768e;

    /* renamed from: b, reason: collision with root package name */
    private Handler f11769b;

    /* renamed from: c, reason: collision with root package name */
    private CacheExector f11770c = new CacheExector(a());

    /* renamed from: d, reason: collision with root package name */
    private Context f11771d;

    private CacheApi(Context context) {
        this.f11771d = context;
    }

    private String a() {
        Context context = this.f11771d;
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getPath();
    }

    public static CacheApi get(Context context) {
        if (f11768e == null) {
            f11768e = new CacheApi(context);
        }
        return f11768e;
    }

    public double checkSize(String str) {
        CacheExector cacheExector = this.f11770c;
        if (cacheExector == null) {
            return 0.0d;
        }
        return cacheExector.checkSize(str);
    }

    public boolean delete(String str) {
        CacheExector cacheExector = this.f11770c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.deleteFile(str);
    }

    public IReader read(String str, Class cls) {
        CacheExector cacheExector = this.f11770c;
        if (cacheExector == null) {
            return null;
        }
        return cacheExector.readFile(str, cls);
    }

    public boolean save(String str, String str2) {
        CacheExector cacheExector = this.f11770c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.save(str, str2);
    }
}
