package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class q implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f6317a;

    public q(s sVar) {
        this.f6317a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f6317a.f6325b.a(false);
        return null;
    }
}
