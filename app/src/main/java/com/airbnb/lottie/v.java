package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TextDelegate.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3626a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final LottieAnimationView f3627b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final j f3628c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3629d;

    @VisibleForTesting
    v() {
        this.f3626a = new HashMap();
        this.f3629d = true;
        this.f3627b = null;
        this.f3628c = null;
    }

    public String a(String str) {
        return str;
    }

    public void a(String str, String str2) {
        this.f3626a.put(str, str2);
        b();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String b(String str) {
        if (this.f3629d && this.f3626a.containsKey(str)) {
            return this.f3626a.get(str);
        }
        String strA = a(str);
        if (this.f3629d) {
            this.f3626a.put(str, strA);
        }
        return strA;
    }

    public void c(String str) {
        this.f3626a.remove(str);
        b();
    }

    public void a(boolean z) {
        this.f3629d = z;
    }

    public void a() {
        this.f3626a.clear();
        b();
    }

    public v(LottieAnimationView lottieAnimationView) {
        this.f3626a = new HashMap();
        this.f3629d = true;
        this.f3627b = lottieAnimationView;
        this.f3628c = null;
    }

    private void b() {
        LottieAnimationView lottieAnimationView = this.f3627b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        j jVar = this.f3628c;
        if (jVar != null) {
            jVar.invalidateSelf();
        }
    }

    public v(j jVar) {
        this.f3626a = new HashMap();
        this.f3629d = true;
        this.f3628c = jVar;
        this.f3627b = null;
    }
}
