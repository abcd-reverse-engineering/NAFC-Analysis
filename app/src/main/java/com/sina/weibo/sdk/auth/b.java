package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    private Map<String, WbAuthListener> f8359e;

    static class a {

        /* renamed from: f, reason: collision with root package name */
        private static final b f8360f = new b(0);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    public static synchronized b b() {
        return a.f8360f;
    }

    public final synchronized void a(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.f8359e.put(str, wbAuthListener);
        }
    }

    private b() {
        this.f8359e = new HashMap();
    }

    public final synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8359e.remove(str);
    }

    public final synchronized WbAuthListener a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f8359e.get(str);
    }
}
