package com.airbnb.lottie.b0;

import com.airbnb.lottie.m;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LogcatLogger.java */
/* loaded from: classes.dex */
public class c implements m {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f3428a = new HashSet();

    @Override // com.airbnb.lottie.m
    public void a(String str) {
        c(str, null);
    }

    @Override // com.airbnb.lottie.m
    public void b(String str) {
        b(str, null);
    }

    @Override // com.airbnb.lottie.m
    public void c(String str, Throwable th) {
        boolean z = com.airbnb.lottie.e.f3479a;
    }

    @Override // com.airbnb.lottie.m
    public void a(String str, Throwable th) {
        boolean z = com.airbnb.lottie.e.f3479a;
    }

    @Override // com.airbnb.lottie.m
    public void b(String str, Throwable th) {
        if (f3428a.contains(str)) {
            return;
        }
        f3428a.add(str);
    }
}
