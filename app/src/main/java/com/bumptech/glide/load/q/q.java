package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: MultiModelLoader.java */
/* loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n<Model, Data>> f4754a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f4755b;

    q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f4754a = list;
        this.f4755b = pool;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        n.a<Data> aVarA;
        int size = this.f4754a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.g gVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n<Model, Data> nVar = this.f4754a.get(i4);
            if (nVar.a(model) && (aVarA = nVar.a(model, i2, i3, jVar)) != null) {
                gVar = aVarA.f4747a;
                arrayList.add(aVarA.f4749c);
            }
        }
        if (arrayList.isEmpty() || gVar == null) {
            return null;
        }
        return new n.a<>(gVar, new a(arrayList, this.f4755b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f4754a.toArray()) + '}';
    }

    /* compiled from: MultiModelLoader.java */
    static class a<Data> implements com.bumptech.glide.load.o.d<Data>, d.a<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.bumptech.glide.load.o.d<Data>> f4756a;

        /* renamed from: b, reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f4757b;

        /* renamed from: c, reason: collision with root package name */
        private int f4758c;

        /* renamed from: d, reason: collision with root package name */
        private com.bumptech.glide.h f4759d;

        /* renamed from: e, reason: collision with root package name */
        private d.a<? super Data> f4760e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private List<Throwable> f4761f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f4762g;

        a(@NonNull List<com.bumptech.glide.load.o.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f4757b = pool;
            com.bumptech.glide.util.j.a(list);
            this.f4756a = list;
            this.f4758c = 0;
        }

        private void d() {
            if (this.f4762g) {
                return;
            }
            if (this.f4758c < this.f4756a.size() - 1) {
                this.f4758c++;
                a(this.f4759d, this.f4760e);
            } else {
                com.bumptech.glide.util.j.a(this.f4761f);
                this.f4760e.a((Exception) new com.bumptech.glide.load.p.q("Fetch failed", new ArrayList(this.f4761f)));
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Data> aVar) {
            this.f4759d = hVar;
            this.f4760e = aVar;
            this.f4761f = this.f4757b.acquire();
            this.f4756a.get(this.f4758c).a(hVar, this);
            if (this.f4762g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
            List<Throwable> list = this.f4761f;
            if (list != null) {
                this.f4757b.release(list);
            }
            this.f4761f = null;
            Iterator<com.bumptech.glide.load.o.d<Data>> it = this.f4756a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return this.f4756a.get(0).c();
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
            this.f4762g = true;
            Iterator<com.bumptech.glide.load.o.d<Data>> it = this.f4756a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<Data> a() {
            return this.f4756a.get(0).a();
        }

        @Override // com.bumptech.glide.load.o.d.a
        public void a(@Nullable Data data) {
            if (data != null) {
                this.f4760e.a((d.a<? super Data>) data);
            } else {
                d();
            }
        }

        @Override // com.bumptech.glide.load.o.d.a
        public void a(@NonNull Exception exc) {
            ((List) com.bumptech.glide.util.j.a(this.f4761f)).add(exc);
            d();
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Model model) {
        Iterator<n<Model, Data>> it = this.f4754a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }
}
