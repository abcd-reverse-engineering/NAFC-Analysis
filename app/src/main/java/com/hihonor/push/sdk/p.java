package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class p implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f6315a;

    public p(s sVar) {
        this.f6315a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f6315a.f6325b.a(true);
        return null;
    }
}
