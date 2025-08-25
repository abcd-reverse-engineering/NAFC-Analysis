package com.bumptech.glide.util.n;

import androidx.annotation.NonNull;

/* compiled from: StateVerifier.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f5401a = false;

    @NonNull
    public static c b() {
        return new C0081c();
    }

    public abstract void a();

    abstract void a(boolean z);

    /* compiled from: StateVerifier.java */
    private static class b extends c {

        /* renamed from: b, reason: collision with root package name */
        private volatile RuntimeException f5402b;

        b() {
            super();
        }

        @Override // com.bumptech.glide.util.n.c
        public void a() {
            if (this.f5402b != null) {
                throw new IllegalStateException("Already released", this.f5402b);
            }
        }

        @Override // com.bumptech.glide.util.n.c
        void a(boolean z) {
            if (z) {
                this.f5402b = new RuntimeException("Released");
            } else {
                this.f5402b = null;
            }
        }
    }

    /* compiled from: StateVerifier.java */
    /* renamed from: com.bumptech.glide.util.n.c$c, reason: collision with other inner class name */
    private static class C0081c extends c {

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f5403b;

        C0081c() {
            super();
        }

        @Override // com.bumptech.glide.util.n.c
        public void a() {
            if (this.f5403b) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.n.c
        public void a(boolean z) {
            this.f5403b = z;
        }
    }

    private c() {
    }
}
