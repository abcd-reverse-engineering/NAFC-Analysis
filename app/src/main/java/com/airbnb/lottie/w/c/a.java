package com.airbnb.lottie.w.c;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class a<K, A> {

    /* renamed from: c, reason: collision with root package name */
    private final d<K> f3746c;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    protected com.airbnb.lottie.c0.j<A> f3748e;

    /* renamed from: a, reason: collision with root package name */
    final List<b> f3744a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    private boolean f3745b = false;

    /* renamed from: d, reason: collision with root package name */
    protected float f3747d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private A f3749f = null;

    /* renamed from: g, reason: collision with root package name */
    private float f3750g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f3751h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    public interface b {
        void a();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    private static final class c<T> implements d<T> {
        private c() {
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public com.airbnb.lottie.c0.a<T> a() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float b() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean b(float f2) {
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float c() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean a(float f2) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    private interface d<T> {
        com.airbnb.lottie.c0.a<T> a();

        boolean a(float f2);

        @FloatRange(from = 0.0d, to = 1.0d)
        float b();

        boolean b(float f2);

        @FloatRange(from = 0.0d, to = 1.0d)
        float c();

        boolean isEmpty();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    private static final class e<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        private final List<? extends com.airbnb.lottie.c0.a<T>> f3752a;

        /* renamed from: c, reason: collision with root package name */
        private com.airbnb.lottie.c0.a<T> f3754c = null;

        /* renamed from: d, reason: collision with root package name */
        private float f3755d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private com.airbnb.lottie.c0.a<T> f3753b = c(0.0f);

        e(List<? extends com.airbnb.lottie.c0.a<T>> list) {
            this.f3752a = list;
        }

        private com.airbnb.lottie.c0.a<T> c(float f2) {
            List<? extends com.airbnb.lottie.c0.a<T>> list = this.f3752a;
            com.airbnb.lottie.c0.a<T> aVar = list.get(list.size() - 1);
            if (f2 >= aVar.d()) {
                return aVar;
            }
            for (int size = this.f3752a.size() - 2; size >= 1; size--) {
                com.airbnb.lottie.c0.a<T> aVar2 = this.f3752a.get(size);
                if (this.f3753b != aVar2 && aVar2.a(f2)) {
                    return aVar2;
                }
            }
            return this.f3752a.get(0);
        }

        @Override // com.airbnb.lottie.w.c.a.d
        @NonNull
        public com.airbnb.lottie.c0.a<T> a() {
            return this.f3753b;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean b(float f2) {
            if (this.f3753b.a(f2)) {
                return !this.f3753b.g();
            }
            this.f3753b = c(f2);
            return true;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean a(float f2) {
            if (this.f3754c == this.f3753b && this.f3755d == f2) {
                return true;
            }
            this.f3754c = this.f3753b;
            this.f3755d = f2;
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float b() {
            return this.f3752a.get(r0.size() - 1).a();
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float c() {
            return this.f3752a.get(0).d();
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    private static final class f<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final com.airbnb.lottie.c0.a<T> f3756a;

        /* renamed from: b, reason: collision with root package name */
        private float f3757b = -1.0f;

        f(List<? extends com.airbnb.lottie.c0.a<T>> list) {
            this.f3756a = list.get(0);
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public com.airbnb.lottie.c0.a<T> a() {
            return this.f3756a;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean b(float f2) {
            return !this.f3756a.g();
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float c() {
            return this.f3756a.d();
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean a(float f2) {
            if (this.f3757b == f2) {
                return true;
            }
            this.f3757b = f2;
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float b() {
            return this.f3756a.a();
        }
    }

    a(List<? extends com.airbnb.lottie.c0.a<K>> list) {
        this.f3746c = a(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float i() {
        if (this.f3750g == -1.0f) {
            this.f3750g = this.f3746c.c();
        }
        return this.f3750g;
    }

    abstract A a(com.airbnb.lottie.c0.a<K> aVar, float f2);

    public void a(b bVar) {
        this.f3744a.add(bVar);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float b() {
        if (this.f3751h == -1.0f) {
            this.f3751h = this.f3746c.b();
        }
        return this.f3751h;
    }

    protected float c() {
        com.airbnb.lottie.c0.a<K> aVarA = a();
        if (aVarA.g()) {
            return 0.0f;
        }
        return aVarA.f3452d.getInterpolation(d());
    }

    float d() {
        if (this.f3745b) {
            return 0.0f;
        }
        com.airbnb.lottie.c0.a<K> aVarA = a();
        if (aVarA.g()) {
            return 0.0f;
        }
        return (this.f3747d - aVarA.d()) / (aVarA.a() - aVarA.d());
    }

    public float e() {
        return this.f3747d;
    }

    public A f() {
        float fD = d();
        if (this.f3748e == null && this.f3746c.a(fD)) {
            return this.f3749f;
        }
        com.airbnb.lottie.c0.a<K> aVarA = a();
        Interpolator interpolator = aVarA.f3453e;
        A a2 = (interpolator == null || aVarA.f3454f == null) ? a(aVarA, c()) : a(aVarA, fD, interpolator.getInterpolation(fD), aVarA.f3454f.getInterpolation(fD));
        this.f3749f = a2;
        return a2;
    }

    public void g() {
        for (int i2 = 0; i2 < this.f3744a.size(); i2++) {
            this.f3744a.get(i2).a();
        }
    }

    public void h() {
        this.f3745b = true;
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f3746c.isEmpty()) {
            return;
        }
        if (f2 < i()) {
            f2 = i();
        } else if (f2 > b()) {
            f2 = b();
        }
        if (f2 == this.f3747d) {
            return;
        }
        this.f3747d = f2;
        if (this.f3746c.b(f2)) {
            g();
        }
    }

    protected com.airbnb.lottie.c0.a<K> a() {
        com.airbnb.lottie.e.a("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.c0.a<K> aVarA = this.f3746c.a();
        com.airbnb.lottie.e.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarA;
    }

    public void a(@Nullable com.airbnb.lottie.c0.j<A> jVar) {
        com.airbnb.lottie.c0.j<A> jVar2 = this.f3748e;
        if (jVar2 != null) {
            jVar2.a((a<?, ?>) null);
        }
        this.f3748e = jVar;
        if (jVar != null) {
            jVar.a((a<?, ?>) this);
        }
    }

    protected A a(com.airbnb.lottie.c0.a<K> aVar, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> d<T> a(List<? extends com.airbnb.lottie.c0.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }
}
