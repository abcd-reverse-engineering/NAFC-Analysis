package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class m<A, B> {

    /* renamed from: b, reason: collision with root package name */
    private static final int f4740b = 250;

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.g<b<A>, B> f4741a;

    /* compiled from: ModelCache.java */
    class a extends com.bumptech.glide.util.g<b<A>, B> {
        a(long j2) {
            super(j2);
        }

        @Override // com.bumptech.glide.util.g
        protected /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable Object obj2) {
            a((b) obj, (b<A>) obj2);
        }

        protected void a(@NonNull b<A> bVar, @Nullable B b2) {
            bVar.a();
        }
    }

    public m() {
        this(250L);
    }

    @Nullable
    public B a(A a2, int i2, int i3) {
        b<A> bVarA = b.a(a2, i2, i3);
        B b2 = this.f4741a.b(bVarA);
        bVarA.a();
        return b2;
    }

    public m(long j2) {
        this.f4741a = new a(j2);
    }

    public void a(A a2, int i2, int i3, B b2) {
        this.f4741a.b(b.a(a2, i2, i3), b2);
    }

    /* compiled from: ModelCache.java */
    @VisibleForTesting
    static final class b<A> {

        /* renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f4743d = com.bumptech.glide.util.l.a(0);

        /* renamed from: a, reason: collision with root package name */
        private int f4744a;

        /* renamed from: b, reason: collision with root package name */
        private int f4745b;

        /* renamed from: c, reason: collision with root package name */
        private A f4746c;

        private b() {
        }

        static <A> b<A> a(A a2, int i2, int i3) {
            b<A> bVar;
            synchronized (f4743d) {
                bVar = (b) f4743d.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a2, i2, i3);
            return bVar;
        }

        private void b(A a2, int i2, int i3) {
            this.f4746c = a2;
            this.f4745b = i2;
            this.f4744a = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f4745b == bVar.f4745b && this.f4744a == bVar.f4744a && this.f4746c.equals(bVar.f4746c);
        }

        public int hashCode() {
            return (((this.f4744a * 31) + this.f4745b) * 31) + this.f4746c.hashCode();
        }

        public void a() {
            synchronized (f4743d) {
                f4743d.offer(this);
            }
        }
    }

    public void a() {
        this.f4741a.a();
    }
}
