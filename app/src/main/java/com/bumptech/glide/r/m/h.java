package com.bumptech.glide.r.m;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.r.m.k;

/* compiled from: ViewAnimationFactory.java */
/* loaded from: classes.dex */
public class h<R> implements g<R> {

    /* renamed from: a, reason: collision with root package name */
    private final k.a f5338a;

    /* renamed from: b, reason: collision with root package name */
    private f<R> f5339b;

    /* compiled from: ViewAnimationFactory.java */
    private static class a implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private final Animation f5340a;

        a(Animation animation) {
            this.f5340a = animation;
        }

        @Override // com.bumptech.glide.r.m.k.a
        public Animation a(Context context) {
            return this.f5340a;
        }
    }

    /* compiled from: ViewAnimationFactory.java */
    private static class b implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private final int f5341a;

        b(int i2) {
            this.f5341a = i2;
        }

        @Override // com.bumptech.glide.r.m.k.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f5341a);
        }
    }

    public h(Animation animation) {
        this(new a(animation));
    }

    @Override // com.bumptech.glide.r.m.g
    public f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        if (aVar == com.bumptech.glide.load.a.MEMORY_CACHE || !z) {
            return e.a();
        }
        if (this.f5339b == null) {
            this.f5339b = new k(this.f5338a);
        }
        return this.f5339b;
    }

    public h(int i2) {
        this(new b(i2));
    }

    h(k.a aVar) {
        this.f5338a = aVar;
    }
}
