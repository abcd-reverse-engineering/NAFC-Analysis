package com.hihonor.honorid;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ApplicationContext.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f6098c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, List<String>> f6099a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f6100b;

    private a() {
        new HashMap();
        new HashMap();
        new HashMap();
        new HashMap();
        this.f6100b = null;
    }

    public static synchronized a c() {
        if (f6098c == null) {
            f6098c = new a();
        }
        return f6098c;
    }

    public void a(Context context) {
        this.f6100b = new WeakReference<>(context);
    }

    public List<String> b() {
        return this.f6099a.get("packageNamesNotUseApk");
    }

    public Context a() {
        WeakReference<Context> weakReference = this.f6100b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f6100b.get();
    }

    public void a(List<String> list) {
        this.f6099a.put("packageNamesNotUseApk", list);
    }
}
