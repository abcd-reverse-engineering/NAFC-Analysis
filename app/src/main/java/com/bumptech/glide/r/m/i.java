package com.bumptech.glide.r.m;

import com.bumptech.glide.r.m.j;

/* compiled from: ViewPropertyAnimationFactory.java */
/* loaded from: classes.dex */
public class i<R> implements g<R> {

    /* renamed from: a, reason: collision with root package name */
    private final j.a f5342a;

    /* renamed from: b, reason: collision with root package name */
    private j<R> f5343b;

    public i(j.a aVar) {
        this.f5342a = aVar;
    }

    @Override // com.bumptech.glide.r.m.g
    public f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        if (aVar == com.bumptech.glide.load.a.MEMORY_CACHE || !z) {
            return e.a();
        }
        if (this.f5343b == null) {
            this.f5343b = new j<>(this.f5342a);
        }
        return this.f5343b;
    }
}
